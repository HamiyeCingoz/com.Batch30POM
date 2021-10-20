package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReaderIle extends TestBase {
    @Test
    public void positiveTestCongig(){
        //Bir test method olustur positiveLoginTest()
        // https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));
        // login butonuna bas
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        concortHotelPage.ilkLoginLinki.click();
        // test data username: manager ,
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUseranme"));
        // test data password : Manager1!
        concortHotelPage.passWordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.loginTusu.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed());

    }
}
