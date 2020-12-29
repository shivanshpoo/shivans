package in.co.sunrays.project0.service;

import java.util.List;

import in.co.sunrays.project0.dto.MarksheetDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

public interface MarksheetServiceInt {

	/**
     * Adds a marksheet
     * 
     * param dto
     * return
     */
    public long add(MarksheetDTO dto) throws DuplicateRecordException;

    /**
     * updates Marksheet
     * 
     * param dto
     * return
     */
    public void update(MarksheetDTO dto) throws DuplicateRecordException;

    /**
     * Delets marksheet
     * 
     * param id
     */
    public void delete(long id);

    /**
     * Finds marksheet by Roll No
     * 
     * param rollNo
     * return
     */
    public MarksheetDTO findByRollNo(String rollNo);

    /**
     * Finds Marksheet by PK
     * 
     * param pk
     * return
     */
    public MarksheetDTO findByPK(long pk);

    /**
     * Searches markhseet
     * 
     * param dto
     * return
     */
    public List search(MarksheetDTO dto);

    /**
     * Searches marksheet with pagination
     * 
     * param dto
     * param pageNo
     * param pageSize
     * return
     */
    public List search(MarksheetDTO dto, int pageNo, int pageSize);

    /**
     * Get merit list
     * 
     * param pageNo
     * param pageSize
     * return
     */
    public List getMeritList(int pageNo, int pageSize);

}
