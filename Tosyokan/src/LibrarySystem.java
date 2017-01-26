import java.util.Calendar;

public class LibrarySystem {


	//フィールド
	BookManager bookManager;
	BorrowerManager borrowerManager;
	LendInformationManager lendInformationManager;
	String filePath_bo = "./shoseki.txt";
	String filePath_l = "./kashidashi.txt";
	String filePath_br = "./riyousya.txt";

	//コンストラクタ
	LibrarySystem(){
		bookManager = new BookManager();
		borrowerManager = new BorrowerManager();
		lendInformationManager = new LendInformationManager();

	}

	public void loadData(){
		bookManager.loadBooks(filePath_bo);
		borrowerManager.loadBorrower(filePath_br);
		lendInformationManager.loadLendInformation(filePath_l,borrowerManager,bookManager);
	}
	public void saveData(){
		bookManager.saveBooks(filePath_bo);
		borrowerManager.saveBorrower(filePath_br);
		lendInformationManager.saveLendInformation(filePath_l);
	}

	//図書の貸し出し。受け取った利用者IDと図書IDを参照し、結果を受け取る。
	public String checkOutBook(int borrowerId, int bookId){
		/*if(borrowerManager.getBorrower(borrowerId) == null){
			return "不正な利用者IDが入力されました。";
		}else if(lendInformationManager.getCountOfBorrowingBooks(borrowerId) > 3){
			return "利用者はすでに3冊の図書を借りています。";
		}else if(bookManager.getBook(bookId) == null){
			return "不正な図書IDが入力されました。";
		}else if(lendInformationManager.isLentBook(bookId) == true){
			return "図書はすでに貸し出し中です。";
		}
		return lendInformationManager.addLendInformation(borrowerManager.getBorrower(borrowerId),bookManager.getBook(bookId));
	}*/
		//ifを並べるパターン
		if(borrowerManager.getBorrower(borrowerId) == null){
			return "不正な利用者IDが入力されました。";
		}
		if(lendInformationManager.getCountOfBorrowingBooks(borrowerId) >= 3){
			return "利用者はすでに3冊の図書を借りています。";
		}
		if(bookManager.getBook(bookId) == null){
			return "不正な図書IDが入力されました。";
		}
		if(lendInformationManager.isLentBook(bookId) == true){
			return "図書はすでに貸し出し中です。";
		}
		return lendInformationManager.addLendInformation(borrowerManager.getBorrower(borrowerId),bookManager.getBook(bookId));
	}


	//図書の返却。受け取った図書IDをBookManagerに渡し、結果を受け取る。
	public String returnBook(int bookId){
		if(bookManager.getBook(bookId) == null){
			return "不正な図書IDが入力されました。";
		}else if(lendInformationManager.getLendInformation(bookId) == null){
			return "図書は貸出されていません。";
		}
		lendInformationManager.removeInformation(lendInformationManager.getLendInformation(bookId));
		return "図書ID" + bookId + "を返却しました。";
	}

	//利用者の登録。受け取った利用者名をBorrwerManagerに渡し、結果を受け取る。
	public String registerBorrower(String borrowerName){
		//System.out.println("LibrarySystem" + borrowerManager.registerBorrower(borrowerName));
		return borrowerManager.registerBorrower(borrowerName);
	}

	//利用者の削除。受け取った利用者IDをBorrowerManagerに渡し、結果を受け取る。
	public String removeBorrower(int borrowerId){
		if(lendInformationManager.getCountOfBorrowingBooks(borrowerId) == 0){
			return borrowerManager.removeBorrower(borrowerId);
		}else{
		return "図書借用中の利用者を削除できません。";
		}
	}

	//利用者一覧
	public String getBorrwerListStr(){
		return borrowerManager.getBorrowerListStr();
	}

	//図書の登録
	public String registerBook(String bookName){
		return bookManager.registerBook(bookName);
	}

	//図書の削除
	public String removeBook(int bookId){
		if(lendInformationManager.isLentBook(bookId) == false){
			return bookManager.removeBook(bookId);
		}else{
		return "貸出中の図書を削除できません。";
		}
	}

	//図書一覧
	public String getBookListStr(){
		return bookManager.getBookListStr();
	}

	//返却日超過者一覧
	public String getOverDateList(Calendar date){
		return lendInformationManager.getOverDateList(date);
	}
	//図書の検索
	public String searchbook(String name){
		return bookManager.searchbook(name);
	}
	//貸出一覧
	public String getList(){
		return lendInformationManager.getList();
	}

	//利用者IDが存在するか
	public boolean isgetID(int num){
		return borrowerManager.isgetID(num);
	}
}
