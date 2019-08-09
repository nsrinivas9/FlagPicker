/**
 * 
 */
package com.example.flagpicker.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flagpicker.beans.Countries;
import com.example.flagpicker.service.FlagService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author SRINIVASARAON
 *
 */

@RestController
@RequestMapping(path = "/flags")
@Api(value="flags", description="Flags of Countries by Continents")
public class FlagController {

	private static final Logger logger = Logger.getLogger(FlagController.class);

	@Autowired
	FlagService flagService;

	@ApiOperation(value = "View a list of available countries of a continent", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list of countries"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	
	@GetMapping(path = "/bycontinent/{continent}", produces = "application/json")
	public Object byContinent(@PathVariable("continent") String continent) {

		logger.info("In byContinent method of FlagController");

		Countries[] countries = flagService.byContinent(continent);
		return countries;
	}

	@ApiOperation(value = "View the flag of a country", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved the flag"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path = "/bycountry/{country}", produces = "application/json")
	public Object byCountry(@PathVariable("country") String country) {

		logger.info("In byCountry method of FlagController");

		String flag = flagService.byCountry(country);
		return "Flag of "+country+" is "+ flag;
	}

}
