package com.kbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Process
 */
@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Controller ctr=new Controller();
		//String name=bj.getName();
		String answer1=request.getParameter("option1");
		String answer2=request.getParameter("option2");
		String answer3=request.getParameter("option3");
		String answer4=request.getParameter("option4");
		String s = request.getParameter("name1");
		System.out.println("Name of the person is:////////");
		System.out.println(answer1+"option1");
		System.out.println(answer2+"option2");
		System.out.println(answer3+"option3");
		System.out.println(answer4+"option4 123");
		int count=0;
		if(answer1.equals("denish rich")) {
			count+=1;
		}
		if(answer2.equals("modi")) {
			count+=1;
		}
		if(answer3.equals("nabin patanaik")) {
			count+=1;
		}
		if(answer4.equals("oop")) {
			count+=1;
		}
		
		out.print("<center>Result</center>");
		out.print("<br><br>");
		out.print(" You have scored: "+count);
		out.print("<br>");
		out.print("new code");
			}

}
