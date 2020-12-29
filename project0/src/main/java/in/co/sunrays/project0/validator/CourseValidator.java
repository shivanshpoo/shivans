package in.co.sunrays.project0.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.sunrays.project0.form.CourseForm;
import in.co.sunrays.project0.util.DataValidator;

@Component
public class CourseValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		CourseForm form=(CourseForm) target;
		String courseName = form.getCourseName();
		
		   if (!DataValidator.isNull(courseName)) {
				
				if(!DataValidator.isNameWithSpace(courseName)) {
				
			errors.rejectValue("courseName", "error.courseName.invalid");
				 }
				
			          }
	    

	}

	
}
