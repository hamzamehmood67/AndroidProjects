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
        loadTweets();

        return view;
    }

    private void loadTweets() {
        // Static data to simulate tweets
        tweetList.add(new Tweet("Maleeha Hashmey",
                "عمران خان نے آج جلسہ منسوخ کرنے کا فیصلہ کیا ہے تو بہت سوچ سمجھ کر کیا ہو گا۔",
                628000,
                50,
                32000000));

        tweetList.add(new Tweet("Aun Ali Khosa",
                "بسم اللہ الرحمن الرحیم\n"
                        + "سمجھ سے باہر ہے کہ لاکھوں لوگوں کے شکریہ کا حق کیسے ادا ہو۔",

                49000,
                40,
                238000));

        tweetList.add(new Tweet("Enkidu Reborn",
                "A tweet about recent events with a picture.",

                6000,
                244,
                3500000));

        tweetList.add(new Tweet("Maleeha Hashmey",
                "عمران خان نے آج جلسہ منسوخ کرنے کا فیصلہ کیا ہے تو بہت سوچ سمجھ کر کیا ہو گا۔",
                628,
                564,
                32000000));

        tweetList.add(new Tweet("Aun Ali Khosa",
                "بسم اللہ الرحمن الرحیم\n"
                        + "سمجھ سے باہر ہے کہ لاکھوں لوگوں کے شکریہ کا حق کیسے ادا ہو۔",

                490,
                342,
                238000));

        tweetList.add(new Tweet("Enkidu Reborn",
                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
                        "industry. Lorem Ipsum has been the industry's standard dummy tex" +
                        "t ever since the 1500s, when an unknown printer took a galley of typ" +
                        "e and scrambled it to make a type specimen book.",

                600,
                12,
                3500));
        tweetList.add(new Tweet("Enkidu Reborn",
                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
                        "industry. Lorem Ipsum has been the industry's standard dummy tex" +
                        "t ever since the 1500s, when an unknown printer took a galley of typ" +
                        "e and scrambled it to make a type specimen book.",

                600,
                25,
                3500000));
        tweetList.add(new Tweet("Enkidu Reborn",
                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
                        "industry. Lorem Ipsum has been the industry's standard dummy tex" +
                        "t ever since the 1500s, when an unknown printer took a galley of typ" +
                        "e and scrambled it to make a type specimen book.",

                685,
                231,
                3500000));
        tweetList.add(new Tweet("Enkidu Reborn",
                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
                        "industry. Lorem Ipsum has been the industry's standard dummy tex" +
                        "t ever since the 1500s, when an unknown printer took a galley of typ" +
                        "e and scrambled it to make a type specimen book.",

                86,
                12,
                3500));

        // Notify the adapter that the data has changed
        tweetAdapter.notifyDataSetChanged();
    }

}
