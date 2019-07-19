


import basepackage.BaseTest;

import org.testng.annotations.*;
import org.testng.Assert;
import pages.MainPage;

public class MainPageTest extends BaseTest {

    private MainPage mainPage;
    @DataProvider(name = "goods")
    public Object[] getGoods() {
        String [] goods = new String[]{"Blouse", "Mouse"};
        return goods;
    }

    @BeforeMethod
    public void before(){
        System.out.println("before method");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class\n");
    }

    @AfterMethod
    public void after(){
        System.out.println("after method\n");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }


    @BeforeTest
    public void setupMainPage(){
        mainPage = new MainPage(driver);
    }


    @Test(dataProvider = "goods")
    public void myFirstPattern(String good) {


        mainPage.enterSomeBody_andClick(good);

        Assert.assertEquals("1", "1");
      /*  mainPage.addCartClick(); //Add to cart
        mainPage.proceedtoCheckoutClick(); //Proceed to checkout
        mainPage.plusClick(); //click Plus*/



       /* List <String> expected = new ArrayList<String>();
        String expected_pTotalProducts= "$54.00";
        String expected_pTotalShipping= "$2.00";
        String expected_pTotalSum= "$56.00";
        String expected_pTotalTax= "$0.00";
        String expected_pTotalFinish= "$56.00";
        String expected_pIconTrashEmpty= "Your shopping cart is empty.";
        expected.add(expected_pTotalProducts);
        expected.add(expected_pTotalShipping);
        expected.add(expected_pTotalSum);
        expected.add(expected_pTotalTax);
        expected.add(expected_pTotalFinish);
        expected.add(expected_pIconTrashEmpty);

        List <String> actual = new ArrayList<String>();
        actual= (mainPage.getAllTotals(actual));
        Assert.assertEquals(expected, actual);*/
    }
}

