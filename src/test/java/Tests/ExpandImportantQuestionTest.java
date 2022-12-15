package Tests;
import PageObjectsPackage.HomePageObjects;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class ExpandImportantQuestionTest {
    private WebDriver driver;
    private final String questionToOpen;
    private final String expectedAnswer;

    public ExpandImportantQuestionTest(String questionToOpen, String expectedAnswer){
        this.questionToOpen = questionToOpen;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли заказать самокат прямо на сегодня?", "Неть!"},
        };
    }

    @Test
    public void expandQuestionGetText(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageObjects objForImpQuestions = new HomePageObjects(driver);
        String question = questionToOpen;
        String expAnswer = expectedAnswer;
        objForImpQuestions.scrollToImportantQuestions();
        objForImpQuestions.confirmCookie();
        objForImpQuestions.expandQuestion(question);
        String actAnswer = objForImpQuestions.getExpandedAnswerText();
        System.out.println("Expected answer: "+expAnswer+"");
        System.out.println("Actual answer: "+actAnswer+"");
        assertThat("Неожидаемый результат: Текст открытого ответа не соответствует ожидаемому.", actAnswer, is(expAnswer));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
