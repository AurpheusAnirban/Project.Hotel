package pages;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

import generalActions.CommonActions;

public class HomePage extends CommonActions{
	private static HomePage hotels = new HomePage();
	
	private WebElement hotelSearchPageElements(String key){
		HashMap<String, By> elementLocations = new HashMap<String, By>();
		elementLocations.put("searchDestinationTextBox", By.cssSelector("#qf-0q-destination"));
		elementLocations.put("search", By.cssSelector("[type='submit']"));
		elementLocations.put("hotelDeals", By.cssSelector("#hdr-deals"));
		elementLocations.put("PackagesAndFlights", By.cssSelector("#hdr-packages"));
		
		elementLocations.put("menu", By.cssSelector(".trigger"));
		return findElmt(elementLocations.get(key));
	}

	
	public static void searchDestination(String inputData){
		hotels.hotelSearchPageElements("searchDestinationTextBox").sendKeys(inputData);
		hotels.autoComplete(By.cssSelector(".autosuggest-city .autosuggest-category-result"), inputData);
	}
	
	public static void clickButton(String buttonName){
		hotels.hotelSearchPageElements(buttonName).click();
	}
    
	@Parameters("browserName")
	public static void goToPage(String page, String browserName){
		if(browserName.equalsIgnoreCase("sauceLabs")){
//			if(hotels.findElmt(By.cssSelector(".cta.widget-overlay-close")).isDisplayed()){
//				hotels.findElmt(By.cssSelector(".cta.widget-overlay-close")).click();
//			}
			clickButton("menu");
			clickButton(page);
		}else{
			clickButton(page);
		}

	}
	
	
  
}
