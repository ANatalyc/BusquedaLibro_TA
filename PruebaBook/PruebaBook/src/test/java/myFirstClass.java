import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class myFirstClass {

    public static void main(String[] args) throws InterruptedException {
        String book = "Bajo la misma estrella";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.goodreads.com/");
        driver.findElement(By.id("sitesearch_field")).sendKeys(book);
        driver.findElement(By.cssSelector("img[alt='search']")).click();
        driver.findElement(By.cssSelector("img[src='//s.gr-assets.com/assets/gr/icons/icon_close-63734f04e7baaa77fbad796225e5724c.svg']")).click();
        WebElement title= driver.findElement(By.cssSelector(".tableList > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1) > span:nth-child(1)"));
        //assertThat(title.getText(), equalTo(LOGIN_TITLE));
        Assert.assertEquals(title.getText(), book);

        Thread.sleep(1000);
        driver.quit();
    }
}
