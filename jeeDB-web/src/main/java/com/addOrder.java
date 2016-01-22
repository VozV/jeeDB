package com;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addOrder", urlPatterns = {"add/order"})
public class addOrder extends HttpServlet {

    @EJB
    private JPAService jpas;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getDistrict(request);
        getStreet(request);
        request.getRequestDispatcher("/addOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("sumbit") != null) {
            if (0 < jpas.addOrder(
                    new Integer(request.getParameter("DistinctCmb")),
                    new Integer(request.getParameter("StreetCmb")),
                    new String(request.getParameter("houseNumer").getBytes("iso-8859-1"), "UTF-8"),
                    new String(request.getParameter("officeNumer").getBytes("iso-8859-1"), "UTF-8"),
                    new Integer(request.getParameter("count")),
                    new String(request.getParameter("text").getBytes("iso-8859-1"), "UTF-8")
            )) {
                response.sendRedirect("/db/add/order?resultAdd=success");
            } else
                response.sendRedirect("/db/add/order?resultAdd=error");
        }
    }

    private HttpServletRequest getDistrict(HttpServletRequest request) {
        request.setAttribute("DistinctList", jpas.getDistinct());
        return request;
    }

    private HttpServletRequest getStreet(HttpServletRequest request) {
        request.setAttribute("StreetList", jpas.getStreet());
        return request;
    }
}
