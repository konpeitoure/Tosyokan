import java.util.Calendar;

public class LendInformation{



	/**
	 *	機能説明：
	 *	@param args[] mainメソッド生成のためにのみ必要
	 */

	private Calendar returnDate;
	private Borrower borrower;
	private Book book;

		LendInformation(Calendar returnDate,Borrower borrower,Book book)
		{
			//1.引数を受け取って、フィールドに格納する。
			this.returnDate = returnDate;
			this.borrower = borrower;
			this.book = book;
		}

		public int destory()
		{
			int a = 0;
			return a;
		}

		public String getBookName()
		{
			//1.フィールドのBookオブジェクトのgetNameメソッドを呼び出して、結果を返す。
		//	Book boo = new Book();
			//boo.getName();
			//String a = "";
			return book.getName();
		}

		public String getBorrowerName()
		{
			//1.フィールドのBorrowerオブジェクトのgetNameメソッドを呼び出して、結果を返す。
			//Borrower bor = new Borrower();
			//String a = "";
			return borrower.getName();
		}

		public int getBooksID()
		{
			//1.フィールドのBookオブジェクトのgetIDメソッドを呼び出して、結果を返す。
			//Book boo = new Book();
			//boo.getID();
			//int a = 0;
			//return a;
			return book.getID();
		}

		public int getBorrowersID()
		{
			//1.フィールドのBorrowerオブジェクトのgetIDメソッドを呼び出して、結果を返す。
			//int a = 0;
			//Borrower bor = new Borrower();
			return borrower.getID();
		}
		//追加仕様
		public Calendar getReturndate()
		{
			return returnDate;
		}

}
