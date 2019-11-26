import java.util.Scanner;
class SS
{
	 static int[] w=new int[100];
	static int[] x=new int[100];
	static int m,r,s=0;
	/*Scanner sc=new Scanner();
	System.out.println("Enter array size w:");
	n=sc.nextInt();
	System.out.println("Enter array w:");
	for(int i=0;i<n;i++)
	{
		w[i]=sc.nextInt();
		x[i]=0;
	}*/
	void solve(int s,int k,int r,int n)
	{
		x[k]=1;
		if((s+w[k])==m)
		{
			for(int i=0;i<n;i++)
			System.out.print(x[i]+" ");
			System.out.println("");
		}
		else if((s+w[k]+w[k+1])<=m)
		{
			solve((s+w[k]),k+1,(r-w[k]),n);	
		}
		x[k]=0;
		if(((s+r-w[k])>=m) &&((s+w[k+1])<=m))
		{
			x[k]=0;
			solve(s,k+1,(r-w[k]),n);	
		} 
			
	}
	public static void main(String...args)
	{
		int n,k=0,sum=0;
		//int[] w=new int[100];
		//Scanner sc=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter array size w:");
		n=sc.nextInt();
		System.out.println("Enter array w:");
		for(int i=0;i<n;i++)
		{
			w[i]=sc.nextInt();
			x[i]=0;
		}
		System.out.println("Enter expected sum:");
		m=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			sum+=w[i];
		}
		r=sum;
		System.out.println(r+" ");
		
		SS obj=new SS();
		obj.solve(s,k,r,n);	
	}
}
