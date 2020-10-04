package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {

    private User user;

    private List<Fraction> listFractions;

    @BeforeEach
    void before() {
        listFractions = List.of(
                new Fraction(2, 3),
                new Fraction()
        );
        user = new User("1", "Pepe", "Torres", listFractions);
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
        assertEquals(2, this.user.getFractions().size());
    }

    @Test
    void testUserWithoutFractions() {
        assertNotNull(user);
        this.listFractions=this.user.getFractions();
        this.listFractions=List.of();
        assertEquals(0, this.listFractions.size());
    }

    @Test
    void testUserAddFraction() {
        assertNotNull(user);
        this.user = new User();
        this.user.addFraction(new Fraction());
        assertEquals(1, this.user.getFractions().size());
    }

    @Test
    void testUserModifyFractions() {
        assertNotNull(user);
        assertEquals(2, this.user.getFractions().size());
        this.user.setFractions(List.of(
                new Fraction()
        ));
        assertEquals(1, this.user.getFractions().size());
    }

    @Test
    void testUserGetFraction() {
        assertNotNull(user);
        assertEquals(2,this.user.getFractions().size());
        assertEquals(1, this.user.getFractions().get(1).decimal());
    }

    @Test
    void testModifyUser() {
        assertNotNull(user);
        user.setName("Mohammed");
        user.setFamilyName("Ben");
        assertEquals("Mohammed",this.user.getName());
        assertEquals("Ben", this.user.getFamilyName());
    }

}
