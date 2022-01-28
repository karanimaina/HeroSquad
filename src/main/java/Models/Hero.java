package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hero {
private String name ;
private int age;
private String specialPower;
private String weakness;
private int Id;
private static List<Hero>squad = new ArrayList<>();

    public Hero(String name, int age, String specialPower, String weakness) {
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        squad.add(this);
        this.Id= squad.size();
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
        return squad;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }
}
