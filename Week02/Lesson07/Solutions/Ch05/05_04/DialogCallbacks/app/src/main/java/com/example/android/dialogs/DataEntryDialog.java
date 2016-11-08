package com.example.android.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DataEntryDialog extends DialogFragment{

    public static final String PERSON_KEY = "PERSON_KEY";
    EditText etFirstName, etLastName, etAge;
    private DataEntryListener mListener;

    public static DataEntryDialog newInstance(Person person) {

        Bundle args = new Bundle();
        args.putParcelable(PERSON_KEY, person);
        DataEntryDialog fragment = new DataEntryDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (DataEntryListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.data_entry_dialog,
                container, false);

        etFirstName = (EditText) rootView.findViewById(R.id.textFirstName);
        etLastName = (EditText) rootView.findViewById(R.id.textLastName);
        etAge = (EditText) rootView.findViewById(R.id.textAge);

        Person person = getArguments().getParcelable(PERSON_KEY);
        etFirstName.setText(person.getFirstName());
        etLastName.setText(person.getLastName());
        etAge.setText(String.valueOf(person.getAge()));

        Button btnOk = (Button) rootView.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        Button btnCancel = (Button) rootView.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return rootView;
    }

    private void saveData() {
        Person person = new Person();
        person.setFirstName(etFirstName.getText().toString());
        person.setLastName(etLastName.getText().toString());
        person.setAge(Integer.valueOf(etAge.getText().toString()));

        mListener.onDataEntryComplete(person);
        dismiss();
    }

    public interface DataEntryListener {
        void onDataEntryComplete(Person person);
    }
}
