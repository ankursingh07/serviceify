package Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.serviceify.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

     FirebaseAuth mAuth;
    EditText name,email,password1,password2;
    Button signup;
    String email1="";
    String password3="";
    String temp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=findViewById(R.id.signup_name);
        email=findViewById(R.id.signup_email);
        password1=findViewById(R.id.signup_password);
        password2=findViewById(R.id.confirm_password);
        signup=findViewById(R.id.signup_button);

        onLoginClick();
    }

    void onLoginClick()
    {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp=email.getText().toString();
                email1= email.getText().toString().trim();
                password3 = password1.getText().toString().trim();
                //Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_LONG).show();
                Signup();
            }
        });
    }

    void Signup()
    {
        System.out.println("Email:"+email1);
        System.out.println("pwd:" +password3);
        mAuth.createUserWithEmailAndPassword(email1,password3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}