package com.parskavirarvand.loginshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edt_log_username =  findViewById(R.id.edt_log_username);
        final EditText edt_log_password =  findViewById(R.id.edt_log_password);
        Button btn_log_login =  findViewById(R.id.btn_log_login);
        Button btn_log_register =  findViewById(R.id.btn_log_register);

        btn_log_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edt_log_username.getText().toString();
                String password = edt_log_password.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                //String savedPassword = preferences.getString(password, "");
                //String savedUserName = preferences.getString(user, "");

                String userDetails = preferences.getString(user + password + "data","No information on that user.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",userDetails);
                editor.commit();

                Intent displayScreen = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(displayScreen);
                finish();

            }
        });


        btn_log_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerScreen);

            }
        });
    }


}
