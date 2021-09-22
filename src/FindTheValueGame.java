import exceptions.NoValueException;
import value.Value;
import value.ValueFinder;
import value.ValueFinderState;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class FindTheValueGame {

    private Scanner input;
    private ValueFinder valueFinder;


     FindTheValueGame(int options, int repeats){
        input = new Scanner(System.in);
        valueFinder = new ValueFinder(options, repeats);

    }
    void start() throws NoValueException{
        explainGame();
        showInitialValues();
        startInteractivePlay();
        showTheValue();
    }

    private void explainGame(){
        // TODO: explain the game here
    }
    private void showInitialValues(){
        System.out.println("Choose a value and keep it in your head (press enter if done)");
        System.out.println(valueFinder.getInitialValues());
        input.nextLine();
    }

    private void startInteractivePlay(){
        while(valueFinder.getState() == ValueFinderState.NOT_FOUND){
            List<List<Value>> decks = valueFinder.getValuesAsDeck();
            System.out.println("Which deck does your picked value exist?");
            for(int i = 0; i < decks.size(); i++) System.out.println("Deck " + (i+1) + ": " + decks.get(i));
            int choice = input.nextInt() - 1;
            if(choice > decks.size() - 1 || choice < 0){
                System.out.println("Invalid option");
                continue;
            }
            valueFinder.shuffle(choice);
        }
    }

    private void showTheValue() throws NoValueException {
        System.out.println(valueFinder.find());
    }








}
