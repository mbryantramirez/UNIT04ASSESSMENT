package com.example.unit_04_assessment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.unit_04_assessment.MessageViewHolder.ANIMAL_DESCRIPTION;
import static com.example.unit_04_assessment.MessageViewHolder.ANIMAL_IMAGE;
import static com.example.unit_04_assessment.MessageViewHolder.ANIMAL_NAME;

public class SecondActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String animalName = intent.getStringExtra(ANIMAL_NAME);
        String animalImage = intent.getStringExtra(ANIMAL_IMAGE);
        String animalURL = intent.getStringExtra(ANIMAL_DESCRIPTION);


        DetailFragment detailFragment = DetailFragment.newInstance(animalName,animalImage,animalURL);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_container,detailFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(String website) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(website));
        startActivity(browserIntent);



    }
}
