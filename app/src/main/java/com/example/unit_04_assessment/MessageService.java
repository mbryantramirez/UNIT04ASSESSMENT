package com.example.unit_04_assessment;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageService {

    //https://raw.githubusercontent.com/JDVila/storybook/master/echinoderms.json
    @GET("JDVila/storybook/master/echinoderms.json")
    Call<MessageList>getMessage();

}
