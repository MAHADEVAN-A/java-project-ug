import java.rmi.*;
import java.rmi.server.*;
import java.sql.*; 
import java.io.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
import java.util.*;
public class MyRemoteService extends UnicastRemoteObject implements MyRemote
{
	public MyRemoteService() throws RemoteException { }
	
  	 	 
	public Object[] getQueryResult(String sx[],String sy[],String xx)
	{
		int num1 = sx.length;
	    int num2 = sy.length;
		int count=0;
		String ss,st;
		ss = " ";
	    Object o[] = new Object[3];
		for(int i=0;i<sx.length;i++)
		{
			if(i==num1-1){ss = ss + sx[i];}
			else{ss = ss + sx[i] + ",";} 
		}
		st=" ";
		for(int k=0;k<sy.length;k++)
		{
			if(k==num2-1){st = st + sy[k];}
			else{st = st + sy[k] + ",";} 
		}
	   try 
		{	
		  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","thebookofmirdad");
          Statement stmt = con.createStatement();
		  stmt.setFetchSize(250);
		ResultSet query_set1;
		if(xx==null)
		{
			query_set1 = stmt.executeQuery("SELECT  count(*) as COUNT FROM "+st);
		}
		else
		{
		    query_set1 = stmt.executeQuery("SELECT  count(*) as COUNT  FROM "+st+" WHERE "+xx);
		}
		while (query_set1.next())
		 {
		  count=query_set1.getInt("COUNT");	
		 }
        ResultSet query_set;
		  long t1 = System.currentTimeMillis();
		if(xx==null)
		{
			query_set = stmt.executeQuery("SELECT  "+ss+" FROM "+st);
			System.out.println("SELECT  "+ss+" FROM "+st);
		}
		else
		{
		    query_set = stmt.executeQuery("SELECT  "+ss+" FROM "+st+" WHERE "+xx);
			System.out.println("SELECT  "+ss+" FROM "+st+" WHERE "+xx);
		}
		  long t2 = System.currentTimeMillis();
		  System.out.println("Time= "+(t2-t1));
		String s3[][] = new String[count][num1];		 
		int k=0;
   		while (query_set.next())
		 {
			 for(int bb=0;bb<num1;bb++)
			 {  
		     if(sx[bb].equals("STUDENTDETAIL.STUDID")){ sx[bb]="STUDID";}
             else if(sx[bb].equals("TMARKDETAIL.STUDID")){ sx[bb]="STUDID";}		
             else if(sx[bb].equals("UGMARKDETAIL.STUDID")){ sx[bb]="STUDID";}			 
			 else if(sx[bb].equals("UGMAJORS.MAJORS  AS  UGM")){ sx[bb]="UGM";}			 
			 else if(sx[bb].equals("PGMAJORS.MAJORS  AS  PGM")){ sx[bb]="PGM";}
			 else if(sx[bb].equals("UGMAJORS.UGID  AS  UGG")){ sx[bb]="UGG";}
			 else if(sx[bb].equals("PGMAJORS.PGID  AS  PGG")){ sx[bb]="PGG";}
			 else if(sx[bb].equals("TMARKDETAIL.UGID  AS  TUG")){ sx[bb]="TUG";}
			 s3[k][bb] = query_set.getString(sx[bb]);		 
			 }
			 k++;
		 }
		    o[0]=s3;
			o[1]=count;
			o[2]=sx.length;
            stmt.close(); 
            con.close();
		}catch (Exception i)
        {
         System.out.println(i);
        }
         return o;			
	}	
	
	
	public Object[] getToppersData(String ax[],int bx,int cx,String nx[],int t)
	{
		int i=0,num=0;
		String tab[][];
		String fconte[];
				 Object[] arob=new Object[4];
		try 
		{	  
		  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","thebookofmirdad");
          Statement stmt = con.createStatement();
		  stmt.setFetchSize(250);
        ResultSet query_set1 = stmt.executeQuery("SELECT  count(*)  as NUM FROM(SELECT STUDENTDETAIL.STUDID  FROM  "+ax[5]+"  ,  "+ax[6]+"  ,  "+ax[7]+"  WHERE  "+ax[8]+" = "+ax[9]+" AND "+ax[10]+" = "+ax[11]+"  AND  "+ax[12]+" = "+ax[13]+"  AND  Stream = "+bx+" AND Community = "+cx+" ORDER BY  "+ax[2]+" desc)WHERE  ROWNUM <= "+t);
		while (query_set1.next())
		 {
			 num=query_set1.getInt("NUM");	
		 }
		
		tab = new String[num][4];
		fconte = new String[num];
		ResultSet query_set = stmt.executeQuery("SELECT "+nx[0]+", "+nx[1]+" , "+nx[2]+" , "+nx[3]+"  FROM(SELECT  "+ax[0]+"  AS  "+nx[0]+", "+ax[1]+"  AS  "+nx[1]+" , "+ax[2]+"  AS  "+nx[2]+" , "+ax[3]+"  AS  "+nx[3]+"  FROM  "+ax[5]+"  ,  "+ax[6]+"  ,  "+ax[7]+"  WHERE  "+ax[8]+" = "+ax[9]+" AND "+ax[10]+" = "+ax[11]+"  AND  "+ax[12]+" = "+ax[13]+"  AND  Stream = "+bx+" AND Community = "+cx+" ORDER BY  "+ax[2]+" desc)WHERE ROWNUM <= "+t);
	     
		String s1[] = new String[num];
		int m=0,n=0,j=0;;
		while (query_set.next())
		 {
			 
			tab[m][0] = query_set.getString(nx[0]);
			s1[j]=query_set.getString(nx[0]);j++;
			tab[m][1] = query_set.getString(nx[1]);
			tab[m][2] = query_set.getString(nx[2]);
			tab[m][3] = query_set.getString(nx[3]);
			fconte[i]=(i+1)+"   \t     "+tab[m][1]+"  \t    "+tab[m][2];
			i++;
			m++;
         }
		 

		 arob[0]=tab;
		 arob[1]=i;
		 arob[2]=fconte;
		 arob[3]=s1;
		 stmt.close(); 
         con.close();
	

		}catch (Exception ex1)
        {
           System.out.println(ex1);
        }		 return arob;	
	}

	
public Object[] getChartData(String a[],int a1)
	{
		int num=0;

	 Object[] arob=new Object[4];
		try 
		{	
		 String s="";
		   DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","thebookofmirdad");
          Statement stmt = con.createStatement();
		  stmt.setFetchSize(250);
		 ResultSet query_set1 = stmt.executeQuery("SELECT  count(*)   as    NUMOFSTUD  FROM  "+a[2]+" , "+a[3]+"  WHERE  "+a[4]+"  =  "+a[5]+"   AND  STREAM = "+a1+"  AND   "+a[6]+"  =  "+a[7]);
         while (query_set1.next())
		 {
		 num = query_set1.getInt("NUMOFSTUD");
		 Integer i = new Integer(num);
		 s = i.toString();
		 }
		 System.out.println(num);
		 ArrayList<String> u = new ArrayList<>();
		 ArrayList<Integer> slices = new ArrayList<>();
         ResultSet query_set = stmt.executeQuery("SELECT  "+a[0]+"   as   STUDIED   ,   count(*)   as    NUMOFSTUD  FROM  "+a[2]+" , "+a[3]+"  WHERE  "+a[4]+"  =  "+a[5]+"   AND  STREAM = "+a1+"  AND   "+a[6]+"  =  "+a[7]+"   GROUP BY  "+a[0]);
          System.out.println("SELECT  "+a[0]+"   as   STUDIED   ,   count(*)   as    NUMOFSTUD  FROM  "+a[2]+" , "+a[3]+"  WHERE  "+a[4]+"  =  "+a[5]+"   AND  STREAM = "+a1+"  AND   "+a[6]+"  =  "+a[7]+"   GROUP BY  "+a[0]);
		  int k=0;
		  while (query_set.next())
		 {             
			u.add(query_set.getString("STUDIED"));
            slices.add(query_set.getInt("NUMOFSTUD"));
         }
		 Iterator it = u.iterator();
		 while(it.hasNext())
		 {
			 System.out.println(it.next());
		 }
		  Iterator it1 = slices.iterator();
		 while(it1.hasNext())
		 {
			 System.out.println(it1.next());
		 }
		 
		 arob[0]=u;
		 arob[1]=slices;
		 arob[2]=num;
		 arob[3]=s;
		 
         stmt.close(); 
         con.close();
		

		}catch (Exception i)
        {
         System.out.println(i);
        }   return arob; 	   	
	}


    

    public boolean saveNamelist(String bxc,String fcont[])
	{
				 try{
		 FileWriter fw = new FileWriter(bxc+".txt",false);
		 BufferedWriter bw = new BufferedWriter(fw,1024);
		 bw.write(bxc);
		 bw.write(System.getProperty("line.separator"));
		  bw.write(System.getProperty("line.separator"));
		 bw.write("S.No."+"   \t    "+"Name"+"   \t    "+"TotalMark");
		  bw.write(System.getProperty("line.separator"));
		 for(int i=0;i<fcont.length;i++)
		 {
			 bw.write(fcont[i]);
			  bw.write(System.getProperty("line.separator"));
		 }
		 bw.close();

		 }
		 catch(Exception e){}
		 File f = new File(bxc+".txt");
		 if(f.exists())
		 {
		 return true;
		 }
		 return false;
	}
	
	
	public boolean saveMessage(String txt)
	{
		 try{
		 FileWriter fw = new FileWriter("Message.txt",false);
		 BufferedWriter bw = new BufferedWriter(fw,1024);
		 bw.write(txt);
		 bw.close();
		 }
		 catch(Exception e){} 
		 File f = new File("Message.txt");
		 if(f.exists())
		 {
		 return true;
		 }
		 return false;
		 
	}
	public String[] getImages(String sid[],int cc)
	{
		     String r3[] = new String[sid.length];
			 try 
		{	  
	
		   DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","thebookofmirdad");
          Statement stmt = con.createStatement();
		  stmt.setFetchSize(250);
		 ResultSet query_set1; 
		 int ky=0;
		 if(cc==1)
		 {System.out.println(1);
          for(int k=0;k<sid.length;k++)
		  {System.out.println("hell"+sid.length);
			  query_set1 = stmt.executeQuery("select url as location from upload1 where STUDID='"+sid[k]+"'");
		    while (query_set1.next())
            {System.out.println("hell1");
			 r3[ky]=query_set1.getString("location");
			 ky++;
            }
		  }
		 }
		 else
		 {System.out.println(2);
	      for(int k=0;k<sid.length;k++)
		  {
			  query_set1 = stmt.executeQuery("select "+sid[k]+" as SID,url as location from upload2");
		    while (query_set1.next())
            {
			 r3[ky]=query_set1.getString("location");
			 ky++;
            }
		  }
		 }
		 		  
		 stmt.close(); 
         con.close();
		
		}catch (Exception i)
        {
                         System.out.println(i);
        }  return r3;
		
	}

	
	public static void main(String args[])
	{
		try
		{
			MyRemote service = new MyRemoteService();
			Naming.rebind("done",service);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}