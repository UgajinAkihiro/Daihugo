
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
//Player1の情報
public class Player{
	//フィールド
	//private ArrayList<Image> hand = new ArrayList<Image>(); //手札を格納するリスト
	private Image hand[] = new Image[13];
	private ArrayList<String> mark = new ArrayList<String>();//手札のマークを格納するリスト
	private ArrayList<Integer> number= new ArrayList<Integer>();//手札の数字を格納するリスト
	private int i = 0;
	private int n = 0;
	//コンストラクタ
	public Player(){}

	//アックセッサ
	/*public ArrayList<Integer> getHand(){
		return hand;
	}*/
	public Image getHand(int i){
		return hand[i];
	}
	public void setHand(Image hand, String mark , int number){
		//this.hand.add(hand);
		this.hand[n] = hand;
		this.mark.add(mark);
		this.number.add(number);
		this.n++;
	}
	public int HandLength(){
		return number.size();
	}
	//自分の手札から１枚選ぶ
	/*public int SelectCard(int selectnum, int field){
		int x = 
		if(x<=field){
			return 0;//出せないカードなら0を返す
		}
		DeleteHand(selectnum);
		return x;
	}*/
	//コンピューターが出すカードを選ぶ
	/*public int AIPutCard(int[] number, int fieldnum){
		int choice;
		for(i=0;i<number.length;i++){
			if(number[i] > fieldnum){
				choice = number[i];
				break;
			}
		}
	}*/
	public void DeleteHand(int i){
		mark.remove(i);
		number.remove(i);
	}
}