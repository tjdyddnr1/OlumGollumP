package 올룸골룸.VO;


import KH_JDBC.VO.EmpVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class lumMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lumDAO dao = new lumDAO();

        while (true) {
            System.out.println("=====================================================================");
            System.out.print("메뉴 선택 :[0]EXITS [1]SELECT [2]INSERT [3]UPDATE [4]DELETE [5]QUIT : ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    List<OlumGollum> list = dao.olumGollumSelect();
                    dao.Selectprn(list);
                    break;
                case 2:
                    dao.infoInsert();
                    break;
                default:
                    System.out.print("메뉴를 잘못 선택하셨습니다.");
            }
            if (sel == 0 || sel == 5) break;
        }

    }
    public OlumGollum InputFunc() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원가입 페이지 : ");
        System.out.print("아이디 입력(mail) : ");
        String user_mail = sc.next();
        System.out.print("비밀번호 입력 : ");
        String password = sc.next();
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("생년월일 입력 : ");
        int first_id_cardnum = sc.nextInt();
        System.out.print("휴대폰 번호 입력 : ");
        int phone_number = sc.nextInt();
        sc.nextLine();
        System.out.print("주소 입력 : ");
        String address = sc.nextLine();
        System.out.print("성별 입력 : ");
        int gender = sc.nextInt();
        System.out.print("닉네임 입력 : ");
        String  nickname = sc.next();
        OlumGollum olumGollum = new OlumGollum(user_mail, password, name, first_id_cardnum, phone_number, address, gender, nickname);
        return olumGollum;
    }
}
