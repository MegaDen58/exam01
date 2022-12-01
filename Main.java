import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ведить длину массива: ");
        int length = in.nextInt();
        int[] array = new int[length];

        for(int i = 0; i < length; i++){
            System.out.printf("Введить элемент под номером %d: ", i);
            array[i] = in.nextInt();
        }

        Thread max = new Thread(new MaxValue(array));
        Thread min = new Thread(new MinValue(array));

        max.start();
        min.start();

    }

    static class MaxValue implements Runnable{
        int[] array;
        int max;

        MaxValue(int[] array){
            this.array = array;
        }

        @Override
        public void run() {
            max = array[0];
            for(int k : array){
                if(k > max){
                    max = k;
                }
            }
            System.out.printf("Максимальное значение массива: %s", max + "\n");
        }
    }

    static class MinValue implements Runnable{
        int[] array;
        int min;

        MinValue(int[] array){
            this.array = array;
        }

        @Override
        public void run() {
            min = array[0];
            for(int k : array){
                if(k < min){
                    min = k;
                }
            }
            System.out.printf("Минимальное значение массива: %s", min + "\n");
        }
    }
}