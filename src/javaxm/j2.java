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
	JLabel L1,L2,L3,label;            //��ǩ
	TextField T1;                    //�ı���
	JPasswordField T2;                //�����
	JButton b1,b2;                   //����
	JComboBox<?> JB;
	ImageIcon imageicon=new ImageIcon("jpg\\j2.jpg"),logo=new ImageIcon("jpg\\logo.png");
	Image  logoimage=logo.getImage();
	java_sql q=new java_sql();
	JFrame d=new JFrame();               //����JFrame���
	Container c=d.getContentPane();             //Container��JFrame����Ҫ����,��ȡ���㴰���������
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public j2(){
		q.show("000");
		T1_name=q.sql_name;
		T2_pass=q.sql_pass;
		q.deletesj();
				
		L1=new JLabel("�˺ţ�");
		L1.setBounds(width/2-80,40,40,30);
		L1.setForeground(Color.WHITE);
		c.add(L1);
		
		T1=new TextField(T1_name);
		T1.setBounds(width/2-40,45,100,20);
		T1.setBackground(Color.lightGray);
		c.add(T1);
		T1.addTextListener(new T1handler());
		
		L2=new JLabel("���룺");
		L2.setBounds(width/2-80,80,60,30);
		L2.setForeground(Color.WHITE);
		c.add(L2);
		
		T2=new JPasswordField(T2_pass);
		T2.setBounds(width/2-40,85, 100,20);
		T2.setBackground(Color.lightGray);
		c.add(T2);
		
		b1=new JButton("��½");
		//b1.addMouseListener(new MouseAdapter());
		b1.setBounds(width/2-80,160,60 , 30);
		b1.setBorder(BorderFactory.createRaisedBevelBorder());   //ͻ��
		b1.addMouseListener(new handler());
		b1.addActionListener(new handler());
		c.add(b1);
		
		
		b2=new JButton("ע��");
		b2.setBounds(width/2,160,60 , 30);
		b2.setBorder(BorderFactory.createRaisedBevelBorder());
		//b2.setBorder(BorderFactory.createLoweredBevelBorder());    //����
		c.add(b2);
		b2.addMouseListener(new b2handler());
		
		L3=new JLabel("��½����");
		L3.setBounds(width/2-105,120,80,30);
		L3.setForeground(Color.WHITE);
		c.add(L3);
		String[] pet={"�û�","����Ա"};
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
		
		d.setResizable(false);      //���ڴ�С�ɲ��ɸı�
		d.setTitle("supervisory");           //���ڱ���
		d.setIconImage(logoimage);           //��ȡͼ��
		c.setBackground(Color.WHITE);      //������ɫ
		d.setBounds(Width/2-width/2, Height/2-height/2, width, height);  //����λ�����С
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //�رմ����������
		d.setVisible(true);                //�����Ƿ�ɼ�

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
			if(q.sql_sex.equals("Ů")){
			    s=q.sql_name+"Ůʿ  ��ӭ����";
			}else{
				s=q.sql_name+"����  ��ӭ����";
			}
			if(T1_name.equals("����")||T1_name.equals(""));
			else{
				if(T){
			      // JOptionPane.showMessageDialog(null,s,"��Ϣ��ʾ��",1);
			       if(obj.equals("�û�")){
			    	   JOptionPane.showMessageDialog(null,s,"��Ϣ��ʾ��",1);
			    	   d.setVisible(false);
			    	   new Home().Home1(T1_name,"0");
			       }
			       else if(sqlobj.equals("����Ա")&&obj.equals("����Ա")) {
			    	   JOptionPane.showMessageDialog(null,s+"\n���Թ���Ա��ݵ�¼","��Ϣ��ʾ��",1);
			    	   d.setVisible(false);
			    	   new Home().Home1(T1_name,"1");
			       }else{
			    	   JOptionPane.showMessageDialog(null,"�㲻�ǹ���Ա������֤","��Ϣ��ʾ��",1);
			       }
				}else if(q.sql_name.equals("")){
					JOptionPane.showMessageDialog(null,"û�и��û���","��Ϣ��ʾ��",1);
				}else
					JOptionPane.showMessageDialog(null,"�������","��Ϣ��ʾ��",1);
			}
			q.deletesj();
		}
		public void mouseClicked(MouseEvent e) {    //���������²��ͷţ�
        }
		public void mousePressed(MouseEvent e) {    //����ʱ
		}
		public void mouseReleased(MouseEvent e) {   //�ͷ�ʱ
		}
		public void mouseEntered(MouseEvent e) {    //����ʱ
			b1.setBackground(Color.CYAN);
			b1.setMargin(new Insets(100,100,width,height));
		}
		public void mouseExited(MouseEvent e) {     //�뿪ʱ
			Color a=b2.getBackground();
			b1.setBackground(a);//ColorUIResource[r=238,g=238,b=238]
		}
	}
	class b2handler implements MouseListener{       //ע�ᰴť
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
	class T1handler implements TextListener{        //�ı���ʵʱ�������
		public void textValueChanged(TextEvent e) {
			//System.out.println("af");
			//T1_name=T1.getText();
		}
	}
	class JBlist implements ActionListener{          //ѡ���
		public void actionPerformed(ActionEvent e) {
			obj=JB.getSelectedItem();
		}
		
	}

}

