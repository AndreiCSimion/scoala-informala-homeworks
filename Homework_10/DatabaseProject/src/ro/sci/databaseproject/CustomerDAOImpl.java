package ro.sci.databaseproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAOImpl extends AbstractModelDAO implements CustomerDAO {

	@Override
	public void createCustomer(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "INSERT INTO customers " + "VALUES (1, 'zarazar@gmail.com', 'Zara')";
			st.executeUpdate(sql);
			String sql2 = "INSERT INTO customers " + "VALUES (2, 'georgeg@gmail.com', 'George')";
			st.executeUpdate(sql2);
			String sql3 = "INSERT INTO customers " + "VALUES (3, 'costelc@gmail.com', 'Costel')";
			st.executeUpdate(sql3);
			System.out.println("Inserted value(s) into the table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "DELETE FROM customers " + "WHERE id=1";
			st.executeUpdate(sql);
			String sql1 = "DELETE FROM customers " + "WHERE id=3";
			st.executeUpdate(sql1);
			System.out.println("Deleted value(s) from the table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void getAllCustomers(Connection connection) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%20s%30s\n";
		try {

			String sqlQuery = "SELECT * FROM customers WHERE id>? AND name=? AND email=?";
			ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, 2);
			ps.setString(2, "costel");
			ps.setString(3, "costelc@gmail.com");

			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {
				System.out.format(format, "id", "name", "email");
				do {
					System.out.format(format);
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("email"));

				} while (rs.next());
			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}

	}

	@Override
	public void updateCustomer(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "UPDATE customers " + "SET id = 5 WHERE id in (1)";
			st.executeUpdate(sql);
			sql = "SELECT id, name, email FROM customers";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");

				System.out.print("ID: " + id);
				System.out.print(", Name: " + name);
				System.out.print(", email: " + email);
			}

			System.out.println("Selected all values from table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
