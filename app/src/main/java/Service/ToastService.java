package Service;

import android.content.Context;
import android.widget.Toast;

public class ToastService {
    public void shortToast(String message, Context context){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public void longToast(String message, Context context){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
