package ru.ayupov.task;

import java.io.File;

/**
 * Дан текстовый файл определенной структуры, в котором содержится информация о покупках.
 * <p>
 * Формат файла:
 * <p>
 * Название товара
 * количество
 * цена
 * <p>
 * Необходимо написать программу, которая выведет на экран чек, сформированный из этого файла. В чеке должна быть информация:
 * <p>
 * название товара:  цена Х кол-во = стоимость
 * <p>
 * В конце отчета вывести итоговую стоимость.
 */


public class Main {
    public static void main(String[] args) {

        Check check = new Check();
        check.initFromFile(new File("products.txt"));
        check.printCheck();
    }
}
