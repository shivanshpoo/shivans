package in.co.sunrays.project0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.project0.dto.CollegeDTO;
import in.co.sunrays.project0.dto.StudentDTO;

@Repository(value="studentDAO")
public class StudentDAOHibImpl implements StudentDAOInt {


	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory=null;
	
	/** The cdao. */
	@Autowired
	CollegeDAOInt cdao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(StudentDAOHibImpl.class);

	
	@Override
	public long add(StudentDTO dto) {
		log.debug("student Dao Add Started");
		CollegeDTO cdto=cdao.findByPK(dto.getCollegeId());
		dto.setCollegeName(cdto.getName());
		long pk=0;
		pk=(Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("student Dao Add End");
		return pk;
	}

	@Override
	public void update(StudentDTO dto) {
		log.debug("Student Dao Update Started");
		
		CollegeDTO cdto = cdao.findByPK(dto.getCollegeId());
		dto.setCollegeName(cdto.getName());
		sessionfactory.getCurrentSession().update(dto);
		log.debug("Student Dao Update End");
	}

	@Override
	public void delete(long id) {
		log.debug("Student Dao delete Started");
		StudentDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("Student Dao delete End");
	}

	@Override
	public StudentDTO findByEmail(String email) {
		log.debug("Student Dao findByEmail Started");
		StudentDTO dto=null;
		List list = sessionfactory.getCurrentSession().createCriteria(StudentDTO.class).add(Restrictions.eq("EmailId",email)).list();
		if (list.size() == 1) {
            dto = (StudentDTO) list.get(0);
        }
		log.debug("Student Dao findByEmail End");
        return dto;
	}

	@Override
	public StudentDTO findByPK(long pk) {
		log.debug("Student Dao findByPK Started");
		StudentDTO dto = (StudentDTO) sessionfactory.getCurrentSession().get(StudentDTO.class, pk);
		log.debug("Student Dao findByPK End");
		return dto;
	}

	@Override
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		log.debug("Student Dao search Started");
		List list = null;
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(StudentDTO.class);
		
		if(dto!=null)
		{
			
		
		
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }
        if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
            criteria.add(Restrictions.like("firstName", dto.getFirstName()
                    + "%"));
        }
        if (dto.getLastName() != null && dto.getLastName().length() > 0) {
            criteria.add(Restrictions.like("lastName", dto.getLastName()
                    + "%"));
        }
        if (dto.getDob() != null && dto.getDob().getDate() > 0) {
            criteria.add(Restrictions.eq("dob", dto.getDob()));
        }
        if (dto.getEmailId() != null && dto.getEmailId().length() > 0) {
            criteria.add(Restrictions.like("email", dto.getEmailId()
                    + "%"));
        }
        if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
            criteria.add(Restrictions.like("mobileNo", dto.getMobileNo()
                    + "%"));
        }
        if(dto.getCollegeName()!= null && dto.getCollegeName().length() > 0){
    		criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
    	}
        
        
		}
     // if page size is greater than zero the apply pagination
        if (pageSize > 0) {

            criteria.setFirstResult((pageNo - 1) * pageSize);
            criteria.setMaxResults(pageSize);
        }
        list = criteria.list();
        log.debug("Student Dao search End");
		return list;
	}

	@Override
	public List search(StudentDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

}
