package com.example.richard.classdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class select_image extends Activity {

    private int [] imageId=new int []{R.drawable.q,R.drawable.w,R.drawable.e,R.drawable.r,R.drawable.t};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);
        GridView gridView=(GridView)findViewById(R.id.image_select);
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return imageId.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView;
                if(view==null){
                    imageView=new ImageView(select_image.this);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxWidth(200);
                    imageView.setMaxHeight(200);
                    imageView.setPadding(5,5,5,5);
                }else{
                    imageView=(ImageView)view;
                }
                imageView.setImageResource(imageId[i]);
                return imageView;
            }
        };
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=getIntent();
                Bundle bundle=new Bundle();
                bundle.putInt("imageId",imageId[i]);
                intent.putExtras(bundle);
                setResult(0x11,intent);
                finish();
            }
        });
    }
}
