import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import static java.lang.Thread.sleep;

public class flow_checkout {
    WebDriver driver;
    WebDriverWait wait;
    public void waitForCSSElement(String waitConditionLocator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(waitConditionLocator)));
    }
    public void waitForXpathElement(String waitConditionLocator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(waitConditionLocator)));
    }
    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://tiki.vn/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        sleep(5000);
        driver.quit();
    }
    @Test
    public void checkout(){
        driver.findElement(By.cssSelector("input.FormSearch__Input-sc-1fwg3wo-2.gBxvSE")).sendKeys("Zflip3");
        driver.findElement(By.cssSelector("button.FormSearch__Button-sc-1fwg3wo-3.bUpWwh")).click();
        waitForXpathElement("//body/div[@id='__next']/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]/span[1]");
        //driver.findElement(By.xpath("span.style__StyledItem-sc-18svp8n-0.fkDgwT")).click(); - duplicate class css
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]/span[1]")).click();
        waitForCSSElement("div.group-button");
        driver.findElement(By.cssSelector("div.group-button > button.btn.btn-add-to-cart")).click();
        waitForCSSElement("ul.social__items>li.social__item");
        driver.findElement(By.cssSelector("ul.social__items>li.social__item>img[alt=\"google\"]")).click();
    }
    @Test
    public void login(){
        driver.findElement(By.cssSelector("div[data-view-id=\"header_header_account_container\"].Userstyle__Item-sc-6e6am-1.cHRIKv")).click();
        waitForCSSElement("div.input");
        driver.findElement(By.cssSelector("input[type=tel][name=\"tel\"]")).sendKeys("2398012381423");
        waitForCSSElement("span.error-mess");
        String msgError = driver.findElement(By.cssSelector("span.error-mess")).getText();
        Assert.assertEquals(msgError,"Số điện thoại không đúng định dạng.");
        driver.findElement(By.cssSelector("form>button")).click();
    }

}
