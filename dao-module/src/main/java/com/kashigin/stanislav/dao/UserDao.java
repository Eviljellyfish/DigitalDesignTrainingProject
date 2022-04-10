package com.kashigin.stanislav.dao;

import com.kashigin.stanislav.dao.model.*;
import com.kashigin.stanislav.entity.OrgStructure;
import com.kashigin.stanislav.entity.User;
import com.kashigin.stanislav.entity.UserRoleEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BaseDao<User> {

    private static OrgDao orgDao = new OrgDao();
    @Override
    public User get(int id) {
        User user = null;
        try (Connection connection = DbConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("select * from users where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
//                user.setFirstName(rs.getString(2));
//                user.setSecondName(rs.getString(3));
//                user.setRoleId(rs.getInt(4));
//                user.setOrgId(rs.getInt(5));
//                user.setPosition(rs.getString(6));
                user.setFirstName(rs.getString(2));
                user.setSecondName(rs.getString(3));
                user.setRole(UserRoleEnum.values()[rs.getInt(4)-1]);
                user.setOrg(orgDao.get(rs.getInt(5)));
                user.setPosition(rs.getString(6));
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while(rs.next()) {
                User user = new User();
//                user.setFirstName(rs.getString(2));
//                user.setSecondName(rs.getString(3));
//                user.setRoleId(rs.getInt(4));
//                user.setOrgId(rs.getInt(5));
//                user.setPosition(rs.getString(6));
                user.setFirstName(rs.getString(2));
                user.setSecondName(rs.getString(3));
                user.setRole(UserRoleEnum.values()[rs.getInt(4)-1]);
                user.setOrg(orgDao.get(rs.getInt(5)));
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
    public void save(User user) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("insert into org_structure (firstname, lastname, role_id, org_id, position) values(?, ?, ?, ?, ?)");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSecondName());
            ps.setInt(3, user.getRole().ordinal());
            ps.setInt(4, user.getOrg().getId());
            ps.setString(5, user.getPosition());
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("update org_structure set firstname=?, lastname=?, role_id=?, org_id=?, position=?  where id = ?");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSecondName());
            ps.setInt(3, user.getRole().ordinal());
            ps.setInt(4, user.getOrg().getId());
            ps.setString(5, user.getPosition());
            ps.setInt(6, user.getId());
            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("delete from users where id = ?");
            ps.setInt(1, id);
            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
