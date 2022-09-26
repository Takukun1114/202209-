package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "attendance")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "weekday")
	private String weekday;
	@Column(name = "d_date")
	private String d_date;
	@Column(name = "starttime")
	private String starttime;
	@Column(name = "endtime")
	private String endtime;
	@Column(name = "resttime")
	private String resttime;
	@Column(name = "workovertime")
	private String workovertime;
	@Column(name = "workcontent")
	private String workcontent;
	@Column(name = "workstate")
	private String workstate;
	@Column(name = "application")
	private String application;
	@Column(name = "application_state")
	private String application_state;
	@Column(name = "administrator")
	private String administrator;
	@Column(name = "remark")
	private String remark;
	
	public User() {
		super();
	}

	
	public User(int id,String weekday,String d_date,String starttime,
			String endtime,String resttime,String workovertime,
			String workcontent,String workstate,String application
			,String application_state,String administrator,String remark){
		
		this.id = id;
		this.weekday = weekday;
		this.d_date = d_date;
		this.starttime = starttime;
		this.endtime = endtime;
		this.resttime = resttime;
		this.workovertime = workovertime;
		this.workcontent = workcontent;
		this.workstate = workstate;
		this.application =application;
		this.application_state = application_state;
		this.administrator = administrator;
		this.remark = remark;
		
	}
	
	
}
	


