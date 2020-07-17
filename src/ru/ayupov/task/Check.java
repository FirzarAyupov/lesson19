package ru.ayupov.task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Formatter;

public class Check {
    private List<Product> products;

    Check(File productsList) {
        try (Scanner sc = new Scanner(productsList)) {
            this.products = new ArrayList<>();
            while (sc.hasNextLine()) {
                Product product = new Product(sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
                this.products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void printCheck() {
        Formatter f = new Formatter();
        String line = "===============================================";

        f.format("%-17s%7s%9s%13s%n", "Наименование", "Цена", "Кол-во", "Стоимость");
        f.format("%s%n", line);

        for (Product pr : products) {
            f.format("%-17s%7.2f x%7s%14s%n", pr.getName(), pr.getPrice(), pr.getAmountToString(), pr.getProductSumToString());
        }
        f.format("%s%n", line);
        f.format("%-5s%42.2f", "Итого", getCheckSum());
        System.out.print(f.toString());
    }

    private double getCheckSum() {
        double result = 0.0;
        for (Product pr : this.products) {
            result += pr.getProductSum();
        }
        return result;
    }


}
