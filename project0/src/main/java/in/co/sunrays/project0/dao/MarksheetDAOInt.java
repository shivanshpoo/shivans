package in.co.sunrays.project0.dao;

import java.util.List;

import in.co.sunrays.project0.dto.MarksheetDTO;

public interface MarksheetDAOInt {

	/**
	 * Adds a Marksheet.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(MarksheetDTO dto);

	/**
	 * Updates a Marksheet.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 */
	public void update(MarksheetDTO dto);

	/**
	 * Deletes a Marksheet.
	 * 
	 * param id
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds Marskheet by Roll No.
	 * 
	 * param rollNo
	 * return
	 *
	 * @param rollNo the roll no
	 * @return the marksheet DTO
	 */
	public MarksheetDTO findByRollNo(String rollNo);

	/**
	 * Finds Marksheet by Primary Key.
	 * 
	 * param pk
	 * return
	 *
	 * @param pk the pk
	 * @return the marksheet DTO
	 */
	public MarksheetDTO findByPK(long pk);

	/**
	 * Searches Marskheet.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(MarksheetDTO dto);

	/**
	 * Searches Marskheet with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize);

	/**
	 * Gets Merit List.
	 * 
	 * param pageNo
	 * param pageSize
	 * return
	 *
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the merit list
	 */
	public List getMeritList(int pageNo, int pageSize);

}
