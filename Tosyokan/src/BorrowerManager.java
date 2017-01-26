import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BorrowerManager {

	private int nextBorrowerid = 1;
	private ArrayList<Borrower> borrowerList;
	int i = 0;

	BorrowerManager()
	{
		borrowerList = new ArrayList<Borrower>();
		//Borrower bor  = new Borrower();
	}

	public String getBorrowerListStr()
	{

		//int number = 1;
		if(!borrowerList.isEmpty()){
			String result = "利用者ID : 利用者名 \r\n";
			for(int i = 0; i < borrowerList.size(); i++){
				result = result + borrowerList.get(i).getID() + "  " + borrowerList.get(i).getName() + "\r\n";
			}
			return result;
		}else{
			return "利用者は登録されていません。";
			}
	}

	public Borrower getBorrower(int borrowerid)
	{
		//int n = borrowerList.indexOf(borrowerid);
		//borrowerList.get(borrowerid).getID();
		//borrowerid = borrowerid - 1;
		//System.out.println(n);
		//return borrowerList.get(n).getID();
		for(int i = 0; i < borrowerList.size(); i++){
			//LendInformationList.get(i).getid();
			//x = (Integer)LendInformationList.get(i);
			if(borrowerList.get(i).getID() == borrowerid){
				return borrowerList.get(i);
			}
		}return null;
	}

	public String registerBorrower(String borrowerName)
	{
		//例外処理
		//渡された利用者名0と21
		if(borrowerName.length() == 0){
			return "利用者名が入力されていません。";
		}else if(borrowerName.length() >= 21){
			return "利用者名の長さが最大値を超えています。";
		}
		//
		Borrower borrower = new Borrower(borrowerName,nextBorrowerid);
		//ArrayList<Borrower> borrowerList = new Borrower(borrowerName,nextBorrowerid);
		borrowerList.add(borrower);

		//↓で持ってくる
		//list.get(1).getid();

		//どうやって1をいれるか、nextborroweridに保存
		//プラスして呼び出し

		//System.out.println("付与された利用者ID-->" + (nextBorrowerid - 1));
		String s = "付与された利用者ID-->" + nextBorrowerid;
		nextBorrowerid++;
		//return "付与された利用者ID-->" + (nextBorrowerid - 1);
		return s;




	}

	public String removeBorrower(int borrowerId)
	{
		if(getBorrower(borrowerId) == null){
			return "不正な利用者IDが入力されました。";
		}else{
			borrowerList.remove(getBorrower(borrowerId));
			return "利用者ID" + borrowerId + "を削除しました。";
		}
	}

	public boolean loadBorrower(String filePath)
	{
        try
        {
			// ファイルを読み込みモードでオープンする。ファイルが存在しなかったりする場合に FileNotFoundException がスローされる。
            FileReader fr = new FileReader(filePath);

			// ファイルを読むための便利なクラス BufferedReader のオブジェクトを作る。
            BufferedReader br = new BufferedReader( fr );

			// 1行目を読んで変数 str に代入する。もし、空のファイルなら、str には null がセットされる。
			String line = br.readLine();

			//bookList.add(book);
            while( line != null )
            {
    			String[] Line = line.split(",",0);
    			i = Integer.parseInt(Line[0]);
    			Borrower borrower = new Borrower(Line[1],i);
				// ArrayList に追加する。
    			borrowerList.add(borrower);

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
        catch( IOException e )
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
        this.nextBorrowerid = i + 1;
		return true;
	}

	public boolean saveBorrower(String filePath)
	{
		try{
			  File file = new File(filePath);
			  FileWriter filewriter = new FileWriter(file);
			  String result = "";
			  for(int i = 0; i < borrowerList.size(); i++){
				result = result + borrowerList.get(i).getID() + "," + borrowerList.get(i).getName() + "\r\n";
			  }
			  //filewriter.write("こんにちは");
			  filewriter.write(result);

			  filewriter.close();
			}catch(IOException e){
			  System.out.println(e);
			}
		return true;
	}

	public boolean isgetID(int num)
	{

		//int number = 1;
		if(!borrowerList.isEmpty()){
			//String result = "利用者ID : 利用者名 \r\n";
			for(int i = 0; i < borrowerList.size(); i++){
				if(borrowerList.get(i).getID() == num){
					return true;
				}
			}
		}
		return false;
	}
}
