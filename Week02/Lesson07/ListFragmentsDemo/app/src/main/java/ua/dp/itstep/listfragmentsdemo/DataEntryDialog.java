package ua.dp.itstep.listfragmentsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by max on 10.11.2016.
 */

public class DataEntryDialog extends DialogFragment {

    public static final String PERSON_KEY = "PERSON_KEY";
    @BindView(R.id.button_ok)
    Button mButtonOk;

    @BindView(R.id.button_cancel)
    Button mButtonCancel;

    @BindView(R.id.editTextFirstName)
    TextView mEditTextFirstName;

    @BindView(R.id.editTextLastName)
    TextView mEditTextLastName;

    @BindView(R.id.editTextPhone)
    TextView mEditTextPhone;
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
        mListener = (DataEntryListener)activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.data_entry_dialog, container, false).getRootView();
        ButterKnife.bind(this, view);

        final Person person = getArguments().getParcelable(PERSON_KEY);

        mEditTextFirstName.setText(person.getFirstName());
        mEditTextLastName.setText(person.getLastName());
        mEditTextPhone.setText(person.getPhone());

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person(mEditTextFirstName.getText().toString(),
                                      mEditTextLastName.getText().toString(),
                                      mEditTextPhone.getText().toString(), 0);
                mListener.dataEntryCompleted(p);
                dismiss();
            }
        });
        return view;
    }

    public interface DataEntryListener {
        void dataEntryCompleted(Person person);
    }

}
