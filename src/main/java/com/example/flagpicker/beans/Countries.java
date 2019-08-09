/**
 * 
 */
package com.example.flagpicker.beans;

import javax.persistence.Id;

/**
 * @author SRINIVASARAON
 *
 */
public class Countries {

	private String flag;
	@Id
	private String name;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassPojo [flag = " + flag + ", name = " + name + "]";
	}
}
