package upgrade_menu;

import java.util.regex.Pattern;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class package_Demo_14 {
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
  public void testpackage_Demo_14() throws Exception {
	  
    driver.get("https://live-app.pride.network/#/login");
    driver.findElement(By.id("mat-input-0")).click();
    driver.findElement(By.id("mat-input-0")).clear();
    driver.findElement(By.id("mat-input-0")).sendKeys(""); // ���� ������ �� �������� ���������
    TimeUnit.SECONDS.sleep(1); //�������� ����� ������ 
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    TimeUnit.SECONDS.sleep(5);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/");
    driver.findElement(By.className("demo__curator"));
    driver.findElement(By.xpath("(//a[contains(text(),'�������')])[2]")).click();
    TimeUnit.SECONDS.sleep(2);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/packages");
    
    driver.findElement(By.xpath("//div[2]/packages-info/div/div[2]/div/div[2]/button")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("//div[2]/packages-pay-system/div/div[2]/form/div/button")).click();
    TimeUnit.SECONDS.sleep(5);
    Assert.assertEquals(driver.getCurrentUrl(), "https://wallet.advcash.com/sci/paymentRequest.jsf");
    TimeUnit.SECONDS.sleep(3);
    
    
   /*
    driver.findElement(By.xpath("//mat-checkbox[@type='checkbox']")).click();
    TimeUnit.SECONDS.sleep(2);
    driver.findElement(By.xpath("//mat-checkbox[@type='checkbox']")).click();
    */
    
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
