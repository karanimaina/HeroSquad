package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Squad {
    private String name;
    private int size;
    private  String cause;
    private static List<Squad>squads = new ArrayList<>();
    private  int id;
    private List<Hero>heroes ;


    public Squad(String name, int size, String cause) {
        this.name = name;
        this.size = size;
        this.cause = cause;
        squads.add(this);
        this.id = squads.size();
        this.heroes= new ArrayList<>();
    }

    public static List<Squad> getAll() {
        return squads;
    }
    public static Squad findById(int id){
        if (id ==0){
            return squads.get(id+1) ;
        }else{
            return squads.get(id-1);
        }

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

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int getId() {
        return  id;
    }
    public  void addHeroToSquad(Hero newHero){
      heroes.add(newHero);
    }
}
