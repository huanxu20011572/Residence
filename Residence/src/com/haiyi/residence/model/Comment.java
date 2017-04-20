package com.haiyi.residence.model;

import java.util.Date;

public class Comment {

	private Integer id;
	private String content;
	private Date contentD;
	private Integer bid;
	
	/**  
	 * @return the id  
	 */
	public Integer getId() {
		return id;
	}
	/**  
	 * @param id the id to set  
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**  
	 * @return the content  
	 */
	public String getContent() {
		return content;
	}
	/**  
	 * @param content the content to set  
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**  
	 * @return the contentD  
	 */
	public Date getContentD() {
		return contentD;
	}
	/**  
	 * @param contentD the contentD to set  
	 */
	public void setContentD(Date contentD) {
		this.contentD = contentD;
	}
	/**  
	 * @return the bid  
	 */
	public Integer getBid() {
		return bid;
	}
	/**  
	 * @param bid the bid to set  
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
}
