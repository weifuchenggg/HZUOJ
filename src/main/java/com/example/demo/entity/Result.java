package com.example.demo.entity;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;
import java.util.Date;

public class Result extends Model<Result> {

	private static final long serialVersionUID = 1L;

	@TableId
	private String systemid;
	private Integer num;
	private String user;
	private String state;
	private Date createtime;
	private String language;
	private String content;
	private String type;
	private String competname;
	private String bm;

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

	public Integer getNum(){
		return this.num;
	}

	public void setNum(Integer num){
		this.num = num;
	}

	public String getUser(){
		return this.user;
	}

	public void setUser(String user){
		this.user = user;
	}

	public String getState(){
		return this.state;
	}

	public void setState(String state){
		this.state = state;
	}

	public Date getCreatetime(){
		return this.createtime;
	}

	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}

	public String getLanguage(){
		return this.language;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getContent(){
		return this.content;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getCompetname() {
		return competname;
	}

	public void setCompetname(String competname) {
		this.competname = competname;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	@Override
	public String toString() {
		return "Result{" +
				"systemid='" + systemid + '\'' +
				", num=" + num +
				", user='" + user + '\'' +
				", state='" + state + '\'' +
				", createtime=" + createtime +
				", language='" + language + '\'' +
				", content='" + content + '\'' +
				", type='" + type + '\'' +
				", competname='" + competname + '\'' +
				", bm='" + bm + '\'' +
				'}';
	}
}

