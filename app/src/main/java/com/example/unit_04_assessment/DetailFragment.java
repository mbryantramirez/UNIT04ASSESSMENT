package com.example.unit_04_assessment;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ANIMAL_NAME = "ANIMAL NAME";
    private static final String ANIMAL_IMAGE = "ANIMAL IMAGE";
    private static final String ANIMAL_DESCRIPTION = "ANIMAL DESCRIPTION";
    private String animalName;
    private String animalImage;
    private String animalDescription;
    private View rootView;
    private OnFragmentInteractionListener fragmentNavigator;
    private TextView animalNameTextView;
    private ImageView animalImageView;
    private Button websiteButton;



    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String animalName, String animalImage,String animalDescription) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ANIMAL_NAME, animalName);
        args.putString(ANIMAL_IMAGE, animalImage);
        args.putString(ANIMAL_DESCRIPTION, animalDescription);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DetailFragment.OnFragmentInteractionListener) {
            fragmentNavigator = (DetailFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animalName = getArguments().getString(ANIMAL_NAME);
            animalImage = getArguments().getString(ANIMAL_IMAGE);
            animalDescription = getArguments().getString(ANIMAL_DESCRIPTION);
        }
    }

    public void addMessageToListener(String website){
        if (fragmentNavigator != null){
            fragmentNavigator.onFragmentInteraction(website);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_detail, container, false);

        animalNameTextView = rootView.findViewById(R.id.animalName_textView);
        animalImageView = rootView.findViewById(R.id.animalImage_imageView);
        websiteButton = rootView.findViewById(R.id.website_button);

        animalNameTextView.setText(animalName);
        Picasso.get().load(animalImage).into(animalImageView);

        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMessageToListener(animalDescription);

            }
        });

        return  rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentNavigator = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String website);
    }



}
