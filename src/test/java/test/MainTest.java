package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BasePage;
import page.MainPage;
import util.BrowserFactory;



public class MainTest {

	WebDriver driver; 
	@Test
	public void userShouldBeAbleToInsertCategory() {
		
		driver=BrowserFactory.init();
		
		MainPage mainpage=PageFactory.initElements(driver, MainPage.class);
		
		mainpage.addCategory("abdouz");
		mainpage.clickOnAddCategory();
		mainpage.checkNewAddedCategory();
		BrowserFactory.tearDown();
}

	@Test
		public void addNewCateogryNoDuplicate() {
			
			
			driver=BrowserFactory.init();
			
			MainPage mainpage=PageFactory.initElements(driver, MainPage.class);
			
		
		
		mainpage.userShouldNotAddAduplicate("Abdou5665");
		
		BrowserFactory.tearDown();
		}
		
	@Test
		public void verifeyMonthsInDropDown() {
			
			driver=BrowserFactory.init();
			
		MainPage mainpage=PageFactory.initElements(driver, MainPage.class);
			
		mainpage.validateMothDropDown();
		BrowserFactory.tearDown();
		}
	}
	
	
	


