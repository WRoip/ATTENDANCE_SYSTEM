package javaxm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class zhuce{
	Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
	int Width=size.width,Height=size.height;
	Font Labelfont=new Font("����",Font.BOLD,18);
	Font Textfont=new Font("����",Font.PLAIN,22);
	JLabel L1,L2,L3,L4,La,Lb,Lc,Ld,Le,LT1;
	TextField T1,T2,T3;
	JPasswordField T4,T5;
	JButton b1,b2,b3;
	ImageIcon  imageIcon=new ImageIcon("jpg\\3.jpg");
	Image  logoimage=new ImageIcon("jpg/logo.png").getImage();
	JFrame jf;
	Container c;
	String zce_id=null,zce_name=null,zce_sex=null,zce_year=null,zce_mima1=null,zce_mima2=null,account;
	public zhuce(){
		jf=new JFrame();
		c=jf.getContentPane();
		jf.setUndecorated(true);     //�Ƿ�رմ��ڱ߿򣬷��ڼ������֮ǰ
		//this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);  
		
		b1=new JButton("ע��");
		b2=new JButton("����");
		L1=new JLabel(imageIcon);
		L2=new JLabel(imageIcon);
		L3=new JLabel(imageIcon);
		L4=new JLabel(imageIcon);
		La=new JLabel("�ǼǺţ�",JLabel.RIGHT);
		Lb=new JLabel("������",JLabel.RIGHT);
		Lc=new JLabel("�Ա�",JLabel.RIGHT);
		Ld=new JLabel("��½���룺",JLabel.RIGHT);
		Le=new JLabel("ȷ�����룺",JLabel.RIGHT);
		T1=new TextField();
		T2=new TextField();
		T3=new TextField();
		T4=new JPasswordField();
		T5=new JPasswordField();
		b1.setBounds(Width/2-45, Height/2+75,60,30);
		b2.setBounds(Width/2+45, Height/2+75,60,30);
		b1.setBorder(BorderFactory.createRaisedBevelBorder());
		b2.setBorder(BorderFactory.createRaisedBevelBorder());
		L1.setBounds(0,-3,900,562);
		L2.setBounds(900, 0,900,562);
		L3.setBounds(0,557,900,562);
		L4.setBounds(900,559,900,562);
		La.setBounds(Width/2-130,Height/2-130,120,30);
		La.setFont(Labelfont);
		La.setForeground(Color.WHITE);
		Lb.setBounds(Width/2-130,Height/2-90,120,30);
		Lb.setFont(Labelfont);
		Lb.setForeground(Color.WHITE);
		Lc.setBounds(Width/2-130,Height/2-50,120,30);
		Lc.setFont(Labelfont);
		Lc.setForeground(Color.WHITE);
		Ld.setBounds(Width/2-130,Height/2-10,120,30);
		Ld.setFont(Labelfont);
		Ld.setForeground(Color.WHITE);
		Le.setBounds(Width/2-130,Height/2+30,120,30);
		Le.setFont(Labelfont);
		Le.setForeground(Color.WHITE);
		T1.setBounds(Width/2,Height/2-130,150,30);
		T1.setFont(Textfont);
		T2.setBounds(Width/2,Height/2-90,150,30);
		T2.setFont(Textfont);
		T3.setBounds(Width/2,Height/2-50,150,30);
		T3.setFont(Textfont);
		T4.setBounds(Width/2,Height/2-10,150,30);
		T5.setBounds(Width/2,Height/2+30,150,30);
		//L5.setB
		
		c.setLayout(null);
		c.add(b1);
		c.add(La);
		c.add(Lb);
		c.add(Lc);
		c.add(Ld);
		c.add(Le);
		c.add(T1);
		c.add(T2);
		c.add(T3);
		c.add(T4);
		c.add(T5);
		
		c.add(b2);
		jf.add(L3);
		jf.add(L4);
		jf.add(L1);
		jf.add(L2);
		//jf.add(L2);
		//jf.validate();
		
		((JPanel) c).setOpaque(false);
		jf.setTitle ("ע��");
		jf.setBounds (0, 0,Width,Height);
		jf.setLayout(null);
		jf.setIconImage(logoimage);
		b1.addMouseListener( new b1mouse());
		b2.addMouseListener(new b1mouse());
		jf.setVisible (true);
		
		  
		  
	}
	public zhuce(String str1,String str2){
		zce_id=str1;
		account=str2;
		jf=new JFrame();
		c=jf.getContentPane();
		jf.setUndecorated(true);     //�Ƿ�رմ��ڱ߿򣬷��ڼ������֮ǰ
		//this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);  
		
		b1=new JButton("�޸�");
		b2=new JButton("ȡ��");
		L1=new JLabel(imageIcon);
		L2=new JLabel(imageIcon);
		L3=new JLabel(imageIcon);
		L4=new JLabel(imageIcon);
		La=new JLabel("�޸�������",JLabel.RIGHT);
		Lb=new JLabel("�޸��Ա�",JLabel.RIGHT);
		Lc=new JLabel("�޸����䣺",JLabel.RIGHT);
		Ld=new JLabel("�ɵ����룺",JLabel.RIGHT);
		Le=new JLabel("�µ����룺",JLabel.RIGHT);
		T1=new TextField();
		T2=new TextField();
		T3=new TextField();
		T4=new JPasswordField();
		T5=new JPasswordField();
		b1.setBounds(Width/2-45, Height/2+75,60,30);
		b2.setBounds(Width/2+45, Height/2+75,60,30);
		b1.setBorder(BorderFactory.createRaisedBevelBorder());
		b2.setBorder(BorderFactory.createRaisedBevelBorder());
		L1.setBounds(0,-3,900,562);
		L2.setBounds(900, 0,900,562);
		L3.setBounds(0,557,900,562);
		L4.setBounds(900,559,900,562);
		La.setBounds(Width/2-130,Height/2-130,120,30);
		La.setFont(Labelfont);
		La.setForeground(Color.WHITE);
		Lb.setBounds(Width/2-130,Height/2-90,120,30);
		Lb.setFont(Labelfont);
		Lb.setForeground(Color.WHITE);
		Lc.setBounds(Width/2-130,Height/2-50,120,30);
		Lc.setFont(Labelfont);
		Lc.setForeground(Color.WHITE);
		Ld.setBounds(Width/2-130,Height/2-10,120,30);
		Ld.setFont(Labelfont);
		Ld.setForeground(Color.WHITE);
		Le.setBounds(Width/2-130,Height/2+30,120,30);
		Le.setFont(Labelfont);
		Le.setForeground(Color.WHITE);
		T1.setBounds(Width/2,Height/2-130,150,30);
		T1.setFont(Textfont);
		T2.setBounds(Width/2,Height/2-90,150,30);
		T2.setFont(Textfont);
		T3.setBounds(Width/2,Height/2-50,150,30);
		T3.setFont(Textfont);
		T4.setBounds(Width/2,Height/2-10,150,30);
		T5.setBounds(Width/2,Height/2+30,150,30);
		
		c.setLayout(null);
		c.add(b1);
		c.add(La);
		c.add(Lb);
		c.add(Lc);
		c.add(Ld);
		c.add(Le);
		c.add(T1);
		c.add(T2);
		c.add(T3);
		c.add(T4);
		c.add(T5);
		
		c.add(b2);
		jf.add(L3);
		jf.add(L4);
		jf.add(L1);
		jf.add(L2);
		
		((JPanel) c).setOpaque(false);
		jf.setTitle ("�޸�");
		jf.setBounds (0, 0,Width,Height);
		jf.setLayout(null);
		jf.setIconImage(logoimage);
		b1.addMouseListener( new b1mouse());
		b2.addMouseListener(new b1mouse());
		jf.setVisible (true);
		
		  
		  
	}
	class b1mouse implements MouseListener{
		@SuppressWarnings("deprecation")
		public void mouseClicked(MouseEvent e) {
			if(((JButton)e.getSource()).getText().equals("ע��")){
			zce_id=T1.getText();
			zce_name=T2.getText();
			zce_sex=T3.getText();
			zce_mima1=T4.getText();
			zce_mima2=T5.getText();
			boolean blzce_id=zce_id.matches("[0-9]+");
			
			if(zce_id.equals("")||zce_name.equals("")||zce_sex.equals("")||zce_mima1.equals("")||zce_mima2.equals("")){
				JOptionPane.showMessageDialog(null,"����һ������Ϊ�գ����ܿղ���","������ʾ��",1);
			}else{
				if(!zce_mima1.equals(zce_mima2))
					JOptionPane.showMessageDialog(null,"�����������벻һ�£�","������ʾ��",1);
				else if(blzce_id==false)
					JOptionPane.showMessageDialog(null,"�ǼǺ��ɴ����ֹ��ɣ�","������ʾ��",1);
				else if(!zce_sex.equals("��")&&!zce_sex.equals("Ů"))
					JOptionPane.showMessageDialog(null,"�Ա�Ϊ���л�Ů��","������ʾ��",1);
                else{
                	java_sql sql=new java_sql();
                	sql.insert(zce_id, zce_name, zce_sex, zce_mima1);
					jf.setVisible(false);
					j2 p=new j2();
					p.setj2();
				}
			}
			}
			if(((JButton)e.getSource()).getText().equals("����")){
				jf.setVisible(false);
				new j2();
			}
			if(((JButton)e.getSource()).getText().equals("�޸�")){
				java_sql sql=new java_sql();
				zce_name=T1.getText();
				zce_sex=T2.getText();
				zce_year=T3.getText();
				zce_mima1=T4.getText();
				zce_mima2=T5.getText();
				boolean blzce_id=zce_year.matches("[0-9]+");
				sql.show(zce_id);
				if(zce_name.equals("")||zce_sex.equals("")||zce_year.equals("")||zce_mima1.equals("")||zce_mima2.equals("")){
					JOptionPane.showMessageDialog(null,"δ���޸ģ�������ȡ����","������ʾ��",1);
				}else{
					if(!zce_mima1.equals(sql.sql_pass.trim())){
						JOptionPane.showMessageDialog(null,"�������","������ʾ��",1);
					}else if(blzce_id==false&&zce_year.length()>=3){
						JOptionPane.showMessageDialog(null,"�����ʽ����","������ʾ��",1);
					}else if(!zce_sex.equals("��")&&!zce_sex.equals("Ů")){
						JOptionPane.showMessageDialog(null,"�Ա�Ϊ���л�Ů��","������ʾ��",1);
					}else{ 
						sql.update(zce_name, zce_sex, zce_year, zce_mima1, zce_id);
						if(sql.boolupdate){
	                	   JOptionPane.showMessageDialog(null,"�޸ĳɹ�","������ʾ��",1);
	                	   jf.setVisible(false);
	    				   Home p= new Home();
	    				   p.Home1(zce_id,p.account);
	    				   p.card.show(p.pa,"c");
				        }else{
						   JOptionPane.showMessageDialog(null,"��������ԭ���޸�ʧ�ܣ�","������ʾ��",1);
				        }
					}
				}
			}
			if(((JButton)e.getSource()).getText().equals("ȡ��")){
				jf.setVisible(false);
				Home p= new Home();
				p.Home1(zce_id,account);
				p.card.show(p.pa,"c");
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		Color a=b1.getBackground();
		public void mouseEntered(MouseEvent e) {
			if(((JButton)e.getSource()).getText().equals("ע��")){
				b1.setBackground(new Color(0x99,0xff,0xff));
			}
			if(((JButton)e.getSource()).getText().equals("����")){
				b2.setBackground(new Color(0x99,0xff,0xff));
			}
			if(((JButton)e.getSource()).getText().equals("�޸�")){
				b1.setBackground(new Color(0x99,0xff,0xff));
			}
			if(((JButton)e.getSource()).getText().equals("ȡ��")){
				b2.setBackground(new Color(0x99,0xff,0xff));
			}
		}
		public void mouseExited(MouseEvent e) {
            if(((JButton)e.getSource()).getText().equals("ע��")){
            	b1.setBackground(a);
			}
			if(((JButton)e.getSource()).getText().equals("����")){
				b2.setBackground(a);
			}
			if(((JButton)e.getSource()).getText().equals("�޸�")){
				b1.setBackground(a);
			}
			if(((JButton)e.getSource()).getText().equals("ȡ��")){
				b2.setBackground(a);
			}
		}
	}
	class wind implements WindowListener{
		public void windowOpened(WindowEvent e) {}    //���ڱ���ȫ����ʱ����
		public void windowClosing(WindowEvent e) {   //���ڵĹرհ�ť������ʱ����
			j2 p=new j2();
			p.setj2();
		}
		public void windowClosed(WindowEvent e) {}   //������ȫ�ر�ʱ����
		public void windowIconified(WindowEvent e) {}   //���ڱ���С��ʱ����
		public void windowDeiconified(WindowEvent e) {}//������С����ԭʱ����
		public void windowActivated(WindowEvent e) {}    //���ڱ���ȫ����ʱ������
		public void windowDeactivated(WindowEvent e) {}   //����ʧȥ����ʱ����
		
	}
}
