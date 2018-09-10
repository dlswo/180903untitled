package org.injae;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class VoteDAO {

    public void addVote(String leaderId) {

        // 순서

        Connection con = null;
        Statement stmt = null;
        String sql = "insert into tbl_vote (userid) values(";
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.10.10.80:1521:XE",
                    "zerock",
                    "zerock");
            System.out.println(con);
            stmt = con.createStatement();
            sql += "\'" + leaderId+"\')";
            System.out.println(sql);

            int count = stmt.executeUpdate(sql);

            System.out.println(count);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(con != null){
                try { con.close();}catch(Exception e){}
            }

        }//end finally

        // 1.Connection 맺기


        // 2. Statement SQL 전달

        // 3. Statement 실행

        // 4. close


    } // end method
}//end class
