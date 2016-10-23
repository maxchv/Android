package ua.dp.itstep.listdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class UsingMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("UsingMenu", "Selected");
        switch (item.getItemId()){
            case R.id.open:
                AlertDialog.Builder adb = new AlertDialog.Builder(this);
                adb.setTitle("title").setIcon(R.mipmap.contact).setMessage("Message").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UsingMenu.this, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                adb.show();
                break;
            case R.id.save:
                AlertDialog.Builder adb2 = new AlertDialog.Builder(this);
                adb2//.setTitle("title")
                        //.setIcon(R.mipmap.contact)
                        .setView(getLayoutInflater().inflate(R.layout.user_dialog, null))
                        //.setMessage("Message")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UsingMenu.this, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                adb2.show();
            case R.id.ntify:
                Notification.Builder builder = new Notification.Builder(this);

                ////////////////////// callback
                Context context = getApplicationContext();

                Intent notificationIntent = new Intent(context, MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(context,
                        0, notificationIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT);

                Resources res = context.getResources();
                //////////////////////
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(contentIntent)
                        .setTicker("Ticker text")
                        .setContentText("Text")
                        .setContentTitle("Title");
                Notification notification = builder.build();
                NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(101, notification);

                break;
        }
        return true;
    }
}
