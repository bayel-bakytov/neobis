package dao;

import entity.Storage;
import exceptionDao.DaoException;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorageDao {

    private static final StorageDao INSTANCE = new StorageDao();
    private Connection connection = null;
    private static final String DELETE_SQL = """
            DELETE FROM storage WHERE storage_id = ?;
            """;

    private static final String SAVE_SQL = """
            INSERT INTO storage (book_id, count)
            VALUES (?, ?);
            """;

    private static final String UPDATE_SQL = """
            UPDATE storage 
            SET book_id = ?,
                count = ?
            WHERE storage_id = ?   
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT storage_id,
                    book_id,
                    count
            FROM storage
            WHERE storage_id = ?
            """;
    private static final String FIND_ALL_SQL = """
              SELECT storage_id,
                    book_id,
                    count
                 FROM storage
            """;

    public List<Storage> findAll() {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
            ResultSet set = preparedStatement.executeQuery();
            List<Storage> storages = new ArrayList<>();
            while (set.next()) {
                storages.add(buildStorage(set));
            }
            return storages;
        } catch (SQLException e) {
            throw new DaoException(e);
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

    public Optional<Storage> findById(int id) {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            ResultSet set = preparedStatement.executeQuery();
            Storage storage = null;
            if (set.next()) {
                storage = buildStorage(set);
            }
            return Optional.ofNullable(storage);
        } catch (SQLException e) {
            throw new DaoException(e);
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

    public void update(Storage storage) {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(UPDATE_SQL);
            preparedStatement.setInt(1, storage.getBookId());
            preparedStatement.setInt(2, storage.getCountBook());
            preparedStatement.setInt(3, storage.getStorageId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
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

    public Storage save(Storage storage) {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, storage.getBookId());
            preparedStatement.setInt(2, storage.getCountBook());
            preparedStatement.executeUpdate();

            ResultSet set = preparedStatement.getGeneratedKeys();
            if (set.next()) {
                storage.setStorageId(set.getInt(1));
            }
            return storage;
        } catch (SQLException e) {
            throw new DaoException(e);
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

    public boolean delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(DELETE_SQL);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
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

    private Storage buildStorage(ResultSet resultSet) throws SQLException {
        return new Storage(
                resultSet.getInt("storage_id"),
                resultSet.getInt("book_id"),
                resultSet.getInt("count")
        );
    }

    public static StorageDao getInstance() {
        return INSTANCE;
    }

}
