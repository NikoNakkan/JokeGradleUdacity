package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lib.JokeLibrary;
import com.udacity.gradle.builditbigger.R;

//Here I implement the Paid version fragment where I link it with the new Paid fragment layout
//I also have on the values folder the proper Strings to thanks the costumer for his/her purchase

/**
 * A placeholder fragment containing a simple view.
 */
public class PaidMainActivityFragment extends Fragment {
    com.udacity.gradle.builditbigger.MainActivityFragment.OnButtonClickListener mCallback;

    public PaidMainActivityFragment() {
    }

    public interface OnButtonClickListener {
        void onButtonClickListener();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        try {
            mCallback = (com.udacity.gradle.builditbigger.MainActivityFragment.OnButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnButtonClickListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.paid_fragment_main, container, false);



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
