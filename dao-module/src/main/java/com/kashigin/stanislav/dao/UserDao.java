package com.kashigin.stanislav.dao;

import com.kashigin.stanislav.entity.User;
import com.kashigin.stanislav.entity.UserRoleEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BaseDao<User, Long> {

    private static OrgDao orgDao = new OrgDao();
    @Override
    public User get(Long id) {
        User user = null;
        try (Connection connection = DbConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("select * from users where id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong(1));
                user.setFirstName(rs.getString(2));
                user.setSecondName(rs.getString(3));
                user.setRole(UserRoleEnum.values()[rs.getInt(4)]);
                if (rs.getLong(5) != 0) {
                    user.setOrg(orgDao.get(rs.getLong(5)));
                    user.setPosition(rs.getString(6));
                }
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
                user.setId(rs.getLong(1));
                user.setFirstName(rs.getString(2));
                user.setSecondName(rs.getString(3));
                user.setRole(UserRoleEnum.values()[rs.getInt(4)]);
                if (rs.getLong(5) != 0) {
                    user.setOrg(orgDao.get(rs.getLong(5)));
                    user.setPosition(rs.getString(6));
                }
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
            PreparedStatement ps =  connection.prepareStatement("insert into users (id, firstname, lastname, role_id, org_id, position) values(DEFAULT, ?, ?, ?, ?, ?)");
            if (user.getFirstName() != null)
                ps.setString(1, user.getFirstName());
            else
                ps.setNull(1, Types.NULL);
            if (user.getSecondName() != null)
                ps.setString(2, user.getSecondName());
            else
                ps.setNull(2, Types.NULL);
            if (user.getRole() != null)
                ps.setInt(3, user.getRole().getValue());
            else
                ps.setNull(3, Types.NULL);
            if (user.getOrg() != null)
                ps.setLong(4, user.getOrg().getId());
            else
                ps.setNull(4, Types.NULL);
            if (user.getPosition() != null)
                ps.setString(5, user.getPosition());
            else
                ps.setNull(5, Types.NULL);
            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("update users set firstname=COALESCE(?, firstname), lastname=COALESCE(?, lastname), role_id=COALESCE(?, role_id), org_id=COALESCE(?, org_id), position=COALESCE(?, position)  where id = ?");
            if (user.getFirstName() != null)
                ps.setString(1, user.getFirstName());
            else
                ps.setNull(1, Types.NULL);
            if (user.getSecondName() != null)
                ps.setString(2, user.getSecondName());
            else
                ps.setNull(2, Types.NULL);
            if (user.getRole() != null)
                ps.setInt(3, user.getRole().getValue());
            else
                ps.setNull(3, Types.NULL);
            if (user.getOrg() != null)
                ps.setLong(4, user.getOrg().getId());
            else
                ps.setNull(4, Types.NULL);
            if (user.getPosition() != null)
                ps.setString(5, user.getPosition());
            else
                ps.setNull(5, Types.NULL);
            ps.setLong(6, user.getId());
            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("delete from users where id = ?");
            ps.setLong(1, id);
            ps.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
