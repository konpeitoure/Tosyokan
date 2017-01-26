import java.io.IOException;
import java.text.ParseException;

public class LibrarySystemMain {
	public static void main(String[] args) throws IOException, ParseException{

		//ユーザーから入力を受け取る
		 //InputStreamReader n = new InputStreamReader(System.in);
	     //BufferedReader br = new BufferedReader(n);

	     //入力値の判定
	     	//System.out.print(">");
	        //String str = br.readLine();
	        //if(str.equals("LibrarySystem")){
	        	//インスタンス生成
				LibrarySystem librarySystem = new LibrarySystem();
	    		UserInterface UI = new UserInterface(librarySystem);
	    		UI.start();
	        //}else {
	        //	System.out.println("正しいワードを入力してください");
	     //}
	}
}
