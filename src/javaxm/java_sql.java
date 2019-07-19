package javaxm;

import java.math.BigDecimal;

public class java_sql{
	int sql=0;   //>0为SQLserver连接,反之为ODBC数据源连接
	sqlsever sqlq=new sqlsever();
	String sql_id,sql_name,sql_sex,sql_pass,sql_year,sql_obj,sql_qiandao,sql_qiantui,newtime,qishi1,qishi2,zhongzhi1,zhongzhi2;
	String[] a;
	String b[][];
	int zongx,zongf,sumcd,sumzt,x_1,x_2;
	boolean boolupdate =false;
	public java_sql(){
		if(sql>0){
			sqlq.openDB("mysqlserver",sql);
		}else{
			sqlq.openDB("ywq",sql);
		}
	}
	public void show(String str1){        //登录界面初始化调用
		str1="n_id='"+str1+"'";
		sqlq.showDB("name","*",str1);
		sql_name=sqlq.name.trim();
		sql_pass=sqlq.pass.trim();
		sql_obj=sqlq.obj.trim();
	}
	public void showList(){
		String name="Salary,Attendance,name";
		String s="distinct Salary.gonghao 工号,n_name as 姓名,qishi as 起始时间,zhongzhi 终止时间,zong 本周期总时长";//distinct 
		String str1="Salary.gonghao=Attendance.gonghao and name.n_id=Salary.gonghao and zhongzhi in(select max(zhongzhi) from Salary group by gonghao)";
		sqlq.showDBList(name,s,str1);
		x_1=sqlq.x_1;x_2=sqlq.x_2;
		b=new String[x_2][x_1];
		for(int i=0;i<x_2;i++){
			for(int j=0;j<x_1;j++){
				b[i][j]=sqlq.b[i][j];
			}
		}
	}
	public void showname(String str1){      //、我的资料界面调用
		String s;
		if(str1.matches("[0-9]+")){
			s="Attendance.gonghao=name.n_id and n_id='"+str1+"'";
		}else{
		    s="Attendance.gonghao=name.n_id and n_name='"+str1+"'";
		}
		sqlq.showDB("name,Attendance","*",s);
		sql_name=sqlq.name.trim(); 
		sql_id=sqlq.id.trim();
		sql_sex=sqlq.sex.trim();
		sql_year=sqlq.year.trim();
		sql_obj=sqlq.obj.trim();
		newtime=sqlq.qiandao.trim();
	}
	public boolean show1(String str1,String str2){      //密码验证调用
		String s;
		if(str1.matches("[0-9]+")){
			s="n_id='"+str1+"'";
		}else{
		    s="n_name='"+str1+"'";
		}
		sqlq.showDB("name","*",s);
		sql_name=sqlq.name.trim();     //去掉前后空格
		sql_pass=sqlq.pass.trim();
		if(str2.equals(sql_pass)&&!sql_name.equals("")){
			return true;
		}else{
			return false;
		}
	}
	public boolean showAttendance(String str1){
		String s="gonghao='"+str1+"' and qiandao<>'0' and qiantui='0'";
		sqlq.showDB("Attendance","*",s);
		if(sqlq.sex.trim().equals("0")&&!sqlq.name.trim().equals("0")){
			sql_qiandao=sqlq.name.trim();
			return true;
		}
		else
			return false;
	}
	public void showz(String str1,String str2,String str3){
		String s="gonghao='"+str3+"' and riqi>='"+str1+"' and riqi<='"+str2+"' and qiantui<>'0'";
		sqlq.showzong("Attendance", "*", s);
		zongx=sqlq.H;
		zongf=sqlq.M;
		sumcd=sqlq.sumcd;
		sumzt=sqlq.sumzt;
	}
	public void showSalary(String str1){
		String s="gonghao='"+str1+"' and zhongzhi=(select MAX(zhongzhi) from Salary where gonghao='"+str1+"')";
		sqlq.showDB("Salary","*",s);
		qishi1=sqlq.qishi;
		zhongzhi1=sqlq.qiandao;
		s="gonghao='"+str1+"' and zhongzhi=(select MAX(zhongzhi) from Salary where gonghao='"+str1+"' and zhongzhi<>(select MAX(zhongzhi) from Salary where gonghao='"+str1+"'))";
		sqlq.showDB("Salary","*",s);
		qishi2=sqlq.qishi;
		zhongzhi2=sqlq.qiandao;
	}
	public void insert(String str1,String str2,String str3,String str4){    //注册提交调用
		String s="'"+str1+"','"+str2+"','"+str3+"','"+str4+"',"+"''"+",'"+"用户"+"'";
		sqlq.insertRecord("name",s);
	}
	public void insertAttendance(int s1,String s2,String str3){
		String s="'"+s1+"','"+s2+"','0','0','"+str3+"','0'";
		sqlq.insertRecord("Attendance",s);
	}
	public boolean insertSalary(String str1,int str2,int str3){
		if(!str1.matches("[0-9]+")){
			sqlq.showDB("name","*", "n_name='"+str1+"'");
			str1=sqlq.id;
			sql_id=sqlq.id;
		}else{
		sqlq.showDB("name","*", "n_id='"+str1+"'");
		sql_name=sqlq.name;
		}
		String s="gonghao='"+str1+"' and zhongzhi=(select MAX(zhongzhi) from Salary where gonghao='"+str1+"')";
		sqlq.showDB("Salary","*",s);
		int sss=Integer.parseInt(sqlq.qishi.trim());
		boolupdate=true;
		for(;sss==str2&&boolupdate;){
			sqlq.deleteRecord("Salary", s);
			boolupdate=sqlq.xxx;
			sqlq.showDB("Salary","*",s);
			sss=Integer.parseInt(sqlq.qishi.trim());
		}
		s="gonghao='"+str1+"' and zhongzhi=(select MAX(zhongzhi) from Salary where gonghao='"+str1+"')";
		String ss="zhongzhi='"+(str2-1)+"'";
		if(sqlq.updateRecord("Salary", ss,s)){
		s="'"+str1+"','0','0','0','0','0','"+str2+"','"+str3+"','0'";
		sqlq.insertRecord("Salary",s);
		return sqlq.xxx;
		}else{
			return false;
		}
	}
	public boolean insertSalary(int str1,int str2){
		String s=str1+"";
		s=s+str2;
		sqlq.showSalary("Salary","distinct gonghao",s);
		return sqlq.xxx;
	}
	public void update(String str1,String str2,String str3,String str4,String str5){
		String s="n_name='"+str1+"',n_sex='"+str2+"',n_year='"+str3+"',mima='"+str4+"'";
		String ss="n_id='"+str5+"'";
		boolupdate=sqlq.updateRecord("name",s,ss);
		
	}
	public void qantui(String str1,int str2,int str3,String str4){
		String s="qiantui='"+str1+"',shichang='"+str2+"小时"+str3+"分钟'";
		String ss="gonghao='"+str4+"' and qiantui='0'";
		boolupdate=sqlq.updateRecord("Attendance",s,ss);
	}
	public void updateshicheng(int str2,int str3,String str4){
		float f=(float)str2+(float)str3/60,f1;
		BigDecimal b=new BigDecimal(f);
		f1=b.setScale(3,BigDecimal.ROUND_HALF_UP).floatValue();  //四舍五入
		String s="zong='"+f1+"'";
		String ss="gonghao='"+str4+"' and zhongzhi=(select MAX(zhongzhi) from Salary where gonghao='"+str4+"')";
		sqlq.updateRecord("Salary",s,ss);
	}
	public void delete(String str1){
		String s="n_name='"+str1+"'";
		sqlq.deleteRecord("name",s);
	}
	public void deletesj(){                                 //防止数据库数据泄露，调用数据库赋值后应当调用
		sql_id="";sql_name="";sql_sex="";sql_pass="";sql_year="";sql_obj="";
	}
	public void endsql(){
		sqlq.endlsql();
	}
}
