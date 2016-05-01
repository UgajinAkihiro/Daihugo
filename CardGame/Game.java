
import java.util.ArrayList;
import java.util.Scanner;

public class Game{
	ArrayList<Integer> hand1 = new ArrayList<Integer>();
	int field = 0;
	//コンストラクタ
	public Game(){
		int i=0;

		//カード全体の情報
		Cards cards = new Cards(Joker.OFF);

		//プレイヤーデータの取得
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		Player p5 = new Player();

		//実行結果の出力
		try{
			System.out.println("ゲームスタート\n");
			while(true){
				Card card = cards.getCard();
				int play = i%5;
				switch(play){
					case 0: p1.drawCard(card.getValue());break;
					case 1: p2.drawCard(card.getValue());break;
					case 2: p3.drawCard(card.getValue());break;
					case 3: p4.drawCard(card.getValue());break;
					case 4: p5.drawCard(card.getValue());break;
				}
				i++;
			}
		}
		catch(NotGetCardException ex){
			hand1 = p1.getHand();

			PlayGame(p1);
		}
		finally{
		}
	}
	/*private void PlayGame(Player p){
		while(hand1.size()>0){
			System.out.print("Player1's hand = ");
			for(int i=0;i<hand1.size();i++){
				System.out.print(""+hand1.get(i)+", ");
			}
			System.out.println("\n場のカード:"+field);
			System.out.println("出したいカードの位置を選んでください(パスの場合は0)");
			Scanner scan = new Scanner(System.in);
			int val = scan.nextInt();
			if(val != 0){
				
				int x = p.SelectCard(val-1, field);
				if(x != 0){
					field = x;
				}
				if(x == 0){
					System.out.println("このカードは出せません\n");
				}
			}
			else{
				field = 0;
			}
		}
		System.out.println("\n上がりました");
	}*/
	private PlayGame(){
		
	}
}