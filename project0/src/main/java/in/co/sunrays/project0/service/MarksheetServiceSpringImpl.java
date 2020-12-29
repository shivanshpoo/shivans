package in.co.sunrays.project0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.project0.dao.MarksheetDAOInt;
import in.co.sunrays.project0.dto.MarksheetDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

@Service("marksheetService")
public class MarksheetServiceSpringImpl implements MarksheetServiceInt{

	private static Logger log=Logger.getLogger(MarksheetServiceSpringImpl.class);
	
	@Autowired
	private MarksheetDAOInt dao = null;

	@Autowired
	private StudentServiceInt student = null;

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl Add Started");
		MarksheetDTO dtoExist = dao.findByRollNo(dto.getRollNo());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Duplicate ROllno in Marksheet");
		}
		dto.setName(student.findByPK(dto.getStudentId()).getFirstName()+" "+student.findByPK(dto.getStudentId()).getLastName());
		log.debug("MarksheetServiceSpringImpl Add End");
		return dao.add(dto);
	}

	@Transactional(propagation =Propagation.REQUIRED, readOnly = false)
	public void update(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl update Started");
		MarksheetDTO dtoExist = findByRollNo(dto.getRollNo());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate Marksheet in update Method");
		}
		 dao.update(dto);
		log.debug("MarksheetServiceSpringImpl update End");		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("MarksheetServiceSpringImpl delete Started");
		dao.delete(id);
		log.debug("MarksheetServiceSpringImpl delete End");
		
	}

	@Transactional(readOnly = true)
	public MarksheetDTO findByRollNo(String rollNo) {
		return dao.findByRollNo(rollNo);
	}

	@Transactional(readOnly = true)
	public MarksheetDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}

	@Transactional(readOnly = true)
	public List search(MarksheetDTO dto) {
		
		return dao.search(dto, 0, 0);
	}

	@Transactional(readOnly = true)
	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List getMeritList(int pageNo, int pageSize) {
		
		return dao.getMeritList(pageNo, pageSize);
	}

}
