import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Home {

    private String url = "https://portal-staging.parent.eu/login";
    private String username = "demo@parent.eu";
    private String password = "12345678";
    public static WebDriver driver;
    private static WebDriverWait driverWait ;


    @Test
    public void createNewEvent() {

        System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 50000);
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.id("txtEmail")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("submitBtn")).sendKeys(Keys.ENTER);
        driverWait.until(ExpectedConditions.elementToBeClickable((By.id("navigateToRolesBtn"))));
        driver.findElement(By.xpath("/html/body/app-root/app-main-layout/main/app-institution/div/div[2]/div/div[2]/div[1]/div[5]/span")).click();
        driverWait.until(ExpectedConditions.elementToBeClickable((By.id("addNewRoomBtn"))));
        driver.findElement(By.xpath("//*[@id=\"calendarTab\"]/i")).click();
        driverWait.until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/app-root/app-main-layout/main/app-view-calendar/div/prt-calendar/prt-calendar-week[1]/section"))));
        driver.findElement(By.id("createEventBtn")).click();
        driverWait.until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/app-root/app-main-layout/main/app-create-event/div/div[2]/form/div/div/div[3]/div[2]/button[1]"))));
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("eventTitle")).sendKeys("New Event");
        driver.findElement(By.xpath("//*[@id=\"Recipients\"]/div/div/div[2]/input")).click();
        driverWait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"option_2\"]/div/span"))));
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"option_2\"]/div/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-main-layout/main/app-create-event/div/div[2]/form/div/div/prt-date-picker/div/div")).click();
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[5]/td[6]/span")).click();
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/app-root/app-main-layout/main/app-create-event/div/div[2]/form/div/div/div[1]/div[1]/prt-time-picker/div/button")).click();
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"timepicker_0\"]/table/tbody/tr[1]/td[1]/a/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-main-layout/main/app-create-event/div/div[2]/form/div/div/div[1]/div[2]/prt-time-picker/div/button")).click();
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"timepicker_0\"]/table/tbody/tr[1]/td[1]/a")).click();
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"timepicker_0\"]/table/tbody/tr[1]/td[1]/a")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-main-layout/main/app-create-event/div/div[2]/form/div/div/div[3]/div[2]/button[2]")).click();
        driverWait.until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/app-root/app-main-layout/main/app-view-calendar/div/prt-calendar/prt-calendar-week[1]/section"))));
        String actualResult = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div/div")).getText();
        Assert.assertEquals(actualResult, "Calendar event registered");
    }
}
