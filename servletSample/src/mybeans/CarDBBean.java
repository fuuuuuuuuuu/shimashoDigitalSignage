package mybeans;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CarDBBean implements Serializable
{
	//配列を作成
	private ArrayList<String> colname;//列
	private ArrayList<ArrayList> data;//行

	private ArrayList<String> scolname;
	private ArrayList<ArrayList> sdata;

	private ArrayList<String> scolname2;
	private ArrayList<ArrayList> sdata2;

	//登録データ(登録画面から)
	private int dNo;//番号
	private String logid;//ログID
	private String kNo;//教員番号
	private int year;//年
	private int month;//月
	private int day;//日
	private int year2;//表示終了年
	private int month2;//表示終了月
	private int day2;//表示終了日
	private String Contents;//内容

	//取得データ(ホーム画面から)
	private int syear;//
	private int smonth;//
	private int sday;//

	public CarDBBean()
	{
		try{
			//接続の準備
			String url = "jdbc:derby:sineeji2;create=true";
			String usr = "";
			String pw = "";

			//データベースへの接続
			Connection cn = DriverManager.getConnection(url, usr, pw);

			//問い合わせの準備
			DatabaseMetaData dm = cn.getMetaData();/**/
			ResultSet tb = dm.getTables(null, null, "予定表", null);/**/
			ResultSet tb2 = dm.getTables(null, null, "教員表", null);

			Statement st = cn.createStatement();

			//テーブル作成
			String qry1 = "CREATE TABLE 予定表(番号 int,ログID varchar(20), 教員番号 varchar(10),年 int, 月 int, 日 int, 内容 varchar(200))";
			//入力データ
			String qry2 = "INSERT INTO 予定表 VALUES (1,'00000000000000','T01',0000,00,00,'サンプル')";
			//抽出
			String qry3 = "SELECT 番号, ログID, 予定表.教員番号, 教員表.教員名, 年, 月, 日, 内容 FROM 予定表 JOIN 教員表 ON 予定表.教員番号=教員表.教員番号 ORDER BY 番号 DESC";

			if(!tb.next()){
				st.executeUpdate(qry1);
				st.executeUpdate(qry2);
			}

			//問い合わせ
			ResultSet rs = st.executeQuery(qry3);

			//列数の取得
			ResultSetMetaData rm = rs.getMetaData();
			int cnum = rm.getColumnCount();
			colname = new ArrayList<String>(cnum);

			//列名の取得
			for(int i=1; i<=cnum; i++){
				colname.add(rm.getColumnName(i).toString());
			}

			//行の取得
			data = new ArrayList<ArrayList>();
			while(rs.next()){
				ArrayList<String> rowdata = new ArrayList<String>();
				for(int i=1; i<=cnum; i++){
					rowdata.add(rs.getObject(i).toString());
				}
				data.add(rowdata);
			}

			//接続のクローズ
			rs.close();
			st.close();
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//データベース情報（列・行）を返すメソッド
	public ArrayList getData()
	{
		return data;
	}
	public ArrayList getColname()
	{
		return colname;
	}

	//登録データのセットメソッド
	//番号
	public void setNo(int no){
		dNo=no;
	}
	//ログID
	public void setLog(String lid){
		logid=lid;
	}
	//教員番号
	public void settNo(String tno){
		kNo=tno;
	}
	//年月日
	public void setDate(int tosi,int tsuki,int hi){
		year = tosi;
		month = tsuki;
		day = hi;
	}
	//表示終了年月日
//	public void setDate2(int tosi,int tsuki,int hi){
//		year2 = tosi;
//		month2 = tsuki;
//		day2 = hi;
//	}

	//内容
	public void setName(String name){
		Contents=name;
	}

	//入力したデータをデータベースに登録
	public void dataSet(){
		try{
			//接続の準備
			String url = "jdbc:derby:sineeji2;create=true";
			String usr = "";
			String pw = "";

			//データベースへの接続
			Connection cn = DriverManager.getConnection(url, usr, pw);

			Statement st = cn.createStatement();

			String qry2 = "INSERT INTO 予定表 VALUES ("+dNo+",'"+logid+"','"+kNo+"',"+year+","+month+","+day+",'"+Contents+"')";

			st.executeUpdate(qry2);

			//接続のクローズ
			st.close();
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//日付取得
	public void setData(int year, int month, int day){
		try{
			//System.out.println(year + "年" + month + "月" + day + "日");
			syear = year;
			smonth = month;
			sday = day;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//今日の予定を抽出するメソッド
	public void select(){
		try{
			//接続の準備
			String url = "jdbc:derby:sineeji2;create=true";
			String usr = "";
			String pw = "";

			//データベースへの接続
			Connection cn = DriverManager.getConnection(url, usr, pw);

			//問い合わせ準備
			DatabaseMetaData dm = cn.getMetaData();/**/
			ResultSet tb = dm.getTables(null, null, "予定表", null);/**/

			Statement st = cn.createStatement();

			String info = "SELECT 内容 FROM 予定表 WHERE 年="+syear+" AND 月="+smonth+" AND 日="+sday;

			//問い合わせ
			ResultSet rs3 = st.executeQuery(info);

			//列数の取得
			ResultSetMetaData rm = rs3.getMetaData();
			int cnum = rm.getColumnCount();
			scolname = new ArrayList<String>(cnum);

			//列名の取得
			for(int i=1; i<=cnum; i++){
				scolname.add(rm.getColumnName(i).toString());
			}

			//行の取得
			sdata = new ArrayList<ArrayList>();
			while(rs3.next()){
				ArrayList<String> srowdata = new ArrayList<String>();
				for(int i=1; i<=cnum; i++){
					srowdata.add(rs3.getObject(i).toString());
				}
				sdata.add(srowdata);
			}

			//接続のクローズ
			rs3.close();
			st.close();
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList getsData()
	{
		return sdata;
	}
	public ArrayList getsColname()
	{
		return scolname;
	}

	//明日の予定
	public void select2(){
	   try{
	   //接続の準備
       String url = "jdbc:derby:sineeji2;create=true";
       String usr = "";
       String pw = "";

       //データベースへの接続
       Connection cn = DriverManager.getConnection(url, usr, pw);

     //問い合わせ準備
       DatabaseMetaData dm = cn.getMetaData();/**/
       ResultSet tb = dm.getTables(null, null, "予定表", null);/**/

       Statement st = cn.createStatement();

       String info = "SELECT 内容 FROM 予定表 WHERE 年="+syear+" AND 月="+smonth+" AND 日="+sday;

       //問い合わせ
       ResultSet rs3 = st.executeQuery(info);

  	 	//列数の取得
         ResultSetMetaData rm = rs3.getMetaData();
         int cnum = rm.getColumnCount();
         scolname2 = new ArrayList<String>(cnum);

         //列名の取得
         for(int i=1; i<=cnum; i++){
            scolname2.add(rm.getColumnName(i).toString());
         }

         //行の取得
         sdata2 = new ArrayList<ArrayList>();
         while(rs3.next()){
            ArrayList<String> srowdata = new ArrayList<String>();
            for(int i=1; i<=cnum; i++){
                srowdata.add(rs3.getObject(i).toString());
            }
            sdata2.add(srowdata);
          }

        //接続のクローズ
        rs3.close();
        st.close();
        cn.close();
     }
     catch(Exception e){
        e.printStackTrace();
     }
   }
   public ArrayList getsData2()
   {
      return sdata2;
   }
   public ArrayList getsColname2()
   {
      return scolname2;
   }

   //教員ID照合
   	public void teacher(){
   		try{
   			//接続の準備
   			String url = "jdbc:derby:sineeji2;create=true";
   			String usr = "";
   			String pw = "";

   			//データベースへの接続
   			Connection cn
   				= DriverManager.getConnection(url, usr, pw);

   			//問い合わせの準備
   			DatabaseMetaData dm = cn.getMetaData();
   			ResultSet tb = dm.getTables(null, null, "教員表", null);

   			Statement st = cn.createStatement();

   			String qry1
   				= "CREATE TABLE 教員表(教員番号 varchar(10), 教員名 varchar(30))";
   			String[] qry2 = {
   				"INSERT INTO 教員表 VALUES ('t01', '吉原 隆')",
   				"INSERT INTO 教員表 VALUES ('t02', '西川 聖美')",
   				"INSERT INTO 教員表 VALUES ('t03', '大畑 京子')",
   				"INSERT INTO 教員表 VALUES ('t04', '岩崎 弘')",
   				"INSERT INTO 教員表 VALUES ('t05', '畑 正剛')",
   				"INSERT INTO 教員表 VALUES ('t06', '三輪 幸代')",
   				"INSERT INTO 教員表 VALUES ('t07', '小俣 美穂')",
   				"INSERT INTO 教員表 VALUES ('t08', '小嶋 日出一')",
   				"INSERT INTO 教員表 VALUES ('t09', '長房 利夫')",
   				"INSERT INTO 教員表 VALUES ('t10', '近藤 祥子')",
   				"INSERT INTO 教員表 VALUES ('t11', '青島 修')",
   				"INSERT INTO 教員表 VALUES ('t12', '佐野 遼平')",
   				"INSERT INTO 教員表 VALUES ('t13', '中山 研人')",
   				"INSERT INTO 教員表 VALUES ('t14', '大石 正晴')",
   				"INSERT INTO 教員表 VALUES ('t15', '福世 浩二')",
   				"INSERT INTO 教員表 VALUES ('t16', '美澤 まち子')",
   				"INSERT INTO 教員表 VALUES ('t17', '池田 新之助')",
   				"INSERT INTO 教員表 VALUES ('t18', '植松 弘樹')",
   				"INSERT INTO 教員表 VALUES ('t19', '望月 駿一')",
   				"INSERT INTO 教員表 VALUES ('t20', '増野 真佐美')",
   				"INSERT INTO 教員表 VALUES ('t21', '植田 義人')",
   				"INSERT INTO 教員表 VALUES ('t22', '三好 旭')",
   				"INSERT INTO 教員表 VALUES ('t23', '暮林 健也')",
   				"INSERT INTO 教員表 VALUES ('t24', '椙山 てる子')",
   				"INSERT INTO 教員表 VALUES ('t25', '紅林 亜寿香')",
   				"INSERT INTO 教員表 VALUES ('t26', '寺田 拓也')",
   				"INSERT INTO 教員表 VALUES ('t27', '周防 優子')",
   				"INSERT INTO 教員表 VALUES ('t28', '増田 昭仁')",
   				"INSERT INTO 教員表 VALUES ('t29', '佐野 進')",
   				"INSERT INTO 教員表 VALUES ('t30', '藤田 浩久')",
   				"INSERT INTO 教員表 VALUES ('t31', '河合 憲一')",
   				"INSERT INTO 教員表 VALUES ('t32', '鈴木 かおり')",
   				"INSERT INTO 教員表 VALUES ('t33', '小平 和美')",
   				"INSERT INTO 教員表 VALUES ('t34', '荒波 正和')",
   				"INSERT INTO 教員表 VALUES ('t35', '長田 淳子')",
   				"INSERT INTO 教員表 VALUES ('t36', '鈴木 滋')",
   				"INSERT INTO 教員表 VALUES ('t37', '高信 匡宏')",
   				"INSERT INTO 教員表 VALUES ('t38', '大瀧 美央')",
   				"INSERT INTO 教員表 VALUES ('t39', '滝 陽介')",
   				"INSERT INTO 教員表 VALUES ('t40', '望月 嗣久')",
   				"INSERT INTO 教員表 VALUES ('t41', '豊島 宏')",
   				"INSERT INTO 教員表 VALUES ('t42', '久保田 大二郎')",
   				"INSERT INTO 教員表 VALUES ('t43', '福世 浄恵')",
   				"INSERT INTO 教員表 VALUES ('t44', '望月 絹枝')",
   				"INSERT INTO 教員表 VALUES ('t45', '山口 由佳')",
   				"INSERT INTO 教員表 VALUES ('t46', '本間 麻李江')",
   				"INSERT INTO 教員表 VALUES ('t47', 'イローラ・ロシター')",
   				"INSERT INTO 教員表 VALUES ('t48', '阿井 雄平')",
   				"INSERT INTO 教員表 VALUES ('t49', '久保田 詔子')",
   				"INSERT INTO 教員表 VALUES ('t50', '浜崎 香')",
   				"INSERT INTO 教員表 VALUES ('t51', '川口 知幸')",
   				"INSERT INTO 教員表 VALUES ('t52', '鈴木 明')",
   				"INSERT INTO 教員表 VALUES ('t53', '深澤 拓')",
   				"INSERT INTO 教員表 VALUES ('t54', '西川 徹')",
   				"INSERT INTO 教員表 VALUES ('t55', '小林 勇介')",
   				"INSERT INTO 教員表 VALUES ('t56', '林 武雄')",
   				"INSERT INTO 教員表 VALUES ('t57', '尾崎 弘幸')",
   				"INSERT INTO 教員表 VALUES ('t58', '小澤 一彰')",
   				"INSERT INTO 教員表 VALUES ('t59', '山口 嘉文')",
   				"INSERT INTO 教員表 VALUES ('t60', '原田 勉')",
   				"INSERT INTO 教員表 VALUES ('t61', '久保田 詔子')",
   				"INSERT INTO 教員表 VALUES ('t62', '末永 里桜')",
   				"INSERT INTO 教員表 VALUES ('t63', '山下 寿康')",
   				"INSERT INTO 教員表 VALUES ('t64', '山下 孝弘')",
   				"INSERT INTO 教員表 VALUES ('t65', '石割 亮太')",
   				"INSERT INTO 教員表 VALUES ('t66', '木ノ内 一博')",
   				"INSERT INTO 教員表 VALUES ('t67', '天野 雄大')",
   				"INSERT INTO 教員表 VALUES ('t68', '村松 一')",
   				"INSERT INTO 教員表 VALUES ('t69', '大垣 洋子')",
   				"INSERT INTO 教員表 VALUES ('t70', '北川 京子')",
   				"INSERT INTO 教員表 VALUES ('t71', '櫻井 直美')"
   			};
   			String qry3 = "SELECT * FROM 教員表";
   			if(!tb.next()){
   				st.executeUpdate(qry1);
   				for(int i=0; i<qry2.length; i++){
   					st.executeUpdate(qry2[i]);
   				}
   			}

   			//問い合わせ
   			ResultSet rs = st.executeQuery(qry3);

   			//データベースの取得
   			ResultSetMetaData rm = rs.getMetaData();
   			int cnum = rm.getColumnCount();
   			while(rs.next()){
   				for(int i=1; i<=cnum; i++){
   			//		System.out.print(rm.getColumnName(i) + ":"+
   			//				rs.getObject(i) + "  ");
   				}
   			//	System.out.println("");
   			}

   			//接続のクローズ
   			rs.close();
   			st.close();
   			cn.close();
   		}
   		catch(Exception e){
   			e.printStackTrace();
   		}
   	}


   //データベースを削除
   public void dataDelete(){
	   try{
	         //接続の準備
	         String url = "jdbc:derby:sineeji2;create=true";
	         String usr = "";
	         String pw = "";

	         //データベースへの接続
	         Connection cn = DriverManager.getConnection(url, usr, pw);

	         Statement st = cn.createStatement();

	         String qryDelete = "DELETE FROM 予定表 WHERE 番号="+dNo;
	         String upDate = "UPDATE 予定表 SET 番号=番号-1 WHERE 番号>"+dNo;

	         st.executeUpdate(qryDelete);
	         st.executeUpdate(upDate);

	          //接続のクローズ
	          st.close();
	          cn.close();
	       }
	       catch(Exception e){
	          e.printStackTrace();
	       }
   }

}
