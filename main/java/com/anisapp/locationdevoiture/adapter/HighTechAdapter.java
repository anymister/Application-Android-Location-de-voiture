package com.anisapp.locationdevoiture.adapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.anisapp.locationdevoiture.Voiture;

import java.util.List;
import com.anisapp.locationdevoiture.R;
import com.anisapp.locationdevoiture.models.HighTech;

public class HighTechAdapter extends BaseAdapter {

    private Context context;
    private List<HighTech> highTechItemList;
    private LayoutInflater inflater;
    public HighTechAdapter(Context context, List<HighTech> highTechItemList){
        this.context=context;
        this.highTechItemList=highTechItemList;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return highTechItemList.size();
    }

    @Override
    public HighTech getItem(int position) {
        return highTechItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.adapter_annonce,null);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        HighTech currentItem=getItem(i);
        final String itemName=currentItem.getName();
        //String memonic=currentItem.getMemoning();
        final int itemPrice=currentItem.getPrice();
        // ImageView itemIconview=view.findViewById(item_icon);

        //   String ressourcename=memonic;
        //  final int resID=context.getResources().getIdentifier(ressourcename,"Drawable",context.getPackageName());
        //itemIconview.setImageResource(resID);
        TextView itemNameView =view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);
        TextView itemPriceView =view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice+" $");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity= new Intent(context.getApplicationContext(),Voiture.class);

                context.startActivity(otherActivity);


                Toast.makeText(context,"Vous essayer de louer "+itemName+"Pour le prix de "+itemPrice+"$",Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}
