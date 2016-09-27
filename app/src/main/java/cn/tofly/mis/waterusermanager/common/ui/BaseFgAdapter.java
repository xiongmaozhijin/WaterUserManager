package cn.tofly.mis.waterusermanager.common.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baoxing on 2016/8/13.
 */
public abstract class BaseFgAdapter<T> extends BaseAdapter {

    /**
     * 数据列表
     */
    private List<T> mData = new ArrayList<>();

    private Context mContext;

    public BaseFgAdapter(Context context) {
        this.mContext = context;
    }


    public void clearAndNotify() {
        mData.clear();
        notifyDataSetChanged();
    }

    /**
     * 重新加载数据
     *
     * @param data
     */
    public void reAddDataAndNotify(List<T> data) {
        if (data != null) {
            this.mData.clear();
            for (T item : data) {
                this.mData.add(item);
            }

            notifyDataSetChanged();
        }

    }

    /**
     * 重新加载数据，Reverse
     *
     * @param data
     */
    public void reAddDataReverseAndNotify(List<T> data) {
        if (data != null) {
            this.mData.clear();
            for (T item : data) {
                this.mData.add(0, item);
            }

            notifyDataSetChanged();
        }

    }


    /**
     * 添加新数据
     *
     * @param newData
     */
    public void addDataAndNotify(List<T> newData) {
        if (newData != null) {
            for (T item : newData) {
                this.mData.add(item);
            }

            notifyDataSetChanged();
        }
    }


    /**
     * 添加新数据
     *
     * @param newData
     */
    public void addDataAndNotify(T newData) {
        if (newData != null) {
            this.mData.add(newData);

            notifyDataSetChanged();
        }
    }

    /**
     * 添加新数据，Reverse
     *
     * @param newData
     */
    public void addDataReverseAndNotify(T newData) {
        if (newData != null) {
            this.mData.add(0, newData);

            notifyDataSetChanged();
        }
    }

    /**
     * 添加新数据，Reverse
     *
     * @param newData
     */
    public void addDataReverseAndNotify(List<T> newData) {
        if (newData != null) {
            for (T item : newData) {
                this.mData.add(0, item);
            }

            notifyDataSetChanged();
        }
    }


    public Context getContext() {
        return mContext;
    }


    @Override
    public int getCount() {
        return this.mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
//            convertView = View.inflate(mContext, getLayoutItemId(), parent);
            convertView = LayoutInflater.from(mContext).inflate(getLayoutItemId(), parent, false);
            viewHolder = getViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        T t = mData.get(position);

        viewHolder.adapterData(t, position);

        return convertView;
    }


    protected abstract int getLayoutItemId();

    protected abstract ViewHolder getViewHolder(View view);


    public static abstract class ViewHolder {

        public ViewHolder(View view) {
        }

        public abstract void adapterData(Object obj, int positon);

    }


}
