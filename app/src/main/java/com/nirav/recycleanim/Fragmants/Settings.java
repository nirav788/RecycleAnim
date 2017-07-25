package com.nirav.recycleanim.Fragmants;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nirav.recycleanim.MainActivity;
import com.nirav.recycleanim.R;

/**
 * Created by Developer on 21-09-2016.
 */
public class Settings extends Fragment {

    View view;

    public Settings() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.setting, container, false);



        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Settings");

        // Inflate the layout for this fragment
        return view;
    }
}