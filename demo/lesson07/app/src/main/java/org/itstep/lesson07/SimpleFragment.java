package org.itstep.lesson07;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleFragment extends Fragment {

    public static final String TEXT_PARAM = "text";
    private String text;

    public static Fragment newInstance(String parameter){
        Fragment fragment = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TEXT_PARAM, parameter);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Bundle arguments = getArguments();
        text = arguments.getString(TEXT_PARAM, "Default text");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(text);
        return view;
    }
}