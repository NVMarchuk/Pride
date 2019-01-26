package com.registration.test;

import java.util.regex.Pattern;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Direct_Link {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	//���������� gecko �������� ����!
	System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDirect_Link() throws Exception {
	  
	  int a = 0; // ��������� �������� ��������� - "��"
      int b = 100000; // �������� �������� ��������� - "��"
      String domain = "@ukr.net";
      String email = a + (int) (Math.random() * b) + domain; // ��������� �����
      
      
    driver.get("https://live-app.pride.network/#/login");
    driver.findElement(By.id("mat-input-0")).click();
    driver.findElement(By.id("mat-input-0")).clear();
    driver.findElement(By.id("mat-input-0")).sendKeys(""); // ���� ������ �� �������� ���������
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.linkText("������������������")).click();
    TimeUnit.SECONDS.sleep(2);
    driver.findElement(By.name("referrerKey")).click();
    driver.findElement(By.name("referrerKey")).clear();
    driver.findElement(By.name("referrerKey")).sendKeys("");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("");
    driver.findElement(By.name("plainPassword")).click();
    driver.findElement(By.name("plainPassword")).clear();
    driver.findElement(By.name("plainPassword")).sendKeys("test");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    TimeUnit.SECONDS.sleep(2);
    //������ �� �������� ����� ������
    String url = driver.getCurrentUrl();
    String url_2 = "https://live-app.pride.network/#/registration/2";
    boolean results = Objects.equals(url, url_2);
    TimeUnit.SECONDS.sleep(5);
    while (results != true)
    	{
	    	String formula = a + (int) (Math.random() * b) + domain;
	    	String new_email = formula;
	    	email = new_email;
	    	driver.findElement(By.name("email")).click();
	        driver.findElement(By.name("email")).clear();
	        driver.findElement(By.name("email")).sendKeys(email);
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        TimeUnit.SECONDS.sleep(3);
	        url = driver.getCurrentUrl();
	        results = Objects.equals(url, url_2);
	        TimeUnit.SECONDS.sleep(3);
    	}
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys(email);
    driver.findElement(By.name("surname")).click();
    driver.findElement(By.name("surname")).clear();
    driver.findElement(By.name("surname")).sendKeys("test");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    TimeUnit.SECONDS.sleep(2);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/registration/3");	
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

