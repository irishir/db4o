package lab1;

/*import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;*/
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class database {
	public static void main(String[] args) throws Exception {
		ObjectContainer db;// = Db4o.openFile("books.data");
		String dB4oFileName = "books.data";
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dB4oFileName);
		
		try {
			// db = Db4o.openFile("books.data");

			Book war_and_peace = new Book("Война и мир", "Толстой", 1869, 1274);
			Book eugene_onegin = new Book("Евгений Онегин", "Пушкин", 1825, 192);
			Book dead_souls = new Book("Мертвые души", "Гоголь", 1842, 352);
			Book anna = new Book("Анна Каренина", "Толстой", 1877, 850);
			Book master_margo = new Book("Мастер и Маргарита", "Булгаков", 1966, 448);
			Book crime_and_punishment = new Book("ПРеступление и наказание", "Достоевский", 1866, 331);
			Book fathers_and_childrens = new Book("Отцы и дети", "Тургенев", 1862, 191);
			Book woe_from_wit = new Book("Горе от ума", "Грибоедов", 1828, 98);
			Book cherry_orchard = new Book("Вишневый сад", "Чехов", 1903, 78);
			Book childhood = new Book("Детство", "Толстой", 1852, 112);
			Book doctor_zhivago = new Book("Доктор Живаго", "Пастернак", 1955, 544);
			Book southpaw = new Book("Левша", "Лесков", 1881, 46);

			db.store(war_and_peace);
			db.store(eugene_onegin);
			db.store(dead_souls);
			db.store(anna);
			db.store(master_margo);
			db.store(crime_and_punishment);
			db.store(fathers_and_childrens);
			db.store(woe_from_wit);
			db.store(cherry_orchard);
			db.store(childhood);
			db.store(doctor_zhivago);
			db.store(southpaw);

			db.commit();

			// Find all books of Tolstoy
			ObjectSet<Book> book1 = db.queryByExample(new Book(null, "Толстой", 0, 0));
			while (book1.hasNext())
				System.out.println(book1.next());
		} finally {
			// if (db != null)
			db.close();
		}
	}
}
