package PageObjectsPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class HomePageObjects {
    private WebDriver driver;
    // Принять куки
    private By confirmCookieBtn = By.xpath(".//button[@class = 'App_CookieButton__3cvqF']");
    // Раздел с вопросами о важном
    private By importantQuestionSection = By.xpath(".//div[@class = 'Home_FourPart__1uthg']");
    // Открытый ответ на вопрос
    private By openedAnswer = By.xpath(".//div[@class = 'accordion__panel' and not(@hidden)]/p");
    // Верхняя кнопка "Заказать"
    private By upperCreateOrderBtn = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    // Нижняя кнопка "Заказать"
    private By middleCreateOrderBtn = By.xpath(".//button[@class = 'Button_Button__ra12g Button_UltraBig__UU3Lp' and text() = 'Заказать']");
    public HomePageObjects(WebDriver driver){
        this.driver = driver;
    }
    public void confirmCookie(){
        WebElement button = driver.findElement(confirmCookieBtn);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(button));
        button.click();

    }
    // Important Questions Scenario
    public void scrollToImportantQuestions(){
        WebElement questionsSection = driver.findElement(importantQuestionSection);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionsSection);
    }
    public void scrollToMiddleOrderBtn(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(middleCreateOrderBtn));
    }
    public void expandQuestion(String question){
        WebElement questionElement =driver.findElement(By.xpath(".//div[text() = '"+question+"']"));
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.elementToBeClickable(questionElement));
        questionElement.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(questionElement, "aria-expanded", "true"));
    }
    public String getExpandedAnswerText(){
        String answerText = driver.findElement(openedAnswer).getText();
        return answerText;
    }
    //Order Workflow
    public void clickUpperOrderBtn(){
        WebElement button = driver.findElement(upperCreateOrderBtn);
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }
    public void clickMiddleOrderBtn(){
        scrollToMiddleOrderBtn();
        WebElement button = driver.findElement(middleCreateOrderBtn);
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }


}
