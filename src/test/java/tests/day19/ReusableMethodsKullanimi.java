package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class ReusableMethodsKullanimi {
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/windows adresine gidelim
        //click hier yazisina basalim

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        String ilkSayfaHandleDegeri=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
       Set<String> windowHandleKumesi= Driver.getDriver().getWindowHandles();

       String ikinciSayfaHandleDEgeri="";
        for (String each:windowHandleKumesi
             ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDEgeri=each;

            }

        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDEgeri);
        System.out.println(Driver.getDriver().getTitle());

        //yeni sayfada new window yazisinin gorundugunu test edelim
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(newWindowYaziElementi.isDisplayed());

    }
    @Test
    public void testReusableIle(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}
