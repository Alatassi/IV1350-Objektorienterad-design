package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;

public class TotalRevenueView extends Observer {
	@Override
	public void update(ItemDTO item) {
		System.out.println(item.getName()+ "	" +item.price ) ;
	}
	public TotalRevenueView(Sale sale) {
		this.sale = sale;
		this.sale.attach(this);
	}
}
