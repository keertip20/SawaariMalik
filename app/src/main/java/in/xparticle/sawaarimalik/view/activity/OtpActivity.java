package in.xparticle.sawaarimalik.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import in.xparticle.sawaarimalik.R;
import in.xparticle.sawaarimalik.model.Verify.VerifyOtpRequest;
import in.xparticle.sawaarimalik.model.Verify.VerifyOtpResponse;
import in.xparticle.sawaarimalik.network.ApiClient;
import in.xparticle.sawaarimalik.network.EndPointInterface;
import in.xparticle.sawaarimalik.utils.AppSession;
import in.xparticle.sawaarimalik.utils.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "OtpActivity";

    TextView mPhoneNo;
    EditText mOtp;
    Button mBtn;
    String mHash2, mType2;
    AppSession mAppSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        First();


    }

    public void First(){
        mAppSession = new AppSession(this);
        String hash=getIntent().getExtras().getString("hashCode");
        mHash2 =hash;
        String phone=getIntent().getExtras().getString("phoneNo");
        String type=getIntent().getExtras().getString("typeCode");
        mType2 =type;
//        Log.e(TAG, "onCreate: bundle"+bundle );
        mPhoneNo =findViewById(R.id.et_phone_no);
        mOtp=findViewById(R.id.ed_otp);

        mBtn =findViewById(R.id.btn_verify_otp);

        mPhoneNo.setText(phone);

        mBtn.setOnClickListener(this);


    }

    private void callApi(){

        VerifyOtpRequest verifyOtpRequest = new VerifyOtpRequest();
        verifyOtpRequest.setHash(mHash2);
        verifyOtpRequest.setOtp(Integer.parseInt(mOtp.getText().toString()));
        verifyOtpRequest.setMobileNumber(mPhoneNo.getText().toString());
        verifyOtpRequest.setUserTypeCode( Integer. parseInt(mType2));

        ApiClient.getClient().create(EndPointInterface.class ).verifyOtp(verifyOtpRequest).enqueue(new Callback<VerifyOtpResponse>() {
            @Override
            public void onResponse(Call<VerifyOtpResponse> call, Response<VerifyOtpResponse> response) {

                if(!response.body().getError()){

                    mAppSession.setAccessToken(response.body().getAccessToken());
                    mAppSession.setLogin(true);

                    Intent intent=new Intent(OtpActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }
                else {
                }
            }

            @Override
            public void onFailure(Call<VerifyOtpResponse> call, Throwable t) {
                Toast.makeText(OtpActivity.this, "error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_verify_otp){
            verifyOtp();
        }
    }
    void verifyOtp(){
        if(Util.isNetworkAvailable(this)){
            callApi();
        }
        else{
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}
