package in.co.sunrays.project0.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;

public class ForgetPasswordForm extends BaseForm {

	@Email
	@NotEmpty
    private String login;

	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public BaseDTO getDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		
	}

}
