import java.util.*;
class KA
{
	int[][] c=new int[10][10];
	int[] p=new int[10];
	int[][] t=new int[10][3];
	int mc,k,j,u,v;
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
	int find(int i)
	{
		while(p[i]>0)
		{
			i=p[i];
		}
		return i;
	}
	void union(int i,int j)
	{
		p[i]=j;
	}
	boolean isEmpty()
	{
		int count=0;
		for(int i=1;i<=n;i++)
			if(p[i]==-1)
				count++;
		if(count==1)
			return false;
		else 
			return true;
	}
	int deleteEdge()
	{
		int min=999;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(min>c[i][j])
				{
					min=c[i][j];
					u=i;
					v=j;
				}
			}
		}
		c[u][v]=999;
		c[v][u]=999;
		return min;
	}
	void krushkalAlgo()
	{
		int cost=0,i=0;
		for(i=1;i<=n;i++)
			p[i]=-1;
		i=0;
		while((i<(n-1)) && isEmpty())
		{
			cost=deleteEdge();
			j=find(u);
			k=find(v);
			if(j!=k)
			{
				i+=1;
				t[i][1]=u;
				t[i][2]=v;
				mc+=cost;
				union(j,k);
			}
		}
		if(i!=n-1)
			System.out.println("No Spanning Tree");
		else
			System.out.println("Minimum Cost="+ mc);
	}
	public static void main(String args[])
	{
		KA ob=new KA();
		ob.readGraph();
		ob.krushkalAlgo();
	}
}