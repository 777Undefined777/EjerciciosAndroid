package com.example.prueba22;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction; // Añade esta importación
import com.example.prueba22.R; // Añade esta importación

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

public class HomeActivity extends AppCompatActivity {

    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Ajusta el nombre del layout a activity_home

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(findViewById(R.id.toolbar))
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(1).withName("Fragment 1"),
                        new PrimaryDrawerItem().withIdentifier(2).withName("Fragment 2")
                        // Agrega más elementos según sea necesario
                )
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    // Maneja los clics en los elementos del Navigation Drawer aquí
                    switch ((int) drawerItem.getIdentifier()) {
                        case 1:
                            // Reemplaza el contenido del fragmento con Fragment1
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();
                            break;
                        case 2:
                            // Reemplaza el contenido del fragmento con Fragment2
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment2()).commit();
                            break;
                        // Agrega más casos según sea necesario
                    }
                    return false;
                })
                .build();
    }
}
