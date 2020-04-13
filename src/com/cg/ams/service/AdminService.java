package com.cg.ams.service;

import java.util.ArrayList;

import com.cg.ams.bean.Asset;
import com.cg.ams.exception.ReadOperationFailed;

public interface AdminService {
	public ArrayList assetAvailability();
	public boolean addAsset(Asset a);
	public ArrayList checkRequests() throws ReadOperationFailed;
	public boolean requestApprove(int requestId) throws ReadOperationFailed;
	public boolean requestDecline(int requestId);
}
