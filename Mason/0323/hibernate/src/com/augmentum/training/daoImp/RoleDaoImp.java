package com.augmentum.training.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.augmentum.training.dao.RoleDao;
import com.augmentum.training.model.GroupInfo;
import com.augmentum.training.model.Role;
import com.augmentum.training.model.UserInfo;
import com.augmentum.training.util.HibernateUtil;

public class RoleDaoImp implements RoleDao {

	@Override
	public void delete(Role role) throws Exception {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
	    session.delete(role);
	    transaction.commit();
	}

	@Override
	public Role get(Integer id) throws Exception {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Role role = (Role) session.get(Role.class, id);
	      
	    return role;
	}

	@Override
	public List<Role> listAll() throws Exception {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		List<Role> list = session.createQuery("FROM Role").list();
		
		return list;
	}

	@Override
	public void saveOrUpdate(Role role) throws Exception {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(role);
		transaction.commit();
	}

}
