import java.util.ArrayList;
import java.util.Scanner;

public class Order{



    // 1,2번에서 받은 주문 저장하기
    public Product output(ArrayList list, int num) {
        ArrayList orderList = null;
        Product productList = (Product) list.get(num - 1);
        double priceD = (double) productList.price / 1000;
        System.out.printf("%-18s \t | %2.1f | %s", productList.name, priceD, productList.desc);

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인" + "\t" + "2.취소");
        Scanner scanner = new Scanner(System.in); // Scanner 생성
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println(productList.name + " 메뉴가 추가되었습니다.");
            Product.stop3Second();
            return productList;
        } else {
            System.out.println("취소 되었습니다. 잠시 후 메인으로 돌아갑니다.");
            Product.stop3Second();
        }
        return null;
    }

    // 3번 주문 확인 후 취소
    public Product listOutput(ArrayList list) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        int sum = 0;
        double sumD = 0.0;
        Product pi = null;
        Product pj = null;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                pi = (Product) list.get(i);
                pj = (Product) list.get(j);
                if (pi.equals(pj)) {
                    list.set(i, new Product(pi.name, pi.desc, pi.priceSum = (pi.price * (pi.count+1)), pi.count = (pi.count + 1)));

                } else {
                    list.add(new Product(pi.name,pi.desc, pi.priceSum, pi.count));
                }
            }
        }
        return pi;
    }



//        sumD = (double) sum / 1000;
//        System.out.println("\n [ Total ]" + "\n" + "W" + sumD + "\n");
//        System.out.println("1.주문" + "\t" + "2.메뉴판");
//        Scanner scanner = new Scanner(System.in); // Scanner 생성
//        int choice = scanner.nextInt();
//        if (choice == 1) {
//            System.out.println("주문이 완료되었습니다!");
//
//            System.out.println("대기번호는 [ 1 ] 번 입니다.");
//            System.out.println("잠시 후 메뉴판으로 돌아갑니다.");
//            list.clear();
//            Menu.stop3Second();
//        } else {
//            System.out.println("메뉴판으로 돌아갑니다.");
//            Menu.stop3Second();

        }

