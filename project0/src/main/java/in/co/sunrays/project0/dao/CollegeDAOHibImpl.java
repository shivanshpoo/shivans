package in.co.sunrays.project0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.project0.dto.CollegeDTO;

/**
 * The Class CollegeDAOHibImpl.
 */

@Repository("collegeDAO")
public class CollegeDAOHibImpl implements CollegeDAOInt {

	/** The log. */
	private static Logger log = Logger.getLogger(CollegeDAOHibImpl.class);

	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.co.sunrays.project0.dao.CollegeDAOInt#add(in.co.sunrays.project0.dto.
	 * CollegeDTO)
	 */
	public long add(CollegeDTO dto) {
		log.debug("College Dao Add Started");
		long pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("College Dao Add End");
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.CollegeDAOInt#update(in.co.sunrays.project0.dto.CollegeDTO)
	 */
	public void update(CollegeDTO dto) {
		log.debug("college DAO update started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("college DAO Update end");

	}

	@Override
	public void delete(long id) {
		log.debug("College Dao delete Started");
CollegeDTO dto=findByPK(id);
sessionfactory.getCurrentSession().delete(dto);
log.debug("college DAO deleted end");
	}

	@Override
	public CollegeDTO findByName(String name) {
		log.debug("College Dao findByName Started");
		CollegeDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(CollegeDTO.class).add(Restrictions.eq("name", name)).list();
		if (list.size() == 1) {
            dto = (CollegeDTO) list.get(0);
	}
		log.debug("College Dao findByName End");
		return dto;
	}

		
	@Override
	public CollegeDTO findByPK(long pk) {
		log.debug("College Dao findByPK Started");
		CollegeDTO dto = (CollegeDTO) sessionfactory.getCurrentSession().get(CollegeDTO.class, pk);
		log.debug("College Dao findByPK End");
		return dto;
	}

	@Override
	public List search(CollegeDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		log.debug("College Dao search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(CollegeDTO.class);
		
		if(dto!=null)
		{

		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }
        if (dto.getName() != null && dto.getName().length() > 0) {
            criteria.add(Restrictions.like("name", dto.getName() + "%"));
        }
        if (dto.getAddress() != null && dto.getAddress().length() > 0) {
            criteria.add(Restrictions.like("address", dto.getAddress() + "%"));
        }
        if (dto.getState() != null && dto.getState().length() > 0) {
            criteria.add(Restrictions.like("state", dto.getState() + "%"));
        }
        if (dto.getCity() != null && dto.getCity().length() > 0) {
            criteria.add(Restrictions.like("city", dto.getCity() + "%"));
        }

		}
     // if page size is greater than zero then apply pagination
        if (pageSize > 0) {
        	criteria.setFirstResult((pageNo - 1) * pageSize);
        	criteria.setMaxResults(pageSize);
        }
		log.debug("College Dao search End");
		return criteria.list();
	}
	}


