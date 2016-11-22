package ua.dp.itstep.usingframes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailActivityFragment extends Fragment {


    private static final String TEXT_TAG = "text_tag";

    public DetailActivityFragment() {
        // Required empty public constructor
    }

    public static DetailActivityFragment newInstance(String text) {

        Bundle args = new Bundle();

        args.putString(TEXT_TAG, text);

        DetailActivityFragment fragment = new DetailActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_activity, container, false);
        TextView tv = (TextView) v.findViewById(R.id.textViewDetails);
        if(getArguments() != null) {
            tv.setText(getArguments().getString(TEXT_TAG));
        }
        return v;
    }

}
