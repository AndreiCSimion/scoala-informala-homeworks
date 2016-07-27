package ro.sci.databaseproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAOImpl extends AbstractModelDAO implements ProductDAO {

	@Override
	public void createProduct(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "INSERT INTO products " + "VALUES (1, 'pan', 'non-stick frying pan')";
			st.executeUpdate(sql);
			String sql2 = "INSERT INTO products " + "VALUES (2, 'tv', 'wide flatscreen tv')";
			st.executeUpdate(sql2);
			String sql3 = "INSERT INTO products " + "VALUES (3, 'vacuum', '1900W vacuum cleaner')";
			st.executeUpdate(sql3);
			System.out.println("Inserted value(s) into the table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "DELETE FROM products " + "WHERE id=1";
			st.executeUpdate(sql);
			String sql1 = "DELETE FROM products " + "WHERE id=3";
			st.executeUpdate(sql1);
			System.out.println("Deleted value(s) from the table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "UPDATE products " + "SET id = 5 WHERE id in (1)";
			st.executeUpdate(sql);
			sql = "SELECT id, name, description FROM products";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String productName = rs.getString("name");
				String description = rs.getString("description");

				System.out.print("ID: " + id);
				System.out.print(", Name: " + productName);
				System.out.print(", Description: " + description);
			}

			System.out.println("Selected all values from table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllProducts(Connection connection) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%20s%30s\n";
		try {

			String sqlQuery = "SELECT * FROM products WHERE id>? AND name=? AND description=?";
			ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, 2);
			ps.setString(2, "pan");
			ps.setString(3, "non-stick frying pan");

			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {
				System.out.format(format, "id", "name", "description");
				do {
					System.out.format(format, rs.getInt("id"), rs.getString("name"), rs.getString("description"));

				} while (rs.next());
			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}
	}

}
