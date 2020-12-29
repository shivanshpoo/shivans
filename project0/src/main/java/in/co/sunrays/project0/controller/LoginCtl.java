package in.co.sunrays.project0.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import in.co.sunrays.project0.dto.RoleDTO;
import in.co.sunrays.project0.dto.UserDTO;
import in.co.sunrays.project0.exception.ApplicationException;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.form.ForgetPasswordForm;
import in.co.sunrays.project0.form.LoginForm;
import in.co.sunrays.project0.form.UserRegistrationForm;
import in.co.sunrays.project0.service.UserServiceInt;
import in.co.sunrays.project0.validator.LoginValidator;
import in.co.sunrays.project0.validator.UserRegistrationValidator;

@Controller
public class LoginCtl extends BaseCtl {

	private static Logger log=Logger.getLogger(LoginCtl.class);
	
	/**
	 * Operations
	 */
	protected static final String OP_SIGNIN = "SignIn";
    protected static final String OP_SIGNUP = "SignUp";
    
    @Autowired
    private UserServiceInt service;
    
    /**
     * i18n Message source
     */
    @Autowired
    private MessageSource messageSource;
    
    
	@Autowired
	private LoginValidator validator1;
	
	/**
     * Display Login View
     * param form:
     * 				Object of LoginForm
     * param session:
     * 					Object of HttpSession
     * param model:
     * 					Object of Model Interface
     * param locale:
     * 					Object of Locale
     * return Login:
     * 					View of Login Page
     */
	@RequestMapping(value="/Login", method=RequestMethod.GET)
    public String display(@ModelAttribute("form") LoginForm form, HttpSession session, Model model, Locale locale) {
    	log.debug("LoginCtl method display to display login form started");
    	System.out.println("Login ctl=====================");
    	if(session.getAttribute("user")!=null) {
    		session.invalidate();
    		String msg=messageSource.getMessage("message.logout",null,locale); 
   	 	 	model.addAttribute("success",msg);
    	}
    	log.debug("LoginCtl method display to display login form ended");
    	return "Login";
    }
	
	/**
     * submit Login View
     * param locale:
     * 				Object of Locale
     * param form:
     * 				Object of LoginForm
     * param bindingResult:
     * 						Object of BindingResult
     * param model:
     * 				Object of Model Interface
     * param session:
     * 					Object of HttpSession
     * param request:
     * 					Object of HttpServletRequest
     * return Login:
     * 					View of Login Page
     */
	@RequestMapping(value="/Login", method=RequestMethod.POST)
    public String submit(Locale locale, @ModelAttribute("form") @Valid LoginForm form, BindingResult bindingResult, Model model, HttpSession session, HttpServletRequest request) {
    	log.debug("LoginCtl method submit to submit login form started");
    	
    	validator1.validate(form, bindingResult);
    	
    	if(OP_SIGNIN.equalsIgnoreCase(form.getOperation())) {
    		if(bindingResult.hasErrors()) {
    			return "Login";
    		}
    		UserDTO dto = new UserDTO();
    		dto.setLogin(form.getEmailId());
    		dto.setPassword(form.getPassword());
    		dto=service.authenticate(dto);
    		if(dto!=null) {
    			UserDTO edto = service.findByPK(dto.getId());
    			try {
    				
    				service.update(edto);
    			}catch(DuplicateRecordException e) {
    				e.printStackTrace();
    			}
    			session.setAttribute("user", dto);
    			RoleDTO roleDTO = service.getRole(dto);
    			session.setAttribute("role", roleDTO.getName());
    			if(form.getUri()==null||"".equalsIgnoreCase(form.getUri())|| "null".equalsIgnoreCase(form.getUri())){
    			return "redirect:/Welcome";
    			}else{
    				return "redirect:/"+ form.getUri();
    			}
    		}else {
    			String msg = messageSource.getMessage("login.error", null,locale);
                model.addAttribute("error", msg);
    		}
    	}if(OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/UserRegistration";
		}
    	log.debug("LoginCtl method submit to submit login form ended");
    	return "Login";
    }
	
	/**
     * Display UserRegistration View
     * param form:
     * 				Object of UserRegistrationForm
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 				Object of Locale
     * return UserRegistration:
     * 							View of UserRegistration Form
     */
    @RequestMapping(value="/UserRegistration", method=RequestMethod.GET)
    public String display(@ModelAttribute("form") UserRegistrationForm form , Model model, Locale locale) {
    	
    	log.debug("LoginCtl method display to display UserRegistration form started");
    	
		log.debug("LoginCtl method display to display UserRegistration form ended");
		
		return "UserRegistration";
    }
    
    /**
     * submit UserRegistraion View
     * param locale:
     * 					Object of Locale
     * param form:
     * 					Object of UserRegistrationForm
     * param bindingResult:
     * 						Object of BindingResult
     * param model:
     * 				Object of Model Interface
     * return UserRegistration:
     * 							View of UserRegistration Form
     */
    @RequestMapping(value="/UserRegistration", method=RequestMethod.POST)
    public String submit(Locale locale, @ModelAttribute("form") @Valid UserRegistrationForm form, BindingResult bindingResult, Model model) {
    	
    	log.debug("LoginCtl method submit to submit UserRegistration form started");
    		
    	System.out.println("hdsfdfsdsfbsddsafbhsdfasdhjsdfjsbdjsd--------------");
    	
    	if(OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {
    		if(bindingResult.hasErrors()) {
    			System.out.println("In signup hasErrors"+bindingResult.toString());
    			return "UserRegistration";
    		}
    		UserDTO dto = (UserDTO) form.getDto();
    		
    		
    		try {
    			if(!dto.getPassword().equals(dto.getConfirmPassword())) {
    				String msg=messageSource.getMessage("pattern.matchpass",null,locale);
   			     	model.addAttribute("error1",msg);
   			     	return "UserRegistration";
    			}
    			dto.setRoleId(RoleDTO.STUDENT);
    			dto.setCreatedBy("root");
    			dto.setModifiedBy("root");
    			dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
    			dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
    			service.registerUser(dto);
    			String msg=messageSource.getMessage("message.success",null,locale);
   		     	model.addAttribute("success",msg);
   		     	form.populate(new UserDTO());
    			return "UserRegistration";
    		}catch(DuplicateRecordException e) {
    			String msg=messageSource.getMessage("error.loginid",null,locale);
   		     	model.addAttribute("error",msg);
    		} catch (ApplicationException e) {
    			String msg=messageSource.getMessage("error.loginid",null,locale);
   		     	model.addAttribute("error",msg);
			}
    		return "redirect:/UserRegistration";
    	}
    	if(OP_RESET.equalsIgnoreCase(form.getOperation())) {
    		return "redirect:/UserRegistration";
    	}
    	
    	log.debug("LoginCtl method submit to submit UserRegistration form ended");
    	
    	return "UserRegistration";
    }
    
    /**
     * Display ForgetPassword View
     * param form:
     * 				Object of ForgetPasswordForm
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 					Object of Locale
     * return ForgetPassword:
     * 							View of ForgetPassword Form
     */
	 @RequestMapping(value="/ForgetPassword" ,method=RequestMethod.GET)
	 public String display(@ModelAttribute("form") ForgetPasswordForm form, Model model,Locale locale){
		 log.debug("LoginCtl method display to display ForgetPassword form started");
		 log.debug("LoginCtl method display to display ForgetPassword form ended");
		 return "ForgetPassword";
	 }
    
    /**
     * submit forgetPassword View
     * param locale:
     * 					Object of Locale
     * param form:
     * 				Object of ForgetPasswordForm
     * param bindingResult:
     * 						Object of BindingResult
     * param model:
     * 				Object of Model
     * return ForgetPassword:
     * 							View of ForgetPassword Form
     */
    @RequestMapping(value="/ForgetPassword", method=RequestMethod.POST)
    public String submit(Locale locale, @ModelAttribute("form") @Valid ForgetPasswordForm form, BindingResult bindingResult, Model model) {
    	log.debug("LoginCtl method submit to submit ForgetPassword form started");
    	if(OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
    		return "redirect:/Login";
    	}
    	if(OP_GO.equalsIgnoreCase(form.getOperation())) {
    		if(bindingResult.hasErrors()) {
    			return "ForgetPassword";
    		}
    		try {
    			boolean dto = service.forgetPassword(form.getLogin());
    			if(dto==true) {
    				model.addAttribute("success","Password has been sent to your registered Email ID!!");
    			}else {
    				String msg=messageSource.getMessage("forgetpass.error",null,locale);
    				model.addAttribute("error",msg);
    			}
    		}catch(ApplicationException e) {
    			e.printStackTrace();
    		}
    	}
    	log.debug("LoginCtl method submit to submit ForgetPassword form ended");
    	return "ForgetPassword";
    }
    
    @ModelAttribute("genderList")
    public Map<String, String> getgenderList() {
       Map<String, String> genderList = new HashMap<String, String>();
       genderList.put("Male", "Male");
       genderList.put("Female", "Female");
       return genderList;
    }


	
	
}
