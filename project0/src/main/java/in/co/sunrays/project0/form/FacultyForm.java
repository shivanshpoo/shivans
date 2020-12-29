package in.co.sunrays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;
import in.co.sunrays.project0.dto.FacultyDTO;
import in.co.sunrays.project0.util.Util;

public class FacultyForm extends BaseForm {

	/** The subject id. */
	@NotNull
	private Long subjectId;
	
	/** The college id. */
	@NotNull
	private Long collegeId;
	
	/** The course id. */
	@NotNull
	private Long courseId;
	
	
	/** The subject name. */
	private String subjectName;
	
	
	/** The course name. */
	private String courseName;
	
	/** The college name. */
	private String collegeName;
	
	/** The first name. */
	@NotEmpty
	private String firstName;
	
	/** The last name. */
	@NotEmpty
	private String lastName;
	
	/** The login id. */
	@Email
	@NotEmpty
    private String loginId;
	
	/** The doj. */
	@NotEmpty
	private String doj;
	
	/** The mobile no. */
	@NotEmpty
	private String mobileNo;

	/**
	 * Gets the subject id.
	 *
	 * @return the subject id
	 */
	public Long getSubjectId() {
		return subjectId;
	}

	
	
	
	public Long getCollegeId() {
		return collegeId;
	}




	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}




	public Long getCourseId() {
		return courseId;
	}




	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}




	public String getSubjectName() {
		return subjectName;
	}




	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}




	public String getCourseName() {
		return courseName;
	}




	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}




	public String getCollegeName() {
		return collegeName;
	}




	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}




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




	public String getLoginId() {
		return loginId;
	}




	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}




	public String getDoj() {
		return doj;
	}




	public void setDoj(String doj) {
		this.doj = doj;
	}




	public String getMobileNo() {
		return mobileNo;
	}




	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}




	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}




	@Override
	public BaseDTO getDto() {
		FacultyDTO dto=new FacultyDTO();
		dto.setId(id);
		dto.setCollegeId(collegeId);
		dto.setCollegeName(collegeName);
		dto.setCourseId(courseId);
		if(subjectId!=null)
		{
		dto.setSubjectId(subjectId);
				
		}
		dto.setCourseName(courseName);
		dto.setSubjectName(subjectName);
		dto.setDoj(Util.getDate(doj));
		dto.setLoginId(loginId);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setMobileNo(mobileNo);
		dto.setCreatedBy(createdBy);
	    dto.setModifiedBy(modifiedBy);
	    dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
	    dto.setModifiedDateTime(new Timestamp(new Date().getTime()));		
			return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		FacultyDTO dto=(FacultyDTO) bDto;
		id=dto.getId();
		collegeId=dto.getCollegeId();
		collegeName=dto.getCollegeName();
		courseId=dto.getCourseId();
		courseName=dto.getCourseName();
		subjectId=dto.getSubjectId();
		subjectName=dto.getSubjectName();
		loginId=dto.getLoginId();
		firstName=dto.getFirstName();
		lastName=dto.getLastName();
		mobileNo=dto.getMobileNo();
		doj=Util.getDate(dto.getDoj());
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


