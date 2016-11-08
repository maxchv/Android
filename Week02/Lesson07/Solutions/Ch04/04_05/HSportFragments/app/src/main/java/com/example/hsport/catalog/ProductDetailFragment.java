package com.example.hsport.catalog;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

public class ProductDetailFragment extends Fragment {
    private static final String ARG_PRODUCT_ID = "productId";

    private Product mProduct;

    public ProductDetailFragment() {
    }

    public static ProductDetailFragment newInstance(String productId) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PRODUCT_ID, productId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String productId = getArguments().getString(ARG_PRODUCT_ID);
            mProduct = DataProvider.productMap.get(productId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_detail, container, false);

        TextView tv = (TextView) view.findViewById(R.id.nameText);
        tv.setText(mProduct.getName());

        TextView descView = (TextView) view.findViewById(R.id.descriptionText);
        descView.setText(mProduct.getDescription());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(mProduct.getPrice());
        TextView priceText = (TextView) view.findViewById(R.id.priceText);
        priceText.setText(price);

        ImageView iv = (ImageView) view.findViewById(R.id.imageView);
        Bitmap bitmap = getBitmapFromAsset(mProduct.getProductId());
        iv.setImageBitmap(bitmap);

        return view;
    }

    private Bitmap getBitmapFromAsset(String productId) {
        AssetManager assetManager = getContext().getAssets();
        InputStream stream = null;

        try {
            stream = assetManager.open(productId + ".png");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
