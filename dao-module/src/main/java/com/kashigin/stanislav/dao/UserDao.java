package com.kashigin.stanislav.dao;

import com.kashigin.stanislav.entity.OrgStructure;
import com.kashigin.stanislav.entity.User;
import com.kashigin.stanislav.entity.UserRoleEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BaseDao<User> {
    @Override
    public User get(int id) {
        User user = null;
        try (Connection connection = DbConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("select * from users where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setFirstName(rs.getString(2));
                user.setSecondName(rs.getString(3));
                user.setRole(UserRoleEnum.valueOf(rs.getString(4)));
                user.setOrg(rs.getObject(5, OrgStructure.class));
                user.setPosition(rs.getString(6));
            }
        }
        catch (SQLException e) {
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
//                User users = new OrgStructure();
//                users.setName(rs.getString(2));
//                users.setHead(rs.getObject(3, User.class));
//                users.setParent(rs.getObject(4, OrgStructure.class));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  users;
    }

    @Override
    public void save(User userDao) {

    }

    @Override
    public void update(int id, User userDao) {

    }

    @Override
    public void delete(User userDao) {

    }
}
