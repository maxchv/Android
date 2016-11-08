package com.example.android.firstfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {

    public static final String MESSAGE_KEY = "message_key";

    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String message = arguments.getString(MESSAGE_KEY);
            TextView tvMessage = (TextView) view.findViewById(R.id.message);
            tvMessage.setText(message);
        }

        return view;
    }

}
