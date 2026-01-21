import java.util.Scanner;
class Handshake
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Number of student= ");
		int n=sc.nextInt();
		int h=(n*(n-1))/2;
		System.out.println("NO.of handshakes= "+h);
		
		
	}
}
