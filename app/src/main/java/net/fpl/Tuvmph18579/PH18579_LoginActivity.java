package net.fpl.Tuvmph18579;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class PH18579_LoginActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView1;
    private EditText eduser, edpass;
    CheckBox ckBox;
    Button dangki, dangnhap;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    public static final int RESULT_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph18579_login);
        imageView = findViewById(R.id.logo);
        imageView1 = findViewById(R.id.iv_day);
        eduser = (EditText) findViewById(R.id.ed_username);
        edpass = (EditText) findViewById(R.id.ed_pass);
        ckBox = findViewById(R.id.chk_remember);
        dangki = findViewById(R.id.btn_dangky);
        dangnhap = findViewById(R.id.btn_dangnhap);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        zoom();
        //lay du lieu tu sharefêns
        SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        eduser.setText(sharedPreferences.getString("use", ""));
        edpass.setText(sharedPreferences.getString("pas", ""));
        ckBox.setChecked(sharedPreferences.getBoolean("REMEMBER", false));
        //dang ki firebase
        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PH18579_LoginActivity.this, PH18579_RegisterActivity.class);
                startActivityForResult(intent, RESULT_CODE);
            }
        });
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklogin();
            }
        });
    }

    public void zoom() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_dangnhap);
        imageView.setAnimation(animation);
        imageView1.setAnimation(animation);
    }

    private void checklogin() {
        if (eduser.getText().toString().isEmpty() || edpass.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Email Và Mật Khẩu Không Được Để Trống", Toast.LENGTH_SHORT).show();
        } else {
            dangnhap();
        }
    }

    private void dangnhap() {
        String email = eduser.getText().toString();
        String password = edpass.getText().toString();
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Toast.makeText(getApplicationContext(), "dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            rememberUser(email, password, ckBox.isChecked());
                            Intent intent = new Intent(getApplicationContext(), PH18579_Main.class);
                            startActivity(intent);

                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "email hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void rememberUser(String user, String pass, Boolean checked) {
        SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!checked) {
            eduser.setText("");
            edpass.setText("");
        } else {
            editor.putString("use", user);
            editor.putString("pas", pass);
            editor.putBoolean("REMEMBER", checked);
        }
        editor.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_CODE && resultCode == PH18579_RegisterActivity.RESULT_OK) {
            String u = data.getStringExtra("u");
            String p = data.getStringExtra("p");
            eduser.setText(u);
            edpass.setText(p);
        }
    }
}