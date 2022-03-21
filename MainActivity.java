package com.example.usecamera;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
public class MainActivity extends AppCompatActivity {

    private static final int INFORMATION_NUMBER=200;
    private String image_path;
    private ImageView image;
    Uri imageUri;
    Uri image_file_uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=findViewById(R.id.btn1);
        image=(ImageView) findViewById(R.id.img1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_path= "/storage/emulated/0/DCIM/Screenshots/nb.jpg";
//                File image_file=new File(image_path);
//                //获取文件路径
                image_file_uri=Uri.parse(image_path);
                //将文件路径转为URI表示

                Intent intent1=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //创建用于打开摄像头的intent
                intent1.putExtra(MediaStore.EXTRA_OUTPUT,image_file_uri);
                //把文件路径传给intent
                startActivityForResult(intent1,INFORMATION_NUMBER);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (1==1) {

            Bitmap  bmp = BitmapFactory.decodeFile(image_path);
            //将照片编码为bmp图
            image.setImageBitmap(bmp);
        }
        else
            Toast.makeText(this,"照相失败",Toast.LENGTH_LONG).show();
        super.onActivityResult(requestCode, resultCode, data);
    }
}
