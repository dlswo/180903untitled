package org.injae;

import org.injae.domain.ReviewVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ReviewDAO {

    public void add(ReviewVO vo){

        // 순서

        Connection con = null;
        PreparedStatement stmt = null;
        String sql =
                "insert into tbl_review ( rno, mid, mno, score, cmt) values (seq_review.nextval, ?, ?, ?, ?)";
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.10.10.91:1521:XE",
                    "zerock",
                    "12345678");
            System.out.println(con);
            stmt = con.prepareStatement(sql);
            //mid, mno, score
            stmt.setString(1,vo.getMid());
            stmt.setInt(2,vo.getmno());
            stmt.setDouble(3,vo.getScore());
            stmt.setString(4,vo.getCmt());

            System.out.println(sql);

            int count = stmt.executeUpdate();

            System.out.println(count);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {
                    }
                }

            }//end finally

            // 1.Connection 맺기


            // 2. Statement SQL 전달

            // 3. Statement 실행

            // 4. close
        }

    } // end method
}//end class

