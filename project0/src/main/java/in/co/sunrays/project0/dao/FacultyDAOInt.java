package in.co.sunrays.project0.dao;

import java.util.List;

import in.co.sunrays.project0.dto.FacultyDTO;

public interface FacultyDAOInt {

	/**
	 * Adds a Faculty.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(FacultyDTO dto);

	/**
	 * Updates a Faculty.
	 *
	 * @param dto the dto
	 */
	public void update(FacultyDTO dto);

	/**
	 * Deletes a Faculty.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds Faculty by Email.
	 *
	 * @param email the email
	 * @return the faculty DTO
	 */
	public FacultyDTO findByEmail(String email);

	/**
	 * Finds Faculty by PK.
	 *
	 * @param pk the pk
	 * @return the faculty DTO
	 */
	public FacultyDTO findByPK(long pk);

	/**
	 * Searches Facultys with pagination
	 * 
	 * return list : List of Facultys
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
	public List search(FacultyDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Facultys
	 * 
	 * return list : List of Facultys
	 * param dto
	 *            : Search Parameters.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(FacultyDTO dto);

}
