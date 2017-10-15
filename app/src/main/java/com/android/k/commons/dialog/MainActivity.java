package com.android.k.commons.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.k.commons.dialog.lib.DialogGenerator;
import com.android.k.commons.dialog.mydialog.MySampleBarDialogFactory;
import com.android.k.commons.dialog.mydialog.MySampleFooDialogFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

        final Activity activity = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySampleFooDialogFactory fooFactory = new MySampleFooDialogFactory(activity);
                DialogGenerator dialogGenerator = new DialogGenerator();
                dialogGenerator.show(fooFactory);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySampleBarDialogFactory barFactory = new MySampleBarDialogFactory(activity);
                barFactory.setPositiveOnClickListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "Ok clicked.(listener setting from activity)", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                barFactory.setNegativeClickListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "Cancel clicked.(listener setting from activity)", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                DialogGenerator dialogGenerator = new DialogGenerator();
                dialogGenerator.show(barFactory);
            }
        });
    }
}
