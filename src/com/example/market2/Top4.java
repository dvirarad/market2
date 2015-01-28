package com.example.market2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Top4 extends Activity {
	private int chepstSum, megaTotal ,shoferSalTotal,victoryTotal,bitanTotal;
	GlobalVariable gv;
	ArrayList<Prodact> selctedPrudact;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top4of);
		gv = (GlobalVariable) getApplicationContext();
		selctedPrudact = gv.getProdactList();
		megaTotal=0; shoferSalTotal=0;victoryTotal=0;bitanTotal=0;
		chepstSum = checkChipst();
		wait4ButoonChose();

	}


	private void wait4ButoonChose() {
		Button bShoferSal = (Button) findViewById(R.id.bshofersal);
		Button bYou = (Button) findViewById(R.id.byou);
		Button bVictory= (Button) findViewById(R.id.bvictory);
		Button bBitan= (Button) findViewById(R.id.bbitan);

		bShoferSal.setText(shoferSalTotal);
		bYou.setText(megaTotal);
		bVictory.setText(victoryTotal);
		bBitan.setText(bitanTotal);
		bShoferSal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {


			}
		});
		
	}
	private int checkChipst() {
		for (int i = 0; i < selctedPrudact.size(); i++) {
			Prodact _prodact = selctedPrudact.get(i);
			int a = _prodact.getId();
			megaTotal += _prodact.getAmount()*gv.getMegaPrice(a);
			shoferSalTotal  += _prodact.getAmount()*gv.getShoferSalPrice(a);
			victoryTotal += _prodact.getAmount()*gv.getVictoryPrice(a);
			bitanTotal += _prodact.getAmount()*gv.getBitanPrice(a);
		}

		return whoChipst(megaTotal,shoferSalTotal,victoryTotal,bitanTotal);
	}
	private int whoChipst(int a, int b,int c, int d) {
		int min_ab, min_cd, min;
		min_ab = a < b ? a : b;
		min_cd = c < d ? c : d;
		min = min_ab < min_cd ? min_ab : min_cd;
		return min;
	}





}
