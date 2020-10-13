package com.example.evcilhayvanim;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import java.util.Objects;

public class MenuActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_shelter, R.id.nav_vet,R.id.nav_dog,R.id.nav_cat,R.id.nav_bird,R.id.nav_fish,R.id.nav_hamster,R.id.nav_rabbit)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.exit_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.exit){
            final AlertDialog.Builder builder=new AlertDialog.Builder(MenuActivity.this);
            builder.setIcon(R.drawable.ic_exit_gray);
            builder.setTitle("Çıkış Yap");
            builder.setMessage("Çıkmak istediğinizden emin misiniz?");
            builder.setCancelable(false);
            builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
        else {
            drawer.openDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MenuActivity.this);
        builder.setIcon(R.drawable.ic_exit_gray);
        builder.setTitle("Çıkış Yap");
        builder.setMessage("Çıkmak istediğinizden emin misiniz?");
        builder.setCancelable(false);
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void mainPageButtonClick(MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).commit();
        item.setChecked(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Ana Sayfa");
    }

    public void shelterButtonClick(MenuItem item){
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new ShelterFragment()).commit();
        item.setChecked(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("En Yakın Petshop");
    }

    public void vetButtonClick(MenuItem item){
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new VetFragment()).commit();
        item.setChecked(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("En Yakın Veteriner");
    }

    public void dogButtonClick(MenuItem item){
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new DogFragment()).commit();
        item.setChecked(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Köpek Bakımı");
    }

    public void catButtonClick(MenuItem item){
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new CatFragment()).commit();
        item.setChecked(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Kedi Bakımı");
    }

    public void birdButtonClick(MenuItem item){
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new BirdFragment()).commit();
        item.setChecked(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Kuş Bakımı");
    }

    public void fishButtonClick(MenuItem item){
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new FishFragment()).commit();
        item.setChecked(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Akvaryum Canlıları");
    }

    public void hamsterButtonClick(MenuItem item){
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HamsterFragment()).commit();
        item.setChecked(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Hamster Bakımı");
    }

    public void rabbitButtonClick(MenuItem item){
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new RabbitFragment()).commit();
        item.setChecked(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Tavşan Bakımı");
    }
}