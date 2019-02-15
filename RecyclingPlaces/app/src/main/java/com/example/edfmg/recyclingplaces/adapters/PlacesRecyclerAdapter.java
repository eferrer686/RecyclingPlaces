package com.example.edfmg.recyclingplaces.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.request.RequestOptions;
import com.example.edfmg.recyclingplaces.R;
import com.example.edfmg.recyclingplaces.model.PlaceCard;
import com.example.edfmg.recyclingplaces.recyclingPlaceCard;

import java.util.List;

public class PlacesRecyclerAdapter extends RecyclerView.Adapter<PlacesRecyclerAdapter.PlacesRecordHolder>{

    private Context context;
    private List<PlaceCard> cards;
    RequestOptions options;

    public PlacesRecyclerAdapter(Context context, List<PlaceCard> cards) {
        this.context = context;
        this.cards = cards;

        options = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);
    }

    @NonNull
    @Override
    public PlacesRecordHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.place_card_item, viewGroup, false);

        final PlacesRecordHolder placesRecordHolder = new PlacesRecordHolder(view);

        placesRecordHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceCard placeCard = cards.get(placesRecordHolder.getAdapterPosition());
                Toast.makeText(context, placeCard.getName(), Toast.LENGTH_SHORT).show();
                Intent it = new Intent(context, recyclingPlaceCard.class);
                it.putExtra("place", placeCard);

                context.startActivity(it);
            }
        });

        return placesRecordHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesRecordHolder placesRecordHolder, int i) {

        placesRecordHolder.id.setText(cards.get(i).getId());
        placesRecordHolder.name.setText(cards.get(i).getName());
        placesRecordHolder.phone.setText(cards.get(i).getPhoneNumber());
        placesRecordHolder.street.setText(cards.get(i).getStreet());
        placesRecordHolder.streetNumber.setText(cards.get(i).getStreetNumber());
        placesRecordHolder.city.setText(cards.get(i).getCity());
        placesRecordHolder.web.setText(cards.get(i).getWebsite());
        placesRecordHolder.schedule.setText(cards.get(i).getSchedule());


    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public static class PlacesRecordHolder extends RecyclerView.ViewHolder{

        TextView id,name,street,streetNumber,phone,city,web,schedule;

        public PlacesRecordHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            phone = itemView.findViewById(R.id.phone);
            name = itemView.findViewById(R.id.name);
            streetNumber = itemView.findViewById(R.id.streetNumber);
            street = itemView.findViewById(R.id.street);
            city = itemView.findViewById(R.id.city);
            web = itemView.findViewById(R.id.web);
            schedule = itemView.findViewById(R.id.schedule);


        }
    }

}
