package Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void Squad_instantiatesCorrectly_true() {
        Squad squad = setupNewSquad();
        assertTrue(squad instanceof Squad);

    }

    /* @Test
        public void getName() {
           Squad squad = setupNewSquad();
           assert
        }

        @Test
        public void getSize() {
        }

        @Test
        public void getCause() {
        }*/
    private Squad  setupNewSquad(){
        return new Squad("Firefighters",20,"silly mistakes");
    }
}