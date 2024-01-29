package pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pom.YoutubeLaunchPOM;
import utilities.LocalHelper;
import utilities.TestUtil;

public class YoutubeLaunchPage extends YoutubeLaunchPOM {
	protected static final Logger logger = LoggerFactory.getLogger(YoutubeLaunchPage.class);

	private final LocalHelper localHelper = new LocalHelper();
	private final TestUtil testUtil = new TestUtil();

	private final WebDriver driver;

	public YoutubeLaunchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	   	public void clickPlayButton() {
			try {
				localHelper.jsExecutorHighlight(playButton, driver);
				localHelper.clickElement(playButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(playButton, driver);
			}
			logger.info("Video play button is clicked");
		}

}