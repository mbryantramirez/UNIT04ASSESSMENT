package com.example.unit_04_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<MessageList> {
    private static final String TAG = "Sheriff";
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMessage();

        recyclerView = findViewById(R.id.recycler_view);
    }

    private void getMessage(){
        Call<MessageList> messageListCall = MessageClient.getInstance().getMessageResponse();
        messageListCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<MessageList> call, Response<MessageList> response) {
        MessageList messageList = response.body();

        Log.d(TAG,messageList.toString());

        List<Message> messages = messageList.getMessage();
        if (messages != null){
            messageAdapter = new MessageAdapter(messages);
            recyclerView.setAdapter(messageAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(linearLayoutManager);
        }

    }

    @Override
    public void onFailure(Call<MessageList> call, Throwable t) {

    }
}
