package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {
    @Test
    public void test(){
        //https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));
        // login butonuna bas
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        concortHotelPage.ilkLoginLinki.click();

        // test data username: manager1 ,
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHInvalidUseranme"));
        // test data password : manager1!
        concortHotelPage.passWordKutusu.sendKeys(ConfigReader.getProperty("CHInvalidPassword")+Keys.ENTER);
        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHotelPage.loginFailedYazisi.isDisplayed());
    }
}
