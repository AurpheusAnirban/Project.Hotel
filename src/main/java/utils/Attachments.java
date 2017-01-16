package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ru.yandex.qatools.allure.annotations.Attachment;

public class Attachments {

	@Attachment(type = "image/png")
	protected static byte[] createAttachment() {
	    return ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
	}
}
