package com.augmentum.training.test;

import static org.junit.Assert.*;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.augmentum.training.daoImp.UserInfoDaoImp;
import com.augmentum.training.model.UserInfo;

/**
 * @author mason.xu
 *
 */
public class UserInfoTest {
	private static UserInfoDaoImp userInfoDaoImp = null;
	private  UserInfo userInfo = null;
	
	@Before
	public void setUp() throws Exception {
		userInfoDaoImp = new UserInfoDaoImp();
		userInfo = new UserInfo();
		userInfo.setUsername("Mason Xu");
		userInfoDaoImp.saveOrUpdate(userInfo);
	}
	
	/**
	 * Test method for {@link com.augmentum.training.daoImp.UserInfoDaoImp#get(com.augmentum.training.model.UserInfo)}.
	 */
	@Test
	public void testGet() throws Exception {
		UserInfo tempUser = userInfoDaoImp.get(userInfo.getUserId());
		Assert.assertEquals(tempUser, userInfo);
	}
	
	/**
	 * Test method for {@link com.augmentum.training.daoImp.UserInfoDaoImp#Save(java.lang.Integer)}.
	 * @throws Exception 
	 * @throws Exception 
	 */
	@Test
	public void testSave() throws Exception {
		userInfo.setUsername("ddddd");
		userInfoDaoImp.saveOrUpdate(userInfo);
		Assert.assertNotNull(userInfo.getUserId());
	}
	
	/**
	 * Test method for {@link com.augmentum.training.daoImp.UserInfoDaoImp#lsitAll(com.augmentum.training.model.UserInfo)}.
	 */
	@Test
	public void testListAll() throws Exception {
		List<UserInfo> userList = userInfoDaoImp.listAll();
		Assert.assertNotNull(userList);
		Assert.assertTrue(userList.size() > 0);
	}

	/**
	 * Test method for {@link com.augmentum.training.daoImp.UserInfoDaoImp#delete(com.augmentum.training.model.UserInfo)}.
	 */
	@Test
	public void testDelete() throws Exception {
		userInfoDaoImp.delete(userInfo);
		UserInfo tempUser = userInfoDaoImp.get(userInfo.getUserId());
		assertNull(tempUser);	
	}

	@After
	public void tearDown() throws Exception {
		userInfoDaoImp = null;
		userInfo = null;
	}
}
