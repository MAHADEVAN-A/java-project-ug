import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.InputStream;
import java.sql.*; 
import java.io.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
class Fcount extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JButton b1;
	GridBagLayout gb;
	GridBagConstraints gc;
	int slices[];
	String u[],s;
	Color scolor[];
	int k=0;
	String ad[];
	String g1[] = new String[2];
	/*public static void main(String args[])
	{
		String a[]={"hello","maha","deva","sasi","mird","bird","dog","lol"};
		int a1=2;
		String x="maha";
Fcount fc = new Fcount(a,a1,x);
fc.setTitle("FORM COUNTER");
fc.setVisible(true);
fc.setSize(1150,600);
//fc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}*/
	
	Fcount(String a[],int a1,String x)
	{
		ad=a;
		//JOptionPane.showMessageDialog(null,"SELECT  "+a[0]+"   as   "+a[1]+"  ,   count(*)   as    NUMOFSTUD  FROM  "+a[2]+" , "+a[3]+"  WHERE  "+a[4]+" = "+a[5]+"   AND  STREAM = "+a1+"  AND "+a[6]+" = "+a[7]+"   group by "+a[0],"Password",1);
	Container c= this.getContentPane();
	gb = new GridBagLayout();
	c.setLayout(gb);
	gc = new GridBagConstraints();
	for(int aa=0;aa<a.length;aa++)
	{
    System.out.println(a[aa]);	
	}
	System.out.println(a1);
	b1=new JButton("<<");
	b1.addActionListener(this);
	b1.setBackground(new Color(155,21,2));
	b1.setForeground(new Color(252,220,177));
	b1.setFont(new Font("Helvetica",Font.BOLD,25));
	gc.gridx = 0;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_START; 
	gc.weighty = 0.7;
	gc.weightx = 0.7;
	gb.setConstraints(b1,gc);
	c.add(b1);
	
	
		try 
		{	
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","thebookofmirdad");
        Statement stmt = con.createStatement();
		System.out.println("hello4");
        ResultSet query_set1 = stmt.executeQuery("SELECT  count(*)   as    NUMOFSTUD  FROM  "+a[2]+" , "+a[3]+"  WHERE  "+a[4]+"  =  "+a[5]+"   AND  STREAM = "+a1+"  AND   "+a[6]+"  =  "+a[7]);
         while (query_set1.next())
		 {
		 int num = query_set1.getInt("NUMOFSTUD");
		 Integer i = new Integer(num);
		 s = i.toString();
		 }
		 System.out.println("hello2");
         ResultSet query_set = stmt.executeQuery("SELECT  "+a[0]+"   as   STUDIED   ,   count(*)   as    NUMOFSTUD  FROM  "+a[2]+" , "+a[3]+"  WHERE  "+a[4]+"  =  "+a[5]+"   AND  STREAM = "+a1+"  AND   "+a[6]+"  =  "+a[7]+"   GROUP BY  "+a[0]);
      System.out.println("hello3");
	  
	  if(a[0].equals("UGMAJORS.MAJORS"))
		{
			Color scol[]=new Color[10];
			String ll[]= new String[10];
			int lk[]=new int[10];
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
		u=ll;
		slices=lk;
		}
		else
		{
			Color scol[]=new Color[3];
			String ll[]= new String[3];
			int lk[]=new int[3];
		scol[0]=Color.pink;
		scol[1]=Color.green;
		scol[2]=Color.blue;
		scolor = scol;
		g1[0]="MALE";
		g1[1]="FEMALE";
		slices=lk;
		u=ll;
		}
		
		System.out.println("hello5");
		for(int k=0;k<scolor.length;k++)
		{
			System.out.println(scolor[k]);
		}
		
		
   		 while (query_set.next())
		 {
            String sk = query_set.getString("STUDIED");
			System.out.println(sk);
			u[k]=sk;
			System.out.println(u[k]);
            slices[k] = query_set.getInt("NUMOFSTUD");
			System.out.println(slices[k]);
			k++;
         }
        for(int i=0;i<u.length;i++)
		{
			System.out.println(u[i]);
		}
		for(int j=0;j<slices.length;j++)
		{
			System.out.println(slices[j]);
		}
         //this.repaint();
		 this.revalidate();
         query_set.close();
         stmt.close(); 
         con.close();

		}catch (Exception i)
        {
                         System.out.println(i);
        }           

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    c.setBackground(new Color(252,220,177));
		
	}
	  public void paint(Graphics g) 
   {
	   	  g.setColor(new Color(252,220,177));
	  g.fillRect(0,0,this.getWidth(),this.getHeight());
        
      double total = 0.0D;
      for (int i = 0; i < slices.length; i++) {
         total += slices[i];
	  }
      
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < slices.length; i++) {
         startAngle = (int) (curValue * 360 / total);
         int arcAngle = (int) (slices[i] * 360 / total);
         g.setColor(scolor[i]);
         g.fillArc(250,150, 400, 400, startAngle, arcAngle);
         curValue += slices[i];
      }
	  Font f  = new Font("Helvetica",Font.BOLD,25);
	  g.setFont(f);
	  g.setColor(new Color(155,21,2));
	  g.drawString("FORM COUNT",100,100);
	  g.setFont(f);
	  g.drawString(s,300,100);
	  int arr[];
	   if(ad[0].equals("UGMAJORS.MAJORS"))
		{
	  int ar[]={150,170,190,210,230,250,270,290,310,330};
	  arr=ar;
		     for(int m=0;m<k;m++)
	  {
		  g.setColor(scolor[m]);
		  g.fillRect(650,arr[m],5,5);
		  g.drawString(u[m],700,arr[m]);
	  }
		}
		else{
			int ar[]={150,170,190};
			arr=ar;
		     for(int m=0;m<k;m++)
	  {
		  g.setColor(scolor[m]);
		  g.fillRect(650,arr[m],5,5);
		  g.drawString(g1[m],700,arr[m]);
	  }
		}
	
	
	  
	 
   }
	public void actionPerformed(ActionEvent ae)
    {
	 if(ae.getSource()==b1)
	 {
		/* Analys as = new Analys();
        as.setTitle("ANALYSIS");
        as.setVisible(true);
        as.setSize(1150,600);*/
		 this.dispose();
	 }
    }
}