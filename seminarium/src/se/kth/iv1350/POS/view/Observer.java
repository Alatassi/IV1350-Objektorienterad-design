package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;

public abstract class Observer {

	
	Sale sale;
	public abstract void update(ItemDTO item);
	
	
	
}
