package lab1;
import java.util.List;

/*import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;*/
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;


public class database {
	
	
	public static void listResult(ObjectSet result) {
		System.out.println(result.size());
		while(result.hasNext()) {
		System.out.println(result.next());
		}
		}
	
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
			Book crime_and_punishment = new Book("Преступление и наказание", "Достоевский", 1866, 331);
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
			
			System.out.println("Книги Л.Н. Толстого:");
			
			while (book1.hasNext()) {
				System.out.println(book1.next());
			}
			System.out.println("\n ------------------------------------------------------------------------------------------------------------- \n");
				

			// Native Queries
			// Find all books with page < 100
			ObjectSet<Book> books = db.query(new Predicate<Book>() {
				public boolean match(Book book) {
					return book.getPage() < 100;
				}
			});
			
			System.out.println("Native Queries: Книги с количеством страниц < 100:");

			while (books.hasNext()) {
				System.out.println(books.next());
			}
			System.out.println("\n ------------------------------------------------------------------------------------------------------------- \n");
			
/*			// Advanced Native Queries
			// Find all books with 40<page<100 or books of Tolstoy
			ObjectSet <Book> result = db.query(new Predicate<Book>() {
				public boolean match(Book book) {
					return book.getPage() > 40
					&& book.getPage() < 100
					|| book.getAuthorName().equals("Толстой");
				}
			});
		
			System.out.println("Advanced Native Queries: Книги с количеством страниц > 40, но < 100 или книги Л.Н. Толстого:");
			
			while (result.hasNext()) {
				System.out.println(result.next());
			}
			System.out.println("\n ------------------------------------------------------------------------------------------------------------- \n");

		} */
			
		// SODA Query API
  
  			System.out.println("SODA Query API:");
  			
			Query query=db.query();
			query.constrain(Book.class);
			query.descend("authorName").constrain("Толстой");
			ObjectSet result=query.execute();
			listResult(result);
		
		} 
		
		finally {
			// if (db != null)
			db.close();
		}
	}
}
