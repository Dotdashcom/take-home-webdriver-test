package net.serenity.showcase.utils;



public interface Constants {
	

	/**
	 * PAGE OBJECT VARIABLES DECLARATIONS
	 */
	String HOMEPAGE = "HomePage";


	/**
	 * 2000 milli seconds delay.
	 */
	int WAIT_FOR_2000MS = 2000;

	/**
	 * 4000 milli seconds delay.
	 */
	int WAIT_FOR_4000MS = 4000;
	
	/**
	 * 7000 milli seconds delay.
	 */
	int WAIT_FOR_7000MS = 7000;


	/**
	 * This method is an enumeration of the Waiting/delay time.
	 * 
	 * @author Manish Lalwani
	 * 
	 */
	public enum WaitingTime {
		/**
		 * 2 seconds delay.
		 */
		SHORT,
		/**
		 * 4 seconds delay.
		 */
		MEDIUM,
		/**
		 * 7 seconds delay.
		 */
		LONG,
	}

}


