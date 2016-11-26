package bareng.ngoprek.weekendprojekblink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private   String mStringUrl="http://192.168.43.158/gpio/";

    Button on,off;
    private   OkHttpClient client;
    private  Request request;
    private  String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new OkHttpClient();

        //inisialisasi
        on=(Button)findViewById(R.id.onbutton);
        off=(Button)findViewById(R.id.offbutton);

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nyala("0");
            }
        });


        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nyala("1");
            }
        });



    }

    private void nyala(String id){
         request = new Request.Builder().url(mStringUrl+id).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.i(TAG, "onResponse: succes ");
            }
        });
    }
}
