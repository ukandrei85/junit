package com.endava.tmd.soj.junit5.p05.s1;

import com.endava.tmd.soj.junit5.p01.ComputationUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s2.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Provocare: Copiati metodele de test din tema precedenta, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare
class ComputationUtilsTest {
    @Test
    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
       // JUnit way of checking the exception class
//        assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
      ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(2147483647, 1))
               .isInstanceOf(ArithmeticException.class)
               .hasMessage("Overflow while computing the sum");
    }
    @Test
   @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        assertThatThrownBy(() -> sum(-2147483648, -1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");

    }
    @Test
    @DisplayName(value="0+0=0")
    @Order(1)
    public void zeroShouldNotChangeZero() {

        assertThat(ComputationUtils.sum(0, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName(value="0+5=5")
    @Order(2)
    void zeroShouldNotChangePositive() {
        assertThat(ComputationUtils.sum(0, 5)).isEqualTo(5);
    }

    @Test
    @DisplayName(value="-10+0=-10")
    @Order(3)
    void zeroShouldNotChangeNegative() {
        assertThat(ComputationUtils.sum(-10, 0)).isEqualTo(-10);
    }

    @Test
    @DisplayName(value="3+3=6")
    @Order(4)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(ComputationUtils.sum(3, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName(value="-8+(-3)=-11")
    @Order(5)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(ComputationUtils.sum(-8, -3)).isEqualTo(-11);
    }

    @Test
    @DisplayName(value="-4+22=18")
    @Order(6)
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(ComputationUtils.sum(-4, 22)).isEqualTo(18);
    }

    @Test
    @DisplayName(value="-40+20=-20")
    @Order(7)
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(ComputationUtils.sum(-40, 20)).isEqualTo(-20);
    }
    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(ComputationUtils.sum(0,Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }
    @Test
    void maxIntAndANegativeNumber() {
        assertThat(ComputationUtils.sum(Integer.MAX_VALUE,-10)).isEqualTo(2147483637);
    }
    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(ComputationUtils.sum(0,Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }
    @Test
    void minIntAndAPositiveNumber() {
        assertThat(ComputationUtils.sum(Integer.MIN_VALUE,10)).isEqualTo(-2147483638);
    }
    @Test
    void minIntAndMaxInt() {
        assertThat(ComputationUtils.sum(Integer.MIN_VALUE,Integer.MAX_VALUE)).isEqualTo(-1);
    }
    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(ComputationUtils.sum(Integer.MAX_VALUE,10)).isEqualTo(2147483657L);
    }

}
