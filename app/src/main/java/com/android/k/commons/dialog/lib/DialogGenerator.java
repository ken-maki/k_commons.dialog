package com.android.k.commons.dialog.lib;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;

/**
 * Created by ken-maki on 2017/10/15.
 */

public class DialogGenerator {

    /**
     * show dialog.
     * @param factory the dialog factory want to view
     * @return showed dialog
     */
    public Dialog show(AlertDialogFactory factory) {
        Activity activity = factory.getActivity();

        FragmentManager fragmentManager = activity.getFragmentManager();
        DialogFragment dialogFragment =
                (DialogFragment) fragmentManager.findFragmentByTag(factory.getTag());
        if (dialogFragment != null && dialogFragment.getShowsDialog()) {
            return dialogFragment.getDialog();
        }

        CommonAlertDialog dialog = CommonAlertDialog.newInstance(factory);
        dialog.show(fragmentManager, factory.getTag());
        return dialog.getDialog();
    }


}
