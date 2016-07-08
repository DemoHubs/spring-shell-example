package com.upsoft.utils;

import java.util.Map;

public class ConditionResult {
	private String sql;
	private Map<String, Object> paramsMap;
	private Object[] paramsArray;
	public ConditionResult() {
		super();
	}

	public ConditionResult(String sql, Map<String, Object> params) {
		super();
		this.sql = sql;
		this.paramsMap = params;
	}
	public ConditionResult(String sql,Object[] paramsArray) {
		super();
		this.sql = sql;
		this.paramsArray = paramsArray;
	}
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

	public Object[] getParamsArray() {
		return paramsArray;
	}

	public void setParamsArray(Object[] paramsArray) {
		this.paramsArray = paramsArray;
	}
}