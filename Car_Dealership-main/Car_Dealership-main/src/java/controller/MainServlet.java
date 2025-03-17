/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Huy
 */
public class MainServlet extends HttpServlet {

    private static final String WELCOME = "LoginSalesPersonPage.jsp";
    private static final String LOGIN = "LoginServlet";
    private static final String DASHBOARD = "SalesPersonDashboard.jsp";
    private static final String LOGOUT = "LogoutServlet";
    private static final String LOAD_CUSTOMER = "CustomerServlet";
    private static final String DASHBOARD_CUSTOMER = "CustomerPage.jsp";
    private static final String REGISTER_CUSTOMER = "CreateCustomer.jsp";
    private static final String CREATE_CUSTOMER = "CreateCustServlet";
    private static final String DELETE_CUSTOMER = "DeleteCustServlet";
    private static final String EDIT_CUSTOMER = "EditCustServlet";
    private static final String VIEW_UPDATE_CUSTOMER = "UpdateCustomer.jsp";
    private static final String UPDATE_CUSTOMER = "UpdateCustServlet";
    private static final String SEARCH_CUSTOMER = "SearchCusServlet";
    private static final String LOAD_DETAIL_CUSTOMER = "DetailCustServlet";
    private static final String VIEW_DETAIL_CUSTOMER = "DetailCustomerPage.jsp";
    private static final String LOAD_CREATE_TICKET = "LoadCreateTicketServlet";
    private static final String VIEW_CREATE_TICKET = "CreateServiceTicket.jsp";
    private static final String CREATE_SERVICE_TICKET = "CreateServiceTicketServlet";
    private static final String LOAD_CARS = "CarServlet";
    private static final String DOASHBOARD_CARS = "CarPage.jsp";
    private static final String REGISTER_CAR = "CreateCar.jsp";
    private static final String CREATE_CAR = "CreateCarServlet";
    private static final String DELETE_CAR = "DeleteCarServlet";
    private static final String EDIT_CAR = "EditCarServlet";
    private static final String VIEW_UPDATE_CAR = "UpdateCar.jsp";
    private static final String UPDATE_CAR = "UpdateCarServlet";
    private static final String SEARCH_CAR = "SearchCarServlet";
    private static final String LOAD_PARTS = "ManagePartsServlet";
    private static final String CREATE_PARTS = "CreatePartsPage.jsp";
    private static final String SEARCH_PARTS = "SearchPartsNameServlet";
    private static final String DASHBOARD_PARTS = "DashboardPartsPage.jsp";
    private static final String CREATE_PARTS_SUCCESS = "CreatePartsServlet";
    private static final String DELETE_PARTS = "DeletePartsServlet";
    private static final String INVOICE_CUSTOMER = "ManageInvoiceServlet";
    private static final String SHOW_INVOICE = "ShowAllInvoice.jsp";
    private static final String CREATE_NEW_INVOICE = "CreateInvoicePage.jsp";
    private static final String UPDATE_PARTS = "UpdatePartsServlet";
    private static final String CREATE_INVOICE_CUS = "CreateInvoiceCustomerServlet";
    private static final String DETAIL_INVOICE = "ShowDetailInvoice.jsp";
    private static final String INVOICE_DETAIL_SER = "DetailInvoiceServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = WELCOME;
        try {
            String action = request.getParameter("action");
            if (action == null || action.isEmpty()) {
                action = "HOME";
            }
            switch (action) {
                case "HOME":
                    url = WELCOME;
                    break;
                case "LOGIN":
                    url = LOGIN;
                    break;
                case "DASHBOARD":
                    url = DASHBOARD;
                    break;
                case "LOGOUT":
                    url = LOGOUT;
                    break;
                case "LOAD_CUSTOMER":
                    url = LOAD_CUSTOMER;
                    break;
                case "DASHBOARD_CUSTOMER":
                    url = DASHBOARD_CUSTOMER;
                    break;
                case "REGISTER_CUSTOMER":
                    url = REGISTER_CUSTOMER;
                    break;
                case "CREATE_CUSTOMER":
                    url = CREATE_CUSTOMER;
                    break;
                case "DELETE_CUSTOMER":
                    url = DELETE_CUSTOMER;
                    break;
                case "EDIT_CUSTOMER":
                    url = EDIT_CUSTOMER;
                    break;
                case "VIEW_UPDATE_CUSTOMER":
                    url = VIEW_UPDATE_CUSTOMER;
                    break;
                case "UPDATE_CUSTOMER":
                    url = UPDATE_CUSTOMER;
                    break;
                case "SEARCH_CUSTOMER":
                    url = SEARCH_CUSTOMER;
                    break;
                case "LOAD_DETAIL_CUSTOMER":
                    url = LOAD_DETAIL_CUSTOMER;
                    break;
                case "VIEW_DETAIL_CUSTOMER":
                    url = VIEW_DETAIL_CUSTOMER;
                    break;
                case "LOAD_CREATE_TICKET":
                    url = LOAD_CREATE_TICKET;
                    break;
                case "VIEW_CREATE_TICKET":
                    url = VIEW_CREATE_TICKET;
                    break;
                case "CREATE_SERVICE_TICKET":
                    url = CREATE_SERVICE_TICKET;
                    break;
                case "LOAD_CARS":
                    url = LOAD_CARS;
                    break;
                case "DOASHBOARD_CARS":
                    url = DOASHBOARD_CARS;
                    break;
                case "REGISTER_CAR":
                    url = REGISTER_CAR;
                    break;
                case "CREATE_CAR":
                    url = CREATE_CAR;
                    break;
                case "DELETE_CAR":
                    url = DELETE_CAR;
                    break;
                case "EDIT_CAR":
                    url = EDIT_CAR;
                    break;
                case "VIEW_UPDATE_CAR":
                    url = VIEW_UPDATE_CAR;
                    break;
                case "UPDATE_CAR":
                    url = UPDATE_CAR;
                    break;
                case "SEARCH_CAR":
                    url = SEARCH_CAR;
                    break;
                case "LOAD_PARTS":
                    url = LOAD_PARTS;
                    break;
                case "CREATE_PARTS":
                    url = CREATE_PARTS;
                    break;
                case "SEARCH_PARTS":
                    url = SEARCH_PARTS;
                    break;
                case "DASHBOARD_PARTS":
                    url = DASHBOARD_PARTS;
                    break;
                case "CREATE_PARTS_SUCCESS":
                    url = CREATE_PARTS_SUCCESS;
                    break;
                case "DELETE_PARTS":
                    url = DELETE_PARTS;
                    break;
                case "INVOICE_CUSTOMER":
                    url = INVOICE_CUSTOMER;
                    break;
                case "SHOW_INVOICE":
                    url = SHOW_INVOICE;
                    break;
                case "CREATE_NEW_INVOICE":
                    url = CREATE_NEW_INVOICE;
                    break;
                case "UPDATE_PARTS":
                    url = UPDATE_PARTS;
                    break;
                case "CREATE_INVOICE_CUS":
                    url = CREATE_INVOICE_CUS;
                    break;
                case "DETAIL_INVOICE":
                    url = DETAIL_INVOICE;
                    break;
                case "INVOICE_DETAIL_SER":
                    url = INVOICE_DETAIL_SER;
                    break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
