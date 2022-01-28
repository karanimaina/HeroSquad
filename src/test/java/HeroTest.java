import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero hero = setupHero();
        assertTrue(hero instanceof Hero);
    }
    private Hero setupHero(){
        return  new Hero("James",22,"highjump","sleep");
    }

    @Test
    public void Hero_returnsGetsName_Name() {
        Hero hero = setupHero();
        assertEquals("James",hero.getName());

    }
    @Test
    public void Hero_returnsGetsAge_Age() {
        Hero hero = setupHero();
        assertEquals(22,hero.getAge());

    }


}