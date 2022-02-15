import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private Connection connection = null;

    public void insertEmployeeWithDelCustomer(String firstName,
                                              String lastName,
                                              String email,
                                              String phoneNumber,
                                              double salary
    ) {
        PreparedStatement preparedStatement = null;
        PreparedStatement prSecond = null;
        String sql = """ 
                INSERT INTO employees (
                first_name, 
                last_name,
                email,  
                phone_number,
                salary
                )
                VALUES (?, ?, ?, ?, ?)
                """;
        String sqlQuery = """ 
                DELETE FROM customers WHERE customer_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            prSecond = connection.prepareStatement(sqlQuery);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setDouble(5, salary);
            preparedStatement.executeUpdate();
            prSecond.setInt(1, 4);
            prSecond.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("no ");
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException sqlExs) {
                new RuntimeException(sqlExs);
            }
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
            try {
                if (prSecond != null) {
                    prSecond.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteEmployeeById(int employeeId) {
        PreparedStatement preparedStatement = null;
        String sql = """
                DELETE FROM employees WHERE employee_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
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

    public void updateEmployeesNameById(int employeeId, String firstName, String lastName) {
        PreparedStatement preparedStatement = null;
        String sql = """
                UPDATE employees 
                SET first_name = ?, last_name = ?
                WHERE employee_id = ?
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, employeeId);
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

    public void selectEmployees() {
        PreparedStatement preparedStatement = null;
        String sql = """
                SELECT * FROM employees
                """;
        try {
            connection = ConnectionManager.get();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet customers = preparedStatement.executeQuery();
            while (customers.next()) {
                int employeeId = customers.getInt("employee_id");
                String firstName = customers.getString("first_name");
                String lastName = customers.getString("last_name");
                String email = customers.getString("email");
                String phoneNumber = customers.getString("phone_number");
                String salary = customers.getString("salary");
                System.out.println("id: " + employeeId + " " + firstName + " " + lastName
                        + " phone: " + phoneNumber + " email " + email + " salary: " + salary);
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
