package com.tikamkumar.numbersspellings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import com.tikamkumar.numbersspellings.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationDrawer()

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.send, R.id.developer, R.id.moreApps, R.id.exit
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)

        binding.OneTen.setOnClickListener {
            boardText(getString(R.string.table1to20),
                getString(R.string.OneToTen),
                "1 to 10")
        }

        binding.Two.setOnClickListener {
            boardText(getString(R.string.table11to20),
                getString(R.string.EleToTwy),
                "11 to 20")
        }

        binding.Three.setOnClickListener {
            boardText(getString(R.string.table21to30),
                getString(R.string.TwyOneToThry),
                "21 to 30")
        }

        binding.Four.setOnClickListener {
            boardText(getString(R.string.table31to40),
                getString(R.string.ThryOneTofoty),
                "31 to 40")
        }

        binding.five.setOnClickListener {
            boardText(getString(R.string.table41to50),
                getString(R.string.ForyOneTofity),
                "41 to 50")
        }

        binding.six.setOnClickListener {
            boardText(getString(R.string.table51to60),
                getString(R.string.FityOneToSixty),
                "51 to 60")
        }

        binding.seven.setOnClickListener {
            boardText(getString(R.string.table61to70),
                getString(R.string.SixOneToSevty),
                "61 to 70")
        }

        binding.eight.setOnClickListener {
            boardText(getString(R.string.table71to80),
                getString(R.string.SevnOneToEity),
                "71 to 80")
        }

        binding.Nine.setOnClickListener {
            boardText(getString(R.string.table81to90),
                getString(R.string.EityOneToNity),
                "81 to 90")
        }

        binding.Ten.setOnClickListener {
            boardText(getString(R.string.table91to100),
                getString(R.string.NinOneToHun),
                "91 to 100")
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    private fun navigationDrawer() {
        val drawer : DrawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this,drawer,binding.toolbar,
            R.string.Open,
            R.string.Close
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(toggle)
        toggle.drawerArrowDrawable.color = ResourcesCompat.getColor(resources, R.color.Blue,null)
        toggle.syncState()
    }
    private fun boardText(num:String,numSpllng: String,title: String) {
        val intent = Intent(this@MainActivity, Blackboard::class.java)
        val mathNum : String = num
        val equal = getString(R.string.equal)
        val numspll : String = numSpllng
        val heading : String = title
        intent.putExtra("titleName",heading)
        intent.putExtra("OneTen",mathNum)
        intent.putExtra("Equal",equal)
        intent.putExtra("Numspll",numspll)
        startActivity(intent)
    }
    override fun onBackPressed() {
        val drawer : DrawerLayout = findViewById(R.id.drawer_layout)
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.exit ->{
                finish()
            }
            R.id.developer -> {
                val intent = Intent(this@MainActivity, Developer::class.java)
                startActivity(intent)
                finish()
            }
            R.id.send -> {
                val intent = Intent()
                val data  = "This is Number's Spellings App:-\n https://play.google.com/store/apps/details?id=com.tikamkumar.numbersspellings&hl=en"
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,data)
                intent.type = "text/plain"
                startActivity(intent)
            }
            R.id.moreApps -> {
                val intent = Intent()
                val data  = "https://play.google.com/store/apps/developer?id=TIKAM+KUMAR&hl=en"
                intent.action = Intent.ACTION_VIEW
                intent.addCategory(Intent.CATEGORY_BROWSABLE)
                intent.data = Uri.parse(data)
                startActivity(intent)
            }
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}