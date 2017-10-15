package com.android.k.commons.dialog.mydialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import com.android.k.commons.dialog.lib.AlertDialogFactory;

/**
 * Created by ken-maki on 2017/10/15.
 */

public class MySampleFooDialogFactory extends AlertDialogFactory {

    public MySampleFooDialogFactory(Activity activity) {
        super(activity);
    }

    @Override
    public AlertDialog.Builder build() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Foo Dialog");
        builder.setMessage("This Foo Dialog. please Button Click.");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Ok clicked.(listener setting from factory)", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancel clicked.(listener setting from factory)", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setCancelable(false);
        return builder;
    }
}
