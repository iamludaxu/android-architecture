package ren.daxu.architecture.example.comm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 基础适配器
 *
 * @param <V> 视图
 * @param <T> 数据
 */
abstract public class BaseObjectAdapter<V, T> extends BaseAdapter {

    protected List<T> mDataList;

    protected Context mContext;

    private LayoutInflater mInflater;

    public BaseObjectAdapter(Context context) {
        mDataList = new ArrayList<T>();
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void add(T data) {
        mDataList.add(data);
        notifyDataSetChanged();
    }


    public void add(List<T> datas) {
        mDataList.addAll(datas);
        notifyDataSetChanged();
    }

    public void remove(T data){
        mDataList.remove(data);
        notifyDataSetChanged();
    }

    public void reset(){
        mDataList.clear();
    }

    public void reset(List<T> datas){
        mDataList.addAll(datas);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        if (mDataList == null) {
            return 0;
        }
        return mDataList.size();
    }

    @Override
    public T getItem(int position) {
        // TODO Auto-generated method stub
        if (mDataList == null) {
            return null;
        }
        return mDataList.get(position);
    }


    public List<T> getDataList(){
        return  mDataList;
    }


    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        V holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(getView(),parent,false);
            holder = attachViewHolder();
            ButterKnife.bind(holder, convertView);

            convertView.setTag(holder);
        } else {
            holder = (V) convertView.getTag();
        }
        if(mDataList==null|| mDataList.size()<=0){
            bindView((V) holder, null, position, convertView, parent);
        }else{
            bindView((V) holder, mDataList.get(position), position, convertView, parent);
        }
        return convertView;
    }

    protected abstract int getView();

    protected abstract V attachViewHolder() ;

    protected abstract void bindView(V holder, T data, int position, View convertView, ViewGroup parent);

    protected void initView(V holder){};


}

