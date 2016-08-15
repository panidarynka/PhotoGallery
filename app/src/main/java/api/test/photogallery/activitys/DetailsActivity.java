package api.test.photogallery.activitys;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import api.test.photogallery.adapters.FullScreenImageAdapter;
import api.test.photogallery.R;

public class DetailsActivity extends AppCompatActivity {
private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        Integer position = intent.getIntExtra("position", 0);
        Log.d("position",position.toString());
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        FullScreenImageAdapter fullScreenImageAdapter = new FullScreenImageAdapter(this);
        viewPager.setAdapter(fullScreenImageAdapter);
        viewPager.setCurrentItem(position);
    }
}
