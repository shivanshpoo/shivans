package in.co.sunrays.project0.controller;

import java.util.LinkedHashMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.sunrays.project0.dto.TimetableDTO;
import in.co.sunrays.project0.dto.UserDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.form.TimetableForm;
import in.co.sunrays.project0.service.CourseServiceInt;
import in.co.sunrays.project0.service.SubjectServiceInt;
import in.co.sunrays.project0.service.TimetableServiceInt;
import in.co.sunrays.project0.validator.StudentValidator;
import in.co.sunrays.project0.validator.TimetableValidator;

@Controller
@RequestMapping(value="/ctl/Timetable")
public class TimetableCtl extends BaseCtl{


private static Logger log = Logger.getLogger(TimetableCtl.class);
	
	@Autowired
	private TimetableServiceInt service;
	
	@Autowired
	private TimetableValidator validator;
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@Override
	public void preload(Model model) {
		log.debug("TimetableCtl preload method started");
		model.addAttribute("courseList",courseService.search(null));
    	model.addAttribute("subjectList",subjectService.search(null));
		log.debug("TimetableCtl preload method ended");
	}
	
	/**
     * Displays Timetable View
     * param id:
     * 				Primary Key
     * param form:
     * 				Object of TimetableForm
     * param model:
     * 				Object of Model Interface
     * return Timetable:
     * 					View of Timetable Form
     */
	@RequestMapping(value="/Timetable", method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") TimetableForm form, Model model,Locale locale) {
		log.debug("TimetableCtl display method to display TimetableForm started");
		System.out.println("inside ctl-----------------");
		if(id!=null && id>0) {
			form.populate(service.findByPK(id));
		}
		log.debug("TimetableCtl display method to display TimetableForm ended");
		return "Timetable";
	}
	
	/**
     * Submit Timetable View
     * 
     * param operation:
     * 					Operation given By User
     * param form:
     * 				Object of TimetableForm
     * param bindingResult:
     * 						Object of BindingResult
     * param model:	
     * 				Object of Model Interface
     * param locale:
     * 					Object of Locale
     * param session:
     * 					Object of HttpSession
     * return Timetable:
     * 					View of Timetable Form
     */
	@PostMapping(value="/Timetable")
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") @Valid TimetableForm form, BindingResult bindingResult, Model model, Locale locale, HttpSession session) {
		log.debug("TimetableCtl submit method to submit TimetableForm started");
		System.out.println("opppp" +operation);
		
		UserDTO userDto = (UserDTO) session.getAttribute("user"); 
	 
	    if(OP_SAVE.equalsIgnoreCase(operation)) {
	    	System.out.println("op save");
	    
	    	if(bindingResult.hasErrors()) {
				
	    		return "Timetable";
	    	}	
	    TimetableDTO dto=(TimetableDTO) form.getDto();   	
	    	try {
	    		if(dto.getId()>0) {
	    			dto.setModifiedBy(userDto.getLogin());
	      			service.update(dto);
	      			String msg=messageSource.getMessage("message.updatesuccess",null,locale);
	  			    model.addAttribute("success",msg);
	  			    model.addAttribute("id",dto.getId());
	    		}else {
	    			dto.setCreatedBy(userDto.getLogin());
	      			dto.setModifiedBy(userDto.getLogin());
	      			System.out.println("addd method in time");
	
	      			service.add(dto);
	      			String msg=messageSource.getMessage("message.success",null,locale);
	      			model.addAttribute("success", msg);
	    		}
	    	}catch(DuplicateRecordException e) {
	    		String msg=messageSource.getMessage("error.record",null,locale);
	  		    model.addAttribute("error",msg);
	  		    return "Timetable";
	    	}
	    }else if(OP_RESET.equalsIgnoreCase(operation)) {
	    	return "redirect:/ctl/Timetable/Timetable";
	    }else if(OP_CANCEL.equalsIgnoreCase(operation)) {
	    	return "redirect:/ctl/Timetable/Search";
	    }
		log.debug("TimetableCtl submit method to submit TimetableForm ended");
		return "Timetable";
	}
	
	/**
     * Displays TimetableList View
     * 
     * param form:
     * 				Object of TimetableForm
     * param model:
     * 				Object of Model Interface
     * return TimetableList:
     * 						View of TimetableList
     */
	@RequestMapping(value="/Search",method=RequestMethod.GET)
	public String display(@ModelAttribute("form") TimetableForm form, Model model,Locale locale) {
		log.debug("TimetableCtl display method to display TimetableList started");
		String entername=messageSource.getMessage("label.enterexamdate",null,locale);
		model.addAttribute("enterDate",entername);
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
		int pageNo = 1;
		List next = service.search(new TimetableDTO(), pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
        model.addAttribute("findList",service.search(null));
         
         model.addAttribute("courseList",courseService.search(null,form.getPageNo(),form.getPageSize()));
		
		model.addAttribute("subjectList",subjectService.search(null,form.getPageNo(),form.getPageSize()));
        
		log.debug("TimetableCtl display method to display TimetableList ended");
		return "TimetableList";
	}
	
	/**
     * Submit TimetableList View
     * 
     * param operation:
     * 					Operation given by User
     * param form:
     * 				Object of TimetableForm
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 				Object of Locale
     * return Timetable:
     * 						View of TimetableList
     */
	@RequestMapping(value="/Search",method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") TimetableForm form, Model model, Locale locale) {
		log.debug("TimetableCtl submit method to submit TimetableList started");
		String entername=messageSource.getMessage("label.enterexamdate",null,locale);
		model.addAttribute("enterDate",entername);
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
	    TimetableDTO dto=(TimetableDTO) form.getDto();
	    List list=service.search(dto, pageNo, form.getPageSize());
	    model.addAttribute("list", list);
	    if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation) ){
	    	model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
	  	}
	    if(OP_RESET.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Timetable/Search";
	    }else if(OP_NEW.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Timetable/Timetable";
	    }else if(OP_BACK.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Timetable/Search";}
		log.debug("TimetableCtl submit method to submit TimetableList ended");
		return "TimetableList";
	}
	
	@ModelAttribute("semesterList")
    public LinkedHashMap<String, String> getsemesterList() {
       LinkedHashMap<String, String> semesterList = new LinkedHashMap<String, String>();
       semesterList.put("1st Semester", "1st Semester");
       semesterList.put("2nd Semester", "2nd Semester");
       semesterList.put("3nd Semester", "3nd Semester");
       semesterList.put("4nd Semester", "4nd Semester");
       semesterList.put("5nd Semester", "5nd Semester");
       semesterList.put("6nd Semester", "6nd Semester");
       semesterList.put("7nd Semester", "7nd Semester");
       semesterList.put("8nd Semester", "8nd Semester");

       return semesterList;
    }
	
	@ModelAttribute("examTimeList")
    public LinkedHashMap<String, String> getexamTimeList() {
       LinkedHashMap<String, String> examTimeList = new LinkedHashMap<String, String>();
       examTimeList.put("09:00 AM to 12:00 PM", "09:00 PM to 03:00 PM");
       examTimeList.put("10:00 PM to 01:00 PM", "10:00 PM to 01:00 PM");
       examTimeList.put("12:00 PM to 03:00 PM", "12:00 PM to 03:00 PM");
       examTimeList.put("01:00 PM to 04:00 PM", "02:00 PM to 05:00 PM");
       return examTimeList;
    }
	
	
	

}
