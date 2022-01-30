package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hero {
private String name ;
private int age;
private String power;
private String weakness;
private int Id;
private static List<Hero>heroes= new ArrayList<>();

    public Hero(String name, int age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        heroes.add(this);
        this.Id= heroes.size();
    }

    public static Hero findById(int id) {
        return heroes.get(id-1);
    }

    public  int getId() {
        return  Id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static List<Hero> getAll() {
        return heroes;
    }

    public String getSpecialPower() {
        return power;
    }

    public String getWeakness() {
        return weakness;
    }
    public static void clearAllHeroes(){
        heroes.clear();
    }

    public void update(int age) {
        this.age= age;
    }
    public void deleteHero() {
        heroes.remove(Id-1);
    }

}

