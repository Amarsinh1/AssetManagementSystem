package com.cg.ams.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ams.bean.Asset;
import com.cg.ams.bean.UserMaster;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;


public class AssetDaoImp implements AssetDao {
private static HashMap<String,Asset> assets=new HashMap<String,Asset>();
static final Logger logger = Logger.getLogger(UserMasterDaoImp.class);
static {
	PropertyConfigurator.configure("C:\\Users\\Abhishek\\Desktop\\CoreJava\\\\Ab\\log4j\\log4j.properties");
}
@Override
public Asset readAsset(String AssetId) throws ReadOperationFailed{
	Asset a=assets.get(AssetId);
	if(a != null) {
		logger.info("Asset Read Successfully");
		return a;
		}
		else {
			logger.info("Asset Read UnSuccessFully");
			throw new ReadOperationFailed();
			
		}
	
}
public ArrayList<Asset> readAssets() {
	List<Asset> result=assets.values().stream().collect(Collectors.toList());
	return new ArrayList<Asset>(result);
}

public String read(String assetName) throws ReadOperationFailed{
	String result=null;
	for(Asset um : assets.values()){
		if(um.getAssetName().equalsIgnoreCase(assetName)){
		 result= um.getAssetId();	
		 logger.info("Asset Read Successfully");
		 result= um.getAssetId();	
			return result;
		}
	}
	throw new ReadOperationFailed();
}
@Override
public boolean createAsset(Asset a) {
	Asset result=assets.putIfAbsent(a.getAssetId(), a);
	if(result == null) {
		logger.info("Created Successfully");
    	return true;
    }
    else {
    	logger.info("Creation failed");
    	return false;
    }
}
@Override
public boolean updateAsset(String AssetId, Asset a) throws UpdateFailedException{
	Asset result = assets.put(AssetId, a);
	if (result != null) {
		logger.info("Update OPeration SuccessFul");
		return true;
	}
	else {
		logger.info("Update Operation Failed ");
		throw new UpdateFailedException();
    	
	}
}
@Override
public boolean deleteAsset(String AssetId) {
	Asset a = assets.remove(AssetId);
	if (a != null) {
		return true;
	}
	return false;
}
public void mockData() {
	assets.put("1",new Asset("ABC1","Monitor","Company:Lenovo c19-10,Screen:47cms",1,"Confirmed"));
	assets.put("2",new Asset("ABC2","Mouse","Company:Dell",1,"Rejected"));
	assets.put("3",new Asset("ABC3","Printer","Company:HP,Black Original Laser Jet ",1,"Accepted"));
	assets.put("4",new Asset("ABC4","Laptop","Company:Dell,RAM:4GB",1,"Rejected"));
	assets.put("5",new Asset("ABC5","CPU","Company:Lenovo,RAM:8GB,HDD:1TB",2,"Accepted"));
}
public void print() {
	System.out.println(assets);
}
}
