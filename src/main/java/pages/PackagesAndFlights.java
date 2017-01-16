package pages;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Calender;
import generalActions.CommonActions;

public class PackagesAndFlights extends CommonActions {
	
	private static PackagesAndFlights pnf = new PackagesAndFlights();
	
	private WebElement PackageAndFlightsElements(String key){
		HashMap<String, By> elementLocation= new HashMap<String, By>(); 
		elementLocation.put("Flight", By.cssSelector("#tab-flight-tab"));
		elementLocation.put("FlightAndHotel", By.cssSelector("#tab-flightHotel-tab"));
		elementLocation.put("ThingsToDo", By.cssSelector("#tab-activity-tab"));
		elementLocation.put("RoundTrip", By.cssSelector("#flight-type-roundtrip-label"));
		elementLocation.put("MultipleDestination", By.cssSelector("#flight-type-multi-dest-label"));
		elementLocation.put("FlyFrom", By.cssSelector("#flight-origin"));
		elementLocation.put("FlyFrom2", By.cssSelector("#flight-2-origin"));
		elementLocation.put("FlyTo", By.cssSelector("#flight-destination"));
		elementLocation.put("FlyTo2", By.cssSelector("#flight-2-destination"));
		elementLocation.put("flyDestination", By.cssSelector("#activity-destination"));
		elementLocation.put("Departing", By.cssSelector("#flight-departing"));
		elementLocation.put("Departing2", By.cssSelector("#flight-2-departing"));
		elementLocation.put("ActivityFrom", By.cssSelector("#activity-start"));
		elementLocation.put("ActivityEnds", By.cssSelector("#activity-end"));
		elementLocation.put("Returning", By.cssSelector("#flight-returning"));
		elementLocation.put("Returning2", By.cssSelector("#flight-2-returning"));
		elementLocation.put("Adults", By.cssSelector("#flight-adults"));
		elementLocation.put("Children", By.cssSelector("#flight-children"));
		elementLocation.put("AddHotel", By.cssSelector("#flight-add-hotel-checkbox"));
		elementLocation.put("Search", By.cssSelector("#search-button"));
		elementLocation.put("PageHeader", By.xpath(".//*[@class='title-city-text'][contains(text(),'Select your departure to')]"));
		elementLocation.put("PageHeaderMultipleDestination", By.xpath(".//*[@class='title-city-text'][contains(text(),'Multi-city trip from')]"));
		elementLocation.put("ThingsToDoPageHeader", By.cssSelector("h1.section-header-sub"));
		elementLocation.put("Table", By.cssSelector("div#srpPriceMatrix"));
		return findElmt(elementLocation.get(key));
	}
	
	private By elmtListLocations(String key){
		HashMap<String, By> elmntList = new HashMap<String, By>();
		elmntList.put("searchPageReviews", By.cssSelector(".full-view"));
		elmntList.put("searchFlights", By.cssSelector(".results>div>li>a"));
		elmntList.put("destination", By.cssSelector(".main-suggestion"));
		return elmntList.get(key);
	}
	
	public static void flightFrom(String city,String input){
		pnf.enterData(pnf.PackageAndFlightsElements("FlyFrom"), city);
		pnf.autoComplete(pnf.elmtListLocations("searchFlights"), input);
	}
	
	public static void flightTo(String city,String input){
		pnf.enterData(pnf.PackageAndFlightsElements("FlyTo"), city);
		pnf.autoComplete(pnf.elmtListLocations("searchFlights"), input);
	}
	public static void flightFrom2(String city,String input){
		pnf.enterData(pnf.PackageAndFlightsElements("FlyFrom2"), city);
		pnf.autoComplete(pnf.elmtListLocations("searchFlights"), input);
	}
	
	public static void flightTo2(String city,String input){
		pnf.enterData(pnf.PackageAndFlightsElements("FlyTo2"), city);
		pnf.autoComplete(pnf.elmtListLocations("searchFlights"), input);
	}
	
	public static void flightDestination(String city,String input){
		pnf.enterData(pnf.PackageAndFlightsElements("flyDestination"), city);
		pnf.autoComplete(pnf.elmtListLocations("destination"), input);
	}
	
	public static void checkInTom(){
		Calender.chooseDatePackagesAndFlights(1, pnf.PackageAndFlightsElements("Departing"));
	}
	public static void checkInTomm(){
		Calender.chooseDatePackagesAndFlights(1, pnf.PackageAndFlightsElements("Departing2"));
	}
	public static void checkInTom2(){
		Calender.chooseDatePackagesAndFlights(1, pnf.PackageAndFlightsElements("ActivityFrom"));
	}
	
	public static void checkOutDayAfterTom(){
		Calender.chooseDatePackagesAndFlights(1, pnf.PackageAndFlightsElements("Returning"));	
	}
	public static void checkOutDayAfterTomm(){
		Calender.chooseDatePackagesAndFlights(2, pnf.PackageAndFlightsElements("Returning2"));	
	}
	public static void checkOutDayAfterTom2(){
		Calender.chooseDatePackagesAndFlights(2, pnf.PackageAndFlightsElements("ActivityEnds"));
	}
	public static void checkOutSelectDate(){
		Calender.chooseDatePackagesAndFlights(7, pnf.PackageAndFlightsElements("Departing2"));
	}
	public static void noOfAdults(int input){
		pnf.dropDownFindAndSelect(pnf.PackageAndFlightsElements("Adults"), input);
	}
	public static void noOfChildren(int input){
		pnf.dropDownFindAndSelect(pnf.PackageAndFlightsElements("Children"), input);
	}
	
	public static void verifyCheckBox(String locator){
		pnf.radioButtonCheckAndSelect(pnf.elmtListLocations(locator));
	}
	
	
	public static void verifyHeadLine(String expectedText){
		pnf.verifyMessage(pnf.PackageAndFlightsElements("PageHeader"), expectedText);
	}
	public static void verifyThingsToDoHeadLine(String expectedText){
		pnf.verifyPartialMessage(pnf.PackageAndFlightsElements("ThingsToDoPageHeader"), expectedText);
	}
	public static void verifyTable(String expectedText){
		pnf.verifyTable(pnf.PackageAndFlightsElements("Table"), expectedText);
	}
	public static void verifyMultDestHeadLine(String expectedText){
		pnf.verifyMessage(pnf.PackageAndFlightsElements("PageHeaderMultipleDestination"), expectedText);
	}
	
	
	public static void clickButton(String buttonName){
		pnf.PackageAndFlightsElements(buttonName).click();
	}
	
	public static int autoCompleteListIndex(List<WebElement> list, String input){
        
        for(WebElement element : list){
            if(element.getText().equals(input)){
                return list.indexOf(element);
            }
        }
        return 0;
    }
	
	
	
}
