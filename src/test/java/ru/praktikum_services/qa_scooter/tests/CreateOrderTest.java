package ru.praktikum_services.qa_scooter.tests;
import ru.praktikum_services.qa_scooter.pom.CreateOrderPageObjects;
import ru.praktikum_services.qa_scooter.pom.HomePageObjects;

import static ru.praktikum_services.qa_scooter.constants.Url.HOME_PAGE_URL;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Parameterized.class)
public class CreateOrderTest {
    private WebDriver driver;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String stationName;
    private final String phoneNumber;
    // form2
    private final String date;
    private final String time;
    private final String commentText;
    private final String color;

    public CreateOrderTest(String firstName, String lastName, String address, String stationName, String phoneNumber, String date, String time, String commentText, String color){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.stationName = stationName;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.time = time;
        this.commentText = commentText;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Иван", "Иванов", "Москва, Русаковская улица, 31", "Сокольники","+79208475757","12.12.2022", "трое суток", "Позвоните, когда будете подъезжать", "чёрный жемчуг"},
                {"Екатерина", "Архипова", "Большая Черкизовская улица, 26", "Черкизовская","+79273672190","12.08.2022", "пятеро суток", "-", "серая безысходность"},
        };
    }
    @Test
    public void createOrderFromUpperButton(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
        HomePageObjects objHomePage = new HomePageObjects(driver);
        objHomePage.confirmCookie();
        objHomePage.clickUpperOrderBtn();
        CreateOrderPageObjects objCreateOrder = new CreateOrderPageObjects(driver);
        objCreateOrder.fillAndCompleteOrderFirstForm(firstName, lastName, address, stationName, phoneNumber);
        objCreateOrder.fillAndCompleteOrderSecondForm(date, time, commentText, color);
        objCreateOrder.confirmOrderCreation();
        objCreateOrder.checkIfCompleteOrderPopupShown();
    }
    @Test
    public void createOrderFromMiddleButton(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
        HomePageObjects objHomePage = new HomePageObjects(driver);
        objHomePage.confirmCookie();
        objHomePage.clickMiddleOrderBtn();
        CreateOrderPageObjects objCreateOrder = new CreateOrderPageObjects(driver);
        objCreateOrder.fillAndCompleteOrderFirstForm(firstName, lastName, address, stationName, phoneNumber);
        objCreateOrder.fillAndCompleteOrderSecondForm(date, time, commentText, color);
        objCreateOrder.confirmOrderCreation();
        objCreateOrder.checkIfCompleteOrderPopupShown();
    }
    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}

