import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.time.Duration;

import static java.lang.Thread.sleep;


public class handle_dropdown {
    WebDriver driver;
    Actions action;

    public void run_browser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://semantic-ui.com/modules/dropdown.html#/definition");
    }

    @Test
    public void selectDropdown() throws InterruptedException {
        run_browser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.simple.example>div.ui.dropdown>div.text")));
        //Get element
        driver.findElement(By.cssSelector("div.simple.example>div.ui.dropdown>div.text")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.simple.example>div.ui.dropdown.visible>div.text")));
        driver.findElement(By.cssSelector("div.menu.transition.visible>div:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div.simple.example>div.ui.dropdown>div.text")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.simple.example>div.ui.dropdown.visible>div.text")));
        driver.findElement(By.cssSelector("div.menu.transition.visible>div:nth-child(6)")).click();
        sleep(5000);
    }
    @Test
    public void selectDropdown_1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        Select select = new Select(driver.findElement(By.cssSelector("select[name='country']")));
        select.selectByValue("ASHMORE AND CARTIER ISLANDS");
    }

    @Test
    public void selectDropdown_2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("div.loader-container"),"style","dis ```````````````````````````````````````````````````````````````````````````````````````play: none;"));
        driver.findElement(By.cssSelector("div.main-search-input>div:nth-child(2)>div>a>div")).click();
        //input search
        driver.findElement(By.cssSelector("div.main-search-input>div:nth-child(2)>div>div>div>input")).sendKeys("U");
        sleep(3000);
        driver.findElement(By.cssSelector("div.main-search-input>div:nth-child(2)>div>div>ul>li:first-child")).click();
    }

}
