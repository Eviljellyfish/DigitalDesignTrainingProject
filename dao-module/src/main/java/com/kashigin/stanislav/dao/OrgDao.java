package com.kashigin.stanislav.dao;

import com.kashigin.stanislav.dao.model.OrgStructureModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrgDao implements BaseDao<OrgStructureModel> {
    @Override
    public OrgStructureModel get(int id) {
        OrgStructureModel org = null;
        try (Connection connection = DbConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("select * from org where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                org = new OrgStructureModel();
                org.setName(rs.getString(2));
                org.setHeadId(rs.getInt(3));
                org.setParentId(rs.getInt(4));
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  org;
    }

    @Override
    public List<OrgStructureModel> getAll() {
        List<OrgStructureModel> orgs = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from org_structure");
            while(rs.next()) {
                OrgStructureModel org = new OrgStructureModel();
                org.setName(rs.getString(2));
                org.setHeadId(rs.getInt(3));
                org.setParentId(rs.getInt(4));
                orgs.add(org);
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  orgs;
    }

    @Override
    public void save(OrgStructureModel orgStructure) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("insert into org_structure values(?, ?, ?)");
            ps.setString(1, orgStructure.getName());
            ps.setInt(2, orgStructure.getHeadId());
            ps.setInt(3, orgStructure.getParentId());
            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, OrgStructureModel orgStructure) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("update org_structure set name=?, user_id=?, parent_id=? where id = ?");
            ps.setString(1, orgStructure.getName());
            ps.setInt(2, orgStructure.getHeadId());
            ps.setInt(3, orgStructure.getParentId());
            ps.setInt(4, orgStructure.getId());
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("delete from org_structure where id = ?");
            ps.setInt(1, id);
            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
