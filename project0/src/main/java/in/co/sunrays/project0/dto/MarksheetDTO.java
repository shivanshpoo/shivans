package in.co.sunrays.project0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class MarksheetDTO.
 */
@Entity
@Table(name = "ST_MARKSHEET")
public class MarksheetDTO extends BaseDTO{

    /** Rollno of Student. */
    @Column(name = "ROLL_NO", length = 20)
	  private String rollNo;
	   
 	  /** ID of Student. */
      @Column(name = "STUDENT_ID")
	    private long studentId;
	    
  	/** Name of Student. */
	    @Column(name = "NAME", length =50)    
	    private String name;
	    
  	/** Physics marks of Student. */
	    @Column(name = "PHYSICS" )
	    private Integer physics;
	    
  	/** Chemistry marks of Student. */
	    @Column(name = "CHEMISTRY")
	    private Integer chemistry;
	    
  	/** Mathematics marks of Student. */
	    @Column(name = "MATHS")
	    private Integer maths;

	    
	
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
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
	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dto.DropdownList#getKey()
	 */
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dto.DropdownList#getValue()
	 */
	public String getValue() {
		// TODO Auto-generated method stub
		return rollNo;
	}

}
