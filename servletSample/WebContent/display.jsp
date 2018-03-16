<%
	//表示のページ（index.jspの派生）
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="cb" class="mybeans.CarDBBean" scope="request"/>
<jsp:useBean id="mb" class="mybeans.MeigenBean" scope="request"/>

<%!
	ArrayList colname;
	ArrayList data;
	ArrayList mcolname;
	ArrayList mdata;
	ArrayList scolname;
	ArrayList sdata;
	ArrayList scolname2;
	ArrayList sdata2;

	//getInstance() メソッドで Calendar オブジェクトを取得
	Calendar cal = Calendar.getInstance();
%>

<%
	//日付を取得
	//今日の日付
	int year = cal.get(Calendar.YEAR); //年
	int month = (cal.get(Calendar.MONTH)+1); //月
	int day = cal.get(Calendar.DATE); //日
	//CarDBBeanのsetDataメソッドに今日の日付データをセット
	cb.setData(year, month, day);

	//明日の日付
	cal.add(Calendar.DATE, 1); //+1日
	int nextyear = cal.get(Calendar.YEAR); //年
	int nextmonth = (cal.get(Calendar.MONTH)+1); //月
	int nextday = cal.get(Calendar.DATE); //日
	cal.add(Calendar.DATE, -1); //-1日(+1日したのを元に戻す)
%>

<%
	//CarDBBeanのメソッドを変数に格納(今日の予定)
	colname = cb.getColname();
	data = cb.getData();

	//CarDBBeanのselectメソッド(今日の予定を取得する)実行
	cb.select();

	//CarDBBeanのメソッドを変数に格納
	scolname = cb.getsColname();
	sdata = cb.getsData();


	//CarDBBeanのsetDataメソッドに今日の日付データをセット
	cb.setData(nextyear, nextmonth, nextday);

	//CarDBBeanのselect2メソッド実行
	cb.select2();

	//CarDBBeanのメソッドを変数に格納(明日の予定)
	scolname2 = cb.getsColname2();
	sdata2 = cb.getsData2();

	//CarDBBeanのメソッドを変数に格納(名言)
	mcolname = mb.getmColname();
	mdata = mb.getmData();
%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link rel="stylesheet" href="css/style.css">
    <title>島商デジタルサイネージ</title>
    <script>
    	//10秒ごとにリロード
		setTimeout("location.reload()",100000);
    </script>
</head>

<body>

    <h1>&nbsp;&nbsp;&nbsp;お知らせ</h1>

	<!--参考にできそうなURL↓
		http://ja.learnlayout.com/position-example.html
		http://www.acky.info/tips/css/00002.html

		http://beginners.atompro.net/smpcss_vline00.html
		縦線を引く。

		「今日」とかを囲みたかったら、今日をｈ1ごとdivで囲んでcssのwakuを使う。
	-->

	<!--
		流れる文字 http://yume.hacca.jp/koiki/page/marquee.htm
		<marquee> IE独自タグ
	 -->

	<!-- 今日の予定 -->
	<div id="today">
		<h1>今日</h1>

		<%
		//今日の日付を表示
		out.println(year + "年" + month + "月" + day + "日");
		%>

		<!-- 横線 -->
		<hr width="100%"/>

		<%
		//今日の予定が8件より多かったら
		if(sdata.size()>8){
		%>
			<marquee direction="up" width="600" height="250" scrollamount="3">
				<h3>
					<%
					//表（データベース）を表示（今日の予定）
					//行
					for(int row=0; row<sdata.size(); row++){
					%>
						<br/>
						<%
						ArrayList rowdata = (ArrayList) (sdata.get(row));
						//列
						for(int column=0; column<rowdata.size(); column++){
						%>
							<%= rowdata.get(column) %>
						<%
						}
						%>
					<%
					}
					%>
				</h3>
			</marquee>
		<%
		}else{
		%>
			<h3>
				<%
				//表（データベース）を表示（今日の予定）
				//行
				for(int row=0; row<sdata.size(); row++){
				%>
					<br/>
					<%
					ArrayList rowdata = (ArrayList) (sdata.get(row));
					//列
					for(int column=0; column<rowdata.size(); column++){
					%>
						<%= rowdata.get(column) %>
					<%
					}
					%>
				<%
				}
				%>
			</h3>
		<%
		}
		%>
	</div>

	<!-- 横線 -->
	<hr width="99%" style="position:absolute; bottom: 44%;"/>

	<!-- 明日の予定 -->
	<div id="tomorrow">
		<h1>明日</h1>

		<%
		//明日の日付を表示
		out.println(nextyear + "年" + nextmonth + "月" + nextday + "日");
		%>

		<!-- 横線 -->
		<hr width="100%"/>

		<%
		//明日の予定が8件より多かったら
		if(sdata2.size()>8){
		%>
			<marquee direction="up" width="600" height="250" scrollamount="3">
				<h3>
					<%
					//表（データベース）を表示（今日の予定）
					//行
					for(int row=0; row<sdata2.size(); row++){
					%>
						<br/>
						<%
						ArrayList rowdata = (ArrayList) (sdata2.get(row));
						//列
						for(int column=0; column<rowdata.size(); column++){
						%>
							<%= rowdata.get(column) %>
						<%
						}
						%>
					<%
					}
					%>
				</h3>
			</marquee>
		<%
		}else{
		%>
			<h3>
				<%
				//表（データベース）を表示（今日の予定）
				//行
				for(int row=0; row<sdata2.size(); row++){
				%>
					<br/>
					<%
					ArrayList rowdata = (ArrayList) (sdata2.get(row));
					//列
					for(int column=0; column<rowdata.size(); column++){
					%>
						<%= rowdata.get(column) %>
					<%
					}
					%>
				<%
				}
				%>
			</h3>
		<%
		}
		%>
	</div>

	<hr width="99%" style="position:absolute; bottom: 90.5%;"/>

	<!-- 名言 -->
	<div id="meigen">
		<h1>名言</h1>

		<hr width="100%"/>

		<!-- 名言表示 -->
		<h3>
			<%
			//ランダムに名言を表示

			//ランダムメソッドでランダムの数字（1～99）を取得（double型）
			double d = Math.random()*100;

			//double型をint型に
			int rand = (int)d;

			//数が名言の数以上なら
			if(rand>73){
				rand = rand-73;
			}
			%>

			<%
			//配列[rand][1]の名言を表示
			ArrayList rowdata = (ArrayList) (mdata.get(rand-1));
			%>
			<%= rowdata.get(1) %>
		</h3>

	</div>

</body>
</html>
