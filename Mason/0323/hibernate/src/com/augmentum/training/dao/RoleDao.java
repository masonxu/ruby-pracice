package com.augmentum.training.dao;

import java.util.List;
import com.augmentum.training.model.Role;
/**
 * The interface is used to defining the role in operating 
 * the Role.
 * @author mason.xu
 * @version 1.0 2011/03/23
 */
public interface RoleDao {
	 /**
     * Get Role by giving id.
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public Role get(Integer id) throws Exception;

    /**
     * List all role.
     * 
     * @return
     * @throws Exception
     */
    public List<Role> listAll() throws Exception;

    /**
     * Create new role, or update a data.
     * 
     * @param department
     * @throws Exception
     */
    public void saveOrUpdate(Role role) throws Exception;

    /**
     * Delete giving role.
     * 
     * @param department
     * @throws Exception
     */
    public void delete(Role role) throws Exception;
}
