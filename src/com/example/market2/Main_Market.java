package com.example.market2;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Main_Market extends Activity {
	//arrays of prodact price;

	public int numItem;
	public MyCustomAdapter dataAdapter = null;
	GlobalVariable gv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main__market);

		// Calling Application class (see application tag in AndroidManifest.xml)
		gv = (GlobalVariable) getApplicationContext();
		numItem = gv.getNUM_ITEM();
		gv.GlobalConstractor();
		gv.setAllPrice();
		displayListView();

		checkButtonClick();
	}



	private void displayListView() {
		ArrayList<Prodact> prodactList = new ArrayList<Prodact>();

		Prodact _prodace = new Prodact("Milk",0);
		prodactList.add(_prodace);
		_prodace = new Prodact("Bread",1);
		prodactList.add(_prodace);
		_prodace = new Prodact("Eggs",2);
		prodactList.add(_prodace);
		_prodace = new Prodact("Yogort",3);
		prodactList.add(_prodace);
		_prodace = new Prodact("Thini",4);
		prodactList.add(_prodace);
		_prodace = new Prodact("Coffe",5);
		prodactList.add(_prodace);
		_prodace = new Prodact("Tona",6);
		prodactList.add(_prodace);
		_prodace = new Prodact("Cheese",7);
		prodactList.add(_prodace);
		_prodace = new Prodact("Honey",8);
		prodactList.add(_prodace);
		_prodace = new Prodact("Tomato",9);
		prodactList.add(_prodace);
		_prodace = new Prodact("Cucumber",10);
		prodactList.add(_prodace);
		// create an ArrayAdaptar from the String Array
		dataAdapter = new MyCustomAdapter(this, R.layout.grosry, prodactList);
		ListView listView = (ListView) findViewById(R.id.listView1);
		// Assign adapter to ListView
		listView.setAdapter(dataAdapter);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main__market, menu);
		return true;
	}



	private class MyCustomAdapter extends ArrayAdapter<Prodact> {

		private ArrayList<Prodact> _prodactList;

		public MyCustomAdapter(Context context, int textViewResourceId,

				ArrayList<Prodact> prodactList) {
			super(context, textViewResourceId, prodactList);
			this._prodactList = prodactList;
			//this._prodactList.addAll(prodactList);
		}

		private class ViewHolder {
			EditText code;
			CheckBox name;
			SeekBar sb;

		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			final int fposition = position;
			final ViewHolder holder;

			Log.v("ConvertView", String.valueOf(position));

			if (convertView == null) {

				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				convertView = vi.inflate(R.layout.grosry, null);

				holder = new ViewHolder();
				holder.code = (EditText) convertView.findViewById(R.id.editText1);
				holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);

				holder.sb = (SeekBar) convertView.findViewById(R.id.seekBar1);
				holder.sb.setMax(5);
				holder.sb.setProgress(0);
				convertView.setTag(holder);
				holder.sb.setOnSeekBarChangeListener(
						new OnSeekBarChangeListener() {

							@Override
							public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
								holder.code.setText(""+progresValue);
							}

							@Override
							public void onStartTrackingTouch(SeekBar seekBar) {
								// Do something here, 
								//if you want to do anything at the start of
								// touching the seekbar
							}

							@Override
							public void onStopTrackingTouch(SeekBar seekBar) {
								if (Integer.parseInt(holder.code.getText().toString())!=0) {
								holder.name.setChecked(true);
								
								Prodact _prodact = _prodactList.get(fposition);
								_prodact.setAmount(Integer.parseInt(holder.code.getText().toString()));
								_prodact.setOnList(true);			
								}
							}
						});






				holder.name.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						CheckBox cb = (CheckBox) v;
						Prodact _prodact = (Prodact) cb.getTag();

						/*
						Toast.makeText(
								getApplicationContext(),
								"Checkbox: " + cb.getText() + " -> "
										+ cb.isChecked(), Toast.LENGTH_LONG)
								.show();
						 */
						_prodact.setOnList((cb.isChecked()));
					}
				});

			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			Prodact _prodact = _prodactList.get(position);
			
			
			holder.code.setText(" (" + _prodact.getAmount() + ")");
			holder.name.setText(_prodact.getName());
			holder.name.setChecked(_prodact.isOnList());
			holder.name.setTag(_prodact);
			return convertView;
		}

	}

	private void checkButtonClick() {

		Button myButton = (Button) findViewById(R.id.findSelected);

		myButton.setOnClickListener(new OnClickListener() {



			@Override
			public void onClick(View v) {
				ArrayList<Prodact> tempProdact = dataAdapter._prodactList;
				ArrayList<Prodact> sumProdact = new ArrayList<Prodact>();
				for (int i = 0; i < tempProdact.size(); i++) {
					Prodact prodact = tempProdact.get(i);

					if (prodact.isOnList()) {
						sumProdact.add(prodact);
					}
				}
				gv.setProdactList(sumProdact);
				Intent myIntent = new Intent(v.getContext(), TotalSum.class);
				startActivityForResult(myIntent, 0);

			}
		});
	}

}
