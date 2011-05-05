package com.augmentum.training.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.augmentum.training.jdbc.Const;
import com.augmentum.training.jdbc.DataBaseManager;
import com.augmentum.training.entity.FieldInfo;
/**
 * Use<code>AccessControlServlet</code>to response the request of client.
 * Then according to the value of the "type" to switching to different process.
 * The primary process includes viewing all tables of the database, viewing 
 * the field and corresponding type, and committing the sql requested by
 * client.  
 * @author mason.xu
 * @version 1.0 2011/03/16
 * @see com.augmentum.training.jdbc.DataBaseManager
 */
public class AccessControlServlet extends HttpServlet {
	
	private DataBaseManager dm = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String type = req.getParameter(Const.TYPE);
		String tableName = req.getParameter(Const.TABLE_NAME);
		dm = new DataBaseManager();
		
		if (Const.DATA_BASE.equals(type)) {
			
			//Const.DATA_BASE means that viewing all tables of the database.
			dm.connectMysql();
			req.setAttribute(Const.DATA_BASE_MANAGER, dm);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/tables.jsp"); 
			dispatcher.forward(req, resp);
		} else if ((Const.VIEW.equals(type)) && (tableName != null)) {
			
			//Const.VIEW means that view the column information of specific table.
			List<FieldInfo> tableInfo = dm.viewTable(tableName);
			req.setAttribute(Const.TABLE_INFO, tableInfo);
			req.setAttribute(Const.TABLE_NAME, tableName);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/tableInfo.jsp"); 
			dispatcher.forward(req, resp);
		} else if ((Const.COMMIT).equals(type)) {
			String sqlString = req.getParameter(Const.SQL_STRING);
			List<Map<String,String>> result = dm.query(sqlString);
			String error = dm.getErrorType();
		
			//Set the reason of error.
			if ((result.size()==0) && (error != null)) {
				//only in the condition of null result and existing error.
				req.setAttribute(Const.ERROR_TYPE, error);
			}
			req.setAttribute(Const.RESULT, result);			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/query.jsp"); 
			dispatcher.forward(req, resp);
		}
	}

	@Override
	public void init() throws ServletException {
		try {
			Class.forName(Const.DRVIER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public DataBaseManager getDm() {
		return dm;
	}

	public void setDm(DataBaseManager dm) {
		this.dm = dm;
	}

	
	

	
}
