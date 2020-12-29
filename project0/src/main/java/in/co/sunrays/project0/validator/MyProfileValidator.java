package in.co.sunrays.project0.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.sunrays.project0.form.MyProfileForm;
import in.co.sunrays.project0.util.DataValidator;

@Component
public class MyProfileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MyProfileForm form = (MyProfileForm) target;
		String firstName = form.getFirstName();
		String lastName = form.getLastName();
		String mobileNo = form.getMobileNo();
	
		if(!DataValidator.isNameWithSpace(firstName)) {
			errors.rejectValue("firstName", "error.firstName.invalid");
		}
		else if (DataValidator.isWhiteSpace(firstName)) {
			errors.rejectValue("firstName", "error.firstName.invalid1");
		}
		
	
	if (!DataValidator.isNull(lastName)) {
		if(!DataValidator.isNameWithSpace(lastName)) {
			errors.rejectValue("lastName", "error.lastName.invalid");
		}
		else if (DataValidator.isWhiteSpace(firstName)) {
			errors.rejectValue("lastName", "error.lastName.invalid1");
		}
	}
	
	if (!DataValidator.isNull(mobileNo)) {

		if (DataValidator.isPhoneNo(mobileNo)) {
			errors.rejectValue("mobileNo", "error.mobileNo.invalid");
		}
	}

	}

	
}
