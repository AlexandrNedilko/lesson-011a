package pages;

import org.openqa.selenium.WebDriver;
import pages.attributes.AlreadyRegistered;
import pages.attributes.CreateAccountAttribute;

public class SignInPage {

    private WebDriver driver;

    private AlreadyRegistered alreadyRegistered;
    private CreateAccountAttribute createAccountAttribute;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage createNewAccountWithEmail(String email){
        createAccountAttribute = new CreateAccountAttribute(driver);
        return createAccountAttribute.typeEmail(email).clickCreateAnAccount();
    }
}