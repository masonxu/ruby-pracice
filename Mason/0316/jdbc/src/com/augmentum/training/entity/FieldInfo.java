package com.augmentum.training.entity;

/**
 * Use<code>FieldInfo</code> to store the basic information
 * of one field.
 * @author mason.xu
 * @version 1.0 2011/03/17
 */
public class FieldInfo {
	private String columnName;
	private String typeName;
	private String remarks;

	public FieldInfo() {
		super();
	}
	
	public FieldInfo(String columnName, String typeName, String remarks) {
		super();
		this.columnName = columnName;
		this.typeName = typeName;
		this.remarks = remarks;
	}
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
