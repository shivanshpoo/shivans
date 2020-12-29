package in.co.sunrays.project0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The Class StudentDTO.
 */
@Entity
@Table(name = "ST_STUDENT")
public class StudentDTO extends BaseDTO{

	/** First Name of Student. */
	@Column(name="FIRST_NAME",length=255)
	private String firstName;

	/** Last Name of Student. */
	@Column(name="LAST_NAME",length=255)
	private String lastName;

	/** Date of Birth of Student. */
	@Column(name="DOB")
	private Date dob;

	/** Mobileno of Student. */
	@Column(name="MOBILE_NO",length=255)
	private String mobileNo;

	/** Email of Student. */

	@Column(name="EMAIL_ID",length=255)
	private String EmailId;

	/** CollegeId of Student. */
	@Column(name="COLLEGE_ID",length=50)
	private long collegeId;

	/** College name of Student. */
	@Transient
	private String collegeName;

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

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dto.DropdownList#getKey()
	 */
	public String getKey() {
		// TODO Auto-generated method stub
		return id +"";
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dto.DropdownList#getValue()
	 */
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName + " " + lastName;
	}

	
}
