package ua.dp.itstep.fragmentscallback;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    EditText mEditTextFirstName, mEditTextLastName, mEditTextAge;
    FragmentListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof FragmentListener)) throw new AssertionError();
        mListener = (FragmentListener) context;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_blank, container, false);

        mEditTextFirstName = (EditText) v.findViewById(R.id.editTextFirstName);
        mEditTextLastName = (EditText) v.findViewById(R.id.editTextLastName);
        mEditTextAge = (EditText) v.findViewById(R.id.editTextAge);

        v.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                done();
            }
        });

        return v;
    }

    private void done() {

        Person person = new Person(mEditTextFirstName.getText().toString(),
                mEditTextLastName.getText().toString(),
                Integer.valueOf(mEditTextAge.getText().toString()));

        mListener.onFragmentFinished(person);
    }

    public interface FragmentListener {
        void onFragmentFinished(Person person);
    }

}
