package in.co.sunrays.project0.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.sunrays.project0.form.ChangePasswordForm;
import in.co.sunrays.project0.util.DataValidator;

@Component
public class ChangePassowrdValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ChangePasswordForm form=(ChangePasswordForm) target;
		String oldPassword =form.getOldPassword();
		String newpassword = form.getNewPassword();
		String confirmPassword = form.getConfirmPassword();
		
		if (!DataValidator.isNull(oldPassword)) {
			if (!DataValidator.isPassword(oldPassword)) {
				errors.rejectValue("oldPassword", "error.password");
			}
		}
		
		if (!DataValidator.isNull(newpassword)) {
			if (oldPassword.equals(newpassword)) 
			{
				errors.rejectValue("newPassword", "error.oldnewpassword");
			
			}
			
		else if (!DataValidator.isPassword(newpassword)) {
				errors.rejectValue("newPassword", "error.password");
			}
		}
		
        if (!DataValidator.isNull(confirmPassword)) {
			
			if (!newpassword.equals(confirmPassword) && !"".equals(confirmPassword)) 
			{
				errors.rejectValue("confirmPassword", "error.confirmPassword");
			}
			
		}

	}

	
}
