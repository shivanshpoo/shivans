package in.co.sunrays.project0.dao;

import java.util.List;

import in.co.sunrays.project0.dto.CourseDTO;

/**
 * The Interface CourseDAOInt.
 */

public interface CourseDAOInt {
	/**
	 * Adds a Course
	 * 
	 * param dto.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(CourseDTO dto);

	/**
	 * Updates a Course
	 * 
	 * param dto.
	 *
	 * @param dto the dto
	 */
	public void update(CourseDTO dto);

	/**
	 * Deletes a Course
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds Course by Name
	 * 
	 * param name
	 *            : get parameter
	 * return dto.
	 *
	 * @param name the name
	 * @return the course DTO
	 */
	public CourseDTO findByName(String name);

	/**
	 * Finds Course by PK
	 * 
	 * param pk
	 *            : get parameter
	 * return dto.
	 *
	 * @param pk the pk
	 * @return the course DTO
	 */
	public CourseDTO findByPK(long pk);

	/**
	 * Searches Courses
	 * 
	 * return list : List of Courses
	 * param dto
	 *            : Search Parameters.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(CourseDTO dto);

	/**
	 * Searches Courses with pagination
	 * 
	 * return list : List of Courses
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
	public List search(CourseDTO dto, int pageNo, int pageSize);

	
}
