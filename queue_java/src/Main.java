import quant.QuantQueue;

public class Main {
    public static int[] fillArray(int[] array){
        int[] new_array = new int[array.length];
        for (int i = 0; i < array.length; i++){
            new_array[i] = i + 1;
        }
        return new_array;
    }
    public static void printArray(int[] array){
        for (int i : array){

            System.out.print(i);
        }
    }
    public static void main(String[] args){
        QuantQueue<Integer> x = new QuantQueue<>(Integer.class);
        x.push(1);
        x.printArray();
//        int[] src = new int[5];
//        int[] dest = new int[10];
//        src = fillArray(src);
//
//        System.arraycopy(src, 0, dest, 0, src.length);
//
//
//        printArray(dest);


    }
}
