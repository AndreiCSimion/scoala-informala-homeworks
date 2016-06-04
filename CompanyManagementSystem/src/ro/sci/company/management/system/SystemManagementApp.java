package ro.sci.company.management.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is the entry point in the CompanyManagementSystem application.
 * <p>
 * It contains the main method and displays the list of employees without a
 * parking space.
 * <p>
 * 
 * @author Andrei Simion
 *
 */
public class SystemManagementApp {

	public static void main(String[] args) {

		// Company C1 = new Company();
		Employee E1 = new Employee("John", 40, "Project Manager", 7, true);
		Employee E2 = new Employee("Dan", 27, "Senior Developer", 6, true);
		Employee E3 = new Employee("Jack", 31, "Senior Developer", 4, true);
		Employee E4 = new Employee("Kate", 25, "Junior Developer", 1, false);
		Employee E5 = new Employee("Marley", 23, "Tester", 2, true);
		Employee E6 = new Employee("Bob", 25, "Tester", 1, false);
		Employee E7 = new Employee("Mary", 27, "HR", 3, true);
		Employee E8 = new Employee("Jane", 25, "HR", 1, false);

		Collection<Employee> listOfEmployees = new ArrayList<>();
		TreeMap<Integer, Employee> employeesWithoutParking = new TreeMap<>();
		listOfEmployees.add(E1);
		listOfEmployees.add(E2);
		listOfEmployees.add(E3);
		listOfEmployees.add(E4);
		listOfEmployees.add(E5);
		listOfEmployees.add(E6);
		listOfEmployees.add(E7);
		listOfEmployees.add(E8);
		employeesWithoutParking.put(1, E1);
		employeesWithoutParking.put(4, E2);
		employeesWithoutParking.put(2, E3);
		employeesWithoutParking.put(5, E4);
		employeesWithoutParking.put(3, E5);
		employeesWithoutParking.put(7, E6);
		employeesWithoutParking.put(6, E7);
		employeesWithoutParking.put(8, E8);

		for (Employee employee : listOfEmployees) {
			System.out.println(employee);

		}
		for (Map.Entry<Integer, Employee> entry : employeesWithoutParking.entrySet()) {

			employeesWithoutParking.comparator();
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}

	}

}
