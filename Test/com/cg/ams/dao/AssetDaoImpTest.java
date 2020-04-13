package com.cg.ams.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssetDaoImpTest {

	public static AssetDao asset = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		asset = new AssetDaoImp();
		asset.mockData();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		asset = null;
	}

	@Test
	public void testReadAssetSuccessfully() {
		assertEquals("Mouse", asset.readAsset("ABC2").getAssetName());
	}
	
	@Test
	public void testReadAssets() {
		assertTrue(true);
	}
	
	@Test
	public void testCreateAssetSuccessfully() {
		assertTrue(asset.createAsset(new Asset("ABC6","Speaker","Company:Boat",5,"Available")));
	}
	
	@Test
	public void testUpdateAssetSuccessfully() {
		assertTrue(asset.updateAsset("ABC2", new Asset("ABC2","Mouse","Company:HP",1,"Rejected")));
	}
	
	@Test
	public void testDeleteAssetSuccessfully() {
		assertTrue(asset.deleteAsset("ABC3"));
	}

}
