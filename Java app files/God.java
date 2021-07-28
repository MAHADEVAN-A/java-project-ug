//252,220,177
//155,21,2
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.rmi.*;
import java.sql.*; 
import oracle.jdbc.driver.*;
import oracle.sql.*;
import javax.swing.border.*;
import javax.swing.table.*;
public class God implements Runnable
{
	String cstr;
	God(String str)
	{
		this.cstr = str;
	}
	public void run()
	{
		if(this.cstr.equals("Goo"))
		{
			Goo splash = new Goo();
			  try {
         // Make JWindow appear for 10 seconds before disappear
         Thread.sleep(5000);
         splash.dispose();
      } catch(Exception e) {
         e.printStackTrace();
      }
		}
		else
		{
		try {
         Thread.sleep(5000);
        }catch(Exception e) 
		{
         e.printStackTrace();
        }
			StartLogin fp= new StartLogin();
		}
	}
	public static void main(String args[])
	{
		God g1 = new God("Goo");
		God g2 = new God("StartLogin");
		Thread t1 = new Thread(g1);
		Thread t2 = new Thread(g2);
		t1.start();
		t2.start();
	}
}
  class Goo extends JWindow {
   Image splashScreen;
   ImageIcon imageIcon;
   public Goo() {
      splashScreen = Toolkit.getDefaultToolkit().getImage("clglogo.png");
      // Create ImageIcon from Image
      imageIcon = new ImageIcon(splashScreen);
      // Set JWindow size from image size
      setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
      // Get current screen size
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      // Get x coordinate on screen for make JWindow locate at center
      int x = (screenSize.width-getSize().width)/2;
      // Get y coordinate on screen for make JWindow locate at center
      int y = (screenSize.height-getSize().height)/2;
      // Set new location for JWindow
      setLocation(x,y);
      // Make JWindow visible
      setVisible(true);
	  
   }
   // Paint image onto JWindow
   public void paint(Graphics g) {
      super.paint(g);
      g.drawImage(splashScreen, 0, 0, this);
   }
   /*public static void main(String[]args) {
        Goo splash = new Goo();
		  try {
         // Make JWindow appear for 10 seconds before disappear
         Thread.sleep(5000);
         splash.dispose();
      } catch(Exception e) {
         e.printStackTrace();
      }    
	  javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               	StartLogin fp= new StartLogin();		 
            }
        });
  
    }*/
}
  
/**This is the class that has the main method and swing componenets for logging 
into the data processor application */
class StartLogin implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	JTextField t1,t3;
	JPasswordField t2;
	String s;
	char c1[]=new char[]{};
	char c2[]=new char[]{'m','i','r','d','a','d'};
	GridBagLayout gb;
	GridBagConstraints gc;
	MyRemot service;
 /* public static void main(String args[])
  {
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		
               	StartLogin fp= new StartLogin();		 
            }
        });
  }*/
  	  /** This is a non-parameterized constructor,it initializes 5 JLabels, 2 JButtons,
	  2 JTextField, 1 JPasswordField for logging into the application*/
	
  public StartLogin()
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
	l2.setFont(new Font("Helvetica",Font.BOLD,34));
	l2.setForeground(new Color(155,21,2));
	gc.gridx = 1;
	gc.gridy = 1;
	gb.setConstraints(l2,gc);
	c.add(l2);
	
	l3=new JLabel("ENTER ADMIN NAME",JLabel.LEFT);
	l3.setFont(new Font("Helvetica",Font.BOLD,25));
	l3.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 3;
	gb.setConstraints(l3,gc);
	c.add(l3);
	
	l4=new JLabel("ENTER THE PASSWORD",JLabel.RIGHT);
	l4.setFont(new Font("Helvetica",Font.BOLD,25));
	l4.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 5;
	gb.setConstraints(l4,gc);
	c.add(l4);
	
	l5=new JLabel("ENTER THE SERVER IP ADDRESS",JLabel.RIGHT);
	l5.setFont(new Font("Helvetica",Font.BOLD,25));
	l5.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 7;
	gb.setConstraints(l5,gc);
	c.add(l5);
	
	t1=new JTextField(10);
	t1.setFont(new Font("Helvetica",Font.BOLD,25));
	t1.setForeground(new Color(252,220,177));
	t1.setBackground(new Color(155,21,2));
	gc.gridx = 2;
	gc.gridy = 3;
	gb.setConstraints(t1,gc);
	c.add(t1);
	
	t3=new JTextField(10);
	t3.setFont(new Font("Helvetica",Font.BOLD,25));
	t3.setForeground(new Color(252,220,177));
	t3.setBackground(new Color(155,21,2));
	gc.gridx = 2;
	gc.gridy = 7;
	gb.setConstraints(t3,gc);
	c.add(t3);

	t2=new JPasswordField(10);
	t2.setFont(new Font("Helvetica",Font.BOLD,25));
	t2.setEchoChar('*');
	t2.setForeground(new Color(252,220,177));
	t2.setBackground(new Color(155,21,2));
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
		if(set)
		{
		s=t1.getText();
		c1=t2.getPassword();
		if(Arrays.equals(c1,c2) && s.equals("bookof"))
		{
			JOptionPane.showMessageDialog(null,"LoginSuccessfull","Password",1);
			String IP=t3.getText();
			try{
            service = (MyRemot)Naming.lookup("rmi://"+IP+"/done");
	        }catch(Exception exx){exx.printStackTrace();}
	
			Homef hf = new Homef();
			hf.setTitle("DATA PROCESSOR");
			hf.setVisible(true);
			hf.setSize(1150,600);
			f.dispose();
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

  //class Homef
/** This class is the inner class to the StartLogin class so that it can inherit
object of the Naming class so that it can call methods on the server. It extends
the JFrame class and implements the ActionListener to handles 5 JButtons*/
public class Homef extends JFrame implements ActionListener
{
	JLabel l1;
	JButton b1,b2,b3,b4,b5;
	GridBagLayout gb;
	GridBagConstraints gc;
	/**This constructor is non-parameterized,it initializes 5 JButtons and 1 JLabel*/
		
	Homef()
	{
        Container c = this.getContentPane();
		gb = new GridBagLayout();
	    c.setLayout(gb);
	    gc = new GridBagConstraints();
	l1=new JLabel("DATA PROCESSOR");
	l1.setFont(new Font("Helvetica",Font.BOLD,34));
	l1.setForeground(new Color(155,21,2));
	gc.gridx = 3;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.PAGE_START;
	gc.gridwidth = 1;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(l1,gc);
	c.add(l1);
	
	b5=new JButton("<<");
	b5.addActionListener(this);
	b5.setMnemonic('B');
	b5.setBackground(new Color(155,21,2));
	b5.setForeground(new Color(252,220,177));
	b5.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0,0,20,20);
	gb.setConstraints(b5,gc);
	c.add(b5);
		
	ImageIcon bi= new ImageIcon("anal.png");	
	b1=new JButton("ANALYSIS",bi);
	b1.addActionListener(this);
	b1.setMnemonic('A');
	b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,20));
	b1.setToolTipText("Get the chart and count of applied students");
	gc.gridx = 0;
	gc.gridy = 1;
	//gc.anchor = GridBagConstraints.FIRST_LINE_END;
	gc.fill = GridBagConstraints.BOTH;
	gc.insets = new Insets(0,100,100,0);
	gc.gridwidth = 2;
	gc.gridheight = 2;
	gb.setConstraints(b1,gc);
	c.add(b1);
	
	ImageIcon bv= new ImageIcon("view.png");
	b2=new JButton("VIEW TOPPERS",bv);	
	b2.addActionListener(this);
	b2.setMnemonic('V');
	b2.setBackground(new Color(155,21,2));
	b2.setForeground(new Color(252,220,177));
	b2.setFont(new Font("Helvetica",Font.BOLD,20));
	b2.setToolTipText("Get the list of students with maximum marks");
	gc.gridx = 4;
	gc.gridy = 1;
	//gc.fill = GridBagConstraints.BOTH;
	gc.insets = new Insets(0,0,100,100);
	//gc.gridwidth = 2;
	//gc.gridheight = 2;
	gb.setConstraints(b2,gc);
	c.add(b2);
	
	ImageIcon bq= new ImageIcon("query.png");
	b3=new JButton("QUERY BUILDER",bq);	
	b3.addActionListener(this);
	b3.setMnemonic('Q');
	b3.setBackground(new Color(155,21,2));
	b3.setForeground(new Color(252,220,177));
	b3.setFont(new Font("Helvetica",Font.BOLD,20));
	b3.setToolTipText("Get the user-required details from database");
	gc.gridx = 0;
	gc.gridy = 4;
	//gc.anchor = GridBagConstraints.LINE_START;
	//gc.fill = GridBagConstraints.BOTH;
	gc.insets = new Insets(0,100,100,0);
	//gc.gridwidth = 2;
	//gc.gridheight = 2;
	gb.setConstraints(b3,gc);
	c.add(b3);
	
	ImageIcon bm= new ImageIcon("mess.png");
	b4=new JButton("MESSENGER",bm);
	b4.addActionListener(this);
	b4.setMnemonic('M');
	b4.setBackground(new Color(155,21,2));
	b4.setForeground(new Color(252,220,177));
	b4.setFont(new Font("Helvetica",Font.BOLD,20));
	b4.setToolTipText("Convey information to the applying students");
    gc.gridx = 4;
	gc.gridy = 4;
	//gc.fill = GridBagConstraints.BOTH;
	gc.insets = new Insets(0,0,100,100);
	//gc.gridwidth = 2;
	//gc.gridheight = 2;
	gb.setConstraints(b4,gc);
	c.add(b4);	
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	c.setBackground(new Color(252,220,177));
	}
	/** This method handles the 5 JButtons.*/
		
	public void actionPerformed(ActionEvent ae)
	{if (ae.getSource()==b5)
	    {
			StartLogin fp= new StartLogin();
		   this.dispose();
	    }
        else if (ae.getSource()==b1)
        {
          Analys as = new Analys();
          as.setTitle("ANALYSIS");
          as.setVisible(true);
          as.setSize(1150,600);
          this.dispose();
        }
        else if (ae.getSource()==b2)
        {
          Vtop vt = new Vtop();
          vt.setTitle("VIEW TOPPERS");
          vt.setVisible(true);
          vt.setSize(1150,600);
          this.dispose();
        }
        else if (ae.getSource()==b4)
        {
            Sms1 sm = new Sms1();
            sm.setTitle("SEND MESSEGE");
            sm.setVisible(true);
            sm.setSize(1150,600);
            this.dispose();
        }
        else if (ae.getSource()==b3)
        {
           Qb1 q1 = new Qb1();
           q1.setTitle("QUERY BUILDER");
           q1.setVisible(true);
           q1.setSize(1150,600);
           this.dispose();
        }	
	}
	
/** This class is a inner class to the Homef class.It extends JFrame class and implements ActionListener*/
public class Analys extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4;
	JButton b1,b2,bh;
	JComboBox bx1,bx2,bx3,bx4;
	GridBagLayout gb;
	GridBagConstraints gc;
    String s1[] = new String[10];	
    String s2[] = new String[10];  
	String s3[] = new String[10];
	String a[] = new String[8];
	Container c= this.getContentPane();
	String x;int a1;
	
	String text="<html>"+
		"Using this window you can select the details"+"<br>"+
		"to view the chart form of the details selected"+"<br>"+
		"by choosing the options in the combo boxes."+"<br>"+
		"Eg. you can view the details of students who "+"<br>"+
		"applied for UG B.Sc.ComputerScience Regular "+"<br>"+
		"distinguished by their groups(12th group for UG,"+"<br>"+
		"UG MAJORS for PG category) or by their Gender."+"<br>"+
		"</html>";
	
	
/** It is non-parameterized,it initializes 4 JLabels, 2 JButtons, 4 JCheckBoxes,
	*/
	Analys()
	{
	s1[0] = "B.Sc.ComputerScience";
    s1[1] = "B.Sc.Mathematics";
    s1[2] = "B.Sc.Physics";
    s1[3] = "B.Sc.Chemistry";
    s1[4] = "B.Sc.Botany";
    s1[5] = "B.Sc.Zoology";
    s1[6] = "B.A.Tamil";
    s1[7] = "B.A.English";
    s1[8] = "B.Com.CA";
    s1[9] = "B.Com.CS";
	
	s2[0] ="M.Sc.ComputerScience";
    s2[1] ="M.Sc.Mathematics";
    s2[2] ="M.Sc.Physics";
    s2[3] ="M.Sc.Chemistry";
    s2[4] ="M.Sc.Botany";
    s2[5] ="M.Sc.Zoology";
    s2[6] ="M.A.Tamil";
    s2[7] ="M.A.English";
    s2[8] ="M.Com.CA";
    s2[9] ="M.Com.CS";
	
	
	gb = new GridBagLayout();
	c.setLayout(gb);
	gc = new GridBagConstraints();
	
    bh = new JButton("help");
	bh.addActionListener(this);
	bh.setMnemonic('H');
	bh.setBackground(new Color(155,21,2));
	bh.setForeground(new Color(252,220,177));
	bh.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 5;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_END;
	gb.setConstraints(bh,gc);
	c.add(bh);
	
	
	b1=new JButton("<<");
	b1.addActionListener(this);
	b1.setMnemonic('B');
	b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0,0,20,20);
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(b1,gc);
	c.add(b1);
	
	l1=new JLabel("SELECT THE CATEGORY");
	l1.setFont(new Font("Helvetica",Font.BOLD,25));
	l1.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 1;
	gb.setConstraints(l1,gc);
	c.add(l1);
	
	l2=new JLabel("SELECT THE STREAM");
	l2.setFont(new Font("Helvetica",Font.BOLD,25));
	l2.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 2;
	gb.setConstraints(l2,gc);
	c.add(l2);
	
	l3=new JLabel("SELECT THE MAJOR",JLabel.LEFT);
	l3.setFont(new Font("Helvetica",Font.BOLD,25));
	l3.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 3;
	gb.setConstraints(l3,gc);
	c.add(l3);
	
	l4=new JLabel("SELECT THE TYPE",JLabel.RIGHT);
	l4.setFont(new Font("Helvetica",Font.BOLD,25));
	l4.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 4;
	gb.setConstraints(l4,gc);
	c.add(l4);
		
	
	
	b2=new JButton("SHOW");
	b2.addActionListener(this);
	b2.setMnemonic('S');
	b2.setBackground(new Color(155,21,2));
	b2.setForeground(new Color(252,220,177));
	b2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 2;
	gc.gridy = 6;
	gb.setConstraints(b2,gc);
	c.add(b2);
	
	bx1 = new JComboBox();
	bx1.addItem("--select--");
	bx1.addItem("UG");
	bx1.addItem("PG");
	bx1.addActionListener(this);
	bx1.setBackground(new Color(155,21,2));
	bx1.setForeground(new Color(252,220,177));
	bx1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 4;
	gc.gridy = 1;
	gb.setConstraints(bx1,gc);
	c.add(bx1);
	
	bx2 = new JComboBox();
	bx2.addItem("--select--");
	bx2.addItem("REGULAR");
	bx2.addItem("SELF-FINANCE");
	bx2.addActionListener(this);
	bx2.setBackground(new Color(155,21,2));
	bx2.setForeground(new Color(252,220,177));
	bx2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 4;
	gc.gridy = 2;
	gb.setConstraints(bx2,gc);
	c.add(bx2);
	
	bx3 = new JComboBox();
	bx3.addItem("--select--");
	for(int i=0;i<10;i++)
	{
	bx3.addItem(s1[i]);
	}
	bx3.addActionListener(this);
	bx3.setBackground(new Color(155,21,2));
	bx3.setForeground(new Color(252,220,177));
	bx3.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 4;
	gc.gridy = 3;
	gb.setConstraints(bx3,gc);
	c.add(bx3);
	
	bx4 = new JComboBox();
	bx4.addItem("--select--");
	bx4.addItem("GENDER");
	bx4.addItem("GROUP");
	bx4.addActionListener(this);
	bx4.setBackground(new Color(155,21,2));
	bx4.setForeground(new Color(252,220,177));
	bx4.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 4;
	gc.gridy = 4;
	gb.setConstraints(bx4,gc);
	c.add(bx4);
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	c.setBackground(new Color(252,220,177));
	}
	/** It handles 2 JButtons and has checking condition for 4 JCheckBoxes*/
		
	public void actionPerformed(ActionEvent ae)
    {if(ae.getSource() == bx1)
		{  
            String str=(String)bx1.getSelectedItem();
			if(str.equals("UG"))
			{
				s3=s1;
				String st=(String)bx3.getItemAt(1);
				if(st.equals(s2[0]))
				{
				 for(int i=0;i<10;i++)
	             {
					 bx3.removeItem(s2[i]);
	                bx3.addItem(s3[i]);
	             }this.revalidate();
				}
            a[0]="TWELVETHGROUPS.Groups";
			a[1]="12THGROUPS";
			a[2]="TWELVETHGROUPS";
			a[3]="TMARKDETAIL";
			a[4]="TWELVETHGROUPS.GroupID";
			a[5]="TMARKDETAIL.GroupID";
			a[6]="UGID";				
			}
			else
			{
				s3=s2;
				String st=(String)bx3.getItemAt(1);
				
				if(st.equals(s1[0]))
				{
				    for(int i=0;i<10;i++)
	                {
						bx3.removeItem(s1[i]);
	                    bx3.addItem(s3[i]);
	                }this.revalidate();
				}
			a[0]="UGMAJORS.MAJORS";
			a[1]="UGMAJORS_STUDIED";
			a[2]="UGMAJORS";
			a[3]="UGMARKDETAIL";
			a[4]="UGMAJORS.UGID";
			a[5]="UGMARKDETAIL.UGID";
			a[6]="PGID";
			}
			
		}
		else if(ae.getSource() == bx2)
		{
			String str=(String)bx2.getSelectedItem();
			if(str.equals("REGULAR"))
			{
				a1 = 1;
			}
			else
			{
				a1 = 2;
			}
		}
		else if(ae.getSource() == bx3)
		{
			String str=(String)bx1.getSelectedItem();
			if(str.equals("UG"))
			{
			String str1=(String)bx3.getSelectedItem();
			switch(str1)
			{
				case "B.Sc.ComputerScience": a[7]="'U0001'";x="12th GROUPS TAKEN FOR B.Sc.ComputerScience";break;
				case "B.Sc.Mathematics": a[7]="'U0002'";x="12th GROUPS TAKEN FOR B.Sc.Mathematics";break;
				case "B.Sc.Physics": a[7]="'U0003'";x="12th GROUPS TAKEN FOR B.Sc.Physics";break;
				case "B.Sc.Chemistry": a[7]="'U0004'";x="12th GROUPS TAKEN FOR B.Sc.Chemistry";break;
				case "B.Sc.Botany": a[7]="'U0005'";x="12th GROUPS TAKEN FOR B.Sc.Botany";break;
				case "B.Sc.Zoology": a[7]="'U0006'";x="12th GROUPS TAKEN FOR B.Sc.Zoology";break;
				case "B.A.Tamil": a[7]="'U0007'";x="12th GROUPS TAKEN FOR B.A.Tamil";break;
				case "B.A.English": a[7]="'U0008'";x="12th GROUPS TAKEN FOR B.A.English";break;
				case "B.Com.CA": a[7]="'U0009'";x="12th GROUPS TAKEN FOR B.Com.CA";break;
				case "B.Com.CS": a[7]="'U0010'";x="12th GROUPS TAKEN FOR B.Com.CS";break;	
			}
			}
			else
			{
			String str2=(String)bx3.getSelectedItem();
			switch(str2)
			{
				case "M.Sc.ComputerScience": a[7]="'P0001'";x="UGMAJOR TAKEN FOR M.Sc.ComputerScience";break;
				case "M.Sc.Mathematics": a[7]="'P0002'";x="UGMAJOR TAKEN FOR M.Sc.Mathematics";break;
				case "M.Sc.Physics": a[7]="'P0003'";x="UGMAJOR TAKEN FOR M.Sc.Physics";break;
				case "M.Sc.Chemistry": a[7]="'P0004'";x="UGMAJOR TAKEN FOR M.Sc.Chemistry";break;
				case "M.Sc.Botany": a[7]="'P0005'";x="UGMAJOR TAKEN FOR M.Sc.Botany";break;
				case "M.Sc.Zoology": a[7]="'P0006'";x="UGMAJOR TAKEN FOR M.Sc.Zoology";break;
				case "M.A.Tamil": a[7]="'P0007'";x="UGMAJOR TAKEN FOR M.A.Tamil";break;
				case "M.A.English": a[7]="'P0008'";x="UGMAJOR TAKEN FOR M.A.English";break;
				case "M.Com.CA": a[7]="'P0009'";x="UGMAJOR TAKEN FOR M.Com.CA";break;
				case "M.Com.CS": a[7]="'P0010'";x="UGMAJOR TAKEN FOR M.Com.CS";break;
			}
			}
				
		}
		else if(ae.getSource() == bx4)
		{
			String str2=(String)bx4.getSelectedItem();
			if(str2.equals("GENDER"))
			{
			String str=(String)bx1.getSelectedItem();
			 if(str.equals("UG"))
			 {
				a[0]="STUDENTDETAIL.Gender";
				a[1]="Gender";
				a[2]="STUDENTDETAIL";
				a[4]="STUDENTDETAIL.StudID";
				a[5]="TMARKDETAIL.StudID";
				x="GENDER";
			 }
			 else
			 {
				a[0]="STUDENTDETAIL.Gender";
				a[1]="Gender";
				a[2]="STUDENTDETAIL";
				a[4]="STUDENTDETAIL.StudID";
				a[5]="UGMARKDETAIL.StudID";
				x="GENDER";
			 }	
			}			
		}
	else if(ae.getSource()==b1)
	 {
            this.dispose();
           Homef hf = new Homef();
			hf.setTitle("DATA PROCESSOR");
			hf.setVisible(true);
			hf.setSize(1150,600);
		
	 }
	 else if(ae.getSource()==bh)
	 {
			JOptionPane.showMessageDialog(this,text); 
	 }
     else if (ae.getSource()==b2)
     {
		 boolean set=true;
		 
		 if(bx1.getSelectedItem()=="--select--")
		 { System.out.println("hello");
			 JOptionPane.showMessageDialog(null, "select the category","Error",JOptionPane.ERROR_MESSAGE);
	         set = false;	 
		 }
		 if(bx2.getSelectedItem()=="--select--")
		 {
			 JOptionPane.showMessageDialog(null, "select the stream","Error",JOptionPane.ERROR_MESSAGE);
	         set = false;	 
		 }
		 if(bx3.getSelectedItem()=="--select--")
		 {
			 JOptionPane.showMessageDialog(null, "select the major","Error",JOptionPane.ERROR_MESSAGE);
	         set = false;	 
		 }
		 if(bx4.getSelectedItem()=="--select--")
		 {
			 JOptionPane.showMessageDialog(null, "select the type","Error",JOptionPane.ERROR_MESSAGE);
	         set = false;	 
		 }
		
		 if(set)
		 {
      Fcount fc = new Fcount(a,a1,x);
      fc.setTitle("FORM COUNTER");
      fc.setVisible(true);
      fc.setSize(1150,600); 
	  this.dispose();
		 }
     }
    }

/**It is a inner class to the Analys class. It extends JFrame class and 
implements ActionListener. It has 2 JLabels, 1 JButton and paint method to 
draw pie chart*/
public class Fcount extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JButton b1,bh;
	GridBagLayout gb;
	GridBagConstraints gc;
	 ArrayList<String> u = new ArrayList<>();
     ArrayList<Integer> slices = new ArrayList<>();	
	String s;
	String head;
	Color scolor[];
	int k=0;

	String ad[];
	String g1[] = new String[2];
	
		String text="<html>"+
		"In this window you can view the pie chart according"+"<br>"+
		"to the options choosed in the previous window."+"<br>"+
		"You can also get the number of students application"+"<br>"+
		"that matches the choosen criteria."+"<br>"+
		"</html>";
	

	/** It is a parameterized constructor. It has 1 String array to get elements of a query 
		 and 1 integer variable to check the selected stream(Regular or Self) 
		 then 1 String variable to get title of the chart*/
   
	Fcount(String a[],int a1,String x)
	{
	 ad=a;
	 head = x;
	Container c= this.getContentPane();
	gb = new GridBagLayout();
	c.setLayout(gb);
	gc = new GridBagConstraints();
	
	bh = new JButton("help");
	bh.addActionListener(this);
	bh.setMnemonic('H');
	bh.setBackground(new Color(155,21,2));
	bh.setForeground(new Color(252,220,177));
	bh.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 5;
	gc.gridy = 0;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gc.anchor = GridBagConstraints.FIRST_LINE_END;
	gb.setConstraints(bh,gc);
	c.add(bh);
	
	b1=new JButton("<<");
	b1.addActionListener(this);
	b1.setMnemonic('B');
	b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_START; 
	gb.setConstraints(b1,gc);
	c.add(b1);
	
	if(a[0].equals("UGMAJORS.MAJORS"))
		{
			Color scol[]=new Color[10];
		
		
		scol[0]=Color.pink;
		scol[1]=Color.green;
		scol[2]=Color.blue;
		scol[3]=Color.red;
		scol[4]=Color.black;
		scol[5]=Color.cyan;
		scol[6]=Color.orange;
		scol[7]=Color.yellow;
		scol[8]=Color.lightGray;
		scol[9]=Color.darkGray;	
        scolor = scol;		
     

	
		}
		/*else if( a[0].equals("TWELVETHGROUPS.Groups"))
		{
			Color scol[]=new Color[3];
		scol[0]=Color.pink;
		scol[1]=Color.green;
		scol[2]=Color.blue;
        scolor = scol;		
		}*/
		else
		{
			Color scol[]=new Color[3];
		scol[0]=Color.pink;
		scol[1]=Color.green;
		scol[2]=Color.blue;
		scolor = scol;
		}	
		try
		{
		  Object o[] = new Object[4];
          o = service.getChartData(a,a1);	
		  int k =(int)o[2];
		  u = (ArrayList<String>)o[0];
    
		  slices = (ArrayList<Integer>)o[1];
		  

		  s = (String)o[3];
		  System.out.println(s);
		}catch(Exception ex){}
	    
		this.revalidate();	   		     
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    c.setBackground(new Color(252,220,177));
	}
	/** It paints the background color, two strings to show form count and the pie chart.*/
	   
	  public void paint(Graphics g) 
   {	  g.setColor(new Color(252,220,177));
	  g.fillRect(0,0,this.getWidth(),this.getHeight());
        
      double total = 0.0D;
	  
      for (int ia = 0; ia < slices.size(); ia++) {
         total += slices.get(ia);
	  }
      
      double curValue = 0.0D;
      int startAngle = 0;
      for (int ib = 0; ib < slices.size(); ib++) {
         startAngle = (int) (curValue * 360 / total);
         int arcAngle = (int) (slices.get(ib) * 360 / total);
         g.setColor(scolor[ib]);
         g.fillArc(250,150, 400, 400, startAngle, arcAngle);
         curValue += slices.get(ib);
      }
	  Font f  = new Font("Helvetica",Font.BOLD,25);
	  g.setFont(f);
	  g.setColor(new Color(155,21,2));
	  g.drawString("FORM COUNT",100,100);	  
	  g.drawString(head,400,100);
	  g.setFont(f);
	  g.drawString(s,300,100);
	  int arr[];
	   if(ad[0].equals("UGMAJORS.MAJORS"))
		{
	  int ar[]={150,180,210,240,270,300,330,360,390,420};
	  
		     for(int m1=0;m1<u.size();m1++)
	  {
		  g.setColor(scolor[m1]);
		  g.fillRect(700,ar[m1],5,5);
		  g.drawString(u.get(m1),750,ar[m1]);
	  }
		}
		 else if(ad[0].equals("PGMAJORS.MAJORS"))
		{
             int ar[]={150,180,210,240,270,300,330,360,390,420};	  
		     for(int m4=0;m4<u.size();m4++)
	  {
		  g.setColor(scolor[m4]);
		  g.fillRect(700,ar[m4],5,5);
		  g.drawString(u.get(m4),750,ar[m4]);
	  }
		}
		else if( ad[0].equals("TWELVETHGROUPS.Groups"))
		{
             int ar[]={150,180,210};	
		     for(int m2=0;m2<u.size();m2++)
	  {
		  g.setColor(scolor[m2]);
		  g.fillRect(700,ar[m2],5,5);
		  g.drawString(u.get(m2),750,ar[m2]);
	  }
		}
		else{
int ar[]={150,180};			
		     for(int m3=0;m3<u.size();m3++)
	  {
		  g.setColor(scolor[m3]);
		  g.fillRect(700,ar[m3],5,5);
		  if(u.get(m3).equals("1"))
		  {
		  g.drawString("MALE",750,ar[m3]);
		  }else{g.drawString("FEMALE",750,ar[m3]);}
	  }
		}
	
	
	  
	 
   }
   /** It handles one JButton to go back.*/
	 
	public void actionPerformed(ActionEvent ae)
    {if(ae.getSource()==b1)
	 {
          this.dispose();
	 Analys as = new Analys();
        as.setTitle("ANALYSIS");
        as.setVisible(true);
        as.setSize(1150,600);
		 
	 }
	 	 else if(ae.getSource()==bh)
	 {
			JOptionPane.showMessageDialog(this,text); 
	 }
    }
}//End Fcount


}//End Analys

/** It is inner class to the Homef class. It extends JFrame and implements
ActionListener. It has 5 JLabels, 2 JButtons and 5 JCheckBoxes*/
public class Vtop extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,bh;
	JComboBox bx1,bx2,bx3,bx4,bx5;
	GridBagLayout gb;
	GridBagConstraints gc;
    Container c;
	int vcount;
    String s1[] = new String[10];
	int bx,c1;
    String s2[] = new String[10];
	String s3[] = new String[10];
	String n[] = new String[4];
	String a[] = new String[14];
    String bxc;
	
			String text="<html>"+
		"This window let you choose the criteria you want"+"<br>"+
		"to get the list of students scored maximum marks."+"<br>"+
		"</html>";
	
		/**It initializes 5 JLabels, 2 JButtons and 5 JCheckBoxes*/
	
	Vtop()
	{
	s1[0] = "B.Sc.ComputerScience";
    s1[1] = "B.Sc.Mathematics";
    s1[2] = "B.Sc.Physics";
    s1[3] = "B.Sc.Chemistry";
    s1[4] = "B.Sc.Botany";
    s1[5] = "B.Sc.Zoology";
    s1[6] = "B.A.Tamil";
    s1[7] = "B.A.English";
    s1[8] = "B.Com.CA";
    s1[9] = "B.Com.CS";
	
	s2[0] ="M.Sc.ComputerScience";
    s2[1] ="M.Sc.Mathematics";
    s2[2] ="M.Sc.Physics";
    s2[3] ="M.Sc.Chemistry";
    s2[4] ="M.Sc.Botany";
    s2[5] ="M.Sc.Zoology";
    s2[6] ="M.A.Tamil";
    s2[7] ="M.A.English";
    s2[8] ="M.Com.CA";
    s2[9] ="M.Com.CS";
		
	c= this.getContentPane();
	gb = new GridBagLayout();
	c.setLayout(gb);
	gc = new GridBagConstraints();
	
	bh = new JButton("help");
	bh.addActionListener(this);
	bh.setMnemonic('H');
	bh.setBackground(new Color(155,21,2));
	bh.setForeground(new Color(252,220,177));
	bh.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 5;
	gc.gridy = 0;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gc.anchor = GridBagConstraints.FIRST_LINE_END;
	gb.setConstraints(bh,gc);
	c.add(bh);
	
	b1=new JButton("<<");
	b1.addActionListener(this);
	b1.setMnemonic('B');
	b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0,0,20,20);
	gb.setConstraints(b1,gc);
	c.add(b1);

	l1=new JLabel("SELECT THE CATEGORY");
	l1.setFont(new Font("Helvetica",Font.BOLD,25));
	l1.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 1;
	gb.setConstraints(l1,gc);
	c.add(l1);
	
	l2=new JLabel("SELECT THE STREAM");
	l2.setFont(new Font("Helvetica",Font.BOLD,25));
	l2.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 2;
	gb.setConstraints(l2,gc);
	c.add(l2);
	
	l3=new JLabel("SELECT THE MAJOR");
	l3.setFont(new Font("Helvetica",Font.BOLD,25));
	l3.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 3;
	gb.setConstraints(l3,gc);
	c.add(l3);
	
	l4=new JLabel("SELECT THE COMMUNITY");
	l4.setFont(new Font("Helvetica",Font.BOLD,25));
	l4.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 4;
	gb.setConstraints(l4,gc);
	c.add(l4);
	
	b2=new JButton("SHOW");
	b2.addActionListener(this);
	b2.setMnemonic('S');
	b2.setBackground(new Color(155,21,2));
	b2.setForeground(new Color(252,220,177));
	b2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 2;
	gc.gridy = 5;
	gb.setConstraints(b2,gc);
	c.add(b2);
	
	bx1 = new JComboBox();
	bx1.addItem("--select--");
	for(int i=0;i<10;i++)
	{
	bx1.addItem(s1[i]);
	}
	bx1.addActionListener(this);
	bx1.setBackground(new Color(155,21,2));
	bx1.setForeground(new Color(252,220,177));
	bx1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 5;
	gc.gridy = 3;
	gc.anchor = GridBagConstraints.LINE_START;
	gc.gridwidth = 1;
	gb.setConstraints(bx1,gc);
	c.add(bx1);
	
	bx2 = new JComboBox();
	bx2.addItem("--select--");
	bx2.addItem("OC");
	bx2.addItem("BC");
	bx2.addItem("MBC");
	bx2.addItem("SC/ST");
	bx2.addItem("DNC");
	bx2.addItem("OTHERS");
	bx2.addActionListener(this);
	bx2.setBackground(new Color(155,21,2));
	bx2.setForeground(new Color(252,220,177));
	bx2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 5;
	gc.gridy = 4;
	//gc.anchor = GridBagConstraints.LINE_START;
	//gc.gridwidth = 1;
	gb.setConstraints(bx2,gc);
	c.add(bx2);
	
	bx3 = new JComboBox();
	bx3.addItem("--select--");
	bx3.addItem("UG");
	bx3.addItem("PG");
	bx3.addActionListener(this);
	bx3.setBackground(new Color(155,21,2));
	bx3.setForeground(new Color(252,220,177));
	bx3.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 5;
	gc.gridy = 1;
	//gc.anchor = GridBagConstraints.LINE_START;
	//gc.gridwidth = 1;
	gb.setConstraints(bx3,gc);
	c.add(bx3);
	
	bx4 = new JComboBox();
	bx4.addItem("--select--");
	bx4.addItem("REGULAR");
	bx4.addItem("SELF");
	bx4.addActionListener(this);
	bx4.setBackground(new Color(155,21,2));
	bx4.setForeground(new Color(252,220,177));
	bx4.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 5;
	gc.gridy = 2;
	//gc.anchor = GridBagConstraints.LINE_START;
	//gc.gridwidth = 1;
	gb.setConstraints(bx4,gc);
	c.add(bx4);

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	c.setBackground(new Color(252,220,177));
	}
			/**It handles 2 JButtons and 5 JCheckBoxes. It also has 
		checking condition for JCheckBoxes.*/
	 
	public void actionPerformed(ActionEvent ae)
    {
if(ae.getSource()==b1)
	 {
          Homef hf = new Homef();
			hf.setTitle("DATA PROCESSOR");
			hf.setVisible(true);
			hf.setSize(1150,600);
		 this.dispose();
	 }
	 	 else if(ae.getSource()==bh)
	 {
			JOptionPane.showMessageDialog(this,text); 
	 }
	 else if(ae.getSource()==b2)
	 {
		 		 boolean set=true;
		 
		 if(bx1.getSelectedItem()=="--select--")
		 { 
			 JOptionPane.showMessageDialog(null, "select the major","Error",JOptionPane.ERROR_MESSAGE);
	         set = false;	 
		 }
		 if(bx2.getSelectedItem()=="--select--")
		 {
			 JOptionPane.showMessageDialog(null, "select the community","Error",JOptionPane.ERROR_MESSAGE);
	         set = false;	 
		 }
		 if(bx3.getSelectedItem()=="--select--")
		 {
			 JOptionPane.showMessageDialog(null, "select the category","Error",JOptionPane.ERROR_MESSAGE);
	         set = false;	 
		 }
		 if(bx4.getSelectedItem()=="--select--")
		 {
			 JOptionPane.showMessageDialog(null, "select the stream","Error",JOptionPane.ERROR_MESSAGE);
	         set = false;	 
		 }
		
		 if(set)
		 {
			 
		    Vcatt vc = new Vcatt(a,bx,c1,n,vcount,bxc);
            vc.setTitle("SELECT CATEGORY");
            vc.setVisible(true);
			 vc.setSize(1150,600);
			this.dispose();
		 }
			
	 }

	 else if(ae.getSource()==bx3)
	 {
		 String str=(String)bx3.getSelectedItem();
			if(str.equals("UG"))
			{   vcount=1;
				s3=s1;
				String st=(String)bx1.getItemAt(1);
				if(st.equals(s2[0]))
				{
				 for(int i=0;i<10;i++)
	             {
					 bx1.removeItem(s2[i]);
	                bx1.addItem(s3[i]);
	             }
				}
				n[0]="StudentID";
				n[1]="StudentName";
				n[2]="TotalMarks";
				n[3]="GroupStudied";
				//n[4]="EmailID";
			a[0]="STUDENTDETAIL.StudID";
			a[1]="Name";
			a[2]="Total";
			a[3]="TWELVETHGROUPS.Groups";
			a[4]="Email";
			a[5]="STUDENTDETAIL";
			a[6]="TMARKDETAIL";
			a[7]="TWELVETHGROUPS";
			a[8]=a[0];
			a[9]="TMARKDETAIL.StudID";
			a[10]="TMARKDETAIL.GroupID";
			a[11]="TWELVETHGROUPS.GroupID";			
			a[12]="UGID";
			}			
			else
			{
				vcount=2;
				s3=s2;
				String st=(String)bx1.getItemAt(1);
				if(st.equals(s1[0]))
				{
				    for(int i=0;i<10;i++)
	                {
						bx1.removeItem(s1[i]);
	                    bx1.addItem(s3[i]);
	                }
				}
				n[0]="StudentID";
				n[1]="StudentName";
				n[2]="TotalPercentage";
				n[3]="MajorStudied";
				//n[4]="EmailID";
			a[0]="STUDENTDETAIL.StudID";
			a[1]="Name";
			a[2]="Percentage";
			a[3]="UGMAJORS.Majors";
			a[4]="Email";
			a[5]="STUDENTDETAIL";
			a[6]="UGMARKDETAIL";
			a[7]="UGMAJORS";
			a[8]=a[0];
			a[9]="UGMARKDETAIL.StudID";
			a[10]="UGMARKDETAIL.UGID";
			a[11]="UGMAJORS.UGID";
			a[12]="PGID";
							
			}
	
	    }
	 else if(ae.getSource()==bx4)
	 {
		 String str=(String)bx4.getSelectedItem();
			if(str.equals("REGULAR"))
			{
				bx = 1;
			}
			else
			{
				bx = 2;
			}
	 }
	 else if(ae.getSource()==bx1)
	 {
		 String str=(String)bx3.getSelectedItem();
			if(str.equals("UG"))
			{
			String str1=(String)bx1.getSelectedItem();
			bxc=(String)bx1.getSelectedItem();
			switch(str1)
			{
				case "B.Sc.ComputerScience": a[13]="'U0001'";break;
				case "B.Sc.Mathematics": a[13]="'U0002'";break;
				case "B.Sc.Physics": a[13]="'U0003'";break;
				case "B.Sc.Chemistry": a[13]="'U0004'";break;
				case "B.Sc.Botany": a[13]="'U0005'";break;
				case "B.Sc.Zoology": a[13]="'U0006'";break;
				case "B.A.Tamil": a[13]="'U0007'";break;
				case "B.A.English": a[13]="'U0008'";break;
				case "B.Com.CA": a[13]="'U0009'";break;
				case "B.Com.CS": a[13]="'U0010'";break;	
			}
			}
			else
			{
			String str2=(String)bx1.getSelectedItem();
			bxc=(String)bx1.getSelectedItem();
			switch(str2)
			{
				case "M.Sc.ComputerScience": a[13]="'P0001'";break;
				case "M.Sc.Mathematics": a[13]="'P0002'";break;
				case "M.Sc.Physics": a[13]="'P0003'";break;
				case "M.Sc.Chemistry": a[13]="'P0004'";break;
				case "M.Sc.Botany": a[13]="'P0005'";break;
				case "M.Sc.Zoology": a[13]="'P0006'";break;
				case "M.A.Tamil": a[13]="'P0007'";break;
				case "M.A.English": a[13]="'P0008'";break;
				case "M.Com.CA": a[13]="'P0009'";break;
				case "M.Com.CS": a[13]="'P0010'";break;
			}
			}
	 }
	 else if(ae.getSource()==bx2)
	 {
		 String str1=(String)bx2.getSelectedItem();
			switch(str1)
			{
				case "OC": c1 = 1;break;
				case "BC": c1 = 2;break;
				case "MBC": c1 = 3;break;
				case "SC/ST": c1 = 4;break;
				case "DNC": c1 = 5;break;
				case "OTHERS": c1 = 6;break;
			}
	 }
    }
	
/** It is inner class to the Vtop class*/
public class Vcatt extends JFrame implements ActionListener
{
	JLabel l1;
	JButton b1,b3,b4,b5,bh;
	JTextField t1;
	int t,num;
	GridBagLayout gb;
	GridBagConstraints gc;
	 String s[],ax1[],nx1[];
	Container c;
	JPanel jp;
    JTable tab;
	DefaultTableModel model;
	String fcont[];
	int vcount,cx1,bx1;
	String bxc;
	
	    String text="<html>"+
		"In this window you can see the list of students"+"<br>"+
		"who scored maximum marks on the criteria you choosen."+"<br>"+
		"you can also save the name list of "+"<br>"+
		"the students who scored high marks and also"+"<br>"+
		"verify their marksheet"+"<br>"+
		"</html>";
	
	/** It is parameterized. It gets two String array for getting elements of the 
	query statement, three integer variable,cx for course , bx for stream and vb for
	for marksheet , then one string variable bxb to get file content*/
		
	Vcatt(String ax[],int bx,int cx,String nx[],int vb,String bxb)
	{vcount=vb;
		bxc=bxb;
		ax1=ax;
		nx1=nx;
		bx1=bx;
		cx1=cx;
    c= this.getContentPane();
	gb = new GridBagLayout();
	c.setLayout(gb);
	gc = new GridBagConstraints();
	
	b5=new JButton("<<");
	b5.addActionListener(this);
	b5.setMnemonic('B');
	b5.setBackground(new Color(155,21,2));
	b5.setForeground(new Color(252,220,177));
	b5.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0,0,20,20);
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(b5,gc);
	c.add(b5);
	
	l1=new JLabel("TOP");
	    l1.setFont(new Font("Helvetica",Font.BOLD,25));
	    l1.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 1;
	gb.setConstraints(l1,gc);
	c.add(l1);
		
		t1=new JTextField(10);
	t1.setFont(new Font("Helvetica",Font.BOLD,25));
	t1.setForeground(new Color(252,220,177));
	t1.setBackground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 2;
	gc.gridwidth = 2;
	gb.setConstraints(t1,gc);
	c.add(t1);
		
	b1=new JButton("SHOW");
	b1.addActionListener(this);
	b1.setMnemonic('S');
	b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 3;
	gb.setConstraints(b1,gc);
	c.add(b1);
	

	
	b3=new JButton("SAVE NAMELIST");
	b3.addActionListener(this);
	b3.setMnemonic('N');
	b3.setBackground(new Color(155,21,2));
	b3.setForeground(new Color(252,220,177));
	b3.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 4;
	gb.setConstraints(b3,gc);
	c.add(b3);
	
	b4=new JButton("VERIFY MARKSHEET");
	b4.addActionListener(this);
	b4.setMnemonic('Y');
	b4.setBackground(new Color(155,21,2));
	b4.setForeground(new Color(252,220,177));
	b4.setFont(new Font("Helvetica",Font.BOLD,25));
    gc.gridx = 0;
	gc.gridy = 5;
	gb.setConstraints(b4,gc);
	c.add(b4);	
	
	    bh = new JButton("help");
	bh.addActionListener(this);
	bh.setMnemonic('H');
	bh.setBackground(new Color(155,21,2));
	bh.setForeground(new Color(252,220,177));
	bh.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 6;
	gb.setConstraints(bh,gc);
	c.add(bh);
	
	jp = new JPanel();
	jp.setLayout(gb);
	gc.gridx = 1;
	gc.gridy = 0;
	gc.gridwidth = 12;
	      gc.gridheight = 12;
    gc.fill = GridBagConstraints.BOTH;
	gb.setConstraints(jp,gc);
	c.add(jp);
	
	      model = new DefaultTableModel();
          model.setColumnIdentifiers(nx);
		  tab = new JTable();
		  tab.setModel(model);
		  tab.setRowHeight(30);
		  tab.setGridColor(Color.red);
		  tab.setFont(new Font("Arial",Font.BOLD,20));
          JScrollPane scroll = new JScrollPane(tab);
          scroll.setHorizontalScrollBarPolicy(
          JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scroll.setVerticalScrollBarPolicy(
          JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		  gc.gridwidth = 12;
	      gc.gridheight = 12;
		  gb.setConstraints(scroll,gc);
		  jp.add(scroll);
		
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	c.setBackground(new Color(252,220,177));  	
	}
/**It handles four JButtons and one JTextField and also has checking
	condition for them*/
	 
	public void actionPerformed(ActionEvent ae)
    {if(ae.getSource()==b5)
	 {
		 Vtop vt = new Vtop();
         vt.setTitle("VIEW TOPPERS");
         vt.setVisible(true);
         vt.setSize(1150,600);
		 this.dispose();
	 }
	 	 else if(ae.getSource()==bh)
	 {
			JOptionPane.showMessageDialog(this,text); 
	 }
	 else if(ae.getSource()==b1)
	 {
		 if(t1.getText().isEmpty())
		 {
		  JOptionPane.showMessageDialog(null, "Enter the top number","Error",JOptionPane.ERROR_MESSAGE);
	      }
		else
		{
		 try{
		 Object o[] = new Object[4];
		 int tcount = Integer.parseInt(t1.getText());
		 o = service.getToppersData(ax1,bx1,cx1,nx1,tcount);
		 fcont=(String[])o[2];
		 int i = (int)o[1];
		 String s1[];
		 s1 = (String[])o[3];
		 s=s1;
		 	String ss[][]=(String[][])o[0];
            int l=ss[0].length;
            int k=ss.length;			
			Object t[]=new Object[l];
            model.setRowCount(0);
	        try{
			for(int n=0;n<k;n++)
			{
             for(int m=0;m<l;m++)
			 {
             t[m]=ss[n][m];
			 }
			  model.addRow(t);
			}
			}catch(Exception e)
			{ System.out.println("No records"); }			
		 this.revalidate();
		 /*JTableHeader head = tab.getTableHeader();
	     gc.gridx = 1;
	     gc.gridy = 3;
	     gb.setConstraints(head,gc);
	     c.add(head);*/
		 
		 if(i <1)
         {
          JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
         }
         if(i ==1)
         {			
			System.out.println(i+" Record Found");
         }
         else
         {
          System.out.println(i+" Records Found");
         }
		 }
		 catch(Exception ex)
		 {
		  ex.printStackTrace();
		 }			
			 
		
		}
	}

	 else if(ae.getSource()==b3)
	 {
		 try{
		 boolean res = service.saveNamelist(bxc,fcont);
		 if(res){JOptionPane.showMessageDialog(null, "File Created");}
		 else{JOptionPane.showMessageDialog(null, "File not created");}
		 }
		 catch(Exception e){}
	 }
      
   else if (ae.getSource()==b4)
    {
	    if(vcount==1)
	    {
			for(int k=0;k<s.length;k++)
			{
				System.out.println(s[k]);
			}
         Vmark v1= new Vmark(s,vcount);
		 v1.setTitle("VIEW 12th MARKSHEET");
         v1.setVisible(true);
         v1.setSize(1150,600);
		 this.dispose();
	    }
        else
		{
			for(int k=0;k<s.length;k++)
			{
				System.out.println(s[k]);
			}
         Vmark v1 = new Vmark(s,vcount);
		 v1.setTitle("VIEW UG MARKSHEET");
         v1.setVisible(true);
         v1.setSize(1150,600);
		
		 this.dispose();
        }
    }

    }
/**It is inner class to the Vcatt class.*/
public class Vmark extends JFrame implements ActionListener
{
	JButton b1;
	int cc;
	JFrame f;
	Container c;
	Image img[];
	Object oo[];
	int count;

	/** It is parameterized and initializes one string array and an integer variable*/
    Vmark(String a[],int vcount)
	{      
        cc=a.length;
	    c= this.getContentPane();
		BorderLayout obj = new BorderLayout();
        c.setLayout(obj);
		
		  JPanel dp = new JPanel();
		  BoxLayout bbb = new BoxLayout(dp,BoxLayout.Y_AXIS);
	      dp.setLayout(bbb);
          JScrollPane scroll = new JScrollPane(dp);
          scroll.setHorizontalScrollBarPolicy(
          JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scroll.setVerticalScrollBarPolicy(
          JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		  c.add("Center",scroll);
		
	b1=new JButton("BACK");
	b1.addActionListener(this);
	b1.setMnemonic('B');
	b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
    c.add("North",b1);
	
	 try 
		{	  
          oo = service.getImages(a,vcount);
		  ImageIcon ic[] =new ImageIcon[oo.length];
		  JLabel jb[] = new JLabel[oo.length];
		   for(int i=0;i<oo.length;i++)
		   {
			ic[i] = (ImageIcon)oo[i];
			jb[i] = new JLabel(ic[i]);
			dp.add(jb[i]);
		   }
			/*MediaTracker track = new MediaTracker(this);
		   for(int k=0;k<oo.length;k++)
		   {
			track.addImage(img[k],k);
		   }
			try{
		 for(int k1=0;k1<oo.length;k1++)
		   {
				track.waitForID(k1);
		   }
			}catch(InterruptedException ie){ ie.printStackTrace();}*/
		   
	
		}catch (Exception i)
        {
			 i.printStackTrace();
        }
	     
	      //Drawpic dp = new Drawpic(img,cc);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setBackground(new Color(252,220,177));
	}
	/**It handles one JButton to go back.*/
	 
	public void actionPerformed(ActionEvent ae)
    {if(ae.getSource()==b1)
	 {
		 Vcatt vc = new Vcatt(ax1,bx1,cx1,nx1,vcount,bxc);
         vc.setTitle("SELECT CATEGORY");
         vc.setVisible(true);
         vc.setSize(1150,600);
		 this.dispose();
	 }
    }
	
	/**It is inner class to the Vmark class. It extends JPanel.*/
/*	public class Drawpic extends JPanel
   {
	
	int cou;
	Image img[];
	/**It is parameterized and initializes Image object and one integer variable to 
	get the image count.
		
	Drawpic(Image a[],int b)
	{img=a;
		cou=b;
	}
	/**It paints the images on the JPanel  
	   
	public void paintComponent(Graphics g)
	{ int pos=10;
        super.paintComponent(g);	
		g.setColor(new Color(252,220,177));
		  g.fillRect(0,0,this.getWidth(),this.getHeight());
		for(int i=0;i<cou;i++)
        {
		    g.drawImage(img[i],200,pos,800,800,null);
            pos=pos+600;			
		}     
		
	}
	
   }*///End Drawpic
}//End Vmark

}//End Vcatt
	
}//End Vtop

/** It is inner class to the Homef class.*/
public class Sms1 extends JFrame implements ActionListener
{
	
	JButton b1,b2,bh;
	JLabel l1;
	JTextArea t1;
	GridBagLayout gb;
	GridBagConstraints gc;
	
		    String text="<html>"+
		"In this window you can save the message"+"<br>"+
		"you type so that that message can be "+"<br>"+
		"displayed on the webpage that the students"+"<br>"+
		"use to apply form."+"<br>"+
		"</html>";
	
/**It is non-parameterized and initializes 2 JButton, 1 JLabel and 1 JTextArea.*/	
	
	Sms1()
	{
	
	Container c= this.getContentPane();
	gb = new GridBagLayout();
	c.setLayout(gb);
	gc = new GridBagConstraints();

    bh = new JButton("help");
	bh.addActionListener(this);
	bh.setMnemonic('H');
	bh.setBackground(new Color(155,21,2));
	bh.setForeground(new Color(252,220,177));
	bh.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 5;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_END;
	gb.setConstraints(bh,gc);
	c.add(bh);
	
	b1=new JButton("<<");
	b1.addActionListener(this);
	b1.setMnemonic('B');
		b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0,0,20,20);
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(b1,gc);
	c.add(b1);
	
	l1=new JLabel("TYPE THE MESSEGE");
	    l1.setFont(new Font("Helvetica",Font.BOLD,34));
	   l1.setForeground(new Color(155,21,2));
	gc.gridx = 1;
	gc.gridy = 1;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.gridwidth = 2;
	gb.setConstraints(l1,gc);
	c.add(l1);
	
	t1=new JTextArea(3,10);
	t1.setBackground(new Color(155,21,2));
	t1.setForeground(new Color(252,220,177));
	t1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 1;
	gc.gridy = 2;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0,50,20,20);
	gc.gridwidth = 1;
	gb.setConstraints(t1,gc);
	c.add(t1);
		
	
	
	b2=new JButton("SEND");
	b2.addActionListener(this);
	b2.setMnemonic('D');
	b2.setBackground(new Color(155,21,2));
	b2.setForeground(new Color(252,220,177));
	b2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 1;
	gc.gridy = 3;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0,100,20,20);
	gc.gridwidth = 1;
	gb.setConstraints(b2,gc);
	c.add(b2);
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	c.setBackground(new Color(252,220,177));
		
	}
	/**It handles the 2 JButton,one to go back and another to call server for creating message file.*/
	
	public void actionPerformed(ActionEvent ae)
    { if(ae.getSource()==b1)
	 {		
            Homef hf = new Homef();
			hf.setTitle("DATA PROCESSOR");
			hf.setVisible(true);
			hf.setSize(1150,600);
			this.dispose();		 
	 }
	 	 else if(ae.getSource()==bh)
	 {
			JOptionPane.showMessageDialog(this,text); 
	 }
     else if(ae.getSource()==b2)
	 {
	    if(t1.getText().isEmpty())
		{
			  JOptionPane.showMessageDialog(null, "Enter the message","Error",JOptionPane.ERROR_MESSAGE);
		}
	    else
	    {
		 try{
		 String txt = t1.getText();
		 boolean res = service.saveMessage(txt);
		 if(res){JOptionPane.showMessageDialog(null, "File Created");}
		 else{JOptionPane.showMessageDialog(null, "File not created");}
		 }
		 catch(Exception e){}
		}
	 }
   }
}//End Sms1
/** It is inner class to the Homef class.*/
public class Qb1 extends JFrame implements ActionListener,ItemListener
{
	
	JButton b1,b2,bh;
	JLabel l1,l2,l3;
    JPanel jp1,jp2;
	JTextField t1;
	GridBagLayout gb;
	GridBagConstraints gc;
	JRadioButton r1,r2,r3,r4,r5,r6,r7;
	JCheckBox j[];
	ButtonGroup bg;
	String sx[],sz[];
	int s;int xx=0,xy=0;
	int t11=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0;
	Container c;
	    String text="<html>"+
		"In this window you can the select the tables "+"<br>"+
		"you want and also the fields in the table so"+"<br>"+
		"that you can view the contents of the choosen"+"<br>"+
		"tables and fields in the database."+"<br>"+
		"</html>";
	
/** It is a non-parameterized constructor and initializes 7 JRadioButton, 1 JCheckBox array for 45 JCheckBoxes, 2 JButton, 3 JLabel and 2 JPanel*/
		
	Qb1()
	{
	c= this.getContentPane();
	gb = new GridBagLayout();
	c.setLayout(gb);
	gc = new GridBagConstraints();

		
    bh = new JButton("help");
	bh.addActionListener(this);
	bh.setMnemonic('H');
	bh.setBackground(new Color(155,21,2));
	bh.setForeground(new Color(252,220,177));
	bh.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 5;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_END;
	gb.setConstraints(bh,gc);
	c.add(bh);		
		
		r1= new JRadioButton("UGMAJORS");
		r1.addActionListener(this);
        r2= new JRadioButton("PGMAJORS");
		r2.addActionListener(this);
        r3= new JRadioButton("TWELVETHGROUPS");
		r3.addActionListener(this);
        r4= new JRadioButton("NATIVEDISTRICTS");
		r4.addActionListener(this);
        r5= new JRadioButton("STUDENTDETAIL");
		r5.addActionListener(this);
        r6= new JRadioButton("TMARKDETAIL");
		r6.addActionListener(this);
        r7= new JRadioButton("UGMARKDETAIL");
		r7.addActionListener(this);
		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		bg.add(r5);
		bg.add(r6);
		bg.add(r7);
		
		j = new JCheckBox[45];
		j[0] = new JCheckBox("TMARKDETAIL.STUDID");
		j[1] = new JCheckBox("GROUPID");
        j[2] = new JCheckBox("SUB1");
        j[3] = new JCheckBox("SUB2");
        j[4] = new JCheckBox("SUB3");
        j[5] = new JCheckBox("SUB4");
        j[6] = new JCheckBox("SUB5");
        j[7] = new JCheckBox("SUB6");
        j[8] = new JCheckBox("TOTAL");
        j[9] = new JCheckBox("TMARKDETAIL.UGID  AS  TUG");
		j[10] = new JCheckBox("STREAM");
	

        j[11] = new JCheckBox("UGMARKDETAIL.STUDID");
		j[12] = new JCheckBox("UGID");
        j[13] = new JCheckBox("PGID");
        j[14] = new JCheckBox("PERCENTAGE");
        j[15] = new JCheckBox("STREAM");
	
		
		j[16] = new JCheckBox("UGMAJORS.UGID  AS  UGG");
		j[17] = new JCheckBox("UGMAJORS.MAJORS  AS  UGM");
		               
		
		j[18] = new JCheckBox("PGMAJORS.PGID  AS  PGG");
		j[19] = new JCheckBox("PGMAJORS.MAJORS  AS  PGM");

		j[20] = new JCheckBox("GROUPID");
		j[21] = new JCheckBox("GROUPS");

		
		j[22] = new JCheckBox("NDID");
		j[23] = new JCheckBox("NATIVEDISTRICTS");

		
		j[24] = new JCheckBox("STUDENTDETAIL.STUDID");
		j[25] = new JCheckBox("NAME");
		j[26] = new JCheckBox("DOB");
		j[27] = new JCheckBox("FNAME");
		j[28] = new JCheckBox("FOCCUP");
		j[29] = new JCheckBox("MNAME");
		j[30] = new JCheckBox("MOCCUP");
		j[31] = new JCheckBox("STREET");
		j[32] = new JCheckBox("AREA");
		j[33] = new JCheckBox("PINCODE");
		j[34] = new JCheckBox("MOBNO");
		j[35] = new JCheckBox("EMAIL");
		j[36] = new JCheckBox("NATIONALITY");
		j[37] = new JCheckBox("MTONGUE");
		j[38] = new JCheckBox("RELIGION");
		j[39] = new JCheckBox("COMMUNITY");
		j[40] = new JCheckBox("GENDER");
		j[41] = new JCheckBox("CASTEID");
		j[42] = new JCheckBox("NDID");
		for(int i=0;i<42;i++)
		{  
			j[i].addItemListener(this);
		}
		
	b1=new JButton("<<");
	b1.addActionListener(this);
	b1.setMnemonic('B');
	b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.insets = new Insets(0,0,20,20);
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(b1,gc);
	c.add(b1);
	
	l1=new JLabel("CHOOSE THE TABLE");
	l1.setFont(new Font("Helvetica",Font.BOLD,25));
    l1.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 1;
	gc.anchor = GridBagConstraints.CENTER;
	gb.setConstraints(l1,gc);
	c.add(l1);
	
	l2=new JLabel("CHOOSE THE FIELD");
	l2.setFont(new Font("Helvetica",Font.BOLD,25));
	l2.setForeground(new Color(155,21,2));
	gc.gridx = 1;
	gc.gridy = 1;
	gc.anchor = GridBagConstraints.CENTER;
	gb.setConstraints(l2,gc);
	c.add(l2);
	
	l3=new JLabel("ENTER THE CONDITION");
	l3.setFont(new Font("Helvetica",Font.BOLD,25));
	l3.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 3;
	gc.insets = new Insets(0,70,0,0);
	gb.setConstraints(l3,gc);
	c.add(l3);
	
	b2=new JButton("SHOW");
	b2.addActionListener(this);
	b2.setMnemonic('S');
	b2.setBackground(new Color(155,21,2));
	b2.setForeground(new Color(252,220,177));
	b2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 2;
	gc.gridy = 4;
	gc.anchor = GridBagConstraints.CENTER;
	gc.insets = new Insets(0,60,20,100);
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(b2,gc);
	c.add(b2);
	
	t1=new JTextField(10);
	t1.setFont(new Font("Helvetica",Font.BOLD,25));
	t1.setBackground(new Color(155,21,2));
	t1.setForeground(new Color(252,220,177));
	gc.gridx = 1;
	gc.gridy = 3;
	 gc.fill = GridBagConstraints.HORIZONTAL;
	gb.setConstraints(t1,gc);
	c.add(t1);
	
			jp1 = new JPanel();
		BoxLayout bx1 = new BoxLayout(jp1,BoxLayout.Y_AXIS);
	jp1.setLayout(bx1);
	gc.gridx = 0;
	gc.gridy = 2;
	gc.fill = GridBagConstraints.BOTH;
	gc.insets = new Insets(0,70,0,0);
	gb.setConstraints(jp1,gc);
	jp1.add(r1);
	jp1.add(r2);
	jp1.add(r3);
	jp1.add(r4);
	jp1.add(r5);
	jp1.add(r6);
	jp1.add(r7);
	c.add(jp1);
	
		jp2= new JPanel();
		BoxLayout bx2 = new BoxLayout(jp2,BoxLayout.Y_AXIS);
	jp2.setLayout(bx2);
	gc.gridx = 1;
	gc.gridy = 2;
	gc.insets = new Insets(0,80,0,0);
	  JScrollPane scroll = new JScrollPane(jp2);
          scroll.setHorizontalScrollBarPolicy(
          JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scroll.setVerticalScrollBarPolicy(
          JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    gc.fill = GridBagConstraints.BOTH;
	gb.setConstraints(scroll,gc);
	c.add(scroll);
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	c.setBackground(new Color(252,220,177));
	}
	/** It is to get the count of selected checkboxes*/
		
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
			s++;
		}
		else 
		{
			s--;
		}
	}
	/** It handles 7 JRadioButton, 45 JCheckBoxes, 2 JButton and also checking condition for the 
	checkboxes*/
	public void actionPerformed(ActionEvent ae)
    {
	 if(ae.getSource()==b1)
	 {
		 Homef hf = new Homef();
			hf.setTitle("DATA PROCESSOR");
			hf.setVisible(true);
			hf.setSize(1150,600);
		 this.dispose();
	 }
	 	 else if(ae.getSource()==bh)
	 {
			JOptionPane.showMessageDialog(this,text); 
	 }
	 else if (ae.getSource()==b2)
     {
		 sx = new String[s];
		 int yy=0;
		 int t111=0,t12=0,t13=0,t14=0,t15=0,t16=0,t17=0;
		 for(int ac=0;ac<42;ac++)
		 {
			  
		  if(j[ac].getModel().isSelected())
			 {
				 if((ac>=24) && (ac<=42) && (t111==0)){t111=1;yy++;}
				 else if((ac>=0) && (ac<=10) && (t12==0)){t12=1;yy++;}
				 else if((ac>=11) && (ac<=15) && (t13==0)){t13=1;yy++;}
				 else if((ac>=16) && (ac<=17) && (t14==0)){t14=1;yy++;}
				 else if((ac>=18) && (ac<=19) && (t15==0)){t15=1;yy++;}
				 else if((ac>=20) && (ac<=21) && (t16==0)){t16=1;yy++;}
				 else if((ac>=22) &&( ac<=23) && (t17==0)){t17=1;yy++;}
			 }
		 }
		 sz = new String[yy];
		 
		 xx=0;
		 for(int a=0;a<42;a++)
		 {
			  
			 if(j[a].getModel().isSelected())
			 {
				 
				 if((a>=24) && (a<=42) && (t11==0)){sz[xx]="STUDENTDETAIL";t11=1;xx++;}
				 else if((a>=0) && (a<=10) && (t2==0)){sz[xx]="TMARKDETAIL";t2=1;xx++;}
				 else if((a>=11) && (a<=15) && (t3==0)){sz[xx]="UGMARKDETAIL";t3=1;xx++;}
				 else if((a>=16) && (a<=17) && (t4==0)){sz[xx]="UGMAJORS";t4=1;xx++;}
				 else if((a>=18) && (a<=19) && (t5==0)){sz[xx]="PGMAJORS";t5=1;xx++;}
				 else if((a>=20) && (a<=21) && (t6==0)){sz[xx]="TWELVETHGROUPS";t6=1;xx++;}
				 else if((a>=22) &&( a<=23) && (t7==0)){sz[xx]="NATIVEDISTRICTS";t7=1;xx++;}
				 sx[xy]=j[a].getText();
				 xy++;
				 
			 }
		 } 
		 boolean set=false;
		 for(int md=0;md<42;md++)
		 {
			 
			 if(j[md].isSelected())
			 {
				 set=true;
			 }
		 }
		 if(set)
		 {
		 String ss;
		 if(t1.getText().equals("")){ss=null;}
		else{ss=t1.getText();}
      Qv q2 = new Qv(sx,sz,ss);
      q2.setTitle("QUERY RESULT");
      q2.setVisible(true);
      q2.setSize(1150,600);
      this.dispose();
		 }
		 else{  
		 JOptionPane.showMessageDialog(null, "select any field","Error",JOptionPane.ERROR_MESSAGE);
		 }
//q2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
	  if(r1.getModel().isSelected())
	  {
		   
			   jp2.add(j[16]);
			   jp2.add(j[17]);
			   j[16].setVisible(true);
			   j[17].setVisible(true);
	for(int i1=0;i1<=15;i1++){j[i1].setVisible(false);}
		   for(int i2=18;i2<=42;i2++){j[i2].setVisible(false);}
		  jp2.revalidate();
	  }
	  if(r2.getModel().isSelected())
	  {
		   jp2.add(j[18]);
		  jp2.add(j[19]);
		   j[18].setVisible(true);
			   j[19].setVisible(true);
		  for(int i1=0;i1<=17;i1++){j[i1].setVisible(false);}
		   for(int i2=20;i2<=42;i2++){j[i2].setVisible(false);}
		  jp2.revalidate();
	  }
	  if(r3.getModel().isSelected())
	  {
		  jp2.add(j[20]);
		  jp2.add(j[21]);
		   j[20].setVisible(true);
			   j[21].setVisible(true);
		  for(int i1=0;i1<=19;i1++){j[i1].setVisible(false);}
		   for(int i2=22;i2<=42;i2++){j[i2].setVisible(false);}
		  jp2.revalidate();
	  }
	  if(r4.getModel().isSelected())
	  {
		  jp2.add(j[22]);
		  jp2.add(j[23]);
		   j[22].setVisible(true);
			   j[23].setVisible(true);
		  for(int i1=0;i1<=21;i1++){j[i1].setVisible(false);}
		   for(int i2=24;i2<=42;i2++){j[i2].setVisible(false);}
		  jp2.revalidate();
	  }
	 
	  if(r5.getModel().isSelected())
	  {
		    for(int i=24;i<=42;i++)
		   {
			   jp2.add(j[i]);
			   j[i].setVisible(true);
		   }for(int i1=0;i1<=23;i1++){j[i1].setVisible(false);}
		  jp2.revalidate();
	  }
	  if(r6.getModel().isSelected())
	  {
		   for(int i=0;i<=10;i++)
		   {
			   jp2.add(j[i]);
			   j[i].setVisible(true);
		   }
		   for(int i1=11;i1<=42;i1++){j[i1].setVisible(false);}
		   jp2.revalidate();
	  }
	  if(r7.getModel().isSelected())
	  {
		     for(int i=11;i<=15;i++)
		   {
			   jp2.add(j[i]);
			   j[i].setVisible(true);
		   }
		   for(int i1=0;i1<=10;i1++){j[i1].setVisible(false);}
		   for(int i2=16;i2<=42;i2++){j[i2].setVisible(false);}
		  jp2.revalidate();
	  }
	}


/**It is inner class to the Qb1 class*/
public class Qv extends JFrame implements ActionListener
{
	
	JButton b1;
	GridBagLayout gb;
	GridBagConstraints gc;
	String s1[];
	String s2[];
    String s3;
	
	JPanel jp;
    JTable tab;
	DefaultTableModel model;
	int num1,num2;
	String xy;
	/**It is parameterized and initializes 1 JButton,JPanel and JTable.
   It parameters are 2 String array to get elements of the query statement and
   one String variable to get where condition of query statement*/
 
	Qv(String sx[],String sy[],String xx)
   {s1=sx;
 s2=sy;
 s3=xx;
	Container c= this.getContentPane();
	gb = new GridBagLayout();
	c.setLayout(gb);
	gc = new GridBagConstraints();
	
	jp = new JPanel();
	jp.setLayout(gb);
	gc.gridx = 1;
	gc.gridy = 0;
	gc.gridwidth = 20;
	gc.gridheight = 20;
    gc.fill = GridBagConstraints.HORIZONTAL;
	gb.setConstraints(jp,gc);
	c.add(jp);
	
			b1=new JButton("BACK");
	b1.addActionListener(this);
	b1.setMnemonic('B');
	b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 1;
	gc.gridy = 1;
	gc.anchor = GridBagConstraints.PAGE_END;
	gc.insets = new Insets(0,0,50,0);
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(b1,gc);
	c.add(b1);
	
	      model = new DefaultTableModel();
          model.setColumnIdentifiers(s1);
		  tab = new JTable();
		  tab.setModel(model);
		  gc.insets = new Insets(0,50,0,50);
		  tab.setRowHeight(30);
		  tab.setGridColor(Color.red);
		  tab.setFont(new Font("Arial",Font.BOLD,20));
		 tab.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

          JScrollPane scroll = new JScrollPane(tab);
          scroll.setHorizontalScrollBarPolicy(
          JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scroll.setVerticalScrollBarPolicy(
          JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		  gc.insets = new Insets(0,50,0,50);
		  gc.gridwidth = 20;
	      gc.gridheight = 20;
		  gc.fill = GridBagConstraints.BOTH;
		  gb.setConstraints(scroll,gc);	
		  jp.add(scroll);
	        
			try
			{
			    Object o[] = new Object[3];
				o = service.getQueryResult(s1,s2,s3);
				int k = (int)o[1];
			    int l = (int)o[2];
			
			String s[][]=(String[][])o[0];			
			Object t[]=new Object[l];
            model.setRowCount(0);
			for(int n=0;n<k;n++)
			{
             for(int m=0;m<l;m++)
			 {
             t[m]=s[n][m];
			 }
			  model.addRow(t);
			}
			
		    if(k <1)
            {
               JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
            }
            if(k ==1)
            {
               System.out.println(k+" Record Found");
            }
            else
            {
               System.out.println(k+" Records Found");
            }
     
	        }
			catch(Exception ex)
			{
				ex.printStackTrace();
			}			
    this.revalidate();	
	c.setBackground(new Color(252,220,177));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	  public void actionPerformed(ActionEvent ae)
      {/** It handles one JButton to go back*/
	    if(ae.getSource()==b1)
	    {
		 Qb1 q1 = new Qb1();
         q1.setTitle("QUERY BUILDER");
         q1.setVisible(true);
         q1.setSize(1150,600);
		 this.dispose();
	    }
       }
}//End Qv
	
}//End Qb1
		
} // End Homef    

}// End StartLogin
	