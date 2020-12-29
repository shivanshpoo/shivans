package in.co.sunrays.project0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.project0.dao.SubjectDAOInt;
import in.co.sunrays.project0.dto.SubjectDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

/**
 * Session facade of Subject Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author Iterator
 * @version 1.0
 * Copyright (c) Iterator
 */

@Service("subjectService")
public class SubjectServiceSpringImpl implements SubjectServiceInt {

	@Autowired
	private SubjectDAOInt dao;

	
	private static Logger log = Logger.getLogger(SubjectServiceSpringImpl.class);

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(SubjectDTO dto) throws DuplicateRecordException {
		log.debug("SubjectServiceSpringImpl Add Started");
		SubjectDTO dtoExist = dao.findByName(dto.getSubjectName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Subject Name is already exist");
		}
		log.debug("SubjectServiceSpringImpl  Add End");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(SubjectDTO dto) throws DuplicateRecordException {
		log.debug("SubjectServiceSpringImpl update Started");
		SubjectDTO dtoExist = dao.findByName(dto.getSubjectName());
		// Check if updated Subject is already exists
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate Name in update method");
		}
		dao.update(dto);
		log.debug("SubjectServiceSpringImpl  update End");		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("SubjectServiceSpringImpl delete Started");
		dao.delete(id);
		log.debug("SubjectServiceSpringImpl  delete End");
	}

	@Transactional(readOnly = true)
	public SubjectDTO findByName(String name) {
		return dao.findByName(name);

	}

	@Transactional(readOnly = true)	
	public SubjectDTO findByPK(long id) {
		return dao.findByPK(id);
	}

	@Transactional(readOnly = true)	
	public List search(SubjectDTO dto) {
		return dao.search(dto);
	}

	@Transactional(readOnly = true)	
	public List search(SubjectDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	
}
