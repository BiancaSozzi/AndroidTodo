package intermediate.course.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import intermediate.course.R
import intermediate.course.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY).run {
            create_activity_title.text = if (this == NavigationActivity.FRAGMENT_VALUE_TASk){
               "this is a task"
            } else if (this == NavigationActivity.FRAGMENT_VALUE_NOTE){
                "this is a note"
            } else {
                "something went wrong!"
            }
        }

//        create_activity_title.text = if (intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY) == NavigationActivity.FRAGMENT_VALUE_TASk){
//            "this is a task"
//        } else {
//            "this is a note"
//        }
    }
}
