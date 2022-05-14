import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class upload_file {
    WebDriver driver;

    @Test
    public void uploadFile() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");

        driver.findElement(By.cssSelector("input[name='userfile']"))
                .sendKeys("C:\\1_Local_Data\\Research\\UI_testing\\cẩm nang css-xpath.pdf");

    }

    @Test
    public void uploadFileMp3(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://speech-to-text-demo.ng.bluemix.net/");

        driver.findElement(By.cssSelector("div.flex.buttons>button:nth-child(2)"))
                .sendKeys("C:\\Users\\Phuoc Dai\\Downloads\\audio.mp3");

    }
}
