import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Guru99_handle_scrollPage {
    WebDriver driver;
    WebDriverWait wait;
    @Test
    public void login_page_bank() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/V4/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        sleep(3000);
        driver.findElement(By.cssSelector("a[href = 'http://demo.guru99.com/']")).click();
        //Advertisement
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe[title = '3rd party ad content']"))));
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title = '3rd party ad content']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Advertisement']")));
        WebElement dismissBtn = driver.findElement(By.cssSelector("#dismiss-button"));
        if (dismissBtn.isDisplayed()){
            dismissBtn.click();
        }else {
            return;
        }
        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[name='emailid']"))));

        driver.findElement(By.cssSelector("input[name='emailid']")).sendKeys("zone.zick995@gmail.com");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("table[align='center']"))));

        String userName = driver.findElement(By.cssSelector("table[align='center']>tbody>tr:nth-child(4)>td:nth-child(2)")).getText();
        String passWord = driver.findElement(By.cssSelector("table[align='center']>tbody>tr:nth-child(5)>td:nth-child(2)")).getText();
        sleep(3000);
        System.out.println(userName);
        System.out.println(passWord);
        sleep(3000);
        driver.get("http://demo.guru99.com/V4/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("table[align='center'][style='margin-top: 320px']"))));

        driver.findElement(By.cssSelector("input[name='uid']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(passWord);
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
        sleep(5000);
    }


    @Test
    public void scroll_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/V4/");

        driver.findElement(By.xpath("//li[1]/a[contains(text(),\"Selenium\")]")).click();
        driver.findElement(By.cssSelector("ul.dropdown-menu>li:nth-child(16)")).click();
        sleep(5000);
        //Advertisement
        WebElement adver = driver.findElement(By.cssSelector("iframe[title = '3rd party ad content']"));
        if (adver.isDisplayed()){
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title = '3rd party ad content']")));
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Advertisement']")));
            WebElement dismissBtn = driver.findElement(By.cssSelector("#dismiss-button"));
            if (dismissBtn.isDisplayed()){
                dismissBtn.click();
            }else {
                return;
            }
            driver.switchTo().defaultContent();
        }
        WebElement scrollArea = driver.findElement(By.xpath("//a[contains(text(),'Ethical Hacking')]"));
        //https://stackoverflow.com/questions/41116013/selenium-code-to-scroll-horizontally-in-a-web-element-which-is-loading-lazily
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", scrollArea);
        sleep(5000);
    }

    @Test
    public void handle_scroll_2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
        sleep(3000);
        WebElement scroll_1 = driver.findElement(By.cssSelector("#mCSB_1_container"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','position: relative; top: -1114px; left: 0px;')", scroll_1 );
        sleep(5000);
    }
}
