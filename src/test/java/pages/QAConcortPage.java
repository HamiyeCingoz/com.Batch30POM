package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QAConcortPage {
    WebDriver driver;
  public  QAConcortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id="UserName")
    public WebElement usernameKutusu;

    @FindBy(id="Password")
    public WebElement passWordKutusu;

    @FindBy(id="btnSubmit")
    public WebElement loginTusu;
    @FindBy(xpath="//span[@class='caption-subject font-green-sharp bold uppercase']")
    public  WebElement basariliGirisYaziElementi;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement loginFailedYazisi;
}
