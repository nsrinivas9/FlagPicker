/**
 * 
 */
package com.example.flagpicker.dao;

import com.example.flagpicker.beans.Countries;

/**
 * @author SRINIVASARAON
 *
 */
public interface FlagDao {

	Countries[] byContinent(String continent);
	String byCountry(String country);
}
