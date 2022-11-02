package rhirwa;

import java.util.List;

import com.google.gson.Gson;

public class ObjectToJson {
		public static String JsonConverter(List<Person> persons) {
		persons = PersonsDataConverter.parseDataFile();
		String json = new Gson().toJson(persons);
		return json;
		}

}
