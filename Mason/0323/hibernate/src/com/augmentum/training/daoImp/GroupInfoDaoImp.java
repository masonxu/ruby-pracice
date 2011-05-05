package com.augmentum.training.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.augmentum.training.dao.GroupInfoDao;
import com.augmentum.training.model.GroupInfo;
import com.augmentum.training.model.UserInfo;
import com.augmentum.training.util.HibernateUtil;

public class GroupInfoDaoImp implements GroupInfoDao {

	@Override
	public void delete(GroupInfo groupinfo) throws Exception {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
	    session.delete(groupinfo);
	    transaction.commit();
	}

	@Override
	public GroupInfo get(Integer id) throws Exception {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		GroupInfo groupInfo = (GroupInfo) session.get(GroupInfo.class, id);

		return groupInfo;
	}

	@Override
	public List<GroupInfo> listAll() throws Exception {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		List<GroupInfo> list = session.createQuery("FROM GroupInfo").list();
		
		return list;
	}

	@Override
	public void saveOrUpdate(GroupInfo groupinfo) throws Exception {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(groupinfo);
		transaction.commit();
	}

}
