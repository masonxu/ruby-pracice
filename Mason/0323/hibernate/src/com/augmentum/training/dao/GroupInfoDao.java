package com.augmentum.training.dao;

import java.util.List;
import com.augmentum.training.model.GroupInfo;
/**
 * The interface is used to defining the role in operating 
 * the Groupinfo.
 * @author mason.xu
 * @version 1.0 2011/03/23
 */
public interface GroupInfoDao {
	 /**
     * Get groupinfo by giving id.
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public GroupInfo get(Integer id) throws Exception;

    /**
     * List all role.
     * 
     * @return
     * @throws Exception
     */
    public List<GroupInfo> listAll() throws Exception;

    /**
     * Save or Update new groupinfo.
     * 
     * @param department
     * @throws Exception
     */
    public void saveOrUpdate(GroupInfo groupinfo) throws Exception;

    /**
     * Delete giving groupinfo.
     * 
     * @param department
     * @throws Exception
     */
    public void delete(GroupInfo groupinfo) throws Exception;
}
