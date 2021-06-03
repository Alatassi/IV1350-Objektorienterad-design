/**
 * Author: M Rami Alsaid Suliman
 * Date: may 5th 2021
 */

package se.kth.iv1350.POS.startUp;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.controller.DatabaseFailureException;
import se.kth.iv1350.POS.controller.IdentifierDoesNotExistException;
import se.kth.iv1350.POS.view.*;
/**
 * @author Sadeq
 *
 */
public class Main {

	/**
	 * @param args
	 * change the comment in main 
	 * @throws DatabaseFailureException 
	 * @throws IdentifierDoesNotExistException 
	 */
	public static void main(String[] args) throws DatabaseFailureException, IdentifierDoesNotExistException {
		Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeSale();
	}

}
