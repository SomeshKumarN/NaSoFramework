package nasofw.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public abstract class ExcelManipulator {

	private String excelFilePath;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;

	protected ExcelManipulator(String excelFilePath) {
		try {
			this.setExcelFilePath(excelFilePath);
			File excelFile = new File(this.excelFilePath);
			FileInputStream excelFIStream = new FileInputStream(excelFile);
			this.workbook = new HSSFWorkbook(excelFIStream);
			this.sheet = workbook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			System.out.println("File: " + excelFilePath + " is not available");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String getExcelFilePath() {
		return excelFilePath;
	}

	protected void setExcelFilePath(String excelFilePath) {
		this.excelFilePath = excelFilePath;
	}

	protected final String getRowHeader(String sheetName, int rowNo) {
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		return row.getCell(0).toString();
	}

	protected final String getRowHeader(int sheetNo, int rowNo) {
		sheet = workbook.getSheetAt(sheetNo);
		Row row = sheet.getRow(rowNo);
		return row.getCell(0).toString();
	}

	protected final String getColumnHeader(String sheetName, int columnNo) {
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(columnNo);
		return cell.toString();
	}

	protected final String getColumnHeader(int sheetNo, int columnNo) {
		sheet = workbook.getSheetAt(sheetNo);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(columnNo);
		return cell.toString();
	}

	private ArrayList<String> getRowValues(int rowNo) {
		ArrayList<String> rowValules = new ArrayList<>();
		Row row = sheet.getRow(rowNo);
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			rowValules.add(cellIterator.next().toString());
		}
		return rowValules;
	}

	protected final ArrayList<String> getRowValues(String sheetName, int rowNo) {
		sheet = workbook.getSheet(sheetName);
		return getRowValues(rowNo);
	}

	protected final ArrayList<String> getRowValues(int sheetNo, int rowNo) {
		sheet = workbook.getSheetAt(sheetNo);
		return getRowValues(rowNo);

	}

	private ArrayList<String> getColumnValues(int columnNo) {
		ArrayList<String> columnValules = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			columnValules.add(row.getCell(columnNo).toString());
		}
		return columnValules;
	}

	protected final ArrayList<String> getColumnValues(String sheetName, int columnNo) {
		sheet = workbook.getSheet(sheetName);
		return getColumnValues(columnNo);
	}

	protected final ArrayList<String> getColumnValues(int sheetNo, int columnNo) {
		sheet = workbook.getSheetAt(sheetNo);
		return getColumnValues(columnNo);
	}

	public String getStringCellValue(Cell cell) {

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return Double.toString(cell.getNumericCellValue());

		case Cell.CELL_TYPE_BOOLEAN:
			return Boolean.toString(cell.getBooleanCellValue());

		case Cell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();

		default:
			return null;
		}

	}

	protected final int getColumnIndex(String lookUpValue) {
		Iterator<Row> rowIterator = sheet.iterator();
		int cellIndex = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (lookUpValue.equals(getStringCellValue(cell))) {
					return cellIndex;
				}
				cellIndex++;
			}
			cellIndex = 0;
		}
		return cellIndex;
	}

	protected final int getColumnIndex(String sheetName, String lookUpValue) {
		sheet = workbook.getSheet(sheetName);
		return getColumnIndex(lookUpValue);
	}

	protected final int getColumnIndex(int sheetNo, String lookUpValue) {
		sheet = workbook.getSheetAt(sheetNo);
		return getColumnIndex(lookUpValue);
	}

	protected final int getRowIndex(String lookUpValue) {
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (lookUpValue.equals(getStringCellValue(cell))) {
					return row.getRowNum();
				}
			}
		}
		return 0;
	}

	protected final int getRowIndex(String sheetName, String lookUpValue) {
		sheet = workbook.getSheet(sheetName);
		return getRowIndex(lookUpValue);
	}

	protected final int getRowIndex(int sheetNo, String lookUpValue) {
		sheet = workbook.getSheetAt(sheetNo);
		return getRowIndex(lookUpValue);
	}

	protected final String getCellValue(int rowIndex, int columnIndex) {
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(columnIndex);
		getStringCellValue(cell);
		return getStringCellValue(cell);
	}

	protected final String getDataBasedOnRowAndColumnHeaderValues(String rowLookUpValue, String columnLookUpValue) {
		return getCellValue(getRowIndex(rowLookUpValue), getColumnIndex(columnLookUpValue));
	}

	protected final String getDataBasedOnRowAndColumnHeaderValues(String sheetName, String rowLookUpValue,
			String columnLookUpValue) {
		sheet = workbook.getSheet(sheetName);
		return getDataBasedOnRowAndColumnHeaderValues(rowLookUpValue, columnLookUpValue);
	}

	protected final String getDataBasedOnRowAndColumnHeaderValues(int sheetNo, String rowLookUpValue,
			String columnLookUpValue) {
		sheet = workbook.getSheetAt(sheetNo);
		return getDataBasedOnRowAndColumnHeaderValues(rowLookUpValue, columnLookUpValue);
	}

}
