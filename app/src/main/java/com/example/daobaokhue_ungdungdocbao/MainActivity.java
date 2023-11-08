package com.example.daobaokhue_ungdungdocbao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity {
    ListView lvtieude;
    ArrayList<Docbao> mangdocbao;
    MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvtieude = (ListView)findViewById(R.id.lv_tieude) ;
        mangdocbao = new ArrayList<Docbao>();

       // MyListAdapter adapter=new MyListAdapter(this, arrayTitle[], arraydescrip[],arrayimglink[]);
        //lvtieude.setAdapter(adapter);
        new ReadRSS().execute("https://www.nguoiduatin.vn/rss/tai-chinh-ngan-hang.rss");
        lvtieude.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("linkTinTuc",mangdocbao.get(position).link);
                startActivity(intent);
            }
        });
    }
    private class ReadRSS extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);

                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            NodeList nodelistdescrip = document.getElementsByTagName("description");
            String tieude = "";
            String link="";
            String hinhanh="";
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                    Node tieudeNode = element.getElementsByTagName("title").item(0);
                    if (tieudeNode != null) {
                        tieude = tieudeNode.getTextContent() + "\n";
                    }
                String cdata = nodelistdescrip.item(i+1).getTextContent();
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher = p.matcher(cdata);
                        if(matcher.find()){
                            hinhanh = matcher.group(1);
                        }
                    mangdocbao.add(new Docbao(tieude,hinhanh,parser.getValue(element,"link")));
                }

            adapter = new MyListAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mangdocbao);
            lvtieude.setAdapter(adapter);
            super.onPostExecute(s);
            adapter.notifyDataSetChanged();
            }

        }

}

