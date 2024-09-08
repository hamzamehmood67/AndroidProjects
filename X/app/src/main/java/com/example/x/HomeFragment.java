package com.example.x;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.WorkSource;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x.R;
import com.example.x.Tweet;
import com.example.x.TweetAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private TweetAdapter tweetAdapter;
    private List<Tweet> tweetList;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FloatingActionButton addtweet;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        addtweet=view.findViewById(R.id.add_tweet);
        tweetList = new ArrayList<>();
        tweetAdapter = new TweetAdapter(tweetList);
        recyclerView.setAdapter(tweetAdapter);

        addtweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddTweetDialog();
            }
        });

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Tweets");
        // Populate the tweetList with data
        fetchTweets();
        return view;
    }

    protected  void addTweet(Tweet tweet){

        myRef.child(tweet.getId()).setValue(tweet);
        Log.d("TAG", "Tweet added");
    }

    private void loadTweets() {
        // Static data to simulate tweets
//        tweetList.add(new Tweet("Maleeha Hashmey",
//                "عمران خان نے آج جلسہ منسوخ کرنے کا فیصلہ کیا ہے تو بہت سوچ سمجھ کر کیا ہو گا۔",
//                628000,
//                50,
//                32000000));
//
//        tweetList.add(new Tweet("Aun Ali Khosa",
//                "بسم اللہ الرحمن الرحیم\n"
//                        + "سمجھ سے باہر ہے کہ لاکھوں لوگوں کے شکریہ کا حق کیسے ادا ہو۔",
//
//                49000,
//                40,
//                238000));
//
//        tweetList.add(new Tweet("Enkidu Reborn",
//                "A tweet about recent events with a picture.",
//
//                6000,
//                244,
//                3500000));
//
//        tweetList.add(new Tweet("Maleeha Hashmey",
//                "عمران خان نے آج جلسہ منسوخ کرنے کا فیصلہ کیا ہے تو بہت سوچ سمجھ کر کیا ہو گا۔",
//                628,
//                564,
//                32000000));
//
//        tweetList.add(new Tweet("Aun Ali Khosa",
//                "بسم اللہ الرحمن الرحیم\n"
//                        + "سمجھ سے باہر ہے کہ لاکھوں لوگوں کے شکریہ کا حق کیسے ادا ہو۔",
//
//                490,
//                342,
//                238000));
//
//        tweetList.add(new Tweet("Enkidu Reborn",
//                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
//                        "industry. Lorem Ipsum has been the industry's standard dummy tex" +
//                        "t ever since the 1500s, when an unknown printer took a galley of typ" +
//                        "e and scrambled it to make a type specimen book.",
//
//                600,
//                12,
//                3500));
//        tweetList.add(new Tweet("Enkidu Reborn",
//                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
//                        "industry. Lorem Ipsum has been the industry's standard dummy tex" +
//                        "t ever since the 1500s, when an unknown printer took a galley of typ" +
//                        "e and scrambled it to make a type specimen book.",
//
//                600,
//                25,
//                3500000));
//        tweetList.add(new Tweet("Enkidu Reborn",
//                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
//                        "industry. Lorem Ipsum has been the industry's standard dummy tex" +
//                        "t ever since the 1500s, when an unknown printer took a galley of typ" +
//                        "e and scrambled it to make a type specimen book.",
//
//                685,
//                231,
//                3500000));
//        tweetList.add(new Tweet("Enkidu Reborn",
//                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
//                        "industry. Lorem Ipsum has been the industry's standard dummy tex" +
//                        "t ever since the 1500s, when an unknown printer took a galley of typ" +
//                        "e and scrambled it to make a type specimen book.",
//
//                86,
//                12,
//                3500));

        // Notify the adapter that the data has changed
        tweetAdapter.notifyDataSetChanged();
    }

    private void showAddTweetDialog() {
        // Create an AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        // Inflate the custom layout for the dialog
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_box, null);
        builder.setView(dialogView);

        // Get references to the EditText and Button in the dialog layout
        EditText tweetContent = dialogView.findViewById(R.id.content);
        Button submitTweet = dialogView.findViewById(R.id.submit_tweet);

        // Create the AlertDialog
        AlertDialog dialog = builder.create();

        // Set the submit button action
        submitTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tweetText = tweetContent.getText().toString();

                if (!tweetText.isEmpty()) {
                    Tweet tweet=new Tweet("Anonymus",tweetText , 0,0,0);
                    // You can handle the tweet submission here (e.g., save it or display it)
                    addTweet(tweet);
                    fetchTweets();
                    // Dismiss the dialog after submission
                    dialog.dismiss();
                } else {
                    tweetContent.setError("Tweet content can't be empty!");
                }
            }
        });

        // Show the dialog
        dialog.show();
    }

    private void fetchTweets() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Clear the previous list to avoid duplicates
                tweetList.clear();

                // Iterate through all the tweets in the database
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Deserialize each tweet into a Tweet object
                    Tweet tweet = snapshot.getValue(Tweet.class);

                    // Add the tweet to the list
                    if (tweet != null) {
                        tweetList.add(tweet);
                    }
                }
                tweetAdapter.notifyDataSetChanged();
                // Now you can use tweetList (e.g., update UI or log the tweets)
                Log.d("TAG", "Number of tweets: " + tweetList.size());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }
}
