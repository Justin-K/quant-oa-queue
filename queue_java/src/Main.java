import quant.QuantQueue;

public class Main {

    public static void main(String[] args) {
        QuantQueue<Integer> quantQueue = new QuantQueue<>(Integer.class);
        System.out.println(quantQueue.isEmpty()); // This true
        quantQueue.push(1);
        quantQueue.push(2);
        quantQueue.push(3);
        System.out.println(quantQueue.pop()); // This prints 1
        System.out.println(quantQueue.front()); // This prints 2
        System.out.println(quantQueue.back()); // This prints 3
        System.out.println(quantQueue.size()); // This prints 2
        System.out.println(quantQueue.isEmpty()); // This prints false
    }
}
