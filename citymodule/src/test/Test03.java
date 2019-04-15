package test;

import com.pojo.City;
import com.service.ICityService;
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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Test03 {
    private List <Element> countryRegionList;
    private List<City> cityList;
    private Document document;
    City world;


    @Autowired
    private ICityService cityService;

    @Before
    public void before_cn() throws DocumentException {

        document = new SAXReader ().read(new File ("I:/LocList-国际版.xml"));

        Element rootElement = document.getRootElement();

        countryRegionList = rootElement.elements();
        cityList= new ArrayList <City> ();

        City world;
        world = new City ();
        world.setCode ( "world" );
        world.setName ( "world" );
        world.setParentcode ( "00000000000000000000" );
        world.setType ( "world" );
        world.setParenttype ( "00000000000000000000" );
        world.setId ( 999999999 );
    }


    @Test
    public void import_test(){


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

            cityService.save ( country );

            List<Element> stateElements = countryRegion.elements ();

            for (Element stateElement : stateElements) {

                String statename = stateElement.attributeValue ( "Name" );
                String statecode = stateElement.attributeValue ( "Code" );

                City state_ = null;
                if(statecode!=null){
                    state_ = new City();
                    state_.setName(statename);
                    state_.setParentcode(countrycode);
                    state_.setType("state");
                    state_.setCode(statecode);
                    state_.setParenttype("country");
                    state_.setCity ( country );
                    cityService.save ( state_ );

                }
                List<Element> cityList1 = stateElement.elements();
                for (Element city : cityList1) {
                    String cityname = city.attributeValue("Name");
                    String citycode = city.attributeValue("Code");


                    City city_ = new City();
                    city_.setName(cityname);
                    city_.setParentcode(statecode==null?countrycode:statecode);
                    city_.setType("city");
                    city_.setCode(citycode);
                    city_.setParenttype(statecode==null?"country":"state");
                    city_.setCity ( statecode==null ? country : state_ );
                    cityService.save ( city_ );

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
                        region_.setCity ( city_ );
                        cityService.save ( region_ );
                    }
                }

            }

        }



    }


}
