package net.fpl.Tuvmph18579;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PH18579_Main extends AppCompatActivity {
    ImageView coursos, maps, news, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph18579_main);
        coursos = findViewById(R.id.iv_courses);
        maps = findViewById(R.id.iv_maps);
        news = findViewById(R.id.iv_news);
        share = findViewById(R.id.iv_social);

        //onclick
        coursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PH18579_Main.this, PH18579_Courses.class);
                startActivity(intent);
            }
        });
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PH18579_Main.this,PH18579_MapsActivity.class);
                startActivity(intent);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PH18579_Main.this,PH18579_News.class);
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PH18579_Main.this,PH18579_ShareFaceBook.class);
                startActivity(intent);
            }
        });
    }
}