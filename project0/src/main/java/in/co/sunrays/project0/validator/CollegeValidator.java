package in.co.sunrays.project0.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.sunrays.project0.form.CollegeForm;
import in.co.sunrays.project0.util.DataValidator;

@Component
public class CollegeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
	
		System.out.println("hiiiiiiiiiiiiiiii-----------------");
		CollegeForm form = (CollegeForm) target;
		String collegeName = form.getName();

		String mobileNo = form.getPhoneNo();

		if (!DataValidator.isNull(collegeName)) {

			if (!DataValidator.isNameWithSpace(collegeName)) {
				errors.rejectValue("name", "error.collegeName.invalid");
			}

		}

		if (!DataValidator.isNull(mobileNo)) {

			if (DataValidator.isPhoneNo(mobileNo)) {
				errors.rejectValue("phoneNo", "error.mobileNo.invalid");
			}
		}

	}

}
