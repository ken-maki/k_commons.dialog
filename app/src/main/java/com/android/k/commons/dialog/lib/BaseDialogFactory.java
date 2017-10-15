package com.android.k.commons.dialog.lib;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import java.io.Serializable;

/**
 * Created by ken-maki on 2017/10/15.
 */

abstract class BaseDialogFactory implements Serializable {

    DialogInterface.OnCancelListener mOnCancelListener;
    DialogInterface.OnDismissListener mOnDismissListener;

    /**
     * Activity to display Dialog.
     */
    private Activity mActivity;

    /**
     * Constructor.
     *
     * @param activity create dialog for activity.
     */
    BaseDialogFactory(Activity activity) {
        if (activity == null) throw new IllegalArgumentException("activity is null.");
        mActivity = activity;
    }

    /**
     * get Activity.
     *
     * @return Activity
     */
    protected Activity getActivity() {
        return mActivity;
    }

    /**
     * get Dialog Tag.
     *
     * @return Dialog Tag
     */
    protected String getTag() {
        return this.getClass().getSimpleName();
    }

    /**
     * set OnCancelListener.
     * @param listener action listener
     */
    public void setOnCancelListener(DialogInterface.OnCancelListener listener) {
        mOnCancelListener = listener;
    }

    /**
     * set OnDismissListener.
     * @param listener action listener
     */
    public void setOnDismissListener(DialogInterface.OnDismissListener listener) {
        mOnDismissListener = listener;
    }
}
