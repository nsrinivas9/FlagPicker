/**
 * 
 */
package com.example.flagpicker.service;

import com.example.flagpicker.beans.Countries;

/**
 * @author SRINIVASARAON
 *
 */
public interface FlagService {

	Countries[] byContinent(String continent);
	String byCountry(String country);
}
