package quant;
import java.lang.reflect.Array;

public class QuantQueue<Type>{
    public static int DEFAULT_SIZE = 5;

    private Type[] array;
    public int head;
    public int tail;
    public int size = DEFAULT_SIZE;
    private final Class<Type> type;

    public Type get(int index){return array[index];}
    public Type[] getQueue(){return array;}

    public void printArray(){
        for (Type x : array) {
            if (x != null){
                System.out.print(x);
            }
            else{
                System.out.print("0");
            }
        }
    }

    @SuppressWarnings("unchecked")
    public QuantQueue(Class<Type> t){
        this.type = t;
        // This is sketch
        array = (Type[]) Array.newInstance(this.type, DEFAULT_SIZE);
        head = 0;
        tail = 0;
    }
    @SuppressWarnings("unchecked")
    private void expandArray(int new_size){
        Type[] new_array = (Type[]) Array.newInstance(type, new_size);
        System.arraycopy(array, 0, new_array, 0, array.length);
        array = new_array;
    }

    public void push(final Type entry){
        if ((tail == size) && (head == 0)) {
            expandArray(DEFAULT_SIZE + size);
            size = tail;
        }
        array[tail] = entry;
        tail++;
    }

    public Type front(){return array[head];}
    public Type back(){return array[tail];}
    public Boolean isEmpty(){
        boolean flag = true;
        for (Type x : array) {
            if (x != null) {
                flag = false;
                break;
            }
        }
        return flag;
    }
//    public int size(){}
//    public void emplace(final Type entry){}
//    public Type pop(){}
//    public void swap(final int index_1, final int index_2){}
}
