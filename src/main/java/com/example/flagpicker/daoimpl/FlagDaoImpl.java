/**
 * 
 */
package com.example.flagpicker.daoimpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.example.flagpicker.beans.Continents;
import com.example.flagpicker.beans.Countries;
import com.example.flagpicker.dao.FlagDao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SRINIVASARAON
 *
 */
@Repository
public class FlagDaoImpl implements FlagDao {

	private static final Logger logger = Logger.getLogger(FlagDaoImpl.class);

	@Override
	public Countries[] byContinent(String continent) {
		logger.info("In byContinent method of FlagDaoImpl class");

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Continents>> typeReference = new TypeReference<List<Continents>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/continents.json");
		Countries[] countries = null;

		try {
			List<Continents> continents = mapper.readValue(inputStream, typeReference);
			/*
			 * for(Continents c : continents) { if((c.getContinent()).equals(continent))
			 * countries = c.getCountries(); }
			 */
			continents = continents.stream().filter(b -> (b.getContinent()).equals(continent))
					.collect(Collectors.toList());
			countries = continents.get(0).getCountries();

		} catch (IOException e) {
			System.out.println("Unable to retrieve list of countries: " + e.getMessage());
		}

		return countries;

	}

	@Override
	public String byCountry(String country) {
		logger.info("In byCountry method of FlagDaoImpl class");

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Continents>> typeReference = new TypeReference<List<Continents>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/continents.json");

		Countries[] countries = null;
		List<Countries> list = null;
		String result = null;
		try {
			List<Continents> continents = mapper.readValue(inputStream, typeReference);
			/*for (Continents c : continents) {
				countries = c.getCountries();

				for (Countries cc : countries) {
					if (cc.getName().equals(country)) {
						result = cc.getFlag();
					}

				}
			}*/
			for (Continents c : continents) {
				countries = c.getCountries();
				
				Stream<Countries> stream = Stream.of(countries);
				list = stream.filter(b->(b.getName()).equals(country)).collect(Collectors.toList());
				if(!list.isEmpty())
				result = list.get(0).getFlag();
			}
		} catch (Exception e) {
			System.out.println("Unable to retrieve flag: " + e.getMessage());
		}
		return result;
	}

}
