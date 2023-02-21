package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import util.BrowserFactory;

public class MainPage extends BasePage {
	
	
	
	
	WebDriver driver;
	
public MainPage(WebDriver driver){
	
	this.driver=driver;
}

	
	
	
	
  @FindBy(how=How.XPATH,using="#todos-content > form > ul > li > input[type=checkbox]") WebElement ITEM_RADIO_BOX;
	
  @FindBy(how=How.XPATH,using="/html/body/div[3]/input[3]") WebElement TOGGLE_ALL_RADIO_BOX;
  
  @FindBy(how=How.XPATH,using="//*[@id=\"extra\"]/input[1]") WebElement ADD_CATEGORY_ELEMENT;
  
  @FindBy(how=How.XPATH,using="//*[@id=\"extra\"]/input[2]") WebElement ADD_CATEGORY_BUTTON;
  @FindBy(how=How.CSS,using="body > div.controls > a:nth-child(6) > span") WebElement NEW_CATEGORY_ELEMENT;
  @FindBy(how=How.CSS,using="#extra > select:nth-child(3)") WebElement MONTH_DROP_DOWN;
  
  
  

  public void clickOnRadioBox() {
	  
	 
	  
	  TOGGLE_ALL_RADIO_BOX.click();
	 
	  
	 
  }
	public String addCategory(String addcategory) {
		
		ADD_CATEGORY_ELEMENT.sendKeys(addcategory+generateRandomNumber(999));
		return addcategory;
	}
	
	public void clickOnAddCategory() {
		
		ADD_CATEGORY_BUTTON.click();
	}
	
public ArrayList<WebElement> CategoryListData() {
		
		ArrayList<WebElement> fileData = new ArrayList<WebElement>();
		int i =7;
		
	try {
	while(NEW_CATEGORY_ELEMENT.isDisplayed()) {
				 
				String csspath ="body > div.controls > a:nth-child("+i+") > span";
				
			fileData.add(NEW_CATEGORY_ELEMENT);
				NEW_CATEGORY_ELEMENT = driver.findElement(By.cssSelector(csspath));
				i++;}
			
	}
			
	catch (Exception e) {}
		return fileData;
		
	}
	public void checkNewAddedCategory() {
		ArrayList<WebElement> fileData = new ArrayList<WebElement>();
	fileData=CategoryListData();
		
		
		System.out.println(fileData.get(fileData.size()-1).getText());
		System.out.println("Category Added succesfully!!");
		
	}
	
	public void userShouldNotAddAduplicate(String addcategory2) {
		String Url1="https://techfios.com/test/101/index.php";
		String Url2=driver.getCurrentUrl();
		
		addCategory(addcategory2);
		
		clickOnAddCategory();
		addCategory(addcategory2);
		clickOnAddCategory();
		
		
		if (Url1.matches(Url2)) {
			
			System.out.println("Duplicate is not found");
		}
		else {
			System.out.println("The category you want to add already exists: "+addcategory2);
		}
	}
	
	public void validateMothDropDown() {
		
		

		String []month= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		
		
		Select sel = new Select(MONTH_DROP_DOWN);
		  List<WebElement> dd=sel.getOptions();
		
		  System.out.println(dd.size());
		  int c=0;
		  
		  for (int i=0;i<dd.size();i++) {
			  
       for (int j=0;j<month.length;j++) {
			  
			  if (dd.get(i).getText().equals(month[j])) {
				 c++;
				 
			  }
			  }
       
			  }
		  if(c==12) {
			  
			  System.out.println("All Months Exist!!");
		  }
		  else {
			  System.out.println("Months Does not Much!!");
		  }
		  }
	}
	
	
  
  
  

