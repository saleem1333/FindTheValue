import exceptions.NoValueException;

public class Main {

    public static void main(String[] args) throws NoValueException {

        FindTheValueGame game = new FindTheValueGame(3, 3);
        game.start();
    }
}
