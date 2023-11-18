package pom;

import org.openqa.selenium.By;

public class EduleyAutomationInstituteRegisterPOM {
	
	public By instituteInformationText=By.xpath("//h4[text()='Institute Information']");
	public By instituteNameBox=By.xpath("//input[@id='name']");
	public By contactNameBox=By.xpath("//input[@id='contact_name']");
	public By emailBox=By.xpath("//input[@id='email']");
	public By tagLineBox=By.xpath("//input[@id='tagline']");
	public By phoneBox=By.xpath("//input[@id='phone']");
	public By addressBox=By.xpath("//input[@id='address']");
	public By themeLogo=By.xpath("//h4[text()='Theme & Logo']");
	public By faviconIcon=By.xpath("//label[text()='Favicon Icon']");
	public By primaryColorText=By.xpath("//label[text()='Primary Color']");
	public By logoChooseButton=By.xpath("(//label[text()='Logo']/following::input)[1]");
	public By footerLogoChooseButton=By.xpath("(//label[text()='Logo']/following::input)[2]");
	public By faviconIconChooseButton=By.xpath("(//input[@type='file'])[3]");
	public By submitButton=By.xpath("//button[text()='Submit']");
	public By titleMsg=By.xpath("//h4[@class='title']");
	public By primaryColor=By.xpath("//input[@name='primary_color']");
	public By secondaryColor=By.xpath("//input[@name='secondary_color']");

}
