package com.kashigin.stanislav.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kashigin.stanislav.dao.UserDao;
import com.kashigin.stanislav.entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@Deprecated
@WebServlet(name="UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private  UserDao userDao;
    private  Gson gson;
    private  ObjectMapper objectMapper ;
    private  ModelMapper modelMapper;

    @Override
    public void init() {
        userDao = new UserDao();
        gson = new Gson();
        objectMapper = new ObjectMapper();
        modelMapper = new ModelMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (id != null) {
            User user = userDao.get(Long.parseLong(id));
            try(PrintWriter writer = resp.getWriter()) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                writer.print(gson.toJson(user));
                writer.flush();
            }
        }
        else {
            List<User> user = userDao.getAll();
            try(PrintWriter writer = resp.getWriter()) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                writer.print(gson.toJson(user));
                writer.flush();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(body);
        User user = objectMapper.readValue(body, User.class);
        userDao.save(user);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        if (id != null) {
            userDao.delete(Long.parseLong(id));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(body);

        User user = objectMapper.readValue(body, User.class);

        userDao.update(user);
    }
}
