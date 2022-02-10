import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {

    private Connection connection = null;

    public void insertBook(String title, int authorId,
                           int priceId, int genreId) {
        PreparedStatement preparedStatement = null;
        String sql = """
                INSERT INTO books (title, author_id,price_id,genre_id) 
                VALUES (?,?,?,?)
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, authorId);
            preparedStatement.setInt(3, priceId);
            preparedStatement.setInt(4, genreId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteBookById(int bookId) {
        PreparedStatement preparedStatement = null;
        String sql = """
                DELETE FROM books WHERE book_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookId);
            int countChanges = preparedStatement.executeUpdate();
            if (countChanges != 0) {
                System.out.println("Success");
            } else {
                System.out.println("Not success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectBooks() {
        PreparedStatement preparedStatement = null;
        String sql = """
                SELECT book_id, title FROM books
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet books = preparedStatement.executeQuery();
            while (books.next()) {
                int bookId = books.getInt("book_id");
                String title = books.getString("title");
                System.out.println("id: " + bookId + " titleName: " + title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateBookByPriceId(int bookId, String title) {
        PreparedStatement preparedStatement = null;
        String sql = """
                UPDATE books 
                SET title = ?
                WHERE book_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, bookId);
            int countChanges = preparedStatement.executeUpdate();
            if (countChanges != 0) {
                System.out.println("Success");
            } else {
                System.out.println("Not success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
