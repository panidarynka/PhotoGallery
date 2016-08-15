package api.test.photogallery.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import api.test.photogallery.R;

/**
 * Created by dasha on 15.08.16.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] ids = {R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4,
            R.drawable.dog5, R.drawable.dog6, R.drawable.anim1, R.drawable.anim2,
            R.drawable.anim7, R.drawable.anim4, R.drawable.anim5, R.drawable.anim6,
            R.drawable.anim7, R.drawable.anim8};

    public ImageAdapter(Context context) {
        mContext = context;

    }

    @Override
    public int getCount() {
        return ids.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            //initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(230, 220));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(ids[position]);
        return imageView;
    }
}
