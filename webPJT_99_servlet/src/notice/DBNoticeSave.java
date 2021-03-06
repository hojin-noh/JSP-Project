package notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import common.CommonUtil;
import dao.Notice_dao;
import dto.Notice_dto;

/**
 * Servlet implementation class DBNoticeSave
 */
@WebServlet("/DBNoticeSave")
public class DBNoticeSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBNoticeSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Notice_dao dao = new Notice_dao();
		String no 		= dao.getNoticeNo();

		String file_dir = CommonUtil.file_dir_notice;
		int sizeLimit = 1024 * 1024 * 10; 
		MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"utf-8");
		
		String attach = mpr.getFilesystemName("t_attach");				// aaa.hwp
		String dbAttachName = "";
		if(attach != null){
			File oldFile = new File(file_dir, attach);
			File newFile = new File(file_dir, no + "-" + attach);		//N025-aaa.hwp
			oldFile.renameTo(newFile);
			dbAttachName = newFile.getName();							//첨부파일 저장 폴더에서 이름이 N025-aaa.hwp로 올라가게 해줌.
		}
		
		String title 	= mpr.getParameter("t_title");
		String content 	= mpr.getParameter("t_content");
		String reg_name = "관리자";
		String reg_date = CommonUtil.getToday();
		
		Notice_dto dto 	= new Notice_dto(no, title, content, dbAttachName, reg_name, reg_date,0);
		
		String msg = "";
		int result = dao.SaveNotice(dto);
		if(result == 0) { 
			msg = " 등록 실패~ ";
		}
		else {
			msg = " 등록 성공~ ";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/NoticeList");
		
		RequestDispatcher rd = request.getRequestDispatcher("/common_alert_page.jsp");
		rd.forward(request, response);
		
		//response.sendRedirect("/NoticeList");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
