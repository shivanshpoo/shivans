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

import in.co.sunrays.project0.dto.SubjectDTO;
import in.co.sunrays.project0.dto.UserDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.form.SubjectForm;
import in.co.sunrays.project0.service.CourseServiceInt;
import in.co.sunrays.project0.service.SubjectServiceInt;
import in.co.sunrays.project0.validator.SubjectValidator;

@Controller
@RequestMapping(value = "/ctl/Subject")
public class SubjectCtl extends BaseCtl {


	private static Logger log = Logger.getLogger(SubjectCtl.class);

	@Autowired
	private SubjectServiceInt service;

	@Autowired
	private CourseServiceInt courseService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private SubjectValidator validator;


	
	
	@Override
	public void preload(Model model) {
		log.debug("SubjectCtl preload method started");
		List list = courseService.search(null);
		model.addAttribute("courseList", list);
		log.debug("SubjectCtl preload method ended");
	}

	/**
	 * Displays Subject View
	 * 
	 * param id:
	 *            Primary Key
	 * param form:
	 *            Object of SubjectForm
	 * param model:
	 *            Object of Model Interface
	 * return Subject: View of Subject Form
	 */
	@RequestMapping(value = "/Subject", method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") SubjectForm form,
			Model model,Locale locale) {
		
		log.debug("SubjectCtl display method to display SubjectForm started");
		if (id != null && id > 0) {
			form.populate(service.findByPK(id));
		}
		log.debug("SubjectCtl display method to display SubjectForm ended");
		return "Subject";
	}

	/**
	 * Submit Subject View
	 * 
	 * param operation:
	 *            Operation given by User
	 * param model:
	 *            Object of Model Interface
	 * param form:
	 *            Object of StudentForm
	 * param bindingResult:
	 *            Object of BindingResult
	 * param session:
	 *            Object of HttpSession
	 * param locale:
	 *            Object of Locale
	 * return Subject: View of Subject Form
	 */
	@RequestMapping(value = "/Subject", method = RequestMethod.POST)
	public String submit(@RequestParam String operation, Model model, @ModelAttribute("form") @Valid SubjectForm form,
			BindingResult bindingResult, HttpSession session, Locale locale) {
		
		validator.validate(form, bindingResult);
		
		log.debug("SubjectCtl submit method to submit SubjectForm started");
		if (OP_SAVE.equalsIgnoreCase(operation)) {
			if (bindingResult.hasErrors()) {
				return "Subject";
			}
			
			
			SubjectDTO dto = (SubjectDTO) form.getDto();
			
			try {
				if (dto.getId() > 0) {
					service.update(dto);
					String msg = messageSource.getMessage("message.updatesuccess", null, locale);
					model.addAttribute("success", msg);
					model.addAttribute("id", dto.getId());
					return "Subject";
				} else {
					UserDTO userDto = (UserDTO) session.getAttribute("user");
					dto.setCreatedBy(userDto.getLogin());
					dto.setModifiedBy(userDto.getLogin());
					service.add(dto);
					String msg = messageSource.getMessage("message.success", null, locale);
					model.addAttribute("success", msg);
					
				}
			} catch (DuplicateRecordException e) {
				String msg = messageSource.getMessage("error.subjectname", null, locale);
				model.addAttribute("error", msg);
				return "Subject";
			}
		} else if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Subject/Search";
		} else if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Subject/Subject";
		}
		log.debug("SubjectCtl submit method to submit SubjectForm ended");
		return "Subject";
	}

	/**
	 * Displays Subject List.
	 * 
	 * param form:
	 *            Object of SubjectForm
	 * param model:
	 *            Object of Model Interface
	 * return SubjectList: View of Subject List
	 */
	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") SubjectForm form, Model model) {
		log.debug("SubjectCtl display method to display SubjectList started");
		model.addAttribute("list", service.search(null, form.getPageNo(), form.getPageSize()));
		int pageNo = 1;
		List next = service.search(new SubjectDTO(), pageNo + 1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		model.addAttribute("courseList",courseService.search(null,form.getPageNo(),form.getPageSize()));
		log.debug("SubjectCtl display method to display SubjectList ended");
		return "SubjectList";
	}

	/**
	 * Submit Subject List.
	 * 
	 * param operation:
	 *            Operation given by User
	 * param form:
	 *            Object of SubjectForm
	 * param model:
	 *            Object of Model Interface
	 * param locale:
	 *            Object of Locale
	 * return SubjectList: View of SubjectList
	 */
	@RequestMapping(value = "/Search", method = RequestMethod.POST)
	public String submit(@RequestParam(required = false) String operation, @ModelAttribute("form") SubjectForm form,
			Model model, Locale locale) {
		log.debug("SubjectCtl submit method to submit SubjectList started");

		int pageNo = form.getPageNo();
		if (OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		} else if (OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		} else if (OP_DELETE.equalsIgnoreCase(operation)) {
			if (form.getChk_1() != null) {
				for (long id : form.getChk_1()) {
					service.delete(id);
				}
				String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
			} else {
				String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error1", msg);
			}
		}
		pageNo = (pageNo < 1) ? 1 : pageNo;
		form.setPageNo(pageNo);
		SubjectDTO dto = (SubjectDTO) form.getDto();
		List list = service.search(dto, pageNo, form.getPageSize());
		model.addAttribute("list", list);
		List next = service.search(dto, pageNo + 1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
		}

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Subject/Search";
		}
		else if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Subject/Subject";
		}
		if (OP_BACK.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Subject/Search";
		}
		log.debug("SubjectCtl submit method to submit SubjectList ended");
		return "SubjectList";
	}


}
