package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addMainServlet", urlPatterns = {"/add"})
public class addMain extends HttpServlet {

    @EJB
    private JPAService jpas;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/addMain.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*if (request.getParameter("addDistrict") != null) {
            request.getRequestDispatcher("/addDistrict.jsp").forward(request, response);
        }
        else if (request.getParameter("addStreet") != null){
            request.getRequestDispatcher("/addStreet.jsp").forward(request, response);
        }
        else if (request.getParameter("addOffice") != null){
            request.getRequestDispatcher("/addOffice.jsp").forward(request, response);
        }
        else if (request.getParameter("addOrder") != null){
            request.getRequestDispatcher("/addOrder.jsp").forward(request, response);
        }*/
    }

/*    private HttpServletRequest getStreet(HttpServletRequest request) {
        request.setAttribute("StreetList", jpas.getStreet());
        return request;
    }

    private HttpServletRequest getDistrict(HttpServletRequest request) {
        request.setAttribute("DistinctList", jpas.getDistinct());
        return request;
    }*/
}
