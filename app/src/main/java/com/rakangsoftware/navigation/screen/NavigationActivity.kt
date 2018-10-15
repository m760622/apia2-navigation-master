package com.rakangsoftware.navigation.screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.NavUtils
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import com.rakangsoftware.navigation.R
import kotlinx.android.synthetic.main.navigation_activity.*

class NavigationActivity : AppCompatActivity() {

    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_activity)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "A Navigation "
            subtitle = "Toolbar, bottom, up and drawer navigation"
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.abc_ic_menu_overflow_material)
        }

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation)

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.secondDMenu -> {
                    SecondActivity.start(this)
                    drawerLayout.closeDrawer(Gravity.START)
                    true
                }
                R.id.thirdDMenu -> {
                    ThirdActivity.start(this)
                    drawerLayout.closeDrawer(Gravity.START)
                    true
                }

                R.id.local_bar -> {
                    nav_label.text = getString(R.string.bottom_nav_bar)
                    drawerLayout.closeDrawer(Gravity.START)
                    true
                }
                else -> false
            }
        }//navigationView

        drawerToggle = ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        )
        drawerLayout.addDrawerListener(drawerToggle)



        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {

                R.id.action_list -> nav_label.text = "List clicked"
                R.id.action_grid -> nav_label.text = "Grid clicked"
                R.id.action_Map -> nav_label.text = "Map clicked"
                else -> {
                    nav_label.text = "Nothing "
                }
            }
        }//bottomNavigationView
    }//onCreate

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareMenu -> nav_label.text = "Toolbar bar nav pressed."
            R.id.settingsMenu -> nav_label.text = "Toolbar Settings nav pressed."
            R.id.CloseMenu -> finish()
        //    android.R.id.home -> onBackPressed()
          //  R.id.home ->  onBackPressed()
            R.id.local_florist -> SecondActivity.start(this)
            R.id.thirdMenu -> ThirdActivity.start(this)

            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }

        }
     //   return true
        return super.onOptionsItemSelected(item)
    }



    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }


}
