package quant;
import java.lang.reflect.Array;

/**
 *
 * @param <Type>
 */
public class QuantQueue<Type>{
    /**
     * This is the default capacity of the queue.
     */
    public final static int DEFAULT_SIZE = 1024;

    /**
     * This exception represents attempting to remove from a queue with no elements.
     */
    public static class QueueUnderflowException extends RuntimeException{
        private QueueUnderflowException(String msg){
            super(msg);
        }
    }

    private Type[] array;
    private int head;
    private int tail;
    private int size;
    private final Class<Type> type;

    /**
     *
     * @param t represents the data-type of the elements in the queue.
     */
    @SuppressWarnings("unchecked")
    public QuantQueue(Class<Type> t){
        type = t;
        // This is sketch, why doesn't java have better support for generic arrays?
        array = (Type[]) Array.newInstance(type, DEFAULT_SIZE);
        head = 0;
        tail = 0;
    }

    /**
     *  This method prints a line with all elements in the queue seperated by space.
     */
    public void printQueue(){
        for (int i = 0; i < size; i++){
            System.out.print(array[(i+head)%array.length] + " ");
        }
        System.out.println();
    }

    /**
     * This method is used to expand the queue once it reaches its default capacity as defined by DEFAULT_SIZE.
     * @param new_size The size of the new queue.
     */
    @SuppressWarnings("unchecked")
    private void expandArray(int new_size){
        Type[] newArray = (Type[]) Array.newInstance(type, new_size);
        System.arraycopy(array, head, newArray, 0, array.length-head); //makes sense
        System.arraycopy(array, 0, newArray, array.length-head, head);
        array = newArray;
        head = 0;
        tail = size;
    }

    /**
     * This method is used to add an element to the queue.
     * @param entry The element to add to the queue.
     */
    public void push(final Type entry){
        if ((size() == array.length)) {
            expandArray(2 * array.length);
        }

        array[tail] = entry;
        size++;
        tail = (tail + 1) % array.length;
    }

    /**
     * This method retrieves the next element in the queue, removes it, and then returns it.
     * @return The return represents the element popped.
     */
    public Type pop(){
        if (size() == 0){
            throw new QueueUnderflowException("Attempted pop on queue of size 0.");
        }
        Type element = array[head];
        size--;
        head = (head + 1) % array.length;
        return element;
    }

    /**
     * This method is used to get the element at the front of the queue (the next element to be removed).
     * @return The return is the front-most element in the queue of type Type.
     */
    public Type front(){return array[head];}

    /**
     * This method is used to get the element at the back of the queue (the last element to be removed).
     * @return The return is the last element in the queue of type Type.
     */
    public Type back(){return array[(tail-1+array.length) % array.length];}

    /**
     * This method is used to determine whether the queue is devoid of elements.
     * @return A boolean representing whether or not the queue contains elements.
     */
    public boolean isEmpty(){return size == 0;}

    /**
     * This method is used to get the current size of the queue.
     * @return An int representing the number of elements in the queue.
     */
    public int size(){return size;}

}
