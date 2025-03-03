/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.Scanner; 
public class RSA
{
public static int p,q,n,t,flag,msg,m,temp; 
public static int e[]=new int[100];
public static int d[]=new int[100]; 
public static int prime( int pr)
{
int i;
Double a=(Math.sqrt(pr)); 
m=a.intValue();
for(i=2;i<=m;i++)
{
if(pr%i==0)
return 0;
}

return 1;

}
public static void ce()
{
int k=0;

for(int i=2;i<t;i++)
{
if(t%i==0)
continue; 
flag=prime(i);
if(flag==1&&i!=p&&i!=q)
{

e[k]=i; flag=cd(e[k]); 
if(flag>0)
{
d[k]=flag;
k++;
}
if(k==99)
break;
}
}
}

public static int cd(int x)
{
int k=1;

while(true)
{
k=k+t;
if(k%x==0)
return(k/x);
}

}

public static void encrypt()
{
int pt,ct,key=e[0],k;
pt=msg;
k=1;

for(int j=0;j<key;j++)
{
k=k*pt;
k=k%n;
}

ct=k; temp=ct; 
System.out.println("\nTHE ENCRYPTED MESSAGE IS:"+ct);
}

public static void decrypt()
{
int pt,ct,key=d[0],k; 
ct=temp;
k=1;
for(int j=0;j<key;j++)
{
k=k*ct;
k=k%n;
}

pt=k;
System.out.println("\nTHE DECRYPTED MESSAGE IS:"+pt);
}

public static void main(String args[])
{
Scanner sc=new Scanner(System.in); 
System.out.println("ENTER FIRST PRIME NUMBER"); 
p=sc.nextInt(); 
flag=prime(p); 
if(flag==0)
{
System.out.println("WRONG INPUT");
System.exit(1);
}
System.out.println("ENTER ANOTHER PRIME NUMBER");
q=sc.nextInt();
flag=prime(q);
if(flag==0||p==q)
{
System.out.println("WRONG INPUT"); 
System.exit(1);
}

System.out.println("ENTER MESSAGE");
msg=sc.nextInt();
n=p*q;
t=(p-1)*(q-1);
ce();
System.out.println("POSSIBLE VALUES OF e AND d ARE"); 
for (int i=0;i< m-1;i++)
System.out.printf("\n%d\t%d",e[i],d[i]);
encrypt();
decrypt();
}
}
 

