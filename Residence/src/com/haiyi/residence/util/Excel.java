package com.haiyi.residence.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.Region;
/**
 * 对 Excel 的相关操作
 * @author JoebinWuu
 */
@SuppressWarnings("deprecation")
public class Excel<T> {
	/**
	 * 导出 Excel 表格
	 * @param ops 输出流
	 * @param fileName 导出文件的文件名
	 * @param title 标题名称
	 * @param headers 导出表格的表头列名数组
	 * @param dataList 要到处的数据对象列表
	 * @param dateFormat 日期格式
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked" })
	public boolean exportExcel (OutputStream ops, String title, String[] headers, 
			List<T> dataList, String dateFormat,String fileurl) throws IOException {
		//返回结果
		boolean result = true;
		//开始
		System.out.println(">> EXCEL EXPORTING...");
		//生成工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//生成工作表
		HSSFSheet sheet = workbook.createSheet(title);
		//设置表格默认列宽度为20个字节
		sheet.setDefaultColumnWidth(20);
		//生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		//设置单元格填充样式
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//设置单元格设置前景颜色
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		//设置边框样式
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		//设置边框颜色
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		//设置单元格对齐方式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		//把字体应用到当前的样式
		style.setFont(font);
//		//生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		//设置单元格填充样式
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//设置单元格设置前景颜色
		style2.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		//设置边框样式
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		//设置边框颜色
		style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
		//设置单元格对齐方式
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//生成一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setColor(HSSFColor.BLACK.index);
		font2.setFontHeightInPoints((short) 12);
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		//把字体应用到当前的样式
		style2.setFont(font2);
		//声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
//		//定义注释的大小和位置,详见文档
//		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short)4, 2, (short)6, 5));
//		//设置注释内容
//		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
//		//设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
//		comment.setAuthor("JoebinWuu");
		//产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			row.setHeightInPoints(30);
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style2);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		//遍历集合数据，产生数据行
		for (int i = 0; i < dataList.size(); i++) {
			T t = dataList.get(i);
			row = sheet.createRow(i+1);
			Field[] fields = t.getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				HSSFCell cell = row.createCell(j);
				cell.setCellStyle(style);
				Field field = fields[j];
				String fieldName = field.getName();
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					Class tClass = t.getClass();
					Method getMethod = tClass.getMethod(getMethodName,new Class[]{});
					Object value = getMethod.invoke(t, new Object[]{});
					value = (value == null) ? "" : value;
					//判断值的类型后进行强制类型转换
					String textValue = null;
					if (value != null && value instanceof List) {
						List<byte[]> list = (List<byte[]>)value;
						int count = j;
						for (int k = 0; k < list.size(); k++) {
							if (list.get(k) != null) {
								byte[] bsValue = (byte[]) list.get(k);
								//有图片时，设置行高为100px;
								row.setHeightInPoints(100);
								//设置图片所在列宽度为80px,注意这里单位的一个换算
								sheet.setColumnWidth(j, (short) (35.7 * 90));
								//sheet.autoSizeColumn(i);
								HSSFClientAnchor anchor = new HSSFClientAnchor(30, 5, 1000, 251, (short) (j+k), i+1, (short) (j+k), i+1);
								anchor.setAnchorType(2);
								patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
								if (k > 0) {
									count++;
								}
							}
						}
						if (list.size() > 1) {
							//重新设置多图片上的表头
							sheet.addMergedRegion(new Region(0, (short) (j), 0,(short) (count)));
							HSSFRow r = sheet.getRow(0);
							r.removeCell(r.getCell(j));
							r.setHeightInPoints(30);
							HSSFCell c = r.createCell(j);
							c.setCellStyle(style2);
							HSSFRichTextString text = new HSSFRichTextString(headers[j]);
							c.setCellValue(text);
						}
					} else {
						if (value instanceof Boolean) {
							boolean bValue = (Boolean) value;
							textValue = "false";
							if (bValue) {
								textValue = "true";
							}
						} else if (value instanceof Date) {
							Date date = (Date) value;
							SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
							textValue = sdf.format(date);
						}  else if (value instanceof byte[]) {
							//有图片时，设置行高为100px;
							row.setHeightInPoints(100);
							//设置图片所在列宽度为80px,注意这里单位的一个换算
							sheet.setColumnWidth(j, (short) (35.7 * 90));
							//sheet.autoSizeColumn(i);
							byte[] bsValue = (byte[]) value;
							HSSFClientAnchor anchor = new HSSFClientAnchor(30, 5, 1000, 251, (short) j, i+1, (short) j, i+1);
							anchor.setAnchorType(2);
							patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
						} else{
							//其它数据类型都当作字符串简单处理
							textValue = value.toString();
						}
						//如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
						if(textValue!=null){
							Pattern p = Pattern.compile("^//d+(//.//d+)?$");
							Matcher matcher = p.matcher(textValue);
							if(matcher.matches()){
								//是数字当作double处理
								cell.setCellValue(Double.parseDouble(textValue));
							}else{
								HSSFRichTextString richString = new HSSFRichTextString(textValue);
								HSSFFont font3 = workbook.createFont();
								font3.setColor(HSSFColor.BLACK.index);
								richString.applyFont(font3);
								cell.setCellValue(richString);
							}
						}
					}
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		//OutputStream os=new FileOutputStream(new File(""));
//		OutputStream os=new FileOutputStream(file);
		workbook.write(ops);
		
		if (result) {
			System.out.println(">> EXCEL EXPORT SUCCEED!");
		} else {
			System.out.println(">> EXCEL EXPORT FAILED!");
		}
		return result;
	}
	
}
