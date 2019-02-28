package com.example.unit_04_assessment;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//https://raw.githubusercontent.com/JDVila/storybook/master/echinoderms.json

public class MessageClient {
    private static MessageClient instance;
    private static Retrofit retrofit;
    public static final String BASE_URL ="https://raw.githubusercontent.com/";


    public static MessageClient getInstance(){
        if (instance == null){
            instance = new MessageClient();
        }
        return instance;
    }

    private MessageClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    private MessageService getMessageService(){
        return retrofit.create(MessageService.class);
    }
    public Call<MessageList> getMessageResponse(){
        return getMessageService().getMessage();
    }
}
