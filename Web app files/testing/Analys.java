import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Analys extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4;
	JButton b1,b2;
	JComboBox bx1,bx2,bx3,bx4;
	GridBagLayout gb;
	GridBagConstraints gc;
	    String s1[] = new String[10];
    
	int a1;
    String s2[] = new String[10];
   
	String s3[] = new String[10];
	String a[] = new String[8];
	Container c= this.getContentPane();
	String x;
	public static void main(String args[])throws Exception
	{
		Analys as = new Analys();
        as.setTitle("ANALYSIS");
        as.setVisible(true);
        as.setSize(1150,600);
	}
	
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
	
	b1=new JButton("<<");
	b1.addActionListener(this);
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
	//l1.setBounds(400,50,500,50);
	l1.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 1;
	//gc.anchor = GridBagConstraints.CENTER;
	//gc.gridwidth = 2;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(l1,gc);
	c.add(l1);
	
	l2=new JLabel("SELECT THE STREAM");
	l2.setFont(new Font("Helvetica",Font.BOLD,25));
	l2.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 2;
	//gc.anchor = GridBagConstraints.CENTER;
	//gc.gridwidth = 2;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(l2,gc);
	c.add(l2);
	
	l3=new JLabel("SELECT THE MAJOR",JLabel.LEFT);
	l3.setFont(new Font("Helvetica",Font.BOLD,25));
	l3.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 3;
	//gc.anchor = GridBagConstraints.CENTER;
	//gc.gridwidth = 2;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(l3,gc);
	c.add(l3);
	
	l4=new JLabel("SELECT THE TYPE",JLabel.RIGHT);
	l4.setFont(new Font("Helvetica",Font.BOLD,25));
	l4.setForeground(new Color(155,21,2));
	gc.gridx = 0;
	gc.gridy = 4;
	//gc.anchor = GridBagConstraints.CENTER;
	//gc.gridwidth = 2;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(l4,gc);
	c.add(l4);
		
	
	
	b2=new JButton("SHOW");
	b2.addActionListener(this);
	b2.setBackground(new Color(155,21,2));
	b2.setForeground(new Color(252,220,177));
	b2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 2;
	gc.gridy = 6;
	//gc.anchor = GridBagConstraints.CENTER;
	//gc.gridwidth = 1;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(b2,gc);
	c.add(b2);
	
	bx1 = new JComboBox();
	bx1.addItem("UG");
	bx1.addItem("PG");
	bx1.addActionListener(this);
	bx1.setBackground(new Color(155,21,2));
	bx1.setForeground(new Color(252,220,177));
	bx1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 4;
	gc.gridy = 1;
	//gc.anchor = GridBagConstraints.CENTER;
	//gc.gridwidth = 1;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(bx1,gc);
	c.add(bx1);
	
	bx2 = new JComboBox();
	bx2.addItem("REGULAR");
	bx2.addItem("SELF-FINANCE");
	bx2.addActionListener(this);
	bx2.setBackground(new Color(155,21,2));
	bx2.setForeground(new Color(252,220,177));
	bx2.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 4;
	gc.gridy = 2;
	//gc.anchor = GridBagConstraints.CENTER;
	//gc.gridwidth = 1;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(bx2,gc);
	c.add(bx2);
	
	bx3 = new JComboBox();
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
	//gc.anchor = GridBagConstraints.CENTER;
	//gc.gridwidth = 1;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(bx3,gc);
	c.add(bx3);
	
	bx4 = new JComboBox();
	bx4.addItem("GENDER");
	bx4.addItem("GROUP");
	bx4.addActionListener(this);
	bx4.setBackground(new Color(155,21,2));
	bx4.setForeground(new Color(252,220,177));
	bx4.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 4;
	gc.gridy = 4;
	//gc.anchor = GridBagConstraints.CENTER;
	//gc.gridwidth = 1;
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(bx4,gc);
	c.add(bx4);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
		
	c.setBackground(new Color(252,220,177));
	}
	public void actionPerformed(ActionEvent ae)
    {
		if(ae.getSource() == bx1)
		{
			 
			//JOptionPane.showMessageDialog(null,"IAM IN CATEGROY","Password",1);
			String str=(String)bx1.getSelectedItem();
			if(str.equals("UG"))
			{
				//JOptionPane.showMessageDialog(null,"UG IS CLICKED","Password",1);
				s3=s1;
				String st=(String)bx3.getItemAt(0);
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
			a[3]="TMARKDETAILS";
			a[4]="TWELVETHGROUPS.GroupID";
			a[5]="TMARKDETAILS.GroupID";
			a[6]="UGID";				
			}
			else
			{
				//JOptionPane.showMessageDialog(null,"PG IS CLICKED","Password",1);
				s3=s2;
				String st=(String)bx3.getItemAt(0);
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
			a[3]="UGMARKDETAILS";
			a[4]="UGMAJORS.UGID";
			a[5]="UGMARKDETAILS.UGID";
			a[6]="PGID";
			}
			
		}
		else if(ae.getSource() == bx2)
		{
			//JOptionPane.showMessageDialog(null,"IAM IN STREAM","Password",1);
			String str=(String)bx2.getSelectedItem();
			if(str.equals("REGULAR"))
			{
			//	JOptionPane.showMessageDialog(null,"IAM IN REGUALR","Password",1);
				a1 = 1;
			}
			else
			{
			//	JOptionPane.showMessageDialog(null,"IAM IN SELF","Password",1);
				a1 = 2;
			}
		}
		else if(ae.getSource() == bx3)
		{
		//	JOptionPane.showMessageDialog(null,"IAM IN MAJOR","Password",1);
			String str=(String)bx1.getSelectedItem();
			if(str.equals("UG"))
			{
		//		JOptionPane.showMessageDialog(null,"IAM IN SWITCH 1","Password",1);
			String str1=(String)bx3.getSelectedItem();
		//	JOptionPane.showMessageDialog(null,str1,"Password",1);
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
		//		JOptionPane.showMessageDialog(null,"IAM IN SWITCH 2","Password",1);
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
			//JOptionPane.showMessageDialog(null,"IAM IN BX4","Password",1);
			String str2=(String)bx4.getSelectedItem();
			if(str2.equals("GENDER"))
			{
				//JOptionPane.showMessageDialog(null,"GENDER IS CLICKED","Password",1);
			String str=(String)bx1.getSelectedItem();
			 if(str.equals("UG"))
			 {
				//JOptionPane.showMessageDialog(null,"GENDER IS CLICKED","Password",1);
				a[0]="STUDENTDETAILS.Gender";
				a[1]="Gender";
				a[2]="STUDENTDETAILS";
				a[4]="STUDENTDETAILS.StudID";
				a[5]="TMARKDETAILS.StudID";
				x="GENDER  1.MALE   2.FEMAIL";
			 }
			 else
			 {
				//JOptionPane.showMessageDialog(null,"GENDER IS CLICKED","Password",1);
				a[0]="STUDENTDETAILS.Gender";
				a[1]="Gender";
				a[2]="STUDENTDETAILS";
				a[4]="STUDENTDETAILS.StudID";
				a[5]="UGMARKDETAILS.StudID";
				x="GENDER  1.MALE   2.FEMAIL";
			 }	
			}			
		}
	else if(ae.getSource()==b1)
	 {
        /* Homef hf = new Homef();
			hf.setTitle("DATA PROCESSOR");
			hf.setVisible(true);
			hf.setSize(1150,600);*/
		 this.dispose();
	 }
     else if (ae.getSource()==b2)
     {
		 try
		 {
      Fcount fc = new Fcount(a,a1,x);
      fc.setTitle("FORM COUNTER");
      fc.setVisible(true);
      fc.setSize(1150,600);
		 }catch (Exception i)
        {
                         System.out.println(i);
        }
	  this.dispose();
      //fc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}

}
