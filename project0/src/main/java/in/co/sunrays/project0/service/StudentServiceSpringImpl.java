package in.co.sunrays.project0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.project0.dao.StudentDAOInt;
import in.co.sunrays.project0.dto.StudentDTO;
import in.co.sunrays.project0.exception.ApplicationException;
import in.co.sunrays.project0.exception.DuplicateRecordException;

@Service(value = "studentService")
public class StudentServiceSpringImpl implements StudentServiceInt {

	@Autowired
	private StudentDAOInt dao;
	
	private static Logger log=Logger.getLogger(StudentServiceSpringImpl.class);

	
	public void setDao(StudentDAOInt dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(StudentDTO dto) throws DuplicateRecordException {
		log.debug("StudentServiceSpringImpl Add Started");
		StudentDTO dtoExist = dao.findByEmail(dto.getEmailId());
		if (dtoExist != null) 
		{
			throw new DuplicateRecordException("Student is already exist");
		}
		long pk = dao.add(dto);
		log.debug("StudentServiceSpringImpl  Add End");
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(StudentDTO dto) throws DuplicateRecordException, ApplicationException {
		log.debug("StudentServiceSpringImpl update Started");
		 dao.update(dto);
		log.debug("StudentServiceSpringImpl  update End");
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("StudentServiceSpringImpl delete Started");
		dao.delete(id);
		log.debug("StudentServiceSpringImpl  delete End");		
	}

	@Transactional(readOnly = true)
	public StudentDTO findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Transactional(readOnly = true)
	public StudentDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}

	@Transactional(readOnly = true)
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(StudentDTO dto) {
		return dao.search(dto, 0, 0);
	}

	
}
