package in.co.sunrays.project0.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.sunrays.project0.form.SubjectForm;
import in.co.sunrays.project0.util.DataValidator;

@Component
public class SubjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		SubjectForm form=(SubjectForm) target;
		String subjectName = form.getSubjectName();
		   if (!DataValidator.isNull(subjectName)) {
				
					if(!DataValidator.isNameWithSpace(subjectName)) {
					
						errors.rejectValue("subjectName", "error.subjectName.invalid");
					 }
					
				          }
			
		}

	}


