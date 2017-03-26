package com.example.root.ocps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Prashant Pratap on 26-02-2017.
 */

public class voterLogin extends Activity {

    Spinner spn_profile,spn_vote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voter_login);

        spn_profile = (Spinner)findViewById(R.id.c_spinner);
        spn_vote = (Spinner)findViewById(R.id.v_spinner);


        ArrayList<String> Values = new ArrayList<String>();
        Values.add("Select Post");
        Values.add("Hostel-President");
        Values.add("Hostel-Vice President");
        Values.add("College-President");
        Values.add("College-Vice President");
        ArrayAdapter<String> my_adp = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Values);

        spn_profile.setAdapter(my_adp);
        spn_vote.setAdapter(my_adp);

    }




    public void candidate_profile(View view) {

        LinearLayout l = (LinearLayout)findViewById(R.id.profile_layout);
        l.setVisibility(view.VISIBLE);

    }

    public void vote(View view) {

        LinearLayout l = (LinearLayout)findViewById(R.id.vote_layout);
        l.setVisibility(view.VISIBLE);
    }

    public void view_list_for_vote(View view) {

        Toast.makeText(this,"Please wait",Toast.LENGTH_SHORT).show();
        try {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("A List of all candidates for selected post will appear along with their election symbol, click on the VOTE Button to whom you want to vote");
            builder.setCancelable(false);
            builder.setTitle("Message");

            AlertDialog alert11 = builder.create();
            alert11.show();


           // Thread.sleep(10);


        }
        catch (Exception e)
        {

        }

        Intent i = new Intent(this,vote_now.class);
        startActivity(i);

    }

    public void view_profile(View view) {

        Intent i = new Intent(this,view_candidate_profile.class);
        startActivity(i);
    }
}
