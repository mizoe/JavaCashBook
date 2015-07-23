import java.util.Calendar;

public class Journal {
	private Calendar date;
	private String usage;
	private int amount;
	private int balance;
	private static int lastBalance;

	public Journal(){
	}
	public Journal(Calendar date, String usage, int amount, int balance){
		this.date   = date;
		this.usage  = usage;
		this.amount = amount;
		this.balance= balance;
	}


	private Calendar getDate(){
		return date;
	}

	public String toString(){
		String dateStr = date.getTime().toString();
		return dateStr + " " + usage + " " + amount + " " + balance;
	}
}
