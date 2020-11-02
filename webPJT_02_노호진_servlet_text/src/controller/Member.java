package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Notice_dao;
import dto.Notice_dto;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");;
		Notice_dao dao = new Notice_dao();
		ArrayList<Notice_dto> dtos = dao.getNoticeList("title", ""); 
		
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1> servlet 이다 ~~~");
		out.print("</h1>");
		
		out.print("<table>");
			out.print("<tr>");
				out.print("<th>번호</th>");
				out.print("<th>제목</th>");
				out.print("<th>첨부</th>");
				out.print("<th>등록자</th>");
				out.print("<th>등록일</th>");
				out.print("<th>조회수</th>");
			out.print("</tr>");
			
		for(int k = 0; k < dtos.size(); k++) {
			out.print("<tr>");
				out.print("<td>"+dtos.get(k).getNo()+"</td>");
				out.print("<td>"+dtos.get(k).getTitle()+"</td>");
				out.print("<td>"+dtos.get(k).getAttach()+"</td>");
				out.print("<td>"+dtos.get(k).getReg_name()+"</td>");
				out.print("<td>"+dtos.get(k).getReg_date()+"</td>");
				out.print("<td>"+dtos.get(k).getHit()+"</td>");
			out.print("</tr>");
		}
			
		out.print("</table>");
		
		out.print("</body>");

		out.print("<html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
