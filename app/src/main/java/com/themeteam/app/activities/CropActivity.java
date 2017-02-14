package com.themeteam.app.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;

import com.theartofdev.edmodo.cropper.CropImageView;
import com.themeteam.app.R;
import com.themeteam.app.adapters.FingerSpinnerAdapter;
import com.themeteam.app.fragments.ChoosePhotoMethodFragment;
import com.themeteam.app.utils.CapturePhotoUtils;
import com.themeteam.app.utils.GeneralUtils;

import java.io.File;

import static com.themeteam.app.utils.CapturePhotoUtils.FULL_PIC_FILE_NAME;
import static com.themeteam.app.utils.CapturePhotoUtils.REQUEST_CODE_CAMERA;
import static com.themeteam.app.utils.CapturePhotoUtils.REQUEST_CODE_GALLERY;
import static com.themeteam.app.utils.CapturePhotoUtils.URI_PREFIX;
import static com.themeteam.app.utils.CapturePhotoUtils.getAlbumStorageDirForCase;

public class CropActivity extends BaseActivity {
    private static final String FULL_IMAGE_URI_KEY = "imageUri";
    private static final String CASE_NUMBER_KEY = "caseNumber";

    private CropImageView imageView;
    private Spinner fingerSpinner;
    private String caseNumber;
    private String[] filesNames;
    private String camUri;

    public static Intent intentFactory(String imagePath, String caseNumber, Context context) {
        Intent intent = new Intent(context, CropActivity.class);
        intent.putExtra(FULL_IMAGE_URI_KEY, imagePath);
        intent.putExtra(CASE_NUMBER_KEY, caseNumber);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_crop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case (R.id.mcCrop): {
                final Bitmap image = imageView.getCroppedImage();
                final int selectedPos = fingerSpinner.getSelectedItemPosition();
                final ProgressDialog dialog = GeneralUtils.getProgressDialog("גוזר ושומר את התמונה...", false, this);
                dialog.show();

                new AsyncTask<Void, Void, String>() {
                    @Override
                    protected String doInBackground(Void... params) {
                        return CapturePhotoUtils.saveImage(getContentResolver(), image,
                                getAlbumStorageDirForCase(caseNumber),
                                filesNames[selectedPos]);

                    }

                    @Override
                    protected void onPostExecute(String uri) {
                        super.onPostExecute(uri);
                        dialog.dismiss();
                        startActivity(CropResultActivity.intentFactory(uri, fingerSpinner.getSelectedItem().toString(),
                                GeneralUtils.iconResources[selectedPos], getBaseContext()));

                         // Show the user the pic is taken, must find view....
                        ((ImageView) fingerSpinner.findViewById(R.id.fsrIsPhotoTaken)).setImageResource(R.drawable.ic_check);
                    }
                }.execute();
                break;
            }
            case (R.id.mcSwitchPhoto): {
                camUri = verifyUri(getAlbumStorageDirForCase(caseNumber).getPath() + File.separator + FULL_PIC_FILE_NAME);
                ChoosePhotoMethodFragment.newInstance(getAlbumStorageDirForCase(caseNumber).getPath(), FULL_PIC_FILE_NAME)
                        .show(getSupportFragmentManager(), "Dialog");
                break;
            }
            case (R.id.mcRotateRight): {
                imageView.rotateImage(90);

                break;
            }
            case (R.id.mcNext): {
                Intent intent = ReviewPhotosActivity.intentFactory(getAlbumStorageDirForCase(this.caseNumber).getPath(), this);
                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    void init() {
        super.initToolbar("גזור תמונות");

        filesNames = this.getResources().getStringArray(R.array.fingerFileNames);

        caseNumber = getIntent().getStringExtra(CASE_NUMBER_KEY);

        imageView = (CropImageView) findViewById(R.id.cropImageView);
        imageView.setImageUriAsync(Uri.parse(verifyUri(getIntent().getStringExtra(FULL_IMAGE_URI_KEY))));

        this.initSpinner();
    }

    private void initSpinner() {
        getIntent().getStringExtra(FULL_IMAGE_URI_KEY);
        fingerSpinner = (Spinner) findViewById(R.id.acFingerSpinner);
        String[] displayNames = getResources().getStringArray(R.array.fingerDisplayNames);
        FingerSpinnerAdapter adapter = new FingerSpinnerAdapter(this, R.layout.finger_spinner_row, displayNames);
        adapter.setCaseFileUri(getAlbumStorageDirForCase(caseNumber).getAbsolutePath());
        fingerSpinner.setAdapter(adapter);
    }

    private String verifyUri(String uri) {
        // Must add prefix to URI or it won't be shown
        if (!uri.startsWith(URI_PREFIX)) {
            uri = URI_PREFIX + uri;
        }

        return uri;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case (REQUEST_CODE_GALLERY): {
                    imageView.setImageUriAsync(data.getData());
                    break;
                }
                case (REQUEST_CODE_CAMERA): {
                    imageView.setImageUriAsync(Uri.parse(camUri));
                    break;
                }
            }
        }
    }
}
