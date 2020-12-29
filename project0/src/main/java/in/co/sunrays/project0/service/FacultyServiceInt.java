package in.co.sunrays.project0.service;

import java.util.List;

import in.co.sunrays.project0.dto.FacultyDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

public interface FacultyServiceInt {

	/**
	 * Adds a Faculty
	 * 
	 * param dto
	 * return
	 */
	public long add(FacultyDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Faculty
	 * 
	 * param dto
	 * return
	 */
	public void update(FacultyDTO dto);

	/**
	 * Deletes a Faculty
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds Faculty by Email
	 * 
	 * param email
	 * return
	 */
	public FacultyDTO findByEmail(String email);

	/**
	 * Finds Faculty by PK
	 * 
	 * param pk
	 * return
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
	 */
	public List search(FacultyDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Facultys
	 * 
	 * return list : List of Facultys
	 * param dto
	 *            : Search Parameters
	 */
	public List search(FacultyDTO dto);


}
