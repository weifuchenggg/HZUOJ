package com.example.demo.entity;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;
import java.util.Date;

public class Role extends Model<Role> {

	private static final long serialVersionUID = 1L;

	@TableId
	private Integer rid;
	private String rname;

	@Override
	protected Serializable pkVal() {
    	return this.rid;
	}
	public Integer getRid(){
		return this.rid;
	}

	public void setRid(Integer rid){
		this.rid = rid;
	}

	public String getRname(){
		return this.rname;
	}

	public void setRname(String rname){
		this.rname = rname;
	}

}

