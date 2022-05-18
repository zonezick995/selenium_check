import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import static java.lang.Thread.sleep;
public class flow_captcha_1 {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void flow_captcha() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        //options.addArguments("--headless");
        driver = new EdgeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://thiennguyen.icu/wp-login.php?redirect_to=https%3A%2F%2Fthiennguyen.icu%2Fwp-admin%2F&reauth=1");
        //sleep(3000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector("iframe[name^='a-']"))));
        //WebElement element = driver.findElement(By.cssSelector("iframe[name^='a-']"));
        //driver.switchTo().frame(element);

        driver.findElement(By.cssSelector("div.recaptcha-checkbox-border")).click();
        sleep(3000);
        driver.switchTo().defaultContent();
        //sleep(3000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector("iframe[name^='c-']"))));

        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name^='c-']")));

        driver.findElement(By.cssSelector("button.rc-button-default.goog-inline-block")).click();
        //driver.findElement(By.cssSelector("#rememberme")).click();

    }
}
