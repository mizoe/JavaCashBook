import lib.Input;

public class Main {

	static CashBook cb = new CashBook();
	public static void main(String[] args) {

		//サンプルデータ
		cb.add(2015, 1, 1, 10, 3, "ビール",	-300);
		cb.add(2015, 1, 1, 10, 1, "かわ", 	-160);
		cb.add(2015, 1, 1, 10, 2, "つくね",	-160);
		cb.add(2015, 1, 1,  9, 0, "繰越", 	1000);

		String menu1 = "1:すべて表示 2:新規作成 3:更新 4:削除";
		//ユーザーインタフェース
		UILOOP:
		while(true){
			System.out.println(menu1);
			int n = Input.getInt();

			switch (n) {
			case 1:
				System.out.println("1:すべて表示");
				cb.printAll();
				break;
			case 2:
				System.out.println("2:新規作成");
				System.out.println("「年,月,日,時,分,用途,金額」の順で、カンマ区切りで入力して下さい。");
				System.out.println("例）2015,1,1,9,25,お年玉,2000");
				String s = Input.getString();
				//カンマ区切りで配列へ
				String[] sa = s.split(",");

				int year, month, day, hour, minute, amount;
				String usage;
				try{
					year 	= Integer.parseInt(sa[0]);
					month 	= Integer.parseInt(sa[1]);
					day 	= Integer.parseInt(sa[2]);
					hour 	= Integer.parseInt(sa[3]);
					minute 	= Integer.parseInt(sa[4]);
					usage  	= sa[5];
					amount 	= Integer.parseInt(sa[6]);
					cb.add(year, month, day, hour, minute, usage, amount);
				}catch(Exception e){
					//入力されたデータが違うので終了
					System.out.println("データ形式が異なります。終了します。:\n");
					break UILOOP;
				}
				break;
			case 3:
				System.out.println("3:更新");
				cb.printAll();
				break;
			case 4:
				System.out.println("4:削除");
				cb.printAll();
				deleteUI();
				break;
			default:
				System.out.println("--- 終了します ---");
				break UILOOP;
			}
		}

	}
	private static void deleteUI(){
		while(true){
			System.out.println("削除する仕訳番号を指定してください。範囲外の値：メインメニュー\n");
			int n = Input.getInt();

			if(n < 0 || n >= cb.size()){
				System.out.println("メインメニューへ移動");
				return;
			}

			cb.delete(n);
		}
	}
}
