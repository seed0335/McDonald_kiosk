import java.util.ArrayList;
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
        orderArr.add(new Menu("Order", "장바구니 확인 후 주문합니다."));
        orderArr.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));


        // hamburgerArr instance 생성 및 배열추가
        ArrayList hamburgerArr = new ArrayList();
        hamburgerArr.add(new Product("hamburger1", "맛잇음", 1100));
        hamburgerArr.add(new Product("hamburger2", "맛잇음", 1200));
        hamburgerArr.add(new Product("hamburger3", "맛잇음", 1300));
        hamburgerArr.add(new Product("hamburger4", "맛잇음", 1400));

        // product instance 생성 후 메소드 사용 출력.
        Product product = new Product();

        // drinkArr instance 생성 및 배열추가
        ArrayList drinkArr = new ArrayList();
        drinkArr.add(new Product("drink1", "맛잇음", 2100));
        drinkArr.add(new Product("drink2", "맛잇음", 2200));
        drinkArr.add(new Product("drink3", "맛잇음", 2300));
        drinkArr.add(new Product("drink4", "맛잇음", 2400));
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
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                // BURGER 메뉴 출력
                Menu.title("BURGER MENU");
                product.listOutput(hamburgerArr);

                // 제품 선택
                String choice1 = scanner.nextLine();
                // 확인, 취소, 출력, 저장
                orderList.add(order.output(hamburgerArr, choice1));

            } else if (choice.equals("2")) {
                // SIDE 메뉴 출력
                Menu.title("SIDE MENU");
                product.listOutput(drinkArr);

                // 제품 선택
                String choice1 = scanner.nextLine();
                // 확인, 취소, 출력, 저장
                orderList.add(order.output(drinkArr, choice1));

            } else if (choice.equals("3")) {
                order.listOutput(orderList);

            } else if (choice.equals("4")) {
                if (orderList == null) {
                    System.out.println("선택하신 주문이 없습니다.");
                    System.out.println("잠시 후 메뉴판으로 돌아갑니다.");
                    Menu.stop2Second();
                } else {
                    System.out.println("진행하던 주문을 취소하시겠습니까?");
                    System.out.println("1.확인" + "\t" + "2.메인으로");
                    choice = scanner.nextLine();

                    if (choice.equals("1")) {
                        System.out.println("주문이 초기화 되었습니다.");
                        orderList.clear();
                        System.out.println("잠시 후 메뉴판으로 돌아갑니다.");
                        Menu.stop2Second();
                    } else if (choice.equals("2")) {
                        System.out.println("메인으로");
                        System.out.println("잠시 후 메뉴판으로 돌아갑니다.");
                        Menu.stop2Second();
                    }
                }
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
                Menu.stop2Second();
            }
        }
    }
}