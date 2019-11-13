import java.util.*;
class Prims
{
	int[][] c=new int[10][10];
	int[] near=new int[10];
	int[][] t=new int[10][3];
	int mc,k,l;
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
	int getMin()
	{
		int min=999;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(min>c[i][j] )
				{
					min=c[i][j];
					k=i;
					l=j;
				}
			}
		}
		c[k][l]=999;
		c[l][k]=999;
		return min;
	}
	void minCost()
	{
		int i,j=0;
		mc=getMin();
		t[1][1]=k;
		t[1][2]=l;
		for(i=1;i<=n;i++)
		{
			if(c[i][l]<c[i][k])
			{
				near[i]=l;
			}
			else
			{
				near[i]=k;
			}
		}
		near[k]=near[l]=0;
		for(i=2;i<=n-1;i++)
		{
			j=selectEdge();
			t[i][1]=j;
			t[i][2]=near[j];
			mc+=c[j][near[j]];
			near[j]=0;
			for(k=1;k<=n;k++)
			{
				if(near[k]!=0 && c[k][near[k]]>c[k][j])
					near[k]=j;
			}
		}
	}
	int selectEdge()
	{
		int j=0,min=999;
		for(int i=1;i<=n;i++)
		{
			if((near[i]!=0) && (c[i][near[i]]<min))
			{
				min=c[i][near[i]];	
				j=i;
			}
		}
		return j;
	}
	public static void main(String args[])
	{
		Prims ob=new Prims();
		ob.readGraph();
		ob.minCost();
		System.out.println("Min Cost="+ob.mc);
	}
}