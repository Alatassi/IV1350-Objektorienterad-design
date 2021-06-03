package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.model.DTOs.ItemDTO;
import se.kth.iv1350.POS.model.dbHandler.ItemRegistry;
import se.kth.iv1350.POS.model.extrnalSystem.Tax;
import se.kth.iv1350.POS.model.extrnalSystem.Printer;

import java.util.logging.Logger;

import se.kth.iv1350.POS.model.*;


public class Controller {
	public Sale sale;
	public ItemRegistry itemRegistry;
	private static final Logger logger = Logger.getLogger(Controller.class.getName());

	// Constructor to begin the sale and item registry at the beginning of the startup of the application
	public Controller() {
		this.sale = new Sale();
		this.itemRegistry = new ItemRegistry();

	}
	/**
	 *@param the id of the item  
	 *@return the item using ID   
	 */
	public ItemDTO getItemByID(String id)  {

		return itemRegistry.getItemByID(id);


	}
	/**
	 *@param the id of the item  
	 *add an item to sale   
	 * @throws IdentifierDoesNotExistException 
	 */
	public void addItemToSale(String id) throws DatabaseFailureException, IdentifierDoesNotExistException {
		if (id.equals("milk") || id.equals("cocacola") || id.equals("cigarette")) {
			logger.info("The user tried to enter a hard coded item");
			throw new DatabaseFailureException(id);
		}
		else {
			ItemDTO item = getItemByID(id);
			if (item != null) {
				sale.addItem(item);

			}
			else {
				logger.info("The user tried to enter an unregistered item");

				throw new IdentifierDoesNotExistException(id);

			}
		}
	}

	/**
	 *@param the id of the item  
	 *@return the item if the item was found. 
	 */
	public boolean isItemExists(String id)  {
		ItemDTO item = getItemByID(id);
		return item != null;
	}
	/**
	 *this function shows if the receipt sent to successfully to tax or not.
	 */
	public void sendToTax() {
		int sendResult = Tax.sendToTax(sale.getSum().getPriceAfterVat(), sale.vat);
		if(sendResult == 200)
			System.out.println("The reciept is sent successfully to tax");
		else
			System.err.println("Error: cannot send the reciept to tax. The error code: " + sendResult);
	}
	/**
	 *call the function endSale in the class sale to end the sale
	 */
	public void endSale() {
		sale.endSale();

	}
	/**
	 *this function shows if the receipt sent successfully to printer or not.
	 */
	public void sendToPrintr() {
		boolean printResult = Printer.print(sale);
		if(printResult)
			System.out.println("Printed");
		else
			System.out.println("Error while printing");

	}
}
