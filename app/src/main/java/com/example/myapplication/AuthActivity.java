package com.example.myapplication;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

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
            // переход в приложение
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