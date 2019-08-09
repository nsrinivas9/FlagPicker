/**
 * 
 */
package com.example.flagpicker.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flagpicker.beans.Countries;
import com.example.flagpicker.dao.FlagDao;
import com.example.flagpicker.service.FlagService;

/**
 * @author SRINIVASARAON
 *
 */

@Service
public class FlagServiceImpl implements FlagService {

	@Autowired
	FlagDao flagDao;

	@Override
	public Countries[] byContinent(String continent) {

		return flagDao.byContinent(continent);
	}
	
	
	
	@Override
	public String byCountry(String country) {

		return flagDao.byCountry(country);
	}
}
