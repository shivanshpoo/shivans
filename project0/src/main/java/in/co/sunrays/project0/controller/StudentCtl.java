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

import in.co.sunrays.project0.dto.StudentDTO;
import in.co.sunrays.project0.dto.UserDTO;
import in.co.sunrays.project0.exception.ApplicationException;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.form.StudentForm;
import in.co.sunrays.project0.service.CollegeServiceInt;
import in.co.sunrays.project0.service.StudentServiceInt;
import in.co.sunrays.project0.validator.StudentValidator;

@Controller
@RequestMapping(value="/ctl/Student")
public class StudentCtl extends BaseCtl {

private static Logger log = Logger.getLogger(StudentCtl.class);
	
	@Autowired
	private StudentServiceInt service;
	
	@Autowired
	private CollegeServiceInt collegeService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private StudentValidator validator;
	
	@Override
	public void preload(Model model) {
		log.debug("StudentCtl preload method started");
		model.addAttribute("collegeList",collegeService.search(null));
		log.debug("StudentCtl preload method ended");
	}
	
	/**
     * Display Student View
     * param id:
     * 				Primary Key
     * param form:
     * 				Object of StudentForm
     * param model:
     * 				Object of Model Interface
     * return Student:
     * 					View of Student Form
     */
	@RequestMapping(value="/Student",method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") StudentForm form, Model model,Locale locale) {
		 
		log.debug("StudentCtl display method to display StudentForm started");
		if(id!=null && id>0){
			form.populate(service.findByPK(id));
		}
		log.debug("StudentCtl display method to display StudentForm ended");
		return "Student";
	}
	
	/**
     * Submit Student View
     * 
     * param operation:
     * 					Operation given by User
     * param form:
     * 				Object of StudentForm
     * param bindingResult:
     * 						Object of BindingResult
     * param model:
     * 					Object of Model Interface
     * param session:
     * 					Object of HttpSession
     * param locale:
     * 					Object of Locale
     * return Student:
     * 					View of StudentForm
	 * @throws ApplicationException 
	 * @throws DuplicateRecordException 
     */
	@RequestMapping(value="/Student", method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") @Valid StudentForm form, BindingResult bindingResult, Model model, HttpSession session, Locale locale) throws DuplicateRecordException, ApplicationException {
		log.debug("StudentCtl submit method to submit StudentForm started");
		
		validator.validate(form, bindingResult);
		
		if(OP_SAVE.equalsIgnoreCase(operation)) {
		
			if(bindingResult.hasErrors()) {
				return "Student";
			}
			
			StudentDTO dto = (StudentDTO) form.getDto();
			
			
			if(dto.getId()>0) {
				service.update(dto);
			 	String msg=messageSource.getMessage("message.updatesuccess",null,locale);
			 	model.addAttribute("success",msg);    
			 	model.addAttribute("id",dto.getId());
			 	return "Student";
			}else {
				UserDTO userDto = (UserDTO) session.getAttribute("user");
			 	dto.setCreatedBy(userDto.getLogin());
			 	dto.setModifiedBy(userDto.getLogin());
			 	service.add(dto);	 
			 	String msg=messageSource.getMessage("message.success",null,locale);
			 	model.addAttribute("success",msg);
			 	//form.populate(new StudentDTO());
			}
		}else if(OP_RESET.equalsIgnoreCase(operation)) {
			
			System.out.println("inside reset of student ctl dopost");
			return "redirect:/ctl/Student/Student";
		}else if(OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Student/Search";
		}
		log.debug("StudentCtl submit method to submit StudentForm ended");
		return "Student";
	}

	/**
     * Display StudentList View
     * 
     * param form:
     * 				Object of StudentForm
     * param model:
     * 				Object of Model Interface
     * return StudentList:
     * 						View of StudentList
     */
	@RequestMapping(value="/Search", method=RequestMethod.GET)
	public String display(@ModelAttribute("form") StudentForm form, Model model,Locale locale) {
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		log.debug("StudentCtl display method to display StudentList started");
		model.addAttribute("list",service.search(new StudentDTO(), form.getPageNo(),form.getPageSize()));
		int pageNo = 1;
		List next = service.search(new StudentDTO(), pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
        model.addAttribute("findList",service.search(null));
        
    	model.addAttribute("collegeList",collegeService.search(null,form.getPageNo(),form.getPageSize()));
        
		log.debug("StudentCtl display method to display StudentList ended");
		return "StudentList";
	}

	/**
     * Submit StudentList 
     * 
     * param operation:
     * 					Operation given by User
     * param form:
     * 				Object of StudentForm
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 				Object of Locale
     * return StudentList:
     * 						View of Student List
     */
	@RequestMapping(value="/Search",method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") StudentForm form, Model model, Locale locale) {
		log.debug("StudentCtl submit method to submit StudentList started");
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		model.addAttribute("findList",service.search(null));
		int pageNo=form.getPageNo();
		if(OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		}else if(OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		}else if(OP_DELETE.equalsIgnoreCase(operation)) {
			if(form.getChk_1()!=null) {
				for (long id : form.getChk_1()) {
 					service.delete(id);
 				}
 				String msg = messageSource.getMessage("message.deleterecord", null, locale);
 				model.addAttribute("success", msg);
			}else {
				String msg = messageSource.getMessage("message.atleastone", null, locale);
 				model.addAttribute("error", msg);
			}
		}
		pageNo=(pageNo<1)?1:pageNo;
	    form.setPageNo(pageNo);
	    StudentDTO dto=(StudentDTO) form.getDto();
	    List list=service.search(dto, pageNo, form.getPageSize());
	 	model.addAttribute("list",list);
		List next = service.search(dto, pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
	 	
	 	if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation)){
	 		model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
	 	}
	     
	    if(OP_RESET.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Student/Search";
	    }else if(OP_NEW.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Student/Student";
	    }else if(OP_BACK.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Student/Search";
	    }
		log.debug("StudentCtl submit method to submit StudentList ended");
		return "StudentList"; 
	}


	



}
