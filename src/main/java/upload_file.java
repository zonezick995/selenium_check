import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

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
    public void uploadFileMp3() throws AWTException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://speech-to-text-demo.ng.bluemix.net/");

        driver.findElement(By.cssSelector("div.flex.buttons>button:nth-child(2)")).click();

        StringSelection selectPath = new StringSelection("C:\\Users\\Phuoc Dai\\Downloads\\audio.mp3");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selectPath, null);

        Robot r = new Robot();
        r.delay(3000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);

        r.delay(1000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        sleep(10000);
        String textVoice = driver.findElement(By.cssSelector("div[data-id='Text']")).getText();
        System.out.println(textVoice);

    }
}
