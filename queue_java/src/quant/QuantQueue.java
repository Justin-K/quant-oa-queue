package quant;
import java.lang.reflect.Array;

public class QuantQueue<Type>{
    public static int DEFAULT_SIZE = 1024;

    private Type[] array;
    private int head;
    private int tail;
    private final Class<Type> type;

    @SuppressWarnings("unchecked")
    public QuantQueue(Class<Type> t){
        this.type = t;
        // This is sketch
        array = (Type[]) Array.newInstance(this.type, DEFAULT_SIZE);
        head = 0;
        tail = DEFAULT_SIZE - 1;
    }
    @SuppressWarnings("unchecked")
    private void expandArray(int new_size){
        Type[] new_array = (Type[]) Array.newInstance(type, new_size);
        // Remove literal indices and test
        System.arraycopy(array, 0, new_array, 1, new_array.length);
        array = new_array;
    }

    public void push(final Type entry){
        if ((tail == DEFAULT_SIZE) && (head == 0)) {
            expandArray(DEFAULT_SIZE);
        }
        tail++;
        array[tail] = entry;
    }
//    public Type front(){}
//    public Type back(){}
//    public Boolean isEmpty(){}
//    public int size(){}
//    public void emplace(final Type entry){}
//    public Type pop(){}
//    public void swap(final int index_1, final int index_2){}
}
