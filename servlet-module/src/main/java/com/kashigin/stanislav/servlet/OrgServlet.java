package com.kashigin.stanislav.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kashigin.stanislav.dao.OrgDao;
import com.kashigin.stanislav.dao.model.OrgStructureModel;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name="OrgServlet", urlPatterns = "/org")
public class OrgServlet extends HttpServlet {

    private static OrgDao orgDao = new OrgDao();
    private static Gson gson = new Gson();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ModelMapper modelMapper = new ModelMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            OrgStructureModel org = orgDao.get(Integer.parseInt(id));
            try(PrintWriter writer = resp.getWriter()) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                writer.print(gson.toJson(org));
                writer.flush();
            }
        }
        else {
            List<OrgStructureModel> org = orgDao.getAll();
            try(PrintWriter writer = resp.getWriter()) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                writer.print(gson.toJson(org));
                writer.flush();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(body);

        OrgStructureModel org = objectMapper.readValue(body, OrgStructureModel.class);

        orgDao.save(org);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            orgDao.delete(Integer.parseInt(id));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
