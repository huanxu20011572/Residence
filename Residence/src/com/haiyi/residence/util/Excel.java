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
 * �� Excel ����ز���
 * @author JoebinWuu
 */
@SuppressWarnings("deprecation")
public class Excel<T> {
	/**
	 * ���� Excel ���
	 * @param ops �����
	 * @param fileName �����ļ����ļ���
	 * @param title ��������
	 * @param headers �������ı�ͷ��������
	 * @param dataList Ҫ���������ݶ����б�
	 * @param dateFormat ���ڸ�ʽ
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked" })
	public boolean exportExcel (OutputStream ops, String title, String[] headers, 
			List<T> dataList, String dateFormat,String fileurl) throws IOException {
		//���ؽ��
		boolean result = true;
		//��ʼ
		System.out.println(">> EXCEL EXPORTING...");
		//���ɹ�����
		HSSFWorkbook workbook = new HSSFWorkbook();
		//���ɹ�����
		HSSFSheet sheet = workbook.createSheet(title);
		//���ñ��Ĭ���п��Ϊ20���ֽ�
		sheet.setDefaultColumnWidth(20);
		//����һ����ʽ
		HSSFCellStyle style = workbook.createCellStyle();
		//���õ�Ԫ�������ʽ
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//���õ�Ԫ������ǰ����ɫ
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		//���ñ߿���ʽ
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		//���ñ߿���ɫ
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		//���õ�Ԫ����뷽ʽ
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//����һ������
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		//������Ӧ�õ���ǰ����ʽ
		style.setFont(font);
//		//���ɲ�������һ����ʽ
		HSSFCellStyle style2 = workbook.createCellStyle();
		//���õ�Ԫ�������ʽ
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//���õ�Ԫ������ǰ����ɫ
		style2.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		//���ñ߿���ʽ
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		//���ñ߿���ɫ
		style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
		//���õ�Ԫ����뷽ʽ
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//����һ������
		HSSFFont font2 = workbook.createFont();
		font2.setColor(HSSFColor.BLACK.index);
		font2.setFontHeightInPoints((short) 12);
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		//������Ӧ�õ���ǰ����ʽ
		style2.setFont(font2);
		//����һ����ͼ�Ķ���������
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
//		//����ע�͵Ĵ�С��λ��,����ĵ�
//		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short)4, 2, (short)6, 5));
//		//����ע������
//		comment.setString(new HSSFRichTextString("������POI�����ע�ͣ�"));
//		//����ע�����ߣ�������ƶ�����Ԫ�����ǿ�����״̬���п���������.
//		comment.setAuthor("JoebinWuu");
		//������������
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			row.setHeightInPoints(30);
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style2);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		//�����������ݣ�����������
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
					//�ж�ֵ�����ͺ����ǿ������ת��
					String textValue = null;
					if (value != null && value instanceof List) {
						List<byte[]> list = (List<byte[]>)value;
						int count = j;
						for (int k = 0; k < list.size(); k++) {
							if (list.get(k) != null) {
								byte[] bsValue = (byte[]) list.get(k);
								//��ͼƬʱ�������и�Ϊ100px;
								row.setHeightInPoints(100);
								//����ͼƬ�����п��Ϊ80px,ע�����ﵥλ��һ������
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
							//�������ö�ͼƬ�ϵı�ͷ
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
							//��ͼƬʱ�������и�Ϊ100px;
							row.setHeightInPoints(100);
							//����ͼƬ�����п��Ϊ80px,ע�����ﵥλ��һ������
							sheet.setColumnWidth(j, (short) (35.7 * 90));
							//sheet.autoSizeColumn(i);
							byte[] bsValue = (byte[]) value;
							HSSFClientAnchor anchor = new HSSFClientAnchor(30, 5, 1000, 251, (short) j, i+1, (short) j, i+1);
							anchor.setAnchorType(2);
							patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
						} else{
							//�����������Ͷ������ַ����򵥴���
							textValue = value.toString();
						}
						//�������ͼƬ���ݣ�������������ʽ�ж�textValue�Ƿ�ȫ�����������
						if(textValue!=null){
							Pattern p = Pattern.compile("^//d+(//.//d+)?$");
							Matcher matcher = p.matcher(textValue);
							if(matcher.matches()){
								//�����ֵ���double����
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
