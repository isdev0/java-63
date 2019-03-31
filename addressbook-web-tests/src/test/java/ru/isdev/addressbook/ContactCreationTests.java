package ru.isdev.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class ContactCreationTests {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {

        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        goToTheMainPage();
        login("admin", "secret");

    }


    private void goToTheMainPage(){
        goToThePage("index.php");
    }

    private void goToTheContactsPage(){
        goToTheMainPage();
    }

    private void goToThePage(String page) {
        wd.get("http://localhost/addressbook/" + page);
    }

    @Test
    public void testContactCreationTests() throws Exception {
        goToTheContactsPage();
        initContactCreation();
        fillContactForm();
        submitContactCtreation();
    }

    private void submitContactCtreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    private void fillContactForm() {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("fname");
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys("mname");
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("lname");
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys("nname");
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys("title");
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys("company");
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys("address1\naddress2\naddress3");
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys("thome");
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys("tmobile");
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys("twork");
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys("tfax");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("email1");
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys("email2");
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys("email3");
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys("hpage");
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText("1");
        wd.findElement(By.cssSelector("option[value=\"1\"]")).click();
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("January");
        wd.findElement(By.cssSelector("option[value=\"January\"]")).click();
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys("2000");
        wd.findElement(By.name("aday")).click();
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText("10");
        wd.findElement(By.cssSelector("select[name=\"aday\"] > option[value=\"10\"]")).click();
        wd.findElement(By.name("amonth")).click();
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText("October");
        wd.findElement(By.cssSelector("select[name=\"amonth\"] > option[value=\"October\"]")).click();
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys("2010");
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys("secaddress1\nsecaddress2\nsecaddress3");
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys("sechome");
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys("note1\nnote2\nnote3");
    }

    private void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        logout();
        wd.quit();
    }


    private void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    private void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

}
