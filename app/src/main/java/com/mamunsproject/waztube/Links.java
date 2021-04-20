package com.mamunsproject.waztube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Links extends AppCompatActivity {

    CardView cardView1,cardView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);


        cardView1=findViewById(R.id.facebookLink);
        cardView2=findViewById(R.id.youtubeLink);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(),WebView___.class);
                intent.putExtra("key","https://www.facebook.com/mizanurrahmanazhariofficial");
                startActivity(intent);
            }
        });


        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),WebView___.class);
                intent.putExtra("key","https://www.youtube.com/channel/UCxStLx7yb96MGBfIMo20x7Q");
                startActivity(intent);
            }
        });



    }
}