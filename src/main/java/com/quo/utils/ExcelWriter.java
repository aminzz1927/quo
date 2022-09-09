package com.quo.utils;

import java.lang.reflect.Field;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.quo.entity.ProductExport;


public class ExcelWriter<T> {

	/**
	 * 根据数据返回workbook
	 * 
	 * @param dataList  数据
	 * @param sheetName 表格名称
	 * @param clazz     类型
	 * @return 工作簿
	 */
	public XSSFWorkbook getWorkbook(List<T> dataList, String sheetName, Class clazz, String[] arrays) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sheetName);
		XSSFRow row0 = sheet.createRow(0);
		CellStyle Headstyle = workbook.createCellStyle();
		CellStyle HeadStyleCenter = workbook.createCellStyle();
		XSSFFont Headfont = workbook.createFont();
		Headfont.setBold(true);
		Headfont.setFontHeight(11);
		Headfont.setFontName("Microsoft Yahei");
		Headstyle.setFont(Headfont);
		Headstyle.setAlignment(HorizontalAlignment.CENTER);
		HeadStyleCenter.setFont(Headfont);
		HeadStyleCenter.setAlignment(HorizontalAlignment.CENTER);
//	    String cellWidth = "00000000000";
//        for (int i=0; i<arrays.length; i++) {
//        	createCell(row0, i, cellWidth, style);
//        	sheet.autoSizeColumn(i);
//        }
		for (int i = 0; i < arrays.length; i++) {
			XSSFCell cell = row0.createCell(i);
			cell.setCellValue(arrays[i]);
			createCell(row0, i, arrays[i], Headstyle);
		}

		Field[] fields = clazz.getDeclaredFields(); // 获取所有字段
		try {
			for (int i = 0; i < dataList.size(); i++) {
				
				T obj = dataList.get(i);
				XSSFRow row = sheet.createRow(i + 1);
				
				for (int j = 0; j < fields.length; j++) {
					//createCell(row, colIdx++, String.format("%04d", p.getPid()), styleCenter);
					String propertyName = fields[j].getName();
					String getMethodName = "get" + propertyName.substring(0, 1).toUpperCase()
							+ propertyName.substring(1);
					Method getMethod = clazz.getDeclaredMethod(getMethodName);
					Object value = getMethod.invoke(obj);
					String cellStr;
					//XSSFCell cell = row.createCell(j);
					if(value!=null) {
						cellStr = value.toString();
						//cell.setCellValue(value.toString());
					}else {
						cellStr = "";
						//cell.setCellValue("");
					}
					CellStyle style = workbook.createCellStyle();
					CellStyle styleCenter = workbook.createCellStyle();
					XSSFFont font = workbook.createFont();
					font.setBold(false);
					font.setFontHeight(11);
					style.setFont(font);
					style.setAlignment(HorizontalAlignment.CENTER);
					styleCenter.setFont(font);
					styleCenter.setAlignment(HorizontalAlignment.CENTER);
					createCell(row, j, cellStr, style);
					//cell.setCellValue(value.toString());
					//cell.setCellStyle(style);
					// createCell(row, j, value.toString(), style);
					//cell.setCellValue(value == null ? "" : value.toString());
				}
			}
//			
//			int rowIdx = 1;
//	        
//	        for (ProductExport p : list) {
//	        	Row row = sheet.createRow(rowIdx++);
//	        	int colIdx = 0;
//	        	
//	        	createCell(row, colIdx++, String.format("%04d", p.getPid()), styleCenter);
//	        	createCell(row, colIdx++, p.getPname(), styleCenter);
//	        	createCell(row, colIdx++, p.getTname(), style);
//	        	createCell(row, colIdx++, p.getPsname(), style);
//	        	createCell(row, colIdx++, p.getPrice(), style);
//	        	createCell(row, colIdx++, p.getStock(), style);
//	        	createCell(row, colIdx++, p.getConnection(), style);
//	        	createCell(row, colIdx++, p.getPInterface(), style);
//	        	createCell(row, colIdx++, p.getNoise(), style);
//	        	createCell(row, colIdx++, p.getBass(), style);
//	        	createCell(row, colIdx++, p.getWaterproof(), style);
//	        	createCell(row, colIdx++, p.getMic(), style);
//	        	createCell(row, colIdx++, p.getPackageInfo(), style);
//	        }
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
		
		for (int i = 0; i < arrays.length; i++) {
			sheet.autoSizeColumn(i);
			int currentColumnWidth = sheet.getColumnWidth(i);
			sheet.setColumnWidth(i, (currentColumnWidth + 500));
		}

		return workbook;
	}

	



	private void createCell(XSSFRow row0, int i, String value, CellStyle style) {
		Cell cell = row0.createCell(i);
		cell.setCellValue(value);
		cell.setCellStyle(style);
		
	}
	
//	private void createCell(Row row, int colIdx, Object value, CellStyle style) {
//		Cell cell = row.createCell(colIdx);
//		cell.setCellValue(value);
//		cell.setCellStyle(style);
//	}
//	
//	private void createCell(Row row, int colIdx, Object value, CellStyle style) {
//		Cell cell = row.createCell(colIdx);
//		cell.setCellValue(value);
//		cell.setCellStyle(style);
//	}
}
