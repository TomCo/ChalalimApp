package com.themeteam.app.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.theartofdev.edmodo.cropper.CropImageView;
import com.themeteam.app.R;
import com.themeteam.app.Server.Api;
import com.themeteam.app.Server.Chalal;
import com.themeteam.app.Server.User;
import com.themeteam.app.entities.ClientChalal;
import com.themeteam.app.entities.ClientUser;

public class ScanActivity extends BaseActivity implements View.OnClickListener {
    EditText misparChalal;

    public static Intent intentFactory(Context context) {
        return new Intent(context, ScanActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
    }

    @Override
    void init() {
        super.initToolbar("התחברות");
        misparChalal = (EditText) findViewById(R.id.asId);
        findViewById(R.id.asSubmit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Api api = Api.getInstance();
        switch (id) {
            case (R.id.asSubmit): {
                int nMisparChalal = Integer.parseInt(misparChalal.getText().toString());
                Chalal chalal = api.getChalal(nMisparChalal);
                if (chalal != null) {
                    ClientChalal.addCurrentChalal(chalal);
                    Intent intent = new Intent(this, StationListActivity.class);
                    startActivity(intent);
                } else {
                    //Create chalal...
                }

                break;
            }

        }

    }
}
