import java.util.List;
import java.util.Random;

public class CharacterFactory {

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
