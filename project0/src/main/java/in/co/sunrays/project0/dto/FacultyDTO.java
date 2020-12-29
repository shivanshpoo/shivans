package in.co.sunrays.project0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The Class FacultyDTO.
 */
@Entity
@Table(name = "ST_FACULTY")
public class FacultyDTO extends BaseDTO{


	/** The subject id. */
	@Column(name = "SUBJECT_ID" ,length = 50)
	private long subjectId;
	
	/** The subject name. */
	@Transient
	/** The subject name. */
	private String subjectName;
	
	/** The course id. */
	@Column(name = "COURSE_ID" ,length = 50)
	private long courseId;
	
	/** The course name. */
	@Transient
	/** The course name. */
	private String courseName;
	
	
	/** The college id. */
	@Column(name = "COLLEGE_ID" ,length = 50)
	private long collegeId;
	
	/** The college name. */
	@Transient
	/** The college name. */
	private String collegeName;
	
	
	/** The first name. */
	@Column(name = "FIRST_NAME" ,length =255)
	private String firstName;
	
	/** The last name. */
	@Column(name = "LAST_NAME" ,length =255)
	private String lastName;
	
	
	/** The mobile no. */
	@Column(name = "MOBILE_NO" ,length =255)
	private String mobileNo;
	

	
    /** The login id. */
	@Column(name = "LOGIN_ID" ,length =255)
    private String loginId;
    
    
    /** The doj. */
	@Column(name = "DOJ" ,length =255)
    private Date doj;

	

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
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
