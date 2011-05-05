package com.augmentum.training.dao;

import java.util.List;
import com.augmentum.training.model.UserInfo;
/**
 * The interface is used to defining the role in operating 
 * the userinfo.
 * @author mason.xu
 * @version 1.0 2011/03/23
 */
public interface UserInfoDao {
	 /**
     * Get userinfo by giving id.
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfo get(Integer id) throws Exception;

    /**
     * List all userinfo.
     * 
     * @return
     * @throws Exception
     */
    public List<UserInfo> listAll() throws Exception;

    /**
     * Save new userInfo, or Update an userInfo.
     * 
     * @param department
     * @throws Exception
     */
    public void saveOrUpdate(UserInfo userInfo) throws Exception;

    /**
     * Delete giving userinfo.
     * 
     * @param department
     * @throws Exception
     */
    public void delete(UserInfo userInfo) throws Exception;
    
}
