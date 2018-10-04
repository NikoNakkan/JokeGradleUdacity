package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lib.JokeLibrary;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

//Here we have the implementation of the free fragment.I figured that it would take less code if I used
//the implementation of the main as the free flavour ,instead of copying pasting all over again.
//consenquently the strings of the main represent the values of the free flavour strings etc.

public class MainActivityFragment extends Fragment {
    OnButtonClickListener mCallback;

    public MainActivityFragment() {
    }

    public interface OnButtonClickListener {
        void onButtonClickListener();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        try {
            mCallback = (OnButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnButtonClickListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Button but=root.findViewById(R.id.jokebutton);
        final JokeLibrary jokeLibrary=new JokeLibrary();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String s=jokeLibrary.getJoke();
               mCallback.onButtonClickListener();
            }
        });
        return root;

    }

}
