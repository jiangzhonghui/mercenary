package com.zebia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.zebia.loaders.RESTLoader;
import com.zebia.model.Login;

import java.util.List;

public class LoginActivity extends FragmentActivity implements View.OnClickListener, View.OnKeyListener,
        LoaderManager.LoaderCallbacks<RESTLoader.RESTResponse> {

    private static final String LOG_TAG = LoginActivity.class.getName();
    private static final String ARGS_URI = "ARGS_URI";
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

//        etUsername.setOnKeyListener(this);
//        etEmail.setOnKeyListener(this);
//        etCity.setOnKeyListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent launchActivityIntent = null;

        switch (v.getId()) {
            case R.id.bt_login:

                getSupportLoaderManager().restartLoader(1, getBundle(), this);

//                launchActivityIntent = new Intent().setClass(this, SongActivity.class);
//                startActivity(launchActivityIntent);
                break;
        }
    }

    private Bundle getBundle() {
        // This is our REST action.
        Uri twitterSearchUri = Uri.parse("http://10.1.1.57:3001/user");
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

            Intent launchActivityIntent = new Intent().setClass(this, SongActivity.class);
            startActivity(launchActivityIntent);

            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            // For really complicated JSON decoding I usually do my heavy lifting
            // Gson and proper model classes, but for now let's keep it simple
            // and use a utility method that relies on some of the built in
            // JSON utilities on Android.
            //List<Item> tweets = parse(json);

            // Load our list adapter with our Tweets.
            //mAdapter.clear();
//            for (Item tweet : tweets) {
//                mAdapter.add(tweet);
//            }
        } else {
            Toast.makeText(this, "Failed to log in", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<RESTLoader.RESTResponse> restResponseLoader) {
    }
}
