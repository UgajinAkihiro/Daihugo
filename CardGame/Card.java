

//カード情報
public class Card{
	
	//フィールド
	private String mark;		//カードのマーク
	private int value;			//カードの数値
	
	//コンストラクタ
	public Card(){}
	public Card(String mark,int value){
		this.mark = mark;
		this.value = value;
	}
	
	//アクセッサ
	public String getMark(){
		return this.mark;
	}
	public void setMark(String mark){
		this.mark = mark;
	}
	public int getValue(){
		return this.value;
	}
	public void setValue(int value){
		this.value = value;
	}
}
