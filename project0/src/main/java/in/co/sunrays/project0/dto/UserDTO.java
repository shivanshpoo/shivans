package in.co.sunrays.project0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ST_USER")
public class UserDTO extends BaseDTO {

	/** Lock Active constant for User. */
    public static final String ACTIVE = "Active";
    
    /** Lock Inactive constant for User. */
    public static final String INACTIVE = "Inactive";

    /** First Name of User. */
    @Column(name="FIRST_NAME",length=255)
    private String firstName;
    
    /** Last Name of User. */
    @Column(name="LAST_NAME",length=255)
    private String lastName;
    
    /** Login of User. */
    @Column(name="LOGIN",length=255)
    private String login;
    
    /** Password of User. */
    @Column(name="PASSWORD",length=255)
    private String password;
    
    /** Confirm Password of User. */
    @Transient
    private String confirmPassword;
    
    /** Date of Birth of User. */
    @Column(name="DOB")
    private Date dob;
    
    /** MobielNo of User. */
    @Column(name="MOBILE_NO",length=255)
    private String mobileNo;
    
    /** Role of User. */
    @Column(name="ROLE_ID",length=50)
    private long roleId;
    
    /** Gender of User. */
    @Column(name="GENDER",length=255)
    private String gender;
    
    /** rolename. */
    @Transient
    private String roleName;


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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dto.DropdownList#getKey()
	 */
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dto.DropdownList#getValue()
	 */
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}

}
