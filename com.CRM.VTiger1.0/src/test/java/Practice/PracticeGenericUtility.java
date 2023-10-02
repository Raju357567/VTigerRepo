package Practice;

import com.CRM.VTiger1.GenericUtility.FileUtility;

public class PracticeGenericUtility {

	public static void main(String[] args) throws Throwable {
		FileUtility fu = new FileUtility();
		// propertiesfile data
		String BROWSER = fu.getDataFromPropertyFile("Browser");
		System.out.println(BROWSER);
		// Excelsheet data
		String username = fu.getDataFromexcelSheet("Sheet1", 0, 0);
		System.out.println(username);

		String value = fu.getDataFromexcelSheet("Class", 0, 0);
		System.out.println(value);
	}
}
