package Matritsa;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Задайте кількість стовпців матриці: ");
        int m = sc.nextInt();

        System.out.print("Задайте кількість строк матриці: ");
        int n = sc.nextInt();

        int[][] array = new int[n][m]; //створюємо двомірний масив елементів
        System.out.println("Введіть елементи матриці:" + "\t");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++){

                try { //обробка виключення введення рядка замість числа
                    array[i][j] = sc.nextInt();
                }
                catch (InputMismatchException e) {
                    System.err.println("Введений рядок замість числа.");
                    sc.nextLine();
                }

            }
        }
        System.out.println("Введений масив: " + Arrays.deepToString(array));

        int min = array[0][0]; //визначаємо мінімальне від'ємне число масиву
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] < min)
                    min = array[i][j];
            }
        }
        if(min > 0) { //«кинуто вийняток» та створено екземпляр RuntimeException з повідомленням
            throw new IllegalArgumentException("В матрицю не було введено негативних чисел.");
        }
        else System.out.println("Мінімальне від'ємне число: " + min);

}
}