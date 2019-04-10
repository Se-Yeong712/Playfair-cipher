import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.management.Descriptor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

class userDisplay extends JFrame {

	JPanel pan;
	JLabel jl1, jl2;
	JTextField key, plaintext;
	JButton encryption, exit;

	public userDisplay() {
		pan = new JPanel();
		pan.setLayout(null);

		// JLabel
		jl1 = new JLabel("KEY");
		jl2 = new JLabel("PlainText");

		jl1.setBounds(50, 20, 100, 50);
		jl2.setBounds(50, 80, 100, 50);

		pan.add(jl1);
		pan.add(jl2);

		// JTextField
		key = new JTextField(300);
		plaintext = new JTextField(300);

		key.setBounds(130, 20, 300, 50);
		plaintext.setBounds(130, 80, 300, 50);

		pan.add(key);
		pan.add(plaintext);

		// JButton
		encryption = new JButton("암호화");
		exit = new JButton("닫기");

		// 버튼ActionListener
		// 암호화선택
		encryption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String keystr = key.getText();
				String textstr = plaintext.getText();
				if (keystr.equals("")) {

					JOptionPane.showMessageDialog(pan, "key을 입력하십시오");
				} else if (textstr.equals("")) {

					JOptionPane.showMessageDialog(pan, "문자열을 입력하십시오");
				} else {
					dispose();
					MainProgram.setmain(keystr, textstr);
				}

			}
		});

		// 화면 닫기, 프로그램 종료
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		encryption.setBounds(50, 180, 100, 50);
		exit.setBounds(330, 180, 100, 50);

		pan.add(encryption);
		pan.add(exit);

		add(pan);

		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("다중문자치환암호프로그램");

		setVisible(true);

	}

}

class resultDisplay extends JFrame {
	JPanel pan;
	JLabel restitle, encryresult, decryresult,reskey, resjl1, resjl2,resjl3;
	String resenc, resdec;
	JButton resexit;
	JTable table;

	public resultDisplay(String key,String enc, String dec,String row) {
		pan = new JPanel();
		pan.setLayout(null);

		restitle = new JLabel("결과");
		restitle.setFont(new Font("SanSerif", Font.BOLD, 20));

		resjl1 = new JLabel("암호화된 문자열");
		resjl2 = new JLabel("복호화된 문자열");
		resjl3 = new JLabel("KEY");

		pan.add(restitle);
		pan.add(resjl1);
		pan.add(resjl2);
		pan.add(resjl3);

		restitle.setBounds(220, 20, 100, 50);
		resjl1.setBounds(50, 100, 300, 50);
		resjl2.setBounds(50, 140, 300, 50);
		resjl3.setBounds(50, 60, 300, 50);

		encryresult = new JLabel(enc);
		decryresult = new JLabel(dec);
		reskey = new JLabel(key);
			
		encryresult.setBounds(160, 100, 300, 50);
		decryresult.setBounds(160, 140, 300, 50);
		reskey.setBounds(160, 60, 300, 50);

		pan.add(encryresult);
		pan.add(decryresult);
		pan.add(reskey);

		resexit = new JButton("닫기");
		resexit.setBounds(370, 300, 100, 50);
		pan.add(resexit);

		resexit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		Object rowData[][] = {{ "1", "2", "3", "4", "5" },{ "1", "2", "3", "4", "5" },{ "1", "2", "3", "4", "5" },{ "1", "2", "3", "4", "5" },{ "1", "2", "3", "4", "5" }};
		Object colName[] = { "1", "2", "3", "4", "5" };

		for (int i = 0, k = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				rowData[i][j] = row.charAt(k);
				k++;
			}
		}
		
		table = new JTable(rowData, colName);
		
		table.setFont(new Font("맑은고딕", Font.BOLD, 15));
		table.setRowHeight(30);
		
		table.setBounds(50, 180, 150, 150);
		pan.add(table);

		add(pan);

		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("다중문자치환암호프로그램");

		setVisible(true);

	}

}

public class MainProgram extends JFrame {

	public static char plate[][] = new char[5][5];
	public static boolean flag = false; // 글자수 출력
	public static String z = "";
	public static String row;
	
	public static void main(String[] args) {
		userDisplay user = new userDisplay();
	}

	public static void setmain(String keystr, String textstr) {
		String decryresult;
		String encryresult;
		String encdisplay;
		
		String key = keystr;
		String text = textstr;

		String blank = "";
		int blankcount = 0;

		setplate(key); // 암호화에 쓰일 암호판 세팅

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') // 공백제거
			{
				text = text.substring(0, i) + text.substring(i + 1, text.length());
				blank += 10;
			} else {
				blank += 0;
			}
			if (text.charAt(i) == 'z') // z를 q로 바꿔줘서 처리함.
			{
				text = text.substring(0, i) + 'q' + text.substring(i + 1, text.length());
				z += 1;
			} else {
				z += 0;
			}
		}

		encryresult = encryption(key, text);
		encdisplay = encryresult;
		
		
		System.out.println(encryresult + " ");
		for (int i = 0; i < encryresult.length(); i++) {
			if (encryresult.charAt(i) == ' ') // 공백제거
				encryresult = encryresult.substring(0, i) + encryresult.substring(i + 1, encryresult.length());
		}

		decryresult = decryption(key, encryresult, z);

		for (int i = 0; i < decryresult.length(); i++) {
			if (blank.charAt(i) == '1') {
				decryresult = decryresult.substring(0, i) + " " + decryresult.substring(i, decryresult.length());
			}
		}

		System.out.println(encryresult + " " + decryresult);

		resultDisplay result = new resultDisplay(key,encdisplay, decryresult,row);

	}

	public static String encryption(String key, String text) {
		ArrayList<char[]> plaintext = new ArrayList<char[]>();
		ArrayList<char[]> encrytext = new ArrayList<char[]>();
		int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
		String entext = "";

		for (int i = 0; i < text.length(); i += 2) 	//arraylist
		{
			char[] temparr = new char[2];
			temparr[0] = text.charAt(i);
			try {
				if (text.charAt(i) == text.charAt(i + 1)) // 같은 문자가 반복되면 x를 넣어준다.
				{
					temparr[1] = 'x';
					i--;
				} else {
					temparr[1] = text.charAt(i + 1);
				}
			} catch (StringIndexOutOfBoundsException e) {
				temparr[1] = 'x';
				flag = true;
			}
			plaintext.add(temparr);
		}

		for (int i = 0; i < plaintext.size(); i++) {
			System.out.print(plaintext.get(i)[0] + "" + plaintext.get(i)[1] + " ");
		}
		System.out.println();

		for (int i = 0; i < plaintext.size(); i++) {

			char[] tmpArr = new char[2];
			for (int j = 0; j < plate.length; j++) // 위치체크
			{
				for (int k = 0; k < plate[j].length; k++) {
					if (plate[j][k] == plaintext.get(i)[0]) {
						a1 = j;
						b1 = k;
					}
					if (plate[j][k] == plaintext.get(i)[1]) {
						a2 = j;
						b2 = k;
					}
				}
			}

			if (a1 == a2) // 같은 행
			{
				tmpArr[0] = plate[a1][(b1 + 1) % 5];
				tmpArr[1] = plate[a2][(b2 + 1) % 5];
			} else if (b1 == b2) // 같은 열
			{
				tmpArr[0] = plate[(a1 + 1) % 5][b1];
				tmpArr[1] = plate[(a2 + 1) % 5][b2];
			} else // 행, 열 모두 다른경우
			{
				tmpArr[0] = plate[a2][b1];
				tmpArr[1] = plate[a1][b2];
			}

			encrytext.add(tmpArr);

		}

		for (int i = 0; i < encrytext.size(); i++) {
			entext += encrytext.get(i)[0] + "" + encrytext.get(i)[1] + " ";
		}

		return entext;
	}

	public static String decryption(String key, String text, String z) {
		ArrayList<char[]> cryptogram = new ArrayList<char[]>(); // 암호
		ArrayList<char[]> decrytext = new ArrayList<char[]>(); // 복호화한 값
		int a1 = 0, a2 = 0, b1 = 0, b2 = 0; 
		String detext = "";

		int lenthflag = 1;

		for (int i = 0; i < text.length(); i += 2) {
			char[] temparr = new char[2];
			temparr[0] = text.charAt(i);
			temparr[1] = text.charAt(i + 1);
			cryptogram.add(temparr);
		}

		for (int i = 0; i < cryptogram.size(); i++) {

			char[] tmpArr = new char[2];
			for (int j = 0; j < plate.length; j++) {
				for (int k = 0; k < plate[j].length; k++) {
					if (plate[j][k] == cryptogram.get(i)[0]) {
						a1 = j;
						b1 = k;
					}
					if (plate[j][k] == cryptogram.get(i)[1]) {
						a2 = j;
						b2 = k;
					}
				}
			}

			if (a1 == a2) 			// 같은 행
			{
				tmpArr[0] = plate[a1][(b1 + 4) % 5];
				tmpArr[1] = plate[a2][(b2 + 4) % 5];
			} else if (b1 == b2) 	//같은 열
			{
				tmpArr[0] = plate[(a1 + 4) % 5][b1];
				tmpArr[1] = plate[(a2 + 4) % 5][b2];
			} else 					// 행, 열 모두 다른경우
			{
				tmpArr[0] = plate[a2][b1];
				tmpArr[1] = plate[a1][b2];
			}

			decrytext.add(tmpArr);

		}

		for (int i = 0; i < decrytext.size(); i++) // 중복 문자열 돌려놓음
		{
			if (i != decrytext.size() - 1 && decrytext.get(i)[1] == 'x'
					&& decrytext.get(i)[0] == decrytext.get(i + 1)[0]) {
				detext += decrytext.get(i)[0];
			} else {
				detext += decrytext.get(i)[0] + "" + decrytext.get(i)[1];
			}
		}

		for (int i = 0; i < z.length(); i++)// z위치 찾아서 q로 돌려놓음
		{
			if (z.charAt(i) == '1')
				detext = detext.substring(0, i) + 'z' + detext.substring(i + 1, detext.length());

		}

		if (flag)
			detext = detext.substring(0, detext.length() - 1);

		return detext;
	}

	public static void setplate(String key) {
		String platekey = ""; // 중복제거한 문자열을 저장
		boolean overflag = false; // 문자중복체크 flag

		key += "abcdefghijklmnopqrstuvwxyz"; // 암호판을 만들기 위한 알파벳 추가
		// 논리적 오류 -> 마지막 알파벳이 암호판에 나오지 않음 -> z를 q로 바꿔 알파벳을 25개로 만든다.
		key = key.replace('z', 'q');
		System.out.println(key);

		// key의 중복처리
		for (int i = 0; i < key.length(); i++) {
			for (int j = 0; j < platekey.length(); j++) {
				if (key.charAt(i) == platekey.charAt(j)) {
					overflag = true;
					break;
				}
			}
			if (!(overflag))
				platekey += key.charAt(i);
			overflag = false;
		}
		System.out.println(platekey);

		// 암호판에 알파벳 초기화
		for (int i = 0, k = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				plate[i][j] = platekey.charAt(k);
				k++;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(plate[i][j] + " ");
			}
			System.out.println("");
		}
		row=platekey;
			
	}

}