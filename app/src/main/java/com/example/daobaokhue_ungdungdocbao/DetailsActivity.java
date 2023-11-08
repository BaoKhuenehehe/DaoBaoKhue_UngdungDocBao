package com.example.daobaokhue_ungdungdocbao;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/** @noinspection ALL*/
public class DetailsActivity extends AppCompatActivity {
    WebView webView;
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_detail);
        webView=(WebView)findViewById(R.id.webviewTT);
        Intent intent = getIntent();
        String link = intent.getStringExtra("linkTinTuc");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        //Toast.makeText(this,link,Toast.LENGTH_SHORT).show();
    }
}
