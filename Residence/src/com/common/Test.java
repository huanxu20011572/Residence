package com.common;



import java.net.UnknownHostException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	/**
	 * @Description: TODO
	 * @param @param args   
	 * @return void  
	 * @throws
	 * @author luofeng
	 * @date 2015-10-28
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String uuid=UUID.randomUUID().toString();
		System.out.println(uuid);
		String[]stb=uuid.split("-");
		String newStr=stb[0]+stb[1]+stb[2]+stb[3]+stb[4];
		System.out.println(newStr);
//		Test t=new Test();
//		boolean a=t.isNumeric("2.2");
//		System.out.println(a);
		//System.out.println(u.getId()+"\t"+u.getSuperInfo().getAge());
		//String unit="{"bussinessNum":"155","closeTime":"2015-11-27","imageUrls":"e7d1bcb6b5a94df1875dd8ff4eb478a1;c2294845fd064e5ca975e39c7596cf2e;null","landlordId":"","layoutDiagramUrl":"a303a5c183854b408caccb006e37cec4","legalRepresentId":"","linkNumber":"","openningTime":"2015-11-27","orgNum":"155","regesistMoney":"155","regesistTime":"2015-11-27","rent":"55","securityPersonId":"Dh","uAddr":"666","uCategory":"Dhh","uName":"Bhb","uOperateRange":"G","uPersonNum":"5","uProperty":"","validTime":"2015-12-27","extraField1":"","extraField2":"","extraField3":"","extraField4":"","extraField5":"","isRefresh":false,"id":"a738f83eb18c48deb9b7a0dd02805d2a","valid":true,"version":3}";
	}
	public boolean isNumeric(String str){ 
	   Pattern pattern = Pattern.compile("[0-9.]*"); 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   } 
	   return true; 
	}


}
