package net.fpl.Tuvmph18579;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import net.fpl.Tuvmph18579.webview.PH18579_WebView;
import net.fpl.Tuvmph18579.webview.XMLPar;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PH18579_News extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    List<String> lsTitle = new ArrayList<>();
    List<String> lsLink = new ArrayList<>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph18579_news);
        listView = findViewById(R.id.demo5Listview);
        //goi ket noi den server
        new HauTruong().execute("https://vnexpress.net/rss/giao-duc.rss");
        //chuyen du lieu den listview
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lsTitle);
        listView.setAdapter(arrayAdapter);
        //xu ly su kien
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String link = lsLink.get(i);
                intent = new Intent(PH18579_News.this, PH18579_WebView.class);
                intent.putExtra("linkhttp",link);
                startActivity(intent);
            }
        });
    }
    //Dinh nghia AsyncTask
    public class HauTruong extends AsyncTask<String,Void,String>
    {
        //xu ly input
        //ket noi theo url va tra ve ket qua
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder =new StringBuilder();
            //khai bao duong dan
            try {
                URL url = new URL(strings[0]);
                //tao luong doc
                InputStreamReader reader
                        =new InputStreamReader(url.openConnection().getInputStream());
                //tao bo nho dem
                BufferedReader bf = new BufferedReader(reader);
                //doc the tung dong
                String line="";
                while ((line = bf.readLine())!=null)
                {
                    stringBuilder.append(line);//dua dong vao phan du lieu
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }
        //output: dua ket qua da xu ly cho nguoi dung

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLPar xmlParser = new XMLPar();
            //Tao 1 tai lieu
            try {
                Document document = xmlParser.getDocument(s);//tao tai lieu
                //lay ve cac node item
                NodeList nodeList = document.getElementsByTagName("item");
                //lay ve link. title
                String link="";
                String title="";
                for(int i=0;i<nodeList.getLength();i++)
                {
                    //lay ve tung thanh phan
                    Element element = (Element)nodeList.item(i);
                    //lay gia tri cua tung thanh phan (title, link)
                    title = xmlParser.getValue(element,"title");
                    lsTitle.add(title);
                    link = xmlParser.getValue(element,"link");
                    lsLink.add(link);
                }
                arrayAdapter.notifyDataSetChanged();//cap nhat vao adapter
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }
}