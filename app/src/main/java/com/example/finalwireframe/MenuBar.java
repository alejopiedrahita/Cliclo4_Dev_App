package com.example.finalwireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuBar extends AppCompatActivity {

    private Intent intent;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemHome:
                intent = new Intent(this, Home.class);
                startActivity(intent);
                return super.onOptionsItemSelected(item);
            case R.id.itemRegisterPlace:
                intent = new Intent(this, RegisterPlace.class);
                startActivity(intent);
                return super.onOptionsItemSelected(item);
            case R.id.itemFindPlace:
                intent = new Intent(this, FindPlace.class);
                startActivity(intent);
                return super.onOptionsItemSelected(item);
            case R.id.itemReaderCode:
                intent = new Intent(this, ReaderCode.class);
                startActivity(intent);
                return super.onOptionsItemSelected(item);
            case R.id.itemFavoritePlaces:
                intent = new Intent(this, FavoritePlaces.class);
                startActivity(intent);
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
