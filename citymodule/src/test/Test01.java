package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pojo.City;
import com.service.ICityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Test01 {
	
	@Autowired
	private ICityService cityService;
	
	
	@Test
	public void testAdd() {
		City city = new City();
		city.setName("北京");
		city.setParentcode("0");
		city.setType("city");
		city.setCode("00001");
		cityService.save(city);
	}
	
	
	@Test
	public void parseXml() throws Exception {
		Document document = new SAXReader().read(new File("X:/LocList-国际版.xml"));
		
		Element rootElement = document.getRootElement();
		
		List<Element> countryRegionList = rootElement.elements();
		List<City> cityList = new ArrayList<City>();
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

}
