package com.example.unit_04_assessment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

class MessageViewHolder extends RecyclerView.ViewHolder {
    public static final String ANIMAL_NAME = "ANIMAL NAME";
    public static final String ANIMAL_IMAGE = "ANIMAL IMAGE";
    public static final String ANIMAL_DESCRIPTION = "ANIMAL DESCRIPTION";
    private TextView messageTextView;
    private ImageView messageImageView;



    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);

        messageImageView = itemView.findViewById(R.id.message_imageView);
        messageTextView = itemView.findViewById(R.id.message_TextView);
    }

    public void onBind(Message message){
        final String animalName = message.getAnimal();
        final String animalImage = message.getImage();
        final String animalDescription = message.getWiki();

        messageTextView.setText(message.getAnimal());
        Picasso.get().load(message.getImage()).into(messageImageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(ANIMAL_NAME,animalName);
                bundle.putString(ANIMAL_IMAGE,animalImage);
                bundle.putString(ANIMAL_DESCRIPTION,animalDescription);
                Intent intent = new Intent(itemView.getContext(),SecondActivity.class);
                intent.putExtras(bundle);

                itemView.getContext().startActivity(intent);
            }
        });
    }
}
