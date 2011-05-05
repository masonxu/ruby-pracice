package com.augmentum.training.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.augmentum.training.entity.FieldInfo;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
/**
 * Use <code>DatabaseManager</code> to manager the database,
 * including connection,read,write,update,delete and so on. 
 * @author mason.xu
 * 
 */
public class DataBaseManager {

	private static Connection con = null;
	private static Statement stmt = null;
	
	private String errorType = null;
	//Store the name of tables in the specific database.
	private  List<String> tableList = new ArrayList<String>();

	/**
	 * Initialize the connection and statement.
	 * @return boolean 
	 */
	public  boolean init() {
		try {
			con = DriverManager.getConnection(Const.URL,
									Const.USER, Const.PASSWORD);
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Close the statement and connection.
	 */
	public void destroy() {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Used to connect database, then query the tables in the database.
	 * @return boolean.
	 */
	public  boolean connectMysql() {
		ResultSet rs = null;
		String sql = "show tables";
		if (init()) {
			try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					this.tableList.add(rs.getString(Const.TABLE_NAME_COLUMN));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				destroy();
			}
		} else {
			return false;
		}		
		
		return true;
	}
	
	/**
	 * Collect the column definition of one table.
	 * @param tableName
	 * @return 
	 */
	public List<FieldInfo> viewTable(String tableName) {
		ResultSet columnSet = null;		
		List<FieldInfo> fieldList = new ArrayList<FieldInfo>();
			
		if (init()) {
			try {
				DatabaseMetaData dataBaseMetaData = con.getMetaData();
				columnSet = dataBaseMetaData.getColumns(null, "%", tableName, "%");
				String columnName = null;
				String columnType = null;
				String remark = null;
				while (columnSet.next()) {					
					columnName = columnSet.getString(Const.COLUMN_NAME);
					columnType = columnSet.getString(Const.TYPE_NAME);
					remark = columnSet.getString(Const.REMARKS);
					fieldList.add(new FieldInfo(columnName,columnType,remark));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				destroy();
			}
		} 
		
		return fieldList;	
	}
	
	/**
	 * Implement the query operation.
	 * @param sqlString
	 * @return the list of result. And the result is a map,whose key is column name,
	 * 		   the value is corresponding value. 
	 */
	public  List<Map<String,String>> query(String sqlString) {
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		int numberOfColumns;
		
		//Use rowDataList for storing the rows of result of query.
		List<Map<String,String>> rowDataList = new ArrayList<Map<String,String>>();
		Map<String,String> dataMap = null;
		String columnName;
		String value;
		if (init()) {
			try {
				rs = stmt.executeQuery(sqlString);
				while (rs.next()) {
					rsmd = (ResultSetMetaData) rs.getMetaData();
					numberOfColumns = rsmd.getColumnCount();
					dataMap = new HashMap<String,String>();
					
					/**
					 * Traversing one row result, and putting the field and value
					 * into dataMap.
					 */
					for(int i = 1; i <= numberOfColumns; i++) {
						columnName = rsmd.getColumnName(i);
						value = rs.getString(i);
						dataMap.put(columnName,value);
					}
					rowDataList.add(dataMap);
				} //end while
			} catch (SQLException e) {
				System.out.println("ERROR------------------------" + e.getMessage());
				this.setErrorType("SQL is erroneous!");
				return rowDataList;
			} finally {
				destroy();
			}
		} 
	   return rowDataList;
	}
	
	public List<String> getTableList() {
		return tableList;
	}

	public void setTableList(List<String> tableList) {
		this.tableList = tableList;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	
}
