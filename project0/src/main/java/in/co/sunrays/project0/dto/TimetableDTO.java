package in.co.sunrays.project0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The Class TimetableDTO.
 */
@Entity
@Table(name = "ST_TIMETABLE")
public class TimetableDTO extends BaseDTO {

	/** Course Id. */
	@Column(name = "COURSE_ID", length = 50)
	private long courseId;
	
	/** Course Name. */
	@Transient
	private String courseName;
	
	/** Subject Id. */
	@Column(name = "SUBJECT_ID", length = 50)
	private long subjectId;
	
	/** Subject Name. */
	@Transient
	private String subjectName;
	
	/** Exam Date. */
	@Column(name = "EXAM_DATE")
    private Date examDate;
    
    /** Exam Time. */
	@Column(name = "EXAM_TIME", length = 255)
    private String examTime;
    
    /** Exam Time. */
	@Column(name = "SEMESTER", length = 255)
    private String semester;

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

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
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
		return courseName;
	}


}
