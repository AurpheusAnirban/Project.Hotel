package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import generalActions.BaseClass;
import generalActions.CommonActions;
import utils.WebDriverFactory;

public class BookingPage extends CommonActions{

	private static BookingPage book = new BookingPage();
	private static String initialPrice, windowedPrice;
	
	private WebElement bookingPageElements(String key){
		HashMap<String, By> elementLocations = new HashMap<String, By>();
		elementLocations.put("priceWatch", By.cssSelector(".price-watch-text"));
		elementLocations.put("email", By.cssSelector("#pw-email-address"));
		elementLocations.put("subscribe", By.cssSelector(".cta.widget-overlay-ok.price-watch-submit-button"));
		elementLocations.put("verificationMessage", By.xpath("//h3[contains(text(),'We’ll watch the rate')]"));
		return findElmt(elementLocations.get(key));
	}
	
	private By elmtListLocations(String key){
		HashMap<String, By> elmntList = new HashMap<String, By>();
		elmntList.put("comparePrices", By.xpath("//dd/a/span[1]"));
		return elmntList.get(key);
	}
	
	public static void clickButton(String buttonName){
		book.bookingPageElements(buttonName).click();
	}
	
	public static void enterEmail(String email){
		book.bookingPageElements("email").sendKeys(email);
	}
	
	public static void getPriceofHotel(){
		initialPrice = book.findElmt(By.cssSelector(".current-price.bold")).getText();
	}
	
	public static void verifyAndMatchPrice(){
		windowedPrice = book.findElmt(By.cssSelector(".pw-price")).getText();
		Assert.assertEquals(initialPrice, windowedPrice);
	}
	
	public static void ConfirmMessage(String expectedText){
		book.verifyMessage(book.bookingPageElements("verificationMessage"), expectedText);
	}
	
	public static void verifyOtherSitesAreDisplayed(){
		List<String> comparePricesSites = new ArrayList<String>();
		List<String> actualPricesSites = new ArrayList<String>();
				actualPricesSites.add("Hotwire");
				actualPricesSites.add("Orbitz");
				actualPricesSites.add("Expedia");
				actualPricesSites.add("Travelocity");
		List<WebElement> siteList = WebDriverFactory.getDriver().
									findElements(book.elmtListLocations("comparePrices"));
		for(WebElement site: siteList){
				String websiteName = site.getText();
				System.out.println(websiteName);
				comparePricesSites.add(websiteName);
			}
		
		Collections.sort(comparePricesSites);
		Collections.sort(actualPricesSites);
		
		 if(!comparePricesSites.equals(actualPricesSites)){
			Assert.fail();
		}
	}
}
