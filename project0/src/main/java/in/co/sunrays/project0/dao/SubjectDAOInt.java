package in.co.sunrays.project0.dao;

import java.util.List;

import in.co.sunrays.project0.dto.SubjectDTO;

public interface SubjectDAOInt {

	/**
	 * Adds a Subject
	 * 
	 * param dto.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(SubjectDTO dto);

	/**
	 * Updates a Subject
	 * 
	 * param dto.
	 *
	 * @param dto the dto
	 */
	public void update(SubjectDTO dto);

	/**
	 * Deletes a Subject
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds Subject by Name
	 * 
	 * param name
	 *            : get parameter
	 * return dto.
	 *
	 * @param name the name
	 * @return the subject DTO
	 */
	public SubjectDTO findByName(String name);

	/**
	 * Finds Subject by PK
	 * 
	 * param pk
	 *            : get parameter
	 * return dto.
	 *
	 * @param pk the pk
	 * @return the subject DTO
	 */
	public SubjectDTO findByPK(long pk);

	/**
	 * Searches Subjects
	 * 
	 * return list : List of Subjects
	 * param dto
	 *            : Search Parameters.
	 *
	 * @param dto the dto
	 * @return the list
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
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize);

}
