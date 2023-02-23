package ru.praktikum_services.qa_scooter.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class CreateOrderPageObjects {
    private WebDriver driver;
    //First form objects
    //Title
    private By formHeader = By.xpath(".//div[text() = 'Для кого самокат']");
    // First Name xpath (.//input[@placeholder = '* Имя'])
    private By firstNameField = By.xpath(".//input[@placeholder = '* Имя']");
    // Last Name xpath (.//input[@placeholder = '* Фамилия'])
    private By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    // Address xpath (.//input[@placeholder = '* Адрес: куда привезти заказ'])
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Metro xpath (.//input[@class = 'select-search__input'])
    private By subwayField = By.xpath(".//input[@class = 'select-search__input']");
    private By subwayDdl = By.xpath(".//div[@class = 'select-search__select']");
    // Phone xpath (.//input[@placeholder = '* Телефон: на него позвонит курьер'])
    private By phoneNumberField = By.xpath (".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Кнопка "Далее" (xpath (.//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']))
    private By nextBtn = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Second form objects
    private By whenToSendField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    // Календарь  div class = react-datepicker
    private By whenToSendCalendar = By.xpath(".//div[@class = 'react-datepicker']");
    private By selectedDateInCalendar = By.xpath(".//div[@class = 'react-datepicker__week']/div[contains(@class, 'selected')]");
    //Срок аренды  div class = Dropdown-placeholder
    private By rentTime = By.xpath(".//div[@class = 'Dropdown-placeholder' and text() = '* Срок аренды']");
    private By rentTimeDdl = By.xpath(".//div[@class = 'Dropdown-menu']");
    // Цвет самоката
    // черный жемчуг чекбокс
    private By blackColorCheckBox = By.xpath(".//input[@class = 'Checkbox_Input__14A2w' and @id = 'black']");
    // серая безысходность чекбокс
    private By greyColorCheckBox = By.xpath(".//input[@class = 'Checkbox_Input__14A2w' and @id = 'grey']");
    // Комментарий для курьера  input @placeholder =Комментарий для курьера
    private By comment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка "Назад" button @class=Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i
    private By backBtn = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    // Кнопка "Заказать" button @class = 'Button_Button__ra12g Button_Middle__1CSJM'
    private By submitBtn = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Confirm Order
    //Confirm Order Title
    private By confirmationPopupHeader = By.xpath(".//div[text() = 'Хотите оформить заказ?']");
    // "No" button
    private By confirmationPopupNoBtn = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text() = 'Нет']");
    // "Yes" button
    private By confirmationPopupYesBtn = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    // Order completion form
    // Order completed form title
    private By completedPopupHeader = By.xpath(".//div[text() = 'Заказ оформлен']");
    public CreateOrderPageObjects(WebDriver driver){
        this.driver = driver;
    }
    public void waitUntilFirstFormOpened(){
        List<WebElement> listOfAllFields = new ArrayList<WebElement>();
        listOfAllFields.add(driver.findElement(formHeader));
        listOfAllFields.add(driver.findElement(firstNameField));
        listOfAllFields.add(driver.findElement(lastNameField));
        listOfAllFields.add(driver.findElement(addressField));
        listOfAllFields.add(driver.findElement(subwayField));
        listOfAllFields.add(driver.findElement(phoneNumberField));
        listOfAllFields.add(driver.findElement(nextBtn));
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOfAllElements(listOfAllFields));

    }
    public void waitUntilSecondFormOpened(){
        List<WebElement> listOfAllElements = new ArrayList<WebElement>();
        listOfAllElements.add(driver.findElement(whenToSendField));
        listOfAllElements.add(driver.findElement(rentTime));
        listOfAllElements.add(driver.findElement(blackColorCheckBox));
        listOfAllElements.add(driver.findElement(greyColorCheckBox));
        listOfAllElements.add(driver.findElement(comment));
        listOfAllElements.add(driver.findElement(backBtn));
        listOfAllElements.add(driver.findElement(submitBtn));
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOfAllElements(listOfAllElements));
    }
    public void checkIfElementReady(WebElement element){
        String fieldPlaceholder = element.getAttribute("placeholder");
        assertTrue("Элемент "+fieldPlaceholder+" не отображается", element.isDisplayed());
        assertTrue("Элемент "+fieldPlaceholder+" неактивен", element.isEnabled());
    }
    public void checkEnteredValueInField(WebElement field, String expEntry){
        String fieldValue = field.getAttribute("value");
        String fieldName = field.getAttribute("placeholder");
        assertThat("Не введены данные в поле "+fieldName+".", expEntry, is(not("")));
        assertThat("Некорректные данные введены в поле "+fieldName+".", expEntry, is(fieldValue));
    }
    public void enterValueIntoField(By locator, String value){
        WebElement field = driver.findElement(locator);
        checkIfElementReady(field);
        field.click();
        field.sendKeys(value);
        checkEnteredValueInField(field, value);
    }
    public void clickElement(WebElement element){
        checkIfElementReady(element);
        element.click();
    }
    public void clickElementByLocator(By locator){
        WebElement element = driver.findElement(locator);
        checkIfElementReady(element);
        element.click();
    }

    public void selectItemFromInputDdl(WebElement input, By ddlLocator, String valueToSelect){
        input.click();
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.presenceOfElementLocated(ddlLocator));
        driver.findElement(By.xpath(".//*[text() = '"+valueToSelect+"']")).click();
    }
    public void selectSubwayStationByText(String stationName){
        WebElement field = driver.findElement(subwayField);
        checkIfElementReady(field);
        selectItemFromInputDdl(field, subwayDdl, stationName);
        checkEnteredValueInField(field, stationName);
    }
    public void checkEnteredRentTime(WebElement field, String expEntry){
        String fieldValue = field.getText();
        assertThat("Не введены данные в поле 'Время аренды'.", expEntry, is(not("")));
        assertThat("Некорректные данные введены в поле 'Время аренды'.", expEntry, is(fieldValue));
    }
    public void selectRentTimeByText(String time){
        WebElement field = driver.findElement(rentTime);
        checkIfElementReady(field);
        selectItemFromInputDdl(field, rentTimeDdl, time);
        checkEnteredRentTime(field, time);
    }
    public void clickSelectedDateInCalendar(){
        WebElement dateInCalendar = driver.findElement(selectedDateInCalendar);
        clickElement(dateInCalendar);
    }
    public void enterAndSelectDate(String date){
        enterValueIntoField(whenToSendField, date);
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(whenToSendCalendar));
        clickSelectedDateInCalendar();
        checkEnteredValueInField(driver.findElement(whenToSendField), date);

    }
    public void clickCheckboxByText(String color){
        WebElement checkBox = driver.findElement(By.xpath(".//label[@class = 'Checkbox_Label__3wxSf' and contains(text(), '"+color+"')]/input"));
        checkIfElementReady(checkBox);
        clickElement(checkBox);
    }
    public void waitUntilConfirmationFormOpened(){
        List<WebElement> listOfAllElements = new ArrayList<WebElement>();
        listOfAllElements.add(driver.findElement(confirmationPopupHeader));
        listOfAllElements.add(driver.findElement(confirmationPopupNoBtn));
        listOfAllElements.add(driver.findElement(confirmationPopupYesBtn));
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOfAllElements(listOfAllElements));
    }

    public void checkIfConfirmationFormReady(){
        waitUntilConfirmationFormOpened();
        assertTrue("Заголовок формы подтверждения не отображается", driver.findElement(confirmationPopupHeader).isDisplayed());
        assertTrue("Кнопка 'Нет' формы подтверждения не отображается", driver.findElement(confirmationPopupNoBtn).isDisplayed());
        assertTrue("Кнопка 'Нет' формы подтверждения неактивна",driver.findElement(confirmationPopupNoBtn).isEnabled());
        assertTrue("Кнопка 'Да' формы подтверждения не отображается",driver.findElement(confirmationPopupYesBtn).isDisplayed());
        assertTrue("Кнопка 'Да' формы подтверждения неактивна",driver.findElement(confirmationPopupYesBtn).isEnabled());
    }
    public void fillAndCompleteOrderFirstForm(String firstName, String lastName, String address, String stationName, String phoneNumber){
        waitUntilFirstFormOpened();
        enterValueIntoField(firstNameField, firstName);
        enterValueIntoField(lastNameField, lastName);
        enterValueIntoField(addressField, address);
        selectSubwayStationByText(stationName);
        enterValueIntoField(phoneNumberField, phoneNumber);
        clickElementByLocator(nextBtn);
    }
    public void fillAndCompleteOrderSecondForm(String date, String time, String commentText, String color){
        waitUntilSecondFormOpened();
        enterAndSelectDate(date);
        selectRentTimeByText(time);
        clickCheckboxByText(color);
        enterValueIntoField(comment, commentText);
        clickElementByLocator(submitBtn);
    }
    public void confirmOrderCreation(){
        checkIfConfirmationFormReady();
        clickElementByLocator(confirmationPopupYesBtn);
    }
    public void checkIfCompleteOrderPopupShown(){
        assertTrue("Всплывающее окно с сообщением об успешном создании заказа не отображается", driver.findElements(completedPopupHeader).size() != 0);
    }

}

