package lab1;

public class Book
{
    public Book()
    { }
    public Book(String bookName, String authorName, int year, int page)
    {
        this.bookName = bookName;
        this.authorName = authorName;
        this.year = year;
        this.page = page;
    }
    
    public String getBookName() { return bookName; }
    public void setBookName(String value) { bookName = value; }
    
    public String getAuthorName() { return authorName; }
    public void setAuthorName(String value) { authorName = value; }
    
    public int getYear() { return year; }
    public void setYear(int value) { year = value; }
    
    public int getPage() { return page; }
    public void setPage (int value) { page = value; }

    public String toString()
    {
        return 
            "[Book: " +
            "bookName = " + bookName + " " +
            "authorName = " + authorName + " " +
            "year = " + year + " " +
            "page = " + page +
            "]";
    }
    
    public boolean equals(Object rhs)
    {
        if (rhs == this)
            return true;
        
        if (!(rhs instanceof Book))
            return false;
        
        Book other = (Book)rhs;
        return (this.bookName.equals(other.bookName) &&
                this.authorName.equals(other.authorName) &&
                this.year == other.year) &&
        		this.page == other.page;
    }
    
    private String bookName;
    private String authorName;
    private int year;
    private int page;
}