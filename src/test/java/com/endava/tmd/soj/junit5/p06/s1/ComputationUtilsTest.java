package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
class ComputationUtilsTest {
   @ParameterizedTest(name="{0}+{1}={2}")
   @CsvSource({
           "0,0,0",
           "0,5,5",
           "-10,0,-10",
           "3,3,6",
           "-8,-3,-11",
           "-4,22,18",
           "-40,20,-20"
   })
void testSum(int num1,int num2,int expec){
       assertThat(sum(num1, num2)).isEqualTo(expec);
   }
    @ParameterizedTest(name="{0}+{1} \u21D2 Overflow" )
    @CsvSource({"2147483647,1",
                 "-2147483648,-1" })
    void testOverflowArgs(int a, int b) {
        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
