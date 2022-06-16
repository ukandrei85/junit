package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise


@TestMethodOrder(MethodOrderer.MethodName.class)
class ComputationUtilsTest {

    @Test
    @DisplayName(value="0+0=0")
    public void zeroShouldNotChangeZero() {

        assertThat(sum(0, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName(value="0+5=5")
    void zeroShouldNotChangePositive() {
        assertThat(sum(0, 5)).isEqualTo(5);
    }

    @Test
    @DisplayName(value="-10+0=-10")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-10, 0)).isEqualTo(-10);
    }

    @Test
    @DisplayName(value="3+3=6")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(3, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName(value="-8+(-3)=-11")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-8, -3)).isEqualTo(-11);
    }

    @Test
    @DisplayName(value="-4+22=18")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-4, 22)).isEqualTo(18);
    }

    @Test
    @DisplayName(value="-40+20=-20")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-40, 20)).isEqualTo(-20);
    }
}
