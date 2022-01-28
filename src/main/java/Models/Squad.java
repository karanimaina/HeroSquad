package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Squad {
    private String name;
    private int size;
    private  String cause;
    private static List<Squad>squad = new ArrayList<>();
    private  int id;
    private List<Hero>heroes ;


    public Squad(String name, int size, String cause) {
        this.name = name;
        this.size = size;
        this.cause = cause;
        squad.add(this);
        this.id = squad.size();
        this.heroes= new ArrayList<>();
    }

    public static List<Squad> getAll() {
        return squad;
    }


    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getCause() {
        return cause;
    }

    public int getId() {
        return  id;
    }
    public  void addHeroToSquad(Hero newHero){
      heroes.add(newHero);
    }
}
