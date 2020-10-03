package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {

    private User user;

    private List<Fraction> fractions;

    @BeforeEach
    void before() {
        fractions = List.of(
                new Fraction(2, 3),
                new Fraction()
        );
        user = new User("1", "Pepe", "Torres", fractions);
    }

    @Test
    void testUserCreateWithDataPersonal() {
        assertNotNull(user);
        assertEquals("1", user.getId());
        assertEquals("Pepe", user.getName());
        assertEquals("Torres", user.getFamilyName());
    }

    @Test
    void testUserCreateWithoutDataPersonal() {
        user = new User();
        assertNotNull(user);
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getFamilyName());
    }

    @Test
    void testUserFullName() {
        assertNotNull(user);
        assertEquals(user.getName() + " " + user.getFamilyName(), user.fullName());
    }

    @Test
    void testUserNameInitils() {
        assertNotNull(user);
        assertEquals(2, user.initials().length());
    }

    @Test
    void testUserWithFractions() {
        assertNotNull(user);
        assertEquals(2, this.fractions.size());
    }

    @Test
    void testUserWithoutFractions() {
        assertNotNull(user);
        this.fractions = List.of();
        assertEquals(0, this.fractions.size());
    }

}
