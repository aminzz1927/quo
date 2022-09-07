package com.quo.utils;

import java.lang.reflect.Field;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelWriter<T> {

	/**
	 * 根据数据返回workbook
	 * @param dataList 数据
	 * @param sheetName 表格名称
	 * @param clazz 类型
	 * @return 工作簿
	 */
	public XSSFWorkbook getWorkbook(List<T> dataList , String sheetName , Class clazz) {
		System.out.println("11111111111111111111111111111111111");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sheetName); 
		XSSFRow row0 = sheet.createRow(0);
		Field[] fields = clazz.getDeclaredFields(); 
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			XSSFCell cell = row0.createCell(i);
			cell.setCellValue(fieldName);
		}
		
		System.out.println("11111111111111111111111111111111111");
		
		try {
			for (int i = 0; i < dataList.size(); i++) {
				T obj = dataList.get(i);
				XSSFRow row = sheet.createRow(i + 1);
				for (int j = 0; j < fields.length; j++) {
					String propertyName = fields[j].getName();
					String getMethodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
					Method getMethod = clazz.getDeclaredMethod(getMethodName);
					Object value = getMethod.invoke(obj);
					XSSFCell cell = row.createCell(j);
					cell.setCellValue(value == null ? "" : value.toString());
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("11111111111111111111111111111111111");
		
		return workbook;
	}
}
