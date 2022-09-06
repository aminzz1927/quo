package com.quo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/login", "/resetpw", "/home", "/system/*","/product/list","/product/listse"})
public class IndexController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletConfig().getServletContext();
		 
		// as a full path you can use with a File object
		String pathToFile = application.getRealPath("/index.html");
		// as an input stream all ready for you to read

String content = new String(Files.readAllBytes(Paths.get(pathToFile)));
response.setContentType("text/html;charset=utf-8");
PrintWriter out = response.getWriter();
out.println(content);
out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
