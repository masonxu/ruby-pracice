/**
 * 
 */
package com.augmentum.training.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.augmentum.training.daoImp.GroupInfoDaoImp;
import com.augmentum.training.daoImp.RoleDaoImp;
import com.augmentum.training.model.GroupInfo;
import com.augmentum.training.model.Role;

/**
 * @author mason.xu
 *
 */
public class GroupInfoDaoTest {

	private  GroupInfoDaoImp groupInfoDaoImp = null;
	private  GroupInfo groupInfo = null;
	
	@Before
	public void setUp() throws Exception {
		groupInfoDaoImp = new GroupInfoDaoImp();
		groupInfo = new GroupInfo();
		groupInfo.setGroupType("admin");
		groupInfoDaoImp.saveOrUpdate(groupInfo);
	}

	/**
	 * Test method for {@link com.augmentum.training.daoImp.GroupInfoDaoImp#get(java.lang.Integer)}.
	 */
	@Test
	public void testGet() throws Exception {
		GroupInfo temp = groupInfoDaoImp.get(groupInfo.getGroupId());
		Assert.assertEquals(temp, groupInfo);	
	}
	
	/**
	 * Test method for {@link com.augmentum.training.daoImp.GroupInfoDaoImp#save(com.augmentum.training.model.GroupInfo)}.
	 */
	@Test
	public void testSaveOrUpdate() throws Exception {
		groupInfo.setGroupType("admin");
		groupInfoDaoImp.saveOrUpdate(groupInfo);
		Assert.assertNotNull(groupInfo.getGroupId());
	}
	/**
	 * Test method for {@link com.augmentum.training.daoImp.GroupInfoDaoImp#listAll()}.
	 */
	@Test
	public void testListAll() throws Exception {
		List<GroupInfo> groupInfoList = groupInfoDaoImp.listAll();
		Assert.assertNotNull(groupInfoList);
		Assert.assertTrue(groupInfoList.size() > 0);
	}


	/**
	 * Test method for {@link com.augmentum.training.daoImp.GroupInfoDaoImp#delete(com.augmentum.training.model.GroupInfo)}.
	 */
	@Test
	public void testDelete() throws Exception {
		groupInfoDaoImp.delete(groupInfo);
		GroupInfo temp = groupInfoDaoImp.get(groupInfo.getGroupId());
		assertNull(temp);
	}
	@After
	public void tearDown() throws Exception {
		groupInfoDaoImp = null;
		groupInfo = null;
	}
}
