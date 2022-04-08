package com.kashigin.stanislav.dao;

import com.kashigin.stanislav.entity.OrgStructure;
import com.kashigin.stanislav.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrgDao implements BaseDao<OrgStructure> {
    @Override
    public OrgStructure get(int id) {
        OrgStructure org = null;
        try (Connection connection = DbConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("select * from org where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                org = new OrgStructure();
                org.setName(rs.getString(2));
                org.setHead(rs.getObject(3, User.class));
                org.setParent(rs.getObject(4, OrgStructure.class));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  org;
    }

    @Override
    public List<OrgStructure> getAll() {
        List<OrgStructure> orgs = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from org");
            while(rs.next()) {
                OrgStructure org = new OrgStructure();
                org.setName(rs.getString(2));
                org.setHead(rs.getObject(3, User.class));
                org.setParent(rs.getObject(4, OrgStructure.class));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  orgs;
    }

    @Override
    public boolean save(OrgStructure orgDao) {
        return false;
    }

    @Override
    public boolean update(OrgStructure orgDao, String[] param) {
        return false;
    }

    @Override
    public void delete(OrgStructure orgDao) {

    }
}
