package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.CP;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String QUERY = "insert into actor(actor_id, first_name, last_name, last_update) values(?,?,?,?)";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		try (Connection connection = CP.createC(); PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
			preparedStatement.setInt(1, Integer.parseInt(request.getParameter("actor_id")));
            preparedStatement.setString(2, request.getParameter("first_name"));
            preparedStatement.setString(3, request.getParameter("last_name"));
            preparedStatement.setString(4, request.getParameter("last_update"));
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	System.out.println(e);
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
