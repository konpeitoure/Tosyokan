import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class UserInterface {

	//フィールド
	LibrarySystem LS;

	//コンストラクタ
	public UserInterface(LibrarySystem librarySystem){
		this.LS = librarySystem;

	}

	//選択項目の表示、受け取った結果の出力
	public void start() throws IOException, ParseException{

		//キーボード入力の準備
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = 0;
		int bookId = 0;
		int borrowerId = 0;
		String bookName = "";
		String borrowerName = "";
		String str = "";
		//データの読み込み
		LS.loadData();

		while(true){
			//項目の表示
			System.out.println("実行する操作を選択してください");
			System.out.println("1:図書の貸出");
			System.out.println("2:図書の返却");
			System.out.println("3:利用者の登録");
			System.out.println("4:利用者の削除");
			System.out.println("5:利用者一覧");
			System.out.println("6:図書の登録");
			System.out.println("7:図書の削除");
			System.out.println("8:図書一覧");
			System.out.println("9:返却日超過者一覧");
			System.out.println("0:終了");

		    try{
		    	System.out.print(">");
	    		num = Integer.parseInt(br.readLine());
		    	//1~0の条件分岐
		    	if(num == 1){
		    		//図書の貸出
		    		String s = "";
		    		while(!s.equals("y")){
			    		System.out.print("利用者ID>");
			    		num = Integer.parseInt(br.readLine());
			    		borrowerId = num;
			    		System.out.print("図書ID>");
			    		num = Integer.parseInt(br.readLine());
			    		bookId = num;
			    		System.out.println(LS.checkOutBook(borrowerId,bookId));
			    		System.out.print("終了する場合は'y'を押してください。>");
			    		s = br.readLine();
		    		}
		    	}else if(num ==2){
		    		//図書の返却
		    		String s = "";
		    		while(!s.equals("y")){
			    		System.out.print("図書ID>");
			    		num = Integer.parseInt(br.readLine());
			    		bookId = num;
			    		System.out.println(LS.returnBook(bookId));
			    		System.out.print("終了する場合は'y'を押してください。>");
			    		s = br.readLine();
		    		}
		    	}else if(num == 3){
		    		//利用者登録
		    		String s = "";
		    		while(!s.equals("y")){
			    		System.out.print("利用者名>");
			    		str = br.readLine();
			    		borrowerName = str;
			    		System.out.println(LS.registerBorrower(borrowerName));
			    		System.out.print("終了する場合は'y'を押してください。>");
			    		s = br.readLine();
		    		}
		    	}else if(num == 4){
		    		//利用者削除
		    		String s = "";
		    		while(!s.equals("y")){
			    		System.out.print("利用者ID>");
			    		num = Integer.parseInt(br.readLine());
			    		borrowerId = num;
			    		//LS.removeBorrower(borrowerId);
			    		System.out.println(LS.removeBorrower(borrowerId));
			    		//message = LS.removeBorrower(borrowerId);
			    		System.out.print("終了する場合は'y'を押してください。>");
			    		s = br.readLine();
		    		}
		    	}else if(num == 5){
		    		//利用者一覧
		    			System.out.println(LS.getBorrwerListStr());
		    	}else if(num == 6){
		    		//図書登録
		    		String s = "";
		    		while(!s.equals("y")){
			    		System.out.print("図書名>");
			    		str = br.readLine();
			    		bookName = str;
			    		System.out.println(LS.registerBook(bookName));
			    		System.out.print("終了する場合は'y'を押してください。>");
			    		s = br.readLine();
		    		}
		    	}else if(num == 7){
		    		//図書削除
		    		String s = "";
		    		while(!s.equals("y")){
			    		System.out.print("図書ID>");
			    		num = Integer.parseInt(br.readLine());
			    		bookId = num;
			    		System.out.println(LS.removeBook(bookId));
			    		System.out.print("終了する場合は'y'を押してください。>");
			    		s = br.readLine();
		    		}
		    	}else if(num == 8){
		    		//図書一覧
		    		System.out.println(LS.getBookListStr());
		    	}else if(num == 9){
                        System.out.print("yyyy/MM/dd>");
                        str = br.readLine();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                        Date d = dateFormat.parse(str);
                        Date d_2 = dateFormat.parse("9999/12/31");
                        if(d.compareTo(d_2) > 0){
                        	System.out.println("フォーマットが違います。");
                        }else{
                        Calendar date = Calendar.getInstance();
                        date.setTime(d);
                        System.out.println(LS.getOverDateList(date));
                        }
		    	}else if(num == 10){
		    		String s = "";
		    		while(!s.equals("y")){
		    		//名前から図書IDの検索
                    System.out.print("本の名前を入れてください>");
                    str = br.readLine();
                    System.out.println(LS.searchbook(str));
		    		System.out.print("終了する場合は'y'を押してください。>");
		    		s = br.readLine();
		    		}
		    	}else if(num == 11){
		    		//貸出図書一覧を表示
		    		System.out.println(LS.getList());
		    	}else if(num == 0){
		    		LS.saveData();
		    		break;
		    	}else{
		    		System.out.println("指定された番号に対応する操作が存在しません。");
		    	}
		    }catch(NumberFormatException e){
		    	System.out.println("正しい数値を入力してください。");
		    }catch(ParseException  e){
		    	System.out.println("正しい数値を入力してください。_2");
		    }catch(Exception e){
		    	System.out.println(e);
		    }
		}
	}
}
