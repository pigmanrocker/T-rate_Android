package com.example.t_rate.Activities;

import android.databinding.DataBindingUtil;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.t_rate.Adapters.HomeAdapter;
import com.example.t_rate.Presenters.HomePresenter;
import com.example.t_rate.R;
import com.example.t_rate.databinding.ActivityHomeBinding;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private HomePresenter presenter;
    private ActivityHomeBinding B;
    private int timesBack = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        B = DataBindingUtil.setContentView(this, R.layout.activity_home);
        presenter = new HomePresenter(this);

        B.setPresenter(presenter);
        B.homeRecycler.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
    }

    public void setDrawerListAdapter(ArrayAdapter adapter){
    }

    public void setRecyclerAdapter(RecyclerView.Adapter<HomeAdapter.VH_teacher_card_small> adapter){
        B.homeRecycler.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }

    @Override
    public void onBackPressed() {
        if (B.drawerLayout.isDrawerOpen(GravityCompat.START)){
            B.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            timesBack--;

            if (timesBack <= 0){
                moveTaskToBack(true);
            } else if (timesBack == 1){
                Toast.makeText(this, R.string.exit_back, Toast.LENGTH_SHORT).show();

                Timer reset = new Timer();

                reset.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        timesBack = 2;
                    }
                }, 3000);
            }
        }
    }
}
