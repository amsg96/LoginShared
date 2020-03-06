package com.parskavirarvand.loginshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText edt_reg_username = findViewById(R.id.edt_reg_username);
        final EditText edt_reg_password = findViewById(R.id.edt_reg_password);
        Button btn_reg_register = findViewById(R.id.btn_reg_register);

        btn_reg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String newUser  = edt_reg_username.getText().toString();
                String newPassword = edt_reg_password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newUser,newUser);
                editor.commit();
                editor.putString(newPassword, newPassword);
                editor.commit();
                editor.putString(newUser + newPassword + "data", newUser + "\n");
                editor.commit();

                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }
}
