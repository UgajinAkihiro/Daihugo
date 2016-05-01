

//カードが引けない例外クラス
public class NotGetCardException extends Exception{
	
	//コンストラクタ
	public NotGetCardException(){
		super("Not Get Card");
	}
}
