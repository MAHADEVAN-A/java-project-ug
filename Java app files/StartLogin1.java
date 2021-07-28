import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class StartLogin1 implements ActionListener
{
	JFrame f;
	JLabel l2,l3,l4,l5;
	JButton b1,b2;
	JTextField t1,t3;
	JPasswordField t2;
	String s;
	char c1[]=new char[]{};
	char c2[]=new char[]{'m','i','r','d','a','d'};
	GridBagLayout gb;
	GridBagConstraints gc;
	MyRemote service;
  public static void main(String args[])
  {
	        StartLogin1 fp= new StartLogin1();		 
       
  }
  	  /** This is a non-parameterized constructor,it initializes 5 JLabels, 2 JButtons,
	  2 JTextField, 1 JPasswordField for logging into the application*/
	
  public StartLogin1()
  {
    f=new JFrame("StartLogin");
	Container c= f.getContentPane();	
	gb = new GridBagLayout();
	c.setLayout(gb);
	gc = new GridBagConstraints();
	gc.weighty = 0.1;
	gc.weightx = 0.1;
	gc.gridwidth = 2;
	gc.anchor = GridBagConstraints.PAGE_START;	
	//l1=new JLabel();
	//ImageIcon ii = new ImageIcon("img.png");
	//l2.setIcon(ii);
	l2=new JLabel("THE MADURA COLLEGE");
	l2.setForeground(new Color(155,21,2));
	l2.setFont(new Font("Helvetica",Font.BOLD,30));
	gc.gridx = 1;
	gc.gridy = 1;
	gb.setConstraints(l2,gc);
	c.add(l2);	
	l3=new JLabel("ENTER ADMIN NAME",JLabel.LEFT);
	l3.setForeground(new Color(155,21,2));
	l3.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 3;
	gb.setConstraints(l3,gc);
	c.add(l3);	
	l4=new JLabel("ENTER THE PASSWORD",JLabel.RIGHT);
	l4.setForeground(new Color(155,21,2));
	l4.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 5;
	gb.setConstraints(l4,gc);
	c.add(l4);	
	l5=new JLabel("ENTER THE SERVER IP ADDRESS",JLabel.RIGHT);
	l5.setForeground(new Color(155,21,2));
	l5.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 7;
	gb.setConstraints(l5,gc);
	c.add(l5);
	t1=new JTextField(10);
	t1.setForeground(new Color(252,220,177));
	t1.setBackground(new Color(155,21,2));
	t1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 2;
	gc.gridy = 3;
	gb.setConstraints(t1,gc);
	c.add(t1);
	t3=new JTextField(10);
	t3.setForeground(new Color(252,220,177));
	t3.setBackground(new Color(155,21,2));
	t3.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 2;
	gc.gridy = 7;
	gb.setConstraints(t3,gc);
	c.add(t3);
	t2=new JPasswordField(10);
	t2.setEchoChar('*');
	t2.setForeground(new Color(252,220,177));
	t2.setBackground(new Color(155,21,2));
	t2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 2;
	gc.gridy = 5;
	gb.setConstraints(t2,gc);
	c.add(t2);
	b1=new JButton("EXIT");
	b1.addActionListener(this);
	b1.setMnemonic('E');
	b1.setForeground(new Color(252,220,177));
	b1.setBackground(new Color(155,21,2));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
    gc.gridx = 1;
	gc.gridy = 8;
	gb.setConstraints(b1,gc);
	c.add(b1);
	b2=new JButton("LOGIN");
	b2.addActionListener(this);
	b2.setMnemonic('L');
	b2.setBackground(new Color(155,21,2));
	b2.setForeground(new Color(252,220,177));
	b2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 2;
	gc.gridy = 8;
	gb.setConstraints(b2,gc);
	c.add(b2);	
	c.setBackground(new Color(252,220,177));
	f.setVisible(true);
	f.setSize(1150,600);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 
 /** This method handles the 2 JButton,it also has checking condition for the 
 text boxes*/
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
		if(t2.getPassword()==null)
		{
			set=false;
			 JOptionPane.showMessageDialog(null, "Enter the password","Error",JOptionPane.ERROR_MESSAGE);
		}
		if(t3.getText().isEmpty())
		{
			set=false;
			 JOptionPane.showMessageDialog(null, "Enter the server IP address","Error",JOptionPane.ERROR_MESSAGE);
		}
		if(set)
		{
		s=t1.getText();
		c1=t2.getPassword();
		if(Arrays.equals(c1,c2) && s.equals("bookof"))
		{
			JOptionPane.showMessageDialog(null,"LoginSuccessfull","Password",1);
			/*String IP=t3.getText();
			try{
            service = (MyRemote)Naming.lookup("rmi://"+IP+"/done");
	        }catch(Exception exx){exx.printStackTrace();}
			Homef hf = new Homef();
			hf.setTitle("DATA PROCESSOR");
			hf.setVisible(true);
			hf.setSize(1150,600);
			f.dispose();*/
		}
		else
		{
			JOptionPane.showMessageDialog(null,"LoginFailed","Password",1);
		}
		}
	}
	else if (ae.getSource()==b1)
	{
		System.exit(0);
	}
  }
}
