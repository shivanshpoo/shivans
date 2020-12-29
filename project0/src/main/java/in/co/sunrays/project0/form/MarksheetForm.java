package in.co.sunrays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;
import in.co.sunrays.project0.dto.MarksheetDTO;

public class MarksheetForm extends BaseForm{

	/** The roll no. */
	@NotEmpty
	private String rollNo;
	
	/** The student id. */
	@NotNull
	private Long studentId;
	 
	 /** The name. */
 	private String name;
	 
	 
	 /** The physics. */
 	@NotNull
	 private Integer physics;
	 
	 
	 
	 /** The chemistry. */
 	@NotNull
	 private Integer chemistry;
	
	 
	 
	 /** The maths. */
 	@NotNull
	 private Integer maths;
	


 	
	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	@Override
	public BaseDTO getDto() {
		MarksheetDTO dto=new MarksheetDTO();
		dto.setId(id);
		dto.setRollNo(rollNo);
		if(studentId!=null)
		{
	     dto.setStudentId(studentId);	
		}
		dto.setName(name);
		dto.setMaths(maths);
		dto.setChemistry(chemistry);
		dto.setPhysics(physics);
		dto.setCreatedBy(createdBy);
	    dto.setModifiedBy(modifiedBy);
	    dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		MarksheetDTO dto=(MarksheetDTO) bDto;
		id=dto.getId();
		rollNo=dto.getRollNo();
		studentId=dto.getStudentId();
		name=dto.getName();
		maths=dto.getMaths();
		chemistry=dto.getChemistry();
		physics=dto.getPhysics();
		createdBy=dto.getCreatedBy();
	   	modifiedBy=dto.getModifiedBy();
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

	

