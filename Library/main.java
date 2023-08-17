public class Library {
    
    private Book first;
    private int total;

    private static class Book {
        private String title;
        private String author;
        private double cost;
        private Book next;

        Book(String title, String author, double cost) {
            this.title = title;
            this.author = author;
            this.cost = cost;
            this.next = null;
        }

        Book(Book old) {
            this.title = old.title;
            this.author = old.author;
            this.cost = old.cost;
            this.next = null; 
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public double getCost() {
            return cost;
        }

        public Book getNext() {
            return next;
        }

        public void setNext(Book next) {
            this.next = next;
        }
    }

    public Library() {
        first = null;
        total = 0;
    }

    public Library(Library deepcopy) {
        Book current = deepcopy.first;
        Book last = null;
        this.total = deepcopy.total;

        while (current != null) {
            Book newBook = new Book(current);
            if (last == null) {
                first = newBook;
            } else {
                last.setNext(newBook);
            }
            last = newBook;
            current = current.getNext();
        }
    }

    public void add(String title, String author, double cost) {
        if (total < 5) {
            if (first == null) {
                first = new Book(title, author, cost);
                total++;
            } else {
                Book temp = first;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(new Book(title, author, cost));
                total++;
            }
        } else {
            System.out.println("Your library is full.");
        }
    }

    public Book search(String title) {
        Book temp = first;
        while (temp != null) {
            if (temp.getTitle().equals(title)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void reverse() {
        Book pointer = first;
        Book previous = null, current = null;

        while (pointer != null) {
            current = pointer;
            pointer = pointer.getNext();
            current.setNext(previous);
            previous = current;
            first = current;
        }
    }

    public void remove(String title) {
        Book temp = first;
        Book prev = null;

        if (temp != null && temp.getTitle().equals(title)) {
            first = temp.getNext();
            temp = null; // Dereference the book
            total--;
            return;
        }

        while (temp != null && !temp.getTitle().equals(title)) {
            prev = temp;
            temp = temp.getNext();
        }

        if (temp != null) {
            prev.setNext(temp.getNext());
            temp = null; // Dereference the book
            total--;
        }
    }

    public void clearLibrary() {
        first = null; 
        total = 0;
    }

    public boolean empty() {
        return total == 0; 
    }

    public boolean full() {
        return total == 5; 
    }

    public void display() {
        Book temp = first;
        while (temp != null) {
            System.out.println("Title: " + temp.getTitle());
            System.out.println("Author: " + temp.getAuthor());
            System.out.println("Cost: " + temp.getCost());
            temp = temp.getNext();
        }
    }

     public static void main(String[] args) {
        System.out.println("*********************************************");
        System.out.println("Beginning test with default constructor.");
        Library mylibrary = new Library();

        System.out.println("Lets start adding books to the collection.");
        mylibrary.add("Julius Caesar", "William Shakespeare", 12.99);
        mylibrary.add("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        mylibrary.add("The Canterbury Tales", "Geoffrey Chaucer", 14.99);
        mylibrary.add("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 13.99);
        mylibrary.add("Moby Dick", "Herman Melville", 10.99);
        mylibrary.display();

        System.out.println("Let's try adding a sixth book.");
        mylibrary.add("The Hunger Games", "Suzanne Collins", 11.99);

        System.out.println("*********************************************");
        System.out.println("Now it is time to copy the library");
        Library mylibrary2 = new Library(mylibrary);
        mylibrary2.display();

        System.out.println("*********************************************");
        System.out.println("Now I will reverse the collection order.");
        mylibrary2.reverse();
        mylibrary2.display();
        System.out.println("*********************************************");

        System.out.println("Now removing book from mylibrary.");
        mylibrary.remove("The Great Gatsby");
        mylibrary.display();
        System.out.println("*********************************************");
        System.out.println("Now lets add that book to the collection.");
        mylibrary.add("The Hunger Games", "Suzanne Collins", 11.99);
        mylibrary.display();
        System.out.println("*********************************************");

        System.out.println("Now clearing a library.");
        mylibrary.clearLibrary();
        System.out.println("Checking to see if library is empty.");
       
        if (mylibrary.empty())
            System.out.println("Empty");
        else
            System.out.println("Not Empty");
       
        System.out.println("*********************************************");

        System.out.println("Looking up an existing book.");
        Book temp = mylibrary2.search("The Canterbury Tales");
       
        if (temp != null)
            System.out.println(temp.getTitle());
       
        System.out.println("Looking up a book that doesn't exist.");
        Book temp2 = mylibrary2.search("What if...");
       
        if (temp2 != null)
            System.out.println(temp2.getTitle());
        else
            System.out.println("Book not found.");
       
        System.out.println("*********************************************");

        System.out.println("End of program run.");
    }
}
