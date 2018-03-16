<%
	//登録完了ページ
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="cb" class="mybeans.CarDBBean" scope="request"/>
<%!
   ArrayList colname;
   ArrayList data;
%>
<%
   colname = cb.getColname();
   data = cb.getData();
%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
	<title>登録完了</title>
</head>

<body>
	<center><h1>登録が完了しました</h1></center>

	<br/>

	<!-- データベース表示 -->
	<div style="text-align: center;">

		<table border="1">
			<tr bgcolor="#E0C76F">
				<%
				//項目
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
			//行
			for(int row=0; row<data.size(); row++){
			%>
				<tr>
					<%
					ArrayList rowdata = (ArrayList) (data.get(row));
					//列
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
		<input type="button" onclick="location.href='http://localhost:8080/servletSample/index.jsp'" value="ホーム" style="width:100px; height:50px; position:absolute; bottom:5%; right:5%;" >
	</div>

</body>
</html>
