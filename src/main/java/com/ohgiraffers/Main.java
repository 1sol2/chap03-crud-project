package com.ohgiraffers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Application a = new Application();

        System.out.println("1. 전체 도시 조회");
        System.out.println("2. 도시 코드별 정보 조회");
        System.out.println("3. 도시 수정");
        System.out.println("4. 도시 삽입");
        System.out.println("5. 도시 삭제");


        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        switch (num) {
            case 1:
                a.menu1();
                break;
            case 2:
                System.out.println("궁금한 도시의 코드를 말해라");
                Scanner sc2 = new Scanner(System.in);

                int code = sc2.nextInt();
                sc2.nextLine();
                a.menu2(code);
                break;
            case 3:
                Scanner sc3 = new Scanner(System.in);
                System.out.println("수정하고 싶은 도시 코드를 말해라");
                int cityId = sc3.nextInt();
                sc3.nextLine();
                System.out.println("변경할 도시 이름은?");
                String city = sc3.nextLine();
                System.out.println("변경할 나라 코드는?");
                int countryId = sc3.nextInt();
                a.menu3(cityId, city,countryId);
                break;
            case 4:
                Scanner sc4 = new Scanner(System.in);
                System.out.println("추가하고 싶은 도시명을 말해라");
                String city4 = sc4.nextLine();
                System.out.println("나라 코드를 말해라");
                int countryId4 = sc4.nextInt();
                sc4.nextLine();
                a.menu4(city4, countryId4);
                break;
            case 5:
                Scanner sc5 = new Scanner(System.in);
                System.out.println("삭제하고 싶은 도시 코드를 말해라");
                int cityId5 = sc5.nextInt();
                a.menu5(cityId5);
                break;
        }
    }
}
