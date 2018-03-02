package com.example.ajdin.zavrsnirad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.example.ajdin.zavrsnirad.model.Artikli;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;

/**
 * Created by ajdin on 28.2.2018..
 */

public class MenuListAdapter extends ArrayAdapter<Artikli> {
    ArrayList<Artikli> lista;
    Context context;
    int resource;

    public MenuListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Artikli> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.lista=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){

            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_row,null,true);

        }
        Artikli artikli=getItem(position);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView2);
        Glide.with(context).load("http://192.168.1.103/artikli/"+artikli.getImage())
                .asBitmap()
                .encoder(new BitmapEncoder(Bitmap.CompressFormat.PNG,100))
                .format(PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);



        TextView naziv_artikla=(TextView)convertView.findViewById(R.id.naziv_artikla);
        naziv_artikla.setText(artikli.getNaziv());
        TextView cijena_artikla=(TextView)convertView.findViewById(R.id.cijena_artikla);
        cijena_artikla.setText(artikli.getCijena());
        TextView jedinica_mjere=(TextView)convertView.findViewById(R.id.jedinica_mjere);
        jedinica_mjere.setText(artikli.getBarkod());

        return convertView;
    }
}
