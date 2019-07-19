package ngtestxml;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import basepackage.BaseTest;

public class NgXmlTest extends BaseTest {
    private MainPage mainPage;
    @BeforeTest
    public void setupMainPage(){
        mainPage = new MainPage(driver);
    }
    @Test
    public void myFirstPattern() {

        mainPage.enterSomeBody_andClick("Blouse");

        Assert.assertEquals("1", "1");
}
}