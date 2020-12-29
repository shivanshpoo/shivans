package in.co.sunrays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;
import in.co.sunrays.project0.dto.UserDTO;
import in.co.sunrays.project0.util.Util;

public class UserForm extends BaseForm {


	/** The first name. */
	@NotEmpty
	private String firstName;
	
	/** The last name. */
	@NotEmpty
	private String lastName;
	
	/** The login. */
	@Email
	@NotEmpty
	private String login;
	
	/** The password. */
	@NotEmpty
	private String password;
	
	/** The confirm password. */
	@NotEmpty
	private String confirmPassword;
	
	/** The dob. */
	@NotEmpty
	private String dob;
	
	/** The mobile no. */
	@NotEmpty
	private String mobileNo;
	
	/** The gender. */
	@NotEmpty
	private String gender;
	
    /** The role id. */
    @NotNull
	private Long roleId;

    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setLogin(login);
        dto.setPassword(password);
        dto.setConfirmPassword(confirmPassword);
        dto.setDob(Util.getDate(dob));
        dto.setMobileNo(mobileNo);
        if(roleId!=null)
        {
        	dto.setRoleId(roleId);	
        }
        dto.setGender(gender);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
        return dto;

	}

	@Override
	public void populate(BaseDTO bDto) {
        UserDTO dto = (UserDTO) bDto;

        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        login = dto.getLogin();
        password = dto.getPassword();
        confirmPassword=dto.getConfirmPassword();
        dob = Util.getDate(dto.getDob());
        mobileNo = dto.getMobileNo();
        roleId = dto.getRoleId();
        gender = dto.getGender();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        createdDatetime = dto.getCreatedDateTime().getTime();
        modifiedDatetime = dto.getModifiedDateTime().getTime();
       
	}

	
}
