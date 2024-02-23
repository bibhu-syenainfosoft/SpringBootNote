package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
	
	private Integer vid;
	private String vname;
	
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vname=" + vname + "]";
	}
	public Vendor(Integer vid, String vname) {
		super();
		this.vid = vid;
		this.vname = vname;
	}

}
