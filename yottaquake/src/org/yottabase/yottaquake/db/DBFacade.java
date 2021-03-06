package org.yottabase.yottaquake.db;

import java.util.Set;

import org.bson.Document;
import org.json.JSONObject;
import org.yottabase.yottaquake.core.BoundingBox;
import org.yottabase.yottaquake.core.CountryDetailLevel;
import org.yottabase.yottaquake.core.EventFilter;

import com.mongodb.client.MongoCollection;

public interface DBFacade {

	public void initializeEarthquakesCollection();

	public void initializeCountriesCollection();
	
	public void initializeContinentsCollection();
	
	public void initializeFlinnRegionsCollection();

	public void initializeTectonicPlatesCollection();
	
	public void initializeCoordinatesCollection();

	
	/**
	 * Chiude il database
	 */
	public void close();
	
	/**
	 * insert
	 */
	
	public void insertEvent(JSONObject event);
	
	public void insertCountry(JSONObject country, CountryDetailLevel level);
	
	public void insertContinent(JSONObject continent);
	
	public void insertTectonicPlate(JSONObject tectonicPlate);
	
	/**
	 * collections getters
	 */
	public MongoCollection<Document> getEarthquakesCollection();
	
	public MongoCollection<Document> getCountriesCollection(CountryDetailLevel level);
	
	public MongoCollection<Document> getFlinnRegionsCollection();
	
	public MongoCollection<Document> getContinentsCollection();
	
	public MongoCollection<Document> getTectonicPlatesCollection();
	
	/**
	 * raggruppa per anno e mese 
	 */
	public Iterable<Document> countByYearMonth();

	public Iterable<Document> countByYear();
	
	public Iterable<Document> countByMonth();
	
	public Iterable<Document> countByMonthInYear(int year);
	
	/*
	 * nome delle flynn region
	 */
	public Iterable<Document> distinctRegion();
		
	public Iterable<Document> getCountries(CountryDetailLevel level, BoundingBox box );
	
	public Iterable<Document> getEventsInPolygon(Document geometry);
	
	public void insertFlinnRegion(JSONObject flinnRegion);
	
	public boolean updateDocument(Document document, Document update);
	
	//API 
		
	public Iterable<Document> getEvents(BoundingBox box, EventFilter eventFilter);
	
	public Set<String> getDistinctMacroRegions(); 
	
	public Iterable<Document> getRegionsByMacroRegion(String macroRegions); 

	public Set<String> getDistinctRegionsAggregates();
	
	public Iterable<Document> getRegionsByAggregate(String aggregate);
	
	public Set<String> getDistinctContinents();
	
	public Iterable<Document> getCountriesByContinet(String continent, CountryDetailLevel level);

	public Iterable<Document> getMagnitudeTypes();
	
	public void getDepth();

	public Integer getCountryEventsCount(String name, EventFilter eventFilter);

	public Iterable<Document> getTectonicPlates(BoundingBox box);

	public Integer getTectonicPlatesEventsCount(String string, EventFilter eventFilter);

	public Iterable<Document> getContinents();

	public Iterable<Document> getFlinnRegions(BoundingBox box);

	public Integer getFlinnRegionEventsCount(String name, EventFilter eventFilter);

	public Integer geContinentEventsCount(String name, EventFilter eventFilter);

	public void insertPoint(Document point);
	
	public Iterable<Document> getPointsInPolygon(Document geometry);
	
	public boolean addSurface(MongoCollection<Document> collection, Object docId, int surface);

}
