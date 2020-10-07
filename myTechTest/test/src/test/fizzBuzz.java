package test;

public class fizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<=100; i++) {
			
			if(i%15 == 0)
				System.out.print("fizzbuzz, ");
			else if(i%5 == 0)
				System.out.print("buzz, ");
			else if(i%3 == 0)
				System.out.print("fizz, ");
			else
				System.out.print(i + ", ");
		}
	}

}
