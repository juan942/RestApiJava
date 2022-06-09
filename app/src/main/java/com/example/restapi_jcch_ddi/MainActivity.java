package com.example.restapi_jcch_ddi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.restapi_jcch_ddi.client.RetrofitClient;
import com.example.restapi_jcch_ddi.databinding.ActivityMainBinding;
import com.example.restapi_jcch_ddi.entity.Message;
import com.example.restapi_jcch_ddi.service.RetrofitApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private TextView mTextView;
    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initValues();
        getMessage(29);

    }

    private void initView() {
        mTextView = findViewById(R.id.m_Text);
    }

    private void initValues() {
        apiService = RetrofitClient.getApiService();
    }

    private void getMessage(int id) {
        apiService.getMessageId(id).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                mTextView.setText(message.toString());
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                mTextView.setText(t.toString());
            }
        });
    }
}