package servletSample;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybeans.CarDBBean;

public class InputSample extends HttpServlet
{
	   public void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
	   throws ServletException
	   {
		   try{
	    	  int dejino=0;

	    	  //文字列データを取得
	    	  String logid = request.getParameter("id");
	    	  String Tno = request.getParameter("teacherID");
	    	  String come = request.getParameter("coment");

	    	  //数値データを取得
	    	  int year = Integer.valueOf(request.getParameter("year")).intValue();
	    	  int month = Integer.valueOf(request.getParameter("month")).intValue();
	    	  int day = Integer.valueOf(request.getParameter("day")).intValue();
	    	  //int year2 = Integer.valueOf(request.getParameter("year2")).intValue();
	    	  //int month2 = Integer.valueOf(request.getParameter("month2")).intValue();
	    	  //int day2 = Integer.valueOf(request.getParameter("day2")).intValue();

	    	  //Beanの作成
	    	  CarDBBean cb=new CarDBBean();

	    	  cb.teacher();

	    	  //データの数の分だけ数字をふる
	    	  dejino=cb.getData().size()+1;
	    	  dejino=dejino+0;

	    	  //セットメソッド実行
	    	  cb.setLog(logid);
	    	  cb.setNo(dejino);
	    	  cb.setName(come);
	    	  cb.setDate(year,month, day);
	    	  cb.settNo(Tno);

	    	  //dataSetメソッド実行
	    	  cb.dataSet();

	    	  //サーブレットコンテキストの取得
	    	  ServletContext sc = getServletContext();

	    	  //リクエストの転送
	    	  if(Tno.length()!=0 && come.length()!=0){
	    		  //教員IDとコメントが入力されていればSample5.jspを実行
	    		  sc.getRequestDispatcher("/Sample5.jsp").forward(request, response);
	    	  }
	    	  else{
	    		  //入力されていない項目があればerror.htmlへ
	    		  sc.getRequestDispatcher("/error.html").forward(request, response);
	    	  }
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	     }
	}
}
