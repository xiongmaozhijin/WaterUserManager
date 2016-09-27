package cn.tofly.mis.waterusermanager.data.local.daoimpl;

import java.util.List;

/**
 *
 * @param <T>   item
 * @param <K>   key
 */
public interface IDbCurl<T, K> {

    /**
     * insert one item
     * @param item
     * @return row ID of newly inserted entity
     */
    long insert(T item);

    /**
     * update one item
     * @param item
     * @return
     */
    long update(T item);

    /**
     * insert or update
     * @param item
     * @return
     */
    long insertOrReplace(T item);


    long delete(T item);

    /**
     * load by key
     * @param key
     * @return
     */
    T load(K key);

    /**
     * load all
     * @return
     */
    List<T> loadAll();



}
