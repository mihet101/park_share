package com.example.parkshare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {
    Button updatePass, updateUser, updateUsernameButton;
    EditText curr_pass, new_pass, curr_username, new_username;
    TextView user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        updatePass = (Button) findViewById(R.id.ButtonResetPassword);
        updateUser = (Button) findViewById(R.id.ButtonResetUsername);

        updatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUpdatePassword();
            }
        });

        updateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUpdateUsername();
            }
        });
    }

    private void showUpdatePassword() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
        View view = LayoutInflater.from(AccountActivity.this).inflate(R.layout.dialog_update_pass, null);

        Button updatePasswordButton = (Button) view.findViewById(R.id.updatepass);
        curr_pass = (EditText)view.findViewById(R.id.currpass);
        new_pass = (EditText)view.findViewById(R.id.newpass);

        builder.setView(view);
        builder.create().show();

        updatePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = findViewById(R.id.StringPassword);
                if(curr_pass.getText().toString().equals(pass.getText().toString())) {
                    String old_pass_entered = curr_pass.getText().toString().trim();
                    String new_pass_entered = new_pass.getText().toString().trim();
                    updatePassword(new_pass_entered);
                }else {
                    Toast toast = Toast.makeText(AccountActivity.this, "Current password entered does not match, please try agian", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }

    private void showUpdateUsername() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
        View view = LayoutInflater.from(AccountActivity.this).inflate(R.layout.dialog_update_user, null);

        builder.setView(view);
        builder.create().show();
        Button updateUsernameButton = (Button) view.findViewById(R.id.updateuser);
        //curr_username = (EditText)view.findViewById(R.id.curruser);
        new_username = (EditText)view.findViewById(R.id.newuser);

        updateUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String old_user_entered = curr_username.getText().toString().trim();
                String new_user_entered = new_username.getText().toString().trim();
                updateUsername(new_user_entered, builder);
            }
        });


    }

    private void updatePassword(String newpass) {

        pass = (TextView) findViewById(R.id.StringPassword);
        pass.setText(newpass);
        Toast toast = Toast.makeText(AccountActivity.this, "Password has been updated", Toast.LENGTH_LONG); //this is the ListActivity
        toast.show();
    }

    private void updateUsername(String newuser, AlertDialog.Builder build) {
        user = (TextView) findViewById(R.id.StringUsername);
        user.setText(newuser);
        Toast toast = Toast.makeText(AccountActivity.this, "Username has been updated", Toast.LENGTH_LONG); //this is the ListActivity
        toast.show();
    }
}