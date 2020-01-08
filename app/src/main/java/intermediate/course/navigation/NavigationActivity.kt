package intermediate.course.navigation

import android.os.Bundle

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import intermediate.course.R
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_tasks -> {
                    messageTextView.setText(R.string.title_task)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notes -> {
                    messageTextView.setText(R.string.title_note)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        messageTextView.text = getString(R.string.title_task)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
        //                R.id.navigation_tasks, R.id.navigation_notes)
        //                .build();
        //        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //        NavigationUI.setupWithNavController(navView, navController);
    }

}
