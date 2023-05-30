import java.util.ArrayList;

public class Menu {
    public String name;

    public String desc;

    public Menu() {
    }

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    // 메뉴 출력 for
    public void listOutput(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            Menu menuList = (Menu) list.get(i);
            System.out.println(i + 1 + "." + menuList.name + "|" + menuList.desc);
        }
    }

    // 확인, 취소 출력
    public void listOutputO(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            Menu menuList = (Menu) list.get(i);
            System.out.println(i + 3 + "." + menuList.name + "|" + menuList.desc);
        }
    }

    //greeting
    public static void greeting(){
        System.out.println("\"BUGERKING에 오신 것을 환영합니다.\" \n 아래 메뉴판을 보시고 주문해주세요.\n");
    }

    //title method
    public static void title(String title) {
        System.out.println("[ " + title + " ]");
    }

    // 2초 대기 후 이동
    public static void stop2Second() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}


