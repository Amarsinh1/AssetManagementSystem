package com.cg.ams.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.cg.ams.bean.Asset;
import com.cg.ams.bean.AssetForm;
import com.cg.ams.bean.Department;
import com.cg.ams.bean.Employee;
import com.cg.ams.bean.UserMaster;
import com.cg.ams.dao.AssetAllocationDaoImp;
import com.cg.ams.dao.AssetDaoImp;
import com.cg.ams.dao.DepartmentDaoImp;
import com.cg.ams.dao.EmployeeDaoImp;
import com.cg.ams.dao.UserMasterDaoImp;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.AuthenticationFailedException;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;
import com.cg.ams.service.AdminServiceImpl;
import com.cg.ams.service.AuthenticationServiceImpl;
import com.cg.ams.service.UserServiceImpl;

public class AssetApp {

	public static void main(String[] args) throws Exception  {
		AuthenticationServiceImpl authenticate = new AuthenticationServiceImpl();
		AdminServiceImpl admin = new AdminServiceImpl();
		UserServiceImpl user = new UserServiceImpl();
		AssetAllocationDaoImp aad=new AssetAllocationDaoImp();
		AssetDaoImp ad=new AssetDaoImp();
		DepartmentDaoImp d=new DepartmentDaoImp();
		EmployeeDaoImp em=new EmployeeDaoImp();
		UserMasterDaoImp usd=new UserMasterDaoImp();
		ad.mockData();
		d.mockData();
		aad.mockData();
		em.mockData();
		usd.mockData();
		
		UserMaster validate=new UserMaster();
		Scanner sc =new Scanner(System.in);
		String username;
		String password;
		System.out.println("Enter Username");
		username=sc.nextLine();
		System.out.println("Enter password");
		password=sc.nextLine();
		
		validate=authenticate.verify(username,password);
		Employee emp = user.employeeData(validate.getEmployee_no());
		//Department dept = user.deptData(emp.getDept_Id());
		//String mgrId = emp.getMgr();
		//String deptName = dept.getDept_Name();
		
		if(validate.getUserType()=="admin") {
			boolean flag=true;
			do {
				System.out.println("Enter your choice");
				System.out.println("1. Add Assets");
				System.out.println("2. Check Requests");
				System.out.println("3. Check Asset Availability");
				System.out.println("4. Request Response");
				System.out.println("5. Stop");
				int choice = sc.nextInt();
				switch(choice){
					case 1: System.out.println("Enter Asset number");
					String assetNumber = sc.next();
					System.out.println("Enter Asset Name");
					String assetName = sc.next();
					System.out.println("Enter Asset Description");
					String assetDes = sc.next();
					System.out.println("Enter Asset Quantity");
					int assetQuantity = sc.nextInt();
					System.out.println("Enter Asset Status (Available/Not available)");
					String assetStatus = sc.next();
					Asset a = new Asset(assetNumber, assetName, assetDes, assetQuantity, assetStatus);
					boolean res=admin.addAsset(a);
					if(res)
						System.out.println("Asset Added Successfully");
					break;
					case 2: ArrayList list = admin.checkRequests();
					System.out.println(list);
					break;
					case 3: ArrayList list1 = admin.assetAvailability();
					System.out.println(list1);
					break;
					case 4: System.out.println("Enter Request Id");
					int requestId = sc.nextInt();
					System.out.println("Want to Approve/Decline");
					String response = sc.next();
					if(response.equalsIgnoreCase("Approve")){
					boolean result = admin.requestApprove(requestId);
					System.out.println(result);
					}
					else if(response.equalsIgnoreCase("Decline")){
					boolean result = admin.requestDecline(requestId);
					System.out.println(result);
					}
					else{
						System.out.println("Enter valid response");
					}
					break;
					case 5: flag = false;
					break;
					default: System.out.println("Enter Correct choice");
					
				}
			}while(flag);
		}
		else if (validate.getUserType() == "Manager"){
			boolean flag = true;
			do{
				System.out.println("Enter your choice");
				System.out.println("1. Raise Request");
				System.out.println("2. Check Status");
				System.out.println("3. Stop");
				int choice = sc.nextInt();
				switch(choice){
					case 1:
					System.out.println("Enter Asset Name");
					String assetName = sc.next();
					System.out.println("Enter Release Date: ");
					String str = sc.next();
					LocalDate releasedate = LocalDate.now();
					
					String empId=validate.getEmployee_no();
					System.out.println("Employee Id"+empId);
					
					String managerId = emp.getMgr();
					System.out.println("Manager Id"+managerId);
					String requestId=emp.getEmployee_no()+emp.getMgr();
					AssetForm form = new AssetForm(empId, managerId, assetName,requestId,releasedate,"processing");
					boolean update=user.raiseRequest(form);
					if(update)
						System.out.println("Form successfully submitted");
					System.out.println("your requestId is:"+requestId);
					break;
					case 2:System.out.println("Enter RequestId");
					String request_Id;
					request_Id=sc.next();
					String status = user.checkStatus(request_Id);
					System.out.println("status: "+status);
					case 3: flag = false;
					break;
					default: System.out.println("Enter Correct choice");
				}
					
			}while(flag);
				
		}
		else {
			System.out.println("Invalid Username or Password");
		}
		
	}

}
