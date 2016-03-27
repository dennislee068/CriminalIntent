package com.bignerdranch.android.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class ZoomSuspectFragment extends DialogFragment{

    private static final String ARG_ZOOM_SUSPECT_IMAGE = "ZoomSuspectImage";

    public static ZoomSuspectFragment newInstance(File file) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ZOOM_SUSPECT_IMAGE, file);

        ZoomSuspectFragment fragment = new ZoomSuspectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        File imageFile = (File) getArguments().getSerializable(ARG_ZOOM_SUSPECT_IMAGE);
        Bitmap image = PictureUtils.getScaledBitmap(imageFile.getPath(),getActivity());

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_zoom_suspect_image, null);

        ImageView imageView = (ImageView) v.findViewById(R.id.zoom_suspect_image);
        imageView.setImageBitmap(image);

        return new AlertDialog.Builder(getActivity())
                .setView(v).create();
    }
}
