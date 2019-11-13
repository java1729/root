import java.util.*;
class JS
{
	int[] p=new int[10];
	int[] dl=new int[10];
	int[] j=new int[10];
	int[] job=new int[10];
	int n,m;
	Scanner sc=new Scanner(System.in);
	void readData()
	{
		int i;
		System.out.println("Enter number of jobs:");
		n=sc.nextInt();
		for(i=1;i<=n;i++)
			job[i]=i;
		System.out.println("Enter profits:");
		for(i=1;i<=n;i++)
			p[i]=sc.nextInt();
		System.out.println("Enter deadlines:");
		for(i=1;i<=n;i++)
			dl[i]=sc.nextInt();
	} 
	void sortJobs()
	{
		int i,j;
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n-i;j++)
			{
				if(p[j]<p[j+1])
				{
					int temp=p[j];
					p[j]=p[j+1];
					p[j+1]=temp;
					temp=dl[j];
					dl[j]=dl[j+1];
					dl[j+1]=temp;
					temp=job[j];
					job[j]=job[j+1];
					job[j+1]=temp;
				}
			}
		}
	}
	int getMaxDL()
	{
		int max,i;
		max=dl[1];
		for(i=2;i<=n;i++)
		{
			if(max<dl[i])
				max=dl[i];
		}
		return max;	
	}
	void js()
	{
		int i,k;
		int count=1;
		m=getMaxDL();
			for(i=1;i<=n;i++)
			{
				if(j[dl[i]]==0)
				{
					j[dl[i]]=job[i];
					count++;
				}
				else
				{
					for(k=dl[i]-1;k>0;k--)
					{
						if(j[k]==0)
						{
							j[k]=job[i];
							count++;
						}
					}
				}	
			}
			
	}
	public static void main(String args[])
	{
		int i,sum=0;
		JS ob=new JS();
		ob.readData();
		ob.sortJobs();
		ob.js();
		for(i=1;i<=ob.m;i++)
		{
			System.out.print(ob.j[i]);
			sum+=ob.p[ob.j[i]];
		}
		System.out.println("\nMax Profit="+sum);
	}
}