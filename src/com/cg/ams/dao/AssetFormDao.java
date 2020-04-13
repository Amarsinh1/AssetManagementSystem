package com.cg.ams.dao;

import java.util.ArrayList;

import com.cg.ams.bean.AssetForm;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public interface AssetFormDao {
	public ArrayList<AssetForm> readAssetforms() throws ReadOperationFailed;
	public boolean update(AssetForm form) throws UpdateFailedException;
	public String checkStatusDao(String assetRequestId);
}
