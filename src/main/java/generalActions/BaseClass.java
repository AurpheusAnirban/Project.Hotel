package generalActions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.WebDriverFactory;

public class BaseClass {
	Actions actions = new Actions(WebDriverFactory.getDriver());
	
	protected WebElement findElmt(By locator){
		return WebDriverFactory.getDriver().findElement(locator);  
	}
	
	protected void click(WebElement element){
		element.click();
	}
	
	protected void hoverOver(WebElement element){
		actions.moveToElement(element).build().perform();
	}
	
	protected void actionClick(WebElement elment){
		actions.moveToElement(elment).click().build().perform();
	}
	
	protected void enterData(WebElement element, String inputData) {
		element.sendKeys(inputData);
	}
	
	protected void verifyMessage(WebElement element, String expectedText ){
	  String actualText = element.getText();
	  Assert.assertEquals(actualText,expectedText);
  	}
	protected void verifyPartialMessage(WebElement element, String expectedText ){
		  String actualText = (element.getText().substring(4, 27));
		  Assert.assertEquals(actualText,expectedText);
	}
	protected void verifyTable(WebElement element, String expectedText ){
		  String actualText = element.getText();
		  Assert.assertTrue(actualText.contains(expectedText));
//		  Assert.assertTrue(actualText.contains(expectedText),"Expected Contents not found");
	}
  
	protected void switchToWidnow(int index) {
		List<String> listOfWindows = new ArrayList<String>(WebDriverFactory.getDriver().getWindowHandles());
		WebDriverFactory.getDriver().switchTo().window(listOfWindows.get(index));
	}
	
	protected WebElement listSelectByIndex(By locater, int index){
		List<WebElement> elmtList = WebDriverFactory.getDriver().findElements(locater);
		return elmtList.get(index);
	}
	protected void autoComplete(By locater, String inputData){
		WebDriverFactory.WaitImplicit(5000);
		List<WebElement> elementList = WebDriverFactory.getDriver().findElements(locater);
		int indexNum = autoCompleteListIndex(elementList, inputData);
		WebDriverFactory.WaitImplicit(5000);
		elementList.get(indexNum).click();
	}
  protected void dropDownFindAndSelect(WebElement element,int input){
		input = input-1;
		Select dropDown = new Select(element);
		dropDown.selectByIndex(input);
		
  }
		protected void radioButtonCheckAndSelect(By locator){			
			try {			
				boolean isSelcted= WebDriverFactory.getDriver().findElement(locator).isSelected();
				if(isSelcted==false){	
				WebDriverFactory.getDriver().findElement(locator).click();
				}else{				
				throw new NoSuchElementException("It can not be checked by default");
				}
			} catch (Exception e) {	
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	private int autoCompleteListIndex(List<WebElement> list, String input){
      for(WebElement element : list){
          if(element.getText().contains(input)){
              return list.indexOf(element);
          }
      
      }
      return 0;
}
}