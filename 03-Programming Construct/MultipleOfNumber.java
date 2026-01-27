import java.util.Scanner;
class MultipleOfNumber{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your Number:- ");
		int number = sc.nextInt();
		if(number<0 || number==0){
			System.out.print("Number is not positive");
			return;
		}
		else if(number > 100){
			System.out.print("Above 100");
			return;
		}
		else{
			for(int i=1;i<=100;i++){
				if(number % i == 0){
					System.out.println(i);
				}
			}
		}
	}
}