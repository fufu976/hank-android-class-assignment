package com.mayaw.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edNtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edNtd = findViewById(R.id.ed_ntd);
    }

    public void calCurrency(View v){
        final String ntd_s = edNtd.getText().toString();
        if(TextUtils.isEmpty(ntd_s)){
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.hint))
                    .setMessage(getString(R.string.hint_empty_amount))
                    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNtd.setText("");
                            edNtd.setHint("0");
                        }
                    })
                    .show();
        } else {
            float ntd_f = Float.parseFloat(ntd_s);
            float us_f = (float) (ntd_f / 30.9);
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.result))
                    .setMessage(getString(R.string.usd_result) + us_f)
                    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNtd.setText("");
                            edNtd.setHint("0");
                        }
                    })
                    .show();
        }
    }
}
