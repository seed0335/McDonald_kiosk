import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Menu instance 생성 및 배열에 추가(자바의 정석 p.169)
        List menuArr = new ArrayList<>();
        menuArr.add(new Menu("Burgers", "주문 즉시 바로 조리해 더욱 맛있는, 맥도날드의 다양한 버거를 소개합니다."));
        menuArr.add(new Menu("MacLunch", "점심만의 특별한 할인으로 맥런치 세트를 즐겨보세요!"));
        menuArr.add(new Menu("Sides", "가볍게 즐겨도, 버거와 함께 푸짐하게 즐겨도, 언제나 맛있는 사이드와 디저트 메뉴!"));
        menuArr.add(new Menu("Beverages", "언제나 즐겁게, 맥카페와 다양한 음료를 부담없이 즐기세요!"));

        // orderArr instance 생성 및 배열에 추가
        List orderArr = new ArrayList<>();
        orderArr.add(new Menu("Order", "장바구니 확인 후 주문합니다."));
        orderArr.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));


        // hamburgerArr instance 생성 및 배열추가
        List hamburgerArr = new ArrayList<>();
        hamburgerArr.add(new Product("Big Mac", "순 쇠고기 패티 두 장에 빅맥만의 특별한 소스", 7800));
        hamburgerArr.add(new Product("1955 Burger", "특별한 1955 소스에 깊은 풍미의 그릴드 어니언까지!", 7200));
        hamburgerArr.add(new Product("McSpicy Burger", "매콤한 시즈닝을 입힌 100% 닭가슴 통살 위에 아삭아삭한 양상추와 신선한 토마토~", 7800));
        hamburgerArr.add(new Product("Bulgogi Burger", "한국인의 입맛에 딱 맞는 불고기 소스에 잘 재운 패티와 고소한 마요네즈 신선한 양상추의 맛있는 조합.", 5800));

        // MacLunch instance 생성 및 배열추가
        List MacLunch = new ArrayList<>();
        MacLunch.add(new Product("Big Mac BLT ", "100% 순쇠고기 패티에 신선한 토마토와 고소한 베이컨을 추가하여 더 특별하게!", 5900));
        MacLunch.add(new Product("Quarter Pounder", "두툼한 패티로 터지는 육즙! 쿼터파운더 치즈", 6000));
        MacLunch.add(new Product("Bacon Tomato Meal", "두 장의 100% 순 쇠고기 패티에 그릴에 구워 더욱 고소한 1장의 베이컨을 얹고 신선한 토마토와 양상추,", 6600));
        MacLunch.add(new Product("Double Bulgogi" , "진한 불고기 소스의 패티가 두 장!", 5000));

        // Sides instance 생성 및 배열추가
        List Sides = new ArrayList<>();
        Sides.add(new Product("French Fries", "통으로 썰어낸 감자를 맥도날드만의 노하우로 튀겨낸 남다른 맛과 바삭함!", 2800));
        Sides.add(new Product("Chicken Snack Wrap", "매콤한 치킨에 달콤한 화이트 마요 소스로 매콤달콤하게!", 3500));
        Sides.add(new Product("McNuggets", "바삭하고 촉촉한 치킨이 한 입에 쏙!", 3300));
        Sides.add(new Product("Hash Brown","씹으면 바삭바삭,속은 부드러운 감자의 고소함.", 2500));

        // Beverages instance 생성 및 배열추가
        List Beverages = new ArrayList<>();
        Beverages.add(new Product("Coca-Cola","갈증해소 뿐만이 아니라 기분까지 상쾌하게! 코카-콜라",2400));
        Beverages.add(new Product("Sprite","청량함에 레몬, 라임향을 더한 시원함!",2400));
        Beverages.add(new Product("Fanta", "톡 쏘는 오렌지 향!",2400));
        Beverages.add(new Product("Strawberry Shake", "신선한 우유에 상큼한 딸기 시럽으로 맛을 더한 부드러운 쉐이크!",3500));


        // instance 생성
        Menu menu = new Menu();
        Product product = new Product();
        Order order = new Order();
        List orderList = new ArrayList();

        // 배열 생성
        Set set = new HashSet(); // set 배열

        // 스캐너
        Scanner scanner = new Scanner(System.in); // Scanner 생성

        // 각종 변수
        double salesOne = 0; // 한번 판매시 총합
        double salesTotal = 0; // 전체 총합


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
                order.output(hamburgerArr, choice1,orderList);

            } else if (choice.equals("2")) {
                // MACLUNCH 메뉴 출력5
                Menu.title("MACLUNCH MENU");
                product.listOutput(MacLunch);

                // 제품 선택
                String choice1 = scanner.nextLine();
                // 확인, 취소, 출력, 저장
                order.output(MacLunch, choice1,orderList);

            }
            else if (choice.equals("3")) {
                // SIDE 메뉴 출력5
                Menu.title("SIDE MENU");
                product.listOutput(Sides);

                // 제품 선택
                String choice1 = scanner.nextLine();
                // 확인, 취소, 출력, 저장
                order.output(Sides, choice1,orderList);

            } else if (choice.equals("4")) {
                // BEVERAGES 메뉴 출력
                Menu.title("BEVERAGES MENU");
                product.listOutput(Beverages);

                // 제품 선택
                String choice1 = scanner.nextLine();
                // 확인, 취소, 출력, 저장
                order.output(Beverages, choice1,orderList);

            }
            // 주문을 출력하고, set 으로 만든 후, 확인버튼시 저장되어 주문이 완료되도록 바꿈.
            else if (choice.equals("5")) {
                List orderList1 = order.orderCountAdd(orderList);
                List orderList2 = order.orderCount(orderList1);




                for (int i = 0; i < orderList2.size(); i++) {
                    Order o1 = (Order) orderList2.get(i);
//                    System.out.println(o1.name + o1.desc +o1.count +o1.price);
                    String name = o1.name;
                    String desc = o1.desc;
                    int price = o1.price;
                    int count = o1.count;
                    set.add(new Order(name, desc, price, count));
                }
                order.setOutPut(set);
            }
            // 주문을 취소하고, 초기화 시킴
            else if (choice.equals("6")) {
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
            } else if (choice.equals("0335")) {
                System.out.println("[ 관리자 모드]");
                System.out.println("판매 목록");
                order.listOutputOrder(orderList);
                String choice1 = scanner.nextLine();
                System.out.println("현재까지 총 판매된 금액은 위와 같습니다.");
            }
            else {
                System.out.println("올바른 번호를 입력해주세요.");
                Menu.stop2Second();
            }
        }
    }

}