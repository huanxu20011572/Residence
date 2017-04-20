package com.common;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.io.UnsupportedEncodingException;  
import java.io.Writer;  
import java.util.Map;  
  
import freemarker.template.Configuration;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;  
  
public class DocumentHandler {  
  
    private Configuration configuration = null;  
  
    public DocumentHandler() {  
        configuration = new Configuration();  
        configuration.setDefaultEncoding("utf-8");  
    }  
  
    public boolean createDoc(Map<String,Object> dataMap,String fileName,int flag) throws UnsupportedEncodingException {  
    	boolean result = true;
    	//dataMap Ҫ����ģ���������ļ�  
        //����ģ��װ�÷�����·��,FreeMarker֧�ֶ���ģ��װ�ط�����������servlet��classpath�����ݿ�װ�أ�  
        //�������ǵ�ģ���Ƿ���template������  
        configuration.setClassForTemplateLoading(this.getClass(), "/com/common/template");  
        Template t=null;  
        try {  
            //test.ftlΪҪװ�ص�ģ��  
        	if(flag == 1){
        		t = configuration.getTemplate("faren.ftl");  
        	}else if(flag == 2){
        		t = configuration.getTemplate("yuangong2.ftl"); 
        	}else if(flag == 3){
        		t = configuration.getTemplate("baoan.ftl"); 
        	}
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        //����ĵ�·��������  
        File outFile = new File(fileName); 
		File parent = outFile.getParentFile(); 
		if(parent!=null&&!parent.exists()){ 
			parent.mkdirs(); 
		} 
        Writer out = null;  
        FileOutputStream fos=null;  
        try {  
            fos = new FileOutputStream(outFile);  
            OutputStreamWriter oWriter = new OutputStreamWriter(fos,"UTF-8");  
            //����ط������ı��벻�ɻ�ȱ��ʹ��main������������ʱ��Ӧ�ÿ��ԣ����������web���󵼳�ʱ������word�ĵ��ͻ�򲻿������Ұ�XML�ļ�������Ҫ�Ǳ����ʽ����ȷ���޷�������  
            //out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));  
             out = new BufferedWriter(oWriter);   
        } catch (FileNotFoundException e1) {  
        	result = false;
            e1.printStackTrace();  
        }  
           
        try { 
            t.process(dataMap, out);  
            out.close();  
            fos.close();  
        } catch (TemplateException e) { 
        	result = false;
            e.printStackTrace();  
        } catch (IOException e) { 
        	result = false;
            e.printStackTrace();  
        }  
        return result ;
        //System.out.println("---------------------------");  
    }  
}  
