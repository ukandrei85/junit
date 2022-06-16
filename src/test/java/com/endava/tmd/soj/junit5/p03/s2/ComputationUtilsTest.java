package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {
    @Test
    @DisplayName(value="0+0=0")
    @Order(1)
    public void zeroShouldNotChangeZero() {

        assertThat(sum(0, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName(value="0+5=5")
    @Order(2)
    void zeroShouldNotChangePositive() {
        assertThat(sum(0, 5)).isEqualTo(5);
    }

    @Test
    @DisplayName(value="-10+0=-10")
    @Order(3)
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-10, 0)).isEqualTo(-10);
    }

    @Test
    @DisplayName(value="3+3=6")
    @Order(4)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(3, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName(value="-8+(-3)=-11")
    @Order(5)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-8, -3)).isEqualTo(-11);
    }

    @Test
    @DisplayName(value="-4+22=18")
    @Order(6)
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-4, 22)).isEqualTo(18);
    }

    @Test
    @DisplayName(value="-40+20=-20")
    @Order(7)
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-40, 20)).isEqualTo(-20);
    }
}
