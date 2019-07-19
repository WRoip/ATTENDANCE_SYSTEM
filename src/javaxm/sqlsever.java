package javaxm;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
public class sqlsever {
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	ResultSetMetaData rsmd=null;
	String sDBDriver=null,sDBDriver2="sun.jdbc.odbc.JdbcOdbcDriver",sDBDriver1="com.microsoft.sqlserver.jdbc.SQLServerDriver";//("sun.jdbc.odbc.JdbcOdbcDriver");
	String sConnStr=null,sConnStr2="jdbc:odbc:",sConnStr1="jdbc:sqlserver://localhost\\SQLExpress:1433;DatabaseName=";  //localhost\\SQLExpress 服务器名
    String user ="sa",password ="123";    //user:SQL身份登录 登录名  ,password:登录密码
    String id="001",name="www",sex="nv",pass="123456",year,obj="用户",qishi,qiandao;
	String a[];
	String b[][];
	boolean xxx;
	int H=0,M=0,sumcd=0,sumzt=0,sum_i=0,x_1 = 0,x_2 = 0,ODBC=0,SQLserver=0;
	public void openDB(String dbName,int n_1){
		if(n_1>0){
			SQLserver=1;
			sDBDriver=sDBDriver1;
		    sConnStr=sConnStr1.concat(dbName);
		}else{
			ODBC=1;
			sDBDriver=sDBDriver2;
			sConnStr=sConnStr2.concat(dbName);
		}
		try{
			Class.forName(sDBDriver);
		}
		catch(java.lang.ClassNotFoundException e){
			System.err.println("forName err="+e.getMessage());
		}
		try{
			if(SQLserver==1){
			    conn=DriverManager.getConnection(sConnStr,user,password);
			}else{
				conn=DriverManager.getConnection(sConnStr);
			}
			stmt=conn.createStatement();
		}
		catch(SQLException e){
			System.err.println("getConnection err="+e.getMessage());
		}
	}
	public void showSalary(String tabName,String fldList,String str1){
		String s="SELECT distinct gonghao FROM Salary";
		sum_i=0;
		try{
			rs=stmt.executeQuery(s);
			rsmd=rs.getMetaData();
			while(rs.next()){
				sum_i++;
			}
		}
		catch(SQLException e){
			System.err.println("xxxx err="+e.getMessage());
		}
		s="SELECT "+fldList+" FROM "+tabName;
		a=new String[sum_i];
		int zz=sum_i;
		try{
			sum_i=0;
			rs=stmt.executeQuery(s);
			rsmd=rs.getMetaData();
			while(rs.next()){
			    a[sum_i]=rs.getString(1).trim();
				sum_i++;
			}
		}
		catch(SQLException e){
			System.err.println("showSalary err="+e.getMessage());
		}
		for(int i=0;i<zz;i++){
		   int s1_1=Integer.parseInt(str1.substring(0, 8));
		   int s2_1=Integer.parseInt(str1.substring(8, 16));
		   int s_i=s1_1-1;
		   s="gonghao='"+a[i]+"' and zhongzhi=(select MAX(zhongzhi) from Salary where gonghao='"+a[i]+"')";
		   showDB("Salary","*",s);
			int sss=Integer.parseInt(qishi.trim());
			xxx=true;
			for(;sss==s1_1&&xxx;){
				deleteRecord("Salary", s);
				showDB("Salary","*",s);
				sss=Integer.parseInt(qishi.trim());
			}
		   String ss="zhongzhi='"+(s_i)+"'";
			if(updateRecord("Salary", ss,s)){
		      ss="insert into Salary values('"+a[i]+"','0','0','0','0','0','"+s1_1+"','"+s2_1+"','0')";
		      try{
			      stmt.executeUpdate(ss);
			      xxx=true;
		      }
		      catch(SQLException e){
			      System.err.println("insertRecord error: "+e.getMessage());
			      xxx=false;
		      }
			}
		}
	}
	public void showDBList(String tabName,String fldList,String str1){
		String s="SELECT "+fldList+" FROM "+tabName;
		if(str1!=null){
			s=s.concat(" WHERE "+str1);
		}
		sum_i=0;
		try{
			rs=stmt.executeQuery(s);
			rsmd=rs.getMetaData();
			x_1=rsmd.getColumnCount();
			while(rs.next()){
				sum_i++;
			}
		}
		catch(SQLException e){
			System.err.println("showDB err="+e.getMessage());
		}
		x_2=sum_i;
		b=new String[x_2][x_1];
		try{
			rs=stmt.executeQuery(s);
			rsmd=rs.getMetaData();
			int i=0;
			while(rs.next()){
				for(int j=1;j<=rsmd.getColumnCount();j++){
					b[i][j-1]=rs.getString(j);
				}
				i++;
			}
		}
		catch(SQLException e){
			System.err.println("showDB err="+e.getMessage());
		}
	}
	public void showDB(String tabName,String fldList,String str1){
		String s="SELECT "+fldList+" FROM "+tabName;
		id="";
		name="";
		sex="";
		pass="";
		year="";
		obj="";
		qiandao="";
		if(str1!=null){
			s=s.concat(" WHERE "+str1);
		}
		try{
			rs=stmt.executeQuery(s);
			rsmd=rs.getMetaData();
			while(rs.next()){
				for(int j=1;j<=rsmd.getColumnCount();j++){
					if(j==1) id=rs.getString(j);
					if(j==2) name=rs.getString(j);
					if(j==3) sex=rs.getString(j);
					if(j==4) pass=rs.getString(j);
					if(j==5) year=rs.getString(j);
					if(j==6) obj=rs.getString(j);
					if(j==7) qishi=rs.getString(j);
					if(j==8) qiandao=rs.getString(j);
				}
			}
		}
		catch(SQLException e){
			System.err.println("showDB err="+e.getMessage());
		}
	}
	@SuppressWarnings("unused")
	public void showzong(String tabName,String fldList,String str1){
		String s="SELECT "+fldList+" FROM "+tabName+" WHERE "+str1;
		String a = null,b=null,T;
		Integer a3;
		int i=0;
		H=0;
		M=0;
		sumcd=0;
		sumzt=0;
		try{
			rs=stmt.executeQuery(s);
			rsmd=rs.getMetaData();
			while(rs.next()){
				i++;
				for(int j=1;j<=rsmd.getColumnCount();j++){ 
					if(j==4&&i>=1){ 
					a=rs.getString(j);
					String [] cl1=a.split("小时");
					List<String> cls1=new ArrayList<String>();
					//for(int ii=0;ii<cl1.length;ii++){
					//	cls1.add(cl1[ii]);
					//}
					T=cl1[1];
					H=a3=Integer.parseInt(cl1[0])+H;
					String [] cl2=T.split("分钟");
					List<String> cls2=new ArrayList<String>();
					for(int ii=0;ii<cl2.length;ii++){
						cls2.add(cl2[ii]);
					}
					M=a3=Integer.parseInt(cl2[0])+M;
					}
					if(j==6){ 
						b=rs.getString(j).trim();
					    if(b.trim().equals("1")){
						    sumcd++;
					    }
					    else if(b.trim().equals("2")){
						    sumzt++;
					    }
					    else if(b.trim().equals("3")){
						    sumcd++;
						    sumzt++;
					    }
					}
				}
			}
			H=H+M/60;
			M=M%60;
		}
		catch(SQLException e){
			System.err.println("showzong err="+e.getMessage());
		}
	}
	public void insertRecord(String tabName,String str1){
		String s=new String("insert into ");
		s=s.concat(tabName+" values("+str1+")");
		try{
			stmt.executeUpdate(s);
			xxx=true;
		}
		catch(SQLException e){
			System.err.println("insertRecord error: "+e.getMessage());
			xxx=false;
		}
	}
	public boolean updateRecord(String tabName,String str1,String str2){
		String s=new String("begin transaction UPDATE "+tabName);
		String sss=" where "+str2;
		s=s.concat(" SET "+str1);
		s=s.concat(sss);
		sss=" if @@Error>0 rollback transaction else commit transaction";
		s=s.concat(sss);
		try{
			stmt.executeUpdate(s);
			return true;
		}
		catch(SQLException e){
			System.err.println("updateRecord error: "+e.getMessage());
			return false;
		}
	}
	public void deleteRecord(String tabName,String str1){
		String s=new String("delete from "+tabName+" where "+str1);
		try{
			int j=stmt.executeUpdate(s);
			if(j==1){
                xxx=true;
             }else{
                xxx=false;
             }
		}
		catch(SQLException e){
			System.err.println("deleteRecord error: "+e.getMessage());
		}
	}
	public void endlsql(){
		try{
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
