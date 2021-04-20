package com.mamunsproject.waztube;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.mamunsproject.waztube.Adapter.Video_adapter;
import com.mamunsproject.waztube.Model.VideoModel;

import java.util.ArrayList;

public class Prosno_porbo extends AppCompatActivity {


    RecyclerView recyclerView;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prosno_porbo);

        setRecyclerView();

    }



    public void setRecyclerView() {

        database= FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.prosnoPorbo_recyclerviewid);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ArrayList<VideoModel> list = new ArrayList<>();
        Video_adapter video_adapter = new Video_adapter(list, getApplicationContext());

        database.collection("ProsnoPorbo")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        //ager data delete kore notun data add korbe
                        list.clear();
                        for (DocumentSnapshot snapshot:value.getDocuments()  ){

                            VideoModel model= snapshot.toObject(VideoModel.class);
                            model.setId(snapshot.getId());
                            list.add(model);

                        }
                        video_adapter.notifyDataSetChanged();
                    }
                });


        recyclerView.setAdapter(video_adapter);


    }

}