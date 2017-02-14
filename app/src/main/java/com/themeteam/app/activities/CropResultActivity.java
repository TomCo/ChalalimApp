package com.themeteam.app.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.themeteam.app.R;

public class CropResultActivity extends BaseActivity implements View.OnTouchListener {

    private static final String KEY_FILE_URI = "uri";
    private static final String KEY_FINGER_NAME = "name";
    private static final String KEY_ICON_RES = "icon";

    public static Intent intentFactory(String uri, String fingerDisplayName, int iconResource, Context context) {
        Intent intent = new Intent(context, CropResultActivity.class);

        intent.putExtra(KEY_ICON_RES, iconResource);
        intent.putExtra(KEY_FILE_URI, uri);
        intent.putExtra(KEY_FINGER_NAME, fingerDisplayName);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_result);
    }

    @Override
    void init() {
        ((ImageView) findViewById(R.id.acrResultImage)).
                setImageURI(Uri.parse(getIntent().getStringExtra(KEY_FILE_URI)));

        ((TextView) findViewById(R.id.acrFingerName)).setText(getIntent().getStringExtra(KEY_FINGER_NAME));

        findViewById(R.id.acrLayout).setOnTouchListener(this);

        ((ImageView) findViewById(R.id.acrIcon)).setImageResource(getIntent().getIntExtra(KEY_ICON_RES, 0));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        finish();
        return false;
    }
}
