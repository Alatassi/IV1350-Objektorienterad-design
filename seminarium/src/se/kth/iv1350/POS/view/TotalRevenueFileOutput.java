package se.kth.iv1350.POS.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;

public class TotalRevenueFileOutput extends Observer implements Logger {
	
	
	    private PrintWriter logStream;

	    /**
	     * Creates a new instance and also creates a new log file. An existing log file will be deleted.
	     */
	    public TotalRevenueFileOutput(Sale sale) {
	    	
	    	this.sale = sale;
	    	this.sale.attach(this);
	        try {
	            logStream = new PrintWriter(new FileWriter("log.txt"), true);
	        } catch (IOException ioe) {
	            System.out.println("CAN NOT LOG.");
	            ioe.printStackTrace();
	        }
	    }

	    /**
	     * Prints the specified string to the log file.
	     *
	     * @param message The string that will be printed to the log file.
	     */
	    @Override
	    public void log(String message) {
	        logStream.println(message);
	    }

		@Override
		public void update(ItemDTO item) {

			log(item.getName()+ "	" +item.price);
			
		}
	

}
