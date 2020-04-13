package com.cg.ams.bean;

import java.time.LocalDate;
import java.util.Date;

public class AssetForm {
private String empId;
private String managerId;
private String assetName;
private String requestId;
private LocalDate releaseDate;
private String status;

 public AssetForm() {
	  
 }



public AssetForm(String empId, String managerId, String assetName, String requestId, LocalDate releaseDate,
		String status) {
	super();
	this.empId = empId;
	this.managerId = managerId;
	this.assetName = assetName;
	this.requestId = requestId;
	this.releaseDate = releaseDate;
	this.status = status;
}



public String getEmpId() {
	return empId;
}
public LocalDate getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(LocalDate releaseDate) {
	this.releaseDate = releaseDate;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getManagerId() {
	return managerId;
}
public void setManagerId(String managerId) {
	this.managerId = managerId;
}
public String getAssetName() {
	return assetName;
}
public void setAssetName(String assetName) {
	this.assetName = assetName;
}

public String getRequestId() {
	return requestId;
}
public void setRequestId(String requestId) {
	this.requestId = requestId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "AssetForm [empId=" + empId + ", managerId=" + managerId + ", assetName=" + assetName + ", requestId="
			+ requestId + ", releaseDate=" + releaseDate + ", status=" + status + "]";
}

 
}
