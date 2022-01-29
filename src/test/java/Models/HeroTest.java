package Models;

import Models.Hero;
import Models.Squad;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HeroTest {
    @After
    public void tearDown() throws Exception {
        Hero.clearAllHeroes();
    }

    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero hero = setupHero();
        assertTrue(hero instanceof Hero);
    }
    private Hero setupHero(){
        return  new Hero("James",22,"highJump","sleep");
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
    @Test
    public void Hero_returnsGetsSpecialPower_Power() {
        Hero hero = setupHero();
        assertEquals("highJump",hero.getSpecialPower());
    }
    @Test
    public void Hero_returnsGetsWeakness_Weakness() {
        Hero hero = setupHero();
        assertEquals("sleep",hero.getWeakness());
    }

    @Test
    public void Hero_squadGetsReturned_List() {
        List<Hero>squad = new ArrayList<>();
        Hero hero = setupHero();
        Hero hero2 = new Hero("Genge",30,"love","vibes");
        squad.add(hero);
        squad.add(hero2);
        assertTrue(squad.contains(hero));
        assertTrue(squad.contains(hero2));
        assertEquals(2,Hero.getAll().size());
        assertEquals(2,hero.getId());
    }


}