package in.co.sunrays.project0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class RoleDTO.
 */
@Entity
@Table(name = "ST_ROLE")
public class RoleDTO extends BaseDTO {

	/** Predefined Role constants. */

	public static final int ADMIN = 1;

	/** The Constant STUDENT. */
	public static final int STUDENT = 2;

	/** The Constant FACULTY. */
	public static final int FACULTY = 3;

	/** The Constant KIOSK. */
	public static final int KIOSK = 4;

	/** The Constant College. */
	public static final int College = 5;

	/** Role Name. */
	@Column(name = "NAME", length = 255)
	private String name;

	/** Role Description. */
	@Column(name = "DESCRIPTION", length = 255)
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
		return name;
	}


}
