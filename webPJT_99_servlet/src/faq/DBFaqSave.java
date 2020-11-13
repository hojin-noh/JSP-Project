package faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Faq_dao;
import dto.Faq_dto;

/**
 * Servlet implementation class DBNoticeSave
 */
@WebServlet("/DBFaqSave")
public class DBFaqSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBFaqSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Faq_dao dao = new Faq_dao();
		
		String no 		= dao.getFaqNo();
		String question 	= request.getParameter("t_question");
		String answer 	= request.getParameter("t_answer");
		String reg_id = "manager";
		String reg_date = CommonUtil.getToday();
		String sort = request.getParameter("t-prio");
		
		System.out.println(sort);
		Faq_dto dto 	= new Faq_dto(no, question, answer, reg_id, reg_date, sort, 0);
		
		String msg = "";
		int result = dao.SaveFaq(dto);
		if(result == 0) { 
			msg = " 등록 실패~ ";
		}
		else {
			msg = " 등록 성공~ ";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/FaqList");
		
		RequestDispatcher rd = request.getRequestDispatcher("/common_alert_page.jsp");
		rd.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
