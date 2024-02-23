import java.util.*;
class Book {
    private String title;
    private String author;
    private int ISBN;
    private boolean isAvailable;

    public Book(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private List<Book> bookList;

    public Library() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        int i=1;
        for (Book book : bookList) {
            System.out.println(i+". "+book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getISBN() + ")");
            i++;
        }
    }

    public Book findBookByISBN(int ISBN) {
        for (Book book : bookList) {
            if (book.getISBN() == ISBN) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(int ISBN) {
        Book book = findBookByISBN(ISBN);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public void returnBook(int ISBN) {
        Book book = findBookByISBN(ISBN);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Invalid book or already available.");
        }
    }
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding some sample books
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 123456));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 789012));
        library.addBook(new Book("1984", "George Orwell", 345678));
        library.addBook(new Book("The Complete Reference Java", "Herbert Schildt", 869451));
        library.addBook(new Book("Python Crash Course",  "Eric Matthes", 758961));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the ISBN of the book you want to borrow: ");
                    int borrowISBN = scanner.nextInt();
                    library.borrowBook(borrowISBN);
                    break;
                case 3:
                    System.out.print("Enter the ISBN of the book you want to return: ");
                    int returnISBN = scanner.nextInt();
                    library.returnBook(returnISBN);
                    break;
                case 4:
                    System.out.println("Exiting the Library Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}