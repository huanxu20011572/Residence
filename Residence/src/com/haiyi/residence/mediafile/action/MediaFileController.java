/**    
* @Title: MediaFileController.java  
* @Package com.haiyi.residence.mediafile.action  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-12-7 ����10:46:26  
* @version V1.0    
*/ 
package com.haiyi.residence.mediafile.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.haiyi.residence.mediafile.service.MediaFileService;
import com.haiyi.residence.model.MediaFile;

  
/**     
 * ��Ȩ���У�2015-yanwenyan 
 * ��Ŀ���ƣ�Residence     
 *  
 * ��������  
 * �����ƣ�com.haiyi.residence.mediafile.action.MediaFileController       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-12-7 ����10:46:26     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-12-7 ����10:46:26     
 * �޸ı�ע��     
 * @version   V1.0      
 */
@Controller
@RequestMapping("/mediaFileController")
public class MediaFileController {

	@Resource(name="mediaFileService")
	private MediaFileService mediaFileService;
	@RequestMapping("/selectMediaFiles")
	public void selectMediaFiles(HttpServletRequest request,HttpServletResponse response,String modeId,String source){
		MediaFile m=new MediaFile();
		if(source.equals("''")){
			source="";
		}
		m.setSource(source);
		m.setModeId(modeId);
		List<MediaFile> list=mediaFileService.selectMediaFiles(m);
		this.printTOClient(response, list);
	}
	public void printTOClient(HttpServletResponse response,List<?>list) {
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().println(new Gson().toJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
