package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calender{
	private static Calendar calendar = Calendar.getInstance();
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("MM/dd/yy");
	
	public static void travelDate(boolean Tomorrow, WebElement element){
		if(Tomorrow=true){
			String tomorrow = addDaysToCurrentDate(1);
			element.click();
			WebDriverFactory.getDriver().findElement(By.cssSelector("a[aria-label='"+ tomorrow+ "']")).click();
			
		}else{
			String dayAfterTomorrow = addDaysToCurrentDate(2);
			element.click();
			WebDriverFactory.getDriver().findElement(By.cssSelector("a[aria-label='"+ dayAfterTomorrow+ "']")).click();
		}
	}
	
	private static String addDaysToCurrentDate(int days) {
        calendar.add(Calendar.DATE, days); 
        String currentTime = timeFormat.format(calendar.getTime());
        return currentTime;
	}
	
	public static void chooseSpecificDate(int month, int day, int year){
		month = month -1;
		calendar.set(year, month, day);
		String chosenDate = timeFormat.format(calendar.getTime());
	}


	public static void chooseDatePackagesAndFlights(int days, WebElement element){
			calendar.add(Calendar.DATE, days);
			String year = new SimpleDateFormat("yyyy").format(calendar.getTime());
			int mon = Integer.parseInt(new SimpleDateFormat("MM").format(calendar.getTime())) -1;
			String day = new SimpleDateFormat("dd").format(calendar.getTime());
		
			element.click();
			WebDriverFactory.getDriver().findElement(By.cssSelector("button[data-year='" + year + "'][data-month='" + mon + "'][data-day='" + day + "']")).click();
	}
	}