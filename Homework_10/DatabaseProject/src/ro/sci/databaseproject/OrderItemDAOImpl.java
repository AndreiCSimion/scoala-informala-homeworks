package ro.sci.databaseproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderItemDAOImpl extends AbstractModelDAO implements OrderItemDAO {

	@Override
	public void createItem(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "INSERT INTO orderitems " + "VALUES (1, '1', '3', '1')";
			st.executeUpdate(sql);
			String sql2 = "INSERT INTO orderitems " + "VALUES (2, '2', '32', '2')";
			st.executeUpdate(sql2);
			String sql3 = "INSERT INTO orderitems " + "VALUES (3, '3', '9', '3')";
			st.executeUpdate(sql3);
			System.out.println("Inserted value(s) into the table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteItem(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "DELETE FROM orderitems " + "WHERE id=1";
			st.executeUpdate(sql);
			String sql1 = "DELETE FROM orderitems " + "WHERE id=3";
			st.executeUpdate(sql1);
			System.out.println("Deleted value(s) from the table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateItem(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "UPDATE orderitems " + "SET id = 5 WHERE id in (1)";
			st.executeUpdate(sql);
			sql = "SELECT id, id_order, quantity, id_product FROM orderitems";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int id_order = rs.getInt("id_order");
				int quantity = rs.getInt("quantity");
				int id_product = rs.getInt("id_product");

				System.out.print("ID: " + id);
				System.out.print(", OrderID: " + id_order);
				System.out.print(", Quantity: " + quantity);
				System.out.print(", ProductID: " + id_product);

			}

			System.out.println("Selected all values from table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllItems(Connection connection) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%20s%30s%40s\n";
		try {

			String sqlQuery = "SELECT * FROM orderitems WHERE id>? AND id_order=? AND quantity=? AND id_product=?";
			ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, 1);
			ps.setInt(2, 1);
			ps.setInt(3, 3);
			ps.setInt(4, 1);

			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {
				System.out.format(format, "id", "id_order", "quantity", "id_product");
				do {
					System.out.format(format, rs.getInt("id"), rs.getInt("id_order"), rs.getInt("quantity"),
							rs.getInt("id_product"));

				} while (rs.next());
			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}
	}

}
