package in.co.sunrays.project0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.project0.dto.FacultyDTO;

/**
 * The Class FacultyDAOHibImpl.
 */

@Repository(value = "facultyDAO")
public class FacultyDAOHibImpl implements FacultyDAOInt {

	/** The log. */
	private static Logger log = Logger.getLogger(FacultyDAOHibImpl.class);

	/** The college dao. */
	@Autowired
	CollegeDAOInt collegeDao;

	/** The course dao. */
	@Autowired
	CourseDAOInt courseDao;

	/** The subject dao. */
	@Autowired
	SubjectDAOInt subjectDao;

	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory = null;

	@Override
	public long add(FacultyDTO dto) {
		log.debug("FacultyDAO add Started");
		long pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("FacultyDAO add End");
		return pk;
	}

	@Override
	public void update(FacultyDTO dto) {
		log.debug("FacultyDAO update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("FacultyDAO update End");
	}

	@Override
	public void delete(long id) {
		log.debug("FacultyDAO delete Started");
		FacultyDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("FacultyDAO delete End");
	
	}

	@Override
	public FacultyDTO findByEmail(String email) {
		log.debug("FacultyDAO findByEmail Started");
		FacultyDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(FacultyDTO.class)
				.add(Restrictions.eq("loginId", email)).list();
		if (list.size() == 1) {
			dto = (FacultyDTO) list.get(0);
		}
		log.debug("FacultyDAO findByEmail End");
		return dto;
	}

	@Override
	public FacultyDTO findByPK(long pk) {
		log.debug("FacultyDAO findByPK Started");
		FacultyDTO dto = (FacultyDTO) sessionfactory.getCurrentSession().get(FacultyDTO.class, pk);
		log.debug("FacultyDAO findByPK End");
		return dto;

	}

	@Override
	public List search(FacultyDTO dto, int pageNo, int pageSize) {
		log.debug("FacultyDAO search Started");
		List list = null;
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(FacultyDTO.class);
		
		if(dto!=null)
		{
		if (dto.getId() > 0) {
			criteria.add(Restrictions.eq("id", dto.getId()));
		}
		if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
			criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
		}
		if (dto.getLastName() != null && dto.getLastName().length() > 0) {

			criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));

		}

		if (dto.getDoj() != null && dto.getDoj().getDate() > 0) {

			criteria.add(Restrictions.like("doj", dto.getDoj() + "%"));

		}

		if (dto.getLoginId() != null && dto.getLoginId().length() > 0) {

			criteria.add(Restrictions.like("loginId", dto.getLoginId() + "%"));

		}

		if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {

			criteria.add(Restrictions.like("mobileNo", dto.getMobileNo() + "%"));

		}

		if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {

			criteria.add(Restrictions.like("courseId", dto.getCourseId() + "%"));

		}

		if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {

			criteria.add(Restrictions.like("subjectId", dto.getSubjectId() + "%"));

		}

		if (dto.getCollegeName() != null && dto.getCollegeName().length() > 0) {

			criteria.add(Restrictions.like("collegeId", dto.getCollegeId() + "%"));

		}
		
		}

		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult(((pageNo - 1) * pageSize));
			criteria.setMaxResults(pageSize);
		}
		list = criteria.list();

		log.debug("FacultyDAO search End");
		return list;
	}

	@Override
	public List search(FacultyDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	
}
