import java.util.Random;
import java.util.List;

class GetRandom {
    public static int get(int min, int max){
        Random random = new Random();
        return random.nextInt(max-min)+min;
    }
}

public class Character {
    private int hp;
    private int power;

    public Character(int hp, int power) {
        this.hp = hp;
        this.power = power;
    }

    public void kick(Character c){
        c.setHp(-this.power);;
    }
    public boolean isAlive(){
        return this.hp > 0;
    }
    public void setHp(int value){
        if (this.hp <= 0){
            return;
        }
        this.hp += value;
        if (this.hp < 0){
            this.hp = 0;
        }
    }

    public int getHp(){
        return this.hp;
    }

    public int getPower(){
        return this.power;
    }

    @Override
    public String toString(){
        Class<?> clazz = this.getClass();
        return clazz.getSimpleName() + "{hp="+this.hp+", power="+this.power+"}";
    }
}

class Elf extends Character {
    public Elf() {
        // Initializes the inherited 'hp' and 'power' fields in Character
        super(10, 10);
    }

    public void kick(Character c){
        if (c.getPower() >= this.getPower()){
            c.setHp(-1);
        }else{
            c.setHp(-c.getHp());
        }
    }
}

class Hobbit extends Character{
    public Hobbit() {
        super(3, 0);
    }

    public void kick(){
        System.out.println("Cry");
    }
}

class King extends Character{
    public King(){
        super(GetRandom.get(5, 15), GetRandom.get(5,15));
    }
}

class Knight extends Character {
    public Knight(){
        super(GetRandom.get(2, 12), GetRandom.get(2, 12));
    }
}

class CharacterFactory {

    private static final List<Class<? extends Character>> characterClasses = List.of(
        Elf.class,
        Hobbit.class,
        King.class,
        Knight.class
    );

    private static final Random random = new Random();

    // Simple Factory pattern
    public Character createCharacter() throws Exception {
        int randomIndex = random.nextInt(characterClasses.size());
        Class<? extends Character> selectedClass = characterClasses.get(randomIndex);

        return selectedClass.getDeclaredConstructor().newInstance();
    }
}

