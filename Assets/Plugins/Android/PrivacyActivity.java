package com.gamesofton.privacy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.widget.TextView;

public class PrivacyActivity extends Activity {

    Boolean anInt = false;

    // Setup activity layout
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        final SharedPreferences base = getSharedPreferences("base",MODE_PRIVATE);
        anInt = base.getBoolean("isFirstStart",true);

        if (anInt==true){
            AlertDialog.Builder dialog=new AlertDialog.Builder(this);
            dialog.setTitle("Privacy Policy");
            dialog.setMessage(Html.fromHtml("Privacy Policy,<br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
                    +"<a href=\"http://www.google.com\">google</a><br>"
            ));
            dialog.setCancelable(false);
            dialog .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            });

            dialog.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = base.edit();
                    editor.putBoolean("isFirstStart",false);
                    editor.commit();

                    startUnity();

                }
            });
            AlertDialog alertDialog = dialog.create();
            alertDialog.show();

            ((TextView) alertDialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());

        } else {

            startUnity();

        }

    }

    protected void startUnity()
    {

        Intent intent = new Intent(this, com.unity3d.player.UnityPlayerActivity.class);
        startActivity(intent);

        this.finish();

    }

}