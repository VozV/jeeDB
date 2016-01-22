package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addDistinct", urlPatterns = {"add/distinct"})
public class addDistinct extends HttpServlet {

    @EJB
    private JPAService jpas;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("resultAdd", "");
        request.getRequestDispatcher("/addDistinct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //request.setCharacterEncoding("UTF-8");
        if (request.getParameter("commit") != null) {
            if (0 < jpas.addDistinct(
                    new String(request.getParameter("distinctName").getBytes("iso-8859-1"), "UTF-8")
            )) {
                request.setAttribute("resultAdd", "Район успешно добавлена");
            } else
                request.setAttribute("resultAdd", "Произошла ошибка при добавлении");
            request.getRequestDispatcher("/addDistinct.jsp").forward(request, response);
        }
    }
}
