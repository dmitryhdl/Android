package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AuthFragment extends Fragment {

    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegister;


    public static AuthFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AuthFragment fragment = new AuthFragment();
        fragment.setArguments(args);
        return fragment;
    }

// класс View содержит различные интрефейсы необходимые для взаимодействия интрфейса экрана и java кода.
    private View.OnClickListener monEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isEmailValid() && isPasswordValid()) {
                Intent startProfileIntent =
                        new Intent(getActivity(),ProfileActivity.class); // Запуск класса ProfileActivity с помощью Intenta.

                startProfileIntent.putExtra(ProfileActivity.USER_KEY,
                        new User(mLogin.getText().toString(),mPassword.getText().toString()));
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
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }


    // Отображение на экране телефона метод onCreate
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fr_auth,container,false);

        // обращение к view элементам
        mLogin = v.findViewById(R.id.etLogin);
        mPassword = v.findViewById(R.id.etPassword);
        mEnter = v.findViewById(R.id.buttonEnter);
        mRegister = v.findViewById(R.id.buttonRegister);

        mEnter.setOnClickListener(monEnterClickListener);
        mRegister.setOnClickListener(monRegisterClickListener);

        return v;

    }
}