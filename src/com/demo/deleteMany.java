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
@WebServlet("/deleteMany")
public class deleteMany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String actorId;
	
//	private static final String QUERY = "insert into actor(actor_id, first_name, last_name, last_update) values(201,'Sambit','Saha','2000-12-8')";
	private static final String QUERY = "delete from actor where actor_id in (" + actorId + ")";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMany() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		try (Connection connection = CP.createC(); PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
			preparedStatement.setInt(1, Integer.parseInt(request.getParameter("actor_id")));
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
