package com.kashigin.stanislav.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kashigin.stanislav.dao.UserDao;
import com.kashigin.stanislav.dao.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name="UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private  UserDao userDao;
    private  Gson gson;
    private  ObjectMapper objectMapper ;
    private  ModelMapper modelMapper;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
        gson = new Gson();
        objectMapper = new ObjectMapper();
        modelMapper = new ModelMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            UserModel user = userDao.get(Integer.parseInt(id));
            try(PrintWriter writer = resp.getWriter()) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                writer.print(gson.toJson(user));
                writer.flush();
            }
        }
        else {
            List<UserModel> user = userDao.getAll();
            try(PrintWriter writer = resp.getWriter()) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                writer.print(gson.toJson(user));
                writer.flush();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(body);

        UserModel user = objectMapper.readValue(body, UserModel.class);

        userDao.save(user);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            userDao.delete(Integer.parseInt(id));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(body);

        UserModel user = objectMapper.readValue(body, UserModel.class);

        userDao.update(user);
    }
}
