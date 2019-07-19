package javaxm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class j2{
	int width=300,height=300;
	Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
	int Width=size.width,Height=size.height;
	String T1_name,T2_pass,objname,sqlobj;
	Object obj;
	JLabel L1,L2,L3,label;            //标签
	TextField T1;                    //文本框
	JPasswordField T2;                //密码框
	JButton b1,b2;                   //按键
	JComboBox<?> JB;
	ImageIcon imageicon=new ImageIcon("jpg\\j2.jpg"),logo=new ImageIcon("jpg\\logo.png");
	Image  logoimage=logo.getImage();
	java_sql q=new java_sql();
	JFrame d=new JFrame();               //创建JFrame框架
	Container c=d.getContentPane();             //Container是JFrame的主要容器,获取顶层窗口内容面板
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public j2(){
		q.show("000");
		T1_name=q.sql_name;
		T2_pass=q.sql_pass;
		q.deletesj();
				
		L1=new JLabel("账号：");
		L1.setBounds(width/2-80,40,40,30);
		L1.setForeground(Color.WHITE);
		c.add(L1);
		
		T1=new TextField(T1_name);
		T1.setBounds(width/2-40,45,100,20);
		T1.setBackground(Color.lightGray);
		c.add(T1);
		T1.addTextListener(new T1handler());
		
		L2=new JLabel("密码：");
		L2.setBounds(width/2-80,80,60,30);
		L2.setForeground(Color.WHITE);
		c.add(L2);
		
		T2=new JPasswordField(T2_pass);
		T2.setBounds(width/2-40,85, 100,20);
		T2.setBackground(Color.lightGray);
		c.add(T2);
		
		b1=new JButton("登陆");
		//b1.addMouseListener(new MouseAdapter());
		b1.setBounds(width/2-80,160,60 , 30);
		b1.setBorder(BorderFactory.createRaisedBevelBorder());   //突出
		b1.addMouseListener(new handler());
		b1.addActionListener(new handler());
		c.add(b1);
		
		
		b2=new JButton("注册");
		b2.setBounds(width/2,160,60 , 30);
		b2.setBorder(BorderFactory.createRaisedBevelBorder());
		//b2.setBorder(BorderFactory.createLoweredBevelBorder());    //凹入
		c.add(b2);
		b2.addMouseListener(new b2handler());
		
		L3=new JLabel("登陆对象：");
		L3.setBounds(width/2-105,120,80,30);
		L3.setForeground(Color.WHITE);
		c.add(L3);
		String[] pet={"用户","管理员"};
		JB=new JComboBox(pet);
		JB.addActionListener(new JBlist());
		JB.setSelectedIndex(0);
		JB.setBounds(width/2-40,125,100,20);
		JB.setBackground(Color.lightGray);
		JB.setEditable(false);
		JB.setEnabled(true);
		c.add(JB);
		
		c.setLayout(null);
		
		label=new JLabel(imageicon);
		label.setBounds(0, 0, width, height);
		d.add(label);
		
		d.setResizable(false);      //窗口大小可不可改变
		d.setTitle("supervisory");           //窗口标题
		d.setIconImage(logoimage);           //获取图标
		c.setBackground(Color.WHITE);      //窗口颜色
		d.setBounds(Width/2-width/2, Height/2-height/2, width, height);  //窗口位置与大小
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //关闭窗口提出进程
		d.setVisible(true);                //窗口是否可见

	}
	public void setj2(){
		d.setVisible(true);   
	}
	class handler implements ActionListener, MouseListener{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e){
			String s;
			T1_name=T1.getText();
			T2_pass=T2.getText();
			boolean T=q.show1(T1_name, T2_pass);
			q.showname(T1_name);
			sqlobj=q.sql_obj;
			if(q.sql_sex.equals("女")){
			    s=q.sql_name+"女士  欢迎您！";
			}else{
				s=q.sql_name+"先生  欢迎您！";
			}
			if(T1_name.equals("姓名")||T1_name.equals(""));
			else{
				if(T){
			      // JOptionPane.showMessageDialog(null,s,"消息提示！",1);
			       if(obj.equals("用户")){
			    	   JOptionPane.showMessageDialog(null,s,"消息提示！",1);
			    	   d.setVisible(false);
			    	   new Home().Home1(T1_name,"0");
			       }
			       else if(sqlobj.equals("管理员")&&obj.equals("管理员")) {
			    	   JOptionPane.showMessageDialog(null,s+"\n你以管理员身份登录","消息提示！",1);
			    	   d.setVisible(false);
			    	   new Home().Home1(T1_name,"1");
			       }else{
			    	   JOptionPane.showMessageDialog(null,"你不是管理员！请认证","消息提示！",1);
			       }
				}else if(q.sql_name.equals("")){
					JOptionPane.showMessageDialog(null,"没有该用户！","消息提示！",1);
				}else
					JOptionPane.showMessageDialog(null,"密码错误！","消息提示！",1);
			}
			q.deletesj();
		}
		public void mouseClicked(MouseEvent e) {    //单击（按下并释放）
        }
		public void mousePressed(MouseEvent e) {    //按下时
		}
		public void mouseReleased(MouseEvent e) {   //释放时
		}
		public void mouseEntered(MouseEvent e) {    //进入时
			b1.setBackground(Color.CYAN);
			b1.setMargin(new Insets(100,100,width,height));
		}
		public void mouseExited(MouseEvent e) {     //离开时
			Color a=b2.getBackground();
			b1.setBackground(a);//ColorUIResource[r=238,g=238,b=238]
		}
	}
	class b2handler implements MouseListener{       //注册按钮
		public void mouseClicked(MouseEvent e) {
			d.setVisible(false);
			new zhuce();
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {
			b2.setBackground(Color.CYAN);
		}
		public void mouseExited(MouseEvent e) {
			Color a=b1.getBackground();
			//System.out.println(b);
			b2.setBackground(a);
		}
		
	}
	class T1handler implements TextListener{        //文本框实时输入更新
		public void textValueChanged(TextEvent e) {
			//System.out.println("af");
			//T1_name=T1.getText();
		}
	}
	class JBlist implements ActionListener{          //选择框
		public void actionPerformed(ActionEvent e) {
			obj=JB.getSelectedItem();
		}
		
	}

}

