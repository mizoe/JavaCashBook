import java.util.Comparator;

public class JournalComparator implements Comparator<Journal> {
	@Override
	public int compare(Journal j1, Journal j2) {
		return j1.getDate().compareTo(j2.getDate());
		//- See more at: http://java.keicode.com/lib/collections-sort.php#sthash.WYTn7bBe.dpuf
	}
}
