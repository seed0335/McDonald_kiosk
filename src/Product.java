import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Product extends Menu {
    public int price;

    public int priceSum;
    public int count = 1;

    public Product() {
    }

    public Product(String name, String desc, int price) {
        super(name, desc);
        this.price = price;
    }

    public Product(String name, String desc, int price, int count) {
        super(name, desc);
        this.price = price;
        this.count = count;
    }

    public void listOutput(ArrayList list) {
        int sum = 0;
        double sumD = 0.0;
        for (int i = 0; i < list.size(); i++) {
            Product productList = (Product) list.get(i);
            System.out.println(i + 1 + "." + productList.name + "|" + productList.price + "|" + productList.desc);
        }
        System.out.println("\n" + "번호 외에 입력시 메인으로 돌아갑니다.");
    }
}
