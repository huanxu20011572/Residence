package com.common;

public class User  {

	private int id;
	private String name;
	private String info;
	/**  
	 * @return the info  
	 */
	public String getInfo() {
		return info;
	}
	/**  
	 * @param info the info to set  
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	private Super superInfo;
	/**  
	 * @return the superInfo  
	 */
	public Super getSuperInfo() {
		return superInfo;
	}
	/**  
	 * @param superInfo the superInfo to set  
	 */
	public void setSuperInfo(Super superInfo) {
		this.superInfo = superInfo;
	}
	/**  
	 * @return the id  
	 */
	public int getId() {
		return id;
	}
	/**  
	 * @param id the id to set  
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**  
	 * @return the name  
	 */
	public String getName() {
		return name;
	}
	/**  
	 * @param name the name to set  
	 */
	public void setName(String name) {
		this.name = name;
	}
}
