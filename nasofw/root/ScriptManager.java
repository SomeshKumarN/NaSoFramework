package nasofw.root;

import java.util.ArrayList;
import nasofw.util.ExcelManipulator;;

public class ScriptManager extends ExcelManipulator {
	public ScriptManager() {
		super(FrameworkConfigProperties.getValueOf(Constants.FrameworkConfigFile.scriptManagerPath));
	}

	// String sheetName = "RunManager";

	public void test() {
		// System.out.println(getRowHeader(sheetName, 4));
		// System.out.println(getColumnHeader(sheetName, 2));
		// System.out.println(getRowHeader(0, 4));
		// System.out.println(getColumnHeader(0, 2));
		// System.out.println(getRowValues(sheetName, 4));
		// System.out.println(getRowValues(0, 3));
		// System.out.println(getColumnValues(sheetName, 2));
		// System.out.println(getColumnIndex("Execute"));
		// System.out.println(getRowIndex(sheetName, "Execute"));
		// System.out.println(getCellValue(0, 0));
		// System.out.println(getDataBasedOnRowAndColumnHeaderValues(sheetName,
		// "TC_01", "Execute"));
		// System.out.println(getDataBasedOnRowAndColumnHeaderValues(sheetName,
		// "TC_02", "Execute"));
		// System.out.println(getDataBasedOnRowAndColumnHeaderValues(0, "TC_02",
		// "Execute"));
		// System.out.println(getDataBasedOnRowAndColumnHeaderValues(0, "TC_01",
		// "Execute"));
		// System.out.println(getexecutionStatus("TC_01"));
		// System.out.println(getDescription("TC_01"));
		// System.out.println(getBrowser("TC_01"));
		// System.out.println(getPlatform("TC_01"));
		System.out.println(getOperatingSystem("TC_01"));
//		System.out.println(getAllTestCasesId());
		
	}

	public void getTestCase() {

	}

	public ArrayList<String> getAllTestCasesId() {
		ArrayList<String> testCases = new ArrayList<>();
		testCases = getColumnValues(Constants.ScriptManager.runManagerSheet, 0);
		testCases.remove(0);
		return testCases;
	}

	public ArrayList<String> getKeywords(String testCaseID) {
		ArrayList<String> keywords = new ArrayList<>();
		keywords = getRowValues(Constants.ScriptManager.runManagerSheet, getRowIndex(testCaseID));
		keywords.remove(0);
		return keywords;
	}

	public String getexecutionStatus(String testCaseId) {
		return getDataBasedOnRowAndColumnHeaderValues(testCaseId, Constants.ScriptManager.executionStatus);
	}

	public String getDescription(String testCaseId) {
		return getDataBasedOnRowAndColumnHeaderValues(testCaseId, Constants.ScriptManager.description);
	}

	public String getBrowser(String testCaseId) {
		return getDataBasedOnRowAndColumnHeaderValues(testCaseId, Constants.ScriptManager.browser);
	}

	public String getOperatingSystem(String testCaseId) {
		return getDataBasedOnRowAndColumnHeaderValues(testCaseId, Constants.ScriptManager.operatingSystem);
	}

	public String getPlatform(String testCaseId) {
		return getDataBasedOnRowAndColumnHeaderValues(testCaseId, Constants.ScriptManager.platform);
	}

}
