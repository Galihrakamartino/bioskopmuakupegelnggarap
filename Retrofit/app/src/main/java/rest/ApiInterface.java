package rest;
import com.example.acer.retrofit.GetFilm;
import com.example.acer.retrofit.GetPembeli;
import com.example.acer.retrofit.GetPembelian;
import com.example.acer.retrofit.GetStudio;
import com.example.acer.retrofit.GetTiket;
import com.example.acer.retrofit.PostPutDelFilm;
import com.example.acer.retrofit.PostPutDelPembeli;
import com.example.acer.retrofit.PostPutDelPembelian;
import com.example.acer.retrofit.PostPutDelTiket;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;


/**
 * Created by Acer on 01/11/2018.
 */

public interface ApiInterface {
    @GET("pembelian/user")
    Call<GetTiket> getTiket();

    @FormUrlEncoded
    @POST("pembelian/user")
    Call<PostPutDelTiket> postTiket(@Field("id_tiket") String idTiket,
                                        @Field("id_film") String idFilm,
                                        @Field("id_studio") String idStudio,
                                        @Field("harga") String harga,
                                        @Field("tayang") String tayang);
    @FormUrlEncoded
    @PUT("pembelian/user")
    Call<PostPutDelTiket> putTiket(@Field("id_tiket") String idTiket,
                                   @Field("id_film") String idFilm,
                                   @Field("id_studio") String idStudio,
                                   @Field("harga") String harga,
                                   @Field("tayang") String tayang);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pembelian/user", hasBody = true)
    Call<PostPutDelTiket> deleteTiket(@Field("id_tiket") String idTiket);

    /********* Pembeli *********/

    @GET("pembeli")
    Call<GetPembeli> getPembeli();

    @FormUrlEncoded
    @POST("pembeli")
    Call<PostPutDelPembeli> postPembeli
            (@Field("id_pembeli") String idPembeli, @Field("id_tiket") String idTiket,
             @Field("nama") String nama, @Field("alamat") String alamat,
             @Field("telp") String telp);

    @FormUrlEncoded
    @PUT("pembeli")
    Call<PostPutDelPembeli> putPembeli(
            @Field("id_pembeli") String idPembeli, @Field("id_tiket") String idTiket,
            @Field("nama") String nama, @Field("alamat") String alamat,
            @Field("telp") String telp);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pembeli", hasBody = true)
    Call<PostPutDelPembeli> deletePembeli(@Field("id_pembeli") String idPembeli);


    /********* Studio *********/

    @GET("studio/all")
    Call<GetStudio> getStudio();

    @Multipart
    @POST("studio/all")
    Call<GetStudio> postStudio(
            @Part MultipartBody.Part file,
            @Part("tempat_duduk") RequestBody tempatduduk,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("studio/all")
    Call<GetStudio> putStudio(
            @Part MultipartBody.Part file,
            @Part("id_studio") RequestBody idStudio,
            @Part("tempat_duduk") RequestBody tempatduduk,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("studio/all")
    Call<GetStudio> deleteStudio(
            @Part("id_Studio") RequestBody idStudio,
            @Part("action") RequestBody action);

    /********* Film *********/


    @GET("film")
    Call<GetFilm> getFilm();

    @FormUrlEncoded
    @POST("film")
    Call<PostPutDelFilm> postFilm
            (@Field("id_film") String idFilm, @Field("judul") String judul,
             @Field("genre") String genre);

    @FormUrlEncoded
    @PUT("film")
    Call<PostPutDelFilm> putFilm(
            @Field("id_Film") String idFilm, @Field("judul") String judul,
            @Field("genre") String genre);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "film", hasBody = true)
    Call<PostPutDelFilm> deleteFilm(@Field("id_film") String idFilm);



}
