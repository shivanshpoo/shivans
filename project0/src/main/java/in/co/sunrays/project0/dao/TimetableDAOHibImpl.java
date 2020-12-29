package in.co.sunrays.project0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.project0.dto.TimetableDTO;

@Repository(value="timetableDAO")
public class TimetableDAOHibImpl implements TimetableDAOInt {

	/** The log. */
	private static Logger log = Logger.getLogger(TimetableDAOHibImpl.class);

	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory=null;
	
	/** The course dao. */
	@Autowired
	private CourseDAOInt courseDao;
	
	/** The subject dao. */
	@Autowired
	private SubjectDAOInt subjectDao;

	
	
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#add(in.co.sunrays.project0.dto.TimetableDTO)
	 */
	public long add(TimetableDTO dto) {
		log.debug("TImeTable Dao Add Started");
		
		long pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("TImeTable Dao Add End");
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#checkBySemester(in.co.sunrays.project0.dto.TimetableDTO)
	 */
	public TimetableDTO checkBySemester(TimetableDTO dto) {
/*		log.debug("TImeTable Dao checkBySemester Started");
		TimetableDTO dtoGet = null;
		Query q = sessionfactory.getCurrentSession().createQuery("from TimetableDTO where courseId=? and subjectId=? and semester=? and examDate=?");
		q.setLong(0, dto.getCourseId());
		q.setLong(1, dto.getSubjectId());
		q.setString(2, dto.getSemester());
		q.setDate(3, dto.getExamDate());
		List list = q.list();
		 if (list.size() > 0) {
	           dtoGet = (TimetableDTO) list.get(0);
	       } else {
	           dtoGet = null;
	    }*/
		 log.debug("TImeTable Dao checkBySemester End");
		 
		 System.out.println("incbs");
	       return null;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#checkByCourse(in.co.sunrays.project0.dto.TimetableDTO)
	 */
	public TimetableDTO checkByCourse(TimetableDTO dto) {
/*		log.debug("TImeTable Dao checkByCourse Started");
		TimetableDTO dtoGet = null;
		Query q = sessionfactory.getCurrentSession().createQuery("from TimetableDTO where courseId=? and examDate=?");
		q.setLong(0, dto.getCourseId());
		q.setDate(1, dto.getExamDate());
		List list = q.list();
		 if (list.size() > 0) {
	           dtoGet = (TimetableDTO) list.get(0);
	       } else {
	           dtoGet = null;
	    }
*/		 log.debug("TImeTable Dao checkByCourse End");
		 
		 System.out.println("incss");
	       return null;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#checkBySubject(in.co.sunrays.project0.dto.TimetableDTO)
	 */
	public TimetableDTO checkBySubject(TimetableDTO dto) {
		log.debug("TImeTable Dao checkBySubject Started");
		/*TimetableDTO dtoGet = null;
		Query q = sessionfactory.getCurrentSession().createQuery("from TimetableDTO where courseId=? and subjectId=? and examDate=?");
		q.setLong(0, dto.getCourseId());
		q.setLong(1, dto.getSubjectId());
		q.setDate(2, dto.getExamDate());
		List list = q.list();
		 if (list.size() > 0) {
	           dtoGet = (TimetableDTO) list.get(0);
	       } else {
	           dtoGet = null;
	    }*/
		 log.debug("TImeTable Dao checkBySubject End");
	       return null;
	}

	
	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#update(in.co.sunrays.project0.dto.TimetableDTO)
	 */
	public void update(TimetableDTO dto) {
		log.debug("TImeTable Dao update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("TImeTable Dao update End");
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#delete(long)
	 */
	public void delete(long id) {
		log.debug("TImeTable Dao delete Started");
		TimetableDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("TImeTable Dao delete End");
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#findByName(java.lang.String)
	 */
	public TimetableDTO findByName(String name) {
		log.debug("TImeTable Dao findByName Started");
		List list = sessionfactory.getCurrentSession().createCriteria(TimetableDTO.class).add(Restrictions.eq("name", name)).list();
		TimetableDTO dto = null;
		if (list.size() == 1) {
			dto = (TimetableDTO) list.get(0);
		}
		log.debug("TImeTable Dao findByName End");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#findByPK(long)
	 */
	public TimetableDTO findByPK(long pk) {
		log.debug("TImeTable Dao findByPK Started");
		TimetableDTO dto = (TimetableDTO) sessionfactory.getCurrentSession().get(TimetableDTO.class, pk);
		log.debug("TImeTable Dao findByPK End");
		return dto;
		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#search(in.co.sunrays.project0.dto.TimetableDTO)
	 */
	public List search(TimetableDTO dto) {
		return search(dto, 0, 0);
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.TimetableDAOInt#search(in.co.sunrays.project0.dto.TimetableDTO, int, int)
	 */
	public List search(TimetableDTO dto, int pageNo, int pageSize) {
		log.debug("TImeTable Dao findByPK Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(TimetableDTO.class);
		if(dto!=null)
		{
			
		
		
		if (dto.getId() > 0) {
			criteria.add(Restrictions.eq("id", dto.getId()));
		}
		if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
			criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
		}
		if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {

			criteria.add(Restrictions.eq("subjectId", dto.getSubjectId() ));

		}

		if (dto.getExamDate() != null && dto.getExamDate().getDate() > 0) {

			criteria.add(Restrictions.eq("examDate", dto.getExamDate()));

		}

		if (dto.getExamTime() != null) {

			criteria.add(Restrictions.like("examTime", dto.getExamTime() + "%"));

		}

		}
		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult(((pageNo - 1) * pageSize));
			criteria.setMaxResults(pageSize);
		}

		 List list = criteria.list();		
		log.debug("TImeTable Dao findByPK End");
		return list;
	}
}
