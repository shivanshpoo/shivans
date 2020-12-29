package in.co.sunrays.project0.form;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;

public class ChangePasswordForm extends BaseForm{

	/** The old password. */
	@NotEmpty
	private String oldPassword;
	
	/** The new password. */
	@NotEmpty
	private String newPassword;
	
	/** The confirm password. */
	@NotEmpty
	private String confirmPassword;
	
	
	
	
	public String getOldPassword() {
		return oldPassword;
	}




	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}




	public String getNewPassword() {
		return newPassword;
	}




	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}




	public String getConfirmPassword() {
		return confirmPassword;
	}




	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}




	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public BaseDTO getDto() {
		// TODO Auto-generated method stub
		return null;
	}

}
