package by.it.group310901.kleschev.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Рекурсивно вычислить расстояние редактирования двух данных непустых строк

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    0

    Sample Input 2:
    short
    ports
    Sample Output 2:
    3

    Sample Input 3:
    distance
    editing
    Sample Output 3:
    5

*/

public class A_EditDist {
//В данном случае используется функция Integer.min, чтобы найти минимальное значение.
    int min(int a, int b, int c) {
        return Integer.min(a, Integer.min(b, c));
    }
//Метод dist является рекурсивной функцией, которая вычисляет редакционное расстояние между двумя подстроками.
    int dist(int i, int j, String one, String two) {
        if (i == 0) {
            return j;
        }

        if (j == 0) {
            return i;
        }

        int tmp = (one.charAt(i - 1) == two.charAt(j - 1)) ? 0 : 1;
        return min(dist(i - 1, j, one, two) + 1, dist(i, j - 1, one, two) + 1, dist(i - 1, j - 1, one, two) + tmp);
        //Рекурсивно вычисляются три возможных расстояния:i;i-1;i-1,j-1
    }
    int getDistanceEdinting(String one, String two) {
        int result = 0;
        result = dist(one.length(), two.length(), one, two);
        return result;
        //Метод инициализирует переменную result нулем и вызывает метод dist с длинами обеих строк.
        //Возвращается вычисленное редакционное расстояние.
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson07/dataABC.txt");
        A_EditDist instance = new A_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
    }
}