import java.util.*;
class OBST
{
	Scanner sc=new Scanner(System.in);
	int[][] w=new int[10][10];
	double[][] c=new double[10][10];
	int[][] r=new int[10][10];
	int[] p=new int[10];
	int[] q=new int[10];
	int n;	
	void getData()
	{
		System.out.println("Enter number of vertices:");
		n=sc.nextInt();
		System.out.println("Enter probabilities of non leaf nodes:");
		for(int i=1;i<=n;i++)
			p[i]=sc.nextInt();
		System.out.println("Enter probabilities of leaf nodes:");
		for(int i=0;i<=n;i++)
			q[i]=sc.nextInt();
	}
	void obst()
	{
		int j,i,k;
		for(i=0;i<=n-1;i++)
		{
			w[i][i]=q[i];
			r[i][i]=0;
			c[i][i]=0.0;
			w[i][i+1]=q[i]+q[i+1]+p[i+1];
			r[i][i+1]=i+1;
			c[i][i+1]=q[i]+q[i+1]+p[i+1];
		}
		w[n][n]=q[n];
		r[n][n]=0;
		c[n][n]=0.0;
		for(int m=2;m<=n;m++)
			for(i=0;i<=n-m;i++)
			{
				j=i+m;
				w[i][j]=w[i][j-1]+p[j]+q[j];
				k=find(i,j);
				c[i][j]=w[i][j]+c[i][k-1]+c[k][j];
				r[i][j]=k;
			}
		System.out.println("Weight of obst is:"+w[0][n]);
		System.out.println("Cost of obst is:"+c[0][n]);
		System.out.println("Root of obst is:"+r[0][n]);
	}
	int find(int i,int j)
	{
		int l=0;
		double min=999.9;
		for(int m=r[i][j-1];m<=r[i+1][j];m++)
			if(c[i][m-1]+c[m][j]<min)
			{
				min=c[i][m-1]+c[m][j];
				l=m;
			}
		return l;
	}
	public static void main(String args[])
	{
		OBST ob=new OBST();
		ob.getData();
		ob.obst();
	}
}