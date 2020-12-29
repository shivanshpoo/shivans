package in.co.sunrays.project0.service;

import java.util.List;

import in.co.sunrays.project0.dto.TimetableDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

public interface TimetableServiceInt {

	/**
	 * Adds a Timetable
	 * 
	 * param dto
	 * throws ApplicationException
	 * throws DuplicateRecordException
	 *             : throws when Timetable is already exists
	 */
	public long add(TimetableDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Timetable
	 * 
	 * param dto
	 * throws ApplicationException
	 * throws DuplicateRecordException
	 *             : throws when updated Timetable is already exists
	 */
	public void update(TimetableDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Timetable
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds Timetable by primary key
	 * 
	 * param name
	 *            : get parameter
	 * return dto
	 */
	public TimetableDTO findByPK(long id);

	/**
	 * Searches Timetables
	 * 
	 * return list : List of Timetables
	 * param dto
	 *            : Search Parameters
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
	 */
	public List search(TimetableDTO dto, int pageNo, int pageSize);


}
