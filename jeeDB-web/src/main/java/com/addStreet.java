package com;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addStreet", urlPatterns = {"add/street"})
public class addStreet extends HttpServlet {

    @EJB
    private JPAService jpas;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getDistrict(request);
        //request.setAttribute("resultAdd", "");
        request.getRequestDispatcher("/addStreet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("commit") != null) {
            if (0 < jpas.addStreet(
                    new String(request.getParameter("streetName").getBytes("iso-8859-1"), "UTF-8"),
                    new Integer(request.getParameter("DistinctCmb"))
            )) {
                response.sendRedirect("/db/add/street?resultAdd=success");
            } else
                response.sendRedirect("/db/add/street?resultAdd=error");
        }
    }

    private HttpServletRequest getDistrict(HttpServletRequest request) {
        request.setAttribute("DistinctList", jpas.getDistinct());
        return request;
    }
}
