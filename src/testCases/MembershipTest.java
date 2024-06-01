package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MembershipTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://stg-fo.metaflyer.io/register");

        String joinElement = driver.findElement(By.className("metaflyer_select_individual_company_title")).getText();
        assert (joinElement.contentEquals("JOIN"));

        Thread.sleep(2000);

        WebElement individualSection = driver.findElement(By.cssSelector(".metaflyer_select_individual_company div:nth-child(1) p"));
        individualSection.click();

        Thread.sleep(2000);

        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement idInput = driver.findElement(By.id("id"));
        WebElement checkEmailButton = driver.findElement(By.className("button-check-email"));
        WebElement pwdInput = driver.findElement(By.id("password"));
        WebElement pwdVerifyInput = driver.findElement(By.id("password-verify"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement phoneInput = driver.findElement(By.id("phone"));

        nameInput.sendKeys("Nancy");
        idInput.sendKeys("username");
        checkEmailButton.click();
        pwdInput.sendKeys("Password@123abcd");
        pwdVerifyInput.sendKeys("Password@123abcd");
        emailInput.sendKeys("email@gmail.com");
        phoneInput.sendKeys("08222222222");

        WebElement ageVerifyCheckbox = driver.findElement(By.cssSelector("label[for='term4']"));
        WebElement agreeTermsCheckbox = driver.findElement(By.cssSelector("label[for='term1']"));
        WebElement agreePolicyCheckbox = driver.findElement(By.cssSelector("label[for='term2']"));

        ageVerifyCheckbox.click();
        agreeTermsCheckbox.click();
        agreePolicyCheckbox.click();

        WebElement registerButton = driver.findElement(By.cssSelector(".metaflyer_register_form_action button:last-child"));
        registerButton.click();

        Thread.sleep(3000);

        WebElement successText = driver.findElement(By.className("metaflyer_register_completed_title"));
        assert (successText.getText().contentEquals("회원가입 완료"));
    }
}
