package in.co.sunrays.project0.service;

import java.util.List;

import in.co.sunrays.project0.dto.CourseDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

public interface CourseServiceInt {
	/**
	 * Adds a Course
	 * 
	 * param dto throws ApplicationException throws DuplicateRecordException :
	 * throws when Course is already exists
	 */
	public long add(CourseDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Course
	 * 
	 * param dto throws ApplicationException throws DuplicateRecordException :
	 * throws when updated Course is already exists
	 */
	public void update(CourseDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Course
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds Course by Name
	 * 
	 * param name : get parameter return dto
	 */
	public CourseDTO findByName(String name);

	/**
	 * Finds Course by primary key
	 * 
	 * param name : get parameter return dto
	 */
	public CourseDTO findByPK(long id);

	/**
	 * Searches Courses
	 * 
	 * return list : List of Courses param dto : Search Parameters
	 */
	public List search(CourseDTO dto);

	/**
	 * Searches Courses with pagination
	 * 
	 * return list : List of Courses param dto : Search Parameters param pageNo
	 * : Current Page No. param pageSize : Size of Page
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize);

}
