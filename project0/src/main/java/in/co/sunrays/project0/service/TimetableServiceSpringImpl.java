package in.co.sunrays.project0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.project0.dao.TimetableDAOInt;
import in.co.sunrays.project0.dto.TimetableDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;

@Service("timetableService")
public class TimetableServiceSpringImpl implements TimetableServiceInt {

	@Autowired
	private TimetableDAOInt dao;

    private static Logger log = Logger.getLogger(TimetableServiceSpringImpl.class);

	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public long add(TimetableDTO dto) throws DuplicateRecordException {
		log.debug("TimetableServiceSpringImpl add started");
		try {
			if(dao.checkBySemester(dto)!=null){
				throw new DuplicateRecordException("Semester and course already Exist on date");
			}if(dao.checkByCourse(dto)!=null){
				throw new DuplicateRecordException("course already exist on this date");
			}if(dao.checkBySubject(dto)!=null){
				throw new DuplicateRecordException("subject for course already exist on this date");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		log.debug("TImetableServiceSpringImpl Add End");
		return dao.add(dto);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void update(TimetableDTO dto) throws DuplicateRecordException {
		log.debug("TImetableServiceSpringImpl update Started");
		if(dao.checkBySemester(dto)!=null){
			throw new DuplicateRecordException("Semester and course already Exist on date");
		}if(dao.checkByCourse(dto)!=null){
			throw new DuplicateRecordException("course already exist on this date");
		}if(dao.checkBySubject(dto)!=null){
			throw new DuplicateRecordException("subject for course already exist on this date");
		}
		dao.update(dto);
		log.debug("TImetableServiceSpringImpl update End");		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly= false)
	public void delete(long id) {
		log.debug("TImetableServiceSpringImpl delete Started");
		dao.delete(id);
		log.debug("TImetableServiceSpringImpl delete End");
		}

@Transactional(readOnly = true)
	public TimetableDTO findByPK(long id) {
	return dao.findByPK(id);

	}

@Transactional(readOnly = true)
	public List search(TimetableDTO dto) {
	return dao.search(dto);
	}

@Transactional(readOnly = true)
	public List search(TimetableDTO dto, int pageNo, int pageSize) {
	return dao.search(dto, pageNo, pageSize);
	}

}
