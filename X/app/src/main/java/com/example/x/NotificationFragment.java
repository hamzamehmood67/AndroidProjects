package com.example.x;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x.R;
import com.example.x.Tweet;
import com.example.x.TweetAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
    private List<notification> notificationList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        notificationList = new ArrayList<>();
        notificationAdapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(notificationAdapter);

        // Populate the tweetList with data
        loadNotification();

        return view;
    }

    private void loadNotification() {
        // Static data to simulate tweets
        notificationList.add(new notification("Hamza", " liked your pic", "2h ago"));
        notificationList.add(new notification("Ali", " liked your pic", "2h ago"));
        notificationList.add(new notification("Umar", " liked your pic", "2h ago"));

        // Notify the adapter that the data has changed
        notificationAdapter.notifyDataSetChanged();
    }

}
