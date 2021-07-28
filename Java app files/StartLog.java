import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.rmi.*;
class StartLog implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	JTextField t1,t3;
	JPasswordField t2;
	String s;
	char c1[]=new char[]{};
	char c2[]=new char[]{'m','i','r','d','a','d'};
	MyRemote service;
	
	public static void main(String args[])
	{
		StartLog s = new StartLog();
	}
	
  public StartLog()
  {

    f=new JFrame("StartLog");
	Container c= f.getContentPane();
	BoxLayout bbb = new BoxLayout(c,BoxLayout.Y_AXIS);
	c.setLayout(bbb);
	
	Box boo1 = Box.createHorizontalBox();
	boo1.add(Box.createHorizontalStrut(80));
	Box bo1 = Box.createVerticalBox(); 
	
	bo1.add(Box.createVerticalStrut(60)); 
	l3=new JLabel("ENTER ADMIN NAME",JLabel.LEFT);
	l3.setFont(new Font("Helvetica",Font.BOLD,25));
	l3.setForeground(new Color(0,0,255));
	bo1.add(l3);
	
	bo1.add(Box.createVerticalStrut(60));
	l4=new JLabel("ENTER THE PASSWORD",JLabel.RIGHT);
	l4.setFont(new Font("Helvetica",Font.BOLD,25));
	l4.setForeground(new Color(0,0,255));
	bo1.add(l4);
	
	bo1.add(Box.createVerticalStrut(60));
	l5=new JLabel("ENTER THE SERVER IP ADDRESS",JLabel.RIGHT);
	l5.setFont(new Font("Helvetica",Font.BOLD,25));
	l5.setForeground(new Color(0,0,255));
	bo1.add(l5);
	
	
	Box bo2 = Box.createVerticalBox();
	
	bo2.add(Box.createVerticalStrut(60)); 
	t1=new JTextField(10);
	t1.setFont(new Font("Helvetica",Font.BOLD,25));
	t1.setForeground(new Color(0,255,255));
	t1.setBackground(new Color(0,0,255));
	t1.setMaximumSize(t1.getPreferredSize());
	bo2.add(t1);
	
	bo2.add(Box.createVerticalStrut(60)); 
	t3=new JTextField(10);
	t3.setFont(new Font("Helvetica",Font.BOLD,25));
	t3.setForeground(new Color(0,255,255));
	t3.setBackground(new Color(0,0,255));
	t3.setMaximumSize(t1.getPreferredSize());
	bo2.add(t3);
	
    bo2.add(Box.createVerticalStrut(60)); 
	t2=new JPasswordField(10);
	t2.setFont(new Font("Helvetica",Font.BOLD,25));
	t2.setEchoChar('*');
	t2.setForeground(new Color(0,255,255));
	t2.setBackground(new Color(0,0,255));
	t2.setMaximumSize(t1.getPreferredSize());
	bo2.add(t2);
	
	boo1.add(bo1);
	boo1.add(bo2);
	
	c.add(boo1);
	
	Box boo = Box.createHorizontalBox();
	boo.add(Box.createHorizontalStrut(10)); 
	b1=new JButton("EXIT");
	b1.addActionListener(this);
	b1.setMnemonic('E');
	b1.setForeground(new Color(0,255,255));
	b1.setBackground(new Color(0,0,255));
    b1.setFont(new Font("Helvetica",Font.BOLD,25));
	boo.add(b1);
	
	boo.add(Box.createHorizontalStrut(10)); 
	b2=new JButton("LOGIN");
	b2.addActionListener(this);
	b2.setMnemonic('L');
	b2.setBackground(new Color(0,0,255));
	b2.setForeground(new Color(0,255,255));
	b2.setFont(new Font("Helvetica",Font.BOLD,25));
	boo.add(b2);
	
	c.add(boo);
	
	c.setBackground(new Color(255,255,255));
	f.setVisible(true);
	f.setSize(1150,600);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 
 public void actionPerformed(ActionEvent ae)
 {
	if(ae.getSource()==b2)
	{
		boolean set=true;
		 
		if(t1.getText().isEmpty())
		{
			set=false;
			 JOptionPane.showMessageDialog(null, "Enter the Admin name","Error",JOptionPane.ERROR_MESSAGE);
		}
		if(t2.getText().isEmpty())
		{
			set=false;
			 JOptionPane.showMessageDialog(null, "Enter the password","Error",JOptionPane.ERROR_MESSAGE);
		}
		if(t3.getText().isEmpty())
		{
			set=false;
			 JOptionPane.showMessageDialog(null, "Enter the server IP address","Error",JOptionPane.ERROR_MESSAGE);
		}
		/*if(set)
		{
		s=t1.getText();
		c1=t2.getPassword();
		if(Arrays.equals(c1,c2) && s.equals("bookof"))
		{
			JOptionPane.showMessageDialog(null,"LoginSuccessfull","Password",1);
			String IP=t3.getText();
			try{
            service = (MyRemote)Naming.lookup("rmi://"+IP+"/done");
	        }
			catch(Exception exx)
			{
				exx.printStackTrace();
			}
	
			Homef hf = new Homef();
			hf.setTitle("DATA PROCESSOR");
			hf.setVisible(true);
			hf.setSize(1150,600);
			f.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"LoginFailed","Password",1);
		}*/
		
	}
	else if (ae.getSource()==b1)
	{
		System.exit(0);
	}
  }
}