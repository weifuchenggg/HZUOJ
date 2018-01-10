package com.example.demo.entity;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;
import java.util.Date;

public class Competition extends Model<Competition> {

	private static final long serialVersionUID = 1L;

	@TableId
	private String systemid;
	private String competname;
	private String author;
	private Date starttime;
	private Date endtime;
	private Integer count;
	private Integer registercount;
	@TableField(exist = false)
	private String register;

	@Override
	protected Serializable pkVal() {
    	return this.systemid;
	}
	public String getSystemid(){
		return this.systemid;
	}

	public void setSystemid(String systemid){
		this.systemid = systemid;
	}

	public String getCompetname(){
		return this.competname;
	}

	public void setCompetname(String competname){
		this.competname = competname;
	}

	public String getAuthor(){
		return this.author;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public Date getStarttime(){
		return this.starttime;
	}

	public void setStarttime(Date starttime){
		this.starttime = starttime;
	}

	public Date getEndtime(){
		return this.endtime;
	}

	public void setEndtime(Date endtime){
		this.endtime = endtime;
	}

	public Integer getCount(){
		return this.count;
	}

	public void setCount(Integer count){
		this.count = count;
	}

	public Integer getRegistercount(){
		return this.registercount;
	}

	public void setRegistercount(Integer registercount){
		this.registercount = registercount;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}
}

