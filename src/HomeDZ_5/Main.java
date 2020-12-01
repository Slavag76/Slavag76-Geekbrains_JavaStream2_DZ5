package HomeDZ_5;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] a1 = new float[h];
    static float[] a2 = new float[h];

    

    public static void main(String[] args) {

        Thread1 tread1 = new Thread1();
        Thread2 tread2 = new Thread2();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        first10000000method(arr); /*выполняем первую часть задания*/

        tread1.start(); /*делаем два потока по разделению массива на две части и соединения обратно*/
        tread2.start();

    }

    static class Thread1 extends Thread {
        public void run() {
            long time11 = System.currentTimeMillis();
            System.arraycopy(arr, 0, a1, 0, h);
            System.out.println("Время разбивки с 0 по 5000000 \n" + (System.currentTimeMillis() - time11));
            long time1 = System.currentTimeMillis();
            for (int i = 0; i < h; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("с 0 по 5000000 посчитались за \n" + (System.currentTimeMillis() - time1));

            long time13 = System.currentTimeMillis();
            System.arraycopy(a1,0, arr, 0, h);
            System.out.println("Время склейки с 0 по 5000000 \n" + (System.currentTimeMillis() - time13));
        }
    }

    static class Thread2 extends Thread {
        public void run() {
            long time22 = System.currentTimeMillis();
            System.arraycopy(arr, h, a2, 0, h);
            System.out.println("Время разбивки с 5000000 по 10000000 \n" + (System.currentTimeMillis() - time22));
            long time2 = System.currentTimeMillis();
            for (int i = 0; i < h; i++) {
                a2[i] = (float) (arr[i+h] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("с 5000000 по 10000000 посчитались за \n" + (System.currentTimeMillis() - time2));

            long time23 = System.currentTimeMillis();
            System.arraycopy(a2,0, arr, h, h);
            System.out.println("Время склейки с 0 по 5000000 \n" + (System.currentTimeMillis() - time23));

        }
    }


    public static void first10000000method(float[] arr) {

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.currentTimeMillis();
        }
        System.out.println("Первый метод с 0 по 10000000 посчитал за \n" + (System.currentTimeMillis() - a));
    }

}



