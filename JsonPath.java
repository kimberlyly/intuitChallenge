/*
 * Class Name: JsonPath
 * Description: This class produces a JSON map with static JSON data.
 *				A user can enter one or more elements, and the program
 *				will output the path in O(1) time.
 * Usage: java JsonPath element1 [element2...elementN]
 */

import java.util.HashMap;

public class JsonPath {
	// The static map which connects element with its path
	public static HashMap<String, String> jsonMap = 
												new HashMap<String, String>();
	
	/* Method name: main
	 * Description: The main driver for the program. It parses the
	 *				input from the command line, and prints a usage
	 *				error if it is incorrect.
	 * Returns: void
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage: java JsonPath " +
				"element1 [element2...elementN");
			return;
		}

		buildMap(); // build the JSON mappings

		// loop through all elements
		for (int i = 0; i < args.length; i++) {
			String jsonElement = args[i];
			System.out.println(jsonElement + " - " + getPath(jsonElement));
		}
	}

	/* Method name: getPath
	 * Description: Searches the map for the specified element and returns
	 *				the path.
	 * Parameters: String value - the element you want to retrieve
	 * Returns: String representation of path.
	 */
	public static String getPath(String value) {
		String returnPath = jsonMap.get(value);
		if (returnPath == null) {
			System.out.print("No such element in JSON.");
			return null;
		}
		return returnPath;
	}

	/* Method name: buildMap
	 * Description: This method builds the mappings between all
	 *				elements and its path. Because the JSON is static,
	 *				and of relatively small size, I decided to hardcode
	 *				the paths for easier computing. However, I know that
	 *				if the JSON were larger, or if the JSON were expected
	 *				to change, I would have to parse the JSON. I would
	 *				be happy to talk to you about the different ways
	 *				I am thinking of! For this exercise, I believed this
	 *				to be the easiest solution, and the most efficient.
	 * Parameters: none
	 * Returns: none
	 */
	private static void buildMap() {
		jsonMap.put("itemList", "/itemList");
		jsonMap.put("items", "/itemList/items");
		jsonMap.put("item1", "/itemList/items/item[0]/id");
		jsonMap.put("item2", "/itemList/items/item[1]/id");
		jsonMap.put("Item 2", "/itemList/items/item[1]/label");
		jsonMap.put("item3", "/itemList/items/item[2]/id");
		jsonMap.put("item4", "/itemList/items/item[3]/id");
		jsonMap.put("item5", "/itemList/items/item[4]/id");
		jsonMap.put("subItem1", "/itemList/items/item[5]/id");
		jsonMap.put("subItem1Item1", "/itemList/items/item[5]/subItems[0]/id");
		jsonMap.put("SubItem 1", "/itemList/items/item[5]/subItems[0]/label");
		jsonMap.put("subItem1Item2", "/itemList/items/item[5]/subItems[1]/id");
		jsonMap.put("SubItem 2", "/itemList/items/item[5]/subItems[1]/label");
		jsonMap.put("subItem1Item3", "/itemList/items/item[5]/subItems[2]/id");
		jsonMap.put("SubItem 3", "/itemList/items/item[5]/subItems[2]/label");
		jsonMap.put("item6", "/itemList/items/item[6]/id");
		jsonMap.put("item7", "/itemList/items/item[7]/id");
		jsonMap.put("Item 7", "/itemList/items/item[7]/label");
		jsonMap.put("subItem2", "/itemList/items/item[8]/id");
		jsonMap.put("subItem2Item1", "/itemList/items/item[8]/subItems[0]/id");
		jsonMap.put("SubItem 2 item1", "/itemList/items/item[8]/subItems[0]/label");
	}
}