package in.co.sunrays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;
import in.co.sunrays.project0.dto.RoleDTO;

public class RoleForm extends BaseForm {

	/** The name. */
	@NotEmpty
	private String name;

	/** The description. */
	@NotEmpty
	private String description;


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDto() {
		RoleDTO dto = new RoleDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setDescription(description);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
        return dto;

	}

	@Override
	public void populate(BaseDTO bDto) {
        RoleDTO dto = (RoleDTO) bDto;

        id = dto.getId();
        name = dto.getName();
        description = dto.getDescription();
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


