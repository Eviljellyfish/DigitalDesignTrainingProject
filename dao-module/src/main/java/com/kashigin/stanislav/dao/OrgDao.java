package com.kashigin.stanislav.dao;

import com.kashigin.stanislav.entity.OrgStructure;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrgDao implements BaseDao<OrgStructure, Long> {

    private static UserDao userDao = new UserDao();

    @Override
    public OrgStructure get(Long id) {
        OrgStructure org = null;
        try (Connection connection = DbConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("select * from org where id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                org = new OrgStructure();
                org.setId(rs.getLong(1));
                org.setName(rs.getString(2));
                org.setHead(userDao.get(rs.getLong(3)));
                org.setParent(this.get(rs.getLong(4)));
            }
        }
        catch (SQLException | ClassNotFoundException e) {
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
                org.setId(rs.getLong(1));
                org.setName(rs.getString(2));
                org.setHead(userDao.get(rs.getLong(3)));
                org.setParent(this.get(rs.getLong(4)));
                orgs.add(org);
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  orgs;
    }

    @Override
    public void save(OrgStructure orgStructure) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("insert into org_structure (id, name, user_id, parent_org_id) values(DEFAULT, ?, ?, ?)");

            if (orgStructure.getName() != null)
                ps.setString(1, orgStructure.getName());
            else
                ps.setNull(1, Types.NULL);
            if (orgStructure.getHead() != null)
                ps.setLong(2, orgStructure.getHead().getId());
            else
                ps.setNull(2, Types.NULL);
            if (orgStructure.getParent() != null)
                ps.setLong(3, orgStructure.getParent().getId());
            else
                ps.setNull(3, Types.NULL);

            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(OrgStructure orgStructure) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("update org_structure set name=?, user_id=?, parent_org_id=? where id = ?");

            if (orgStructure.getName() != null)
                ps.setString(1, orgStructure.getName());
            else
                ps.setNull(1, Types.NULL);
            if (orgStructure.getHead() != null)
                ps.setLong(2, orgStructure.getHead().getId());
            else
                ps.setNull(2, Types.NULL);
            if (orgStructure.getParent() != null)
                ps.setLong(3, orgStructure.getParent().getId());
            else
                ps.setNull(3, Types.NULL);
            ps.setLong(4, orgStructure.getId());

            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("delete from org_structure where id = ?");
            ps.setLong(1, id);
            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
