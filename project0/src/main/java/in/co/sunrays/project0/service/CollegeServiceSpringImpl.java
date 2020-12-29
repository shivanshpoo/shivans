package in.co.sunrays.project0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.project0.dao.CollegeDAOInt;
import in.co.sunrays.project0.dto.CollegeDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

/**
 * Session facade of College Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 */
@Service("collegeService")

public class CollegeServiceSpringImpl implements CollegeServiceInt {

	@Autowired
	private CollegeDAOInt dao;
	private static Logger log = Logger.getLogger(CollegeServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(CollegeDTO dto) throws DuplicateRecordException {
		log.debug("CollegeServiceSpringImpl Add Started");
		CollegeDTO dtoExist = dao.findByName(dto.getName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("College Name is already exist");
		}
		log.debug("CollegeServiceSpringImpl  Add End");
		return dao.add(dto);
	}

 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(CollegeDTO dto) throws DuplicateRecordException {
	 log.debug("CollegeServiceSpringImpl update Started");
		CollegeDTO dtoExist = dao.findByName(dto.getName());
		// Check if updated College is already exists
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate College Name");
		}
		dao.update(dto);
		log.debug("CollegeServiceSpringImpl  update End");
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		dao.delete(id);

	}

	@Transactional(readOnly = true)
	public CollegeDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public CollegeDTO findByPK(long id) {
		// TODO Auto-generated method stub
		return dao.findByPK(id);
	}

	@Transactional(readOnly = true)
	public List search(CollegeDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}

}
