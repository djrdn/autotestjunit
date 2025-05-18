package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginClass {
    @Test
    public void testLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shef\\Desktop\\Навчання QA\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
//        try{
//            Thread.sleep(100);
//        }
//        catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("ipz23-d.serhiienko@nubip.edu.ua");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("213");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
        String result = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]")).getText();

        //Очікуваємий результат
        Assert.assertEquals("Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.", result);

        driver.quit();
    }
}
