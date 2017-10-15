package com.android.k.commons.dialog.lib;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by ken-maki on 2017/10/15.
 */

public class CommonAlertDialog extends DialogFragment {
    private static final String ARG_KEY_FACTORY = "f";

    AlertDialogFactory mFactory;

    public static CommonAlertDialog newInstance(AlertDialogFactory factory) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_KEY_FACTORY, factory);

        CommonAlertDialog dialog = new CommonAlertDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mFactory = (AlertDialogFactory)
                getArguments().getSerializable(ARG_KEY_FACTORY);
        if (mFactory == null) throw new IllegalArgumentException("factory is null.");

        AlertDialog.Builder builder = mFactory.build();
        if (builder == null) throw new IllegalStateException("AlertDialog.Builder is null.");
        return builder.create();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (mFactory.mOnCancelListener != null) {
            mFactory.mOnCancelListener.onCancel(dialog);
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mFactory.mOnDismissListener != null) {
            mFactory.mOnDismissListener.onDismiss(dialog);
        }
    }

    /**
     * return AlertDialogFactory.
     * @return AlertDialogFactory
     */
    public AlertDialogFactory getFactory() {
        return mFactory;
    }
}
