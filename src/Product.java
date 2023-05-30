import java.util.ArrayList;


public class Product extends Menu {
    public int price;

    public int count;

    public Product() {
    }

    public Product(String name, String desc, int price) {
        super(name, desc);
        this.price = price;
    }



    // name, price,desc 출력 for
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
