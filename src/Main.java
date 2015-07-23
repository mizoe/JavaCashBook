import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		System.out.println("--- お小遣い帳 ---");

		ArrayList<Journal> journal = new ArrayList<Journal>();
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 0, 31);
		journal.add(new Journal(cal, "繰越", 1000, 1000));
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2015, 1, 1);
		journal.add(new Journal(cal2, "ビール", -300, 700));

		for (Iterator<Journal> i = journal.iterator(); i.hasNext();) {
			Journal jnl = (Journal) i.next();
			System.out.println(jnl.toString());
		}
	}
}
