package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity {

    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegister;

// класс View содержит различные интрефейсы необходимые для взаимодействия интрфейса экрана и java кода.
    private View.OnClickListener monEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        // todo Обработка нажатия по кнопке
        }
    };

    private View.OnClickListener monRegisterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // todo Обработка нажатия по кнопке
        }
    };

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