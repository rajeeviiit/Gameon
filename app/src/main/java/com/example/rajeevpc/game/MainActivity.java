package com.example.rajeevpc.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView mTextFieldCondition;
    Button mButtonSunny,getmButtonFoggy;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onStart(){
        super.onStart();
        mTextFieldCondition=(TextView)findViewById(R.id.textViewcondition);
        mButtonSunny=(Button)findViewById(R.id.buttonsunny);
        getmButtonFoggy=(Button)findViewById(R.id.buttonfoggy);
        mRef=new Firebase("https://crowd-weather.firebaseio.com/condition");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text =dataSnapshot.getValue(String.class);
                mTextFieldCondition.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mButtonSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mRef.setValue("Sunny");

            }
        });
        getmButtonFoggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("Foggy");
            }
        });
    }
}
