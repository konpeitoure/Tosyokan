

public class Borrower {

	private String name;
	private int id;
	//newすると新しいインスタンスの変数が保存される。

	Borrower(String name,int id)
	{
		this.id = id;
		this.name = name;
	}

	public int getID()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}
}
