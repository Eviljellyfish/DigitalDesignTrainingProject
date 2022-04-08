package com.kashigin.stanislav.dao;

import com.kashigin.stanislav.dao.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BaseDao<UserModel> {
    @Override
    public UserModel get(int id) {
        UserModel user = null;
        try (Connection connection = DbConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("select * from users where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserModel();
                user.setFirstName(rs.getString(2));
                user.setSecondName(rs.getString(3));
                user.setRoleId(rs.getInt(4));
                user.setOrgId(rs.getInt(5));
                user.setPosition(rs.getString(6));
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  user;
    }

    @Override
    public List<UserModel> getAll() {
        List<UserModel> users = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while(rs.next()) {
                UserModel user = new UserModel();
                user.setFirstName(rs.getString(2));
                user.setSecondName(rs.getString(3));
                user.setRoleId(rs.getInt(4));
                user.setOrgId(rs.getInt(5));
                user.setPosition(rs.getString(6));
                users.add(user);
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  users;
    }

    @Override
    public void save(UserModel user) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("insert into org_structure values(?, ?, ?, ?, ?)");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSecondName());
            ps.setInt(3, user.getRoleId());
            ps.setInt(4, user.getOrgId());
            ps.setString(5, user.getPosition());
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, UserModel user) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("update org_structure set firstname=?, lastname=?, role_id=?, org_id=?, position=?  where id = ?");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSecondName());
            ps.setInt(3, user.getRoleId());
            ps.setInt(4, user.getOrgId());
            ps.setString(5, user.getPosition());
            ps.setInt(6, user.getId());
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(UserModel user) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("delete from users where id = ?");
            ps.setInt(1, user.getId());
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
