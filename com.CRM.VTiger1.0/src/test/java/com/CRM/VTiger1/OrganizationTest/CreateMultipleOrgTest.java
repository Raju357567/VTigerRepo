package com.CRM.VTiger1.OrganizationTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.VTiger1.GenericUtility.BaseClass;
import com.CRM.VTiger1.GenericUtility.FileUtility;
import com.CRM.VTiger1.GenericUtility.JavaUtility;
import com.CRM.VTiger1.ObjectRepo.CreateNewOrg;
import com.CRM.VTiger1.ObjectRepo.HomePage;
import com.CRM.VTiger1.ObjectRepo.OrganizationInfoPage;
import com.CRM.VTiger1.ObjectRepo.OrganizationPage;

public class CreateMultipleOrgTest extends BaseClass {

	@Test(dataProvider = "multipleDataFromExcel", dataProviderClass = FileUtility.class)
	public void multipleOrg(String multipleName) throws IOException {
		JavaUtility ju = new JavaUtility();
		HomePage hp = new HomePage(driver);

		// String name = fu.getDataFromexcelSheet("Class", 0, 3) + ju.getRandom();
		String name = multipleName + ju.getRandom();
		OrganizationPage op = new OrganizationPage(driver);
		hp.clickOrganization();
		op.clickOnLookUp();
		CreateNewOrg cno =new CreateNewOrg(driver);
		cno.passOrgName(name);
		cno.clickOnSaveBtn();
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		String head = orgInfo.nameOfOrg();
		wdu.screenshotForEntireWebPage(driver, "Papa");

		/*
		 * if (head.contains(name)) { System.out.println("TC passed"); } else {
		 * System.out.println("TC failed"); }
		 */
		Assert.assertTrue(head.contains(name));
		System.out.println("TC passed");

	}
}
