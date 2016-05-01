
//カード全体の情報
public class Cards{
	
	//フィールド
	private int[] array;	//53枚のカードを格納する配列
	private int sheets;		//カードの残数
	
	//コンストラクタ
	public Cards(){	}
	public Cards(Joker joker){
		this.initCards(joker);
	}
	
	//sheetsのgetter
	public int getSheets(){
		return this.sheets;
	}
	
	//カード全体の情報を初期化するメソッド
	public void initCards(Joker joker){
		
		//カードの枚数
		int sheets = 0;	
		
		//ジョーカーの有無
		if(joker == Joker.OFF){
			sheets = 52;
		}
		else if(joker == Joker.ON){
			sheets = 53;
		}
		
		//カード用配列を初期化
		this.array = new int[sheets];
		for(int i = 0; i < sheets; i++){
			this.array[i] = i + 1;
		}
		
		//カードの残数を初期化
		this.sheets = sheets;
	}
	
	//カード番号を取得するメソッド
	public Card getCard() throws NotGetCardException{
		
		//カードの残数が0
		if(this.sheets == 0){
			throw new NotGetCardException();
		}
		
		//カード番号を取得する
		int cardNo = this.getCardNo();
		
		//カード番号からマークを取得する
		String cardMark = this.getCardMark(cardNo);
		
		//カード番号から数値を取得する
		int cardValue = this.getCardValue(cardNo);
		
		/*//カード番号から絵柄を取得する関数
		String cardDesign = this.getCardDesign(cardNo);*/
		
		//カードの情報
		Card card = new Card(cardMark,cardValue);
		
		return	card;
	}
	
	//カード番号を取得するメソッド
	private int getCardNo(){
				
		//乱数で取得した数値
		int select = (int)(Math.random() * this.sheets);
		
		//取得したカード番号
		int cardNo = this.array[select];
		
		//取得された値は、1番大きい添字の値に入れ替える
		this.array[select] = this.array[this.sheets - 1];
		
		//残りのカードの枚数
		this.sheets--;
		
		return cardNo;
	}
	
	//カード番号からマークを取得するメソッド
	private String getCardMark(int cardNo){
		
		//カードのマーク
		String cardMark = null;
		if(cardNo >= 1 && cardNo <= 13){
			cardMark = "s";		//スペード
		}
		else if(cardNo >= 14 && cardNo <= 26){
			cardMark = "h";		//ハート
		}
		else if(cardNo >= 27 && cardNo <= 39){
			cardMark = "c";		//クラブ
		}
		else if(cardNo >= 40 && cardNo <= 52){
			cardMark = "d";		//ダイヤ
		}
		/*else if(cardNo == 53){
			cardMark = "JK";	//ジョーカー
		}*/
		
		return cardMark;
	}
		
	//カード番号から数値を取得するメソッド
	private int getCardValue(int cardNo){
		
		//カードの数字
		int cardValue = 0;
		if(cardNo >= 1 && cardNo <= 13){
			cardValue = cardNo;
		}
		else if(cardNo >= 14 && cardNo <= 26){
			cardValue = cardNo - 13;
		}
		else if(cardNo >= 27 && cardNo <= 39){
			cardValue = cardNo - 26;
		}
		else if(cardNo >= 40 && cardNo <= 52){
			cardValue = cardNo - 39;
		}
		else if(cardNo == 53){
			cardValue = 0;		//ジョーカーは0を返す
		}
		
		return cardValue;
	}
	
	//カード番号から絵柄を取得するメソッド
	/*private String getCardDesign(int cardNo){
				
		//カード番号からマークを取得する
		String cardMark = this.getCardMark(cardNo);
		
		//カード番号から数値を取得する
		int cardValue = this.getCardValue(cardNo);
		
		//数字から絵札を判別
		String buffer = null;
		if(cardValue == 0){
			buffer = "";
		}
		else if(cardValue == 1){
			buffer = "A";
		}
		else if(cardValue == 11){
			buffer = "J";
		}
		else if(cardValue == 12){
			buffer = "Q";
		}
		else if(cardValue == 13){
			buffer = "K";
		}
		else{
			buffer = String.valueOf(cardValue);
		}
		
		//カードの絵柄を作る
		String cardDesign = cardMark + buffer;
		
		return cardDesign;
	}*/
}
