package servletSample;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybeans.CarDBBean;

public class DeleteSample extends HttpServlet
{
	   public void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
	   throws ServletException
	   {
	      try{
	    	//フォームデータの取得
	    	  int No=Integer.parseInt(request.getParameter("delete"));
	    	  //Beanの作成
	    	  CarDBBean cb=new CarDBBean();
	    	  cb.setNo(No);
	    	  cb.dataDelete();

	         //サーブレットコンテキストの取得
	         ServletContext sc = getServletContext();

	         //リクエストの転送
	             sc.getRequestDispatcher("/DataDeletePage.jsp")
	               .forward(request, response);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	}