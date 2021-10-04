package ru.netology.web;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.openqa.selenium.By.cssSelector;


public class CardDeliveryTest {
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDate nextDate = date.plusDays(5);

    @Test
    void shouldOrderCardDelivery(){
        open ("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Калуга");
        $("[data-test-id=date] input").doubleClick().sendKeys(formatter.format(nextDate));
        $(cssSelector("[name='name']")).setValue("Тимофей Зверев");
        $(cssSelector("[name='phone']")).setValue("+79009999999");
        $("[data-test-id=agreement]").click();
        $(byClassName("button__text")).click();
        $("[data-test-id=notification]").shouldBe((appear), Duration.ofSeconds(15));
        $("[data-test-id=notification]").shouldHave(exactText("Успешно!" + "\n"
                   + "Встреча успешно забронирована на " + "09.10.2021"));

    }
}
