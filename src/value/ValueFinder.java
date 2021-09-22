package value;

import exceptions.NoValueException;

import java.util.*;

public class ValueFinder {
    private final int OPTIONS;
    private final int REPEATS;
    private final int SIZE;
    private List<Value> initialValues;
    private List<Value> values;
    private ValueFinderState state;
    private int finderCounter;


    public ValueFinder(int options, int repeats){
        OPTIONS = options;
        REPEATS = repeats;
        SIZE = (int) Math.pow(options, repeats);


        initialValues = ValuesFactory.create(SIZE);
        values = ValuesFactory.create(SIZE);
        state = ValueFinderState.NOT_FOUND;
    }

    public List<Value> getInitialValues() {
        return initialValues;
    }


   public ValueFinderState getState(){
        return state;
    }

    public List<List<Value>> getValuesAsDeck() {
        List<List<Value>> decks = new ArrayList<>();
        for(int i = 0; i < OPTIONS; i++) decks.add(new ArrayList<>());

        LinkedList<Value> valuesLinkedList = new LinkedList<>(values);

        while (!valuesLinkedList.isEmpty()){
            for(List<Value> deck: decks) deck.add(valuesLinkedList.poll());
        }
        return decks;
    }



    public void shuffle(int choice) {
        List<List<Value>> decks = getValuesAsDeck();
        Collections.swap(decks, choice, 1);
        List<Value> newValues = new ArrayList<>();
        decks.forEach(newValues::addAll);
        values = newValues;
        finderCounter++;
        if(finderCounter == REPEATS) state = ValueFinderState.FOUND;
    }

    public Value find() throws NoValueException{
        if(state == ValueFinderState.NOT_FOUND) throw new NoValueException();
        return values.get(findIndexOfValue());
    }


    private int findIndexOfValue(){
        return (int) Math.ceil(SIZE / (OPTIONS - 1.0)) - 1;
    }
}

// x^y where x is the number of digits and y is length of number
// formula for finding the value:  (x^y) ~/ (x-1)
// x^y is values.size()
