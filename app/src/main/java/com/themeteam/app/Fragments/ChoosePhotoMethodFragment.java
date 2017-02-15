//package com.themeteam.app.fragments;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.support.v4.app.DialogFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//
//import com.themeteam.app.R;
//
//import java.io.File;
//import java.io.IOException;
//
//import static com.themeteam.app.utils.CapturePhotoUtils.REQUEST_CODE_CAMERA;
//import static com.themeteam.app.utils.CapturePhotoUtils.REQUEST_CODE_GALLERY;
//import static com.themeteam.app.utils.CapturePhotoUtils.getFileForTitle;
//
//public class ChoosePhotoMethodFragment extends DialogFragment implements View.OnClickListener {
//
//    private static final String KEY_FILE_NAME = "name";
//    private static final String KEY_FILE_PATH = "path";
//
//    public ChoosePhotoMethodFragment() {
//        // Required empty public constructor
//    }
//
//    public static ChoosePhotoMethodFragment newInstance(String filePath, String fileName) {
//        ChoosePhotoMethodFragment fragment = new ChoosePhotoMethodFragment();
//        Bundle args = new Bundle();
//        args.putString(KEY_FILE_NAME, fileName);
//        args.putString(KEY_FILE_PATH, filePath);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_choose_photo_method, container, false);
//        view.findViewById(R.id.fcpmGallery).setOnClickListener(this);
//        view.findViewById(R.id.fcpmCamera).setOnClickListener(this);
//        return view;
//    }
//
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Dialog dialog = super.onCreateDialog(savedInstanceState);
//
//        // request a window without the title
//        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        return dialog;
//    }
//
//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//
//        switch (id) {
//            case (R.id.fcpmCamera): {
//                this.openCamera();
//                break;
//            }
//            case (R.id.fcpmGallery): {
//                this.openGallery();
//                break;
//            }
//        }
//    }
//
//    private void openGallery() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//
//        // I want the activity to handel the result
//        getActivity().startActivityForResult(
//                Intent.createChooser(intent, "בחר תמונה של מסמך..."),
//                REQUEST_CODE_GALLERY);
//        this.dismiss();
//    }
//
//    private void openCamera() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//
//        File camFile = null;
//        try {
//            camFile = getFileForTitle(getArguments().getString(KEY_FILE_PATH), getArguments().getString(KEY_FILE_NAME));
//        } catch (IOException ignore) {
//        }
//
//        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(camFile));
//        takePictureIntent.putExtra("uri", Uri.fromFile(camFile));
//
//        // I want the activity to handel the result
//        getActivity().startActivityForResult(takePictureIntent, REQUEST_CODE_CAMERA);
//
//        this.dismiss();
//
//    }
//}
