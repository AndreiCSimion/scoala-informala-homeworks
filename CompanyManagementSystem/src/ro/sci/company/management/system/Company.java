package ro.sci.company.management.system;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * This class models the company of employees that are ordered in specific
 * lists(arrays, maps etc).
 * <p>
 * 
 * @author Andrei Simion
 *
 */
public class Company {

	ArrayList<Employee> listOfEmployees = new ArrayList<>();
	ArrayList<Employee> seniorDevelopers = new ArrayList<>();
	ArrayList<Employee> juniorDevelopers = new ArrayList<>();
	ArrayList<Employee> humanResources = new ArrayList<>();
	ArrayList<Employee> managers = new ArrayList<>();
	ArrayList<Employee> testers = new ArrayList<>();
	TreeMap<Integer, ArrayList<Employee>> employeesWithoutParking = new TreeMap<>();

	public void sortEmployees(boolean hasParkingSpace) throws Exception {
		for (Employee employee : listOfEmployees) {
			if (hasParkingSpace == false) {
				employeesWithoutParking.put(0, listOfEmployees);
			} else {
				throw new Exception();
			}
		}
	}

	public TreeMap<Integer, ArrayList<Employee>> getEmployeesWithoutParking() {
		return employeesWithoutParking;
	}

}
