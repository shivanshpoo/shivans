package in.co.sunrays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;
import in.co.sunrays.project0.dto.CourseDTO;

public class CourseForm extends BaseForm {

	/** The course name. */
	@NotEmpty
	private String courseName;
	
	/** The description. */
	@NotEmpty
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

	@Override
	public BaseDTO getDto() {
		CourseDTO dto=new CourseDTO();
    	dto.setId(id);
    	dto.setCourseName(courseName);
        dto.setDescription(description);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
    	return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		 CourseDTO dto=(CourseDTO) bDto;
	  	  id=dto.getId();
	  	  courseName=dto.getCourseName();
	  	  description=dto.getDescription();
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

	

