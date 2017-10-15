package com.android.k.commons.dialog.mydialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import com.android.k.commons.dialog.lib.AlertDialogFactory;

/**
 * Created by ken-maki on 2017/10/15.
 */

public class MySampleBarDialogFactory extends AlertDialogFactory {

    public MySampleBarDialogFactory(Activity activity) {
        super(activity);
    }

    @Override
    public AlertDialog.Builder build() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Bar Dialog");
        builder.setMessage("This Bar Dialog. please Button Click.");
        builder.setPositiveButton("Ok", mPositiveClickListener);
        builder.setNegativeButton("Cancel", mNegativeClickListener);

        return builder;
    }


}
