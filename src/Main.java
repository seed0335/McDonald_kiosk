import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Menu instance 생성 및 배열에 추가
        ArrayList menuArr = new ArrayList();
        menuArr.add(new Menu("menu1", "맛잇음"));
        menuArr.add(new Menu("menu2", "맛잇음"));

        // Product instance 생성
        Menu menu = new Menu();

        // orderArr instance 생성 및 배열에 추가
        ArrayList orderArr = new ArrayList();
        orderArr.add(new Menu("확인", "맛잇음"));
        orderArr.add(new Menu("취소", "맛잇음"));


        // hamburgerArr instance 생성 및 배열추가
        ArrayList hamburgerArr = new ArrayList();
        hamburgerArr.add(new Product("hamburger1", "맛잇음", 1000));
        hamburgerArr.add(new Product("hamburger2", "맛잇음", 1000));
        hamburgerArr.add(new Product("hamburger3", "맛잇음", 1000));
        hamburgerArr.add(new Product("hamburger4", "맛잇음", 1000));

        // product instance 생성 후 메소드 사용 출력.
        Product product = new Product();

        // drinkArr instance 생성 및 배열추가
        ArrayList drinkArr = new ArrayList();
        drinkArr.add(new Product("drink1", "맛잇음", 1000));
        drinkArr.add(new Product("drink2", "맛잇음", 1000));
        drinkArr.add(new Product("drink3", "맛잇음", 1000));
        drinkArr.add(new Product("drink4", "맛잇음", 1000));
        // 메소드 사용 출력.

        Scanner scanner = new Scanner(System.in); // Scanner 생성
        ArrayList orderList = new ArrayList(); // 주문 저장하는 List 생성
        Order order = new Order(); // order instance 생성

        while (true) {
            Menu.greeting();
            Menu.title("McDonald's MENU");
            menu.listOutput(menuArr); // menu 출력 메소드 사용.
            System.out.println();

            Menu.title("ORDER MENU");
            menu.listOutputO(orderArr); // Product instance 생성 후 메소드 사용.
            int choice = scanner.nextInt();
            if (choice == 1) {
                // BURGER 메뉴 출력
                Menu.title("BURGER MENU");
                product.listOutput(hamburgerArr);

                // 제품 선택
                int choice1 = scanner.nextInt();
                // 확인, 취소, 출력, 저장
                orderList.add(order.output(hamburgerArr, choice1));

            } else if (choice == 2) {
                // SIDE 메뉴 출력
                Menu.title("SIDE MENU");
                product.listOutput(drinkArr);

                // 제품 선택
                int choice1 = scanner.nextInt();
                // 확인, 취소, 출력, 저장
                orderList.add(order.output(drinkArr, choice1));

            } else if (choice == 3) {

                order.listOutput(orderList);

            } else if (choice == 4) {
                if (orderList.isEmpty() == true) {
                    System.out.println("선택하신 주문이 없습니다.");
                    System.out.println("잠시 후 메뉴판으로 돌아갑니다.");
                    Menu.stop3Second();
                } else {
                    System.out.println("진행하던 주문을 취소하시겠습니까?");
                    System.out.println("1.취소 확인" + "\t" + "2.메인으로");
                    choice = scanner.nextInt();

                    if (choice == 1) {
                        System.out.println("주문이 초기화 되었습니다.");
                        orderList.clear();
                        System.out.println("잠시 후 메뉴판으로 돌아갑니다.");
                        Menu.stop3Second();
                    } else if (choice == 2) {
                        System.out.println("메인으로");
                        System.out.println("잠시 후 메뉴판으로 돌아갑니다.");
                        Menu.stop3Second();
                    }
                }
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
                Menu.stop3Second();
            }
        }
    }
}