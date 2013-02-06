package com.zebia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;
import com.zebia.loaders.RESTLoader;
import com.zebia.model.Login;

public class LoginActivity extends FragmentActivity implements View.OnClickListener, View.OnKeyListener,
        LoaderManager.LoaderCallbacks<RESTLoader.RESTResponse> {

    private static final String LOG_TAG = LoginActivity.class.getName();
    private static final String ARGS_URI = "ARGS_URI";
    public static final String USER_MAIL_LOGIN = "USER_MAIL_LOGIN";
    private Button btnLogin;
    private EditText etUsername;
    private EditText etEmail;
    private EditText etCity;
    private SharedPreferences sharedPreferences;

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

//        etUsername.setOnKeyListener(this);
//        etEmail.setOnKeyListener(this);
//        etCity.setOnKeyListener(this);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String login = sharedPreferences.getString(USER_MAIL_LOGIN, "NONE-");
        if (!"NONE-".equals(login)) {
            startActivity();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                    getSupportLoaderManager().restartLoader(1, getBundle(), this);
                break;
        }
    }

    private Bundle getBundle() {

        String ip = sharedPreferences.getString(SettingsActivity.PREF_IP, "");
        String port = sharedPreferences.getString(SettingsActivity.PREF_PORT, "3000");

        Uri twitterSearchUri = Uri.parse("http://" + ip + ":" + port + "/user");

        Bundle params = new Bundle();

        Login login = new Login(etCity.getText().toString(), etEmail.getText().toString(), etUsername.getText().toString());
        String json = login.toJson();
        params.putString("BODY", json);

        Bundle args = new Bundle();
        args.putParcelable(ARGS_URI, twitterSearchUri);
        args.putParcelable("ARGS_PARAMS", params);
        return args;
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        btnLogin.setEnabled(
                etUsername.getText().length() != 0 &&
                        etEmail.getText().length() != 0 &&
                        etCity.getText().length() != 0);

        return true;
    }


    @Override
    public Loader<RESTLoader.RESTResponse> onCreateLoader(int i, Bundle bundle) {
        if (bundle != null && bundle.containsKey(ARGS_URI) && bundle.containsKey("ARGS_PARAMS")) {
            Uri action = bundle.getParcelable(ARGS_URI);
            Bundle params = bundle.getParcelable("ARGS_PARAMS");

            return new RESTLoader(this, RESTLoader.HTTPVerb.POST, action, params);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<RESTLoader.RESTResponse> restResponseLoader, RESTLoader.RESTResponse data) {

        int code = data.getCode();

        // Check to see if we got an HTTP 200 code and have some data.
        if (code == 201) {
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
            prefEditor.putString(USER_MAIL_LOGIN, etEmail.getText().toString());
            prefEditor.commit();

            startActivity();

            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to log in", Toast.LENGTH_SHORT).show();
        }
    }

    private void startActivity() {
        Intent launchActivityIntent = new Intent().setClass(this, SongActivity.class);
        startActivity(launchActivityIntent);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<RESTLoader.RESTResponse> restResponseLoader) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_loging, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_preferences_song:
                Intent launchPreferencesIntent = new Intent().setClass(this, SettingsActivity.class);
                startActivityForResult(launchPreferencesIntent, 1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
