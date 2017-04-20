package com.haiyi.residence.model;

import java.util.List;

public class Blog {

	private Integer id;
	private String title;
	private String content;
	private String owner;
	private List<Comment> comments;
	
	/**  
	 * @return the comments  
	 */
	public List<Comment> getComments() {
		return comments;
	}
	/**  
	 * @param comments the comments to set  
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
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
	 * @return the title  
	 */
	public String getTitle() {
		return title;
	}
	/**  
	 * @param title the title to set  
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the owner  
	 */
	public String getOwner() {
		return owner;
	}
	/**  
	 * @param owner the owner to set  
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
