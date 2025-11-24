/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SalesPersonDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SalesPerson;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet for handling user authentication
 *
 * @author Huy
 */
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());
    private static final String PARAM_USERNAME = "txtname";
    private static final String ATTR_ERROR = "ERROR";
    private static final String ATTR_USER = "USER";
    private static final String ACTION_DASHBOARD = "MainServlet?action=DASHBOARD";
    private static final String ACTION_HOME = "MainServlet?action=HOME";
    private static final String ERROR_INVALID_USERNAME = "Invalid username!";

    /**
     * Processes login requests for both HTTP GET and POST methods
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter(PARAM_USERNAME);

        if (username == null || username.trim().isEmpty()) {
            LOGGER.log(Level.WARNING, "Login attempt with empty username");
            handleLoginFailure(request, response, ERROR_INVALID_USERNAME);
            return;
        }

        try {
            SalesPersonDAO dao = new SalesPersonDAO();
            SalesPerson user = dao.checkLogin(username);

            if (user != null) {
                LOGGER.log(Level.INFO, "User logged in successfully: {0}", username);
                HttpSession session = request.getSession(true);
                session.setAttribute(ATTR_USER, user);
                request.getRequestDispatcher(ACTION_DASHBOARD).forward(request, response);
            } else {
                LOGGER.log(Level.WARNING, "Failed login attempt for username: {0}", username);
                handleLoginFailure(request, response, ERROR_INVALID_USERNAME);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during login process", e);
            handleLoginFailure(request, response, "An error occurred during login. Please try again.");
        }
    }

    /**
     * Handles login failure by setting error attribute and forwarding to home page
     */
    private void handleLoginFailure(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        request.setAttribute(ATTR_ERROR, errorMessage);
        request.getRequestDispatcher(ACTION_HOME).forward(request, response);
    }

    /**
     * Handles the HTTP GET method
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
     * Handles the HTTP POST method
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
     * Returns a short description of the servlet
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Login Servlet - Handles user authentication for Car Dealership Management System";
    }
}
