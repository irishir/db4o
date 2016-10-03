
package lab1;

import com.db4o.Db4o;
/*import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;*/

public class db4o
{
    public static void main(String[] args)
        throws Exception
    {
        ObjectContainer db = null;
        try
        {
            db = Db4o.openFile("books.data");

            Book war_and_peace = new Book("War and peace", "Tolstoy", 1869, 1274);
            Book eugene_onegin = new Book("Eugene Onegin", "Pushkin", 1825, 192);
            Book dead_souls = new Book("Dead souls", "Gogol", 1842, 352);
            Book master_margo = new Book("Master and Margo", "Bulgakov", 1966, 448);
            Book crime_and_punishment = new Book("Crime and punishment", "Dostoevskiy", 1866, 331);
            Book fathers_and_childrens = new Book("Fathers and childrens", "Tyrgenev", 1862, 191);
            Book woe_from_wit = new Book("Woe from wit", "Griboedov", 1828, 98);
            Book cherry_orchard = new Book("Cherry orchard", "Chekhov", 1903, 78);
            Book doctor_zhivago = new Book("Doctor Zhivago", "Pasternak", 1955, 544);
            Book southpaw = new Book("Southpaw", "Leskov", 1881, 46);
            
            db.store(war_and_peace);
            db.store(eugene_onegin);
            db.store(master_margo);
            db.store(crime_and_punishment);
            db.store(fathers_and_childrens);
            db.store(woe_from_wit);
            db.store(cherry_orchard);
            db.store(doctor_zhivago);
            db.store(southpaw);

            db.commit();
            
            // Find all books
            ObjectSet book1 = db.queryByExample(new Book(null, null, 0, 0));
            while (book1.hasNext())
                System.out.println(book1.hasNext());
        }
       finally
        {
          if (db != null)
               db.close();
        }
   }
    }
    