package com.quo.utils;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.quo.entity.ProductExport;



public class ProductExcelExporter {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<ProductExport> list;
	
	public ProductExcelExporter(List<ProductExport> list) {
		this.list = list;
		workbook = new XSSFWorkbook();
	}
	
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();
		
		try (ServletOutputStream outputStream = response.getOutputStream()) {
			workbook.write(outputStream);
			workbook.close();
		}
	}
	
	private void writeHeaderLine() {
		sheet = workbook.createSheet("Products");
		
		Row row = sheet.createRow(0);
        
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(11);
        font.setFontName("Microsoft Yahei");
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        
        String[] headers = {"产品编号","产品名称","产品类型名称","产品系列名称","价格","库存","耳机连接方式","耳机接口","降噪","重低音","防水功能","麦克风","包装清单"};
        
        String cellWidth = "00000000";
        for (int i=0; i<headers.length; i++) {
        	createCell(row, i, cellWidth, style);
        	sheet.autoSizeColumn(i);
        }
        
        for (int i=0; i<headers.length; i++) {
        	createCell(row, i, headers[i], style);
        }
	}
	
	private void writeDataLines() {
		int rowIdx = 1;
		
		CellStyle style = workbook.createCellStyle();
		CellStyle styleCenter = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(11);
        font.setFontName("Microsoft Yahei");
        style.setFont(font);
        styleCenter.setFont(font);
        styleCenter.setAlignment(HorizontalAlignment.CENTER);
        
        for (ProductExport p : list) {
        	Row row = sheet.createRow(rowIdx++);
        	int colIdx = 0;
        	
        	createCell(row, colIdx++, String.format("%04d", p.getPid()), styleCenter);
        	createCell(row, colIdx++, p.getPname(), styleCenter);
        	createCell(row, colIdx++, p.getTname(), style);
        	createCell(row, colIdx++, p.getPsname(), style);
        	createCell(row, colIdx++, p.getPrice(), style);
        	createCell(row, colIdx++, p.getStock(), style);
        	createCell(row, colIdx++, p.getConnection(), style);
        	createCell(row, colIdx++, p.getPInterface(), style);
        	createCell(row, colIdx++, p.getNoise(), style);
        	createCell(row, colIdx++, p.getBass(), style);
        	createCell(row, colIdx++, p.getWaterproof(), style);
        	createCell(row, colIdx++, p.getMic(), style);
        	createCell(row, colIdx++, p.getPackageInfo(), style);
        }
        
	}
	
	private void createCell(Row row, int colIdx, double value, CellStyle style) {
		Cell cell = row.createCell(colIdx);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}
	
	private void createCell(Row row, int colIdx, String value, CellStyle style) {
		Cell cell = row.createCell(colIdx);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}
}
