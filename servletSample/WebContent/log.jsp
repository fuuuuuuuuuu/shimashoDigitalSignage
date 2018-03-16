<%
	//履歴表示&削除ページ
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="cb" class="mybeans.CarDBBean" scope="request"/>

<%!
	//配列作成
	ArrayList colname;
	ArrayList data;
%>

<%
	//CarDBBeanのメソッドを変数に
	colname = cb.getColname();
	data = cb.getData();
%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
	<title>履歴</title>
</head>

<body>
	<center>
		<h1>履歴</h1>

		<br/>

		<!-- 削除 -->
		削除するデータの番号を入力してください

		<!-- 削除するデータの番号をDeleteSampleへ送信 -->
		<form action="http://localhost:8080/servletSample/servlet/DeleteSample" method="GET" name="logForm" onSubmit="return check();">
			<input type='text' name='delete' />
			<input type="submit" value="削除" />
		</form>
	</center>

	<br/><br/>

	<!-- データベース表示 -->
	<div style="text-align: center;">
		<!-- テーブル -->
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

	<!-- ボタンを表示 -->
	<div id="bottom1">
		<!-- ホームボタン -->
		<input type="button" onclick="location.href='http://localhost:8080/servletSample/index.jsp'" value="ホーム" style="width:100px; height:50px" >
	</div>

</body>
</html>
