package ru.sli.stack.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.sli.stack.utils.Validations.validateEmail;

@DisplayName("Проверка корректности ввода email")
class ValidationsTest {

    @DisplayName("email не пустой")
    @Test
    void throwsExceptionWhenNull() {
        assertThrows(RuntimeException.class, () -> validateEmail(null));
    }

    @DisplayName("email содержит @")
    @Test
    void returnsFalseWhenNoAt() {
        assertEquals(false, validateEmail("rrmailru"));
    }

    @DisplayName("email содержит точку")
    @Test
    void returnsFalseWhenNoDot() {
        assertEquals(false, validateEmail("rr@mailru"));
    }

    @DisplayName("символ @ стоит левее точки")
    @Test
    void returnsFalseWhenAtNotLeftDot() {
        assertEquals(false, validateEmail("eeeere.r@malru"));
    }

    @DisplayName("между @ и точкой есть символы")
    @Test
    void returnsFalseWhenEmptyBetweenAtAndDot() {
        assertEquals(false, validateEmail("www@.mail"));
    }

    @DisplayName("есть символы после точки")
    @Test
    void returnsFalseWhenEmptyAfterDot() {
        assertEquals(false, validateEmail("www@tt."));
    }

    @DisplayName("есть символы перед @")
    @Test
    void returnsFalseWhenEmptyBeforeAt() {
        assertEquals(false, validateEmail("@ttrer.mail"));
    }

    @DisplayName("в email не больше одной @")
    @Test
    void returnsFalseWhenMoreThenOneAt() {
        assertEquals(false, validateEmail("rr@tt@rer.mail"));
    }

    @DisplayName("в email адресе все хорошо")
    @Test
    void returnsTrueWhenAllCorrect() {
        assertEquals(true, validateEmail("gamer@gmail.ru"));
    }
}