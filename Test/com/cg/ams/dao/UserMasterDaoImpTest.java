package com.cg.ams.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ams.bean.UserMaster;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.AuthenticationFailedException;
import com.cg.ams.exception.InvalidIdException;
import com.cg.ams.exception.UpdateFailedException;

public class UserMasterDaoImpTest {

	public static UserMasterDao user = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 user = new UserMasterDaoImp();
		UserMasterDaoImp.mockData();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		user = null;
	}

	@Test
	public void testReadUserMasterSuccessfully() throws InvalidIdException {
		assertEquals("Abhishek", user.readUserMaster("123456").getUsername());
	}
	@Test(expected = InvalidIdException.class)
	public void testReadUserMasterFailed() throws InvalidIdException {
	user.readUserMaster("1234567").getUsername();
	}
	@Test
	public void testVerifyUserMasterSucccessfully() throws AuthenticationFailedException {
		UserMaster user1 = new UserMaster("123456","Abhishek","987456","admin","GHF1");
		UserMaster user2 = user.verifyDao("Abhishek", "987456");
		boolean result = false;
		if(user1.getUserId()==user2.getUserId()) {
			result = true;
		}
		assertTrue(result);
	}
	@Test(expected = AuthenticationFailedException.class)
	public void testVerifyUserMasterFailed() throws AuthenticationFailedException{
		assertEquals(new UserMaster("1234","Abhishek","98745","admin","GHF2"),user.verifyDao("Abhishek", "98747"));
	}
	
	@Test
	public void testCreateUserMasterSuccessfully() throws  AssetAlreadyExistException{
		assertTrue(user.createUserMaster(new UserMaster("231422", "Jay", "jai1234", "Admin", "4521")));
	}
	@Test(expected=AssetAlreadyExistException.class)
	public void testCreateUserMasterFailed() throws  AssetAlreadyExistException{
		assertTrue(user.createUserMaster(new UserMaster("231422", "Jay", "jai1234", "Admin", "4521")));
	}
	@Test
	public void testUpdateUserMasterSucccessfully() throws UpdateFailedException {
		assertTrue(user.updateUserMaster("423456", new UserMaster("423456","Samiran","814959","Admin","GHF2")));
	}
	@Test(expected=UpdateFailedException.class)
	public void testUpdateUserMasterFailed() throws UpdateFailedException {
		assertTrue(user.updateUserMaster("423456", new UserMaster("423456","Samiran","81495","Admin","GHF2")));
	}
	
	@Test
	public void testDeleteUserMasterSucccessfully() throws InvalidIdException {
		assertTrue(user.deleteUserMaster("123456"));
	}
	@Test(expected= InvalidIdException.class)
	public void testDeleteUserMasterFailed() throws InvalidIdException {
		assertTrue(user.deleteUserMaster("12346"));
	}
}
