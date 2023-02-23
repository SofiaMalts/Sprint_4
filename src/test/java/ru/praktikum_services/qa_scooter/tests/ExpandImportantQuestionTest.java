package ru.praktikum_services.qa_scooter.tests;
import ru.praktikum_services.qa_scooter.pom.HomePageObjects;
import ru.praktikum_services.qa_scooter.constants.Url;
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
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void expandQuestionGetText(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url.HOME_PAGE_URL);
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
