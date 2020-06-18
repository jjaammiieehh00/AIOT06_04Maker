package com.aiotdelivery.controller;

import com.aiotdelivery.DAO.DeliveryDAO;
import com.aiotdelivery.bean.CustomerBean;
import com.aiotdelivery.bean.ViewOrderListBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/GetOrderListUser")
public class GetOrderListUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        DeliveryDAO dao = new DeliveryDAO();
        List<ViewOrderListBean> ords;
        CustomerBean user = (CustomerBean) request.getSession().getAttribute("user");
        String userName = user.getName();

        int identity = (int) request.getSession().getAttribute("identity");

        if (identity == 1) // admin
            ords = dao.getOrderListAll();
        else
            ords = dao.getOrderListByName(userName);
        request.setAttribute("ords", ords);
    } // end of doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    } // end of doPost()
} // end of class GetAllMembers
