package in.co.sunrays.project0.dao;

import java.util.List;

import in.co.sunrays.project0.dto.CollegeDTO;

/**
 * The Interface CollegeDAOInt.
 */

public interface CollegeDAOInt {
	
	/**
	 * Adds a College
	 * 
	 * param dto.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(CollegeDTO dto);

	/**
	 * Updates a College
	 * 
	 * param dto.
	 *
	 * @param dto the dto
	 */
	public void update(CollegeDTO dto);

	/**
	 * Deletes a College
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds College by Name
	 * 
	 * param name
	 *            : get parameter
	 * return dto.
	 *
	 * @param name the name
	 * @return the college DTO
	 */
	public CollegeDTO findByName(String name);

	/**
	 * Finds College by PK
	 * 
	 * param pk
	 *            : get parameter
	 * return dto.
	 *
	 * @param pk the pk
	 * @return the college DTO
	 */
	public CollegeDTO findByPK(long pk);

	/**
	 * Searches Colleges
	 * 
	 * return list : List of Colleges
	 * param dto
	 *            : Search Parameters.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(CollegeDTO dto);

	/**
	 * Searches Colleges with pagination
	 * 
	 * return list : List of Colleges
	 * param dto
	 *            : Search Parameters
	 * param pageNo
	 *            : Current Page No.
	 * param pageSize
	 *            : Size of Page
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize);

	
}
