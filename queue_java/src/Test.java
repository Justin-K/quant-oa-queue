import quant.QuantQueue;
import java.util.LinkedList;
import java.util.Random;

public class Test {

    private static void printRefQueue(LinkedList<Integer> x){
        while (!x.isEmpty()){
            int refElement = x.element();
            x.remove();
            System.out.print(refElement+ " ");
        }
        System.out.println();
    }

    private static void fuzzTest(Random rng){
        int rounds = rng.nextInt(20) + 20;
        QuantQueue<Integer> myQueue = new QuantQueue<>(Integer.class);
        LinkedList<Integer> refQueue = new LinkedList<>();

        for (int i = 0; i < rounds; i++){
            if (refQueue.size() != myQueue.size()){
                throw new RuntimeException("The queues were not of the same size.");
            }
            if (refQueue.size() != 0 && rng.nextDouble() > 0.5){
                int refElement = refQueue.element();
                refQueue.remove();
                int myElement = myQueue.pop();
//                System.out.println("pop");
                if (refElement != myElement){
                    myQueue.printQueue();
                    printRefQueue(refQueue);
                    throw new RuntimeException("The popped elements are not equal.");
                }
            }
            else{
                int num = rng.nextInt();
                myQueue.push(num);
                refQueue.add(num);
//                System.out.println(num);
            }
        }
    }

    public static void main(String[] args){
        Random rng = new Random(123);
        while (true){
            fuzzTest(rng);
        }
    }
}
