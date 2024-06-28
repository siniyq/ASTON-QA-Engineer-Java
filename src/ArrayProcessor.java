class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException("Array must be 4x4 in size");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Array must be 4x4 in size");
            }
        }

        int sum = 0;
        // Проход по элементам массива и суммирование значений
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Попробуем сначала преобразовать в int
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e1) {
                    try {
                        // Если не удалось, попробуем преобразовать в double и затем в int
                        double temp = Double.parseDouble(array[i][j]);
                        sum += (int) temp;
                    } catch (NumberFormatException e2) {
                        throw new MyArrayDataException("Invalid data at (" + i + "," + j + "): " + array[i][j]);
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"10", "11", "12"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] floatDataArray = {
                {"1", "2.0", "3", "4"},
                {"5", "6", "7.45", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16.75"}
        };

        try {
            System.out.println("Sum of validArray: " + processArray(validArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Sum of invalidSizeArray: " + processArray(invalidSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Sum of invalidDataArray: " + processArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Sum of floatDataArray: " + processArray(floatDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
