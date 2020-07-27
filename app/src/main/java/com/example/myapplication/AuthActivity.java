package com.example.myapplication;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


import static com.example.myapplication.ProfileActivity.EMAIL_KEY;
import static com.example.myapplication.ProfileActivity.PASSWORD_KEY;

public class AuthActivity extends AppCompatActivity {

    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegister;

// класс View содержит различные интрефейсы необходимые для взаимодействия интрфейса экрана и java кода.
    private View.OnClickListener monEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isEmailValid() && isPasswordValid()) {
                Intent startProfileIntent =
                        new Intent(AuthActivity.this,ProfileActivity.class); // Запуск класса ProfileActivity с помощью Intenta.

                startProfileIntent.putExtra(ProfileActivity.EMAIL_KEY,mLogin.getText().toString());
                startProfileIntent.putExtra(ProfileActivity.PASSWORD_KEY,mPassword.getText().toString());
                startActivity(startProfileIntent);


            }else{
                ShowMessage(R.string.login_input_error);
            }
        }
};
// Метод проверки Логина на корректность
    private boolean isEmailValid() {
        return !TextUtils.isEmpty(mLogin.getText())
                && Patterns.EMAIL_ADDRESS.matcher(mLogin.getText()).matches();

    }

    private View.OnClickListener monRegisterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    // Метод проверки Пароля на корректность
    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(mPassword.getText());

    }

    /**
     * Метод исключения
     *
      */

    private void ShowMessage(@StringRes int string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }


    // Отображение на экране телефона метод onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_auth);

        // обращение к view элементам
        mLogin = findViewById(R.id.etLogin);
        mPassword = findViewById(R.id.etPassword);
        mEnter = findViewById(R.id.buttonEnter);
        mRegister = findViewById(R.id.buttonRegister);

        mEnter.setOnClickListener(monEnterClickListener);
        mRegister.setOnClickListener(monRegisterClickListener);




    }
}