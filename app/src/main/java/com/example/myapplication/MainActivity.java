package com.example.wydarzenie_w_sudetach;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;
import android.util.Patterns;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button polub = findViewById(R.id.Polub);
        Button usun = findViewById(R.id.Usun);
        EditText passord = findViewById(R.id.Password);
        EditText rep_pas = findViewById(R.id.Rep_pas);
        Button zapisz = findViewById(R.id.Zapisz);
        Button zobacz = findViewById(R.id.Zobacz);
        TextView komunikat = findViewById(R.id.Komunikat);
        TextView licznik = findViewById(R.id.Licznik);
        EditText email =findViewById(R.id.Email);
        EditText password = findViewById(R.id.Password);
        EditText Rep_pas = findViewById(R.id.Rep_pas);
        final int[] counter = {0};

        polub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = counter[0]++;
                licznik.setText(String.valueOf(counter[0] + " polubień"));

            }
        });

        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter[0]<1){
                    Toast.makeText(MainActivity.this, "Nie można dać minusowej ilości polubień", Toast.LENGTH_SHORT).show();
                }else {
                    counter[0]--;
                }

                licznik.setText(String.valueOf(counter[0] + " polubień"));
            }
        });

        zobacz.setEnabled(false);

        zapisz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String emaill = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String rep_pass = rep_pas.getText().toString().trim();


                if(emaill.isEmpty()){
                    komunikat.setText("Nie wprowadzono adresu e-mail");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emaill).matches()) {
                    komunikat.setText("Nieprawidłowy adres e-mail");
                }else if (pass.isEmpty()) {
                    komunikat.setText("Nie wprowadzono hasła");
                } else if (rep_pass.isEmpty()) {
                    komunikat.setText("Nie wprowadzono ponownie hasła");
                } else if (!pass.equals(rep_pass)) {
                    komunikat.setText("Hasła się różnią");
                }else {
                    komunikat.setText("Zarejestrowano " + emaill);
                    zobacz.setEnabled(true);
                }
            }
        });

        zobacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e_mail = email.getText().toString().trim();
                komunikat.setText(e_mail);
                zobacz.setEnabled(false);
            }
        });

    };
}
