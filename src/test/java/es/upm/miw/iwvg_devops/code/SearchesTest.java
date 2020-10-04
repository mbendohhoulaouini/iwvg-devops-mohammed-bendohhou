package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(List.of("Torres"), new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertEquals(List.of(2, 4, 0, 1, 1), new Searches().findFractionNumeratorByUserFamilyName("Torres")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(List.of("López", "Torres"), new Searches().findUserFamilyNameByFractionDenominator(2)
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserNameByAnyImproperFraction() {
        List<Double> listFractions = new Searches().findDecimalImproperFractionByUserName("Ana")
                .collect(Collectors.toList());
        assertEquals(2, listFractions.size());
        assertEquals(2.0, listFractions.get(0), 10e-1);
        assertEquals(1.3, listFractions.get(1), 10e-1);
    }

    @Test
    void testFindUserIdByAllProperFraction() {
        assertEquals(0, new Searches().findUserIdByAllProperFraction()
                .collect(Collectors.toList()).size());

    }

}
