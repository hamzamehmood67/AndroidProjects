package com.example.x;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    ListView listview;
    String[] boys;
    EditText Searchbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boys = getResources().getStringArray(R.array.trends);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Initialize the ListView
        listview = view.findViewById(R.id.listView); // Replace 'your_listview_id' with the actual ID of your ListView
        Searchbar=view.findViewById(R.id.search_bar);
        // Set up the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                R.layout.item_search, R.id.itemTextView, boys);
        listview.setAdapter(adapter);

        // Set up the item click listener
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapter.getItem(i);
                // Perform action based on the selected item
                Searchbar.setText(value);

            }
        });

        return view;
    }
}
