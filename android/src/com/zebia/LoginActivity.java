package com.zebia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements View.OnClickListener, View.OnKeyListener {

    private Button btnLogin;
    private EditText etUsername;
    private EditText etEmail;
    private EditText etCity;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin = (Button) findViewById(R.id.bt_login);
        btnLogin.setOnClickListener(this);

        etUsername = (EditText) findViewById(R.id.et_login_username);
        etEmail = (EditText) findViewById(R.id.et_login_email);
        etCity = (EditText) findViewById(R.id.et_login_city);

        etUsername.setOnKeyListener(this);
        etEmail.setOnKeyListener(this);
        etCity.setOnKeyListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent launchActivityIntent = null;

        switch (v.getId()) {
            case R.id.bt_login:
                launchActivityIntent = new Intent().setClass(this, SongActivity.class);
                startActivity(launchActivityIntent);
                break;
        }
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        btnLogin.setEnabled(
                etUsername.getText().length() != 0 &&
                etEmail.getText().length() != 0 &&
                etCity.getText().length() != 0);

        return true;
    }
}
