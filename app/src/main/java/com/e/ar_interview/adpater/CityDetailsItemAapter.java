package com.e.ar_interview.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.e.ar_interview.R;
import com.e.ar_interview.model.CityDetailsItem;

import java.util.List;

/**
 * Created by shalvi on 9/2/2019.
 */
public class CityDetailsItemAapter extends RecyclerView.Adapter<CityDetailsItemAapter.CityViewHolder> {

    Context mCtx;
    List<CityDetailsItem> cityDetailList;

    public CityDetailsItemAapter(Context mCtx, List<CityDetailsItem> cityDetailList) {
        this.mCtx = mCtx;
        this.cityDetailList = cityDetailList;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.city_details_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        CityDetailsItem city = cityDetailList.get(holder.getAdapterPosition());
        if (city.getTitle() != null || city.getDescription() != null || city.getImageHref() != null) {
            holder.txtDescription.setText("Description : "+city.getDescription());
            holder.txtTitle.setText(city.getTitle());

            Glide.with(mCtx)
                    .load(city.getImageHref())
                    .into(holder.imageView);


        } else {
            cityDetailList.remove(holder.getAdapterPosition());

        }
    }


    @Override
    public int getItemCount() {
        return cityDetailList.size();
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtDescription, txtTitle;

        public CityViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cityImg);
            txtDescription = itemView.findViewById(R.id.descriptionTxt);
            txtTitle = itemView.findViewById(R.id.titleTxt);
        }
    }
}
