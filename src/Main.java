import lib.Input;

public class Main {

	static CashBook cb = new CashBook();
	public static void main(String[] args) {

		//サンプルデータ
		cb.add(2015, 1, 1, 10, 3, "ビール",	-300);
		cb.add(2015, 1, 1, 10, 1, "かわ", 	-160);
		cb.add(2015, 1, 1, 10, 2, "つくね",	-160);
		cb.add(2015, 1, 1,  9, 0, "繰越", 	1000);
		cb.addGoal(2015, 1, "串鐵は週1回まで");
		cb.addGoal(2015, 2, "串鐵は月2回まで");

		String menu1 = "1:すべて表示 2:新規作成 3:更新 4:削除 5:今月の目標";
		//ユーザーインタフェース
		while(true){
			System.out.println(menu1);
			int n = Input.getInt();

			switch (n) {
			case 1:
				System.out.println("1:すべて表示");
				cb.printAll();
				break;
			case 2:
				createUI(-1);
				break;
			case 3:
				System.out.println("3:更新");
				cb.printAll();
				updateUI();
				break;
			case 4:
				System.out.println("4:削除");
				cb.printAll();
				deleteUI();
				break;
			case 5:
				System.out.println("5:今月の目標");
				cb.printGoal();
				goalUI();
				break;
			default:
				System.out.println("正しい値を指定してください。");
				break;
			}
		}
	}

	private static void createUI(int id){
		String msg = "2:新規作成";
		String example = "例）2015,1,1,9,25,お年玉,2000";
		if(id >= 0){
			msg = "3:更新";
			example = cb.getUpdateExample(id);
		}
		System.out.println(msg);
		System.out.println("「年,月,日,時,分,用途,金額」の順で、カンマ区切りで入力して下さい。");
		System.out.println(example);
		String s = Input.getString();
		//nullチェック
		if(s == null || s.length() == 0){
			return;
		}
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
			cb.printAll();
		}catch(Exception e){
			//入力されたデータが違うので終了
			System.out.println("データ形式が異なります。\n");
		}
	}

	private static void updateUI(){
		while(true){
			System.out.println("更新する仕訳番号を指定してください。（範囲外の値：メインメニューへ）\n");
			int n = Input.getInt();

			if(n < 0 || n >= cb.size()){
				System.out.println("メインメニューへ移動");
				return;
			}

			// 更新と言いつつ、実は削除＋新規作成
			// TODO:更新前の確認
			cb.delete(n);
			createUI(n);
		}
	}

	private static void deleteUI(){
		while(true){
			System.out.println("削除する仕訳番号を指定してください。（範囲外の値：メインメニューへ）\n");
			int n = Input.getInt();

			if(n < 0 || n >= cb.size()){
				System.out.println("メインメニューへ移動");
				return;
			}
			// TODO:削除前の確認
			cb.delete(n);
		}
	}

	private static void goalUI(){
		System.out.println("「年,月,今月の目標」の順で、カンマ区切りで入力して下さい。");
		String s = Input.getString();
		//nullチェック
		if(s == null || s.length() == 0){
			return;
		}
		//カンマ区切りで配列へ
		String[] sa = s.split(",");

		int year, month;
		String title;
		try{
			year 	= Integer.parseInt(sa[0]);
			month 	= Integer.parseInt(sa[1]);
			title  	= sa[2];
			cb.addGoal(year, month, title);
			cb.printGoal();
		}catch(Exception e){
			//入力されたデータが違う
			System.out.println("データ形式が異なります。\n");
		}

	}
}
