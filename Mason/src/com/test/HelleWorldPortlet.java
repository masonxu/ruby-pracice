package com.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.portal.common.Portlet;
import com.portal.common.http.ActionRequest;
import com.portal.common.http.ActionResponse;
import com.portal.common.util.Constant;
import com.portal.common.util.TimeUtil;
import com.portal.dao.PortletDao;
import com.portal.dao.PortletDaoImp;
import com.portal.dao.WorkItemsDao;
import com.portal.dao.WorkItemsDaoImp;
import com.portal.entity.WorkItem;

public class HelleWorldPortlet extends Portlet{
	private PortletDao portletDao = new PortletDaoImp();
	private com.portal.entity.Portlet portlet = this.portletDao.getPortlet(
				Constant.DEFAULT_USER_ID, Constant.PORTAL_NAME, Constant.PORTLET_NAME);
	
    @Override
    public Map<String, Object> doClose(ActionRequest request, ActionResponse response) {
    	this.portlet.setWindowStates(Constant.COLSE_STATUS); 	
    	this.portletDao.setPortletById(portlet);
    	return doView(request, response);
    }

    @Override
    public Map<String, Object> doEdit(ActionRequest request, ActionResponse response) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "zack.liu");
        return map;
    }

    @Override
    public Map<String, Object> doMax(ActionRequest request, ActionResponse response) {
    	this.portlet.setWindowStates(Constant.MAX_STATUS); 	
    	this.portletDao.setPortletById(portlet);
    	return doView(request, response);
    }

    @Override
    public Map<String, Object> doMin(ActionRequest request, ActionResponse response) {
    	this.portlet.setWindowStates(Constant.MIN_STATUS); 	
    	this.portletDao.setPortletById(portlet);
    	return doView(request, response);
    }

    @Override
    public Map<String, Object> doSave(ActionRequest request, ActionResponse response) {
    	int pageNum = Integer.parseInt((String) request.getParameter("pageNumber"));
    	this.portlet.setPageNum(pageNum);
    	this.portletDao.setPortletById(portlet);
    	return doView(request, response);
    }

    @Override
    public Map<String, Object> doView(ActionRequest request, ActionResponse response) {  	
    	Map<String, Object> result = new HashMap<String,Object>();
    
    	if ((portlet != null) && portlet.getPageNum()>0) {
    		/**
    		 *  Only the field of pageNum of the portlet is bigger than zero,
    		 *  the portlet could show the items.
    		 */
    		WorkItemsDao workItemsDao = new WorkItemsDaoImp();   	
    		List<WorkItem> list = workItemsDao.queryWorkItemsByUserId(
    								Constant.DEFAULT_USER_ID, portlet.getPageNum());   	
	    	if ((list != null ) && (list.size() >0)) {
	    		List<String> itemTitleList = new ArrayList<String>();
	    		List<String> timeList = new ArrayList<String>();
	    		String time = null;
	    		String title = null;
	    		
	    		for (WorkItem workItem : list) {
	    			title = workItem.getTitle();
	    			time = TimeUtil.getDay(workItem.getCreateTime()); 	  			
	    			itemTitleList.add(title);
	    			timeList.add(time);
	    		}
	    		
	    		result.put("itemTitleList", itemTitleList);
	    		result.put("timeList", timeList);
	    		result.put("windowStates", portlet.getWindowStates());
	    	}// the inner if end
	    }//the outer if end
    	
    	return result;
    		
    }
    
 
}
