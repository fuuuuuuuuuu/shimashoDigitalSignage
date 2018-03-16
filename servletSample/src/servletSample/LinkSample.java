package servletSample;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkSample extends HttpServlet
{
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException
	{
		try{
			//サーブレットコンテキストの取得
			ServletContext sc = getServletContext();

			//リクエストの転送
			//index.jspへ
			sc.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
