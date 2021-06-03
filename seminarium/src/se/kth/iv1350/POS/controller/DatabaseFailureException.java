package se.kth.iv1350.POS.controller;

@SuppressWarnings("serial")
public class DatabaseFailureException extends Exception {

	/**
	 * @param hardcodedIdentifier when there is a connection failure with the database.
	 */
	public DatabaseFailureException(String hardcodedIdentifier) {
		super(hardcodedIdentifier + " Is hardcoded identifier");
		System.out.println("Database failure");
	}
	
}
