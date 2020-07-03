package com.kulsoom.covid19tracker;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SummaryService {

    @GET("/summary")
    Call<Summary> getSummary();

}
