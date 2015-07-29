package cucumber.demo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
 
public class Library {
	private final List<Book> store = new ArrayList<Book>();
    
	public void addBook(final Book book) {
		store.add(book);
	}
 
	public List<Book> findBooks(final Date from, final Date to) {
		Calendar end = Calendar.getInstance();
		end.setTime(to);
		end.roll(Calendar.YEAR, 1);
		return store.stream().filter(book -> {
			return from.before(book.Published) && to.after(book.Published);
		}).collect(Collectors.toList());
	}
}