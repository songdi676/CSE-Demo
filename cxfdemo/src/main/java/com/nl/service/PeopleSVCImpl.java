package com.nl.service;

import com.nl.common.DBUtils;
import com.nl.vo.Person;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface="com.nl.service.IPeopleSVC")
public class PeopleSVCImpl implements IPeopleSVC {

    @Override
    public String getNameById(int id) {
        String sql = "select people_name from demo_people where people_id = ? ";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String name = null;

        try {
            conn = DBUtils.getConnection();
            pstm =conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while(rs.next()) {
                name = rs.getString("people_name");
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(pstm != null) {
                    pstm.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    @Override
    public Person insertPerson(Person person) {
        String sql = "INSERT  INTO  DEMO_PEOPLE VALUES (MYSEQ.nextval, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String name = null;

        try {
            conn = DBUtils.getConnection();
            pstm =conn.prepareStatement(sql);
            pstm.setString(1, person.getPeopleName());
            pstm.setInt(2, person.getStatus());
            pstm.setString(3, person.getDescription());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(pstm != null) {
                    pstm.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return person;
    }


    @Override
    public List<Person> listPeople(Person person) {
        String sql = "select * from demo_people where people_name = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String name = null;
        List<Person> list = new ArrayList<>();
        Person p = null;

        try {
            conn = DBUtils.getConnection();
            pstm =conn.prepareStatement(sql);
            pstm.setString(1, person.getPeopleName());
            rs = pstm.executeQuery();
            while(rs.next()) {
                p = new Person();
                p.setPeopleId(rs.getInt("people_id"));
                p.setPeopleName(rs.getString("people_name"));
                p.setStatus(rs.getInt("status"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(pstm != null) {
                    pstm.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
