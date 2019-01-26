package navigation_menu;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class tariff_Shareholder {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  //ïîäêëþ÷àåì gecko ñòðî÷êîé íèæå!
	System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testtariff_Shareholder() throws Exception {
	  
    driver.get("https://live-app.pride.network/#/login");
    driver.findElement(By.id("mat-input-0")).click();
    driver.findElement(By.id("mat-input-0")).clear();
    driver.findElement(By.id("mat-input-0")).sendKeys(""); // ââîä ïàðîëÿ íà òåñòîâîì îêðóæåíèè
    TimeUnit.SECONDS.sleep(1); //çàäåðæêà ïåðåä ââîäîì 
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    TimeUnit.SECONDS.sleep(5);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/");
    driver.findElement(By.xpath("(//a[contains(text(),'Èãðû')])[2]")).click();
    TimeUnit.SECONDS.sleep(6);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/games/list");
    driver.findElement(By.xpath("(//a[contains(text(),'Áèçíåñ')])[2]")).click();
    TimeUnit.SECONDS.sleep(7);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/business");
    driver.findElement(By.xpath("(//a[contains(text(),'Pride êîìüþíèòè')])[2]")).click();
    TimeUnit.SECONDS.sleep(7);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/feed");
    driver.findElement(By.xpath("(//a[contains(text(),'Ðåéòèíã')])[2]")).click();
    TimeUnit.SECONDS.sleep(3);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/ratings/userRating");
    driver.findElement(By.xpath("(//a[contains(text(),'Ñèñòåìà \"Ìåòîä\"')])[2]")).click();
    TimeUnit.SECONDS.sleep(3);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/system-method/basicPrinciples");
    driver.findElement(By.xpath("(//a[contains(text(),'Àïãðåéä')])[2]")).click();
    TimeUnit.SECONDS.sleep(3);
    Assert.assertEquals(driver.getCurrentUrl(), "https://live-app.pride.network/#/packages");
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
