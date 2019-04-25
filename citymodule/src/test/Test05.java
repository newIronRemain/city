package test;

import com.pojo.SysplDistrict;
import com.service.IDistrictService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Test05 {

    @Autowired
    IDistrictService districtService;

    @Test
    public void test01() throws IOException {
        File file = new File ( "e:\\city.xlsx" );
        XSSFWorkbook workbook = new XSSFWorkbook ( new FileInputStream ( new File ( "e:\\city.xlsx" ) ) );

        XSSFSheet sheet = workbook.getSheetAt ( 0 );

        List <SysplDistrict> countryList = districtService.findBySql ( "from SysplDistrict where districtName = '全国城市' order by districtName" );
        //List <SysplDistrict> countryList = districtService.findBySql ( "from SysplDistrict where districtLevel = 'country' order by districtName" );

        int flag = 0;
        for (SysplDistrict district : countryList) {
            //System.out.println (district.getDistrictName ());
            XSSFRow row = sheet.getRow ( flag );
            XSSFCell rowCell = row.getCell ( 0 );
            if (row.getCell ( 0 )==null){
                row.createCell ( 0 );
                rowCell = row.getCell ( 0 );
            }
            XSSFCell rowCell_en = row.getCell ( 1 );
            if (row.getCell ( 1 )==null){
                row.createCell ( 1 );
                rowCell_en = row.getCell ( 1 );
            }

            rowCell.setCellValue ( district.getDistrictName () );
            rowCell_en.setCellValue ( district.getDistrictNameEN () );

            flag++;
            List <SysplDistrict> districts = districtService.findByParent ( district);

            for (SysplDistrict sysplDistrict : districts) {
                XSSFRow row1 = sheet.getRow ( flag );
                XSSFCell cell_coun = row1.getCell ( 0 );
                if (row1.getCell ( 0 )==null){
                    row1.createCell ( 0 );
                    cell_coun = row1.getCell ( 0 );
                }
                XSSFCell cell1_counen = row1.getCell ( 1 );
                if (row1.getCell ( 1 )==null){
                    row1.createCell ( 1 );
                    cell1_counen = row1.getCell ( 1 );
                }
                XSSFCell cell1 = row1.getCell ( 2 );
                if (row1.getCell ( 2 )==null){
                    row1.createCell ( 2 );
                    cell1 = row1.getCell ( 2 );
                }
                XSSFCell cell1_en = row1.getCell ( 3 );
                if (row1.getCell ( 3 )==null){
                    row1.createCell ( 3 );
                    cell1_en = row1.getCell ( 3 );
                }
                cell_coun.setCellValue ( district.getDistrictName () );
                cell1_counen.setCellValue ( district.getDistrictNameEN () );
                cell1.setCellValue ( sysplDistrict.getDistrictName () );
                cell1_en.setCellValue ( sysplDistrict.getDistrictNameEN () );

                flag++;
                //System.out.println ("----"+sysplDistrict.getDistrictName ());

                List <SysplDistrict> citys = districtService.findByParent ( sysplDistrict);
                for (SysplDistrict city : citys) {
                    XSSFRow row2 = sheet.getRow ( flag );
                    XSSFCell cell1_coun_1 = row2.getCell ( 0 );
                    if (row2.getCell ( 0 )==null){
                        row2.createCell ( 0 );
                        cell1_coun_1 = row2.getCell ( 0 );
                    }
                    XSSFCell cell1_counen_1 = row2.getCell ( 1 );
                    if (row2.getCell ( 1 )==null){
                        row2.createCell ( 1 );
                        cell1_counen_1 = row2.getCell ( 1 );
                    }
                    XSSFCell cell_state = row2.getCell ( 2 );
                    if (row2.getCell ( 2 )==null){
                        row2.createCell ( 2 );
                        cell_state = row2.getCell ( 2 );
                    }
                    XSSFCell cell_stateen = row2.getCell ( 3 );
                    if (row2.getCell ( 3 )==null){
                        row2.createCell ( 3 );
                        cell_stateen = row2.getCell ( 3 );
                    }


                    XSSFCell cell2 = row2.getCell ( 4 );
                    if (row2.getCell ( 4 )==null){
                        row2.createCell ( 4 );
                        cell2 = row2.getCell ( 4 );
                    }
                    XSSFCell cell2_en = row2.getCell ( 5 );
                    if (row2.getCell ( 5 )==null){
                        row2.createCell ( 5 );
                        cell2_en = row2.getCell ( 5 );
                    }

                    cell1_coun_1.setCellValue ( district.getDistrictName () );
                    cell1_counen_1.setCellValue ( district.getDistrictNameEN () );
                    cell_state.setCellValue ( sysplDistrict.getDistrictName () );
                    cell_stateen.setCellValue ( sysplDistrict.getDistrictNameEN () );

                    cell2.setCellValue ( city.getDistrictName () );
                    cell2_en.setCellValue ( city.getDistrictNameEN () );

                    flag++;

                    List <SysplDistrict> regions = districtService.findByParent ( city);
                    for (SysplDistrict region : regions) {

                    XSSFRow row3 = sheet.getRow ( flag );

                        XSSFCell cell1_coun_2 = row3.getCell ( 0 );
                        if (row3.getCell ( 0 )==null){
                            row3.createCell ( 0 );
                            cell1_coun_2 = row3.getCell ( 0 );
                        }
                        XSSFCell cell1_counen_2 = row3.getCell ( 1 );
                        if (row3.getCell ( 1 )==null){
                            row3.createCell ( 1 );
                            cell1_counen_2 = row3.getCell ( 1 );
                        }
                        XSSFCell cell_state_1 = row3.getCell ( 2 );
                        if (row3.getCell ( 2 )==null){
                            row3.createCell ( 2 );
                            cell_state_1 = row3.getCell ( 2 );
                        }
                        XSSFCell cell_stateen_1 = row3.getCell ( 3 );
                        if (row3.getCell ( 3 )==null){
                            row3.createCell ( 3 );
                            cell_stateen_1 = row3.getCell ( 3 );
                        }


                        XSSFCell cell2_1 = row3.getCell ( 4 );
                        if (row3.getCell ( 4 )==null){
                            row3.createCell ( 4 );
                            cell2_1 = row3.getCell ( 4 );
                        }
                        XSSFCell cell2_en_1 = row3.getCell ( 5 );
                        if (row3.getCell ( 5 )==null){
                            row3.createCell ( 5 );
                            cell2_en_1 = row3.getCell ( 5 );
                        }


                    XSSFCell cell3 = row3.getCell ( 6 );

                    if (row3.getCell ( 6 )==null){
                        row3.createCell ( 6 );
                        cell3 = row3.getCell ( 6 );
                    }

                    XSSFCell cell3_en = row3.getCell ( 7 );

                    if (row3.getCell ( 7 )==null){
                        row3.createCell ( 7 );
                        cell3_en = row3.getCell ( 7 );
                    }

                    cell1_coun_2.setCellValue ( district.getDistrictName () );
                    cell1_counen_2.setCellValue ( district.getDistrictNameEN () );
                    cell_state_1.setCellValue ( sysplDistrict.getDistrictName () );
                    cell_stateen_1.setCellValue ( sysplDistrict.getDistrictNameEN () );

                    cell2_1.setCellValue ( city.getDistrictName () );
                    cell2_en_1.setCellValue ( city.getDistrictNameEN () );



                    cell3.setCellValue ( region.getDistrictName () );
                    cell3_en.setCellValue ( region.getDistrictNameEN () );

                    flag++;
                    }
                }
            }

        }

        workbook.write ( new FileOutputStream ( file ) );


    }
}
