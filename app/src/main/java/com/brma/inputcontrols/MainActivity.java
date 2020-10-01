package com.brma.inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText_Main);
        if (editText != null)
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                //If view is found, set the listener for editText.
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND) {
                        dialNumber ();
                        handled = true;
                    }
                    return handled;
                }

                private void dialNumber() {
                    //dialNumber method -- find the editText_main view. 
                    
                    EditText editText = findViewById(R.id.editText_Main);
                    String phoneNum = null;
                    
                    //If editText field is not null, concatenate "tel:" with the phone number string
                    if (editText != null) phoneNum = "tel:" + editText.getText().toString();

                    //Optional: log the concatenated phone number for dialing.
                    Log.d(TAG, "dialNumber: " + phoneNum);

                    //specifying the intent and setting the data for the intent to the phone number.
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(phoneNum));
                    
                    //If the intent resolves to a package, start activity with the intent
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Log.d("ImplicitIntents", "Can't handle this!");
                    }
                }
            });
    }
}
