import java.util.*;

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
    public List output(List list, String str, List orderList) {
        Product product;
        if (str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4")){
            int num = Integer.parseInt(str);
            // List orderList;
            product = (Product) list.get(num - 1);
            double priceD = (double) product.price / 1000;

            System.out.printf("%-18s \t | %2.1f | %s", product.name, priceD, product.desc);
            System.out.println("위 메뉴의 어떤 옵션을 추가하시겠습니까?");
            System.out.println("1. size up(500원)" + "\t" + "2.origin");
            Scanner scanner = new Scanner(System.in); // Scanner 생성

            String choice1 = scanner.nextLine();
            if(choice1.equals("1")) {
                System.out.printf("%-18s \t | %2.1f | %s", product.name + "(L)", priceD + 0.5, product.desc);
                System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?\n");
                System.out.println("1.확인" + "\t" + "2.취소");
                String choice2 = scanner.nextLine();


                if (choice2.equals("1")) {
                    product = (Product) list.get(num -1);
                    Order order = new Order();
                    order.name = product.name + "(L)";
                    order.price = (int) ((priceD + (0.5)) * 1000);
                    order.desc = product.desc;
                    System.out.println(product.name + " 메뉴가 추가되었습니다.\n");
                    Product.stop2Second();
                    orderList.add(order);
                    return orderList;

                } else {
                    System.out.println("취소 되었습니다. 잠시 후 메인으로 돌아갑니다.\n");
                    Product.stop2Second();
                }
            } else {
                System.out.printf("%-18s \t | %2.1f | %s", product.name, priceD, product.desc);
                System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?\n");
                System.out.println("1.확인" + "\t" + "2.취소");
                String choice2 = scanner.nextLine();
                if (choice2.equals("1")) {
                    Order order = new Order();
                    order.name = product.name;
                    order.price = (int) (priceD * 1000);
                    order.desc = product.desc;
                    System.out.println(product.name + " 메뉴가 추가되었습니다.\n");
                    Product.stop2Second();
                    orderList.add(order);
                    return orderList;
                } else {
                    System.out.println("취소 되었습니다. 잠시 후 메인으로 돌아갑니다.\n");
                    Product.stop2Second();
                }
            }
        } else {
            System.out.println("잠시 후 메인으로 돌아갑니다.");
            Product.stop2Second();
        }
        return null;
    }

    // 3번 주문 확인 또는 취소
    public void listOutputOrder(List list) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        int sum = 0;
        double sumD = 0.0;
        for (int i = 0; i < list.size(); i++) {
            Order productList = (Order) list.get(i);
            System.out.println(i + 1 + "." + productList.name + "|" + productList.price + "|" + productList.desc + "|" + productList.count);
            sum += productList.price;
        }
        sumD = (double) sum / 1000;
        System.out.println("[ Total ]" + "\n" + "W" + sumD + "\n");
    }

    // 추가기능 : 주문개수 기능 추가를 위해서 카운트를 더하는 배열을 만듬.
    public List orderCountAdd(List orderList){
        for (int i = 0; i < orderList.size(); i++) {
            Product oi = (Product) orderList.get(i);
            orderList.set(i,(new Order(oi.name, oi.desc, oi.price, 1)));
        }
        return orderList;
    }

    // 추가기능 : 주문개수 기능 추가 count 이용 for 문이 돌아갈 때, count 올라감.
    public List orderCount(List list) {
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                Order oi = (Order) list.get(i);
                Order oj = (Order) list.get(j);
                if((oi.name.equals(oj.name)) == true){
                    count += 1;
                    list.set(i,(new Order(oi.name, oi.desc, oi.price, count)));

                }
            }
        }
        return list;
    }

    // set 을 이용하여 중복을 제거하고, 가격을 정수에서 소수로 바꿈.
    public void setOutPut(Set set) {

        int sum = 0;
        double sumD = 0.0;
        Iterator<Order> iterator = set.iterator();
        while (iterator.hasNext()){
            Order o1 = iterator.next();
            System.out.println(o1.name + "|" + o1.desc + "|" + (o1.price * o1.count) + "|" + o1.count);
            sum += (o1.price * o1.count);
        }
        sumD = (double) sum / 1000;
        System.out.println("[ Total ]" + "\n" + "W" + sumD + "\n");
        System.out.println("아래와 같이 주문 하시겠습니까?");

        System.out.println("1.주문" + "\t" + "2.메뉴판");
        Scanner scanner1 = new Scanner(System.in); // Scanner 생성
        String choice1 = scanner1.nextLine();
        if (choice1.equals("1")) {
            System.out.println("주문이 완료되었습니다!");
            System.out.println("대기번호는 [ 1 ] 번 입니다.");
            System.out.println("잠시 후 메뉴판으로 돌아갑니다.");
            Menu.stop2Second();
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
            Menu.stop2Second();
        }
    }


     // 중복 제거를 위해서 해쉬코드와 equals 메소드를 재정의 함
    @Override
    public int hashCode() {
        String str = String.valueOf(price);
        return name.hashCode() + desc.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Order target){
            return  target.name.equals(name) && (target.desc==desc);
        }
        else {
            return false;
        }
    }
}