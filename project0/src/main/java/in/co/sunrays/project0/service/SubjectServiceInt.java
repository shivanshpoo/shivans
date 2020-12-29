package in.co.sunrays.project0.service;

import java.util.List;

import in.co.sunrays.project0.dto.SubjectDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

public interface SubjectServiceInt {

	/**
	 * Adds a Subject
	 * 
	 * param dto
	 * throws ApplicationException
	 * throws DuplicateRecordException
	 *             : throws when Subject is already exists
	 */
	public long add(SubjectDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Subject
	 * 
	 * param dto
	 * throws ApplicationException
	 * throws DuplicateRecordException
	 *             : throws when updated Subject is already exists
	 */
	public void update(SubjectDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Subject
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds Subject by Name
	 * 
	 * param name
	 *            : get parameter
	 * return dto
	 */
	public SubjectDTO findByName(String name);

	/**
	 * Finds Subject by primary key
	 * 
	 * param name
	 *            : get parameter
	 * return dto
	 */
	public SubjectDTO findByPK(long id);

	/**
	 * Searches Subjects
	 * 
	 * return list : List of Subjects
	 * param dto
	 *            : Search Parameters
	 */
	public List search(SubjectDTO dto);

	/**
	 * Searches Subjects with pagination
	 * 
	 * return list : List of Subjects
	 * param dto
	 *            : Search Parameters
	 * param pageNo
	 *            : Current Page No.
	 * param pageSize
	 *            : Size of Page
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize);


}
