package in.co.sunrays.project0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class CollegeDTO.
 */
@Entity
@Table(name = "ST_COLLEGE")
public class CollegeDTO extends BaseDTO{

	/** Name of College. */
	@Column(name = "NAME", length =255)
	private String name;

	/** Address of College. */
	@Column(name = "ADDRESS", length =255)
	private String address;

	/** State of College. */
	@Column(name = "STATE", length =255)
	private String state;

	/** City of College. */
	@Column(name = "CITY", length =255)
	private String city;

	/** Phoneno of College. */
	@Column(name = "PHONE_NO", length =255)
	private String phoneNo;


	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
		return name;
	}

}
