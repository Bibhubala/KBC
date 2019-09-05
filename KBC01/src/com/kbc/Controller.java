package com.kbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		System.out.println("its inside Controller");
		String name = request.getParameter("name");
		Question  p = new Question();
		p.setName(name);
		String name1=p.getName();
		System.out.println("Name is " + name);
		Connection con = JdbcConn.getConnection();
		// doGet(request, response);
		List<Question> list = JdbcConn.getQuestion();
		System.out.println("List iterator is goinng to create");

		System.out.println("02 created");
		/*while(list!=null) {
			Question q=new Question();
			out.print("firs answer: "+q.getAnswer());
			out.print("second answer: "+q.getAnswer2());
			out.print("third answer: "+q.getAnswer3());
			out.print("fourth answer: "+q.getAnswer4());
		}
		*/
		try {

			out.print("<b><center>Answer all Question</center></b>");
			out.print("<br>");
			int count=0;
			for (Question b : list) {
				
				count+=1;
				out.print(count +") "+ b.getQuestion() + "?" + "<br>");
				// out.print("A) " + b.getAnswer() + "<br>");
				out.print("<form action='Process' method='post'>");
				out.print("<input type='radio' name='option"+count+"' value='"+b.getAnswer()+"'>" + b.getAnswer()+"<br>"
						+ "<input type='radio' name='option"+count+"' value='"+b.getAnswer2()+"'>" + b.getAnswer2()+"<br>"
						+ "<input type='radio' name='option"+count+"' value='"+b.getAnswer3()+"'>"+b.getAnswer3()+"<br>"
						+ "<input type='radio' name='option"+count+"' value='"
						+b.getAnswer4()+"'>"+b.getAnswer4()+"<br>"
						+"<br>");
			}
			out.print("<bold>Hello "+name1+"</bold>");
			out.print("<input type='submit' value='submit'>");
			out.print("</form>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
