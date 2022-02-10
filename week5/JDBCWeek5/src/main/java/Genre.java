import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Genre {
    private Connection connection = null;

    public void insertGenre(String genreName, String description) {
        PreparedStatement preparedStatement = null;
        String sql = """ 
                INSERT INTO category (name, description) 
                VALUES (?, ?)
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, genreName);
            preparedStatement.setString(2, description);
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

    public void deleteGenreById(int genreId) {
        PreparedStatement preparedStatement = null;
        String sql = """
                DELETE FROM category WHERE genre_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, genreId);
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

    public void selectGenres() {
        PreparedStatement preparedStatement = null;
        String sql = """
                SELECT * FROM category
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet genres = preparedStatement.executeQuery();
            while (genres.next()) {
                int genreId = genres.getInt("genre_id");
                String genreName = genres.getString("name");
                String description = genres.getString("description");
                System.out.println("id: " + genreId + " genre: " + genreName + " description: " + description);
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

    public void updateAuthorById(int genreId, String genreName, String description) {
        PreparedStatement preparedStatement = null;

        String sql = """
                UPDATE category 
                SET name = ?, description = ?
                WHERE genre_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, genreName);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, genreId);
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
