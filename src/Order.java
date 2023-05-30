import java.util.ArrayList;
import java.util.Scanner;

public class Order extends Product{

    int count;

    //기본 생성자
    public Order() {
    }

    // 추가기능 구현을 위한 count 사용
    public Order(String name, String desc, int price, int count) {
        super(name, desc, price);
        this.count = count;
    }

    // 1,2번에서 받은 주문 저장하기
    public Product output(ArrayList list, String str) {
        if (str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4")){
            int num = Integer.parseInt(str);
            ArrayList orderList = null;
            Product productList = (Product) list.get(num - 1);
            double priceD = (double) productList.price / 1000;
            System.out.printf("%-18s \t | %2.1f | %s", productList.name, priceD, productList.desc);

            System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?\n");
            System.out.println("1.확인" + "\t" + "2.취소");
            Scanner scanner = new Scanner(System.in); // Scanner 생성
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println(productList.name + " 메뉴가 추가되었습니다.\n");
                Product.stop2Second();
                return productList;
            } else {
                System.out.println("취소 되었습니다. 잠시 후 메인으로 돌아갑니다.\n");
                Product.stop2Second();
            }
        } else {
            System.out.println("잠시 후 메인으로 돌아갑니다.");
            Product.stop2Second();
        }
        return null;
    }

    // 3번 주문 확인 또는 취소
    public void listOutput(ArrayList list) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        int sum = 0;
        double sumD = 0.0;
        for (int i = 0; i < list.size(); i++) {
            Product productList = (Product) list.get(i);
            System.out.println(i + 1 + "." + productList.name + "|" + productList.price + "|" + productList.desc);
            sum += productList.price;
        }
        sumD = (double) sum / 1000;
        System.out.println("[ Total ]" + "\n" + "W" + sumD + "\n");
        System.out.println("1.주문" + "\t" + "2.메뉴판");
        Scanner scanner = new Scanner(System.in); // Scanner 생성
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("주문이 완료되었습니다!");

            System.out.println("대기번호는 [ 1 ] 번 입니다.");
            System.out.println("잠시 후 메뉴판으로 돌아갑니다.");
            list.clear();
            Menu.stop2Second();
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
            Menu.stop2Second();
        }
    }

}