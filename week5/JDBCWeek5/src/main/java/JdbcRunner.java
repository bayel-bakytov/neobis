import util.ConnectionManager;

public class JdbcRunner {
    public static void main(String[] args) {
        Author author = new Author();
        Book book = new Book();
        Customer customer = new Customer();
        Employee employee = new Employee();
        Genre genre = new Genre();
        Price price = new Price();

        try {
            author.insertAuthor("Dzhon","Keho");
            author.updateAuthorById(8,"Robert", "Martin");
            author.deleteAuthorById(5);
            author.selectAuthors();
            book.insertBook("dising pattern",2,2,1);
            book.updateBookByPriceId(5,"java");
            book.deleteBookById(9);
            book.selectBooks();
            customer.insertCustomer("naruto",
                             "uzumaki","45",
                            "bishkek","656215",
                           "123@gmail.com");
            customer.updateCustomersNameById(3,"vas","saw");
            customer.deleteCustomerById(3);
            customer.selectCustomers();
            employee.insertEmployeeWithDelCustomer("Vasya","Murkov", "123@gmail.com","3922",9999);
            employee.updateEmployeesNameById(1,"misha","petrov");
            employee.deleteEmployeeById(4);
            employee.selectEmployees();
            genre.insertGenre("horror", "about horror");
            genre.updateAuthorById(3,"love","about love");
            genre.deleteGenreById(3);
            genre.selectGenres();
            price.insertPrice(4500);
            price.updatePriceById(4,4000);
            price.deletePriceById(4);
            price.selectPrices();
        } finally {
            ConnectionManager.closePool();
        }
    }
}
