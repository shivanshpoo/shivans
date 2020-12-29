package in.co.sunrays.project0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class CourseDTO.
 */
@Entity
@Table(name = "ST_COURSE")
public class CourseDTO extends BaseDTO{

	/** The name. */
	@Column(name = "COURSE_NAME", length =255)
	private String courseName;

	/** The description. */
	@Column(name = "DESCRIPTION", length =255)
	private String description;

	
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return courseName;
	}

}
