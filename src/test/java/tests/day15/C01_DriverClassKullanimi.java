package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

       // Driver driver=new Driver();
        //driver classindan obje uretilemesin istedigimiz icin driver classi SINGLETON yapiyoruz
        // bunun icin default constructor yerine parametresiz bir constructor olusturup
        // accesmodifieri private yaptik
       // Driver driver=new Driver("ben istedim ama olmadi");
        // driver classinda parametreli constructor olmadigi icin kullanilamaz
        Driver.closeDriver();

    }
}
