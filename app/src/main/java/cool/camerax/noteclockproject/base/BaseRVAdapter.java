package cool.camerax.noteclockproject.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseRVAdapter<DATA, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected ArrayList<DATA> mDatas = new ArrayList<>();
    protected AdapterView.OnItemClickListener mItemClickListener;
    protected AdapterView.OnItemLongClickListener mItemLongClickListener;

    public BaseRVAdapter() {
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        DATA item = getItem(position);
        bindItemData(holder, item, position);
    }

    @Override
    public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        VH holder = doCreateViewHolder(viewGroup, viewType);
        setupOnItemClick(holder);
        setupOnItemLongClick(holder);
        return holder;
    }

    protected abstract VH doCreateViewHolder(ViewGroup viewGroup, int viewType);

    protected abstract void bindItemData(VH viewHolder, DATA data, int position);

    protected void setupOnItemClick(final VH viewHolder) {
        if (mItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick(viewHolder);
                }
            });
        }
    }

    protected void setupOnItemLongClick(final VH viewHolder) {
        if (mItemLongClickListener != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View view) {
                    onItemLongClick(viewHolder);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public DATA getItem(int position) {
        if (getItemCount() > position) {
            return mDatas.get(position);
        }
        return null;
    }

    public List<DATA> getData() {
        return new ArrayList<>(mDatas);
    }

    public void setData(Collection<DATA> list) {
        setDataSilently(list);
        notifyDataSetChanged();
    }

    public void setDataSilently(Collection<DATA> list) {
        mDatas.clear();
        addAll(list);
    }

    public void addAll(Collection<DATA> collection) {
        if (collection != null) {
            mDatas.addAll(collection);
        }
    }

    public void addAll(int index, Collection<DATA> collection) {
        if (collection != null) {
            mDatas.addAll(index, collection);
        }
    }

    public void add(DATA item) {
        if (item != null) {
            mDatas.add(item);
        }
    }

    public void add(int index, DATA item) {
        if (item != null) {
            mDatas.add(index, item);
        }
    }

    public DATA remove(int position) {
        return mDatas.remove(position);
    }


    public boolean remove(DATA item) {
        return mDatas.remove(item);
    }

    public int findItemIndex(DATA item) {
        return mDatas.indexOf(item);
    }

    public void clear() {
        mDatas.clear();
    }


    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener listener) {
        this.mItemLongClickListener = listener;
    }

    protected void onItemClick(VH viewHolder) {
        if (mItemClickListener != null) {
            int position = viewHolder.getAdapterPosition();
            mItemClickListener.onItemClick(null, viewHolder.itemView, position, position);
        }
    }

    protected void onItemLongClick(VH viewHolder) {
        if (mItemLongClickListener != null) {
            int position = viewHolder.getAdapterPosition();
            mItemLongClickListener.onItemLongClick(null, viewHolder.itemView, position, position);
        }
    }
}
