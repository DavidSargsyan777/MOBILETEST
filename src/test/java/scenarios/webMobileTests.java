package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.Constants;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened EPAM google search")
    public void simpleWebTest()
        throws InterruptedException {

        Constants constants = new Constants();

        getDriver().get("https://www.google.com/"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getDriver().findElement(By.xpath("//div/input[@class]")).sendKeys("EPAM");
        getDriver().findElement(By.xpath("//div/input[@class]")).sendKeys(Keys.ENTER);

        Thread.sleep(constants.getWaitTime());
        // Check EPAM search in google
        assert ((WebDriver) getDriver()).getTitle().equals("EPAM - Google Search") : "This is not correct search";

        // Log that test finished
        System.out.println("Google search is done");
    }
}
