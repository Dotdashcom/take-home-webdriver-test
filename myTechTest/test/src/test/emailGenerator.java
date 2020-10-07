package test;

public class emailGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fname = "Steve";
		String lname = "Jobs";
		int hireDate = 1976;
		String domainName = "www.apple.com";
		
		emailGenerator obj = new emailGenerator();
		String email = obj.generateEmail(fname, lname, hireDate, domainName);
		System.out.print(email);

	}
	
	   public String generateEmail(String firstName, String lastName, Object hireDateInYear, String domainName) {
		   
		   String generatedEmail;
		   String domain = domainName.substring(4);
		  /* 
		   for(int i=4; i<domainName.length();i++) {
			   domain = domain + domainName.charAt(i);
		   }
		   */
		   generatedEmail = firstName.charAt(0)+lastName+hireDateInYear + "@" + domain;
		   
		   return generatedEmail.toLowerCase();
			
	   }

}
