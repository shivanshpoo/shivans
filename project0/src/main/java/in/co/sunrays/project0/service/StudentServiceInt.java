package in.co.sunrays.project0.service;

import java.util.List;

import in.co.sunrays.project0.dto.StudentDTO;
import in.co.sunrays.project0.exception.ApplicationException;
import in.co.sunrays.project0.exception.DuplicateRecordException;

public interface StudentServiceInt {

	/**
	 * Adds a Student
	 * 
	 * param dto
	 * return
	 */
	public long add(StudentDTO dto)throws DuplicateRecordException;

	/**
	 * Updates a Student
	 * 
	 * param dto
	 * return
	 */
	public void update(StudentDTO dto) throws DuplicateRecordException,ApplicationException;

	/**
	 * Deletes a Student
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds Student by Email
	 * 
	 * param email
	 * return
	 */
	public StudentDTO findByEmail(String email);

	/**
	 * Finds Student by PK
	 * 
	 * param pk
	 * return
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
	 */
	public List search(StudentDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Students
	 * 
	 * return list : List of Students
	 * param dto
	 *            : Search Parameters
	 */
	public List search(StudentDTO dto);

}
