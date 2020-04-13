package com.cg.ams.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ams.bean.AssetForm;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public class AssetFormDaoImp implements AssetFormDao {
	private static HashMap<String, AssetForm>forms = new HashMap<String, AssetForm>();
	static final Logger logger = Logger.getLogger(UserMasterDaoImp.class);
	static {
		PropertyConfigurator.configure("C:\\Users\\Abhishek\\Desktop\\CoreJava\\Ab\\log4j\\log4j.properties");
	}
	@Override
	public ArrayList<AssetForm> readAssetforms()throws ReadOperationFailed {
		List<AssetForm> result = forms.values().stream().collect(Collectors.toList()); 
		logger.info("Asset Read Successfully");
		return new ArrayList<AssetForm>(result);
	}
	
	public boolean update(AssetForm form)throws UpdateFailedException{
		AssetForm result=forms.putIfAbsent(form.getRequestId(), form);
		if(result != null) {
			logger.info("Update OPeration SuccessFul");
	    	return true;
	    }
	    else {
	    	logger.info("Update OPeration UnSuccessFul");
	    	throw new UpdateFailedException();
	    	
	    }
	    
	}
	public String checkStatusDao(String assetRequestId){
		AssetForm a = forms.get(assetRequestId);
		System.out.println(forms);
		if(a != null) {
			logger.info("Checking Status Successful");
			return a.getStatus();
		}
		else {
			logger.info("Checking Status Successful");
			return null;
		}
		
	}
	
	public void changeStatusDao(int assetRequestId){
		AssetForm a = forms.get(assetRequestId);
		if(a != null) {
			logger.info("Changing Status Successful");
			 a.setStatus("Allocated");
			}
			else {
				logger.info("Checking Status UnSuccessful");
			}
	}
	
	public boolean requestDeclineDao(int assetRequestId) {
		AssetForm a = forms.get(assetRequestId);
		if(a != null) {
			logger.info("Request Declined Successful");
			 a.setStatus("Declined");
			 return true;
			}
			else {
				logger.info("REquest DEclined UnSuccessful");
				return false;
			}
	}
	
	public AssetForm read(int requestId)throws ReadOperationFailed {
		AssetForm a = forms.get(requestId);
		if(a != null) {
			logger.info("Asset Read Successfully");
			return a;
			}
			else {
				logger.info("Asset Read UnSuccessfully");
				throw new ReadOperationFailed(); 
				
			}
	}
}
