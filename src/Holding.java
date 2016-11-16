import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Holding implements Comparable<Holding>{
	public static final String SEPARATOR = "@";
	
	private String ticker;
	private String name;
	private int quantity;
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString(){
		return "["+this.getTicker() + ", "+this.getName() + ", "+ this.getQuantity()+"]";
		
	}
	
	public Holding(String ticker, String name, int quantity) {
		super();
		this.ticker = ticker;
		this.name = name;
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Holding another) {
		
		int compare = this.getTicker().compareTo(another.getTicker());
		if (compare > 0){
		    return 1;
		} else if (compare < 0) {
		    return -1;
		} 
		return 0;
	}
	
	
	static int countHoldings(String input) {
		int count = input.split(SEPARATOR).length;
		return count;
	}
	
	static String printHoldings(String portfolioString) {

		List<Holding> holdingList = new ArrayList<Holding>();
		
		StringBuilder sb = new StringBuilder(); 
		//declare arrayList with object
		String[] portfolioStringArray = portfolioString.split(SEPARATOR);
		for(int i=0;i< portfolioStringArray.length; i++){
			String[] holdingArray = portfolioStringArray[i].split(",");
			//create holding object using constructor
			Holding holdingObject = new Holding(holdingArray[0],holdingArray[1],Integer.parseInt(holdingArray[2]));
			
			holdingList.add(holdingObject);			
		}
		
		Collections.sort(holdingList);
		
		Iterator<Holding> iterator = holdingList.iterator();
		while(iterator.hasNext()){
			sb.append(iterator.next().toString());
			if(iterator.hasNext()){
				sb.append(", ");
			}
		}
		String output = sb.toString();
		return output;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String res;
		String _input;
		try {
			_input = in.nextLine();
		} catch (Exception e) {
			_input = null;
		}
		res = printHoldings(_input);
		System.out.println(res);

	}
	
}
