package com.themeteam.app.utils;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class CapturePhotoUtils {

    public static final String APP_ALBUM_NAME = "Nist";
    public final static String TEMP_FILE_NAME = "Temp.png";
    public final static String FULL_PIC_FILE_NAME = "FullPic.png";
    public static final int REQUEST_CODE_GALLERY = 1;
    public static final int REQUEST_CODE_CAMERA = 2;
    public static final String URI_PREFIX = "file:///";

    public static String saveImage(ContentResolver cr,
                                   Bitmap source,
                                   File dir,
                                   String title) {
        Uri uri = null;
        String stringUrl = null;    /* value to be returned */

        try {
            uri = Uri.fromFile(getFileForTitle(dir ,title));
            if (source != null) {
                try (OutputStream imageOut = cr.openOutputStream(uri)) {
                    source.compress(Bitmap.CompressFormat.PNG, 100, imageOut);
                }
            } else {
                cr.delete(uri, null, null);
                uri = null;
            }
        } catch (Exception e) {
            if (uri != null) {
                cr.delete(uri, null, null);
                uri = null;
            }
        }

        if (uri != null) {
            stringUrl = uri.toString();
        }

        return stringUrl;
    }

    public static File getFileForTitle(File dir, String title) throws IOException {
        File image = new File(dir, title);
        if (!image.exists()) {
            image.createNewFile();
        }

        return image;
    }
    public static File getFileForTitle(String dir, String title) throws IOException {
        File image = new File(dir, title);
        if (!image.exists()) {
            image.createNewFile();
        }

        return image;
    }

    public static File getAppStorageDir() {
        File imageRoot = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), APP_ALBUM_NAME);
        if (!imageRoot.exists()) {
            imageRoot.mkdir();
        }
        return imageRoot;
    }

    public static File getAlbumStorageDirForCase(String caseId) {
        File dir = new File(getAppStorageDir(), caseId);
        if (!dir.exists()) {
            dir.mkdir();
        }

        return dir;
    }

    public static void deleteTempImg() {
        new File(getAppStorageDir().getAbsoluteFile(), TEMP_FILE_NAME).delete();
    }

    public static Bitmap drawableToBitmap (Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}