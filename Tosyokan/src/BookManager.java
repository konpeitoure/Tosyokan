import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BookManager {

	// ファイルを変更
	private int nextBookid = 1;
	private ArrayList<Book> bookList;
	int i = 0;

	BookManager() {
		bookList = new ArrayList<Book>();
	}

	public String getBookListStr() {
		if (!bookList.isEmpty()) {
			String result = "図書ID : 図書名 \r\n";
			for (int i = 0; i < bookList.size(); i++) {
				result = result + bookList.get(i).getID() + "  " + bookList.get(i).getName() + "\r\n";
			}
			return result;
		} else {
			return "図書は登録されていません。";
		}
	}

	public Book getBook(int bookid) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getID() == bookid) {
				return bookList.get(i);
			}
		}
		return null;
	}

	public String registerBook(String bookName) {
		// 例外処理
		// 渡された利用者名0と41
		if (bookName.length() == 0) {
			return "図書名が入力されていません。";
		} else if (bookName.length() >= 41) {
			return "図書名の長さが最大値を超えています。";
		}
		Book book = new Book(bookName, nextBookid);
		bookList.add(book);

		// ↓で持ってくる
		// list.get(1).getid();

		// どうやって1をいれるか、nextborroweridに保存
		// プラスして呼び出し

		// System.out.println("付与された利用者ID-->" + (nextBorrowerid - 1));
		String s = "付与された図書ID-->" + nextBookid;
		nextBookid++;
		return s;

	}

	public String removeBook(int bookId) {
		if (getBook(bookId) == null) {
			return "不正な図書IDが入力されました。";
		} else {
			bookList.remove(getBook(bookId));
			return "図書ID" + bookId + "を削除しました。";
		}
	}

	public boolean loadBooks(String filePath) {
		/*
		 * try{ File file = new File(filePath); FileReader filereader = new
		 * FileReader(file); int ch;
		 *
		 * while((ch = filereader.read()) != -1){ System.out.print((char)ch); }
		 *
		 * filereader.close(); }catch(FileNotFoundException e){
		 * System.out.println(e); }catch(IOException e){ System.out.println(e);
		 * }
		 */
		// 例外処理の始まり
		try {
			// ファイルを読み込みモードでオープンする。ファイルが存在しなかったりする場合に FileNotFoundException
			// がスローされる。
			FileReader fr = new FileReader(filePath);

			// ファイルを読むための便利なクラス BufferedReader のオブジェクトを作る。
			BufferedReader br = new BufferedReader(fr);

			// 1行目を読んで変数 str に代入する。もし、空のファイルなら、str には null がセットされる。
			String line = br.readLine();

			// bookList.add(book);
			while (line != null) {
				String[] Line = line.split(",", 0);
				i = Integer.parseInt(Line[0]);
				Book book = new Book(Line[1], i);
				// ArrayList に追加する。
				bookList.add(book);

				// 次の行を読む。
				line = br.readLine();
			}

			// ストリームを閉じて、BufferedReader のリソースを開放する。
			// このとき、同時にFileReader のcloseも行われるので、fr.close()
			// は必要ない。なので、ファイルもここで閉じられます。
			br.close();
		} catch (FileNotFoundException e) {
			// エラーが発生するとここに来る。
			System.out.println(e);
		} catch (IOException e) {
			// エラーが発生するとここに来る。
			System.out.println(e);
		}
		/*
		 * finally { // 例外が発生したときでもファイルを閉じて解放する。ここでも例外がスローされる可能性があるので、例外処理をする。
		 * try { if( br != null ) br.close(); } catch( IOException e ) {
		 * System.out.println(e); } }
		 */
		this.nextBookid = i + 1;
		return true;
	}

	public boolean saveBooks(String filePath) {
		try {
			File file = new File(filePath);
			FileWriter filewriter = new FileWriter(file);
			String result = "";
			for (int i = 0; i < bookList.size(); i++) {
				result = result + bookList.get(i).getID() + "," + bookList.get(i).getName() + "\r\n";
			}
			// filewriter.write("こんにちは");
			filewriter.write(result);

			filewriter.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return true;
	}

	public String searchbook(String name)
	{
	    for (int i = 0; i < bookList.size(); i++){
	    	if(bookList.get(i).getName().equals(name)){
		        return "書籍IDは" + bookList.get(i).getID() + "です。";
	    	}
	    }
	    	return "その書籍は登録がありません。";
	}
}

