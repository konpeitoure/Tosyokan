
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class LendInformationManager{



	/**
	 *	機能説明：
	 *	@param
	 */

	private ArrayList<LendInformation> LendInformationList;
	private int i = 0;
	private int i_2 = 0;

	//private List<Integer[]> lendInformationList;

		LendInformationManager()
		{
			//フィールドのLendInformationListにArrayListのインスタンスを作成し代入する。
			//ArrayList生成
			 LendInformationList = new ArrayList<LendInformation>();

		}

		public LendInformation getLendInformation(int booksID)
		{
			/*
			 * 本の返却の際
			 *
			 * 1.LendInformationオブジェクトの書籍IDがLendInformationListの引数に一致するまで検索する。
			 * 1‐1.引数に対応するLendInformationオブジェクトが存在しない場合、nullを返す。
			 * 1‐2.引数に対応するLendInformationオブジェクトを返す。
			 *
			 * 配列の中身を取り出す処理をまず書く。
			 * if文で一致を確認する。
			 */
			//要素の参照
			//int count = 0;
			for(int i = 0; i < LendInformationList.size(); i++){
				//LendInformationList.get(i).getid();
				//x = (Integer)LendInformationList.get(i);
				if(LendInformationList.get(i).getBooksID() == booksID){
					return LendInformationList.get(i);
				}
			}
			return null;

			/*
			 * 1.ﾌｨｰﾙﾄﾞのLendinformationListの配列から書籍IDを取りだす。
			 * 2.引数と本が借りられているLendInformationListと照合し、合致するものを探す。
			 * 3.合致した個数を返す。
			 */
		}

		public String addLendInformation(Borrower borrower,Book book)
		{
			/*
			 * 1.返却日情報のReturnDateを付加する。
			 * 2.引数をもとにLendInformationオブジェクトを生成する。
			 * 3.LendInformationListに追加する。
			 * 4.追加したオブジェクトの返却日情報をString型で返す。
			 * "yyyy/mm/dd"   →　　例　　"2011/11/11"
			 */

			Calendar calendar = Calendar.getInstance();

			//calendarに値を入れている、これだと月末にずれる
			//int year = calendar.get(Calendar.YEAR);
			//int month = calendar.get(Calendar.MONTH) + 1;
			//int day = calendar.get(Calendar.DATE) + 5;
			//返却日指定のため、
			calendar.add(Calendar.DAY_OF_MONTH, 5);
			/*
			 * public abstract void add(int field,int amount)
			 *カレンダのルールに基づいて、指定された時間量を指定されたカレンダ・フィールドに加算または減算します。たとえば、カレンダの現在の時間から5日を引く場合は、次の呼出しを実行します。
			 *add(Calendar.DAY_OF_MONTH, -5).
			 *パラメータ:
			 *field - カレンダ・フィールド。
			 *amount - フィールドに追加される日付または時間の量。
			 */
		    //int hour = calendar.get(Calendar.HOUR_OF_DAY);
		    //int minute = calendar.get(Calendar.MINUTE);
		    //int second = calendar.get(Calendar.SECOND);
		    //int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;

		    //int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);

		    //System.out.println("現在の日時は");
		    //System.out.println(year + "年" + month + "月" + day + "日");
		    //Calendar returnDate = year/month/day;

		    LendInformation lendInformation = new LendInformation(calendar,borrower,book);
		    LendInformationList.add(lendInformation);
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		    sdf.format(calendar.getTime());

		    //System.out.println("(" + week_name[week] + ")");
		    //System.out.println(hour + "時" + minute + "分" + second + "秒");

		    //System.out.println("今日は今年の" + day_of_year + "日目です");


			//String returnday = year + "/" + month + "/" + day;
			return sdf.format(calendar.getTime());
		}

		public void removeInformation(LendInformation lendInformation)
		{
			//1.引数で渡されたLendInformationオブジェクトを配列から削除
			LendInformationList.remove(lendInformation);
		}

		public boolean isLentBook(int booksID)
		{
			/*
			 * 1.ﾌｨｰﾙﾄﾞのLendinformationListの配列から書籍IDを取りだす。
			 * 2.引数と本が借りられているLendInformationListと照合し、合致するものを探す。
			 * 2-1.値が存在する場合、trueを返す。
			 * 2-2.存在しない場合、falseを返す。
			 */
			//for(int i = 0; i < LendInformationList.size(); i++){
				//LendInformationList.get(i).getid();
				//x = (Integer)LendInformationList.get(i);
			for(int i = 0; i < LendInformationList.size(); i++){
				if(LendInformationList.get(i).getBooksID() == booksID){
					return true;
				}
			}
			return false;
		}

		public int getCountOfBorrowingBooks(int borrowersID)
		{
			//borrowersID = borrowersID - 1;
			//要素の参照
			int count = 0;
			//int x;
			for(int i = 0; i < LendInformationList.size(); i++){
				//LendInformationList.get(i).getid();
				//x = (Integer)LendInformationList.get(i);
				if(LendInformationList.get(i).getBorrowersID() == borrowersID){
					count++;
				}
			}
				return count;
			/*
			 * 1.ﾌｨｰﾙﾄﾞのLendinformationListの配列から書籍IDを取りだす。
			 * 2.引数と本が借りられているLendInformationListと照合し、合致するものを探す。
			 * 3.合致した個数を返す。
			 */
		}

		public String getOverDateList(Calendar date)
		{
			/*
			 * 1.LendinformationListの配列内の全ての要素の返却日情報と引数の日付情報(date)を比較する。
			 * 2.引数の日付情報が後になる要素の一覧を指定のフォーマットの文字列に編集して返す。
			 * 利用者名　：　図書名　：　返却日
			 * 例) tachibana  : スッキリわかるJava　基本編　 2017/02/01
			 */
			/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			if(LendInformationList.get(i).getReturndate().before(date)){
				String result = "利用者名 : 図書名 : 返却日 \r\n";
				for(int i = 0; i < LendInformationList.size(); i++){
					result = result + LendInformationList.get(i).getBorrowerName() + " : "
					+ LendInformationList.get(i).getBookName() + " : "
					+ sdf.format(LendInformationList.get(i).getReturndate().getTime()) + "\r\n";
				}
				return result;
			}else{
				return "返却日超過貸出はありません。";
				}*/

			String result;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			if(!LendInformationList.isEmpty()){
				result = "利用者名 : 図書名 : 返却日 \r\n";
				for(int i = 0; i < LendInformationList.size(); i++){
					if(LendInformationList.get(i).getReturndate().before(date)){
						//sdf.format(LendInformationList.get(i).getReturndate().getTime());
						result = result + LendInformationList.get(i).getBorrowerName() + " : "
						+ LendInformationList.get(i).getBookName() + " : "
						//+ LendInformationList.get(i).getReturndate() + "\r\n";
						+ sdf.format(LendInformationList.get(i).getReturndate().getTime()) + "\r\n";
						//return "利用者名 : 図書名 : 返却日 : \r\n";
					}else{
						result = "返却日超過貸出はありません。\r\n";
					}
				}
			}else{
				result = "返却日超過貸出はありません。\r\n";
			}
			return result;
		}

		public String getList(String name)
		{
			/*
				特定の人物が借りている本を表示する。
			 */
			String result;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			if(!LendInformationList.isEmpty()){
				result = "利用者名 : 図書名 : 返却日 \r\n";
				for(int i = 0; i < LendInformationList.size(); i++){
					if(LendInformationList.get(i).getBorrowerName().equals(name)){
						result = result + LendInformationList.get(i).getBorrowerName() + " : "
						+ LendInformationList.get(i).getBookName() + " : "
						+ sdf.format(LendInformationList.get(i).getReturndate().getTime()) + "\r\n";
					}
				}
			}else{
				result = "貸出図書はありません。\r\n";
			}
			return result;
		}

		public String getList()
		{
			/*
			 * 貸し出した本を確認する
			 */

			String result;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			if(!LendInformationList.isEmpty()){
				result = "利用者名 : 図書名 : 返却日 \r\n";
				for(int i = 0; i < LendInformationList.size(); i++){
						result = result + LendInformationList.get(i).getBorrowerName() + " : "
						+ LendInformationList.get(i).getBookName() + " : "
						+ sdf.format(LendInformationList.get(i).getReturndate().getTime()) + "\r\n";
				}
			}else{
				result = "貸出図書はありません。\r\n";
			}
			return result;
		}

		public boolean loadLendInformation(String filepath,BorrowerManager borrowerManager,BookManager bookManager )
		{
	        try
	        {
				// ファイルを読み込みモードでオープンする。ファイルが存在しなかったりする場合に FileNotFoundException がスローされる。
	            FileReader fr = new FileReader(filepath);

				// ファイルを読むための便利なクラス BufferedReader のオブジェクトを作る。
	            BufferedReader br = new BufferedReader( fr );

				// 1行目を読んで変数 str に代入する。もし、空のファイルなら、str には null がセットされる。
				String line = br.readLine();

				//bookList.add(book);
	            while( line != null )
	            {
	    			String[] Line = line.split(",",0);
	    			//i = Integer.parseInt(Line[0]);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date d = dateFormat.parse(Line[0]);
                    Calendar date = Calendar.getInstance();
                    date.setTime(d);
                    //BorrowerManager borrower = new BorrowerManager();
                    i = Integer.parseInt(Line[1]);
                    //BookManager book = new BookManager();
                    i_2 = Integer.parseInt(Line[2]);

	    			LendInformation lendInformation =
	    					new LendInformation(date,borrowerManager.getBorrower(i),bookManager.getBook(i_2));
	    			//LendInformation(Calendar returnDate,Borrower borrower,Book book)
	    			//Borrower borrower = new Borrower(Line[1],i);
					// ArrayList に追加する。
	    			LendInformationList.add(lendInformation);

					// 次の行を読む。
	                line = br.readLine();
	            }

				// ストリームを閉じて、BufferedReader のリソースを開放する。
				// このとき、同時にFileReader のcloseも行われるので、fr.close() は必要ない。なので、ファイルもここで閉じられます。
	            br.close();
	        }
			catch( FileNotFoundException e )
			{
				// エラーが発生するとここに来る。
	            System.out.println( e );
			}
	        catch( Exception e )
	        {
				// エラーが発生するとここに来る。
	            System.out.println( e );
	        }
	        /*finally
	        {
				// 例外が発生したときでもファイルを閉じて解放する。ここでも例外がスローされる可能性があるので、例外処理をする。
	        	try
	        	{
	                if( br != null )
	            		br.close();
	            }
	            catch( IOException e )
	            {
		            System.out.println(e);
	            }
	        }*/
			return true;
		}

		public boolean saveLendInformation(String filepath)
		//getTime()でdate型に変換している
		{
			try{
				  File file = new File(filepath);
				  FileWriter filewriter = new FileWriter(file);
				  String result = "";
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

				  for(int i = 0; i < LendInformationList.size(); i++){
					//result = result + LendInformationList.get(i).getReturndate() + ","
					  result = result + sdf.format(LendInformationList.get(i).getReturndate().getTime()) + ","
					+ LendInformationList.get(i).getBorrowersID() + ","
					+ LendInformationList.get(i).getBooksID() + "\r\n";
				  }
				  //filewriter.write("こんにちは");
				  filewriter.write(result);

				  filewriter.close();
				}catch(IOException e){
				  System.out.println(e);
				}
			return true;
		}

}
