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

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private TweetAdapter tweetAdapter;
    private List<Tweet> tweetList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tweetList = new ArrayList<>();
        tweetAdapter = new TweetAdapter(tweetList);
        recyclerView.setAdapter(tweetAdapter);

        // Populate the tweetList with data
        loadTweets();

        return view;
    }

    private void loadTweets() {
        // Static data to simulate tweets
        tweetList.add(new Tweet("Maleeha Hashmey",
                "عمران خان نے آج جلسہ منسوخ کرنے کا فیصلہ کیا ہے تو بہت سوچ سمجھ کر کیا ہو گا۔",
                628000,
                32000000));

        tweetList.add(new Tweet("Aun Ali Khosa",
                "بسم اللہ الرحمن الرحیم\n"
                        + "سمجھ سے باہر ہے کہ لاکھوں لوگوں کے شکریہ کا حق کیسے ادا ہو۔",

                49000,
                238000));

        tweetList.add(new Tweet("Enkidu Reborn",
                "A tweet about recent events with a picture.",

                600000,
                3500000));

        // Notify the adapter that the data has changed
        tweetAdapter.notifyDataSetChanged();
    }

}
