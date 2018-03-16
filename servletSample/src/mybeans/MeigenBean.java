package mybeans;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class MeigenBean implements Serializable
{
   private ArrayList<String> mcolname;
   private ArrayList<ArrayList> mdata;

   public MeigenBean()
   {
	   try{
		 //接続の準備
		 String url = "jdbc:derby:meigen;create=true";
		 String usr = "";
		 String pw = "";

		 //データベースへの接続
		 Connection cn
		 = DriverManager.getConnection(url, usr, pw);

		 //問い合わせの準備
		 DatabaseMetaData dm = cn.getMetaData();
		 ResultSet tb = dm.getTables(null, null, "名言表", null);

		 Statement st = cn.createStatement();

		 String qry1
		 = "CREATE TABLE 名言表(番号 int, 名言 varchar(250))";
		 String[] qry2 = {
		 "INSERT INTO 名言表 VALUES (1, '必死に生きてこそ、その生涯は光を放つ（織田信長）')",
		 "INSERT INTO 名言表 VALUES (2, '幸福とは結果ではなく、自分が納得のいく生き方をしている「状態」なのである。（ジョンキム）')",
		 "INSERT INTO 名言表 VALUES (3, '１００回たたくと壊れる壁があったとする。でもみんな何回たたけば壊れるかわからないから、９９回まで来ていても途中であきらめてしまう。（松岡修造）')",
		 "INSERT INTO 名言表 VALUES (4, '人生における大きな喜びは、「君にはできない」と世間が言うことをやってのけることである。（ウォルター・バジョット）')",
		 "INSERT INTO 名言表 VALUES (5, '苦しいから逃げるのではない。逃げるから苦しくなるのだ。（ウィリアム・ジェームズ）')",
		 "INSERT INTO 名言表 VALUES (6, 'やってみて「ダメだ」とわかったことと、はじめから「ダメだ」と言われたことは、違います。（イチロー）')",
		 "INSERT INTO 名言表 VALUES (7, '挫折にしろ、無念さにしろ自分の能力の低さにしろ、自分というものに出会ってから人生は始まる。（武田　鉄矢）')",
		 "INSERT INTO 名言表 VALUES (8, '失敗？これはうまくいかないということを確認した成功だよ。（トーマス・エジソン）')",
		 "INSERT INTO 名言表 VALUES (9, 'お前がいつか出会う災いは、お前がおろそかにしたある時間の報いだ。（ナポレオン）')",
		 "INSERT INTO 名言表 VALUES (10, 'キャリアではない。私の人生なんだ。（スティーブ・ジョブズ）')",
		 "INSERT INTO 名言表 VALUES (11, 'つまづいたっていいじゃないか、だってにんげんだもの（相田　みつを）')",
		 "INSERT INTO 名言表 VALUES (12, '「努力」より先に「成功」が先に出るのは辞書の中だけ（製作者不明）')",
		 "INSERT INTO 名言表 VALUES (13, 'うつくしいものを美しいと思えるあなたのこころがうつくしい（相田　みつを）')",
		 "INSERT INTO 名言表 VALUES (14, '苦情処理係に関する苦情は、どこに持っていけばいいんだろう。（レポナルド・フェクトナー）')",
		 "INSERT INTO 名言表 VALUES (15, 'たとえ太陽系と天体のすべてが壊れたとしても、君が死ぬのは１度きりだ（トーマス・カーライル）')",
		 "INSERT INTO 名言表 VALUES (16, '人の信頼を得るには２０年かかる。だが、その信頼はたった５分で崩れることがある。（ウォーレン・バフェット）')",
		 "INSERT INTO 名言表 VALUES (17, '人は自分のした失敗から学ぶ。成功から学ぶことはほとんどない。（ハロルド・ジニーン）')",
		 "INSERT INTO 名言表 VALUES (18, 'あなたのこれからの人生の中で、今日が一番若い日。（製作者不明）')",
		 "INSERT INTO 名言表 VALUES (19, '失敗とはつまづくことではない。いつまでもつまづいたままでいる事だ。（製作者不明）')",
		 "INSERT INTO 名言表 VALUES (20, '変わることにはリスクが伴う、しかし、変わらなければもっと多くのリスクが伴う。（ジョン・ヤング）')",
		 "INSERT INTO 名言表 VALUES (21, '人間、志を立てるのに遅すぎるということはない。（スタンリー・ボールドウィン）')",
		 "INSERT INTO 名言表 VALUES (22, 'どんなばかげた考えでも、行動を起こさないと世界は変わらない。（マイケル・ムーア）')",
		 "INSERT INTO 名言表 VALUES (23, '必ずできると信念を持ったならば必ずできる。（松下　幸之助）')",
		 "INSERT INTO 名言表 VALUES (24, '選手生活を通して俺は9000ショット外した。300試合負けた。26回は俺に仲間が託した勝負ショットを外した。俺は失敗して失敗して失敗し続けてきた。それが俺が成功した理由。（マイケル・ジョーダン）')",
		 "INSERT INTO 名言表 VALUES (25, '努力だけでは、どうにもならないかもしれん。しかし、努力をしなければ、確実にこのまま（ハチミツとクローバー）')",
		 "INSERT INTO 名言表 VALUES (26, '未来はどう『なる』ではなく、どう『する』で考えるべき。（小飼弾）')",
		 "INSERT INTO 名言表 VALUES (27, '君には二つの生き方がある。奇跡など起こらない、と信じて生きるか、すべてが奇跡だ！と信じて生きるかだ。（アルベルト・アインシュタイン）')",
		 "INSERT INTO 名言表 VALUES (28, '三流は人の話を聞かない。二流は人の話を聞く。一流は人の話を聞いて実行する。超一流は人の話を聞いて工夫する。（羽生善治）')",
		 "INSERT INTO 名言表 VALUES (29, '人は繰り返すことで何かになる。つまり、すばらしいのは、行いではなく習慣だ。（アリストテレス）')",
		 "INSERT INTO 名言表 VALUES (30, '他人の意見で、自分の本当の心の声を消してはならない。自分の直感を信じる勇気を持ちなさい。（スティーブ・ジョブズ）')",
		 "INSERT INTO 名言表 VALUES (31, '行為する者にとって、行為せざる者は最も過酷な批判者である。（福沢　諭吉）')",
		 "INSERT INTO 名言表 VALUES (32, '険しい丘を登るためには、最初にゆっくり歩くことが必要である。（シェイクスピア）')",
		 "INSERT INTO 名言表 VALUES (33, 'あなたの心が正しいと思うことをしなさい。どっちにしたって批判されるのだから。（エレノア・ルーズベルト）')",
		 "INSERT INTO 名言表 VALUES (34, '学生時代に不勉強だった人は、社会に出てからも、かならずむごいエゴイストだ。（太宰治）')",
		 "INSERT INTO 名言表 VALUES (35, '三千年の歴史から学ぶことを知らぬ者は、知ることもなく、闇の中にいよ、その日その日を生きることも。（ヨハン・ヴォルフガング・フォン・ゲーテ）')",
		 "INSERT INTO 名言表 VALUES (36, '前向きにもがき苦しむ経験は、すぐに結果につながらなくても、必ず自分の生きる力になっていく。（落合　博満）')",
		 "INSERT INTO 名言表 VALUES (37, '神様は私たちに、成功してほしいなんて思っていません。ただ、挑戦することを望んでいるだけよ。（マザー・テレサ）')",
		 "INSERT INTO 名言表 VALUES (38, '明日死ぬと思って生きろ。永久に生きると思って学べ。（マハトマ・ガンジー）')",
		 "INSERT INTO 名言表 VALUES (39, 'だれにだってあるんだよ  ひとにはいえないくるしみが  だれにだってあるんだよ  ひとにはいえないかなしみが  ただだまっているだけなんだよ  いえば   ぐちになるから(みつを)')",
		 "INSERT INTO 名言表 VALUES (40, 'ぐちをこぼしたっていいがな  弱音を吐いたっていいがな  人間だもの  たまには涙をみせたっていいがな  生きているんだもの（みつを）')",
		 "INSERT INTO 名言表 VALUES (41, '毎日毎日の足跡がおのずから人生の答えを出す　きれいな足跡にはきれいな水がたまる（みつを）')",
		 "INSERT INTO 名言表 VALUES (42, '美しいものを美しいと思える　あなたの心が美しい（みつを）')",
		 "INSERT INTO 名言表 VALUES (43, 'うそはいわない　人にこびない　人のかげぐちはいわぬ わたしにできぬことばかり（みつを）')",
		 "INSERT INTO 名言表 VALUES (44, 'やりなおしが　きかねんだなぁ　人生というものは（みつを）')",
		 "INSERT INTO 名言表 VALUES (45, 'しあわせはいつもじぶんのこころがきめる（みつを）')",
		 "INSERT INTO 名言表 VALUES (46, 'つまづいたっていいじゃないか　にんげんだもの（みつを）')",
		 "INSERT INTO 名言表 VALUES (47, 'ほんとうのことがいちばんいい（みつを）')",
		 "INSERT INTO 名言表 VALUES (48, '七転八倒　つまづいたりころんだりするほうが自然なんだな　にんげんだもの（みつを）')",
		 "INSERT INTO 名言表 VALUES (49, '「できるか？」と聞かれたらいつでも「もちろん」と返事をすることだ。それから懸命にやり方を見つければよい（ルーズベルト）')",
		 "INSERT INTO 名言表 VALUES (50, '失敗とは、よりよい方法で再挑戦するいい機会である（ヘンリー・フォード）')",
		 "INSERT INTO 名言表 VALUES (51, '物事を考える人間は大勢いるが、行動を起こすのはたった一人だ（シャルル・ド・ゴール）')",
		 "INSERT INTO 名言表 VALUES (52, 'たまには踏みならされた道を避けて、森の中に入りこむのがいい。今まで見たこともないものを発見できるに違いないからだ。（グラハム・ベル）')",
		 "INSERT INTO 名言表 VALUES (53, '自分自身を信じてみるだけでいい　きっと、生きる道が見えてくる（ゲーテ）')",
		 "INSERT INTO 名言表 VALUES (54, '過去ばかり振り向いていたのではダメだ　自分がこれまで何をして　これまでに誰だったのかを受け止めた上で　それを捨てればいい（スティブ・ジョブス）')",
		 "INSERT INTO 名言表 VALUES (55, '人間はまじめに生きている限り、必ず不幸や苦しみが降りかかってくるものである。しかし、それを自分の運命として受け止め、辛抱強く我慢し、さらに積極的に力強くその運命と戦えば、いつかは必ず勝利するものである。（ベートーヴェン）')",
		 "INSERT INTO 名言表 VALUES (56, '明日死ぬかのように生きよ　永遠に生きるかのように学べ（ガンジー）')",
		 "INSERT INTO 名言表 VALUES (57, '人生は道路のようなものだ。一番の近道は、たいてい一番悪い道だ。（フランシスコ・ベーコン）')",
		 "INSERT INTO 名言表 VALUES (58, '失敗すればやり直せばいい。やり直してダメなら、もう一度工夫し、もう一度やり直せばいい。（松下幸之助）')",
		 "INSERT INTO 名言表 VALUES (59, '人生とは、その時々に自然に変化し、移りゆくものだ。変化に抵抗してはならない。それは悲しみを招くだけである。（老子）')",
		 "INSERT INTO 名言表 VALUES (60, '焦ることは何の役にも立たない。後悔はなおさら役に立たない。焦りは過ちを増し、後悔は新しい後悔を作る。（ゲーテ）')",
		 "INSERT INTO 名言表 VALUES (61, '成功できる人っていうのは、「思い通りに行かない事が起きるのはあたりまえ」という前提を持って挑戦している。（トーマス・エジソン）')",
		 "INSERT INTO 名言表 VALUES (62, '速度を上げるばかりが人生ではない。（ガンジー）')",
		 "INSERT INTO 名言表 VALUES (63, '人生とは自分を見つけることではない。人生とは自分を創ることである。（バーナード・ショー）')",
		 "INSERT INTO 名言表 VALUES (64, '人生とは自転車のようなものだ。倒れないようにするには、走り続けなければならない。（アインシュタイン）')",
		 "INSERT INTO 名言表 VALUES (65, '幸せかどうかは、自分次第である。（アリストテレス）')",
		 "INSERT INTO 名言表 VALUES (66, 'コミュニケーションで最も大事なことは、言葉にされないことに耳を傾けることだ。（ピーター・ドラッカー）')",
		 "INSERT INTO 名言表 VALUES (67, '愛とは、大きな愛情をもって小さなことをすることです。（マザー・テレサ）')",
		 "INSERT INTO 名言表 VALUES (68, '神様は私たちに、成功してほしいなんて思っていません。ただ、挑戦することを望んでいるだけよ。(マザー・テレサ)')",
		 "INSERT INTO 名言表 VALUES (69, '何より大事なのは、人生を楽しむこと。幸せを感じること、それだけです。(オードリー・ヘップバーン)')",
		 "INSERT INTO 名言表 VALUES (70, 'ステップ・バイ・ステップ。どんなことでも、何かを達成する場合にとるべき方法はただひとつ、一歩ずつ着実に立ち向かうことだ。これ以外に方法はない。(マイケル・ジョーダン)')",
		 "INSERT INTO 名言表 VALUES (71, '自分で自分をあきらめなければ、人生に「負け」はない。(斎藤茂太)')",
		 "INSERT INTO 名言表 VALUES (72, '「できること」が増えるより、「楽しめること」が増えるのが、いい人生。（斎藤茂太）')",
		 "INSERT INTO 名言表 VALUES (73, 'あきらめないことだ。一度あきらめると習慣になる。（斎藤茂太）')"
		 };
		 String qry3 = "SELECT * FROM 名言表";

		 if(!tb.next()){
		 st.executeUpdate(qry1);
		 for(int i=0; i<qry2.length; i++){
		 st.executeUpdate(qry2[i]);
		 }
		 }

		 //問い合わせ
		 ResultSet rs = st.executeQuery(qry3);

			//列数の取得
			ResultSetMetaData rm = rs.getMetaData();
			int cnum = rm.getColumnCount();
			mcolname = new ArrayList<String>(cnum);

			//列名の取得
			for(int i=1; i<=cnum; i++){
				mcolname.add(rm.getColumnName(i).toString());
			}

			//行の取得
			mdata = new ArrayList<ArrayList>();
			while(rs.next()){
				ArrayList<String> rowdata = new ArrayList<String>();
				for(int i=1; i<=cnum; i++){
					rowdata.add(rs.getObject(i).toString());
				}
				mdata.add(rowdata);
			}

			//接続クローズ
			rs.close();
			st.close();
			cn.close();

	       }
	       catch(Exception e){
	          e.printStackTrace();
	       }
   }
 //データベース情報（列・行）を返すメソッド
 	public ArrayList getmData()
 	{
 		return mdata;
 	}
 	public ArrayList getmColname()
 	{
 		return mcolname;
 	}
}
