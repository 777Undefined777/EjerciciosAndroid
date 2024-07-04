package com.example.loginexample;





import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText usernameInput;
    private TextInputEditText passwordInput;
    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        logoImageView = findViewById(R.id.logoImageView);

        // Start the animation
        Animation logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_slide_up);
        logoImageView.startAnimation(logoAnimation);

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        findViewById(R.id.forgotPasswordTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle forgot password click
                Toast.makeText(MainActivity.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleLogin() {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (TextUtils.isEmpty(username)) {
            usernameInput.setError(getString(R.string.username_required));
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordInput.setError(getString(R.string.password_required));
            return;
        }

        // Aquí puedes agregar la lógica para autenticar al usuario.
        // Por ejemplo, verificar el usuario y la contraseña con una base de datos o API.

        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
        // Intent intent = new Intent(this, HomeActivity.class);
        // startActivity(intent);
        // finish();
    }
}
