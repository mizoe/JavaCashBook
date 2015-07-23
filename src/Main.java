import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		System.out.println("--- お小遣い帳 ---");

		ArrayList<Journal> journal = new ArrayList<Journal>();
		journal.add(new Journal(2015, 1, 1, 9, 0, "繰越", 1000, 1000));
		journal.add(new Journal(2015, 1, 1, 10, 0, "ビール", -300, 700));

		for (Iterator<Journal> i = journal.iterator(); i.hasNext();) {
			Journal jnl = (Journal) i.next();
			System.out.println(jnl.toString());
		}
	}
}
