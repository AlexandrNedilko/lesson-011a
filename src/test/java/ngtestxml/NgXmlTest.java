package ngtestxml;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import basepackage.BaseTest;

public class NgXmlTest extends BaseTest {
    private MainPage mainPage;
    private MainPage mainPage1;
    @BeforeTest
    public void setupMainPage(){

        mainPage = new MainPage(driver);

    }
    @Test
        public void myFirstPattern() {

            mainPage.enterSomeBody("Blouse");
            Assert.assertEquals("1", "1");
}
    @Test
    public void secondTest(){
    System.out.println("secondTest");
    Assert.assertEquals(2,2);
        }

    @Test
    public void thirdTest(){
        System.out.println("thirdTest");
        Assert.assertEquals(4,4);
    }

}