package org.allgays.bestyary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.allgays.bestyary.Model.Monster;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore firebaseFirestore;

    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recycler)  ;

        //Query
        Query query = firebaseFirestore.collection("Monsters").orderBy("monster_name");
        //RecyclerOptions
        FirestoreRecyclerOptions<Monster> options = new FirestoreRecyclerOptions.Builder<Monster>()
                .setQuery(query, Monster.class)
                .build();
        adapter = new FirestoreRecyclerAdapter<Monster, MonsterViewHolder>(options) {
            @NonNull
            @Override
            public MonsterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_monster, parent, false);
                return new MonsterViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull MonsterViewHolder holder, int position, @NonNull Monster model) {
                holder.monster_name.setText(model.getMonster_name());
                holder.monster_type.setText(model.getMonster_type());
                holder.monster_danger.setText(model.getMonster_danger());

            }
        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private class MonsterViewHolder extends RecyclerView.ViewHolder {

        private TextView monster_name,monster_type,monster_danger;

        public MonsterViewHolder(@NonNull View itemView) {
            super(itemView);

            monster_name = itemView.findViewById(R.id.item_name);
            monster_type = itemView.findViewById(R.id.item_type);;
            monster_danger = itemView.findViewById(R.id.item_danger);;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
