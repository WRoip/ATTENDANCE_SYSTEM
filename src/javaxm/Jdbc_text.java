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
			rs=sm.executeQuery("select * from name");                          //���ݿ�ִ�����
                        int i=sm.executeUpdate("insert into name values('002','����','��','112233')");//�������
                        if(i==1){
                           System.out.println("OK");
                        }else{
                           System.out.println("NO");
                        }
			rs=sm.executeQuery("select * from name");        //���ݿ�ִ�����
			while(rs.next()){                                 //��ȡ���ݿ�ѭ�����
				String a=rs.getString(1);
				String b=rs.getString(2);
				String c=rs.getString(3);
				System.out.println(a+"\t"+b+"\t"+c);
			}
			rs=sm.executeQuery("select * from name");                          //���ݿ�ִ�����
                        int j=sm.executeUpdate("delete from name where n_name='����'");//����
                        if(j==1){
                           System.out.println("OK");
                        }else{
                           System.out.println("NO");
                        }
			rs=sm.executeQuery("select * from name");        //���ݿ�ִ�����
			while(rs.next()){                                 //��ȡ���ݿ�ѭ�����
				String a=rs.getString(1);
				String b=rs.getString(2);
				String c=rs.getString(4);
				System.out.println(a+"\t"+b+"\t"+c);
			}
                        /*ps=ct.prepareStatement("select * from name where ����=? and �Ա�=? and ����=?");
                        ps.setString(1,"����");
                        ps.setString(2,"��");
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
