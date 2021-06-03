package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.controller.DatabaseFailureException;
import se.kth.iv1350.POS.controller.IdentifierDoesNotExistException;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;

public class ControllerTest {
	Controller contoller;
	
	@Before 
    public void init() throws IdentifierDoesNotExistException {
		contoller = new Controller();
		try {
			contoller.addItemToSale("1");
		} catch (DatabaseFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Test
	public void testController() {
		int expected = 3;
		int actual = contoller.itemRegistry.items.size();
		assertEquals(expected, actual);
		
		expected = 1;
		actual = contoller.sale.itemList.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetItemByID() {
		ItemDTO item;
		item = contoller.getItemByID("1");
		String expected = "1";
		String actual = item.itemIdentifier;
		assertEquals(expected, actual);

	
	}
	
	@Test
	public void testAddItemToSale() throws IdentifierDoesNotExistException {
		try {
			contoller.addItemToSale("3");
		} catch (DatabaseFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expected = "3";
		String actual = contoller.sale.itemList.get(1).itemIdentifier;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsItemExists() {
		boolean actual;
		actual = contoller.isItemExists("3");
		boolean expected = true;
		assertEquals(expected, actual);
		
		actual = contoller.isItemExists("4");
		 expected = false;
		assertEquals(expected, actual);
		
	}

}
