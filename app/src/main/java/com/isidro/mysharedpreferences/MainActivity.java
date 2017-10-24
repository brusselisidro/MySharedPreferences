package com.isidro.mysharedpreferences;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnSave, btnshow;
    TextView display;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername=(EditText) findViewById(R.id.editText);
        etPassword=(EditText) findViewById(R.id.editText3);
        btnSave=(Button) findViewById(R.id.btn_save);
        btnSave=(Button) findViewById(R.id.btn_show);
        display=(TextView) findViewById(R.id.textView3);
        preferences= getPreferences(Context.MODE_PRIVATE);
    }


    public void SaveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data is Saved!", Toast.LENGTH_SHORT).show();
    }


    public void ShowInfo(View view){
        String user= preferences.getString("username","");
        String pass= preferences.getString("password","");
        display.setText("The Password of " + user + " is " + pass);

    }
}


