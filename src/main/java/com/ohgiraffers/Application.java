package com.ohgiraffers;

import com.ohgiraffers.model.dto.CityDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {
    public void menu1() {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = con.prepareStatement("SELECT city_id, city FROM city");

            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println(rset.getString("city_id") + ", " + rset.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }

    public void menu2(int cityId) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        CityDTO selectCity = null;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/city-query.xml"));
            String query = prop.getProperty("selectCity");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, cityId);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectCity = new CityDTO();

                selectCity.setCityId(rset.getInt("city_id"));
                selectCity.setName(rset.getString("city"));
                selectCity.setCountryId(rset.getInt("country_id"));
                selectCity.setLastUpdate(rset.getString("last_update"));

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

            System.out.println(selectCity.toString());

    }

    public void menu3(int cityId, String city, int countryId) {

        CityDTO changeCity = new CityDTO();
        changeCity.setCityId(cityId);
        changeCity.setName(city);
        changeCity.setCountryId(countryId);

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/city-query.xml"));
            String query = prop.getProperty("updateCity");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, changeCity.getCityId());
            pstmt.setString(2, changeCity.getName());
            pstmt.setInt(3, changeCity.getCountryId());

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }

        if (result > 0) {
            System.out.println("도시 변경 성공!");
        } else {
            System.out.println("도시 변경 실패ㅠㅠ");
        }

    }

    public void menu4(String city, int countryId) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/city-query.xml"));
            String query = prop.getProperty("insertCity");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, city);
            pstmt.setInt(2, countryId);

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }

        if (result > 0) {
            System.out.println("도시 추가 성공!");
        } else {
            System.out.println("도시 추가 실패ㅠㅠ");
        }


    }

    public void menu5(int cityId) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/city-query.xml"));
            String query = prop.getProperty("deleteCity");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, cityId);

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }

        if (result > 0) {
            System.out.println("도시 삭제 성공!");
        } else {
            System.out.println("도시 삭제 실패ㅠㅠ");
        }
    }
}
