package com.common;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;

@SuppressWarnings({"unused","unchecked"})
public class GenericsUtils {
	/**
	 * 
	 * @param object
	 * @return JSON format string
	 */
	public static String toJson(Object object) {
		return new Gson().toJson(object);
	}

	/**
	 * 
	 * @param json
	 *            JSON format string
	 * @param typeOfT
	 *            result object type
	 * @return result object of given type
	 */
	public static Type fromJson(String json, Type typeOfT) {
		return new Gson().fromJson(json, typeOfT);
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return new Gson().fromJson(json, classOfT);
	}

	public static Class getGenericSuperclassType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	/**
	 * ��һ��List�е�obj���䵽һ��List��HashMap��
	 * 
	 * @param obj
	 * @return
	 */
	public static List mappingObjectToForm(List list) {
		try {
			if (list != null && list.size() > 0) {
				List resultList = new ArrayList();
				Class c = list.get(0).getClass();
				Method m[] = c.getDeclaredMethods();

				for (int listSize = 0; listSize < list.size(); listSize++) {
					Map<String, String> hashMap = null;
					hashMap = getFieldVlaue(list.get(listSize));
					// for (int i = 0; i < m.length; i++) {
					// if (m[i].getName().indexOf("get") == 0) {
					// Object val= m[i].invoke(list.get(listSize), new
					// Object[0]);
					// hashMap.put(m[i].getName().toString(),val==null?"":val.toString());
					// }
					// }
					resultList.add(hashMap);
				}
				return resultList;
			} else {
				return new ArrayList(0);
			}
		} catch (Throwable e) {
					}
		return null;
	}

	public static Map<String, String> getFieldVlaue(Object obj)
			throws Exception {
		Map<String, String> mapValue = new HashMap<String, String>();
		Class<?> cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();

		for (Field field : fields) {
			String name = field.getName();

			String strGet = "get" + name.substring(0, 1).toUpperCase()
					+ name.substring(1, name.length());
			Method methodGet = cls.getDeclaredMethod(strGet);
			Object object = methodGet.invoke(obj);

			if (field.getType().getClassLoader() != null) {
				// �Լ��������
				if (object != null) {
					// ���������ֵ
					getFieldValueSubClass(mapValue, name, object);
				}
			} else {

				String value = object != null ? object.toString() : "";
				mapValue.put(name, value);
			}
		}
		return mapValue;
	}

	/**
	 * ��ʱֻ֧��2��
	 */
	private static void getFieldValueSubClass(Map<String, String> mapValue,
			String paramentName, Object object) throws Exception {
		Class<?> cls = object.getClass();
		Field[] fields = cls.getDeclaredFields();

		for (Field field : fields) {
			if (field.getType().getClassLoader() == null) {// ֻ����ڶ��������Զ���������
				String name = field.getName();
				String strGet = "get" + name.substring(0, 1).toUpperCase()
						+ name.substring(1, name.length());
				Method methodGet = cls.getDeclaredMethod(strGet);
				Object o = methodGet.invoke(object);
				String value = o != null ? o.toString() : "";
				mapValue.put(paramentName + "." + name, value);
			}

		}
	}

	/**
	 * ��ȡ��ǰϵͳʱ��,��ʽ�Զ���
	 */
	public static Long getCurrentDate(String partten) {
		Long dateLong = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(partten);
		try {
			String dateStr = sdf.format(date);
			dateLong = new Long(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateLong;
	}

	/**
	 * ��ȡ��ǰϵͳʱ��,��ʽΪ��yyyyMMdd��
	 */
	public static Long getCurrentDate() {
		Long dateLong = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			String dateStr = sdf.format(date);
			dateLong = new Long(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateLong;
	}

	/**
	 * ����ʱ�䣬����unixʱ��� ����ʱ���ʱ���ʽ��:yyyy-MM-dd HH:mm:ss ����
	 * 
	 * @return
	 */
	public static Long getUnixTimes(String datetime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(datetime);
			return date.getTime() / 1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����ʱ�䣬����unixʱ��� ����ʱ���ʱ���ʽ��:�Զ��塾yyyyMMdd�������� ����
	 * 
	 * @return
	 */
	public static Long getUnixTimes(String datetime, String parseStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(parseStr);
		try {
			Date date = sdf.parse(datetime);
			return date.getTime() / 1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����ʱ���������ʱ��,���ظ�ʽyyyy-mm-dd HH:mm:ss
	 * 
	 * @param second
	 *            ��λ��
	 * @return
	 */
	public static String getTimesFromUnix(Long second) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(second * 1000L);
		return date;
	}
	/**
	 * ����ʱ���������ʱ��,���ظ�ʽ
	 * 
	 * @param second
	 *            ��λ��
	 * @return
	 */
	public static String getTimesFromUnix(Long second,String patten) {
		if(StringUtils.isEmpty(patten)){
			patten = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(patten);
		String date = sdf.format(second * 1000L);
		return date;
	}
	/**
	 * ���ַ���ת��int,���ַ������ڲ���ת�����ַ�,����׳�NumberFormatException. ���ַ���Ϊnull,""," ",�򷵻�0
	 * 
	 * @param param
	 *            ��ת��int���ַ���
	 * @return int
	 */
	public static int StringToInt(String param) {
		int result = 0;

		if (StringUtils.isNotBlank(param)) {
			result = Integer.parseInt(param);
		}

		return result;
	}

	/**
	 * ���ַ���ת��int,���ַ������ڲ���ת�����ַ�,����׳�NumberFormatException.
	 * ���ַ���Ϊnull,""," ",�򷵻�defaultVal
	 * 
	 * @param param
	 *            ��ת��int���ַ���
	 * @param defaultVal
	 *            Ĭ��ֵ
	 * @return int
	 */
	public static int StringToInt(String param, int defaultVal) {
		int result = defaultVal;

		if (StringUtils.isNotBlank(param)) {
			result = Integer.parseInt(param);
		}

		return result;
	}

	/**
	 * ����ҳ��ѯ���������б�ת��JSONObject
	 * 
	 * @param total
	 * @param list
	 * @return
	 */
	public static Map<String, Object> orgJsonFromQueryResult(long total,
			List<?> list) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", list);
		return jsonMap;
	}

	/**
	 * ʹ��UTF-8��ָ���ַ�������
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decodeToUTF8(String param)
			throws UnsupportedEncodingException {
		if (param == null) {
			throw new NullPointerException("param is Null!");
		}

		return URLDecoder.decode(param, "UTF-8");
	}

	public static String ifValue(String srcStr, String checkVal,
			String replaceValue) {

		if (srcStr == checkVal || (srcStr != null && srcStr.equals(checkVal))
				|| (checkVal != null && checkVal.equals(srcStr))) {
			return replaceValue;
		}
		return srcStr;
	}

	public static String emptyIfNull(String srcStr) {

		return ifValue(srcStr, null, "");
	}

	/**
	 * ����URL����URL�Ĳ���������map��
	 * 
	 * @param confInfo
	 * @return
	 */
	public static HashMap getConfigReslv(String confInfo) {
		HashMap map = new HashMap();
		String info[] = confInfo.split("&");

		for (int i = 0; i < info.length; i++) {
			String tem[] = info[i].split("=");
			map.put(tem[0], tem[1]);
		}

		return map;
	}

	/**
	 * ���Ϊ���򷵻�Ĭ��ֵ
	 * 
	 * @param str
	 * @param defaultStr
	 * @return
	 */
	public static String defaultIfBlank(String str, String defaultStr) {
		return StringUtils.isBlank(str) ? defaultStr : str;
	}

	/**
	 * ���Ϊ�շ���Ĭ��ֵ.
	 * 
	 * @author gezq
	 */
	public static int defaultIfBlank(String str, int defaultInt) {
		return StringUtils.isBlank(str) ? defaultInt : Integer.parseInt(str);
	}

	/**
	 * ���Ϊ�շ���Ĭ��ֵ.
	 * 
	 * @author gezq
	 */
	public static double defaultIfBlank(String str, double defaultDouble) {
		return StringUtils.isBlank(str) ? defaultDouble : Double.parseDouble(str);
	}
	
	/**
	 * ���Ϊ�շ���Ĭ��ֵ.
	 * 
	 * @author gezq
	 */
	public static long defaultIfBlank(String str, long defaultDouble) {
		return StringUtils.isBlank(str) ? defaultDouble : Long.parseLong(str);
	}
	
	 public static String ListToString(List<?> list) {  
		 	String SEP1=",";
	        StringBuffer sb = new StringBuffer();  
	        if (list != null && list.size() > 0) {  
	            for (int i = 0; i < list.size(); i++) {  
	                if (list.get(i) == null || list.get(i) == "") {  
	                    continue;  
	                }  
	                // ���ֵ��list����������Լ�  
	                if (list.get(i) instanceof List) {  
	                    sb.append(ListToString((List<?>) list.get(i)));  
	                    sb.append(SEP1);  
	                } 
	                else {  
	                    sb.append(list.get(i));  
	                    sb.append(SEP1);  
	                }  
	            }  
	        }  
	        return sb.toString();  
	    }  
	
	public static void main(String args[]) {
	}
}
