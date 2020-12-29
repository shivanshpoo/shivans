package in.co.sunrays.project0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.project0.dao.FacultyDAOInt;
import in.co.sunrays.project0.dto.FacultyDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

/**
 * Session facade of Faculty Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction is rolled
 * back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author Iterator
 * @version 1.0
 * Copyright (c) Iterator
 */

@Service(value = "facultyService")
public class FacultyServiceSpringImpl implements FacultyServiceInt {

	private static Logger log=Logger.getLogger(UserServiceSpringImpl.class);
	
	@Autowired
	private FacultyDAOInt dao;

	public void setDao(FacultyDAOInt dao) {
		this.dao = dao;
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(FacultyDTO dto) throws DuplicateRecordException {
		log.debug("FacultyServiceSpringImpl Add Started");
		FacultyDTO dtoExist = dao.findByEmail(dto.getLoginId());
		if (dtoExist != null) 
		{
			throw new DuplicateRecordException("Login Id is already exist");
		}
		long pk = dao.add(dto);
		log.debug("FacultyServiceSpringImpl  Add End");
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(FacultyDTO dto) {
		log.debug("FacultyServiceSpringImpl update Started");
	    dao.update(dto);
	    log.debug("FacultyServiceSpringImpl  update End");		
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("FacultyServiceSpringImpl delete Started");
		dao.delete(id);
		log.debug("FacultyServiceSpringImpl  delete End");
	}

	@Transactional(readOnly = true)
	public FacultyDTO findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Transactional(readOnly = true)
	public FacultyDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}

	@Transactional(readOnly = true)
	public List search(FacultyDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(FacultyDTO dto) {
		return dao.search(dto, 0, 0);
	}

}
