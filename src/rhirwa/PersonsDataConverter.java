package rhirwa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PersonsDataConverter {
	
	public static List<Person> parseDataFile() {
		List<Person> result = new ArrayList<Person>();
		File f = new File("data/Persons.dat");
		try(Scanner s = new Scanner(f)){
			s.nextLine();
			while (s.hasNext()) {
				Person e = null;
				String line = s.nextLine();
				String tokens[] = line.split(";");
				String code = tokens[0];
				String tokens1[] = tokens[1].split(",");
				String firstName = tokens1[0];
				String lastName = tokens1[1];
				String tokens2[] = tokens[2].split(",");
				String street = tokens2[0];
				String city = tokens2[1];
				String state = tokens2[2];
				String zipcode = tokens2[3];
				String country = tokens2[4];

				List<String> emails = new ArrayList<>();
				if(tokens.length == 4) {
					String[] emailAddressTokens = tokens[3].split(",");
					for (String email : emailAddressTokens) {
						emails.add(email);
					}
				}
				PhysicalAddress address = new PhysicalAddress(street, city, state, zipcode,country);
				e = new Person(code, firstName, lastName, address, emails);
				result.add(e);
			}
			s.close();
		} catch(Exception e) {
			throw new RuntimeException(e);
		};
		return result;
	}
	public static void main(String[] args) throws IOException {
		List<Person> persons = parseDataFile();
		Collections.sort(persons, (a,b) -> a.getFirstName().compareToIgnoreCase(b.getFirstName()));
		StringBuilder ps = new StringBuilder();
		for(Person p: persons) {
			ps.append(String.format("%10s %10s %10s\n", p.getFirstName(), p.getLastName(), "emails = " + p.getEmailAddress()));
		}
		System.out.println(ps);
		try (FileWriter myWriter = new FileWriter("data/Persons.json")) {
			myWriter.write(ObjectToJson.JsonConverter(persons));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
