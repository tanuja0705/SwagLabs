package ecom.SwagLabs.Login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.SwagLabs.baseClass.BaseClass;
import ecom.SwagLabs.genericUtility.ExcelUtility;
import ecom.SwagLabs.objRepo.LoginPage;

public class UserLoginWithValidCredentials_Test extends BaseClass{
	@Test(groups = "SmT")
	public void userLoginWithValidCredentials_Test() throws Exception {
		LoginPage lp = new LoginPage(driver);
		ExcelUtility eu = new ExcelUtility();
		
		lp.login(eu.readDataFromExcel("LoginCredentials", 1, 0), eu.readDataFromExcel("LoginCredentials", 1, 1));

		/*FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String un = wb.getSheet("LoginCredentials").getRow(1).getCell(0).toString();
		String pwd = wb.getSheet("LoginCredentials").getRow(1).getCell(1).toString();
		
		lp.getUn().clear();
		lp.getUn().sendKeys(un);
		lp.getPwd().clear();
		lp.getPwd().sendKeys(pwd);
		lp.getLoginB().click();*/
		
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed(),true);
		Reporter.log("User logged in successfully with valid credentials",true);
	}
}
