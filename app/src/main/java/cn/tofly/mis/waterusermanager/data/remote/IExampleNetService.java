package cn.tofly.mis.waterusermanager.data.remote;

import cn.tofly.mis.waterusermanager.data.entity.CheckCoder;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 某个服务器接口
 * Created by baoxing on 2016/9/26.
 */
public interface IExampleNetService {

    @GET("api/bm/bmListHandler.ashx")
    Observable<CheckCoder> getCby(@Query("mode") String queryMode);


}
