package com.example.lionel.alivo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lionel on 29/03/17.
 */

public class SignUpUserActivity extends AppCompatActivity {
    private static final String TAG = "SignUpUserActivity";

    @Bind(R.id.sign_up_nom_utilisateur) EditText nom_utilisateur;
    @Bind(R.id.sign_up_numero) EditText numero;
    @Bind(R.id.sign_up_button) Button signupButton;
    //@Bind(R.id.sign_up_login) TextView loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupuser);
        ButterKnife.bind(this);

        signupButton.setOnClickListener(new View.OnClickListener() { //au clic du bouton s'inscrire
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        /*loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });*/
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUpUserActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Création de compte...");
        progressDialog.show();

        String name = nom_utilisateur.getText().toString();
        String mobile = numero.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    /*En cas de succès de création de compte*/
    public void onSignupSuccess() {
        signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    /*En cas d'échec de création de compte*/
    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Veuillez réessayer", Toast.LENGTH_LONG).show();
        signupButton.setEnabled(true);
    }

    /*vérifie si les informations saisies sont fiables*/
    public boolean validate() {
        boolean valid = true;

        String name = nom_utilisateur.getText().toString();
        String mobile = numero.getText().toString();

        if (name.isEmpty() || name.length() < 4) {
            nom_utilisateur.setError("au moins 4 caractères");
            valid = false;
        } else {
            nom_utilisateur.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=13) {
            numero.setError("Entrer un numéro valide (00229...)");
            valid = false;
        } else {
            numero.setError(null);
        }

        return valid;
    }
}
