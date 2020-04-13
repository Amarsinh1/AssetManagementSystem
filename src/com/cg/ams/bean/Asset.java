package com.cg.ams.bean;

public class Asset {
	private String AssetId;
	private String AssetName;
	private String AssetDes;
	private int quantity;
	private String Status;
	
	
	public Asset() {
		
	}


	public Asset(String assetId, String assetName, String assetDes, int quantity, String status) {
		super();
		AssetId = assetId;
		AssetName = assetName;
		AssetDes = assetDes;
		this.quantity = quantity;
		Status = status;
	}


	public String getAssetId() {
		return AssetId;
	}


	public void setAssetId(String assetId) {
		AssetId = assetId;
	}


	public String getAssetName() {
		return AssetName;
	}


	public void setAssetName(String assetName) {
		AssetName = assetName;
	}


	public String getAssetDes() {
		return AssetDes;
	}


	public void setAssetDes(String assetDes) {
		AssetDes = assetDes;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	@Override
	public String toString() {
		return "AssetAllocation [AssetId=" + AssetId + ", AssetName=" + AssetName + ", AssetDes=" + AssetDes
				+ ", quantity=" + quantity + ", Status=" + Status + "]";
	}






}
