/**    
* @Title: MediaFileController.java  
* @Package com.haiyi.residence.mediafile.action  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-12-7 上午10:46:26  
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
 * 版权所有：2015-yanwenyan 
 * 项目名称：Residence     
 *  
 * 类描述：  
 * 类名称：com.haiyi.residence.mediafile.action.MediaFileController       
 * 创建人：yanwenyan  
 * 创建时间：2015-12-7 上午10:46:26     
 * 修改人：  
 * 修改时间：2015-12-7 上午10:46:26     
 * 修改备注：     
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
