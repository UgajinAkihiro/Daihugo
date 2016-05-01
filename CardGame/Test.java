import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Test extends JPanel /*implements ActionListener*/{

	Image pic[] = new Image[52];
	Image urax = getImage(getCodeBase(), "/cards/ura.png");
	//Image pic = new Image();
	private ArrayList<Integer> hand1 = new ArrayList<Integer>();

	//プレイヤー情報の取得
	Player player = new Player();
	Player cpu1 = new Player();
	Player cpu2 = new Player();
	Player cpu3 = new Player();

	//コンストラクタ
	public Test(){
		//カード全体の情報の取得
		Cards cards = new Cards(Joker.OFF);

		//画像ファイルの読み込み
		int i;
		String mark;
		int value;
		try{
			for(i=0;i<52;i++){
				Card card = cards.getCard();
				mark = card.getMark();
				value = card.getValue();
				InputStream f = getClass().getResourceAsStream(String.format("/cards/%s%02d.png", mark, value));
				pic[0] = ImageIO.read(f);
				switch(i%4){
					case 0:
					player.setHand(pic[0], mark, value); break;
					case 1:
					cpu1.setHand(pic[0], mark, value); break;
					case 2:
					cpu2.setHand(pic[0], mark, value); break;
					case 3:
					cpu3.setHand(pic[0], mark, value); break;
				}
			}
		}catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
		setPreferredSize(new Dimension(1000, 650));
	}

	//カードを配る
	public void delCard(){
		for(int i=0;i<10;i++){
			
		}
	}

	//画面描画
	public void paintComponent(Graphics g){
		g.setColor(new Color(0, 100, 0));
		g.fillRect(0, 0, 1000, 650);
		int i, j;
		int x = 0, y = 20;
		for(i=0;i<4;i++){
			switch(i){
				case 0:
				for(j=0;j<player.HandLength();j++){
					Random rnd = new Random();
					int ura = rnd.nextInt(2);
					switch(ura){
						case 0:
						g.drawImage(player.getHand(j), x, y, null);
						x = x + 50;
						break;
						case 1:
						g.drawImage(urax, x, y, null);
						x = x+ 50;
						break;
					}
				}
				break;

				case 1:
				for(j=0;j<cpu1.HandLength();j++){
					g.drawImage(cpu1.getHand(j), x, y, null);
					x = x + 50;
				}
				break;

				case 2:
				for(j=0;j<cpu2.HandLength();j++){
					g.drawImage(cpu2.getHand(j), x, y, null);
					x = x + 50;
				}
				break;

				case 3:
				for(j=0;j<cpu3.HandLength();j++){
					g.drawImage(cpu3.getHand(j), x, y, null);
					x = x + 50;
				}
				break;
			}
			x = 0;
			y += 150;
		}
	}

	//起動時
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(new Test());
		f.pack();
		f.setTitle("大富豪");
		f.setLocationRelativeTo(null);//フレームを画面中央に設定
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}

	/*//アクセッサ
	public String getMark(){
		return this.mark;
	}
	public void setMark(String mark){
		this.mark = mark;
	}*/
	//配列の要素を削除
	public int[] DeletArray(int[] array, int n){
		int newarray[] = new int[array.length-1];
		for(int i=0;i<array.length;i++){
			if(i!=n){
				newarray[i] = array[i];
			}
		}
		return newarray;
	}
}