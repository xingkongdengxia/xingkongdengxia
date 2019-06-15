package com.weiyi.entity.pojo;

import java.io.Serializable;

public class Weiyiuser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;//id
	private String param_name;//用户名
	private String param_value;//密码
	private String power;//权限
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParam_name() {
		return param_name;
	}
	public void setParam_name(String param_name) {
		this.param_name = param_name;
	}
	public String getParam_value() {
		return param_value;
	}
	public void setParam_value(String param_value) {
		this.param_value = param_value;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "Weiyiuser [id=" + id + ", param_name=" + param_name
				+ ", param_value=" + param_value + ", power=" + power + "]";
	}
	
	
	
	
}
