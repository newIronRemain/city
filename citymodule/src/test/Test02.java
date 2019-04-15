package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pojo.City;
import com.service.ICityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Test02 {
	
	@Autowired
	private ICityService cityService;

	@Test
	public void parseXml() throws Exception {

		List<City> cityList = new ArrayList <City> ();
		for (Element countryRegion : countryRegionList) {
			String countryname = countryRegion.attributeValue("Name");
			String countrycode = countryRegion.attributeValue("Code");
			
			City country = new City();
			country.setName(countryname);
			country.setParentcode("0");
			country.setType("country");
			country.setCode(countrycode);
			country.setParenttype("root");
			cityList.add(country);
			
			List<Element> stateList = countryRegion.elements();
			for (Element state : stateList) {
				String statename = state.attributeValue("Name");
				String statecode = state.attributeValue("Code");
				
				if(statecode!=null){
					City state_ = new City();
					state_.setName(statename);
					state_.setParentcode(countrycode);
					state_.setType("state");
					state_.setCode(statecode);
					state_.setParenttype("country");
					cityList.add(state_);
				}
				
				List<Element> cityList1 = state.elements();
				for (Element city : cityList1) {
					String cityname = city.attributeValue("Name");
					String citycode = city.attributeValue("Code");
					
					
					City city_ = new City();
					city_.setName(cityname);
					city_.setParentcode(statecode==null?countrycode:statecode);
					city_.setType("city");
					city_.setCode(citycode);
					city_.setParenttype(statecode==null?"country":"state");
					cityList.add(city_);
					
					List<Element> RegionList = city.elements();
					
					for (Element region : RegionList) {
						String regionname = region.attributeValue("Name");
						String regioncode = region.attributeValue("Code");
						
						City region_ = new City();
						region_.setName(regionname);
						region_.setParentcode(citycode);
						region_.setType("region");
						region_.setCode(regioncode);
						region_.setParenttype("city");
						cityList.add(region_);
					}
				}
				
			}
		}
		
		
		cityService.save(cityList);
		
	}



	@Test
	public void importCn() throws Exception {

		City world = new City ();
		world.setCode ( "world" );
		world.setName ( "world" );
		world.setParentcode ( "00000000000000000000" );
		world.setType ( "world" );
		world.setParenttype ( "00000000000000000000" );
		world.setId ( 999999999 );
		cityList.add ( world );
		for (Element countryRegion : countryRegionList) {
			String countryname = countryRegion.attributeValue ( "Name" );
			String countrycode = countryRegion.attributeValue ( "Code" );

			City country = new City ();

			country.setName ( countryname );
			country.setParentcode ( "world" );
			country.setType ( "country" );
			country.setCode ( countrycode );
			country.setParenttype ( "world" );
			country.setCity ( world );
			cityList.add ( country );

		}

		cityService.save(cityList);

	}


	@Test
	public void import_state() throws DocumentException {

		for (Element element : countryRegionList) {
			String countryName = element.attributeValue ( "Name" );
			String countryCode = element.attributeValue ( "Code" );
			String type = "country";
			City country = cityService.find(countryName,countryCode,type);
			//cityList.add ( country );

			List<Element> stateElements = element.elements ();

			for (Element stateElement : stateElements) {
				String stateName = stateElement.attributeValue ( "Name" );
				String stateCode = stateElement.attributeValue ( "Code" );


				City state = new City ();

				state.setName ( stateName );

				state.setCode ( stateCode );
				state.setParentcode ( country.getCode () );

				state.setType ( "state" );
				state.setParenttype ( country.getType () );

				state.setCity ( country );

				cityList.add ( state );

			}

		}

		cityService.save ( cityList );
//		for (City city : cityList) {
//			System.out.println (city);
//
//		}
//		System.out.println (cityList.size ());
	}

	@Before
	public void before_cn() throws DocumentException {
		Document document = new SAXReader ().read(new File ("I:/LocList-中文版.xml"));

		Element rootElement = document.getRootElement();

		countryRegionList = rootElement.elements();
		cityList= new ArrayList <City> ();
	}


	private List <Element> countryRegionList;
	private List<City> cityList;










	@Test
	public void import_City() throws DocumentException {

		for (Element element : countryRegionList) {
//			String countryName = element.attributeValue ( "Name" );
//			String countryCode = element.attributeValue ( "Code" );
//			String type = "country";
//			City country = cityService.find(countryName,countryCode,type);


			List<Element> stateElements = element.elements ();

			for (Element stateElement : stateElements) {
				String stateName = stateElement.attributeValue ( "Name" );
				String stateCode = stateElement.attributeValue ( "Code" );
				String type = "state";
				City state = cityService.find(stateName,stateCode,type);

				List<Element> cityElements = stateElement.elements ();

				for (Element cityElement : cityElements) {

					String cityName = cityElement.attributeValue ( "Name" );
					String cityCode = cityElement.attributeValue ( "Code" );
					City city = new City ();

					city.setName ( cityName );

					city.setCode ( cityCode );
					city.setParentcode ( state.getCode () );

					city.setType ( "city" );
					city.setParenttype ( state.getType () );

					city.setCity ( state );

					cityList.add ( city );


				}
			}

		}

		//cityService.save ( cityList );
		for (City city : cityList) {
			System.out.println (city);

		}
		System.out.println (cityList.size ());
	}
}
