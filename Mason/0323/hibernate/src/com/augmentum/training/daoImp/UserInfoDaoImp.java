package com.augmentum.training.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.augmentum.training.dao.UserInfoDao;
import com.augmentum.training.model.UserInfo;
import com.augmentum.training.util.HibernateUtil;
/**
 * 
 * @author mason.xu
 *
 */
public class UserInfoDaoImp implements UserInfoDao {

	@Override
	public void delete(UserInfo userInfo) throws Exception {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
	    session.delete(userInfo);
	    transaction.commit();
	}

	@Override
	public UserInfo get(Integer id) throws Exception {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
	    UserInfo userInfo = (UserInfo) session.get(UserInfo.class, id);
	      
	    return userInfo;
	}

	@Override
	public List<UserInfo> listAll() throws Exception {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		List<UserInfo> list = session.createQuery("FROM UserInfo").list();
		
		return list;
	}

	@Override
	public void saveOrUpdate(UserInfo userInfo) throws Exception {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(userInfo);
		transaction.commit();
	}

}
