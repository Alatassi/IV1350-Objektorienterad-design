package se.kth.iv1350.POS.controller;

@SuppressWarnings("serial")
public class IdentifierDoesNotExistException extends Exception {

	/**
	 * @param invalidIdentifier the item identifier that does not exist
	 */
	public IdentifierDoesNotExistException(String invalidIdentifier) {
		super("The inserted item doesn't exist	" + invalidIdentifier);
		System.out.println( "The inserted item doesn't exist	" + invalidIdentifier);

	}
}

