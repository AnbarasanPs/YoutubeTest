package pom;

import org.openqa.selenium.By;

public class EduleyAdminPortalPOM {
	public By userNameBox=By.xpath("//input[@name='username']");
	public By passwordBox=By.xpath("//input[@name='password']");
	public By loginButton=By.xpath("//input[@type='submit']");
	public By institutesLink=By.xpath("//a[text()='Institutes']");
	public By paymentMethodDropdown=By.xpath("//select[@id='id_payment_method']");
	public By languageDropdown=By.xpath("//select[@id='id_default_language']");
	public By currencyDropdown=By.xpath("//select[@id='id_default_currency']");
	public By paymentValue=By.xpath("(//option[@value='eduley'])[1]");
	public By languageValue=By.xpath("(//option[@value='1'])[1]");
	public By currencyValue=By.xpath("//option[@value='2']");
	public By isActive=By.xpath("//input[@id='id_is_active']");
	public By isApproved=By.xpath("//input[@id='id_is_approved']");
	public By saveButton=By.xpath("//input[@name='_save']");
	public By InsActiveSuccessMsg=By.xpath("//li[text()='The institute “' and text()='” was changed successfully.']");
	
	
	
	

}
