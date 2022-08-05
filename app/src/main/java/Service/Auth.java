package Service;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class Auth {

    public final  FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    FirebaseUser firebaseUser;
    ToastService toastService=new ToastService();

    public void login(String email, String password, Context context){
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        System.out.println("Success");
                        setFirebaseUser(firebaseAuth.getCurrentUser());
                    }
                    else{
                        System.out.println("failed");
                        toastService.shortToast("failed",context);
                    }
                }
            });
    }

    public void signUp(String Email,String password){
        try {
            firebaseAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                }
            });
        }catch (Exception e){

        }
    }

    public void signOut(Context context){
        try{
            firebaseAuth.signOut();
        }catch (Exception e){
            toastService.shortToast("SignOut failed",context);
        }

    }
    public FirebaseUser currentUser(){
            return firebaseAuth.getCurrentUser();
    }

//    public FirebaseUser getFirebaseUser() {
//        return firebaseUser;
//    }

    public void setFirebaseUser(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }
}
