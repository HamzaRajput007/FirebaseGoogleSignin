package com.school.firebasegooglesignin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Task<InstanceIdResult> getInstanceId_failed = FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>(){
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("TAG2", "getInstanceId_failed", task.getException());
                            return;
                        }
                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);

                        char[] destLength = token.toCharArray();
                        token.getChars(0 , token.length() , destLength   , 0);
                        Log.d("TAG", destLength.toString());
                        Toast.makeText(MainActivity.this, destLength.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
