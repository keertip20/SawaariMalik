package in.xparticle.sawaarimalik.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

public class AppSession {

    private static final String SESSION_NAME = "apps.nms";
    private SharedPreferences mSharedPreferences;
    private Context mContext;
    private SharedPreferences.Editor prefsEditor;

    public AppSession(Context context){
        mContext = context;
        mSharedPreferences = context.getSharedPreferences(SESSION_NAME,Context.MODE_PRIVATE);
        prefsEditor = mSharedPreferences.edit();
    }

    public void setBool(String name,boolean toggle)
    {
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putBoolean(name, toggle);
        prefsEditor.commit();
    }

    public boolean getBool(String name)
    { return mSharedPreferences.getBoolean(name, false);
    }




    public void setToggle(boolean toggle)
    {
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putBoolean("Toggle", toggle);
        prefsEditor.commit();
    }

    public boolean getToggle()
    { return mSharedPreferences.getBoolean("Toggle", false);
    }
    public void setLanguage(String language){
        if (language.equalsIgnoreCase("English"))
            language = "en";
        else
            language = "hi";

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        mContext.getResources().updateConfiguration(configuration,mContext.getResources().getDisplayMetrics());
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("my_lang",language);
        prefsEditor.putBoolean("languageSet",true);
        //setLocal(language);
        prefsEditor.apply();
    }

    public boolean isLanguageSet(){
        return mSharedPreferences.getBoolean("languageSet",false);
    }
    public String getLanguage(){
        return mSharedPreferences.getString("my_lang","en");
    }

    public boolean isLogin() {
        return mSharedPreferences.getBoolean("Login", false);
    }

    public void setLogin(boolean Login) {
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putBoolean("Login", Login);
        prefsEditor.commit();
    }

    public void setFirstName(String name){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("getFirstName",name);
        prefsEditor.commit();
    }
    public String getFirstName(){
        return mSharedPreferences.getString("getFirstName","");
    }


    public void setLastName(String name){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("getLastName",name);
        prefsEditor.commit();
    }
    public String getLastName(){
        return mSharedPreferences.getString("getLastName","");
    }

    public void setGender(String gender){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("getGender",gender);
        prefsEditor.apply();
    }
    public String getGender(){
        return mSharedPreferences.getString("getGender","");
    }

    public void setMobileNumber(String number){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("getMobileNumber",number);
        prefsEditor.apply();
    }

    public String getMobileNumber(){
        return mSharedPreferences.getString("getMobileNumber","");
    }

    public void setEmail(String email){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("setEmail",email);
        prefsEditor.apply();
    }

    public String getEmail(){
        return mSharedPreferences.getString("setEmail","");
    }


    public void setAge(String age){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("setAge",age);
        prefsEditor.apply();
    }
    public String getAge(){
        return mSharedPreferences.getString("setAge","");
    }

    public void setAddress(String age){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("address",age);
        prefsEditor.apply();
    }
    public String getAddress(){
        return mSharedPreferences.getString("address","");
    }

    public void setAadharNumber(String age){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("aadharNumber",age);
        prefsEditor.apply();
    }
    public String getAadharNumber(){
        return mSharedPreferences.getString("aadharNumber","");
    }

    public void setPanNumber(String age){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("panNumber",age);
        prefsEditor.apply();
    }
    public String getPanNumber(){
        return mSharedPreferences.getString("panNumber","");
    }

    public void setDrivingLicense(String age){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("drivingLicense",age);
        prefsEditor.apply();
    }
    public String getDrivinglicense(){
        return mSharedPreferences.getString("drivingLicense","");
    }


    public String getWalletAmount(){
        return mSharedPreferences.getString("getWalletAmount","");
    }

    public void setWalletAmount(String amount){
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("getWalletAmount",amount);
        prefsEditor.apply();
    }



    public String getAccessToken() {
        return mSharedPreferences.getString("getAccessToken", "");
    }

    public void setAccessToken(String accessToken) {
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("getAccessToken", accessToken);
        prefsEditor.apply();
    }
    public void setRefreshToken(String accessToken) {
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("RefreshToken", accessToken);
        prefsEditor.apply();
    }
    public String getRefreshToken() {
        return mSharedPreferences.getString("RefreshToken", "");
    }
}