<%
	//データ削除成功ページ
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="cb" class="mybeans.CarDBBean" scope="request"/>
<%!
	//配列宣言
	ArrayList colname;
	ArrayList data;
%>
<%
	//メソッドを変数に格納
	colname = cb.getColname();
	data = cb.getData();
%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
	<title>削除</title>
</head>
<body>
	<div style="text-align: center;">
	<h2>削除</h2>
	<br/>
	データを削除しました。<br/>
	<br/>

	<!-- データベース表示 -->
	<table border="1">
		<tr bgcolor="#E0C76F">
			<%
			for(int column=0; column<colname.size(); column++){
			%>
				<th>
				<%= (String) colname.get(column) %>
				</th>
			<%
   			}
			%>
		</tr>

		<%
		for(int row=0; row<data.size(); row++){
		%>
			<tr>
				<%
				ArrayList rowdata = (ArrayList) (data.get(row));
				for(int column=0; column<rowdata.size(); column++){
				%>
					<td>
						<%= rowdata.get(column) %>
					</td>
				<%
				}
				%>
			</tr>
		<%
		}
		%>
	</table>
	</div>

	<!-- ボタン -->
	<div id="bottom1">
		<input type="button" onclick="location.href='http://localhost:8080/servletSample/index.jsp'" value="ホーム" style="width:100px; height:50px" >
	</div>
</body>
</html>
