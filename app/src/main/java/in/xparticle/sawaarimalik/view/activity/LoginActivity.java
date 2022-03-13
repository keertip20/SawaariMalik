package in.xparticle.sawaarimalik.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.xparticle.sawaarimalik.R;
import in.xparticle.sawaarimalik.model.SendOTP.SendOTPRequest;
import in.xparticle.sawaarimalik.model.SendOTP.SendOTPResponse;
import in.xparticle.sawaarimalik.network.ApiClient;
import in.xparticle.sawaarimalik.network.EndPointInterface;
import in.xparticle.sawaarimalik.utils.AppSession;
import in.xparticle.sawaarimalik.utils.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mEtPhoneNumber;
    Button mBtnNext;
    AppSession mAppSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private TextWatcher phoneNoTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String phoneNoInput= mEtPhoneNumber.getText().toString().trim();

            mBtnNext.setEnabled(phoneNoInput.length() == 10);
        }

        @Override
        public void afterTextChanged(Editable editable) {


        }
    };

    public boolean validatePhoneNumber(){
        if(mEtPhoneNumber.getText().toString().length()==10){
            return true;
        }
        return false;
    }

    public void callAPI(){
        SendOTPRequest sendOTPRequest = new SendOTPRequest();
        sendOTPRequest.setMobileNumber("+91"+ mEtPhoneNumber.getText().toString());
        sendOTPRequest.setUserTypeCode(2);
        ApiClient.getClient().create(EndPointInterface.class).SendOtp(sendOTPRequest).enqueue(new Callback<SendOTPResponse>() {
            @Override
            public void onResponse(Call<SendOTPResponse> call, Response<SendOTPResponse> response) {


                try {
                    if(!response.body().getError()){
                        String hashCode = response.body().getHash();
                        String phoneNumber = response.body().getMobileNumber();
                        String typeCode = String.valueOf(response.body().getUserTypeCode());

                        Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
                        intent.putExtra("hashCode",hashCode);
                        intent.putExtra("phoneNo",phoneNumber);
                        intent.putExtra("typeCode",typeCode);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Error "+response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<SendOTPResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void initView(){
        mEtPhoneNumber =findViewById(R.id.ed_mobile_number);
        mBtnNext =findViewById(R.id.btn_next);
//        ed_phoneNo.addTextChangedListener(phoneNoTextWatcher);
        mAppSession = new AppSession(this);
        mBtnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_next){
            submitBtnClicked();
        }
    }

    void submitBtnClicked(){
        if(validatePhoneNumber()==true){
            if(Util.isNetworkAvailable(this)){
                callAPI();
            }
            else{
                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Enter a valid PHone number", Toast.LENGTH_SHORT).show();
        }
    }

}