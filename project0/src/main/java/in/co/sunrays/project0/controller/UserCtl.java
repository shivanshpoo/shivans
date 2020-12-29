package in.co.sunrays.project0.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.sunrays.project0.dto.UserDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.form.ChangePasswordForm;
import in.co.sunrays.project0.form.MyProfileForm;
import in.co.sunrays.project0.form.UserForm;
import in.co.sunrays.project0.service.RoleServiceInt;
import in.co.sunrays.project0.service.UserServiceInt;
import in.co.sunrays.project0.util.Util;
import in.co.sunrays.project0.validator.ChangePassowrdValidator;
import in.co.sunrays.project0.validator.MyProfileValidator;
import in.co.sunrays.project0.validator.UserValidator;

@Controller
@RequestMapping(value = "/ctl/User")
public class UserCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(UserCtl.class);


	@Autowired
	private UserServiceInt service;
	
	@Autowired
	private RoleServiceInt roleService;
	
	/**
     * i18n Message source
     */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserValidator validator;

	@Autowired
	private ChangePassowrdValidator validator1;
	
	
	@Autowired
	private MyProfileValidator validator2;

	
	/**
     * Preload Role List
     */
	@Override
	public void preload(Model model) {
		List list = roleService.search(null);
		model.addAttribute("roleList", list);
	}
	
	/**
     * Displays MyProfile View
     * 
     * param session:
     * 					Object of HttpSession
     * param form:
     * 				Object of MyProfileForm
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 				Object of Locale
     * return MyProfile:
     * 						View of MyProfile Form
     */
	@RequestMapping(value="/Myprofile", method=RequestMethod.GET)
	public String displayProfile(HttpSession session, @ModelAttribute("form") MyProfileForm form, Model model, Locale locale) {
		log.debug("UserCtl displayProfile method to display MyProfile started");
		
		UserDTO dto = (UserDTO) session.getAttribute("user");
		System.out.println("Date value in Myprofile Get method----------->"+Util.getDate(dto.getDob()));
		
		form.populate(dto);
		log.debug("UserCtl displayProfile method to display MyProfile started");
		
		return "MyProfile";
	}
	
	/**
     * Submit MyProfile View
     * 
     * param locale:
     * 					Object of Locale
     * param session:
     * 					Object of HttpSession
     * param form:
     * 				Object of MyProfile Form
     * param model:
     * 				Object of Model Interface
     * param bindingResult:
     * 						Object of BindingResult
     * return MyProfile:
     * 					View of MyProfile Form
     */
	@RequestMapping(value="/Myprofile", method=RequestMethod.POST)
	public String submitProfile(Locale locale, @ModelAttribute("form") @Valid MyProfileForm form, BindingResult bindingResult, Model model, HttpSession session) {
		log.debug("UserCtl submitProfile method to submit MyProfile started");
	
		validator2.validate(form, bindingResult);
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			if(bindingResult.hasErrors()) {
				return "MyProfile";
			}
			
			
			UserDTO dto = service.findByPK(form.getId());
			dto.setFirstName(form.getFirstName());
			dto.setLastName(form.getLastName());
		    dto.setDob(Util.getDate(form.getDob()));
		    System.out.println("Date value in Myprofile Post method----------->"+Util.getDate(form.getDob()));
			dto.setMobileNo(form.getMobileNo());
			dto.setGender(form.getGender());
			dto.setModifiedBy(form.getLogin());
			dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
			session.setAttribute("user", dto);
			
			try {
				service.update(dto);
				String msg=messageSource.getMessage("message.success",null,locale);
 				model.addAttribute("success",msg);
			}catch(DuplicateRecordException e) {
				String msg=messageSource.getMessage("error.loginid",null,locale);
			    model.addAttribute("error",msg);
			}
			return "MyProfile";
		}
		if(OP_CHANGEPASSWORD.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/User/ChangePassword";
		}
		log.debug("UserCtl submitProfile method to submit MyProfile ended");
		return "MyProfile";
	}
	
	/**
     * Displays ChangePassword View
     * 
     * param session:
     * 					Object of HttpSession
     * param form:
     * 				Object of ChangePasswordForm
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 				Object of Locale
     * return ChangePassword:
     * 							View of ChangePassword View
     */
	@RequestMapping(value="/ChangePassword", method=RequestMethod.GET)
	public String displayChangePassword(HttpSession session, @ModelAttribute("form") ChangePasswordForm form, Model model, Locale locale) {
		log.debug("UserCtl displayChangePassword method to display ChangePassword form started");
		log.debug("UserCtl displayChangePassword method to display ChangePassword form ended");
		return "ChangePassword";
	}
	
	/**
	 * Submit ChangePassword View
	 * 
	 * param locale:
	 * 					Object of Locale
	 * param session:
	 * 					Object of HttpSession
	 * param form:
	 * 					Object of ChangePasswordForm
	 * param bindingResult:
	 * 						Object of BindingResult
	 * param model:
	 * 					Object of Model Interface
	 * return ChangePassword:
	 * 							View of ChangePasssword Form
	 */
	@RequestMapping(value="/ChangePassword", method=RequestMethod.POST)
	public String submitChangePassword(Locale locale, HttpSession session, @ModelAttribute("form") @Valid ChangePasswordForm form, BindingResult bindingResult, Model model) {
		log.debug("UserCtl submitChangePassword method to submit ChangePassword form started");
		
		validator1.validate(form, bindingResult);
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			if(bindingResult.hasErrors()) {
				return "ChangePassword";
			}
			
			boolean flag = false;
			UserDTO dto = (UserDTO) session.getAttribute("user");
			
			if(!form.getOldPassword().equals(form.getNewPassword())) {
				if(form.getConfirmPassword().equals(form.getNewPassword())) {
					try {
						flag=service.changePassword(dto.getId(), form.getOldPassword(), form.getNewPassword());
						if(flag) {
							String msg=messageSource.getMessage("message.success",null,locale);
							model.addAttribute("success",msg);
						}else {
							String msg=messageSource.getMessage("error.oldrightpassword",null,locale);
							model.addAttribute("error",msg);
						}
					}catch(DuplicateRecordException e) {
						
					}
				}else {
					String msg=messageSource.getMessage("error.newconpassword",null,locale);
					model.addAttribute("error",msg);
				}
			}else {
				String msg=messageSource.getMessage("error.oldnewpassword",null,locale);
				model.addAttribute("error",msg);
			}
		}
		if(OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/User/Myprofile";
		}
		log.debug("UserCtl submitChangePassword method to submit ChangePassword form ended");
		return "ChangePassword";
	}
	
	/**
     * Displays User View
     * 
     * param id:
     * 				Primary Key
     * param form:
     * 				Object of UserForm
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 				Object of Locale
     * return User:
     * 				View of User Form
     */
	
	@GetMapping(value="/User")
	public String displayUser(@RequestParam(required=false) Long id, @ModelAttribute("form") UserForm form, Model model, Locale locale) {
		log.debug("UserCtl displayUser method to display User form started");
		
		
		if(id!=null && id>0) {
			UserDTO dto = service.findByPK(id);
			dto.setConfirmPassword(dto.getPassword());
            form.populate(dto);
		}
		
		log.debug("UserCtl displayUser method to display User form ended");
		return "User";
	}
	
	/**
     * Submit User View
     * 
     * param operation:
     * 					Operation given by User
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 				Object of Locale
     * param form:
     * 				Object of UserForm
     * param bindingResult:
     * 						Object of BindingResult
     * param session:
     * 				Object of HttpSession
     * return User:
     * 				View of User Form
     */
	
	@PostMapping(value="/User")
	public String submitUser(@RequestParam String operation, Model model, Locale locale, @ModelAttribute("form") @Valid UserForm form, BindingResult bindingResult, HttpSession session) {
		log.debug("UserCtl submitUser method to submit User form started");
		
		validator.validate(form, bindingResult);
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			if(bindingResult.hasErrors()) {
				return "User";
			}
		
			
			UserDTO dto=(UserDTO) form.getDto();
			
			try {
				if(dto.getId()>0) {
					
					
					service.update(dto);
					String msg=messageSource.getMessage("message.updatesuccess",null,locale);
				    model.addAttribute("success",msg);
				    model.addAttribute("id",dto.getId());
				    return "User";
				}else {
					UserDTO userDto = (UserDTO) session.getAttribute("user");
					dto.setCreatedBy(userDto.getLogin());
					dto.setModifiedBy(userDto.getLogin());
					service.add(dto);
					String msg=messageSource.getMessage("message.success",null,locale);
					model.addAttribute("success",msg);
				}
			}catch(DuplicateRecordException e) {
				String msg=messageSource.getMessage("error.loginid",null,locale);
			    model.addAttribute("error",msg);
			    return "User";
			}
		}else if(OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/User/User";
		}else if(OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/User/Search";
		}
		log.debug("UserCtl submitUser method to submit User form ended");
		return "User";
	}
	
	/**
     * Displays User List.
     * 
     * param form:
     * 				Object of UserForm
     * param model:
     * 				Object of Model Interface
     * return UserList:
     * 					View of UserList
     */
	@RequestMapping(value="/Search", method=RequestMethod.GET)
	public String display(@ModelAttribute("form") UserForm form, Model model, Locale locale) {
		log.debug("UserCtl display method to display User List started");
		
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfFirstName",enterfirstName);
		String enterLastName=messageSource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);
		
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
		int pageNo = 1;
		
		 List next = service.search(new UserDTO(), pageNo+1, form.getPageSize());
		 System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		 model.addAttribute("nextlistsize",next.size());
	     System.out.println("nextlistsize--------------->"+next.size());
		
    	model.addAttribute("findList",service.search(null));
        model.addAttribute("roleList",roleService.search(null,form.getPageNo(),form.getPageSize()));
        
        
		log.debug("UserCtl display method to display User List ended");
		return "UserList";
	}
	
	/**
     * Submit User List.
     * 
     * param form:
     * 				Object of UserForm
     * param bindingResult:
     * 						Object of BindingResult
     * param model:
     * 				Object of Model Interface
     * param operation:
     * 					Operation given by User
     * param locale:
     * 					Object of Locale
     * return UserList:
     * 					View of UserList
     */
	@RequestMapping(value="/Search" , method=RequestMethod.POST)
	public String submit(@ModelAttribute("form") UserForm form, BindingResult bindingResult, Model model, @RequestParam(required=false) String operation, Locale locale) {
		log.debug("UserCtl submit method to submit User List started");
		 String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
			model.addAttribute("enterfFirstName",enterfirstName);
			String enterLastName=messageSource.getMessage("label.enterlname",null,locale);
			model.addAttribute("enterLastName",enterLastName);
		model.addAttribute("findList",service.search(null));
		int pageNo=form.getPageNo();
		if(OP_PREVIOUS.equalsIgnoreCase(form.getOperation())) {
			pageNo--;
		}else if(OP_NEXT.equalsIgnoreCase(form.getOperation())) {
			pageNo++;
		}else if(OP_DELETE.equalsIgnoreCase(form.getOperation())) {
			System.out.println("Delete my record 1");
			if(form.getChk_1()!=null) {
				System.out.println("Delete my record 2");
				for (long id : form.getChk_1()) {
					service.delete(id);
				}
				String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
			}
			else {
				
				String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
			}
		}
		pageNo=(pageNo<1)?1:pageNo;
		form.setPageNo(pageNo);
		UserDTO dto = (UserDTO) form.getDto();
		
		System.out.println("sssssssshhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		List list=service.search(dto, pageNo, form.getPageSize());
		List next = service.search(dto, pageNo+1, form.getPageSize());
	
		model.addAttribute("nextlistsize",next.size());
		model.addAttribute("list",list);
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation)){
			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
		}
		if(OP_RESET.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/User/Search";
		}
		else if(OP_NEW.equalsIgnoreCase(operation)){
   	    	return "redirect:/ctl/User/User";
 		}else if(OP_BACK.equals(operation)){
 			return "redirect:/ctl/User/Search";
 		}
		log.debug("UserCtl submit method to submit User List ended");
		return "UserList";
	}
	
    @ModelAttribute("genderList")
    public Map<String, String> getgenderList() {
       Map<String, String> genderList = new HashMap<String, String>();
       genderList.put("Male", "Male");
       genderList.put("Female", "Female");
       return genderList;
    }


	
}
