import java.util.Calendar;

public class Journal {
	private Calendar date;
	private String usage;
	private int amount;
	private int balance;
	private static int lastBalance;

	public Journal(){
	}
	public Journal(int year, int month, int day, int hour, int minute, String usage, int amount){
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minute);
		this.date   = cal;

		this.usage  = usage;
		this.amount = amount;

		int balance = 0;
		this.balance= balance;
	}

	public void setBalance(int balance){
		this.balance = balance;
	}
	public int getAmount(){
		return amount;
	}
	public Calendar getDate(){
		return date;
	}

	public String toString(){
		String dateStr = date.getTime().toString();
		return dateStr + "\t" + usage + "\t" + amount + "\t" + balance + "\n";
	}
}
