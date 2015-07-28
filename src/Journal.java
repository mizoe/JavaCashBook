import java.util.Calendar;

public class Journal {
	private Calendar date;
	private String usage;
	private int amount;
	private int balance;
	public boolean isDeleted;

	public Journal(){
	}
	public Journal(int year, int month, int day, int hour, int minute, String usage, int amount){
		Calendar cal = Calendar.getInstance();
		cal.set(year, (month-1), day, hour, minute);
		this.date   = cal;

		this.usage  = usage;
		this.amount = amount;

		int balance = 0;
		this.balance= balance;

		this.isDeleted = false;
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

	@SuppressWarnings("static-access")
	public String getExample(){
		Calendar d = this.date;
		// "例）2015,1,1,9,25,お年玉,2000"
		String ex = "例）" + d.get(d.YEAR) + ","+ (d.get(d.MONTH)+1) + "," + d.get(d.DATE) + ","
				+ d.get(d.HOUR) + "," + d.get(d.MINUTE) + ","
				+ this.usage + "," + this.amount;
		return ex;
	}

	public String toString(){
		// TODO: \tを数値書式にする
		String dateStr = date.getTime().toString();
		String amountStr = amount + "\t\t";
		if(amount<0){
			amountStr = "\t\t" + amount;
		}
		return dateStr + "\t" + usage + "\t" + amountStr + "\t" + balance + "\n";
	}
}
