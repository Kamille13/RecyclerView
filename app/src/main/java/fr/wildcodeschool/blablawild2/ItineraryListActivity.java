package fr.wildcodeschool.blablawild2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        TripModel tripModel = getIntent().getParcelableExtra(ItinerarySearchActivity.EXTRA_TRIP);
        this.setTitle(String.format(getString(R.string.departure_to_destination), tripModel.getDeparture(), tripModel.getDestination()));

        RecyclerView listItineraries = findViewById(R.id.list_itineraries);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listItineraries.setLayoutManager(layoutManager);

        final ArrayList<ItineraryModel> itineraryModels = new ArrayList<>();
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Eric Cartman", new Date(), 15));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Stan Marsh", new Date(), 20));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Kenny Broflovski", new Date(), 12));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Kyle McCormick", new Date(), 18));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Wendy Testaburger", new Date(), 16));

        final ItineraryRecyclerAdapter adapter = new ItineraryRecyclerAdapter(itineraryModels);
        listItineraries.setAdapter(adapter);

        listItineraries.addOnItemTouchListener(new RecyclerItemClickListener(ItineraryListActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                itineraryModels.get(position).getDriver();
                Toast.makeText(ItineraryListActivity.this,itineraryModels.get(position).getDriver(), Toast.LENGTH_SHORT).show();


            }
        }));
    }
}
