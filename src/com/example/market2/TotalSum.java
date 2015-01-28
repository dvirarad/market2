package com.example.market2;
import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class TotalSum extends Activity {
	public int numItem;
	public MyCustomAdapter dataAdapter = null;
	GlobalVariable gv;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.total);

		gv = (GlobalVariable) getApplicationContext();

		displayTotalList();


	}

	private void displayTotalList() {

		dataAdapter = new MyCustomAdapter(this, R.layout.prodact, gv.getProdactList());
		ListView listView = (ListView) findViewById(R.id.lvOrder);
		// Assign adapter to ListView
		listView.setAdapter(dataAdapter);

	}
	private class MyCustomAdapter extends ArrayAdapter<Prodact> {

		private ArrayList<Prodact> _prodactList;

		public MyCustomAdapter(Context context, int textViewResourceId,ArrayList<Prodact> prodactList) {
			super(context, textViewResourceId, prodactList);
			this._prodactList = prodactList;
		//	this._prodactList.addAll(prodactList);
		}


		private class ViewHolder {
			TextView name,totalPrice,mul;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			final ViewHolder holder;

			Log.v("ConvertView", String.valueOf(position));

			if (convertView == null) {

				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				convertView = vi.inflate(R.layout.prodact, null);

				holder = new ViewHolder();
				holder.name = (TextView) convertView.findViewById(R.id.tvName);
				holder.totalPrice = (TextView) convertView.findViewById(R.id.tvPrice);


				convertView.setTag(holder);


			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			Prodact _prodact = _prodactList.get(position);

			holder.totalPrice.setText(" (" + _prodact.getAmount() + ")");
			holder.name.setText(_prodact.getName());



			return convertView;
		}

	}

}
