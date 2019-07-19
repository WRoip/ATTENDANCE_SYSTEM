package javaxm;

import java.sql.*; 
public class E11 {
   public static void main(String args[]) {
      Connection con=null;
      Statement sql=null; 
      ResultSet rs;
      try{
    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //加载JDBC_MySQL驱动
      }
      catch(Exception e){}
      String uri = "jdbc:sqlserver://localhost\\SQLExpress:1433;DatabaseName=mysqlserver"; 
      String user ="sa";
      String password ="123";
      try{  
    	  System.out.println("w");
         con = DriverManager.getConnection(uri,user,password); //连接代码   ,user,password
      }
      catch(SQLException e){
         System.err.println("getConnection:"+e.getMessage());
      }
      try { 
    	  System.out.println("www");
          sql=con.createStatement();
          rs=sql.executeQuery("SELECT * FROM name"); //查询mess表
          while(rs.next()) {
             String number=rs.getString(1);
             //String name=rs.getString(2);
            // Date date=rs.getDate(3);
            // float height=rs.getFloat(4);
           System.out.printf("%s\t",number);
            // System.out.printf("%s\t",name);
             //System.out.printf("%s\t",date); 
             //System.out.printf("%.2f\n",height);
          }
          System.out.println("ok");
          con.close();
      }
      catch(SQLException e) { 
         System.err.println("createStatement:"+e.getMessage());
      }
  }
}
