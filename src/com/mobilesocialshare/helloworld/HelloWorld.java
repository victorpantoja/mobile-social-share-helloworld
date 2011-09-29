package com.mobilesocialshare.helloworld;

import java.util.HashMap;
import java.util.Map;

import com.mobilesocialshare.mss.MSSApi;

import android.app.Activity;
import android.os.Bundle;

public class HelloWorld extends Activity {
    /** Called when the activity is first created. */
	public MSSApi mss = new MSSApi("http://192.168.0.255:9080");
	String token, password;
	
	String username = "victor.pantoja@gmail.com";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        try{
        	 mss.Initiate();
        }catch (Exception e) {
			// TODO: handle exception
		}
        
        password = mss.CreateUser("Pantoja","Victor",username,MSSApi.MALE);
        token = mss.Login(username,password);
        
        Map<Integer, String> context = new HashMap<Integer, String>();
        
        context.put(MSSApi.TWITTER_ID, "testando integracao com twitter #mss");
        
        mss.SendContext(context); 
        
        setContentView(R.layout.main);
    }
}