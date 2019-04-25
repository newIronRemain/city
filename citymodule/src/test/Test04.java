package test;

import com.dao.ICityDao;
import com.dao.IDistrictDao;
import com.dao.impl.CityDaoImpl;
import com.dao.impl.DistrictDaoImpl;
import com.pojo.City;
import com.pojo.SysplDistrict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Test04 {

    @Autowired
    private IDistrictDao districtDao;

    @Autowired
    private ICityDao cityDao;

    @Test
    public void test01(){

        List <SysplDistrict> districts = (List <SysplDistrict>) districtDao.findByHql ( "from SysplDistrict where districtLevel = 'country'" );

        for (SysplDistrict district : districts) {
            System.out.println (district.getDistrictName ());
        }

    }

    @Test
    public void test02(){
        SysplDistrict  district = new SysplDistrict (  );
        district.setDistrictName ( "test" );
        district.setStatus ( "test" );
        districtDao.save(district);
    }

    @Test
    public void test03(){

        List <City> citys = (List <City>) cityDao.findByHql ( "from City where type = 'country'" );
        //System.out.println (citys.size ());
        long id = 20190416001L;
        for (City city : citys) {
            //System.out.println (city.getName ());

            SysplDistrict  district = new SysplDistrict (  );
            district.setDistrictId ( id );
            district.setDistrictName ( city.getName () );
            district.setStatus ( "test" );
            district.setDistrictLevel ( "country" );
            districtDao.save(district);

            id++;
        }

    }
}
