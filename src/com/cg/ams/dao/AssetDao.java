package com.cg.ams.dao;

import com.cg.ams.bean.Asset;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public interface AssetDao {
    Asset readAsset(String AssetId) throws ReadOperationFailed;
    boolean createAsset(Asset a);
    boolean updateAsset(String AssetId, Asset a) throws UpdateFailedException;
    boolean deleteAsset(String AssetId);
}
