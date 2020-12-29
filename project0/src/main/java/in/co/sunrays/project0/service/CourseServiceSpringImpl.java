package in.co.sunrays.project0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.project0.dao.CourseDAOInt;
import in.co.sunrays.project0.dto.CourseDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

/**
 * Session facade of Course Service. It is transactional, apply delcarative
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

@Service("courseService")
public class CourseServiceSpringImpl implements CourseServiceInt {

	@Autowired
	private CourseDAOInt dao;
	
    private static Logger log = Logger.getLogger(UserServiceSpringImpl.class);


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(CourseDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl Add Started");
		CourseDTO dtoExist = dao.findByName(dto.getCourseName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Course Name is already exist");
		}
		log.debug("CourseServiceSpringImpl  Add End");
		return dao.add(dto);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(CourseDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl update Started");
		CourseDTO dtoExist = dao.findByName(dto.getCourseName());
		// Check if updated Course is already exists
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate course Name");
		}
		
		dao.update(dto);
		log.debug("CourseServiceSpringImpl update End");		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("CourseServiceSpringImpl delete Started");
		dao.delete(id);
		log.debug("CourseServiceSpringImpl delete End");	
	}

	@Transactional(readOnly = true)
	public CourseDTO findByName(String name) {
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public CourseDTO findByPK(long id) {
		// TODO Auto-generated method stub
		return dao.findByPK(id);
	}

	@Transactional(readOnly = true)
	public List search(CourseDTO dto) {
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(CourseDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	
}
