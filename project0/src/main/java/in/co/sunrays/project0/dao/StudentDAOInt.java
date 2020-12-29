package in.co.sunrays.project0.dao;

import java.util.List;

import in.co.sunrays.project0.dto.StudentDTO;

public interface StudentDAOInt {
	/**
	 * Adds a Student.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(StudentDTO dto);

	/**
	 * Updates a Student.
	 *
	 * @param dto the dto
	 */
	public void update(StudentDTO dto);

	/**
	 * Deletes a Student.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds Student by Email.
	 *
	 * @param email the email
	 * @return the student DTO
	 */
	public StudentDTO findByEmail(String email);

	/**
	 * Finds Student by PK.
	 *
	 * @param pk the pk
	 * @return the student DTO
	 */
	public StudentDTO findByPK(long pk);

	/**
	 * Searches Students with pagination
	 * 
	 * return list : List of Students
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
	public List search(StudentDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Students
	 * 
	 * return list : List of Students
	 * param dto
	 *            : Search Parameters.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(StudentDTO dto);


}
