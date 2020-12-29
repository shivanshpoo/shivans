package in.co.sunrays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;
import in.co.sunrays.project0.dto.CollegeDTO;

public class CollegeForm extends BaseForm {

	
	/** The name. */
	@NotEmpty
	private String name;
	
	/** The address. */
	@NotEmpty
	private String address;
	
	/** The state. */
	@NotEmpty
	private String state;
	
	/** The city. */
	@NotEmpty
	private String city;

	/** The phone no. */
	@NotEmpty
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

	
	
	@Override
	public BaseDTO getDto() {
		  CollegeDTO dto = new CollegeDTO();
	        dto.setId(id);
	        dto.setName(name);
	        dto.setAddress(address);
	        dto.setCity(city);
	        dto.setState(state);
	        dto.setPhoneNo(phoneNo);
	        dto.setCreatedBy(createdBy);
	        dto.setModifiedBy(modifiedBy);
	        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
	        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
	        return dto;

	}

	@Override
	public void populate(BaseDTO bDto) {
        CollegeDTO dto = (CollegeDTO) bDto;
        id = dto.getId();
        name = dto.getName();
        address = dto.getAddress();
        city = dto.getCity();
        state = dto.getState();
        phoneNo = dto.getPhoneNo();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        createdDatetime = dto.getCreatedDateTime().getTime();
        modifiedDatetime = dto.getModifiedDateTime().getTime();
	}

	
}
