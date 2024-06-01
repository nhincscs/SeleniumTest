package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    public LoginPage loginPage;

    @Test
    public void login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

        loginPage.login("username", "Password@123abcd");
        Thread.sleep(3000);
        loginPage.assertDashboardPage();
    }

}