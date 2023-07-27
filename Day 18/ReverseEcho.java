package multireverseecho;
import java.net.*;
import java.io.*;
public class ReverseEcho extends Thread{
	Socket stk;
	public ReverseEcho(Socket st){
	stk=st;
	}
	public void run(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(stk.getInputStream()));
	PrintStream ps=new PrintStream(stk.getOutputStream());
	String msg;
	StringBuilder sb;
	do{
	msg=br.readLine();
	sb=new StringBuilder(msg);
	sb.reverse();
	msg=sb.toString();
	ps.println(msg);	
	}while(!msg.equals("0"));
	stk.close();	

	}
	catch(Exception e){
	
	}
	}
	public static void main(String args[]){
		try{
		ServerSocket ss=new ServerSocket(2000);
		Socket stk;
		ReverseEcho re;
		int Count =1;
		do{
		stk=ss.accept();
		System.out.println("Client Connected "+Count++);
		re=new ReverseEcho(stk);
		re.start();
		}while(true);
		}
		catch(Exception e)
		{}
	


	}
}
