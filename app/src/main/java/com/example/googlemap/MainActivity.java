package com.example.googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mSearchBtn;
    private EditText mCoordinates;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mSearchBtn = findViewById(R.id.searchBtn);
        mCoordinates = findViewById(R.id.editText);

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
    }

    private void openMap() {
        String text = mCoordinates.getText().toString();
        char result = text.charAt(1);
        if(Character.isLetter(result)){
            uri = Uri.parse("geo:?q=" + text);
        }else {
            uri = Uri.parse("geo:" + text);
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);

    }
}
