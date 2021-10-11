package com.alpha.peoplesbank.retrofit;


import androidx.annotation.Keep;


import com.alpha.peoplesbank.Util.APIs;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dhanushka.
 */
@Keep
public interface APIInterface {

    @POST(APIs.loginUrl)
    Call<ResponseBody> LoginUrl( @Query("username") String username, @Query("password") String password);
//
//    @GET(APIs.getAnimalMedicalHistoryUrl+"/{Id}")
//    Call<GetAnimalMedicalById> getAnimalMedicalHistoryUrl( @Header("Authorization") String auth, @Path("Id") int Id);


}
