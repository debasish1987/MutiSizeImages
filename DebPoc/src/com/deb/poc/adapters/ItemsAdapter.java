package com.deb.poc.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deb.poc.R;
/*
public class ItemsAdapter extends ArrayAdapter<Integer>{

    Context context; 
    LayoutInflater inflater;
    int layoutResourceId;
    float imageWidth;
    
    public ItemsAdapter(Context context, int layoutResourceId, Integer[] items) {
        super(context, layoutResourceId, items);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        
        float width = ((Activity)context).getWindowManager().getDefaultDisplay().getWidth();
        float margin = (int)convertDpToPixel(10f, (Activity)context);
        // two images, three margins of 10dips
		imageWidth = ((width - (3 * margin)) / 2);
    }

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FrameLayout row = (FrameLayout) convertView;
        ItemHolder holder;
        Integer item = getItem(position);
        
		if (row == null) {
			holder = new ItemHolder();
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = (FrameLayout) inflater.inflate(layoutResourceId, parent, false);
            ImageView itemImage = (ImageView)row.findViewById(R.id.item_image);
			holder.itemImage = itemImage;
		} else {
			holder = (ItemHolder) row.getTag();
		}
		
		row.setTag(holder);
		setImageBitmap(item, holder.itemImage);
        return row;
    }

    public static class ItemHolder
    {
    	ImageView itemImage;
    }
	
    // resize the image proportionately so it fits the entire space
	private void setImageBitmap(Integer item, ImageView imageView){
		Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), item);
		float i = ((float) imageWidth) / ((float) bitmap.getWidth());
		float imageHeight = i * (bitmap.getHeight());
		FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imageView.getLayoutParams();
		params.height = (int) imageHeight;
		params.width = (int) imageWidth;
		imageView.setLayoutParams(params);
		imageView.setImageResource(item);
	}
	
	public static float convertDpToPixel(float dp, Context context){
	    Resources resources = context.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    float px = dp * (metrics.densityDpi/160f);
	    return px;
	}

}*/


public class ItemsAdapter extends ArrayAdapter<Data>{

 //   Context context; 
    LayoutInflater inflater;
    int layoutResourceId;
    float imageWidth;
    
    Activity activity;
	int resource;
	List<Data> datas;
    
/*    public ItemsAdapter(Context context, int layoutResourceId, Integer[] items) {
        super(context, layoutResourceId, items);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        
        float width = ((Activity)context).getWindowManager().getDefaultDisplay().getWidth();
        float margin = (int)convertDpToPixel(10f, (Activity)context);
        // two images, three margins of 10dips
		imageWidth = ((width - (3 * margin)) / 2);
    }*/
	
	public ItemsAdapter(Activity activity, int resource, List<Data> objects) {
		super(activity, resource, objects);

		this.activity = activity;
		this.resource = resource;
		this.datas = objects;
		
        this.layoutResourceId = resource;
        
        float width = activity.getWindowManager().getDefaultDisplay().getWidth();
        float margin = (int)convertDpToPixel(10f, activity);
        // two images, three margins of 10dips
		imageWidth = ((width - (3 * margin)) / 2);
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
		
		LinearLayout row = (LinearLayout) convertView;
        ItemHolder holder;
        Data data = getItem(position);
        
		if (row == null) {
			holder = new ItemHolder();
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = (LinearLayout) inflater.inflate(layoutResourceId, parent, false);
            
            holder.itemImage = (ImageView)row.findViewById(R.id.item_image);
            holder.title = (TextView)row.findViewById(R.id.title);
			holder.description = (TextView)row.findViewById(R.id.description);
			
		} else {
			holder = (ItemHolder) row.getTag();
		}
		
		row.setTag(holder);
		holder.title.setText(data.title);
		holder.description.setText(data.description);
	    setImageBitmap(data.imgDraw, holder.itemImage);
	    
        return row;
    }

    public static class ItemHolder
    {
    	ImageView itemImage;
		TextView title;
		TextView description;
    }
	
    // resize the image proportionately so it fits the entire space
	private void setImageBitmap(Integer item, ImageView imageView){
		Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), item);
		float i = ((float) imageWidth) / ((float) bitmap.getWidth());
		float imageHeight = i * (bitmap.getHeight());
		LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageView.getLayoutParams();
		params.height = (int) imageHeight;
		params.width = (int) imageWidth;
		imageView.setLayoutParams(params);
		imageView.setImageResource(item);
	}
	
	public static float convertDpToPixel(float dp, Context context){
	    Resources resources = context.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    float px = dp * (metrics.densityDpi/160f);
	    return px;
	}

}