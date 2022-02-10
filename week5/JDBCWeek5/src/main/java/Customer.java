import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private Connection connection = null;

    public void insertCustomer(String firstName,
                               String lastName,
                               String address,
                               String city,
                               String phoneNumber,
                               String email) {
        PreparedStatement preparedStatement = null;
        String sql = """ 
                INSERT INTO customers (
                first_name, 
                last_name, 
                address, 
                city, 
                phone_number,
                email) 
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            if (isValid(email)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, address);
                preparedStatement.setString(4, city);
                preparedStatement.setString(5, phoneNumber);
                preparedStatement.setString(6, email);
                preparedStatement.executeUpdate();
            } else {
                System.out.println("Email is not valid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
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

    private boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public void deleteCustomerById(int customerId) {
        PreparedStatement preparedStatement = null;
        String sql = """
                DELETE FROM customers WHERE customer_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
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

    public void updateCustomersNameById(int customerId, String firstName, String lastName) {
        PreparedStatement preparedStatement = null;
        String sql = """
                UPDATE customers 
                SET first_name = ?, last_name = ?
                WHERE customer_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, customerId);
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

    public void selectCustomers() {
        PreparedStatement preparedStatement = null;
        String sql = """
                SELECT * FROM customers
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet customers = preparedStatement.executeQuery();
            while (customers.next()) {
                int customerId = customers.getInt("customer_id");
                String firstName = customers.getString("first_name");
                String lastName = customers.getString("last_name");
                String address = customers.getString("address");
                String city = customers.getString("city");
                String phoneNumber = customers.getString("phone_number");
                String email = customers.getString("email");
                System.out.println("id: " + customerId + " " + firstName + " " + lastName + " address: " + address
                + " city: " + city + " phone: " + phoneNumber + " email " + email);
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
