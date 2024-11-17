import java.util.LinkedList;

public class Sales {
    public static void main(String[] args) {
        addSale("Ноутбук",20000.00);
        addSale("Ноутбук",20000.00);
        addSale("Ноутбук",20000.00);
        addSale("Ноутбук",20000.00);
        addSale("Холодильник",2000.00);
        addSale("Холодильник",2000.00);
        addSale("Телефон",1000.00);
        sales();
        totalSales();
        mostPopular();
    }

    public static LinkedList<String> salesList = new LinkedList<>();
    public static double totalSales = 0;


    public static void addSale(String name, double price) {
        salesList.add(name);
        totalSales += price;
        System.out.println("Добавлен товар: " + name + " по цене " + price);
    }

    public static void sales() {
        if (salesList.isEmpty()) {
            System.out.println("Нет проданных товаров.");
        } else {
            System.out.println("Список проданных товаров: " + salesList);
        }
    }

    public static void totalSales() {
        System.out.println("Общая сумма продаж: " + totalSales);
    }

    public static void mostPopular() {
        if (salesList.isEmpty()) {
            System.out.println("Нет проданных товаров.");
            return;
        }
        String mostPopular = null;
        int maxCount = 0;

        for (String item : salesList) {
            int count = 0;
            for (String compare : salesList) {
                if (item.equals(compare)) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                mostPopular = item;
            }
        }
        System.out.println("Наиболее популярный товар: " + mostPopular + " (Продан " + maxCount + " раз)");
    }
}