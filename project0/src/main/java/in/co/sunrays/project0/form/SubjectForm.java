package in.co.sunrays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;
import in.co.sunrays.project0.dto.SubjectDTO;

public class SubjectForm extends BaseForm {

	/** The subject name. */
	@NotEmpty
	private String subjectName;
	
	/** The course id. */
	@NotNull
	private Long courseId;
	
	
	/** The course name. */
	private String courseName;

	
	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public BaseDTO getDto() {
		SubjectDTO dto=new SubjectDTO();
		dto.setId(id);
		if(courseId!=null)
		{
			dto.setCourseId(courseId);	
		}
		dto.setSubjectName(subjectName);
        
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		return dto;
}

	@Override
	public void populate(BaseDTO bDto) {
		SubjectDTO dto=(SubjectDTO) bDto;
		id=dto.getId();
		subjectName=dto.getSubjectName();
		courseId=dto.getCourseId();
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

	

