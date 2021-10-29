package tests.day17_ExelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class C01_ReadExel {
    @Test
    public void test() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(2);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);
        System.out.println(cell);
    }
    @Test
    public void test2() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)

        //12. Row objesi olusturun sheet.getRow(index)

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=workbook.getSheet("sayfa1").getRow(3).getCell(5);
        System.out.println(cell);

        //secilen hucredeki yazinin luanda oldugunu test edin
        //cell in data turu cell ruanda nin ise string
        //data turleri farkli oldugu icin bu ikisi equlse olamaz
        Assert.assertEquals(cell.toString(),"Luanda");
        Assert.assertEquals(cell.getRichStringCellValue(),"Luanda");


        //// indexi 3 olan satirdaki indexi 2 olan yaziyi buyuk harfle yazdirin

        Cell cell1=workbook.getSheet("sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase());
    }

        }
