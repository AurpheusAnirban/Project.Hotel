package generalActions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoToPage extends CommonActions {

	private static GoToPage pg = new GoToPage();
	
	private WebElement pagesHashMap(String key){
		HashMap<String, By> pages = new HashMap<String, By>();
		pages.put("HotelDeals", By.cssSelector("#hdr-deals"));
		pages.put("PackagesAndFlights", By.cssSelector("#hdr-packages"));
		pages.put("menu", By.cssSelector(".trigger"));
		return pg.findElmt(pages.get(key));
	}
	
	public static void Page(String page){
		if(pg.pagesHashMap("menu").isDisplayed()){
			pg.click(pg.pagesHashMap("menu"));
		}
		pg.click(pg.pagesHashMap(page));
	}
}
