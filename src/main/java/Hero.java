public class Hero {
private String name ;
private int age;
private String specialPower;
private String weakness;

    public Hero(String name, int age, String specialPower, String weakness) {
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSpecialPower() {
        return specialPower;
    }
}
