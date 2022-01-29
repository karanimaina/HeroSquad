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
        return  new Hero("James",24,"highJump","sleep");
    }

    @Test
    public void Hero_returnsGetsName_Name() {
        Hero hero = setupHero();
        assertEquals("James",hero.getName());

    }
    @Test
    public void Hero_returnsGetsAge_Age() {
        Hero hero = setupHero();
        assertEquals(24,hero.getAge());
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
        assertEquals(1,hero.getId());
    }
    @Test
    public void findReturnsCorrectHero()  {
        Hero hero = setupHero();
        assertEquals(1, Hero.findById(hero.getId()).getId());
    }
    @Test
    public void findReturnsCorrectHeroWhenMoreThanOneHeroExists() throws Exception {
        Hero hero = setupHero();
        Hero hero1 = new Hero("Allanon",43,"magic shield","anger");
        assertEquals(2, Hero.findById(hero1.getId()).getId());
    }
    @Test
    public void updateChangesHero()  {
        Hero hero = setupHero();
        String formerName= hero.getName();
        int formerAge = hero.getAge();
        String formerPower = hero.getSpecialPower();
        String formerWeakness= hero.getWeakness();
        int formerId = hero.getId();
        hero.update(22);
        assertEquals(formerId, hero.getId());
        assertEquals(formerName, hero.getName());
        assertEquals(formerPower,hero.getSpecialPower());
        assertEquals(formerWeakness,hero.getWeakness());
        assertNotEquals(formerAge, hero.getAge());

    }
    @Test
    public void deleteDeletesASpecificHero()  {
        Hero hero = setupHero();
        Hero otherHer = new Hero("shannara",32,"swords","bleeding");
        hero.deleteHero();
        assertEquals(1,Hero.getAll().size()); //one is left
        assertEquals(Hero.getAll().get(0).getId(), 2); //the one that was deleted has the id of 2. Why do we care?
    }


}