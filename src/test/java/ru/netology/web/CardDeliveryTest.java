package ru.netology.web;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDate;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.openqa.selenium.By.cssSelector;


public class CardDeliveryTest {

    @Test

    void shouldOrderCardDelivery(){
        open ("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Калуга");
        LocalDate today = LocalDate.now();
        LocalDate needDay = today.plusDays(3);
        $(cssSelector("[name='name']")).setValue("Тимофей Зверев");
        $(cssSelector("[name='phone']")).setValue("+79009999999");
        $("[data-test-id=agreement]").click();
        $(byClassName("button__text")).click();
        $("[data-test-id=notification]").shouldBe((appear), Duration.ofSeconds(15));

    }
}
