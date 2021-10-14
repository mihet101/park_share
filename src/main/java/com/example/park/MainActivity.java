package com.example.park;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText editloginText;
    private EditText editPassText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button)findViewById(R.id.LoginButton);
        editloginText = (EditText)findViewById(R.id.LoginEditText);
        editPassText = (EditText)findViewById(R.id.PasswordEditText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(editloginText.getText().toString().equals("myemail@temp.org") && editPassText.getText().toString().equals("passtemp")){
                    Intent intent;
                    intent = new Intent(MainActivity.this,tempActivity.class);
                    startActivity(intent);
                }
                else{
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(), "incorrect password", duration);
                    toast.show();
                }
            }
        });
    }
}