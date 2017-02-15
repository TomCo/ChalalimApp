package com.themeteam.app.activities;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;

import com.themeteam.app.R;
import com.themeteam.app.Server.Api;
import com.themeteam.app.Server.User;
import com.themeteam.app.entities.ClientUser;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    void init() {
        super.initToolbar("התחברות");
        id = (EditText) findViewById(R.id.amId);
        findViewById(R.id.amSubmit).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Api api = Api.getInstance();
        switch (id) {
            case (R.id.amSubmit): {
                User user = api.getUserByMisparIshi(this.id.getText().toString());
                if (user != null) {
                    ClientUser.connect(user);
                    Intent intent = ScanActivity.intentFactory(this);
                    startActivity(intent);
                } else {
                    this.id.setError("מספר אישי אינו קיים!");
                }

                break;
            }
        }
    }

    public void scanMisparIshi(View v){
        this.id.setText("1");
    }
}

