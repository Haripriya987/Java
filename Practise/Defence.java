import java.util.Scanner;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    while(n-->0){
        int a=in.nextInt();
        int arr[]=new int[a];
        
        int count=0;
        for(int i=0;i<a;i++){
            arr[i]=in.nextInt();
            
            if(arr[i]>=10 && arr[i]<=60)
            count++;
            
        }
        System.out.println(count);
        
        
    }

	}
}
