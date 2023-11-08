package com.example.daobaokhue_ungdungdocbao;


import static com.squareup.picasso.Picasso.*;

import android.app.Activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/** @noinspection ALL*/
public class MyListAdapter extends ArrayAdapter<Docbao> {

    public MyListAdapter(Context context, int resource, List<Docbao> items) {
        super(context, resource, items);
    }
    public View getView(int position,View convertview,ViewGroup parent) {
        View view = convertview;
        if(view == null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            view =inflater.inflate(R.layout.itemlv, null);
        }
        Docbao p = getItem(position);
        if (p!= null){
            TextView txttile = (TextView) view.findViewById(R.id.maintitle);
            txttile.setText(p.title);
            ImageView imageView = (ImageView) view.findViewById(R.id.imagemini);
            Picasso.get().load(p.hinhanh).into(imageView);

        }

        return view;

    };
}