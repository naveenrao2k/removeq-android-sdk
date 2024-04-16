package com.removeq.sample;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.removeq.sdk.Config;
import com.removeq.sdk.RemoveQ;

public class MainActivity extends AppCompatActivity {

    Config config = new Config ("naveenrao"); // Provide containerId from the panel
    String originalImageUrl = "https://naveenrao.com/wp-content/uploads/2024/04/removeq.png"; // Provide any original image URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String cdnURL = RemoveQ.getInstance(config)
                .url(originalImageUrl)
                .create();
        ImageView imageView = (ImageView) findViewById(R.id.img);
        Glide.with(this).load(cdnURL).into(imageView);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}