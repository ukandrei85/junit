package com.endava.tmd.soj.junit5.p02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat:
// 1. Sa fie afisat "Tests for my sum method" in loc de "ComputationUtilsTest"
// 2. La fiecare test sa fie afisata suma. De exemplu "zeroShouldNotChangeZero" ar trebui sa fie inlocuit cu "0 + 0 = 0"
@DisplayName("Tests for my class")
class ComputationUtilsTest {

    @Test
    @DisplayName(value="0+0=0")
    public void zeroShouldNotChangeZero() {

        assertEquals(0, sum(0,0));

        //  AssertJ Assertion
        assertThat(sum(0, 0)).isEqualTo(0);
    }
    @Test
    @DisplayName(value="0+5=5")
    void zeroShouldNotChangePositive() {
        assertThat(sum(0,5)).isEqualTo(5);
    }
    @Test
    @DisplayName(value="-10+0=-10")
    void zeroShouldNotChangeNegative() {

        assertThat(sum(-10,0)).isEqualTo(-10);
    }
    @Test
    @DisplayName(value="4+4=8")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {

        assertThat(sum(4,4)).isEqualTo(8);
    }
    @Test
    @DisplayName(value="(-8)+(-3)=-11")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {

        assertThat(sum(-8,-3)).isEqualTo(-11);
    }
    @Test
    @DisplayName(value="(-4)+22=18")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-4,22)).isEqualTo(18);
    }
    @Test
    @DisplayName(value="(-40)+20=-20")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-40,20)).isEqualTo(-20);
    }
}
