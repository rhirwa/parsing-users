package rhirwa;

import java.util.List;

public class Person {
	private String code;
	private String firstName;
	private String lastName;
	private PhysicalAddress address;
	private List<String> emailAddress;
	
	public Person(String code, String firstName, String lastName, PhysicalAddress physicalAddress, List<String> emailAddress) {
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = physicalAddress;
		this.emailAddress = emailAddress;
	}
	public String getCode() {
		return code;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public PhysicalAddress getAddress() {
		return address;
	}
	public List<String> getEmailAddress() {
		return emailAddress;
	}
}
