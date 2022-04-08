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
            ResultSet rs = statement.executeQuery("select * from org_structure");
            while(rs.next()) {
                OrgStructure org = new OrgStructure();
                org.setName(rs.getString(2));
                org.setHead(rs.getObject(3, User.class));
                org.setParent(rs.getObject(4, OrgStructure.class));
                orgs.add(org);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  orgs;
    }

    @Override
    public void save(OrgStructure orgStructure) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("insert into org_structure values(?, ?, ?)");
            ps.setString(1, orgStructure.getName());
            ps.setInt(2, orgStructure.getHead().getId());
            ps.setInt(3, orgStructure.getParent().getId());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, OrgStructure orgStructure) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("update org_structure set name=?, user_id=?, parent_id=? where id = ?");
            ps.setString(1, orgStructure.getName());
            ps.setInt(2, orgStructure.getHead().getId());
            ps.setInt(3, orgStructure.getParent().getId());
            ps.setInt(4, orgStructure.getId());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(OrgStructure orgStructure) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("delete from org_structure where id = ?");
            ps.setInt(1, orgStructure.getId());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
