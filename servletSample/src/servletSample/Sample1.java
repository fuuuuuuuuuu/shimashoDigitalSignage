package servletSample;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Sample1
{
public static void main(String[] args)
{
try{
//接続の準備
String url = "jdbc:derby:teacher;create=true";
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
System.out.print(rm.getColumnName(i) + ":"+
rs.getObject(i) + "  ");
}
System.out.println("");
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

}