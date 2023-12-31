package com.CRM.VTiger1.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(className = "dvHeaderText")
	private WebElement orgInfo;

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String nameOfOrg() {
		return orgInfo.getText();
	}

}
