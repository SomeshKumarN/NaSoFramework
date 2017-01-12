package nasofw.root;

import java.util.ArrayList;
import java.util.Iterator;

import nasofw.util.DynamicClass;

public class FrameworkManager {

	protected static ScriptManager scriptManagerSheet;
	protected static DataManager dataManagerSheet;
	public static SeleniumDriver webDriver;
	public static ArrayList<String> testCaseIds;
	static String currentTestCaseId;

	static {
		FrameworkManager.scriptManagerSheet = new ScriptManager();
		FrameworkManager.dataManagerSheet = new DataManager();
		FrameworkManager.testCaseIds = new ArrayList<>();
	}

	SeleniumDriver getWebDriver() {
		return webDriver;
	}

	static void setWebDriver(SeleniumDriver webDriver) {
		FrameworkManager.webDriver = new SeleniumDriver();
	}

	public static String getCurrentTestCaseId() {
		return currentTestCaseId;
	}

	static void setCurrentTestCaseId(String currentTestCaseId) {
		FrameworkManager.currentTestCaseId = currentTestCaseId;
	}

	public static void executeSuite() {
		testCaseIds = getExecutableTestCasesId(scriptManagerSheet.getAllTestCasesId());
		executeTestCases(testCaseIds);
		closeAllConnection();
	}

	private static void closeAllConnection() {
		webDriver.close();

	}

	static ArrayList<String> getExecutableTestCasesId(ArrayList<String> allTestCasesIds) {
		Iterator<String> testCaseId = allTestCasesIds.iterator();
		while (testCaseId.hasNext()) {
			if ((scriptManagerSheet.getexecutionStatus(testCaseId.next().toString())).toUpperCase().equals(("NO"))) {
				testCaseId.remove();
			}
		}
		return allTestCasesIds;
	}

	static void executeTestCases(ArrayList<String> testCaseIds) {
		ArrayList<String> methods = new ArrayList<>();
		Iterator<String> testCaseId = testCaseIds.iterator();
		while (testCaseId.hasNext()) {
			setCurrentTestCaseId(testCaseId.next());
			methods = dataManagerSheet.getMethodKeywords(getCurrentTestCaseId());
			setWebDriver(webDriver);
			executeMethods(methods);
		}
	}

	static void executeMethods(ArrayList<String> methods) {
		Iterator<String> method = methods.iterator();
		System.out.println(methods);
		while (method.hasNext()) {
			DynamicClass.callMethodOf(method.next());
		}
	}

}
