package com.augmentum.training.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.augmentum.training.daoImp.RoleDaoImp;
import com.augmentum.training.model.Role;
/**
 * @author mason.xu
 *
 */
public class RoleDaoTest {
	
	private static RoleDaoImp roleDaoImp = null;
	private  Role role = null;
	
	@Before
	public void setUp() throws Exception {
		roleDaoImp = new RoleDaoImp();
		role = new Role();
		role.setRoleType("open the first door.");
		roleDaoImp.saveOrUpdate(role);
	}

	/**
	 * Test method for {@link com.augmentum.training.daoImp.RoleDaoImp#get(java.lang.Integer)}.
	 * @throws Exception 
	 */
	@Test
	public void testGet() throws Exception {
		Role temp = roleDaoImp.get(role.getRoleId());
		Assert.assertEquals(temp, role);	
	}
	/**
	 * Test method for {@link com.augmentum.training.daoImp.RoleDaoImp#save(com.augmentum.training.model.Role)}.
	 * @throws Exception 
	 */
	@Test
	public void testSave() throws Exception {
		role.setRoleType("open the seconde door");
		roleDaoImp.saveOrUpdate(role);
		Assert.assertNotNull(role.getRoleId());
	}
	/**
	 * Test method for {@link com.augmentum.training.daoImp.RoleDaoImp#listAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testListAll() throws Exception {
		List<Role> roleList = roleDaoImp.listAll();
		Assert.assertNotNull(roleList);
		Assert.assertTrue(roleList.size() > 0);
	}

	/**
	 * Test method for {@link com.augmentum.training.daoImp.RoleDaoImp#delete(com.augmentum.training.model.Role)}.
	 * @throws Exception 
	 */
	@Test
	public void testDelete() throws Exception {
		roleDaoImp.delete(role);
		Role temp = roleDaoImp.get(role.getRoleId());
		assertNull(temp);
	}

	@After
	public void tearDown() throws Exception {
		roleDaoImp = null;
		role = null;
	}
}
