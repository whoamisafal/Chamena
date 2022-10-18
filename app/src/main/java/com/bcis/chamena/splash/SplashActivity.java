package com.bcis.chamena.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bcis.chamena.MainActivity;
import com.bcis.chamena.R;
import com.bcis.chamena.common.FetchUserDetailsModel;
import com.bcis.chamena.common.Status;
import com.bcis.chamena.common.UserPref;
import com.bcis.chamena.databinding.ActivitySplashBinding;
import com.bcis.chamena.model.User;
import com.bcis.chamena.register.Register;
import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {
      ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      Animation animationUtils=  AnimationUtils.loadAnimation(this, R.anim.splash_anim);
      binding.splashImage.startAnimation(animationUtils);
        // Todo:Splash Screen
      Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fetch();
                Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
    void fetch(){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null){
            FetchUserDetailsModel detailsModel =new FetchUserDetailsModel(auth.getCurrentUser().getUid());
            detailsModel.fetch();
            detailsModel._user.observe(this, new Observer<User>() {
                @Override
                public void onChanged(User user) {
                    UserPref pref= new UserPref(user,getApplicationContext());
                    pref.saveUserPref();
                }
            });
            detailsModel._status.observe(this, new Observer<Status>() {
                @Override
                public void onChanged(Status status) {

                }
            });
        }
        return;
    }

}