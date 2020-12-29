package in.co.sunrays.project0.dao;

import java.util.List;

import in.co.sunrays.project0.dto.TimetableDTO;

public interface TimetableDAOInt {

	/**
	 * Adds a Timetable
	 * 
	 * param dto
	 *
	 */
	public long add(TimetableDTO dto);
	
	/**
	 * checkBySemester a Timetable
	 * 
	 * param dto
	 *
	 */
	public TimetableDTO checkBySemester(TimetableDTO dto);
	
	/**
	 * checkByCourse a Timetable
	 * 
	 * param dto
	 *
	 */
	public TimetableDTO checkByCourse(TimetableDTO dto);
	
	/**
	 * checkByCourse a Timetable
	 * 
	 * param dto
	 *
	 */
	public TimetableDTO checkBySubject(TimetableDTO dto);
	
	/**
	 * Updates a Timetable
	 * 
	 * param dto
	 *
	 */
	public void update(TimetableDTO dto);

	/**
	 * Deletes a Timetable
	 * 
	 * param id
	 *
	 */
	public void delete(long id);

	/**
	 * Finds Timetable by Name
	 * 
	 * param name
	 *            : get parameter
	 * return dto
	 *
	 */
	public TimetableDTO findByName(String name);

	/**
	 * Finds Timetable by PK
	 * 
	 * param pk
	 *            : get parameter
	 * return dto
	 *
	 */
	public TimetableDTO findByPK(long pk);

	/**
	 * Searches Timetables
	 * 
	 * return list : List of Timetables
	 * param dto
	 *            : Search Parameters
	 *
	 */
	public List search(TimetableDTO dto);

	/**
	 * Searches Timetables with pagination
	 * 
	 * return list : List of Timetables
	 * param dto
	 *            : Search Parameters
	 * param pageNo
	 *            : Current Page No.
	 * param pageSize
	 *            : Size of Page
	 *
	 */
	public List search(TimetableDTO dto, int pageNo, int pageSize);
	

}
