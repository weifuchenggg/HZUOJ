package com.example.demo.entity;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;
import java.util.Date;

public class Problem extends Model<Problem> {

	private static final long serialVersionUID = 1L;

	@TableId
	private String systemid;
	private Integer num;
	private String title;
	private String content;
	private Date start;
	private Date end;
	private String deteleflag;
	private String lv;
	private String laber;
	private String type;
	private String competname;
	private Date createtime;
	private Integer ac;
	private Integer error;
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

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getContent(){
		return this.content;
	}

	public void setContent(String content){
		this.content = content;
	}

	public Date getStart(){
		return this.start;
	}

	public void setStart(Date start){
		this.start = start;
	}

	public Date getEnd(){
		return this.end;
	}

	public void setEnd(Date end){
		this.end = end;
	}

	public String getDeteleflag(){
		return this.deteleflag;
	}

	public void setDeteleflag(String deteleflag){
		this.deteleflag = deteleflag;
	}

	public String getLv(){
		return this.lv;
	}

	public void setLv(String lv){
		this.lv = lv;
	}

	public String getLaber(){
		return this.laber;
	}

	public void setLaber(String laber){
		this.laber = laber;
	}

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getCompetname(){
		return this.competname;
	}

	public void setCompetname(String competname){
		this.competname = competname;
	}

	public Date getCreatetime(){
		return this.createtime;
	}

	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}

	public Integer getAc(){
		return this.ac;
	}

	public void setAc(Integer ac){
		this.ac = ac;
	}

	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	@Override
	public String toString() {
		return "Problem{" +
				"systemid='" + systemid + '\'' +
				", num=" + num +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", start=" + start +
				", end=" + end +
				", deteleflag='" + deteleflag + '\'' +
				", lv='" + lv + '\'' +
				", laber='" + laber + '\'' +
				", type='" + type + '\'' +
				", competname='" + competname + '\'' +
				", createtime=" + createtime +
				", AC=" + ac +
				", ERROR=" + error +
				'}';
	}
}

