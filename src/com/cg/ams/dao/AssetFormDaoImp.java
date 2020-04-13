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
	@Override
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
	@Override
	public boolean createAssetForm(AssetForm a) {
		AssetForm result=forms.putIfAbsent(a.getRequestId(), a);
	    if(result == null) {
	    	return true;
	    }
	    else {
			return false;
		}
	}
	
	@Override
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
	
	@Override
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
	
	@Override
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
	@Override
	public boolean delete(String requestId) {
		AssetForm af = forms.remove(requestId);
		if (af != null) {
			return true;
		}
		else {
	    	return false;
	    }
	}
	
	@Override
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
	@Override
	public void mockData() {
		this.createAssetForm(new AssetForm("456","Rakesh","Mouse","456Rakesh",LocalDate.parse("2017-10-22"),"Processing"));
		this.createAssetForm(new AssetForm("457","Rakesh","CPU","457Rakesh",LocalDate.parse("2017-10-22"),"Processing"));
		this.createAssetForm(new AssetForm("458","Rakesh","Monitor","458Rakesh",LocalDate.parse("2017-10-22"),"Processing"));
		this.createAssetForm(new AssetForm("459","Rakesh","Mouse","459Rakesh",LocalDate.parse("2017-10-22"),"Processing"));
		
	}
}
