package com.endava.tmd.soj.junit5.p04;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
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
   @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(sum(0,Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }
    @Test
    void maxIntAndANegativeNumber() {
        assertThat(sum(Integer.MAX_VALUE,-10)).isEqualTo(2147483637);
    }
    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(sum(0,Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }
    @Test
    void minIntAndAPositiveNumber() {
        assertThat(sum(Integer.MIN_VALUE,10)).isEqualTo(-2147483638);
    }
    @Test
    void minIntAndMaxInt() {
        assertThat(sum(Integer.MIN_VALUE,Integer.MAX_VALUE)).isEqualTo(-1);
    }
    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(Integer.MAX_VALUE,10)).isEqualTo(2147483657L);
    }

}
