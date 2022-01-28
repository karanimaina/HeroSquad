package Models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void Squad_instantiatesCorrectly_true() {
        Squad squad = setupNewSquad();
        assertTrue(squad instanceof Squad);
    }

     @Test
        public void getName() {
           Squad squad = setupNewSquad();
           assertEquals("Firefighters",squad.getName());
        }

        @Test
        public void getSize() {
        Squad squad = setupNewSquad();
        assertEquals(20, squad.getSize());
        }
        @Test
        public void getCause() {
        Squad squad = setupNewSquad();
        assertEquals("silly mistakes",squad.getCause());
        }
    @Test
    public void Squad_squadGetsReturned_List() {
        List<Squad> squad = new ArrayList<>();
        Squad squad1= setupNewSquad();
        Squad squad2 = new Squad("avengers",20,"bad wisdom");
        squad.add(squad1);
        squad.add(squad2);
        assertTrue(squad.contains(squad1));
        assertTrue(squad.contains(squad2));
        assertEquals(2,Squad.getAll().size());
        assertEquals(2,squad1.getId());
    }

    @Test
    public void Squad_addHeroToSquad() {
        List<Hero>heroes = new ArrayList<>();
        List<Squad>squads = new ArrayList<>();
        Hero hero = new Hero("AJordan",30,"dance","alcohol");
        heroes.add(hero);
        Squad squad = setupNewSquad();

    }

    private Squad  setupNewSquad(){
        return new Squad("Firefighters",20,"silly mistakes");
    }
}