import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class CashBook {
	private ArrayList<Journal> journal;

	public CashBook(){
		 journal = new ArrayList<Journal>();
	}

	public int getLastAmount(Calendar cal){
		int lastAmount = 0;
		//日付でソート
		Collections.sort(journal, new JournalComparator());
		//ソート確認
		for(int i=0;i<journal.size();i++){
			System.out.format(journal.get(i).toString());
		}
		return lastAmount;
	}

	public void sort(){ // 日付でソート
		Collections.sort(journal, new JournalComparator());
		//残高更新
		this.updateBalance();
	}

	public void updateBalance(){
		int balance = 0;
		for(int i=0;i<journal.size();i++){
			balance += journal.get(i).getAmount();
			journal.get(i).setBalance(balance);
		}
	}
	public void printAll(){
		for(int i=0;i<journal.size();i++){
			System.out.format(journal.get(i).toString() + "\n");
		}
	}

	public void add(int year, int month, int day, int hour, int minute, String usage, int amount){
		journal.add(new Journal(year, month, day, hour, minute, usage, amount));
	}

}
