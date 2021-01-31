package com.example.aesencryption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout;

    @BindView(R.id.gotoenc)
    Button gotoenc;
    @BindView(R.id.gotodec)
    Button gotodec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        firebaseAuth = FirebaseAuth.getInstance();

        logout = (Button)findViewById(R.id.out1);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });

    }

    private void Logout() {
        firebaseAuth.signOut();
        startActivity(new Intent(MainActivity.this, MainActivity1.class));
        finish();
    }


    @OnClick(R.id.gotoenc)
    public void setGotoenc(){
        Intent i=new Intent(MainActivity.this,Encryption.class);
        startActivity(i);
    }


    @OnClick(R.id.gotodec)
    public void setGotodec(){
        Intent i=new Intent(MainActivity.this,Decryption.class);
        startActivity(i);
    }

}