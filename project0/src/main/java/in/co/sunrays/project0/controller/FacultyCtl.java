package in.co.sunrays.project0.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.sunrays.project0.dto.FacultyDTO;
import in.co.sunrays.project0.dto.UserDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.form.FacultyForm;
import in.co.sunrays.project0.service.CollegeServiceInt;
import in.co.sunrays.project0.service.CourseServiceInt;
import in.co.sunrays.project0.service.FacultyServiceInt;
import in.co.sunrays.project0.service.SubjectServiceInt;
import in.co.sunrays.project0.validator.FacultyValidator;

@Controller
@RequestMapping(value="/ctl/Faculty")
public class FacultyCtl extends BaseCtl {


private static Logger log = Logger.getLogger(FacultyCtl.class);
	
	@Autowired
	private FacultyServiceInt service;
	
	@Autowired
	private CollegeServiceInt collegeService;
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private FacultyValidator validator;

	
	
	@Override
	public void preload(Model model) {
		log.debug("FacultyCtl preload method started");
		model.addAttribute("collegeList",collegeService.search(null));
    	model.addAttribute("courseList",courseService.search(null));
    	model.addAttribute("subjectList",subjectService.search(null));
		log.debug("FacultyCtl preload method ended");
	}
	
	/**
     * Display Faculty view.
     * 
     * param id:
     * 				Primary Key
     * param form:
     * 				Object of FacultyForm
     * param model:
     * 				Object of Model Interface
     * return Faculty:
     * 					View of Faculty Form
     */
	@RequestMapping(value="/Faculty", method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") FacultyForm form, Model model,Locale locale) {
		log.debug("FacultyCtl display method to display FacultyForm strated");
	    if(id!=null && id>0) {
			form.populate(service.findByPK(id));
		}
		log.debug("FacultyCtl display method to display FacultyForm ended");
		return "Faculty";
	}
	
	/**
     * Submit Faculty view.
     *param operation:
     *					Operation given by user
     * param form:
     * 				Object of FacultyForm
     * param bindingResult:
     * 						Object of BindingResult
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 					Object of Locale
     * param session:
     * 					Object of HttpSession
     * return Faculty:
     * 					View of faculty Form
	 * @throws DuplicateRecordException 
     */
	@RequestMapping(value="/Faculty", method=RequestMethod.POST)
	public String submit(@RequestParam String operation, @ModelAttribute("form") @Valid FacultyForm form, BindingResult bindingResult, Model model, Locale locale, HttpSession session) throws DuplicateRecordException {
		log.debug("FacultyCtl submit method to submit FacultyForm started");
		
		validator.validate(form, bindingResult);
		
		UserDTO userDto = (UserDTO) session.getAttribute("user");
		
		if(OP_SAVE.equalsIgnoreCase(operation)) {
			
			if(bindingResult.hasErrors()) {
				return "Faculty";
			}
			
			FacultyDTO dto=(FacultyDTO) form.getDto();	
			if(dto.getId()>0) {
				dto.setModifiedBy(userDto.getLogin());
				service.update(dto);
				String msg=messageSource.getMessage("message.updatesuccess",null,locale);
			    model.addAttribute("success",msg);
			    model.addAttribute("id",dto.getId());
			}else {
				dto.setCreatedBy(userDto.getLogin());
				dto.setModifiedBy(userDto.getLogin());
				service.add(dto);
				String msg=messageSource.getMessage("message.success",null,locale);
				model.addAttribute("success", msg);
				//form.populate(new FacultyDTO());
			}
		}else if(OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Faculty/Faculty";
		}else if(OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Faculty/Search";
		}
		log.debug("FacultyCtl submit method to submit FacultyForm ended");
		return "Faculty";
	}
	
	/**
     * Displays Faculty List.
     * 
     * param form:
     * 				Object of FacultyForm
     * param model:
     * 				Object of Model Interface
     * return FacultyList:
     * 						View of FacultyList
     */
	@RequestMapping(value="/Search",method=RequestMethod.GET)
	public String display(@ModelAttribute("form") FacultyForm form, Model model) {
		log.debug("FacultyCtl display method to display FacultyList started");
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
		int pageNo = 1;
		List next = service.search(new FacultyDTO(), pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
		
		model.addAttribute("courseList",courseService.search(null,form.getPageNo(),form.getPageSize()));
		
		model.addAttribute("subjectList",subjectService.search(null,form.getPageNo(),form.getPageSize()));
		
		model.addAttribute("collegeList",collegeService.search(null,form.getPageNo(),form.getPageSize()));
		
		log.debug("FacultyCtl display method to display FacultyList ended");
		return "FacultyList";
	}
	
	/**
     * Submit Faculty List.
     * param operation:
     * 					Operation given by User
     * param form:
     * 				Object of FacultyForm
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 					Object of Locale
     * return FacultyList:
     * 						View of FacultyList
     */
	@RequestMapping(value="/Search", method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") FacultyForm form, Model model, Locale locale) {
		log.debug("FacultyCtl submit method to submit FacultyList started");
	    int pageNo=form.getPageNo();
	    if(OP_PREVIOUS.equalsIgnoreCase(operation)) {
	    	pageNo--;
	    }else if(OP_NEXT.equalsIgnoreCase(operation)) {
	    	pageNo++;
	    }else if(OP_DELETE.equalsIgnoreCase(operation)) {
	    	if(form.getChk_1()!=null) {
	    		for(long id:form.getChk_1()){
	    			service.delete(id);
	    		}
	    		String msg = messageSource.getMessage("message.deleterecord", null, locale);
	    		model.addAttribute("success", msg);
	    	}else {
	    		String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error1", msg);
	    	}
	    }
	    pageNo=(pageNo<1)?1:pageNo;
	    form.setPageNo(pageNo);
	    FacultyDTO dto=(FacultyDTO) form.getDto();
	    List list=service.search(dto, pageNo, form.getPageSize());
	    model.addAttribute("list", list);
		List next = service.search(dto, pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
	    if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation) ){
	    	model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
	  	}
	    if(OP_RESET.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Faculty/Search";
	    }else if(OP_NEW.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Faculty/Faculty";
	    }else if(OP_BACK.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Faculty/Search";
	    }
		log.debug("FacultyCtl submit method to submit FacultyList ended");
		return "FacultyList";
	}


}
