package com.dev.Eduley;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pages.YoutubeLaunchPage;

public class YoutubeVideoLaunch extends BaseClass {
	Faker faker = new Faker();
	
	
	private YoutubeLaunchPage youtubeLaunchPage;
	
	

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		logger.info("Initial setup is in progress");
	}

	@Test(priority = 0,enabled = true)
	public void youtubeVideoLaunchMethod() throws AWTException, InterruptedException{
		logger.info("Youtube launch and watch video");
		youtubeLaunchPage=new YoutubeLaunchPage(driver);
		youtubeLaunchPage.clickPlayButton();
		Thread.sleep(35000);
		logger.info("video completed");

}
}