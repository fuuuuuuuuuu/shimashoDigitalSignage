package servletSample;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybeans.CarDBBean;

public class Sample5 extends HttpServlet
{
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException
	{
		try{
			//サーブレットコンテキストの取得
			ServletContext sc = getServletContext();

			//Beanの作成
			CarDBBean cb = new CarDBBean();


			//リクエストに設定
			request.setAttribute("cb", cb);

			//リクエストの転送
			//Sample5.jspへ
			sc.getRequestDispatcher("/Sample5.jsp").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
