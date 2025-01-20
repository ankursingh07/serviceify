package Service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.serviceify.Fragments.ProfileFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

import javax.security.auth.callback.Callback;

import Models.Customer;

public class FetchService {

    public final FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    final String customerDetailCollection="CustomerDetails";
    public DocumentReference documentReference;
    Auth auth=new Auth();
    public Customer customer=new Customer();

    public void fetchCustomerDetails(){
        documentReference=firebaseFirestore.collection(customerDetailCollection).document(auth.currentUser().getUid().toString());
        documentReference.get(Source.SERVER).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    System.out.println("Success");
                    System.out.println(task.getResult().get("name").toString());
                    customer.setName(task.getResult().get("name").toString());
                    customer.setAddress(task.getResult().get("Address").toString());
                    customer.setPhoneNumber(task.getResult().get("phone number").toString());
                    customer.setEmail(task.getResult().get("email").toString());
                    customer.setProfileUrl(task.getResult().get("profile photo").toString());
                    setCustomer(customer);
                }
                else{

                }
            }

        });
//        System.out.println("Customer:");
//        System.out.println(task.getResult().get("email"));
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public interface callBack{
        public void customerDetails(Customer customer);
    }
}
