package com.example.finalwireframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class FavoritePlaces extends MenuBar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_places);
    }

    // Barra Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        invalidateOptionsMenu(menu);
        return true;
    }

    // Ocultar opcion menu
    public boolean invalidateOptionsMenu(Menu menu) {
        menu.findItem(R.id.itemFavoritePlaces).setVisible(false);
        return true;
    }
}