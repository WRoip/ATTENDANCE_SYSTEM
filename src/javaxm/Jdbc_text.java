package javaxm;
import java.sql.*;
public class Jdbc_text {
	public static void main(String args[]) {
             //public sqlmain(){
		Connection ct=null;
		Statement sm=null;
                //PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct=DriverManager.getConnection("jdbc:odbc:ywq");
			sm=ct.createStatement();
			rs=sm.executeQuery("select * from name");                          //数据库执行语句
                        int i=sm.executeUpdate("insert into name values('002','王武','男','112233')");//添加数据
                        if(i==1){
                           System.out.println("OK");
                        }else{
                           System.out.println("NO");
                        }
			rs=sm.executeQuery("select * from name");        //数据库执行语句
			while(rs.next()){                                 //读取数据库循环输出
				String a=rs.getString(1);
				String b=rs.getString(2);
				String c=rs.getString(3);
				System.out.println(a+"\t"+b+"\t"+c);
			}
			rs=sm.executeQuery("select * from name");                          //数据库执行语句
                        int j=sm.executeUpdate("delete from name where n_name='王武'");//数据
                        if(j==1){
                           System.out.println("OK");
                        }else{
                           System.out.println("NO");
                        }
			rs=sm.executeQuery("select * from name");        //数据库执行语句
			while(rs.next()){                                 //读取数据库循环输出
				String a=rs.getString(1);
				String b=rs.getString(2);
				String c=rs.getString(4);
				System.out.println(a+"\t"+b+"\t"+c);
			}
                        /*ps=ct.prepareStatement("select * from name where 姓名=? and 性别=? and 年龄=?");
                        ps.setString(1,"王武");
                        ps.setString(2,"男");
                        ps.setInt(3,35);
                        int j=ps.executeUpdate();
                        if(j==1){
                           System.out.println("OK");
                        }else{
                           System.out.println("NO");
                        }
                        
                        rs=ps.executeQuery();
			while(rs.next()){
				String a=rs.getString(1);
				String b=rs.getString(2);
				int c=rs.getInt(3);
				System.out.println(a+"\t"+b+"\t"+c);
			}*/
                        
                        
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(sm!=null){
					sm.close();
				}
				/*if(ps!=null){
					ps.close();
				}*/
				if(ct!=null){
					ct.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
              //}
	}
}
