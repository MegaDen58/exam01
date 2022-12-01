import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int length = in.nextInt(); // ввод длины массива
        int[] array = new int[length]; // создание массива с заданной длиной

        for(int i = 0; i < length; i++){ // заполнение масива
            System.out.printf("Введите элемент под номером %d: ", i);
            array[i] = in.nextInt();
        }

        /*
        Создание и запуск потоков
        в качестве параметров в конструктор передаётся заполненный массив
         */
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
            max = array[0]; // как максимальное берётся первый элемент
            for(int k : array){ // перебор элементов массива
                if(k > max) max = k; // если следующий элемент больше максимального, то этот элемент становится максимальным
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
            min = array[0]; // как минимальное берётся первый элемент
            for(int k : array){ // перебор элементов массива
                if(k < min) min = k;  // если следующий элемент меньше минимального, то этот элемент становится максимальным
            }
            System.out.printf("Минимальное значение массива: %s", min + "\n");
        }
    }
}
