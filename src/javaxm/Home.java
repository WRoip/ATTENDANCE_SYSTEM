package javaxm;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class Home{
	int xtime,ONE_SECOND=1000,Htime,Mtime,time1,time2,zaoqi1_1=0,zaoqi1_2=0,zaoqi2_1=0,zaoqi2_2=0,x_1,x_2,c_i,sum_x=1;;
	
	Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
	int Width=size.width,Height=size.height;
	
	JFrame jf;
	JPanel pa,pb,pan1,pan2,pan2_1,pan2_2,pan2_3,pan2_4,pan3;
	JScrollPane pan2_2_1;
	CardLayout card;
	java_sql homesql=new java_sql();
	
	ImageIcon image1,image11,image12,image2,image21,image22,image3,image31,image32,imagecaixfen,imagexiaoron;
	Image logoimage;
	JLabel Lx1,Lx2,Lx2_gh,dao1,dao2;
	JLabel L1,L2,L2_1,L2_2,L2_3,L2_4,L3,Ltime,Lwelcome,qandaotime,qantuitime,jishu,in_qandaotime,in_qantuitime,in_jishu;
	JLabel Lcaixfen,Lxiaoron,id,name,sex,year,work,newwork;
	JLabel in_id,in_name,in_sex,in_year,in_work,in_newwork;
	JLabel wname,wid,wtime,wbumen,wzhiwu,wnewtime;
	JLabel in_wname,in_wid,in_wtime,in_wbumen,in_wzhiwu,in_wnewtime;
	JLabel b_zhoqi,b_shichang,b_cdao,b_zaotui,l_zhoqi,l_shichang,l_cdao,l_zaotui;
	JLabel in_b_zhoqi,in_b_shichang,in_b_cdao,in_b_zaotui,in_l_zhoqi,in_l_shichang,in_l_cdao,in_l_zaotui;
	JButton b2_1_1,b2_1_2,b2_1_3,b2_2_1,b2_2_2,b2_2_3,b2_3_1,b2_3_2,b2_3_3,b2_4_1,b2_4_2,b2_4_3;
	JButton b2_n1_1,b2_n1_2,b2_n1_3,b2_n1_4,b2_n2_1,b2_n2_2,b2_n2_3,b2_n2_4,b2_n3_1,b2_n3_2,b2_n3_3,b2_n3_4,b2_n4_1,b2_n4_2,b2_n4_3,b2_n4_4;
	JButton b1_1,b1_2,b1_3,b2_1,b2_2,b2_3,b3_1,b3_2,b3_3,xiugai,tuichu,qandao,qantui,quxiaoqandao,tijiaoqandao;
	JButton bx_1,bx_2,lastyue,nextyue;
	JComboBox<?> JBx1_11,JBx1_12,JBx1_13,JBx1_21,JBx1_22,JBx1_23,JBx2_11,JBx2_12,JBx2_13,JBx2_21,JBx2_22,JBx2_23;
	JTable L_x;
	JList<?> L_x1;
	TextField Tx1; 
	Font Labelfont=new Font("楷体",Font.BOLD+Font.ITALIC,30);
Font JButtonfont=new Font("楷体",Font.BOLD+Font.TRUETYPE_FONT,30);
Font Textfont=new Font("宋体",Font.PLAIN,22);
Font timefont=new Font("宋体",Font.BOLD,22);
Color zicolor=new Color(0xff,0xff,0x00),ancolor=new Color(0x99,0x99,0xcc),dkzicolor=new Color(0xff,0xff,0xff);

String n_id="001",n_name="蔡雪奋",n_sex="女",n_year="21",n_work="用户",n_newwork="2018/6/9",account="0";
String n_wname="振华重工",n_wid="270181",n_wtime="2009/5/16",n_wbumen="设计部",n_wzhiwu="首席设计师",n_wnewtime="2018/6/9";
String Str_time,n_qandao="。。。暂未签到。。。",n_qantui="。。。暂未签退。。。";
String n_b_zhoqi1="20180516",n_b_zhoqi2="20180615",n_b_shichang1="0小时",n_b_shichang2="0小时",n_b_cdao="0 次",n_b_zaotui="0 次";
String n_l_zhoqi1="20180416",n_l_zhoqi2="20180515",n_l_shichang1="0小时",n_l_shichang2="0小时",n_l_cdao="0 次",n_l_zaotui="0 次";
String t1="1970年",t2="1971年",t3="1972年",t4="1973年",t5="1975年";
Object objy1_1,objy1_2,objy2_1,objy2_2,objm1_1,objm1_2,objm2_1,objm2_2,objd1_1,objd1_2,objd2_1,objd2_2;
String[] yea={t1,t2,t3,t4,t5},c;
String[] month={"01月","02月","03月","04月","05月","06月","07月","08月","09月","10月","11月","12月",};
String[] day={"01日","02日","03日","04日","05日","06日","07日","08日","09日","10日","11日","12日","13日","14日","15日","16日","17日","18日","19日","20日","21日","22日","23日","24日","25日","26日","27日","28日","29日","30日","31日"};
String b[][],bb[][];
@SuppressWarnings({ "rawtypes", "unchecked"})
public void Home1(String str1,String str2){
	//Str_time=df.format(new Date());    //获取当前系统时间;
account=str2;
homesql.showname(str1);
n_id=homesql.sql_id;
n_name=homesql.sql_name;
n_sex=homesql.sql_sex;
n_year=homesql.sql_year;
n_work=homesql.sql_obj;
n_newwork=homesql.newtime.substring(0,10);
n_wnewtime=homesql.newtime.substring(0,16);
int x=Integer.parseInt(n_newwork.substring(0, 4));
t1=x+"年";t2=(x+1)+"年";t3=(x+2)+"年";t4=(x+3)+"年";t5=(x+4)+"年";
yea[0]=t1;yea[1]=t2;yea[2]=t3;yea[3]=t4;yea[4]=t5;
homesql.deletesj();
homesql.showSalary(n_id);
n_b_zhoqi1=homesql.qishi1;
n_b_zhoqi2=homesql.zhongzhi1;
homesql.showz(n_b_zhoqi1,n_b_zhoqi2,n_id);
n_b_shichang1=homesql.zongx+"小时";
n_b_shichang2=homesql.zongf+"分钟";
n_b_cdao=homesql.sumcd+" 次";
n_b_zaotui=homesql.sumzt+" 次";
homesql.updateshicheng(homesql.zongx,homesql.zongf,n_id);
homesql.showSalary(n_id);
n_l_zhoqi1=homesql.qishi2;
n_l_zhoqi2=homesql.zhongzhi2;
homesql.showz(n_l_zhoqi1,n_l_zhoqi2,n_id);
n_l_shichang1=homesql.zongx+"小时";
n_l_shichang2=homesql.zongf+"分钟";
n_l_cdao=homesql.sumcd+" 次";
n_l_zaotui=homesql.sumzt+" 次";
if(homesql.showAttendance(n_id)){
	n_qandao=homesql.sql_qiandao;
	}
homesql.showList();
x_1=homesql.x_1;x_2=homesql.x_2;
b=new String[x_2+1][x_1];
c_i=0;
for(int i=0;i<x_2;i++){
	c_i++;
	for(int j=0;j<x_1;j++){
	    b[i][j]=homesql.b[i][j];
	}
}
c=new String[x_1];
for(int i=0;i<x_1;i++){
	c[i]=i+"";
}
bb=new String[14][x_1];
int ii;
if(x_2<14)
	ii=x_2+1;
else
	ii=14;
for(int i=0;i<ii;i++){
	if(i==0){
	bb[i][0]="工号";bb[i][1]="姓名";bb[i][2]="开始时间";bb[i][3]="结束时间";bb[i][4]="本周期总时长";
	}else{
	    for(int j=0;j<x_1;j++){
    	    bb[i][j]=b[i-1][j];
        }
	}
}
jf=new JFrame();
pa=new JPanel();
pb=new JPanel();
card=new CardLayout();
pan1=new JPanel();
pan2=new JPanel();
pan2_1=new JPanel();
pan2_2=new JPanel();
pan2_2_1=new JScrollPane();
pan2_3=new JPanel();
pan2_4=new JPanel();
pan3=new JPanel();
pan1.setLayout(null);
pan2.setLayout(null);
pan2_1.setLayout(null);
pan2_2.setLayout(null);
//pan2_2_1.setLayout(null);
pan2_3.setLayout(null);
pan2_4.setLayout(null);
pan3.setLayout(null);
pa.setLayout(card);                   //卡片布局
image1=new ImageIcon("jpg\\Home-1.jpg");
image11=new ImageIcon("jpg\\Home-11.jpg");
image12=new ImageIcon("jpg\\Home-12.jpg");
image2=new ImageIcon("jpg\\Home-2.jpg");
image21=new ImageIcon("jpg\\Home-21.jpg");
image22=new ImageIcon("jpg\\Home-22.jpg");
image3=new ImageIcon("jpg\\Home-3.jpg");
image31=new ImageIcon("jpg\\Home-31.jpg");
image32=new ImageIcon("jpg\\Home-32.jpg");
imagecaixfen=new ImageIcon("jpg\\caixfen.jpg");
imagexiaoron=new ImageIcon("jpg\\xiaoron.jpg");
L1=new JLabel(image1);
L2=new JLabel(image2);
L2_1=new JLabel(image2);
L2_2=new JLabel(image2);
L2_3=new JLabel(image2);
L2_4=new JLabel(image2);
L3=new JLabel(image3);
L_x1=new JList();
L_x=new JTable(bb,c);
L_x.setRowHeight(40);//每行的高度
L_x.setFont(Textfont);
L_x.setShowVerticalLines(false);   //竖向网格
L_x.setRowSelectionAllowed(true);  //选择一行
//L_x1.add(L_x);
//pan2_2_1.setViewportView(L_x);
L_x1.setVisibleRowCount(10);
//pan2_2_1.setBorder(BorderFactory.createTitledBorder("员工信息"));
pan2_2_1.setWheelScrollingEnabled(false);
Lwelcome=new JLabel(n_name+" 欢迎您！",JLabel.RIGHT);
Ltime=new JLabel("当前时间："+Str_time,JLabel.RIGHT);
qandaotime=new JLabel("本次签到：");
qantuitime=new JLabel("本次签退：");
jishu=new JLabel("本次计时：");
in_qandaotime=new JLabel(n_qandao);
in_qantuitime=new JLabel(n_qantui);
in_jishu=new JLabel(Htime+" 小时 "+Mtime+" 分钟");
b_zhoqi=new JLabel("本次周期：",JLabel.RIGHT);
b_shichang=new JLabel("周期时长：",JLabel.RIGHT);
b_cdao=new JLabel("迟到次数：",JLabel.RIGHT);
b_zaotui=new JLabel("早退次数：",JLabel.RIGHT);
l_zhoqi=new JLabel("上次周期：",JLabel.RIGHT);
l_shichang=new JLabel("周期时长：",JLabel.RIGHT);
l_cdao=new JLabel("迟到次数：",JLabel.RIGHT);
l_zaotui=new JLabel("早退次数：",JLabel.RIGHT);
in_b_zhoqi=new JLabel(n_b_zhoqi1+"-"+n_b_zhoqi2,JLabel.LEFT);
in_b_shichang=new JLabel(n_b_shichang1+n_b_shichang2,JLabel.LEFT);
in_b_cdao=new JLabel(n_b_cdao,JLabel.LEFT);
in_b_zaotui=new JLabel(n_b_zaotui,JLabel.LEFT);
in_l_zhoqi=new JLabel(n_l_zhoqi1+"-"+n_l_zhoqi2,JLabel.LEFT);
in_l_shichang=new JLabel(n_l_shichang1+n_l_shichang2,JLabel.LEFT);
in_l_cdao=new JLabel(n_l_cdao,JLabel.LEFT);
in_l_zaotui=new JLabel(n_l_zaotui,JLabel.LEFT);
id=new JLabel("登录号：",JLabel.RIGHT);
name=new JLabel("姓名：",JLabel.RIGHT);
sex=new JLabel("性别：",JLabel.RIGHT);
year=new JLabel("年龄：",JLabel.RIGHT);
work=new JLabel("登录身份：",JLabel.RIGHT);
newwork=new JLabel("最近登录：",JLabel.RIGHT);
in_id=new JLabel(n_id,JLabel.LEFT);
in_name=new JLabel(n_name,JLabel.LEFT);
in_sex=new JLabel(n_sex,JLabel.LEFT);
in_year=new JLabel(n_year,JLabel.LEFT);
in_work=new JLabel(n_work,JLabel.LEFT);
in_newwork=new JLabel(n_newwork,JLabel.LEFT);
wname=new JLabel("公司名称：",JLabel.RIGHT);
wid=new JLabel("工号：",JLabel.RIGHT);
wtime=new JLabel("入职时间：",JLabel.RIGHT);
wbumen=new JLabel("所在部门：",JLabel.RIGHT);
wzhiwu=new JLabel("职务：",JLabel.RIGHT);
wnewtime=new JLabel("最近签到：",JLabel.RIGHT);
in_wname=new JLabel(n_wname,JLabel.LEFT);
in_wid=new JLabel(n_wid,JLabel.LEFT);
in_wtime=new JLabel(n_wtime,JLabel.LEFT);
in_wbumen=new JLabel(n_wbumen,JLabel.LEFT);
in_wzhiwu=new JLabel(n_wzhiwu,JLabel.LEFT);
in_wnewtime=new JLabel(n_wnewtime,JLabel.LEFT);
Lcaixfen=new JLabel(imagecaixfen);
Lxiaoron=new JLabel(imagexiaoron);
dao1=new JLabel("到");
dao2=new JLabel("到");
Lx1=new JLabel("全部更新：所有员工周期将从下一天开始到下面指定时间结束！没有指定时间为无效");
Lx2=new JLabel("指定更新：该员工周期将从下一天开始到下面指定时间结束！没有指定时间为无效");
Lx2_gh=new JLabel("工号/姓名：");
Tx1=new TextField();
JBx1_11=new JComboBox(yea);
JBx1_12=new JComboBox(month);
JBx1_13=new JComboBox(day);
JBx1_21=new JComboBox(yea);
JBx1_22=new JComboBox(month);
JBx1_23=new JComboBox(day);
JBx2_11=new JComboBox(yea);
JBx2_12=new JComboBox(month);
JBx2_13=new JComboBox(day);
JBx2_21=new JComboBox(yea);
JBx2_22=new JComboBox(month);
JBx2_23=new JComboBox(day);
lastyue=new JButton("上一页");
nextyue=new JButton("下一页");
bx_1=new JButton("全部更新");
bx_2=new JButton("指定更新");
b1_1=new JButton("首页",image12);
b1_2=new JButton("管理",image21);
b1_3=new JButton("我的",image31);
//b1_3.setVerticalTextPosition(JButton.BOTTOM);
b2_1=new JButton("首页",image11);
b2_1_1=new JButton("首页",image11);
b2_2_1=new JButton("首页",image11);
b2_3_1=new JButton("首页",image11);
b2_4_1=new JButton("首页",image11);
b2_2=new JButton("管理",image22);
b2_1_2=new JButton("管理",image22);
b2_2_2=new JButton("管理",image22);
b2_3_2=new JButton("管理",image22);
b2_4_2=new JButton("管理",image22);
b2_3=new JButton("我的",image31);
b2_1_3=new JButton("我的",image31);
b2_2_3=new JButton("我的",image31);
b2_3_3=new JButton("我的",image31);
b2_4_3=new JButton("我的",image31);
b3_1=new JButton("首页",image11);
b3_2=new JButton("管理",image21);
b3_3=new JButton("我的资料",image32);
b2_n1_1=new JButton("周期更新");
b2_n1_2=new JButton("员工信息");
b2_n1_3=new JButton("职务调动");
b2_n1_4=new JButton("请假审批");
b2_n2_1=new JButton("周期更新");
b2_n2_2=new JButton("员工信息");
b2_n2_3=new JButton("职务调动");
b2_n2_4=new JButton("请假审批");
b2_n3_1=new JButton("周期更新");
b2_n3_2=new JButton("员工信息");
b2_n3_3=new JButton("职务调动");
b2_n3_4=new JButton("请假审批");
b2_n4_1=new JButton("周期更新");
b2_n4_2=new JButton("员工信息");
b2_n4_3=new JButton("职务调动");
b2_n4_4=new JButton("请假审批");
xiugai=new JButton("修改");
tuichu=new JButton("退出");
qandao=new JButton("签到");
qantui=new JButton("签退");
quxiaoqandao=new JButton("取消本次签到");
tijiaoqandao=new JButton("退出本次签到");
tijiaoqandao.setBorder(BorderFactory.createRaisedBevelBorder()); 
quxiaoqandao.setBorder(BorderFactory.createRaisedBevelBorder()); 
qandao.setBorder(BorderFactory.createRaisedBevelBorder()); 
qantui.setBorder(BorderFactory.createRaisedBevelBorder()); 
xiugai.setBorder(BorderFactory.createRaisedBevelBorder()); 
tuichu.setBorder(BorderFactory.createRaisedBevelBorder()); 
b1_1.setBorder(BorderFactory.createRaisedBevelBorder());  //突出
b2_2.setBorder(BorderFactory.createRaisedBevelBorder());
b3_3.setBorder(BorderFactory.createRaisedBevelBorder());
b2_1_2.setBorder(BorderFactory.createRaisedBevelBorder());
b2_2_2.setBorder(BorderFactory.createRaisedBevelBorder());
b2_3_2.setBorder(BorderFactory.createRaisedBevelBorder());
b2_4_2.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n1_1.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n1_2.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n1_3.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n1_4.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n2_1.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n2_2.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n2_3.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n2_4.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n3_1.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n3_2.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n3_3.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n3_4.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n4_1.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n4_2.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n4_3.setBorder(BorderFactory.createRaisedBevelBorder());
b2_n4_4.setBorder(BorderFactory.createRaisedBevelBorder());
bx_1.setBorder(BorderFactory.createRaisedBevelBorder());
bx_2.setBorder(BorderFactory.createRaisedBevelBorder());
lastyue.setBorder(BorderFactory.createRaisedBevelBorder());
nextyue.setBorder(BorderFactory.createRaisedBevelBorder());
b1_1.setHorizontalTextPosition(JButton.CENTER);          //字在图上
b1_2.setHorizontalTextPosition(JButton.CENTER);
b1_3.setHorizontalTextPosition(JButton.CENTER);
b2_1.setHorizontalTextPosition(JButton.CENTER);
b2_1_1.setHorizontalTextPosition(JButton.CENTER);
b2_2_1.setHorizontalTextPosition(JButton.CENTER);
b2_3_1.setHorizontalTextPosition(JButton.CENTER);
b2_4_1.setHorizontalTextPosition(JButton.CENTER);
b2_2.setHorizontalTextPosition(JButton.CENTER);
b2_1_2.setHorizontalTextPosition(JButton.CENTER);
b2_2_2.setHorizontalTextPosition(JButton.CENTER);
b2_3_2.setHorizontalTextPosition(JButton.CENTER);
b2_4_2.setHorizontalTextPosition(JButton.CENTER);
b2_3.setHorizontalTextPosition(JButton.CENTER);
b2_1_3.setHorizontalTextPosition(JButton.CENTER);
b2_2_3.setHorizontalTextPosition(JButton.CENTER);
b2_3_3.setHorizontalTextPosition(JButton.CENTER);
b2_4_3.setHorizontalTextPosition(JButton.CENTER);
b3_1.setHorizontalTextPosition(JButton.CENTER);
b3_2.setHorizontalTextPosition(JButton.CENTER);
b3_3.setHorizontalTextPosition(JButton.CENTER);
L1.setSize(Width, Height);
L2.setSize(Width, Height);
L3.setSize(Width, Height);
L1.setLocation(0, 0);
L2.setLocation(0, 0);
L3.setLocation(0, 0);
L2_1.setBounds(0, 0, Width, Height);
L2_2.setBounds(0, 0, Width, Height);
L2_3.setBounds(0, 0, Width, Height);
L2_4.setBounds(0, 0, Width, Height);
lastyue.setBounds(Width/5,Height-80, 150,40);
nextyue.setBounds(Width/5*4-200,Height-80, 150,40);
L_x.setBounds(Width/5-100,100,Width/5*3+200,Height-210);
L_x1.setBounds(Width/5-100,100,Width/5*3+200,Height-200);
qandaotime.setBounds(Width/2-300, Height/4-30,160,40);
qantuitime.setBounds(Width/2-300, Height/4+30,160,40);
jishu.setBounds(Width/2-300, Height/4+90,160,40);
b_zhoqi.setBounds(Width/2-450, Height/2+40, 160,50);
b_shichang.setBounds(Width/2-450, Height/2+100, 160,50);
b_cdao.setBounds(Width/2-450, Height/2+160, 160,50);
b_zaotui.setBounds(Width/2-450, Height/2+220, 160,50);
l_zhoqi.setBounds(Width/2+40, Height/2+40, 160,50);
l_shichang.setBounds(Width/2+40, Height/2+100, 160,50);
l_cdao.setBounds(Width/2+40, Height/2+160, 160,50);
l_zaotui.setBounds(Width/2+40, Height/2+220, 160,50);
in_b_zhoqi.setBounds(Width/2-290, Height/2+40,300,50);
in_b_shichang.setBounds(Width/2-290, Height/2+100,240,50);
in_b_cdao.setBounds(Width/2-290, Height/2+160,240,50);
in_b_zaotui.setBounds(Width/2-290, Height/2+220,240,50);
in_l_zhoqi.setBounds(Width/2+200, Height/2+40,300,50);
in_l_shichang.setBounds(Width/2+200, Height/2+100,240,50);
in_l_cdao.setBounds(Width/2+200, Height/2+160,240,50);
in_l_zaotui.setBounds(Width/2+200, Height/2+220,240,50);
in_qandaotime.setBounds(Width/2-50, Height/4-30,400,40);
in_qantuitime.setBounds(Width/2-50, Height/4+30,400,40);
in_jishu.setBounds(Width/2-50, Height/4+90,400,40);
Lwelcome.setBounds(Width-250,10, 250, 30);
Ltime.setBounds(Width-350,50, 350, 30);
id.setBounds(180,80,160,60);
name.setBounds(180,150,160,60);
sex.setBounds(180,220,160,60);
year.setBounds(180,290,160,60);
work.setBounds(180,360,160,60);
newwork.setBounds(180,430,160,60);
in_id.setBounds(345,80,160,60);
in_name.setBounds(345,150,160,60);
in_sex.setBounds(345,220,160,60);
in_year.setBounds(345,290,160,60);
in_work.setBounds(345,360,160,60);
in_newwork.setBounds(345,430,320,60);
wname.setBounds(650,80,160,60);
wid.setBounds(650,150,160,60);
wtime.setBounds(650,220,160,60);
wbumen.setBounds(650,290,160,60);
wzhiwu.setBounds(650,360,160,60);
wnewtime.setBounds(650,430,160,60);
in_wname.setBounds(815,80,160,60);
in_wid.setBounds(815,150,160,60);
in_wtime.setBounds(815,220,160,60);
in_wbumen.setBounds(815,290,160,60);
in_wzhiwu.setBounds(815,360,160,60);
in_wnewtime.setBounds(815,430,320,60);
Lcaixfen.setBounds(Width-300,0,300,400);
Lxiaoron.setBounds(Width-500,0,500,500);
Lx1.setBounds(Width/5-100,120,1200,40);
Lx2.setBounds(Width/5-100,360,1200,40);
dao1.setBounds(Width/4+310, 200,40,40);
dao2.setBounds(Width/5+360,500,40,40);
JBx1_11.setBounds(Width/4-100, 200,100,40);
JBx1_12.setBounds(Width/4+50, 200,100,40);
JBx1_13.setBounds(Width/4+200, 200,100,40);
JBx1_21.setBounds(Width/4*3-300, 200,100,40);
JBx1_22.setBounds(Width/4*3-150, 200,100,40);
JBx1_23.setBounds(Width/4*3, 200,100,40);
Lx2_gh.setBounds(Width/5,440,200,40);
Tx1.setBounds(Width/5+200,440,180,40);
JBx2_11.setBounds(Width/5+410,440,100,40);
JBx2_12.setBounds(Width/5+540,440,80,40);
JBx2_13.setBounds(Width/5+650,440,80,40);
JBx2_21.setBounds(Width/5+410,500,100,40);
JBx2_22.setBounds(Width/5+540,500,80,40);
JBx2_23.setBounds(Width/5+650,500,80,40);
bx_1.setBounds(Width/2-100,280,200,40);
bx_2.setBounds(Width/2-100,570,200,40);
b1_1.setBounds(0,0, 150, 120);
b1_2.setBounds(0,120, 60, 120);
b1_3.setBounds(0,240, 60, 120);
b2_1.setBounds(0,0, 60,120);
b2_2.setBounds(0,120,150,120);
b2_3.setBounds(0,240, 60,120);
b2_1_1.setBounds(0,0, 60,120);
b2_1_2.setBounds(0,120,150,120);
b2_1_3.setBounds(0,240, 60,120);
b2_2_1.setBounds(0,0, 60,120);
b2_2_2.setBounds(0,120,150,120);
b2_2_3.setBounds(0,240, 60,120);
b2_3_1.setBounds(0,0, 60,120);
b2_3_2.setBounds(0,120,150,120);
b2_3_3.setBounds(0,240, 60,120);
b2_4_1.setBounds(0,0, 60,120);
b2_4_2.setBounds(0,120,150,120);
b2_4_3.setBounds(0,240, 60,120);
b3_1.setBounds(0,0, 60,120);
b3_2.setBounds(0,120, 60,120);
b3_3.setBounds(0,240,150, 120);
b2_n1_1.setBounds(Width/5-100,20,200,40);
b2_n1_2.setBounds(Width/5*2-100,20,200,40);
b2_n1_3.setBounds(Width/5*3-100,20,200,40);
b2_n1_4.setBounds(Width/5*4-100,20,200,40);
b2_n2_1.setBounds(Width/5-100,20,200,40);
b2_n2_2.setBounds(Width/5*2-100,20,200,40);
b2_n2_3.setBounds(Width/5*3-100,20,200,40);
b2_n2_4.setBounds(Width/5*4-100,20,200,40);
b2_n3_1.setBounds(Width/5-100,20,200,40);
b2_n3_2.setBounds(Width/5*2-100,20,200,40);
b2_n3_3.setBounds(Width/5*3-100,20,200,40);
b2_n3_4.setBounds(Width/5*4-100,20,200,40);
b2_n4_1.setBounds(Width/5-100,20,200,40);
b2_n4_2.setBounds(Width/5*2-100,20,200,40);
b2_n4_3.setBounds(Width/5*3-100,20,200,40);
b2_n4_4.setBounds(Width/5*4-100,20,200,40);
xiugai.setBounds(Width-270,430,100,50);
tuichu.setBounds(Width-130,430,100,50);
qandao.setBounds(Width/2-110, Height/2-30,100, 50);
qantui.setBounds(Width/2+10, Height/2-30, 100,50);
quxiaoqandao.setBounds(Width-220, Height-100,200,50);
tijiaoqandao.setBounds(20, Height-100,200,50);
xiugai.setForeground(ancolor);
tuichu.setForeground(ancolor);
qandao.setFont(JButtonfont);
qantui.setFont(JButtonfont);
quxiaoqandao.setFont(JButtonfont);
tijiaoqandao.setFont(JButtonfont);
qandao.setForeground(Color.BLACK);
qantui.setForeground(Color.BLACK);
quxiaoqandao.setForeground(Color.BLACK);
tijiaoqandao.setForeground(Color.BLACK);
b1_1.setForeground(dkzicolor);
b1_2.setForeground(dkzicolor);
b1_3.setForeground(dkzicolor);
b2_1.setForeground(dkzicolor);
b2_1_1.setForeground(dkzicolor);
b2_1_2.setForeground(dkzicolor);
b2_1_3.setForeground(dkzicolor);
b2_2.setForeground(dkzicolor);
b2_2_1.setForeground(dkzicolor);
b2_2_2.setForeground(dkzicolor);
b2_2_3.setForeground(dkzicolor);
b2_3.setForeground(dkzicolor);
b2_3_1.setForeground(dkzicolor);
b2_3_2.setForeground(dkzicolor);
b2_3_3.setForeground(dkzicolor);
b2_4_1.setForeground(dkzicolor);
b2_4_2.setForeground(dkzicolor);
b2_4_3.setForeground(dkzicolor);
lastyue.setForeground(Color.BLACK);
nextyue.setForeground(Color.BLACK);
b3_1.setForeground(dkzicolor);
b3_2.setForeground(dkzicolor);
b3_3.setForeground(dkzicolor);
lastyue.setFont(Labelfont);
nextyue.setFont(Labelfont);
b1_1.setFont(Labelfont);
b2_2.setFont(Labelfont);
b2_1_2.setFont(Labelfont);
b2_2_2.setFont(Labelfont);
b2_3_2.setFont(Labelfont);
b2_4_2.setFont(Labelfont);
b3_3.setFont(Labelfont);
b2_n1_1.setFont(Labelfont);
b2_n1_2.setFont(Labelfont);
b2_n1_3.setFont(Labelfont);
b2_n1_4.setFont(Labelfont);
b2_n2_1.setFont(Labelfont);
b2_n2_2.setFont(Labelfont);
b2_n2_3.setFont(Labelfont);
b2_n2_4.setFont(Labelfont);
b2_n3_1.setFont(Labelfont);
b2_n3_2.setFont(Labelfont);
b2_n3_3.setFont(Labelfont);
b2_n3_4.setFont(Labelfont);
b2_n4_1.setFont(Labelfont);
b2_n4_2.setFont(Labelfont);
b2_n4_3.setFont(Labelfont);
b2_n4_4.setFont(Labelfont);
qandaotime.setFont(Labelfont);
qantuitime.setFont(Labelfont);
jishu.setFont(Labelfont);
b_zhoqi.setFont(Labelfont);
b_shichang.setFont(Labelfont);
b_cdao.setFont(Labelfont);
b_zaotui.setFont(Labelfont);
l_zhoqi.setFont(Labelfont);
l_shichang.setFont(Labelfont);
l_cdao.setFont(Labelfont);
l_zaotui.setFont(Labelfont);
in_b_zhoqi.setFont(Labelfont);
in_b_shichang.setFont(Labelfont);
in_b_cdao.setFont(Labelfont);
in_b_zaotui.setFont(Labelfont);
in_l_zhoqi.setFont(Labelfont);
in_l_shichang.setFont(Labelfont);
in_l_cdao.setFont(Labelfont);
in_l_zaotui.setFont(Labelfont);
JBx1_11.setFont(Textfont);
JBx1_12.setFont(Textfont);
JBx1_13.setFont(Textfont);
JBx1_21.setFont(Textfont);
JBx1_22.setFont(Textfont);
JBx1_23.setFont(Textfont);
JBx2_11.setFont(Textfont);
JBx2_12.setFont(Textfont);
JBx2_13.setFont(Textfont);
JBx2_21.setFont(Textfont);
JBx2_22.setFont(Textfont);
JBx2_23.setFont(Textfont);
dao1.setFont(Labelfont);
dao2.setFont(Labelfont);
dao1.setForeground(Color.WHITE);
dao2.setForeground(Color.WHITE);
Tx1.setFont(JButtonfont);
Lx1.setFont(Labelfont);
Lx2.setFont(Labelfont);
Lx2_gh.setFont(Labelfont);
Lx1.setForeground(Color.WHITE);
Lx2.setForeground(Color.WHITE);
Lx2_gh.setForeground(Color.WHITE);
bx_1.setFont(Labelfont);
bx_1.setForeground(Color.WHITE);
bx_2.setFont(Labelfont);
bx_2.setForeground(Color.WHITE);
b2_n1_1.setForeground(Color.YELLOW);
b2_n2_2.setForeground(Color.YELLOW);
b2_n3_3.setForeground(Color.YELLOW);
b2_n4_4.setForeground(Color.YELLOW);
b_zhoqi.setForeground(dkzicolor);
b_shichang.setForeground(dkzicolor);
b_cdao.setForeground(dkzicolor);
b_zaotui.setForeground(dkzicolor);
l_zhoqi.setForeground(dkzicolor);
l_shichang.setForeground(dkzicolor);
l_cdao.setForeground(dkzicolor);
l_zaotui.setForeground(dkzicolor);
in_b_zhoqi.setForeground(dkzicolor);
in_b_shichang.setForeground(dkzicolor);
in_b_cdao.setForeground(dkzicolor);
in_b_zaotui.setForeground(dkzicolor);
in_l_zhoqi.setForeground(dkzicolor);
in_l_shichang.setForeground(dkzicolor);
in_l_cdao.setForeground(dkzicolor);
in_l_zaotui.setForeground(dkzicolor);
in_jishu.setFont(Labelfont);
jishu.setForeground(dkzicolor);
in_jishu.setForeground(dkzicolor);
in_qandaotime.setFont(Labelfont);
in_qantuitime.setFont(Labelfont);
qandaotime.setForeground(dkzicolor);
qantuitime.setForeground(dkzicolor);
in_qandaotime.setForeground(dkzicolor);
in_qantuitime.setForeground(dkzicolor);
Lwelcome.setForeground(Color.WHITE);
Ltime.setForeground(Color.WHITE);
Lwelcome.setFont(timefont);
Ltime.setFont(timefont);
id.setForeground(zicolor);
id.setFont(Labelfont);
name.setForeground(zicolor);
name.setFont(Labelfont);
sex.setForeground(zicolor);
sex.setFont(Labelfont);
year.setForeground(zicolor);
year.setFont(Labelfont);
work.setForeground(zicolor);
work.setFont(Labelfont);
newwork.setForeground(zicolor);
newwork.setFont(Labelfont);
in_id.setForeground(zicolor);
in_id.setFont(Labelfont);
in_name.setForeground(zicolor);
in_name.setFont(Labelfont);
in_sex.setForeground(zicolor);
in_sex.setFont(Labelfont);
in_year.setForeground(zicolor);
in_year.setFont(Labelfont);
in_work.setForeground(zicolor);
in_work.setFont(Labelfont);
in_newwork.setForeground(zicolor);
in_newwork.setFont(Labelfont);
wid.setForeground(zicolor);
wid.setFont(Labelfont);
wname.setForeground(zicolor);
wname.setFont(Labelfont);
wtime.setForeground(zicolor);
wtime.setFont(Labelfont);
wbumen.setForeground(zicolor);
wbumen.setFont(Labelfont);
wzhiwu.setForeground(zicolor);
wzhiwu.setFont(Labelfont);
wnewtime.setForeground(zicolor);
wnewtime.setFont(Labelfont);
in_wid.setForeground(zicolor);
in_wid.setFont(Labelfont);
in_wname.setForeground(zicolor);
in_wname.setFont(Labelfont);
in_wtime.setForeground(zicolor);
in_wtime.setFont(Labelfont);
in_wbumen.setForeground(zicolor);
in_wbumen.setFont(Labelfont);
in_wzhiwu.setForeground(zicolor);
in_wzhiwu.setFont(Labelfont);
in_wnewtime.setForeground(zicolor);
in_wnewtime.setFont(Labelfont);
b1_1.addActionListener(new c());
b1_2.addActionListener(new c());
b1_3.addActionListener(new c());
b2_1.addActionListener(new c());
b2_1_1.addActionListener(new c());
b2_1_2.addActionListener(new c());
b2_1_3.addActionListener(new c());
b2_2.addActionListener(new c());
b2_2_1.addActionListener(new c());
b2_2_2.addActionListener(new c());
b2_2_3.addActionListener(new c());
b2_3.addActionListener(new c());
b2_3_1.addActionListener(new c());
b2_3_2.addActionListener(new c());
b2_3_3.addActionListener(new c());
b2_4_1.addActionListener(new c());
b2_4_2.addActionListener(new c());
b2_4_3.addActionListener(new c());
b3_1.addActionListener(new c());
b3_2.addActionListener(new c());
b3_3.addActionListener(new c());
b2_n1_1.addActionListener(new c());
b2_n1_2.addActionListener(new c());
b2_n1_3.addActionListener(new c());
b2_n1_4.addActionListener(new c());
b2_n2_1.addActionListener(new c());
b2_n2_2.addActionListener(new c());
b2_n2_3.addActionListener(new c());
b2_n2_4.addActionListener(new c());
b2_n3_1.addActionListener(new c());
b2_n3_2.addActionListener(new c());
b2_n3_3.addActionListener(new c());
b2_n3_4.addActionListener(new c());
b2_n4_1.addActionListener(new c());
b2_n4_2.addActionListener(new c());
b2_n4_3.addActionListener(new c());
b2_n4_4.addActionListener(new c());
b2_n1_1.addMouseListener(new anniu());
b2_n1_2.addMouseListener(new anniu());
b2_n1_3.addMouseListener(new anniu());
b2_n1_4.addMouseListener(new anniu());
b2_n2_1.addMouseListener(new anniu());
b2_n2_2.addMouseListener(new anniu());
b2_n2_3.addMouseListener(new anniu());
b2_n2_4.addMouseListener(new anniu());
b2_n3_1.addMouseListener(new anniu());
b2_n3_2.addMouseListener(new anniu());
b2_n3_3.addMouseListener(new anniu());
b2_n3_4.addMouseListener(new anniu());
b2_n4_1.addMouseListener(new anniu());
b2_n4_2.addMouseListener(new anniu());
b2_n4_3.addMouseListener(new anniu());
b2_n4_4.addMouseListener(new anniu());
bx_1.addMouseListener(new anniu());
bx_2.addMouseListener(new anniu());
lastyue.addMouseListener(new anniu());
nextyue.addMouseListener(new anniu());
xiugai.addMouseListener(new anniu());
tuichu.addMouseListener(new anniu());
qandao.addMouseListener(new anniu());
qantui.addMouseListener(new anniu());
quxiaoqandao.addMouseListener(new anniu());
tijiaoqandao.addMouseListener(new anniu());
JBx1_11.addActionListener(new JBlist());
JBx1_12.addActionListener(new JBlist());
JBx1_13.addActionListener(new JBlist());
JBx1_21.addActionListener(new JBlist());
JBx1_22.addActionListener(new JBlist());
JBx1_23.addActionListener(new JBlist());
JBx2_11.addActionListener(new JBlist());
JBx2_12.addActionListener(new JBlist());
JBx2_13.addActionListener(new JBlist());
JBx2_21.addActionListener(new JBlist());
JBx2_22.addActionListener(new JBlist());
JBx2_23.addActionListener(new JBlist());
//b1_1.setBorderPainted(false);       //边框
//b1_1.setBackground(Color.GRAY);     //颜色
//b1_1.setContentAreaFilled(false);   //透明
pan1.add(b1_1);
pan1.add(b1_2);
pan1.add(b1_3);
pan1.add(Lwelcome);
pan1.add(Ltime);
pan1.add(qandao);
pan1.add(qantui);
pan1.add(quxiaoqandao);
pan1.add(tijiaoqandao);
pan1.add(qantuitime);
pan1.add(qandaotime);
pan1.add(in_qandaotime);
pan1.add(in_qantuitime);
pan1.add(jishu);
pan1.add(in_jishu);
pan1.add(b_zhoqi);
pan1.add(b_shichang);
pan1.add(b_cdao);
pan1.add(b_zaotui);
pan1.add(l_zhoqi);
pan1.add(l_shichang);
pan1.add(l_cdao);
pan1.add(l_zaotui);
pan1.add(in_b_zhoqi);
pan1.add(in_b_shichang);
pan1.add(in_b_cdao);
pan1.add(in_b_zaotui);
pan1.add(in_l_zhoqi);
pan1.add(in_l_shichang);
pan1.add(in_l_cdao);
pan1.add(in_l_zaotui);
pan2.add(b2_1);
pan2.add(b2_2);
pan2.add(b2_3);
pan2_1.add(b2_1_1);
pan2_1.add(b2_1_2);
pan2_1.add(b2_1_3);
pan2_1.add(b2_n1_1);
pan2_1.add(b2_n1_2);
pan2_1.add(b2_n1_3);
pan2_1.add(b2_n1_4);
pan2_1.add(Lx1);
pan2_1.add(Lx2);
pan2_1.add(JBx1_11);
pan2_1.add(JBx1_12);
pan2_1.add(JBx1_13);
pan2_1.add(JBx1_21);
pan2_1.add(JBx1_22);
pan2_1.add(JBx1_23);
pan2_1.add(JBx2_11);
pan2_1.add(JBx2_12);
pan2_1.add(JBx2_13);
pan2_1.add(JBx2_21);
pan2_1.add(JBx2_22);
pan2_1.add(JBx2_23);
pan2_1.add(dao1);
pan2_1.add(dao2);
pan2_1.add(Lx2_gh);
pan2_1.add(bx_1);
pan2_1.add(bx_2);
pan2_1.add(Tx1);
pan2_2.add(b2_2_1);
pan2_2.add(b2_2_2);
pan2_2.add(b2_2_3);
pan2_2.add(b2_n2_1);
pan2_2.add(b2_n2_2);
pan2_2.add(b2_n2_3);
pan2_2.add(b2_n2_4);
pan2_2.add(lastyue);
pan2_2.add(nextyue);
pan2_2.add(L_x);//,BorderLayout.CENTER
//pan2_2_1.add(pan2_2);
pan2_2_1.setViewportView(pan2_2);
pan2_3.add(b2_3_1);
pan2_3.add(b2_3_2);
pan2_3.add(b2_3_3);
pan2_3.add(b2_n3_1);
pan2_3.add(b2_n3_2);
pan2_3.add(b2_n3_3);
pan2_3.add(b2_n3_4);
pan2_4.add(b2_4_1);
pan2_4.add(b2_4_2);
pan2_4.add(b2_4_3);
pan2_4.add(b2_n4_1);
pan2_4.add(b2_n4_2);
pan2_4.add(b2_n4_3);
pan2_4.add(b2_n4_4);
pan3.add(b3_1);
pan3.add(b3_2);
pan3.add(b3_3);
pan3.add(xiugai);
pan3.add(tuichu);
pan3.add(id);
pan3.add(name);
pan3.add(sex);
pan3.add(year);
pan3.add(work);
pan3.add(newwork);
pan3.add(in_id);
pan3.add(in_name);
pan3.add(in_sex);
pan3.add(in_year);
pan3.add(in_work);
pan3.add(in_newwork);
pan3.add(wid);
pan3.add(wname);
pan3.add(wbumen);
pan3.add(wtime);
pan3.add(wzhiwu);
pan3.add(wnewtime);
pan3.add(in_wid);
pan3.add(in_wname);
pan3.add(in_wtime);
pan3.add(in_wbumen);
pan3.add(in_wzhiwu);
pan3.add(in_wnewtime);
pa.add("a",pan1);
pa.add("b",pan2);
pa.add("b1",pan2_1);
pa.add("b2",pan2_2_1);
pa.add("b3",pan2_3);
pa.add("b4",pan2_4);
pa.add("c",pan3);
jf.add(pa);//BorderLayout.NORTH
pan3.add(Lcaixfen);
pan1.add(L1);
pan2.add(L2);
pan2_1.add(L2_1);
pan2_2.add(L2_2);
pan2_3.add(L2_3);
pan2_4.add(L2_4);
pan3.add(L3);
Timer tmr=new Timer();       //调用Timer类scheduleAtFixedRate方法,继承TimerTask构成时间更新事件
tmr.scheduleAtFixedRate(new cltime(),new Date(),ONE_SECOND);
jf.setBounds(0, 0, Width, Height);
jf.setTitle("supervisory");
logoimage=new ImageIcon("jpg/logo.png").getImage();
jf.setIconImage(logoimage);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setVisible(true);
jf.setExtendedState(Frame.MAXIMIZED_BOTH);  //初始窗口最大化
}
public void V(){
	jf.setVisible(true);
}
class cltime extends TimerTask{
	public cltime(){
	}
	public void run() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Str_time=df.format(Calendar.getInstance().getTime());
Ltime.setText("当前时间："+Str_time);
	}
}
class c implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		String a=e.getActionCommand();
		if(a.equals("首页")){
card.show(pa,"a");
}else if(a.equals("管理")&&account.equals("1")){
card.show(pa,"b1");
}else if(a.equals("我的")){
card.show(pa,"c");
}else if(a.equals("管理")){
card.show(pa,"b");
}else if(a.equals("周期更新")){
card.show(pa,"b1");
}else if(a.equals("员工信息")){
card.show(pa,"b2");
}else if(a.equals("职务调动")){
card.show(pa,"b3");
}else if(a.equals("请假审批")){
card.show(pa,"b4");
		}
	}
	
}
class anniu implements MouseListener{
	Color a=xiugai.getBackground();
	@SuppressWarnings("deprecation")
public void mouseClicked(MouseEvent e) {
	if(((JButton)e.getSource()).getText().equals("退出")){    //((JButton)e.getSource()).getText()获取按钮文本
System.exit(0);
}else if(((JButton)e.getSource()).getText().equals("修改")){
	jf.setVisible(false);
	new zhuce(n_id,account);
}else if(((JButton)e.getSource()).getText().equals("签到")&&n_qandao.equals("。。。暂未签到。。。")){
	n_qandao=Str_time;
	Date date1=new Date();
	int ay=date1.getYear();
	int am=date1.getMonth();
	int ad=date1.getDate();
	in_qandaotime.setText(n_qandao);
	int s1=(ay+1900)*10000+(am+1)*100+ad;
	String s2=n_qandao;
	String s3=n_id;
	homesql.insertAttendance(s1, s2,s3);
}else if(((JButton)e.getSource()).getText().equals("签退")&&n_qantui.equals("。。。暂未签退。。。")&&!n_qandao.equals("。。。暂未签到。。。")){
Integer a1,a2,a3;
String a11=n_qandao.substring(8,10);
a1=Integer.parseInt(a11);
String a12=n_qandao.substring(11,13);
a2=Integer.parseInt(a12);
String a13=n_qandao.substring(14,16);
a3=Integer.parseInt(a13);
time1=((a1*24)+a2)*60+a3;
n_qantui=Str_time;
Date date2=new Date();
int b1=date2.getDate();
int b2=date2.getHours();
int b3=date2.getMinutes();
time2=((b1*24)+b2)*60+b3;
Htime=(time2-time1)/60;
Mtime=(time2-time1)%60;
in_jishu.setText(Htime+" 小时 "+Mtime+" 分钟");
in_qantuitime.setText(n_qantui);              //显示时间在签退
homesql.qantui(n_qantui,Htime,Mtime,n_id);    //保存签退时间，时长到数据库
if(homesql.boolupdate){
	homesql.showz(n_b_zhoqi1,n_b_zhoqi2,n_id);
	String T=homesql.zongx+"小时"+homesql.zongf+"分钟";
in_b_shichang.setText(T);
homesql.updateshicheng(homesql.zongx,homesql.zongf,n_id);
n_b_cdao=homesql.sumcd+" 次";
n_b_zaotui=homesql.sumzt+" 次";
	in_b_cdao.setText(n_b_cdao);
	in_b_zaotui.setText(n_b_zaotui);
   JOptionPane.showMessageDialog(null,"签到成功","提示！",1);
}else{
   JOptionPane.showMessageDialog(null,"签到失败！","错误提示！",1);
    }
}else if(((JButton)e.getSource()).getText().equals("取消本次签到")){
n_qandao="。。。暂未签到。。。";
n_qantui="。。。暂未签退。。。";
Htime=0;
Mtime=0;
in_qandaotime.setText(n_qandao);
in_qantuitime.setText(n_qantui);
in_jishu.setText(Htime+" 小时 "+Mtime+" 分钟");
}else if(((JButton)e.getSource()).getText().equals("退出本次签到")){
n_qandao="。。。暂未签到。。。";
n_qantui="。。。暂未签退。。。";
Htime=0;
Mtime=0;
in_qandaotime.setText(n_qandao);
in_qantuitime.setText(n_qantui);
in_jishu.setText(Htime+" 小时 "+Mtime+" 分钟");
    jf.setVisible(false);
    new j2();
}else if(((JButton)e.getSource()).getText().equals("全部更新")){
Date date1=new Date();
int ay=date1.getYear();
int am=date1.getMonth();
int ad=date1.getDate();
int s1=(ay+1900)*10000+(am+1)*100+ad;
if(zaoqi1_1>=zaoqi1_2||s1>zaoqi1_1){
	JOptionPane.showMessageDialog(null,"时间出错！","提示！",1);
}else if(homesql.insertSalary(zaoqi1_1, zaoqi1_2)){
	JOptionPane.showMessageDialog(null,"所有周期更新成功","提示！",1);
}else{
	JOptionPane.showMessageDialog(null,"更新失败","提示！",1);
	}
}else if(((JButton)e.getSource()).getText().equals("指定更新")){
String daqun_id=Tx1.getText();
Date date1=new Date();
int ay=date1.getYear();
int am=date1.getMonth();
int ad=date1.getDate();
int s1=(ay+1900)*10000+(am+1)*100+ad;
if(zaoqi2_1>=zaoqi2_2||s1>zaoqi2_1){
	JOptionPane.showMessageDialog(null,"时间出错！","提示！",1);
}else if(homesql.insertSalary(daqun_id,zaoqi2_1, zaoqi2_2)){
	if(daqun_id.matches("[0-9]+")){
daqun_id=daqun_id+" "+homesql.sql_name.trim();
}else{
	daqun_id=homesql.sql_id.trim()+" "+daqun_id;
}
JOptionPane.showMessageDialog(null,daqun_id+" 周期更新成功","提示！",1);
}else{
	JOptionPane.showMessageDialog(null,"更新失败","提示！",1);
	}
}else if(((JButton)e.getSource()).getText().equals("上一页")){
if(sum_x>1){
	sum_x--;
	for(int i=0;i<14;i++){
		if(i==0){
		bb[i][0]="工号";bb[i][1]="姓名";bb[i][2]="开始时间";bb[i][3]="结束时间";bb[i][4]="本周期总时长";
		}else{
		    for(int j=0;j<x_1;j++){
	    	    bb[i][j]=b[(sum_x-1)*13+i-1][j];
	        }
		}
	}
	pan2_2.updateUI();
	pan2_2.repaint();
}else{
	JOptionPane.showMessageDialog(null,"当前是首页","提示！",1);
	}
}else if(((JButton)e.getSource()).getText().equals("下一页")){
int ii;
if(x_2>13*sum_x){
	sum_x++;
	if(x_2>13*sum_x)
	ii=14;
	else{
		ii=x_2-13*(sum_x-1)+1;
	}
	for(int i=0;i<14;i++){
		for(int j=0;j<x_1;j++){
			bb[i][j]="";
	}
}
for(int i=0;i<ii;i++){
    if(i==0){
    bb[i][0]="工号";bb[i][1]="姓名";bb[i][2]="开始时间";bb[i][3]="结束时间";bb[i][4]="本周期总时长";
	    }else{
	        for(int j=0;j<x_1;j++){
    	        bb[i][j]=b[(sum_x-1)*13+i-1][j];
            }
	    }
    }
    pan2_2.updateUI();
    pan2_2.repaint();
}else{
	JOptionPane.showMessageDialog(null,"这是最后一页","提示！",1);
		}
	}
}
public void mousePressed(MouseEvent e) {}
public void mouseReleased(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {
	if(((JButton)e.getSource()).getText().equals("退出")){
	tuichu.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("修改")){
	xiugai.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("签到")&&n_qandao.equals("。。。暂未签到。。。")){
	qandao.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("签退")&&n_qantui.equals("。。。暂未签退。。。")&&!n_qandao.equals("。。。暂未签到。。。")){
	qantui.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("取消本次签到")){
	quxiaoqandao.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("退出本次签到")){
	tijiaoqandao.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("周期更新")){
	b2_n1_1.setBackground(new Color(0x99,0xff,0xff));
	b2_n2_1.setBackground(new Color(0x99,0xff,0xff));
	b2_n3_1.setBackground(new Color(0x99,0xff,0xff));
	b2_n4_1.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("员工信息")){
	b2_n1_2.setBackground(new Color(0x99,0xff,0xff));
	b2_n2_2.setBackground(new Color(0x99,0xff,0xff));
	b2_n3_2.setBackground(new Color(0x99,0xff,0xff));
	b2_n4_2.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("职务调动")){
	b2_n1_3.setBackground(new Color(0x99,0xff,0xff));
	b2_n2_3.setBackground(new Color(0x99,0xff,0xff));
	b2_n3_3.setBackground(new Color(0x99,0xff,0xff));
	b2_n4_3.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("请假审批")){
	b2_n1_4.setBackground(new Color(0x99,0xff,0xff));
	b2_n2_4.setBackground(new Color(0x99,0xff,0xff));
	b2_n3_4.setBackground(new Color(0x99,0xff,0xff));
	b2_n4_4.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("全部更新")){
	bx_1.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("指定更新")){
	bx_2.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("上一页")){
	lastyue.setBackground(new Color(0x99,0xff,0xff));
}else if(((JButton)e.getSource()).getText().equals("下一页")){
		nextyue.setBackground(new Color(0x99,0xff,0xff));
	}
}
public void mouseExited(MouseEvent e) {
    if(((JButton)e.getSource()).getText().equals("退出")){
	tuichu.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("修改")){
	xiugai.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("签到")){
	qandao.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("签退")){
	qantui.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("取消本次签到")){
	quxiaoqandao.setBackground(a);
}
else if(((JButton)e.getSource()).getText().equals("退出本次签到")){
	tijiaoqandao.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("周期更新")){
	b2_n1_1.setBackground(a);
	b2_n2_1.setBackground(a);
	b2_n3_1.setBackground(a);
	b2_n4_1.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("员工信息")){
	b2_n1_2.setBackground(a);
	b2_n2_2.setBackground(a);
	b2_n3_2.setBackground(a);
	b2_n4_2.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("职务调动")){
	b2_n1_3.setBackground(a);
	b2_n2_3.setBackground(a);
	b2_n3_3.setBackground(a);
	b2_n4_3.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("请假审批")){
	b2_n1_4.setBackground(a);
	b2_n2_4.setBackground(a);
	b2_n3_4.setBackground(a);
	b2_n4_4.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("全部更新")){
	bx_1.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("指定更新")){
	bx_2.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("上一页")){
	lastyue.setBackground(a);
}else if(((JButton)e.getSource()).getText().equals("下一页")){
			nextyue.setBackground(a);
		}
	}
	
	
}
class JBlist implements ActionListener{          //选择框
		public void actionPerformed(ActionEvent e) {
			objy1_1=JBx1_11.getSelectedItem();objy1_2=JBx1_21.getSelectedItem();objy2_1=JBx2_11.getSelectedItem();objy2_2=JBx2_21.getSelectedItem();
			objm1_1=JBx1_12.getSelectedItem();objm1_2=JBx1_22.getSelectedItem();objm2_1=JBx2_12.getSelectedItem();objm2_2=JBx2_22.getSelectedItem();
			objd1_1=JBx1_13.getSelectedItem();objd1_2=JBx1_23.getSelectedItem();objd2_1=JBx2_13.getSelectedItem();objd2_2=JBx2_23.getSelectedItem();
			int x1_11=Integer.parseInt(((String) objy1_1).substring(0, 4)), x2_11=Integer.parseInt(((String) objy2_1).substring(0, 4)),x1_12=Integer.parseInt(((String) objm1_1).substring(0, 2)),x2_12=Integer.parseInt(((String) objm2_1).substring(0, 2)),x1_13=Integer.parseInt(((String) objd1_1).substring(0, 2)),x2_13=Integer.parseInt(((String) objd2_1).substring(0, 2));
			int x1_21=Integer.parseInt(((String) objy1_2).substring(0, 4)), x2_21=Integer.parseInt(((String) objy2_2).substring(0, 4)),x1_22=Integer.parseInt(((String) objm1_2).substring(0, 2)),x2_22=Integer.parseInt(((String) objm2_2).substring(0, 2)),x1_23=Integer.parseInt(((String) objd1_2).substring(0, 2)),x2_23=Integer.parseInt(((String) objd2_2).substring(0, 2));
			zaoqi1_1=((x1_11*100)+x1_12)*100+x1_13;zaoqi2_1=((x2_11*100)+x2_12)*100+x2_13;
			zaoqi1_2=((x1_21*100)+x1_22)*100+x1_23;zaoqi2_2=((x2_21*100)+x2_22)*100+x2_23;
		}
		
	}

}
