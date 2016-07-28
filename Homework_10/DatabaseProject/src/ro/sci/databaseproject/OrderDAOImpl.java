package ro.sci.databaseproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDAOImpl extends AbstractModelDAO implements OrderDAO {

	@Override
	public void createOrder(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "INSERT INTO orders " + "VALUES (1, '230', '2016.8.8', 'yes', 1)";
			st.executeUpdate(sql);
			String sql2 = "INSERT INTO orders " + "VALUES (2, '400', '2016.8.9', 'no', 2)";
			st.executeUpdate(sql2);
			String sql3 = "INSERT INTO orders " + "VALUES (3, '500', '2016.8.10', 'yes', 3)";
			st.executeUpdate(sql3);
			System.out.println("Inserted value(s) into the table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "DELETE FROM orders " + "WHERE id=1";
			st.executeUpdate(sql);
			String sql1 = "DELETE FROM orders " + "WHERE id=3";
			st.executeUpdate(sql1);
			System.out.println("Deleted value(s) from the table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllOrders(Connection connection) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Date date = null;

		final String format = "%10s%20s%30s%40s%50s\n";
		try {

			String sqlQuery = "SELECT * FROM orders WHERE id>? AND value=? AND date=? AND confirmed=? AND id_customer=?";
			ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, 2);
			ps.setInt(2, 230);
			ps.setDate(3, date);
			ps.setBoolean(4, true);
			ps.setInt(5, 1);

			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {
				System.out.format(format, "id", "value", "date", "confirmed", "id_customer");
				do {
					System.out.format(format, rs.getInt("id"), rs.getInt("value"), rs.getDate("date"),
							rs.getBoolean("confirmed"), rs.getInt("id_customer"));

				} while (rs.next());
			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}
	}

	@Override
	public void updateOrder(Connection connection) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = "UPDATE orders " + "SET id = 5 WHERE id in (1)";
			st.executeUpdate(sql);
			sql = "SELECT id, value, date, confirmed, id_customer FROM orders";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int value = rs.getInt("value");
				Date date = rs.getDate("date");
				boolean confirmed = rs.getBoolean("confirmed");
				int id_customer = rs.getInt("id_customer");

				System.out.print("ID: " + id);
				System.out.print(", Value: " + value);
				System.out.print(", Date: " + date);
				System.out.print(", Confirmed: " + confirmed);
				System.out.print(", Customer_ID: " + id_customer);
			}

			System.out.println("Selected all values from table...");
		} catch (SQLException se) {
			System.err.println("Cannot execute query: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
