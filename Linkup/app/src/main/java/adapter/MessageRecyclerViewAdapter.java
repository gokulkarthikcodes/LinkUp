package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import bean.MessageBean;
import set2.linkup.MessageActivity;
import set2.linkup.R;
import util.DateUtil;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class MessageRecyclerViewAdapter extends RecyclerView.Adapter{
    private final static int ITEM = 1;
    private final static int ITEM_ME = 2;

    private Context context;
    private List<MessageBean> msgList;


    public MessageRecyclerViewAdapter(Context context, List<MessageBean> msgList){
        this.context = context;
        this.msgList = msgList;
    }

    @Override
    public int getItemCount(){
        return msgList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view;
        if(i == ITEM) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_msg, null);
            view.setLayoutParams(lp);
        }else{
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_msg_pri, null);
            view.setLayoutParams(lp);
        }
        return new MessageRecyclerViewAdapter.ItemViewHolder(view);
    }

    @Override
    public int getItemViewType(int position){
        if(msgList.get(position).isPrimary() == true)
            return ITEM_ME;
        else
            return ITEM;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i){
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;

        itemViewHolder.avatar.setImageResource(R.mipmap.ic_account_circle_black_48dp);
        itemViewHolder.tvMessage.setText(msgList.get(i).getMessage());
        itemViewHolder.tvDate.setText(DateUtil.getDateNormal(msgList.get(i).getDateline()));
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView avatar;
        TextView tvMessage,tvDate;

        public ItemViewHolder(View itemView){
            super(itemView);

            avatar = (ImageView) itemView.findViewById(R.id.iv_item);
            tvMessage = (TextView) itemView.findViewById(R.id.tv_item);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);

        }
    }
}
