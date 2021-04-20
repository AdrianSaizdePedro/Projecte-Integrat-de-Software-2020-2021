package com.example.lize.workers;

import android.os.Bundle;
import android.content.Intent;
import android.util.Patterns;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import com.example.lize.R;
import android.widget.Toast;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
        // Variables
        EditText nombre, apellidos, email, psw;
        Button signup;
        TextView login;
        boolean isNameValid, isEmailValid, isPasswordValid;
        TextInputLayout nameError,surnameError, emailError, passError;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_drawable_nav);
            setContentView(R.layout.activity_signup);

            nombre = findViewById(R.id.nombre);
            apellidos = findViewById(R.id.apellidos);
            email = findViewById(R.id.email);
            psw = findViewById(R.id.password);
            login = findViewById(R.id.login);
            signup = findViewById(R.id.signup);
            nameError = findViewById(R.id.nameError);
            surnameError = findViewById(R.id.surnameError);
            emailError = findViewById(R.id.emailError);
            passError = findViewById(R.id.passError);

            signup.setOnClickListener(v ->
            {
                if(SetValidation()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });

        }


    public boolean SetValidation() {
        // Validamos el nombre
        if (nombre.getText().toString().isEmpty()) {
            nameError.setError(getResources().getString(R.string.error_campo_vacio));
            Toast.makeText(getApplicationContext(), nameError.getError(), Toast.LENGTH_SHORT).show();
            isNameValid = false;
        } else if (nombre.getText().toString().length() >= 20) {
            nameError.setError(getResources().getString(R.string.demasiados_caracteres));
            Toast.makeText(getApplicationContext(), nameError.getError(), Toast.LENGTH_SHORT).show();
            isNameValid = false;
        } else  {
            isNameValid = true;
            nameError.setErrorEnabled(false);
        }

        // Validamos los apellidos
        if (apellidos.getText().toString().isEmpty()) {
            surnameError.setError(getResources().getString(R.string.error_campo_vacio));
            Toast.makeText(getApplicationContext(), surnameError.getError(), Toast.LENGTH_SHORT).show();
            isNameValid = false;
        } else if (nombre.getText().toString().length() >= 30) {
            surnameError.setError(getResources().getString(R.string.demasiados_caracteres));
            Toast.makeText(getApplicationContext(), surnameError.getError(), Toast.LENGTH_SHORT).show();
            isNameValid = false;
        } else  {
            isNameValid = true;
            surnameError.setErrorEnabled(false);
        }

        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            emailError.setError(getResources().getString(R.string.error_campo_vacio));
            isEmailValid = false;
            Toast.makeText(getApplicationContext(), emailError.getError(), Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            emailError.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
            Toast.makeText(getApplicationContext(), emailError.getError(), Toast.LENGTH_SHORT).show();
        } else  {
            isEmailValid = true;
            emailError.setErrorEnabled(false);
        }

        // Check for a valid password.
        if (psw.getText().toString().isEmpty()) {
            passError.setError(getResources().getString(R.string.error_campo_vacio));
            isPasswordValid = false;
            Toast.makeText(getApplicationContext(), passError.getError(), Toast.LENGTH_SHORT).show();
        } else if (psw.getText().length() < 6) {
            passError.setError(getResources().getString(R.string.error_invalid_pwd));
            isPasswordValid = false;
            Toast.makeText(getApplicationContext(), passError.getError(), Toast.LENGTH_SHORT).show();
        } else  {
            isPasswordValid = true;
            passError.setErrorEnabled(false);
        }

        if (isNameValid && isEmailValid && isPasswordValid) {
            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;

    }

}
