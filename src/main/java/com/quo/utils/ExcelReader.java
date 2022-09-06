package com.quo.utils;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader<T> {

	/**
	 * 读取excel文件，获取List集合
	 * @param excelPath
	 * @param clazz
	 * @return
	 */
	public List<T> read(String excelPath, Class clazz) {
		List<T> dataList = new ArrayList<>();
		try {
			Workbook workbook = null;
			if (excelPath.indexOf(".xlsx") > -1) {
				workbook = new XSSFWorkbook(new FileInputStream(excelPath));
			} else {
				workbook = new HSSFWorkbook(new FileInputStream(excelPath));
			}
			Sheet sheet = workbook.getSheetAt(0);
			Row row0 = sheet.getRow(0);
			int totalColumns = row0.getLastCellNum();
			String[] propertyNames = new String[totalColumns];
			for (int i = 0; i < totalColumns; i++) {
				Cell cell = row0.getCell(i);
				String cellValue = getCellValue(cell);
				propertyNames[i] = cellValue;
			}
			int totalRows = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < totalRows; i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					T obj = (T)clazz.newInstance();
					for (int j = 0; j < totalColumns; j++) {
						Cell cell = row.getCell(j);
						String cellValue = getCellValue(cell);
						String propertyName = propertyNames[j];
						String methodName = "set" + propertyName.substring(0, 1).toUpperCase()
								+ propertyName.substring(1);
						Method setMethod = clazz.getDeclaredMethod(methodName, String.class);
						setMethod.invoke(obj, cellValue);
					}
					dataList.add(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}
	
	/**
	 * 根据单元格获取单元格当中的文本
	 * @param cell
	 * @return
	 */
	private static String getCellValue(Cell cell) {
		DecimalFormat df = new DecimalFormat("#");
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				return sdf.format(cell.getDateCellValue()).toString();
				// return
				// sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
			}
			return df.format(cell.getNumericCellValue());
		case Cell.CELL_TYPE_STRING:
			// System.out.println(cell.getStringCellValue());
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		case Cell.CELL_TYPE_BLANK:
			return "";
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue() + "";
		case Cell.CELL_TYPE_ERROR:
			return cell.getErrorCellValue() + "";
		}
		return "";
	}

}
