package com.example.x;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<notification> notificationList;

    public NotificationAdapter(List<notification> notificationList) {
        this.notificationList = notificationList;
    }


    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        notification notification = notificationList.get(position);
        holder.time.setText(notification.getTimeStamp());
        holder.content.setText(notification.getAuthor()+ notification.getAction());

    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView  content, time;

        public NotificationViewHolder(View itemView) {
            super(itemView);

            content = itemView.findViewById(R.id.tvNotificationText);
            time = itemView.findViewById(R.id.tvTimestamp);

        }
    }
}

