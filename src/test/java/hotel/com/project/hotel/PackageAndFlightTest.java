package hotel.com.project.hotel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PackagesAndFlights;
import utils.WebDriverFactory;

public class PackageAndFlightTest extends WebDriverFactory {
	
	@Parameters("browserName")
	@BeforeMethod
		public void NavigateToPage(String browserName){
		HomePage.goToPage("PackagesAndFlights", browserName);
	}
		
		@Test(testName = "TA110")
		public void TA110() throws InterruptedException {
			
			PackagesAndFlights.clickButton("Flight");
			PackagesAndFlights.clickButton("RoundTrip");
			PackagesAndFlights.flightFrom("New York","JFK");
			PackagesAndFlights.flightTo("Los Angeles","LAX");
			PackagesAndFlights.checkInTom();
			PackagesAndFlights.checkOutDayAfterTom();
			PackagesAndFlights.noOfAdults(1);
			PackagesAndFlights.noOfChildren(1);
			PackagesAndFlights.verifyCheckBox("AddHotel");
			PackagesAndFlights.clickButton("Search");
			PackagesAndFlights.verifyHeadLine("Select your departure to Los Angeles");
	}

//		@Test(testName = "TA111")
		public void TA111() throws InterruptedException {
			
			PackagesAndFlights.clickButton("ThingsToDo");
			PackagesAndFlights.flightDestination("Florida","Orlando");
			Thread.sleep(1000);
			PackagesAndFlights.checkInTom2();
			PackagesAndFlights.checkOutDayAfterTom2();
			PackagesAndFlights.clickButton("Search");
			PackagesAndFlights.verifyThingsToDoHeadLine("things to do in Orlando");
			PackagesAndFlights.verifyTable("Adventures & Excursions avg");
			PackagesAndFlights.verifyTable("Tours & Sightseeing avg");
			PackagesAndFlights.verifyTable("Attractions & Nightlife avg");  
		
}

//		@Test(testName = "TA130")
		public void TA130() throws InterruptedException {
			PackagesAndFlights.clickButton("Flight");
			PackagesAndFlights.clickButton("MultipleDestination");
			PackagesAndFlights.flightFrom("Newark","Newark, NJ (EWR-Liberty Intl.)");
			PackagesAndFlights.flightTo("Orlando","Orlando, FL (ORL-All Airports)");
			PackagesAndFlights.checkInTom();
			PackagesAndFlights.noOfAdults(2);
			PackagesAndFlights.noOfChildren(1);
			PackagesAndFlights.flightFrom2("Orlando","Orlando, FL (ORL-All Airports)");
			PackagesAndFlights.flightTo2("Las Vegas","Las Vegas, NV (LAS-All Airports)");
			PackagesAndFlights.checkOutSelectDate();
			PackagesAndFlights.clickButton("Search");
			PackagesAndFlights.verifyMultDestHeadLine("Multi-city trip from Newark");
		}
		
//		@Test(testName = "TA134")
//		public void TA134() throws InterruptedException {
//			PackagesAndFlights.clickButton("FlightAndHotel");
//			PackagesAndFlights.clickOnFlightAndHotel();
//			PackagesAndFlights.flyingFromNewyork();
//			PackagesAndFlights.flyingToLosAngeles();
//			PackagesAndFlights.departTomorrow();
//			PackagesAndFlights.returnAWeekFromTomorrow();
//			PackagesAndFlights.selectOneRoom();
//			PackagesAndFlights.checkTheCheckbox();
//			PackagesAndFlights.selectOneAdult();
//			PackagesAndFlights.selectZeroChild();
//			PackagesAndFlights.clickOnsearchButton();
//			PackagesAndFlights.verifyHeaderFlightAndHotel();	
//			}
		
		//@Test(testName="TA5")
//		public void TA5() throws IOException{
//			PreTestRequirements.goToPackagesAndFlights();
//			implicitWaitOn(5000);
//			PackagesAndFlights_Page.clickOnBeachPackage();
//			PackagesAndFlights_Page.leaveFromJFK();
//			PackagesAndFlights_Page.goingToMiami();
//			PackagesAndFlights_Page.selectOneRoomInBeachPackage();
//			PackagesAndFlights_Page.selectTwoAdultsInBeachPackage();
//			PackagesAndFlights_Page.selectZeroChildrenInBeachPackage();
//			PackagesAndFlights_Page.selectFirstClass();
//			PackagesAndFlights_Page.searchBeachPackages();
//			implicitWaitOn(5000);
//			PackagesAndFlights_Page.verifyEnterDatesMessage();
		}

