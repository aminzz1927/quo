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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 韩宛廷
 *
 */
@Controller("indexController2")
public class IndexController2 {
	@RequestMapping({ "/login", "/resetpw", "/home", "/system/*", "/product/*" })
	public String check(HttpServletResponse response) throws IOException {
		ServletContext application = getServletConfig().getServletContext();

		// as a full path you can use with a File object
		String pathToFile = application.getRealPath("/index.html");
		// as an input stream all ready for you to read

		String content = new String(Files.readAllBytes(Paths.get(pathToFile)));
		response.setContentType("text/html;charset=utf-8");
		return content;

	}

}
