package in.co.sunrays.project0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ST_SUBJECT")
/**
 * The Class SubjectDTO.
 */

public class SubjectDTO extends BaseDTO {


	/** The course name. */
	@Transient
	private String courseName;
    
	/** The course id. */
	@Column(name = "COURSE_ID", length = 50)
	private long courseId;
    
	/** The subject name. */
	@Column(name = "SUBJECT_NAME", length =255)
    private String subjectName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
		return subjectName;
	}

	
}
