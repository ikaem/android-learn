package xyz.imkaem.recordme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import xyz.imkaem.recordme.databinding.ActivityMainBinding

// deprecated
//class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
//class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var viewBinding: ActivityMainBinding
//    private lateinit var fragmentManager: FragmentTransaction

////        TODO move it below
//    override fun onClick(v: View?) {
////        we can access id on view
//        if(v?.id == R.id.button_cycling) {
//// make some other toast here
//            return
//        }
//        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
//    } s

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.toolbar_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.reset_cycling -> {
                Toast.makeText(this, "Reset cycling", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.reset_running -> {
                Toast.makeText(this, "Reset running", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.reset_all -> {
                Toast.makeText(this, "Reset all", Toast.LENGTH_LONG).show()
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
//                return false
            }
        }
//        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        fragmentManager = fragmentManager.beginTransaction()
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val activityView: ConstraintLayout = viewBinding.root

//        this puts view on the screen
        setContentView(activityView)

//        now we want to click on nav bar
//        viewBinding.bottomNavigationViewBottomNav.setOnNavigationItemSelectedListener(this)
        viewBinding.bottomNavigationViewBottomNav.setOnItemSelectedListener(this)

//        inline anonymouse class use - : here actually implements interface
/*        viewBinding.buttonCycling.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
//                Toast.makeText(MainActivity::class.java, "Something", Toast.LENGTH_LONG )

                Toast.makeText(this@MainActivity, "Something", Toast.LENGTH_LONG ).show()
            }
        })*/


//        implementaiton of a separate onClickListener class
//        val theClickListener: View.OnClickListener = MyClickListener()
//        not good because separate class does not have this
//        viewBinding.buttonCycling.setOnClickListener(theClickListener)

//        this is if we have view implmenet the conclicklistener itnerface
//        viewBinding.buttonCycling.setOnClickListener(this)

        // adding fragment to the layout
//        supportFragmentManager.commit {
////            add(R.id.frame_layout_content, RunningFragment())
////            we can use replace initially
////            replace(R.id.frame_layout_content, RunningFragment())
//            replace(R.id.fragment_container_view_content, RunningFragment())
//        }

//        this is just test
/*        viewBinding.buttonCycling.setOnClickListener {

            onCyclingClicked()

        }

        viewBinding.buttonRunning.setOnClickListener {

            onRunningClicked()
        }*/

//        navigating by clicking on bottom nav bar
/*        viewBinding.bottomNavigationViewBottomNav.setOnNavigationItemSelectedListener()

        BottomNavigationView.OnNavigationItemSelectedListener*/


//        we can access elements in that layout - in viewBinding
//        viewBinding.bottomNavigationViewBottomNav


//        not needed if we use viewBinding
//        setContentView(R.layout.activity_main)
    }

    private fun onRunningClicked() {

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view_content, RunningFragment())
        }
    }

    private fun onCyclingClicked() {

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view_content, CyclingFragment())
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.item_nav_cycling -> {
                onCyclingClicked()
                true
            }
            R.id.item_nav_running -> {
                onRunningClicked()
                true
            }
            else -> {
                false

            }
        }
//        return true
    }


}