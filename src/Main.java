import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		System.out.println("--- お小遣い帳 ---");

		CashBook cb = new CashBook();
		ArrayList<Journal> journal = new ArrayList<Journal>();
		cb.add(2015, 1, 1, 9, 0, "繰越", 1000);
		cb.add(2015, 1, 1, 10, 3, "ビール", -300);
		cb.add(2015, 1, 1, 10, 1, "かわ", -160);
		cb.add(2015, 1, 1, 10, 2, "つくね", -160);

		cb.sort();
		cb.printAll();
/*
		for (Iterator<Journal> i = journal.iterator(); i.hasNext();) {
			Journal jnl = (Journal) i.next();
			System.out.println(jnl.toString());
		}
*/
	}
}
