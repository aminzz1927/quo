//package com.quo.utils;
//
//import java.io.FileInputStream;
//
//
//
//
//import java.lang.reflect.Method;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.ExcelNumberFormat;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader<T> {
//
//	/**
//	 * 读取excel文件，获取List集合
//	 * @param excelPath
//	 * @param clazz
//	 * @return
//	 */
//	public List<T> read(String excelPath, Class clazz) {
//		List<T> dataList = new ArrayList<>();
//		try {
//			Workbook workbook = null;
//			if (excelPath.indexOf(".xlsx") > -1) {
//				workbook = new XSSFWorkbook(new FileInputStream(excelPath));
//			} else {
//				workbook = new HSSFWorkbook(new FileInputStream(excelPath));
//			}
//			Sheet sheet = workbook.getSheetAt(0);
//			Row row0 = sheet.getRow(0);
//			int totalColumns = row0.getLastCellNum();
//			String[] propertyNames = new String[totalColumns];
//			for (int i = 0; i < totalColumns; i++) {
//				Cell cell = row0.getCell(i);
//				String cellValue = getCellValue(cell);
//				propertyNames[i] = cellValue;
//			}
//			int totalRows = sheet.getPhysicalNumberOfRows();
//			for (int i = 1; i < totalRows; i++) {
//				Row row = sheet.getRow(i);
//				if (row != null) {
//					T obj = (T)clazz.newInstance();
//					for (int j = 0; j < totalColumns; j++) {
//						Cell cell = row.getCell(j);
//						String cellValue = getCellValue(cell);
//						String propertyName = propertyNames[j];
//						String methodName = "set" + propertyName.substring(0, 1).toUpperCase()
//								+ propertyName.substring(1);
//						Method setMethod = clazz.getDeclaredMethod(methodName, String.class);
//						setMethod.invoke(obj, cellValue);
//					}
//					dataList.add(obj);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dataList;
//	}
//	
//	/**
//	 * 根据单元格获取单元格当中的文本
//	 * @param cell
//	 * @return
//	 */
//	private static String getCellValue(Cell cell) {
//		  String cellValue = "";
//	        if (cell == null) return null;//cell不编辑则获取的cell为null
//	        switch (cell.getCellType()) {
//	            case STRING:
//	                cellValue = cell.getStringCellValue();
//	                break;
//	            case NUMERIC:
//	                if (DateUtil.isADateFormat(ExcelNumberFormat.from(cell.getCellStyle()))) {
//	                    Date date = cell.getDateCellValue();
//	                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//	                    cellValue = simpleDateFormat.format(date);
//	                } else {
//	                    cellValue = String.valueOf(cell.getNumericCellValue());
//	                }
//	                break;
//	            case FORMULA:
//	                cell.setCellType(CellType.NUMERIC);
//	                cellValue = String.valueOf(cell.getNumericCellValue());
//	                break;
//	            case BOOLEAN:
//	                cellValue = String.valueOf(cell.getBooleanCellValue());
//	                break;
//	            case ERROR:
//	                cellValue = String.valueOf(cell.getErrorCellValue());
//	                break;
//	            case BLANK:
//	                break;
//	            case _NONE:
//	                break;
//	            default:
//	                break;
//	        }
//	        return cellValue;
//
//}
//}
