public class Main {
    public static void main(String[] args) {
        //1.
        printThreeWords();
        //2.
        checkSumSign();
        //3.
        printColor();
        //4.
        compareNumbers();
        //5.
        System.out.println(isSumInRange(5, 10));
        //6.
        checkNumberSign(5);
        //7.
        System.out.println(isNegative(-5));
        //8.
        printStringMultipleTimes("Hello", 3);
        //9.
        System.out.println(isLeapYear(400));
        //10.
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertBinaryArray(binaryArray);
        printArray(binaryArray);
        //11.
        int[] filledArray = fillArray(100);
        printArray(filledArray);
        //12.
        int[] sampleArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyLessThanSix(sampleArray);
        printArray(sampleArray);
        //13.
        int[][] squareArray = fillDiagonal(5);
        print2DArray(squareArray);
        //14.
        int[] customArray = createArray(5, 7);
        printArray(customArray);
    }

    //1.
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //2.
    public static void checkSumSign() {
        int a = 5;
        int b = -10;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3.
    public static void printColor() {
        int value = 75;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4.
    public static void compareNumbers() {
        int a = 7;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //5.
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //6.
    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //7.
    public static boolean isNegative(int number) {
        return number < 0;
    }

    //8.
    public static void printStringMultipleTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    //.9
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }


    //10.
    public static void invertBinaryArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    //Метод printArray отвечает за печать одномерного массива целых чисел в консоль
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    //11.
    public static int[] fillArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    //12.
    public static void multiplyLessThanSix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    //13.
    public static int[][] fillDiagonal(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - i - 1] = 1;
        }
        return array;
    }
    //Метод print2DArray отвечает за печать двумерного массива целых чисел в консоль

    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    //14.
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }


}


