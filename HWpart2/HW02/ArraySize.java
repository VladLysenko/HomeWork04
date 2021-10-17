package HW02;

public class ArraySize {

    static int getArray(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        if (arr.length == 4 && arr[0].length == 4){
            System.out.println("Длина массива правильная");
        } else {
            throw new MyArraySizeException("Длина массива неправильная");
        }

        int sum = 0;
        if (arr.length != 4){
            throw new MyArraySizeException("Длина массива неправильная");
        }


        for (int i = 0; i < arr.length ; i++) {
            if (arr[i].length != 4){
                throw new MyArraySizeException("Длина массива неправильная");
            }
            for (int j = 0; j < arr[i].length ; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("нельзя преобразовать ячейку " + i + "x" + j);
                }
            }
        }

        Integer[][] intArray = new Integer[arr.length][arr[0].length];
        int res = 0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[0].length ; j++) {
                intArray[i][j] = Integer.parseInt(arr[i][j]);
                res += intArray[i][j];
            }
        }
        return sum;
    }
}