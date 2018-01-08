package com.example.demo.entity;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;
import java.util.Date;

public class User extends Model<User> {

	private static final long serialVersionUID = 1L;

	@TableId
	private String username;
	private String password;
	private Integer ac;
	private Integer wa;
	private Integer rank;
	private String img;
	private String role;
	private Date createtime;
	private String vip;
	private String autograph;

	@Override
	protected Serializable pkVal() {
    	return this.username;
	}
	public String getUsername(){
		return this.username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Integer getAc(){
		return this.ac;
	}

	public void setAc(Integer ac){
		this.ac = ac;
	}

	public Integer getWa(){
		return this.wa;
	}

	public void setWa(Integer wa){
		this.wa = wa;
	}

	public Integer getRank(){
		return this.rank;
	}

	public void setRank(Integer rank){
		this.rank = rank;
	}

	public String getImg(){
		return this.img;
	}

	public void setImg(String img){
		this.img = img;
	}

	public String getRole(){
		return this.role;
	}

	public void setRole(String role){
		this.role = role;
	}

	public Date getCreatetime(){
		return this.createtime;
	}

	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}

	public String getVip(){
		return this.vip;
	}

	public void setVip(String vip){
		this.vip = vip;
	}

	public String getAutograph(){
		return this.autograph;
	}

	public void setAutograph(String autograph){
		this.autograph = autograph;
	}

}

