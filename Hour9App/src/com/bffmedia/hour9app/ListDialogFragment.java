package com.bffmedia.hour9app;

import com.bffmedia.hour9app.MainActivity;
import com.bffmedia.hour9app.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ListDialogFragment extends DialogFragment {
String[] items={"beef","fish","chicken","pasta"};
	@Override
public Dialog onCreateDialog(Bundle saveInsatanceState){
		AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
		builder.setTitle("Your choice are:").setItems(items, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
			}
		}).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		return builder.create();
	}

}
