/*1. Create a new Maven project;
        2. Add TestNG dependency and Selenium Web Driver;
        3. Add several test classes and 4-5 tests to each class.
        4. Write @BeforeTest method where you should create your instance of a
        WebDriver.
        5. Write @AfterTest method where you should close your browser.
        6. Add a testng.xml configuration file.
        7. Configure the test suite to run all tests from the first class and only two from the second.
        8. Create a @DataProvider method to generate some data for your tests.
        9. Add your data provider to any test you wish.

        1) You can write your tests for any web site or for your project.
        2) You can use dataProvider to generate login information.*/
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    private final static String TITLE_PROCEED_TO_CHECKOUT = "//*[@title='Proceed to checkout']";

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    private WebElement womenTab;

    @FindBy(css = "#block_top_menu > ul > li.sfHoverForce > a")
    private WebElement dressesTab;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    private WebElement tShirtTab;

    @FindBy(xpath = "//*[@id='searchbox']/button")
    private WebElement search;

    @FindBy(xpath = "//*[@id='search_query_top']")
    private WebElement formSearch;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@class='product-image-container']")
    private WebElement itemView;

    @FindBy(className = "icon-th-list")
    private WebElement listView;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addCartButton;

    @FindBy(xpath = "//*[@id='list']/a")
    private WebElement getListView;

    @FindBy(xpath = TITLE_PROCEED_TO_CHECKOUT)
    private WebElement proceedCheckout;

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalSum;


    @FindBy(xpath = "//*[contains(@href,'controller=my-account')]")
    private WebElement singIn;

    @FindBy(xpath = "//*[@title='Contact Us']")
    private WebElement contactUs;

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement sizeLcheckbox;

//==========******myFirstPattern******==========//

    @FindBy(xpath = "//*[@id='center_column']/ul/li/div/div/div[3]/div/div[2]/a[1]/span")
    private WebElement tShirtCart;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
    private WebElement tProceedtoCheckout;

    @FindBy(xpath = "//*[@id='cart_quantity_up_2_7_0_0']/span/i")
    private WebElement tProceedtoPlus;

    @FindBy(xpath = "//*[@id='total_product']")
    private WebElement tTotalProducts;

    @FindBy(xpath = "//*[@id='total_shipping']")
    private WebElement tTotalShipping;

    @FindBy(xpath = "//*[@id='total_price_without_tax']")
    private WebElement tTotalSumm;

    @FindBy(xpath = "//*[@id='total_tax']")
    private WebElement tTotalTaxSumm;

    @FindBy(xpath = "//*[@id='total_price']")
    private WebElement tTotalFinishSumm;

    @FindBy(xpath = "//*[@id='2_7_0_0']/i")
    private WebElement tIconTrashBasket;

    @FindBy(css = "#center_column p.alert-warning")
    private WebElement tIconTrashBasketEmpty;

    public MainPage addCartClick() {
        tShirtCart.click();
        return this;
    }

    public MainPage proceedtoCheckoutClick() {
        tProceedtoCheckout.click();
        return this;
    }

    public MainPage plusClick() {
        tProceedtoPlus.click();
        return this;
    }

    /*public String pTotalProducts() {
          appearElement(tTotalProducts);
        return  tTotalProducts.getText();
    }

    public String pTotalShipping() {
        return tTotalShipping.getText();
    }

    public String pTotalSumm() {
        return tTotalSumm.getText();
    }

    public String pTotalTax() {
        return tTotalTaxSumm.getText();
    }

    public MainPage pTotalFinish() {
        tTotalFinishSumm.click();
        return this;
    }*/

    public MainPage pIconTrash() {
        tIconTrashBasket.click();
        return this;
    }

    public String pIconTrashEmpty() {
        return tIconTrashBasketEmpty.getText();
    }

    public boolean isPresent(By isRegister) {
        return this.driver.findElement(isRegister).isEnabled();
    }

//END//

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage clickWomenTab() {
        womenTab.click();
        return this;
    }

    public MainPage clickDressesTab() {
        dressesTab.click();
        return this;
    }

    public MainPage clickTShirtTab() {
        tShirtTab.click();
        return this;
    }

    public SignInPage clickSignIn(){
        singIn.click();
        return new SignInPage(driver);
    }

    public MainPage selectSizeL(){
        sizeLcheckbox.click();
        return this;
    }

    public void clickAddToCart(){
        addCartButton.click();
    }

    public void navigateToItemView () {
        Actions actions = new Actions(driver);
        actions.moveToElement(itemView).build().perform();
    }

    public void scrollToItem(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", itemView);
    }

    public void clickProceedToCheckout() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.
                        xpath(TITLE_PROCEED_TO_CHECKOUT))).click();
    }

    //my sequel myFirstPattern//
    public String getTotalPrice(){
        return totalSum.getText();
    }

    public void enterSomeBody_andClick(String someone) {

        formSearch.sendKeys(someone);
        search.click();
        getListView.click();

    }

    public void appearElement( final WebElement element, final String exp){
        Wait wait = new WebDriverWait(this.driver, 25)
                .ignoring(NoSuchElementException.class);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                // System.out.println("apply wait "+exp );
                return element.getText().equals(exp);
            }
            public String toString() {      return null;            }
        });
    }

    public List getAllTotals(List list) {
        appearElement(tTotalProducts, "$54.00");
        list.add(getSummary(tTotalProducts));
        list.add(getSummary(tTotalShipping));
        list.add(getSummary(tTotalSumm));
        list.add(getSummary(tTotalTaxSumm));
        list.add(getSummary(tTotalFinishSumm));
        pIconTrash(); //icon-trash
        appearElement(tIconTrashBasketEmpty, "Your shopping cart is empty.");
        list.add(getSummary(tIconTrashBasketEmpty));
        return list;
    }

    private String getSummary(WebElement webElement) {
        return webElement.getText();
    }

}

