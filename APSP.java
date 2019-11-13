import java.util.*;
class APSP
{
	int[][] c=new int[10][10];
	int[][] a=new int[10][10];
	Scanner sc=new Scanner(System.in);
	int n;
	void readGraph()
	{
		System.out.println("Enter the number of vertices:");
		n=sc.nextInt();
		System.out.println("Enter cost matrix:");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				c[i][j]=sc.nextInt();
			}
		}
	}
	int min(int a,int b)
	{
		if(a>b)
			return b;
		else
			return a;
	}
	void allPaths()
	{
		int i=0,j=0,k=0;
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				a[i][j]=c[i][j];
			}
		}
		for(k=1;k<=n;k++)
		{
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					a[i][j]=min(a[i][j],a[i][k]+a[k][j]);
				}
			}	
		}
		printing();
	}
	void printing()
	{
		System.out.println("Solution is:");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		APSP ob=new APSP();
		ob.readGraph();
		ob.allPaths();
	}
}