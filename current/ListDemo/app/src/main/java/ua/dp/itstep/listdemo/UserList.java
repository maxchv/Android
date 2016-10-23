package ua.dp.itstep.listdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("First", "Last", "+3 8 095 123 45 67", R.mipmap.contact));
        users.add(new User("First", "Last", "+3 8 095 123 45 67", R.mipmap.contact));
        users.add(new User("First", "Last", "+3 8 095 123 45 67", R.mipmap.contact));
        users.add(new User("First", "Last", "+3 8 095 123 45 67", R.mipmap.contact));

        UserAdapter adapter = new UserAdapter(this, users);

        ListView userList = (ListView) findViewById(R.id.userList);
        userList.setAdapter(adapter);
    }
}
