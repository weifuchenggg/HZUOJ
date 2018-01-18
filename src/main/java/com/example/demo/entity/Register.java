package com.example.demo.entity;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;
import java.util.Date;

public class Register extends Model<Register> {

	private static final long serialVersionUID = 1L;

	@TableId
	private String systemid;
	private String competname;
	private String username;
	private Integer ac;
	private Integer error;
	private Integer time;

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

	public String getUsername(){
		return this.username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public Integer getAc(){
		return this.ac;
	}

	public void setAc(Integer ac){
		this.ac = ac;
	}

	public Integer getError(){
		return this.error;
	}

	public void setError(Integer error){
		this.error = error;
	}

	public Integer getTime(){
		return this.time;
	}

	public void setTime(Integer time){
		this.time = time;
	}

}

