package com.endava.tmd.soj.junit5.p01;


// Provocari:
// 1. Adaugati adnotarea neecesara pentru a rula prima metoda ca si un test unitar
// 2. Rulati prima metoda ca si un test unitar
// 3. Decomentati asertiile din primul test, si efectuati importurile necesare. Rulati testul din nou.
// 4. Adaugati o linie care sa determine testul sa fie "failed". La sfarsit commentati acea linie
// 5. Completati celelalte metode astfel incat sa reprezinte scenarii de testare

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputationUtilsTest {
    @Test
    public void zeroShouldNotChangeZero() {

        assertEquals(0, sum(0,0));

        //  AssertJ Assertion
        assertThat(sum(0, 0)).isEqualTo(0);
    }
    @Test
    void zeroShouldNotChangePositive() {

        assertThat(sum(0,5)).isEqualTo(5);
    }
    @Test
    void zeroShouldNotChangeNegative() {

        assertThat(sum(-10,0)).isEqualTo(-10);
    }
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {

        assertThat(sum(3,3)).isEqualTo(6);
    }
    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {

        assertThat(sum(-8,-3)).isEqualTo(-11);
    }
    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-4,22)).isEqualTo(18);
    }
    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-40,20)).isEqualTo(-20);
    }

}
