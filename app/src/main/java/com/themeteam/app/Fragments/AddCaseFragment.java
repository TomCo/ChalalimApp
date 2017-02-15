//package com.themeteam.app.fragments;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageView;
//
//import com.themeteam.app.R;
//import com.themeteam.app.activities.ScanActivity;
//import com.themeteam.app.utils.CapturePhotoUtils;
//import com.themeteam.app.utils.GeneralUtils;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//
//import static com.themeteam.app.utils.CapturePhotoUtils.FULL_PIC_FILE_NAME;
//import static com.themeteam.app.utils.CapturePhotoUtils.REQUEST_CODE_CAMERA;
//import static com.themeteam.app.utils.CapturePhotoUtils.REQUEST_CODE_GALLERY;
//import static com.themeteam.app.utils.CapturePhotoUtils.TEMP_FILE_NAME;
//import static com.themeteam.app.utils.CapturePhotoUtils.getAppStorageDir;
//
//public class AddCaseFragment extends Fragment implements View.OnClickListener {
//
//    private Bitmap bitmap;
//    private ImageView image;
//    private EditText txtId;
//    private String camUri;
//
//    public AddCaseFragment() {
//        // Required empty public constructor
//    }
//
//    public static AddCaseFragment newInstance() {
//        AddCaseFragment fragment = new AddCaseFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_add_case, container, false);
//        image = (ImageView) view.findViewById(R.id.cmImage);
//        txtId = (EditText) view.findViewById(R.id.cmIdentifier);
//        image.setOnClickListener(this);
//
//        return view;
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//    }
//
//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id) {
//            case (R.id.cmImage): {
//                camUri = getAppStorageDir().getPath() + File.separator + TEMP_FILE_NAME;
//
//                ChoosePhotoMethodFragment.newInstance(getAppStorageDir().getPath(), TEMP_FILE_NAME).
//                        show(getActivity().getSupportFragmentManager(), "Dialog");
//
//                break;
//            }
//        }
//    }
//
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        InputStream inputStream = null;
//        if (resultCode == Activity.RESULT_OK) {
//            if (bitmap != null) {
//                bitmap.recycle();
//            }
//            switch (requestCode) {
//                case (REQUEST_CODE_GALLERY): {
//                    try {
//                        inputStream = getActivity().getContentResolver().openInputStream(data.getData());
//                        bitmap = BitmapFactory.decodeStream(inputStream);
//                        image.setImageBitmap(bitmap);
//                    } catch (FileNotFoundException ignore) {
//                    } finally {
//                        if (inputStream != null) {
//                            try {
//                                inputStream.close();
//                            } catch (IOException ignore) {
//                            }
//                        }
//                    }
//
//                    break;
//                }
//                case (REQUEST_CODE_CAMERA): {
//                    bitmap = BitmapFactory.decodeFile(camUri);
//                    image.setImageBitmap(bitmap);
//                    break;
//                }
//            }
//        }
//    }
//
//    public void next() {
//        final Bitmap bitmap = CapturePhotoUtils.drawableToBitmap(image.getDrawable());
//        if (txtId.getText().toString().isEmpty()) {
//            txtId.setError("חובה למלא שדה זה");
//            txtId.requestFocus();
//        } else if (bitmap == null) {
//            Snackbar.make(image, "יש לצלם מסמך לפני המעבר לדף הבא", Snackbar.LENGTH_LONG).show();
//        } else {
//            final File storage = CapturePhotoUtils.getAlbumStorageDirForCase(txtId.getText().toString());
//            final ProgressDialog dialog = GeneralUtils.getProgressDialog("שומר את התמונה...", false, getActivity());
//            dialog.show();
//            new AsyncTask<String, Void, String>() {
//
//                @Override
//                protected String doInBackground(String... params) {
//                    return CapturePhotoUtils.saveImage(getActivity().getContentResolver(), bitmap, storage, params[0]);
//                }
//
//                @Override
//                protected void onPostExecute(String uri) {
//                    super.onPostExecute(uri);
//                    dialog.dismiss();
//                }
//            }.execute(FULL_PIC_FILE_NAME);
//        }
//    }
//
//}
