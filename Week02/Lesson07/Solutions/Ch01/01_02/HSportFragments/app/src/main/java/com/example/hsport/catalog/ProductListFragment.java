package com.example.hsport.catalog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;


public class ProductListFragment extends Fragment {

    private ListFragmentListener mListener;
    private List<Product> products = DataProvider.productList;

    public ProductListFragment() {
    }

    public static ProductListFragment newInstance(String param1, String param2) {
        ProductListFragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);

        String[] items = getResources().getStringArray(R.array.clothing);
        ProductListAdapter adapter = new ProductListAdapter(
                getContext(), R.layout.list_item, products);
        ListView lv = (ListView) view.findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String uriString = "http://hplussport.com/catalog/productid/" + position;
                Uri uri = Uri.parse(uriString);
                mListener.onListItemClick(uri);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListFragmentListener) {
            mListener = (ListFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ListFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface ListFragmentListener {
        void onListItemClick(Uri uri);
    }
}
