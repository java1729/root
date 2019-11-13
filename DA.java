import java.util.*;
class DA
{
	int[][] c=new int[10][10];
	boolean[] s=new boolean[10];
	int[] d=new int[10];
	Scanner sc=new Scanner(System.in);
	int n;
	void readGraph()
	{
		int i,j;
		System.out.println("Enter the number of vertices:");
		n=sc.nextInt();
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				c[i][j]=sc.nextInt();
			}
		}
	}
	int findU()
	{
		int min=0,i;
		for(i=2;i<=n;i++)
		{
			if(s[i]==false)
			{
				min=i;
				break;
			}
		}
		for(i=2;i<=n;i++)
		{
			if(d[min]>d[i] && s[i]==false)
			{
				min=i;
			}
		}
		return min;
	}
	void printing()
	{
		for(int i=2;i<=n;i++)
		{
			System.out.println("Shortest path from 1 to "+i+" is: "+d[i]);
		}
	}
	void shortestPaths(int v)
	{
		int i,num,u;
		for(i=1;i<=n;i++)
		{
			s[i]=false;
			d[i]=c[v][i];			
		}
		s[v]=true;
		d[v]=0;
		for(num=2;num<=n;num++)
		{
			u=findU();
			s[u]=true;
			for(i=1;i<=n;i++)
			{
				if(c[u][i]!=9999 && s[i]==false)
				{
					if(d[i]>d[u]+c[u][i])
						d[i]=d[u]+c[u][i];
				}
			}	
		}
		printing();
	}
	public static void main(String args[])
	{
		DA ob=new DA();
		ob.readGraph();
		ob.shortestPaths(1);
	}
}