package ro.sci.company.management.system;

/**
 * This class models a generic employee.
 * <p>
 * It has fields such as name, age, role etc.
 * <p>
 * 
 * @author Andrei Simion
 *
 */
public class Employee implements Comparable<Employee> {
	private String name;
	private int age;
	private String role;
	private int seniority;
	private boolean hasParkingSpace;

	public Employee(String name, int age, String role, int seniority, boolean hasParkingSpace) {
		this.name = name;
		this.age = age;
		this.role = role;
		this.seniority = seniority;
		this.hasParkingSpace = hasParkingSpace;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getRole() {
		return role;
	}

	public int getSeniority() {
		return seniority;
	}

	public boolean isParkingSpace() {
		return hasParkingSpace;
	}

	public void setParkingSpace(boolean parkingSpace) {
		this.hasParkingSpace = parkingSpace;
	}

	@Override
	public String toString() {
		return "Employee [" + name + ", " + age + ", " + role + ", " + seniority + ", Has Parking Space? -->"
				+ hasParkingSpace + "]";
	}

	@Override
	public int compareTo(Employee compareEmployee) {
		int compareSeniority = ((Employee) compareEmployee).getSeniority();

		return compareSeniority - this.seniority;
	}

}
