package com.CRM.VTiger1.OrganizationTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRM.VTiger1.GenericUtility.BaseClass;
import com.CRM.VTiger1.GenericUtility.JavaUtility;
import com.CRM.VTiger1.ObjectRepo.CreateNewOrg;
import com.CRM.VTiger1.ObjectRepo.HomePage;
import com.CRM.VTiger1.ObjectRepo.OrganizationInfoPage;
import com.CRM.VTiger1.ObjectRepo.OrganizationPage;

@Listeners(com.CRM.VTiger1.GenericUtility.ListenerImplementation.class)
public class CreateOranizationTest extends BaseClass {

	@Test(groups = { "RegressionSuite",
			"SmokeSuite" }, retryAnalyzer = com.CRM.VTiger1.GenericUtility.RetryAnalyzer.class)
	public void createOrganization() throws Throwable {

		JavaUtility ju = new JavaUtility();
		HomePage hp = new HomePage(driver);

		String name = fu.getDataFromexcelSheet("Class", 0, 3)+ju.getRandom();

		OrganizationPage op = new OrganizationPage(driver);
		hp.clickOrganization();
		Reporter.log("click on organization", true);
// Assert.fail();//to fail the test script
		op.clickOnLookUp();
		Reporter.log("click on lookup image", true);

		CreateNewOrg cno = new CreateNewOrg(driver);
		cno.passOrgName(name);
		cno.clickOnSaveBtn();
		Reporter.log("click on save button", true);

		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		String head = orgInfo.nameOfOrg();
		wdu.screenshotForEntireWebPage(driver, "Papa");

//if (head.contains(name)) {
//	System.out.println("TC passed");
//} else {
//	System.out.println("TC failed");
//}
		Assert.assertTrue(head.contains(name));
		Reporter.log("validation passed", true);
		System.out.println("TC passed");

	}
}
