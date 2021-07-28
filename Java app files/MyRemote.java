import java.rmi.*;
public interface MyRemote extends Remote
{
public Object[] getQueryResult(String ss[],String st[],String xx)throws RemoteException;
	public boolean saveNamelist(String bxc,String fcont[])throws RemoteException;
	public boolean saveMessage(String txt)throws RemoteException;
	public String[] getImages(String sid[],int cc)throws RemoteException;
    public Object[] getChartData(String a[],int a1)throws RemoteException;
	public Object[] getToppersData(String a[],int bx,int cx,String nx[],int t)throws RemoteException;
}