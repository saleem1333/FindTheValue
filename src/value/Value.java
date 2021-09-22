package value;

public class Value<T>{
    private final T value;
    Value(T value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(obj.getClass() != obj.getClass()) return false;

        Value other = (Value) obj;
        return value == other.value;

    }
}
