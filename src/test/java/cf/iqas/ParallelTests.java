package cf.iqas;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParallelTests {


    @ValueSource(strings = {
            "steam",
            "epic games store",
            "uplay",
            "gog"
    })
    @ParameterizedTest
    void yandexSearchTest(String searchQuery){
      Selenide.open("http://ya.ru");
      Selenide.$(".input__control").setValue(searchQuery);
      Selenide.$("button[type='submit']").click();
      Selenide.$$(".serp-item").shouldBe(CollectionCondition.sizeGreaterThan(0))
              .get(1)
              .shouldHave(Condition.text(searchQuery));
    }
}
