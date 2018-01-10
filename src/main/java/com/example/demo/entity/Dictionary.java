package com.example.demo.entity;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;
import java.util.Date;

public class Dictionary extends Model<Dictionary> {

	private static final long serialVersionUID = 1L;

	@TableId
	private Integer systemid;
	private String kind;
	private String code;
	private String detail;
	private String detail2;

	@Override
	protected Serializable pkVal() {
    	return this.systemid;
	}
	public Integer getSystemid(){
		return this.systemid;
	}

	public void setSystemid(Integer systemid){
		this.systemid = systemid;
	}

	public String getKind(){
		return this.kind;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getCode(){
		return this.code;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getDetail(){
		return this.detail;
	}

	public void setDetail(String detail){
		this.detail = detail;
	}

	public String getDetail2(){
		return this.detail2;
	}

	public void setDetail2(String detail2){
		this.detail2 = detail2;
	}

}

