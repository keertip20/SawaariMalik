package in.xparticle.sawaarimalik.network;

import in.xparticle.sawaarimalik.model.SendOTP.SendOTPRequest;
import in.xparticle.sawaarimalik.model.SendOTP.SendOTPResponse;
import in.xparticle.sawaarimalik.model.Verify.VerifyOtpRequest;
import in.xparticle.sawaarimalik.model.Verify.VerifyOtpResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface EndPointInterface {

    @Headers("Content-Type: application/json")
    @POST("/api/auth/sendOTP")
    Call<SendOTPResponse> SendOtp(@Body SendOTPRequest request);

    @Headers("Content-Type: application/json")
    @POST("/api/auth/verifyOTP")
    Call<VerifyOtpResponse> verifyOtp(@Body VerifyOtpRequest verifyOtpRequest);
}


//fun(5);
//
//public void fun(int a){
//
//}