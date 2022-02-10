import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Author {

    private Connection connection = null;

    public void insertAuthor(String firstName, String lastName) {
        PreparedStatement preparedStatement = null;
        String sql = """
                INSERT INTO authors (first_name, last_name) 
                VALUES (? , ?)
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) {
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

    public void deleteAuthorById(int authorId) {
        PreparedStatement preparedStatement = null;
        String sql = """
                DELETE FROM authors WHERE author_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, authorId);
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
                if(connection != null) {
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

    public void selectAuthors() {
        PreparedStatement preparedStatement = null;
        String sql = """
                SELECT * FROM authors
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet authors = preparedStatement.executeQuery();
            while (authors.next()) {
                int authorId = authors.getInt("author_id");
                String firstName = authors.getString("first_name");
                String lastName = authors.getString("last_name");
                System.out.println("id: " + authorId + " " + firstName + " " + lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) {
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

    public void updateAuthorById(int authorId, String firstName, String lastName) {
        PreparedStatement preparedStatement = null;
        String sql = """
                UPDATE authors 
                SET first_name = ?, last_name = ?
                WHERE author_id = ?
                """;
        try  {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, authorId);
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
                if(connection != null) {
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
