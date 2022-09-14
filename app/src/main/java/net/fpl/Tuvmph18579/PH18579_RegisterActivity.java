package net.fpl.Tuvmph18579;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PH18579_RegisterActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView1;
    Button dangki, huy;
    private EditText mail, pass;
    private FirebaseAuth auth;
    ProgressDialog progressDialog;
    public static final int RESULT_CODE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph18579_register);
        imageView = findViewById(R.id.day_night_switch);
        imageView1 = findViewById(R.id.iv_day);
        dangki = findViewById(R.id.btn_dangkytk);
        huy = findViewById(R.id.btn_huy);
        mail = (EditText) findViewById(R.id.ed_username);
        pass = (EditText) findViewById(R.id.ed_pass);
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        zoom();
        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangKy();
            }
        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail.setText("");
                pass.setText("");
            }
        });
    }

    public void zoom() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_dangnhap);
        imageView.setAnimation(animation);
        imageView1.setAnimation(animation);
    }

    private void dangKy() {
        String email = mail.getText().toString();
        String password = pass.getText().toString();
        progressDialog.show();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();

                            progressDialog.dismiss();
                            Intent intent = new Intent(getApplicationContext(), PH18579_LoginActivity.class);
                            intent.putExtra("u", email);
                            intent.putExtra("p", password);
                            setResult(RESULT_CODE, intent);
                            finish();

//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
//                            updateUI(null);
                        }
                    }
                });
    }
}