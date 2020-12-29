package in.co.sunrays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;
import in.co.sunrays.project0.dto.StudentDTO;
import in.co.sunrays.project0.util.Util;

public class StudentForm extends BaseForm {

	/** The first name. */
	@NotEmpty
	private String firstName;
	
	/** The last name. */
	@NotEmpty
	private String lastName;
	
	/** The dob. */
	@NotEmpty
	private String dob;
	
	/** The mobile no. */
	@NotEmpty
	private String mobileNo;
	
	/** The Email id. */
	@Email
    @NotEmpty
	private String EmailId;
	
    /** The college id. */
    @NotNull
	private Long collegeId;
	
	/** The college name. */
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

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public BaseDTO getDto() {
		StudentDTO dto = new StudentDTO();
        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDob(Util.getDate(dob));
        dto.setMobileNo(mobileNo);
        dto.setEmailId(EmailId);
        dto.setCollegeId(collegeId);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
        return dto;

	}

	@Override
	public void populate(BaseDTO bDto) {
        StudentDTO dto = (StudentDTO) bDto;
        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        dob = Util.getDate(dto.getDob());
        mobileNo = dto.getMobileNo();
        EmailId = dto.getEmailId();
        collegeId = dto.getCollegeId();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        if(createdDatetime!=0)
        {
        	createdDatetime = dto.getCreatedDateTime().getTime();	
        }
        
        if(modifiedDatetime!=0)
        {
        	modifiedDatetime = dto.getModifiedDateTime().getTime();	
        }

	}
	}


