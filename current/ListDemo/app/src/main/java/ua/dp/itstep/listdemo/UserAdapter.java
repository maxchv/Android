package ua.dp.itstep.listdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 23.10.2016.
 */
public class UserAdapter extends ArrayAdapter<User>{
    public UserAdapter(Context userList, ArrayList<User> users) {
        super(userList, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user, parent, false);
        }

        TextView firstName = (TextView) convertView.findViewById(R.id.firstName);
        TextView lastName = (TextView) convertView.findViewById(R.id.lastName);
        ImageView photo = (ImageView) convertView.findViewById(R.id.photo);

        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        photo.setImageResource(user.getPhoto());

        return convertView;
    }
}
