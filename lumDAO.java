package 올룸골룸.VO;

import KH_JDBC.COMMON.Common;
import KH_JDBC.VO.EmpVo;
import 올룸골룸.VO.lumCommon;
import 올룸골룸.VO.lumDAO;
import 올룸골룸.VO.OlumGollum;
import 올룸골룸.VO.lumMain;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class lumDAO extends lumMain {
        Connection conn = null;
        Statement stmt =null; // create Statement 방식
        PreparedStatement pSmt = null; // Prepared Statement 방식
        ResultSet rs = null; // database 부터 결과를 받는 변수
        Scanner sc = new Scanner(System.in);
        // SELECT문(조회)
        public List<OlumGollum> olumGollumSelect() {
            List<OlumGollum> list = new ArrayList<>();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                conn = lumCommon.getConnection();
                stmt = conn.createStatement();
                String sql = "SELECT * FROM INFO";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String user_mail = rs.getString("USER_MAIL");
                    String password = rs.getString("PASSWORD");
                    String name = rs.getString("NAME");
                    int id_card_number = rs.getInt("FIRST_ID_CARDNUM");
                    int phone_number = rs.getInt("PHONE_NUMBER");
                    String address = rs.getString("ADDRESS");
                    int gender = rs.getInt("GENDER");
                    String nickname = rs.getString("NICKNAME");
                    list.add(new OlumGollum(user_mail, password, name, id_card_number, phone_number, address, gender, nickname));
                }
                lumCommon.close(rs);
                lumCommon.close(stmt);
                lumCommon.close(conn);

            } catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }
        public void infoInsert(){
            OlumGollum olumGollum = InputFunc();
            String query = "INSERT INTO INFO(USER_MAIL, PASSWORD, NAME, FIRST_ID_CARDNUM, PHONE_NUMBER, ADDRESS, GENDER, NICKNAME)" +
                    "VALUES(?,?,?,?,?,?,?,?)";
            try{
                conn = Common.getConnection();
                pSmt = conn.prepareStatement(query);
                pSmt.setString(1,olumGollum.getUser_mail());
                pSmt.setString(2,olumGollum.getPassword());
                pSmt.setString(3,olumGollum.getName());
                pSmt.setInt(4,olumGollum.getFirst_id_cardnum());
                pSmt.setInt(5,olumGollum.getPhone_number());
                pSmt.setString(6,olumGollum.getAddress());
                pSmt.setInt(7,olumGollum.getGender());
                pSmt.setString(8,olumGollum.getNickname());
                int rst = pSmt.executeUpdate();
                System.out.print("rst :" + rst);

            }catch(Exception e){
                e.printStackTrace();
            }
            Common.close(pSmt);
            Common.close(conn);
        }
        public void Selectprn(List<OlumGollum> list){
            for (OlumGollum e : list){
                System.out.print(e.getUser_mail() + " ");
                System.out.print(e.getAddress() + " ");
                System.out.print(e.getPassword() + " ");
                System.out.print(e.getName() + " ");
                System.out.print(e.getGender()+ " ");
                System.out.print(e.getPhone_number() + " ");
                System.out.print(e.getFirst_id_cardnum() + " ");
                System.out.println(e.getNickname());
            }
        }
    }
