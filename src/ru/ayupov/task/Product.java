package ru.ayupov.task;

class Product {
    private String name;
    private double amount;
    private double price;

    Product(String name, double amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public double getProductSum() {
        double sum = getPrice() * getAmount();
        return Math.round(sum * 100.0) / 100.0;
    }

    public String getProductSumToString() { //для вывода суммы товара со знаком "=" в начале
        return String.format("=%.2f", getProductSum());
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getAmountToString() { //для вывода штучных товаров без дробной части
        /*
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(amount);
        */
        String result = String.format("%.3f", amount);
        if (amount % 1 == 0) {
            result = Integer.toString((int) Math.round(amount));
        }
        return result;
    }

    public double getPrice() {
        return price;
    }

}
