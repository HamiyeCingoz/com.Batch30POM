package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    @Test
    public void yanlisSifre(){
        //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
        //3 Farkli test Methodunda 3 senaryoyu test et
        // - yanlisSifre
        // - yanlisKulllanici
        // - yanlisSifreKullanici
        //test data yanlis username: manager1 , yanlis password : manager1!
        //2) https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();

        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUseranme"));

        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        qaConcortPage.loginButonu.click();
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());
    }
    @Test
    public void yanlisKullaniciAdi(){

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();

        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUseranme"));

        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());
    }
    @Test
    public void yanlisSifreKullanici(){

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();

        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUseranme"));

        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        qaConcortPage.loginButonu.click();
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());
        Driver.closeDriver();
    }
}
