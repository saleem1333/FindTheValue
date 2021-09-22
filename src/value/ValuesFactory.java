package value;

import java.util.ArrayList;
import java.util.List;

class ValuesFactory {


     static List<Value> create(int size){
        List<Value> values = new ArrayList<>();

        for(int i = 1; i <= size; i++){
            values.add(new Value<>(i));
        }
        return values;
    }
}
