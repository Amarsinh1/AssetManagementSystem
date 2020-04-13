package com.cg.ams.bean;

import java.sql.Date;
import java.time.LocalDate;

public class AssetAllocation {
	private String allocationId;
	private String assetId;
	private String empno;
	private LocalDate allocation_date;
	private LocalDate release_date;

	public AssetAllocation() {
		
	}

	public AssetAllocation(String allocationId, String assetId, String empno, LocalDate allocation_date,
			LocalDate release_date) {
		super();
		this.allocationId = allocationId;
		this.assetId = assetId;
		this.empno = empno;
		this.allocation_date = allocation_date;
		this.release_date = release_date;
	}

	public String getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(String allocationId) {
		this.allocationId = allocationId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public LocalDate getAllocation_date() {
		return allocation_date;
	}

	public void setAllocation_date(LocalDate allocation_date) {
		this.allocation_date = allocation_date;
	}

	public LocalDate getRelease_date() {
		return release_date;
	}

	public void setRelease_date(LocalDate release_date) {
		this.release_date = release_date;
	}

	@Override
	public String toString() {
		return "AssetAllocation [allocationId=" + allocationId + ", assetId=" + assetId + ", empno=" + empno
				+ ", allocation_date=" + allocation_date + ", release_date=" + release_date + "]";
	}

	
	

	}




