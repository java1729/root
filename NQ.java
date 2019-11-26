import java.util.*;
import java.lang.Math.*;
class NQ
{
	int[] x=new int[100];
	//Scanner Sc=new Scanner(System.in);
	void Nqueens(int k,int n)
	{
		for(int i=1;i<=n;i++)
		{
			if(place(k,i))
			{
				x[k]=i;
				if(k==n)
				{
					for(int j=1;j<=n;j++)
					{
						System.out.print(x[j]);
					}			
				
				System.out.println("");}
				else
					Nqueens(k+1,n);	
			}
		}	
	}
	boolean place(int k,int i)
	{
		for(int j=1;j<=k-1;j++)
		{
			if(x[j]==i||Math.abs(x[j]-i)==Math.abs(j-k))
			return false;	
		}
		return true;
	}
	public static void main(String...args)
	{
			//x[100]={0};
			int n;
			Scanner Sc=new Scanner(System.in);
			System.out.println("Enter no of queens:");
			n=Sc.nextInt();
			NQ obj=new NQ();
			obj.Nqueens(1,n);
	}
}
