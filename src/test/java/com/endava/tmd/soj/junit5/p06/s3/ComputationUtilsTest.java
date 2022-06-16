package com.endava.tmd.soj.junit5.p06.s3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.endava.tmd.soj.junit5.p06.s3.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {
    @ParameterizedTest(name = "{0}+{1}={2}")
    @MethodSource("testValidArgs")
    void testSum(int num1, int num2, int expec) {
        assertThat(sum(num1, num2)).isEqualTo(expec);
    }

    @ParameterizedTest(name = "{0}+{1} \u21D2 Overflow")
    @MethodSource("testMaxMinArgs")
    void testOverflowArgs(int a, int b) {
        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    static Stream<Arguments> testValidArgs() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 5, 5),
                Arguments.of(4, 4, 8)
        );
    }

    static Stream<Arguments> testMaxMinArgs() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, -1)
        );
    }
}
