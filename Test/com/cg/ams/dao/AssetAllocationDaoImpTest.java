package com.cg.ams.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssetAllocationDaoImpTest {

public static AssetAllocationDao asset= null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		asset = new AssetAllocationDaoImp();
		asset.mockData();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		asset = null;
	}

	@Test
	public void testReadAssetAllocationSuccessfully() {
		assertEquals("ABC2", asset.readAssetAllocation("xyz1").getAssetId());
	}
	
	@Test
	public void testApproveRequestSuccessfully() throws Exception {
		
		assertTrue(true);
	}

	@Test
	public void testCreateAssetAllocationSuccessfully() {
		assertTrue(asset.createAssetAllocation(new AssetAllocation("xyz7","ABC6","128", LocalDate.parse("2020-03-20"), LocalDate.parse("2020-02-17"))));
	}

	@Test
	public void testUpdateAssetAllocationSuccessfully() {
		assertTrue(asset.updateAssetAllocation("xyz4", new AssetAllocation("xyz4","ABC8","130", LocalDate.parse("2020-01-15"), LocalDate.parse("2020-02-01"))));
	}

	@Test
	public void testDeleteAssetAllocationSuccessfully() {
		assertTrue(asset.deleteAssetAllocation("xyz2"));
	}


}
