package in.co.sunrays.project0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.project0.dto.RoleDTO;

@Repository("roleDAO")
public class RoleDAOHibImpl implements RoleDAOInt {

	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory = null;

	/** The log. */
	private static Logger log = Logger.getLogger(RoleDAOHibImpl.class);

	@Override
	public long add(RoleDTO dto) {
		log.debug("Role Dao Add Started");
		long pk = 0;
		try {
			pk = (Long) sessionfactory.getCurrentSession().save(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.debug("Role Dao Add End");
		return pk;
	}

	@Override
	public void update(RoleDTO dto) {
		log.debug("Role Dao Update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("Role Dao Update End");
	}

	@Override
	public void delete(long id) {
		log.debug("Role Dao Delete Started");
		RoleDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("Role Dao Delete End");

	}

	@Override
	public RoleDTO findByName(String roleName) {
		log.debug("Role DAO Find by Name Started");
		RoleDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(RoleDTO.class)
				.add(Restrictions.eq("name", roleName)).list();
		if (list.size() == 1) {
			dto = (RoleDTO) list.get(0);
		}
		log.debug("Role DAO Find by Name Ended");
		return dto;
	}

	@Override
	public RoleDTO findByPK(long pk) {
		log.debug("RoleDAO Find by PK Started");
		RoleDTO dto = null;
		dto = (RoleDTO) sessionfactory.getCurrentSession().get(RoleDTO.class, pk);
		log.debug("RoleDAO Find by PK Ended");
		return dto;
	}

	@Override
	public List search(RoleDTO dto, int pageNo, int pageSize) {
		log.debug("Role DAO search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(RoleDTO.class);
		if (dto != null) {

			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (dto.getDescription() != null && dto.getDescription().length() > 0) {
				criteria.add(Restrictions.like("description", dto.getDescription() + "%"));
			}
		}
		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult(((pageNo - 1) * pageSize));
			criteria.setMaxResults(pageSize);
		}
		List list = criteria.list();
		log.debug("Role DAO search End");
		return list;
	}

	@Override
	public List search(RoleDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);

	}

}
