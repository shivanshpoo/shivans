package in.co.sunrays.project0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.project0.dto.CourseDTO;

/**
 * The Class CourseDAOHibImpl.
 */
@Repository(value = "courseDAO")
public class CourseDAOHibImpl implements CourseDAOInt {

	/** The log. */
	private static Logger log = Logger.getLogger(CourseDAOHibImpl.class);

	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory = null;

	public long add(CourseDTO dto) {
		log.debug("Course Dao Add Started");
		long pk = 0;
        pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("Course Dao Add End");
		return pk;
	}

	
	public void update(CourseDTO dto) {
		log.debug("Course Dao update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("Course Dao update End");
	}

	
	public void delete(long id) {
		log.debug("Course Dao delete Started");
		CourseDTO dto = findByPK(id);
        sessionfactory.getCurrentSession().delete(dto);
		log.debug("Course Dao delete End");
	}

	@Override
	public CourseDTO findByName(String name) {
		log.debug("Course Dao findByName Started");
		List list = sessionfactory.getCurrentSession().createCriteria(CourseDTO.class).add(Restrictions.eq("courseName",name)).list();
		CourseDTO dto = null;
        if (list.size() == 1) {
            dto = (CourseDTO) list.get(0);
        }
        log.debug("Course Dao findByName End");
        return dto;

	}

	@Override
	public CourseDTO findByPK(long pk) {
		log.debug("Course Dao findByPK Started");
		CourseDTO dto = (CourseDTO) sessionfactory.getCurrentSession().get(CourseDTO.class, pk);
		log.debug("Course Dao findByPK End");
		return dto;
	}

	@Override
	public List search(CourseDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);

	}

	@Override
	public List search(CourseDTO dto, int pageNo, int pageSize) {
		log.debug("Course Dao search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(CourseDTO.class);
		
		if(dto!=null)
		{
			
		
		
		
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }
        if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
            criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
        }
        if (dto.getDescription() != null  && dto.getDescription().length() > 0) {
        	
        	criteria.add(Restrictions.like("description", dto.getDescription() + "%"));
            
        }
        
		}
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult(((pageNo - 1) * pageSize));
            criteria.setMaxResults(pageSize);
        }
		
		log.debug("Course Dao search End");
		return criteria.list();
	}

	}


