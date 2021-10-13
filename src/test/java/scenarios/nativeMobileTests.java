package scenarios;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.Constants;

public class nativeMobileTests extends BaseTest {
    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest()
        throws IllegalAccessException, NoSuchFieldException, InstantiationException, InterruptedException {
        Constants constants = new Constants();
        // Register a new account
        getPo().getWelement("regBtn").click();
        getDriver().manage().timeouts().implicitlyWait(constants.getWaitTime(), TimeUnit.SECONDS);
        getPo().getWelement("regEmail").sendKeys(constants.getEmail());
        getPo().getWelement("regUserName").sendKeys("DAVID");
        getPo().getWelement("regPassword").sendKeys(constants.getPassword());
        getPo().getWelement("regConfPassword").sendKeys(constants.getPassword());
        getPo().getWelement("regConfConditions").click();
        getPo().getWelement("regNewAccBtn").click();
        getDriver().manage().timeouts().implicitlyWait(constants.getWaitTime(), TimeUnit.SECONDS);
        //Sing in with created account
        getPo().getWelement("singInEmail").sendKeys(constants.getEmail());
        getPo().getWelement("singInPassword").sendKeys(constants.getPassword());
        getPo().getWelement("signInBtn").click();
        Thread.sleep(constants.getWaitTime());

        assert (getPo().getWelement("budgetActivityPage").getText().equals("BudgetActivity")) : "This is not BudgetActivity page";

        System.out.println("The BudgetActivity page was opened");
    }
}
