package nasofw.root;

import java.util.ArrayList;
import nasofw.util.*;

public class DataManager extends ExcelManipulator {

	public DataManager() {
		super(FrameworkConfigProperties.getValueOf(Constants.FrameworkConfigFile.dataManagerPath));
	}

	public void test() {
		System.out.println(getMethodKeywords("TC_03"));
	}

	public ArrayList<String> getMethodKeywords(String testCaseID) {
		ArrayList<String> keywords = new ArrayList<>();
		keywords = getRowValues(Constants.DataManager.keyWordManagerSheet, getRowIndex(testCaseID));
		keywords.remove(0);
		return keywords;

	}

}
