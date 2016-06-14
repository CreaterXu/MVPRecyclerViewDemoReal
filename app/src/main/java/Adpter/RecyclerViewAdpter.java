package Adpter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.test.MainActivity;
import com.example.administrator.test.MessageBean;
import com.example.administrator.test.MessagePresenter;
import com.example.administrator.test.Presenter;
import com.example.administrator.test.R;

import java.util.ArrayList;

import imsdk.views.IMEmotionTextView;
import view.BadgeView;
import view.RoundedCornerImageView;

/**
 * Created by Administrator on 2016/5/20.
 */
public class RecyclerViewAdpter extends RecyclerView.Adapter<RecyclerViewAdpter.MsgViewHolder>{
    private FragmentActivity fragmentActivity;
    private View line_view;

    public ArrayList<MessageBean> getMessageBeanArrayList() {
        return messageBeanArrayList;
    }

    public void setMessageBeanArrayList(ArrayList<MessageBean> messageBeanArrayList) {
        this.messageBeanArrayList = messageBeanArrayList;
    }

    private ArrayList<MessageBean> messageBeanArrayList;

    public RecyclerViewAdpter(FragmentActivity fragmentActivity){
        this.fragmentActivity=fragmentActivity;
        //messagePresenter=new MessagePresenter();
    }
    @Override
    public RecyclerViewAdpter.MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        line_view=LayoutInflater.from(fragmentActivity).inflate(R.layout.item_message,parent,false);
        MsgViewHolder msgViewHolder=new MsgViewHolder(fragmentActivity.getLayoutInflater().inflate(R.layout.item_message,parent,false));
        return msgViewHolder;
    }

    @Override
    public int getItemCount() {
        return messageBeanArrayList==null ? 0:messageBeanArrayList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdpter.MsgViewHolder holder, int position) {
        if (holder==null){
            holder=new MsgViewHolder(line_view);
        }else {
            Log.e("xv","me"+holder.nameTextview);
            holder.nameTextview.setText(messageBeanArrayList.get(position).getName()+"");
        }

    }

    class MsgViewHolder extends RecyclerView.ViewHolder{
        RoundedCornerImageView headImagview;
        TextView nameTextview;
        TextView timeTextview;
        IMEmotionTextView imEmotionTextView;
        BadgeView badgeView;
        public MsgViewHolder(View view){
            super(view);
            headImagview=(RoundedCornerImageView) view.findViewById(R.id.item_user_mainphoto_imageview);
            nameTextview=(TextView) view.findViewById(R.id.item_user_name_textview);
            timeTextview=(TextView)view.findViewById(R.id.item_user_time_textview);
            imEmotionTextView=(IMEmotionTextView)view.findViewById(R.id.item_user_otherinfo_textview);
            badgeView=(BadgeView)view.findViewById(R.id.item_user_badgeview);

    }
    }
}
