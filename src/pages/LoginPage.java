package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    private final By usernameInput = By.name("id");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.className("meta_login_btn");
    private final By dashboardText = By.cssSelector(".ant-space-item span");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean verifyLoginPageTitle() {
        return getLoginPageTitle().equals("LOGIN");
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);

        clickLogin();
    }

    public boolean assertDashboardPage() {
        String currentUrl = driver.getCurrentUrl();
        assert (currentUrl.equalsIgnoreCase("https://bo.metaflyer.io/manager/dashboard"));

        WebElement dashboardText = driver.findElement(this.dashboardText);
        return dashboardText.getText().contentEquals("월간 사용량관리");
    }

    private void enterUsername(String username) {
        WebElement usernameInput = driver.findElement(this.usernameInput);
        if (usernameInput.isDisplayed()) {
            usernameInput.sendKeys(username);
        }
    }

    private void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(this.passwordInput);
        if (passwordInput.isDisplayed()) {
            passwordInput.sendKeys(password);
        }
    }

    private void clickLogin() {
        WebElement loginBtn = driver.findElement(this.loginButton);
        if (loginBtn.isDisplayed()) {
            loginBtn.click();
        }
    }
}
