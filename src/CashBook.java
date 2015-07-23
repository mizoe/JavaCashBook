import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class CashBook {
	private ArrayList<Journal> journal;

	public CashBook(){
		 journal = new ArrayList<Journal>();
	}

	// TODO: 最後の残高を知りたい（最低限の計算で更新できるようにしたいので）
	public int getLastBalance(Calendar cal){
		int lastAmount = 0;
		return lastAmount;
	}

	// 日付でソート
	public void sort(){
		Collections.sort(journal, new JournalComparator());
		//残高更新
		this.updateBalance();
	}

	//すべての仕訳の残高を更新 TODO:最低限の計算で更新できるようにする
	public void updateBalance(){
		int balance = 0;
		for(int i=0;i<journal.size();i++){
			balance += journal.get(i).getAmount();
			journal.get(i).setBalance(balance);
		}
	}

	//画面にすべての仕訳を出力
	public void printAll(){
		for(int i=0;i<journal.size();i++){
			System.out.format(journal.get(i).toString() + "\n");
		}
	}

	//仕訳の追加
	public void add(int year, int month, int day, int hour, int minute, String usage, int amount){
		journal.add(new Journal(year, month, day, hour, minute, usage, amount));
	}

}
