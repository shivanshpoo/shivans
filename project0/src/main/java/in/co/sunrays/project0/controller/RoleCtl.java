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

import in.co.sunrays.project0.dto.RoleDTO;
import in.co.sunrays.project0.dto.UserDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.form.RoleForm;
import in.co.sunrays.project0.service.RoleServiceInt;

@Controller
@RequestMapping(value="/ctl/Role")
public class RoleCtl extends BaseCtl {
private static Logger log = Logger.getLogger(RoleCtl.class);
	
	@Autowired
	private RoleServiceInt service;
	
	/**
     * i18n Message source
     */
	@Autowired
	private MessageSource messageSource;
	
	/**
     * Displays Role view.
     * 
     * param id:
     * 				Primary Key
     * param form:
     * 				Object of RoleForm
     * param model:
     * 				Object of Model Interface
     * return Role:
     * 				View of Role Form
     */
	@RequestMapping(value="/Role",method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") RoleForm form, Model model,Locale locale) {
		log.debug("RoleClt display method to display RoleForm started");
		if(id!=null && id>0) {
			RoleDTO dto=service.findById(id);
			form.populate(dto);
		}
		log.debug("RoleCtl display method to display RoleForm ended");
		return "Role";
	}
	
	/**
     * Submit Role view.
     * param operation:
     * 					Operation given by User
     * param model:
     * 				Object of Model Interface
     * param form:
     * 				Object of RoleForm
     * param bindingResult:
     * 						Object of BindingResult
     * param session:
     * 					Object of HttpSession
     * param locale:
     * 					Object of Locale
     * return Role:
     * 				View of Role Form
     */
	@RequestMapping(value="/Role", method=RequestMethod.POST)
	public String submit(@RequestParam String operation, Model model, @ModelAttribute("form") @Valid RoleForm form, BindingResult bindingResult, HttpSession session, Locale locale) {
		log.debug("RoleCtl submit method to submit RoleForm started");
		RoleDTO dto = (RoleDTO) form.getDto();
		if(OP_SAVE.equalsIgnoreCase(operation)) {
			if(bindingResult.hasErrors()) {
				return "Role";
			}
			try {
				if(dto.getId()>0) {
					service.update(dto);
					String msg=messageSource.getMessage("message.updatesuccess",null,locale);
				    model.addAttribute("success",msg);
				    model.addAttribute("id",dto.getId());
				    return "Role";
				}else {
					UserDTO userDto = (UserDTO) session.getAttribute("user");
					dto.setCreatedBy(userDto.getLogin());
					dto.setModifiedBy(userDto.getLogin());
					service.add(dto);
					String msg=messageSource.getMessage("message.success",null,locale);
					model.addAttribute("success",msg);
					//form.populate(new RoleDTO());
				}
			}catch(DuplicateRecordException e) {
				String msg=messageSource.getMessage("error.rolename",null,locale);
			    model.addAttribute("error",msg);
			    return "Role";
			}
		}else if(OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Role/Role";
		}else if(OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Role/Search";
		}
		log.debug("RoleCtl submit method to submit RoleForm ended");
		return "Role";
	}
	
	/**
     * Displays Role List.
     * 
     * param form:
     * 				Object of RoleForm
     * param model:
     * 				Object of Model Interface
     * return RoleList:
     * 					View of RoleList
     */
	@RequestMapping(value="/Search", method=RequestMethod.GET)
	public String display(@ModelAttribute("form") RoleForm form, Model model,Locale locale) {
		log.debug("RoleCtl display method to display RoleList started");
		String entername=messageSource.getMessage("label.enterrname",null,locale);
		model.addAttribute("enterName",entername);
		
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
		int pageNo = 1;
		List next = service.search(new RoleDTO(), pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
        model.addAttribute("findList",service.search(null));
		log.debug("RoleCtl display method to display RoleList ended");
		return "RoleList";
	}
	
	/**
     * Submit Role List.
     * param operation:
     * 					Operation given by User
     * param form:
     * 				Object of RoleForm
     * param model:
     * 				Object of Model Interface
     * param locale:
     * 					Object of Locale
     * return RoleList:
     * 					View of RoleList
     */ 
	@RequestMapping(value="/Search", method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") RoleForm form, Model model, Locale locale) {
		log.debug("RoleCtl submit method to submit RoleList started");
		String entername=messageSource.getMessage("label.enterrname",null,locale);
		model.addAttribute("enterName",entername);
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
				model.addAttribute("error1", msg);
			}
		}
		pageNo=(pageNo<1)?1:pageNo;
        form.setPageNo(pageNo);
        RoleDTO dto=(RoleDTO) form.getDto();
        List list=service.search(dto, pageNo, form.getPageSize());
		model.addAttribute("list",list);
		List next = service.search(dto, pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
		
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation)){
  			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
  		}
		
		if(OP_RESET.equalsIgnoreCase(operation)){
        	return "redirect:/ctl/Role/Search";
        }else if(OP_NEW.equalsIgnoreCase(operation)){
        	return "redirect:/ctl/Role/Role";
	    }else if(OP_BACK.equalsIgnoreCase(operation)){
        	return "redirect:/ctl/Role/Search";
	    }
		log.debug("RoleCtl submit method to submit RoleList ended");
		return "RoleList";
	}
	

	
}
