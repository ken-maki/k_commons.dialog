package com.android.k.commons.dialog.lib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by ken-maki on 2017/10/15.
 */

public abstract class AlertDialogFactory extends BaseDialogFactory {

    protected DialogInterface.OnClickListener mPositiveClickListener;
    protected DialogInterface.OnClickListener mNegativeClickListener;

    /**
     * Constructor.
     *
     * @param activity create dialog for activity.
     */
    public AlertDialogFactory(Activity activity) {
        super(activity);
    }

    /**
     * create AlertDialog.Builder.
     *
     * @return can be Show AlertDialog.Builder
     */
    public abstract AlertDialog.Builder build();

    /**
     * set OnClickListener for PositiveButton click.
     * @param listener action listener
     */
    public void setPositiveOnClickListener(DialogInterface.OnClickListener listener) {
        mPositiveClickListener = listener;
    }

    /**
     * set OnClickListener for NegativeButton click.
     * @param listener action listener
     */
    public void setNegativeClickListener(DialogInterface.OnClickListener listener) {
        mNegativeClickListener = listener;
    }
}
