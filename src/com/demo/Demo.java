package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.demo.CP;
import com.demo.pogo.Actor;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/view")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String QUERY = "SELECT * FROM actor";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Actor> actors = new ArrayList<>();
		try {
			
			// creating connection object
			// jdbc connection setup
			try (Connection connection = CP.createC();){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY);
			while(resultSet.next()) {
				Actor actor = new Actor();
				
				//getting data based on column name
				actor.setFirstName(resultSet.getString("first_name"));
				actor.setLastName(resultSet.getString("last_name"));
				
				
				//gettind data based on column number
				actor.setId(resultSet.getInt(1));
				actor.setLastUpdated(resultSet.getDate(4));
				actors.add(actor);
			}
			
			// converting list into JSON Data
			Gson gson = new Gson();
			String result = gson.toJson(actors);
			
			//setting the response headers
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			// sending JSON Data
			PrintWriter writer = response.getWriter();
			writer.print(result);
			writer.flush();
			writer.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}catch(Exception e) {
		System.out.println(e);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
