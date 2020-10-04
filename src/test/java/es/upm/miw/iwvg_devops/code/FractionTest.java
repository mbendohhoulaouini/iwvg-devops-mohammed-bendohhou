package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void before() {
        fraction = new Fraction(2, 3);
    }

    @Test
    void testFractionIntInt() {
        assertEquals(2, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    void testFractionInt() {
        fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testFractionDecimalInt() {
        fraction = new Fraction();
        assertEquals(1, fraction.decimal());
    }

    @Test
    void testFractionDecimalPeriodicDouble() {
        assertEquals(0.66, fraction.decimal(), 10e-3);
    }

    @Test
    void testFractionConvertDecimalError() {
        fraction = new Fraction(1, 0);
        assertEquals(0, fraction.getDenominator() / fraction.getNumerator());
    }

    @Test
    void testFractionModify() {
        fraction = new Fraction();
        assertEquals(1,fraction.decimal());
        fraction.setNumerator(10);
        fraction.setDenominator(5);
        assertEquals(2,fraction.decimal());
    }

}
