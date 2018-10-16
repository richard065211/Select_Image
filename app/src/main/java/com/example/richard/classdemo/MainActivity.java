package com.example.richard.classdemo;

import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button1;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.bn);
        imageView=(ImageView)findViewById(R.id.image);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,select_image.class);
                startActivityForResult(intent,0x11);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==0x11&&resultCode==0x11){
            Bundle bundle=data.getExtras();
            int imageId=bundle.getInt("imageId");
            ImageView iv=(ImageView)findViewById(R.id.image);
            iv.setImageResource(imageId);
        }
    }
}
