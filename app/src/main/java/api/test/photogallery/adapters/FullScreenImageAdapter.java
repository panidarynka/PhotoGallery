package api.test.photogallery.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import api.test.photogallery.R;

/**
 * Created by dasha on 15.08.16.
 */
public class FullScreenImageAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    private Integer[] ids = {R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4,
            R.drawable.dog5, R.drawable.anim8, R.drawable.anim1, R.drawable.anim2,
            R.drawable.anim7, R.drawable.anim4, R.drawable.anim5, R.drawable.anim6,
            R.drawable.anim7, R.drawable.anim8};

    public FullScreenImageAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ids.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_page, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.full_image);
        imageView.setImageResource(ids[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
