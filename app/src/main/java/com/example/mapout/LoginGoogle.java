
package com.example.mapout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
public class loginGoogle extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    private ConstraintLayout profSection;
    private Button signOut;
    private SignInButton signIn;
    private TextView Name,Email;
    private ImageView profilePic;
    private Button usebtn;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    private TextView signInTv;
    private  ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_google);
        usebtn = findViewById(R.id.useAccountBtn);
        profSection = findViewById(R.id.profileSection);
        signOut = findViewById(R.id.btn);
        signIn = (SignInButton) findViewById(R.id.signIn);
        Name = findViewById(R.id.tv1);
        Email = findViewById(R.id.tv2);
        profilePic = findViewById(R.id.imageView);
        logo = findViewById(R.id.logo);

        signInTv = findViewById(R.id.signInTv);
        signIn.setOnClickListener(this);
        signOut.setOnClickListener(this);
        profSection.setVisibility(View.GONE);



        usebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginGoogle.this, MainActivity.class);
                startActivity(i);
            }
        });
        GoogleSignInOptions signInOptions = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions)
                .build();


    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signIn:
                setSignIn();
                break;
            case R.id.btn: {
                setSignOut();
                break;
            }
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }
    private void setSignIn(){
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, REQ_CODE);
    }
    private void setSignOut(){
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(false);
            }
        });
    }
    private void handleResult(GoogleSignInResult result){
        if (result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
            String email = account.getEmail();
            Glide.with(this).load(account.getPhotoUrl())
                    .apply(RequestOptions.circleCropTransform()).into(profilePic);
            Name.setText(name);
            Email.setText(email);            //            Glide.with(this).load(img_url).into(profilePic);
            updateUI(true);
        }
        else {
            updateUI(false);
        }
    }
    private void updateUI (boolean isLogin){
        if(isLogin){
            profSection.setVisibility(View.VISIBLE);
            signIn.setVisibility(View.GONE);
            signInTv.setVisibility(View.GONE);
            logo.setVisibility(View.GONE);

        }
        else {
            profSection.setVisibility(View.GONE);
            signIn.setVisibility(View.VISIBLE);
            signInTv.setVisibility(View.VISIBLE);
            logo.setVisibility(View.VISIBLE);

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQ_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }
}