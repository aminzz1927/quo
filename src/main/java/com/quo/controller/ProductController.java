 package com.quo.controller;

import java.io.ByteArrayOutputStream;



import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.quo.annotation.Permission;
import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.*;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.entity.ProductType;
import com.quo.entity.Quote;
import com.quo.service.ProductService;
import com.quo.service.QuoteService;
import com.quo.utils.DownloadUtils;
import com.quo.utils.ExcelImportUtil;
import com.quo.utils.ExcelWriter;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;



/** 

* @author zhoumin
 * 

*/
@Controller("productController")
@RequestMapping(value="/api")
public class ProductController {

	@Autowired
	public ProductService pService;  
	
	@Autowired
	public QuoteService qService;

	
	     //????????????????????????		
			  @Permission(name = "product:view")
			  @RequestMapping(value="/product",method=RequestMethod.GET)
			  @ResponseBody 
			  public Result getProductList(){ 
				  
				  List<ProductsDto> plist =	pService.getProductList(); 
				  Result result=new Result(ResultCode.SUCCESS);
				  result.setData(plist);     
				  
				  return result;
			  
			  }
		  
		  //????????????????????????
		  @RequestMapping(value="/product/{pid}",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getProduct(@PathVariable Long pid){ 
			  ProductDto product = pService.getProduct(pid);
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(product);
			  return result;
		  
		  }
		  
		  //????????????????????????
		  @Permission(name = "product:edit")
		  @RequestMapping(value="/product/{pid}",method=RequestMethod.PUT)
		  @ResponseBody
		  public Result updateProduct(@PathVariable(value="pid") Long pid,@RequestBody Product product){ 
			  product.setPid(pid);		
			  pService.updateProduct(product);					
			  return new Result(ResultCode.SUCCESS);
		  
		  }		  		  
		  
		  //????????????????????????(????????????)
		
		  @RequestMapping(value="/product-type-list-edit",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeList(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }		
		  
		  //????????????????????????(????????????)
		  @RequestMapping(value="/product-type-list-add",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeListForNew(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }	
		  
		//????????????????????????(??????????????????)
		  @RequestMapping(value="/product-type-list-series-edit",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeListForSeries(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }	
		  
		//????????????????????????(??????????????????)
		  @RequestMapping(value="/product-type-list-series-add",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeListForNewSeries(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }	
		  	  
		  
		  //????????????????????????(????????????)
		  @RequestMapping(value="/product-series-list-edit",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getSeriesListForEdit(){ 
			  List<ProductSeries2> seriesList = pService.getSeriesList();
			  System.out.println("AAAAAAAAAA"+seriesList);
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(seriesList);
			  return result;
		  
		  }
		  
		  //????????????????????????(????????????)
		  @RequestMapping(value="/product-series-list-add",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getSeriesListForNew(){ 
			  List<ProductSeries2> seriesList = pService.getSeriesList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(seriesList);
			  return result;
		  
		  }
		  
		  
		  
		  //??????????????????
			/*	  @RequestMapping(value="/product/{pid}",method=RequestMethod.DELETE)
				  @ResponseBody
				  public Result deleteProduct(@PathVariable(value="pid") Long pid){ 
					      pService.deleteProduct(pid);
					  return new Result(ResultCode.SUCCESS);
				  
				  }
				  */
		  @Permission(name = "product:delete")
		  @RequestMapping(value="/product/{pid}",method=RequestMethod.DELETE)
		  @ResponseBody
		  public Result deleteProduct(@PathVariable(value="pid") Long pid){ 
			  
			  Long[] pids =	qService.getPidsByQuote();
			  if (Arrays.binarySearch(pids, pid) >=0) {
				  return new Result(ResultCode.NODEL);
			  }
			      pService.deleteProduct(pid);
			  return new Result(ResultCode.SUCCESS);
		  
		  }
		  
		  //??????????????????
		  @RequestMapping(value="/product-del",method=RequestMethod.POST)		  
		  @ResponseBody 
		  public Result deleteProducts(@RequestBody Long[] pids){ 
			  
			  Long[] pidsOfQuote =	qService.getPidsByQuote();
			  for(Long pid:pids) {				 
			  	  if (Arrays.binarySearch(pidsOfQuote, pid) >=0) {
				  return new Result(ResultCode.NODEL);
			  }
			} 
			  		
				  pService.deleteProducts(pids);
				  
			  
			  return new Result(ResultCode.SUCCESS);
		  
		  }	

		  //??????????????????
		  @Permission(name = "product:add")
		  @RequestMapping(value="/product",method=RequestMethod.POST)
		  @ResponseBody
		  public Result addProduct(@RequestBody Product product){ 

			  	pService.addProduct(product);
			
				return new Result(ResultCode.SUCCESS);						  
		  
		  }		  


/**
 * author:?????????
 * ????????????
 * @param request
 * @param response
 * @throws IOException 
 */          
		    @RequestMapping(value="/product-export",method = RequestMethod.POST)
		    public void ProductExport(@RequestBody Long[] pids, HttpServletRequest request, HttpServletResponse response) {
		    	String[] arrays= {"????????????","????????????","??????????????????","??????????????????","??????","??????","??????????????????","????????????","??????","?????????","????????????","?????????","????????????"};
		 
				 response.setContentType("application/vnd.ms-excel"); 
				response.setHeader("Content-disposition", "attachment;filename=Product-"+System.currentTimeMillis()+".xlsx");
				List<ProductExport> proList =	pService.getByPids(pids);
		        System.out.println(proList);
				ExcelWriter<ProductExport> ew = new ExcelWriter<>();
				XSSFWorkbook workbook = ew.getWorkbook(proList, "????????????", ProductExport.class,arrays);
				ServletOutputStream outputStream = null;
				try {
					outputStream=response.getOutputStream();
					workbook.write(outputStream);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						workbook.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		    }
		    
		    
//		    @RequestMapping(value="/product-export",method = RequestMethod.POST)
//		    public void ProductExport(@RequestBody Long[] pids, HttpServletRequest request, HttpServletResponse response) throws IOException {
//	    	 response.setContentType("application/octet-stream"); 
//					response.setHeader("Content-disposition", "attachment;filename=Product-"+System.currentTimeMillis()+".xlsx");
//					List<ProductExport> proList =	pService.getByPids(pids);
//					ProductExcelExporter exporter = new ProductExcelExporter(proList);
//					exporter.export(response);
//		    }
		    

		    @RequestMapping(value = "/products/template", method = RequestMethod.GET)
		    public void download(HttpServletResponse response) throws Exception {
		  
		        //??????Excel
		        //???????????????
		    	XSSFWorkbook wb = new XSSFWorkbook();
		        //??????sheet
		        Sheet sheet = wb.createSheet();
		        
		
		        String [] templates = "????????????,????????????,??????????????????,??????????????????,??????,??????,??????????????????,????????????,??????,?????????,????????????,?????????,????????????".split(",");
		        //???????????????
		    	CellStyle style = wb.createCellStyle();
		    	XSSFFont font = wb.createFont();
				font.setBold(false);
				font.setFontHeight(11);
				style.setFont(font);
				style.setAlignment(HorizontalAlignment.CENTER);
		        Row row0 = sheet.createRow(0);
		
		        int templateIndex=0;
		        
		        for (int j = 0; j < templates.length; j++) {

		        	  Cell cell = row0.createCell(templateIndex++);
			          cell.setCellValue(templates[j]);

					sheet.autoSizeColumn(j);
					int currentColumnWidth = sheet.getColumnWidth(j);
					sheet.setColumnWidth(j, (currentColumnWidth + 500));
					cell.setCellStyle(style);
				}
//		        for (String template : templates) {
//		            Cell cell = row1.createCell(templateIndex++);
//		            cell.setCellValue(template);
//		        }
		        
		        
		        CellStyle Headstyle = wb.createCellStyle();
		        XSSFFont Headfont = wb.createFont();
				Headfont.setBold(true);
				Headfont.setFontHeight(11);
				Headfont.setFontName("Microsoft Yahei");
				Headstyle.setFont(Headfont);
				Headstyle.setAlignment(HorizontalAlignment.CENTER);
		        //??????
		        String [] titles = "????????????,????????????,??????????????????,??????????????????,??????,??????,??????????????????,????????????,??????,?????????,????????????,?????????,????????????".split(",");
		        //????????????
		        //?????????
		        Row row1 = sheet.createRow(1);
		
		        int titleIndex=0;
		        for (int i = 0; i < titles.length; i++) {
		        	Cell cell = row1.createCell(titleIndex++);
		            cell.setCellValue(i);
					sheet.autoSizeColumn(i);
					int currentColumnWidth = sheet.getColumnWidth(i);
					sheet.setColumnWidth(i, (currentColumnWidth + 500));
					cell.setCellStyle(Headstyle);
				}
//		        for (String title : titles) {
//		            
//		        }
	
		        
		        //3.????????????
		        ByteArrayOutputStream os = new ByteArrayOutputStream();
		        wb.write(os);
		        new DownloadUtils().download(os,response,"?????????.xlsx");
		    }
		    
		    
		    /**
		     * ??????Excel???????????????
		     *  ????????????
		     */
		    @RequestMapping(value="/products",method = RequestMethod.POST)
		    @ResponseBody
		    public Result importProducts(@RequestParam(name="file") MultipartFile file) throws Exception {
//		        //1.??????Excel
//		        //1.1.??????Excel?????????????????????
//		        Workbook wb = new XSSFWorkbook(file.getInputStream());
//		        //1.2.??????Sheet
//		        Sheet sheet = wb.getSheetAt(0);//???????????????
//		        //1.3.??????Sheet???????????????????????????????????????
//		        //2.????????????????????????
//		        List<ProductReport> list = new ArrayList<>();
//		        System.out.println(sheet.getLastRowNum());
//		        for (int rowNum =2; rowNum<= sheet.getLastRowNum() ;rowNum ++) {
//		            Row row = sheet.getRow(rowNum);//??????????????????????????????
//		            Object [] values = new Object[row.getLastCellNum()];
//		            for(int cellNum=0;cellNum< row.getLastCellNum(); cellNum ++) {
//		                Cell cell = row.getCell(cellNum);
//		                Object value = getCellValue(cell);
//		                values[cellNum] = value;
//		            }
//		            ProductReport pro2 = new ProductReport(values);
//		            list.add(pro2);
//		  
//		        }
//		        pService.saves(list);
//				return new Result(ResultCode.SUCCESS);

		        List<ProductReport> list = new ExcelImportUtil(ProductReport.class).readExcel(file.getInputStream(), 2, 0);
		        //3.??????????????????
		        pService.saves(list);
		        return new Result(ResultCode.SUCCESS);
		    }

		    public static Object getCellValue(Cell cell) {
		        //1.?????????????????????????????????
		        CellType cellType = cell.getCellType();
		        //2.???????????????????????????????????????
		        Object value = null;
		        switch (cellType) {
		            case STRING:
		                value = cell.getStringCellValue();
		                break;
		            case BOOLEAN:
		                value = cell.getBooleanCellValue();
		                break;
		            case NUMERIC:
		                if(DateUtil.isCellDateFormatted(cell)) {
		                    //????????????
		                    value = cell.getDateCellValue();
		                }else{
		                    //??????
		                    value = cell.getNumericCellValue();
		                }
		                break;
		            case FORMULA: //??????
		                value = cell.getCellFormula();
		                break;
		            default:
		                break;
		        }
		        return value;
		    }


}
		    

