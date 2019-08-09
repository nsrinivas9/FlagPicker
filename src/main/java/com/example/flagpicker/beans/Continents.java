/**
 * 
 */
package com.example.flagpicker.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


/**
 * @author SRINIVASARAON
 *
 */
@Data
@Entity
public class Continents {

	
	@Id
	private String continent;
    private Countries[] countries;

    public String getContinent ()
    {
        return continent;
    }

    public void setContinent (String continent)
    {
        this.continent = continent;
    }

    public Countries[] getCountries ()
    {
        return countries;
    }

    public void setCountries (Countries[] countries)
    {
        this.countries = countries;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [continent = "+continent+", countries = "+countries+"]";
    }
}
