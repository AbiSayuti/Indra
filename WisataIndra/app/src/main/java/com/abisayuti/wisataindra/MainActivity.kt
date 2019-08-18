package com.abisayuti.wisataindra

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.abisayuti.wisataindra.fragment.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.nav_home -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, Home()).commit()
            }
            R.id.nav_profile -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, ProfileWisata()).commit()
            }
            R.id.nav_web -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, WebWisata()).commit()
            }
            R.id.nav_lokasi-> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, PetaWisata()).commit()

            }
            R.id.nav_video -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, VideoWisata()).commit()
            }
            R.id.nav_galeri -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, GaleriWisata()).commit()
            }
            R.id.nav_about -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, AboutDeveloper()).commit()
            }
            R.id.nav_exit -> {
                AlertDialog.Builder(this@MainActivity )
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Keluar Dari Aplikasi")
                    .setMessage("Apakah Anda Ingin Keluar Dari Aplikasi?")
                    .setPositiveButton( "Ya", { dialog, which -> finish() } )
                    .setNegativeButton( "Tidak", null )
                    .show()
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
