package in.co.sunrays.project0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.project0.dto.CourseDTO;
import in.co.sunrays.project0.dto.SubjectDTO;
import in.co.sunrays.project0.service.SubjectServiceInt;

/**
 * The Class SubjectDAOHibImpl.
 */
@Repository(value="subjectDAO")
public class SubjectDAOHibImpl implements SubjectDAOInt  {

	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory=null;
	
	
	/** The course dao. */
	@Autowired
	private CourseDAOInt courseDao;

	/** The log. */
	private static Logger log = Logger.getLogger(SubjectDAOHibImpl.class);

	@Override
	public long add(SubjectDTO dto) {
		log.debug("SubjectDAO add Started");
		System.out.println("santosh......................****");
		CourseDTO cdto=courseDao.findByPK(dto.getCourseId());
		System.out.println("dattttttttttttttt................_"+cdto.getCourseName());
		dto.setCourseName(cdto.getCourseName());
		long pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("SubjectDAO add End");
		return pk;

	}

	@Override
	public void update(SubjectDTO dto) {
		log.debug("SubjectDAO update Started");
		dto.setCourseName(courseDao.findByPK(dto.getCourseId()).getCourseName());
		sessionfactory.getCurrentSession().update(dto);
		log.debug("SubjectDAO update End");
	
	}

	@Override
	public void delete(long id) {
		log.debug("SubjectDAO delete Started");
		SubjectDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("SubjectDAO delete End");
	}

	@Override
	public SubjectDTO findByName(String name) {
		log.debug("SubjectDAO findByName Started");
		List list =sessionfactory.getCurrentSession().createCriteria(SubjectDTO.class).add(Restrictions.eq("subjectName", name)).list(); 
		SubjectDTO dto = null;
		if (list.size() == 1) {
			dto = (SubjectDTO) list.get(0);
		}		
		log.debug("SubjectDAO findByName End");
		return dto;
	}

	@Override
	public SubjectDTO findByPK(long pk) {
		log.debug("SubjectDAO findByPK Started");
		SubjectDTO dto = (SubjectDTO) sessionfactory.getCurrentSession().get(SubjectDTO.class, pk);
		log.debug("SubjectDAO findByPK End");
		return dto;
	}

	@Override
	public List search(SubjectDTO dto) {
		return search(dto, 0, 0);

	}

	@Override
	public List search(SubjectDTO dto, int pageNo, int pageSize) {
		log.debug("SubjectDAO search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(SubjectDTO.class);
		if(dto!=null)
		{
		
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }
        if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
            criteria.add(Restrictions.like("subjectName", dto.getSubjectName() + "%"));
        }
        
        if (dto.getCourseName() != null  && dto.getCourseName().length() > 0) {
        	
        	criteria.add(Restrictions.like("courseId", dto.getCourseId()));
            
        }
        
		}
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult(((pageNo - 1) * pageSize));
            criteria.setMaxResults(pageSize);
        }

		log.debug("SubjectDAO search End");
		return criteria.list();
	}
	}



