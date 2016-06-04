package ro.sci.company.management.system;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class ArrayTest {

	private ArrayList<Employee> listOfEmployees;

	@Test
	public void test() {
		ArrayList<Employee> listOfEmployees = new ArrayList<>();
		// assertEquals(8, getEmployeeList(), 0);
	}

	public ArrayList<Employee> getEmployeeList() {
		return listOfEmployees;
	}
}
