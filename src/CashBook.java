import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class CashBook {
	private ArrayList<Journal> journal;
	private ArrayList<Goal> goal;

	public CashBook(){
		 journal = new ArrayList<Journal>();
		 goal    = new ArrayList<Goal>();
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

	//すべての仕訳の残高を更新
	// TODO:最低限の計算で更新できるようにするための、別メソッドを作る
	public void updateBalance(){
		int balance = 0;
		for(int i=0;i<journal.size();i++){
			if(journal.get(i).isDeleted){
				continue;
			}
			balance += journal.get(i).getAmount();
			journal.get(i).setBalance(balance);
		}
	}

	//画面にすべての仕訳を出力
	public void printAll(){
		System.out.println("ID |             日付              | 用途  | 入金  | 出金  | 残高");
		System.out.println("---+-------------------------------+-------+-------+-------+-----");
		for(int i=0;i<journal.size();i++){
			if(journal.get(i).isDeleted){
				continue;
			}
			System.out.format(i + "\t" + journal.get(i).toString());
		}
	}

	//仕訳の追加
	public void add(int year, int month, int day, int hour, int minute, String usage, int amount){
		journal.add(new Journal(year, month, day, hour, minute, usage, amount));
		this.sort();
	}

	//仕訳の削除(削除フラグのオン)
	public void delete(int id){
		journal.get(id).isDeleted = true;
		this.updateBalance();
	}

	//仕訳の総数を獲得（削除フラグがオンのものを含む）
	public int size(){
		return journal.size();
	}

	//更新の時の表示例を獲得
	public String getUpdateExample(int id){
		return journal.get(id).getExample();
	}

	//今月の目標を出力
	public void printGoal(){
		for(int i=0;i<goal.size();i++){
			System.out.println(goal.get(i).year + "/" + goal.get(i).month + " " + goal.get(i).title);
		}

	}

	//今月の目標を追加・更新
	public void addGoal(int y, int m, String t){
		//既存データにすでに存在するかチェック
		for(int i=0;i<goal.size();i++){
			if(goal.get(i).year == y && goal.get(i).month == m){
				//あれば更新
				goal.get(i).title = t;
				return;
			}
		}
		//なければ追加
		goal.add(new Goal(y, m, t));
	}
}
