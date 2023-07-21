package au.edu.swin.sdmd.w03_lightmeup_solutions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {
    val imageViewModel: ImageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageDrawable(AppCompatResources.getDrawable(this, imageViewModel.state))

        imageView.setOnClickListener {
            // update the image state
            imageViewModel.nextImage()
            // then show it on screen
            imageView.setImageDrawable(AppCompatResources.getDrawable(this, imageViewModel.state))
        }
    }
}

class ImageViewModel: ViewModel() {
    // this keeps track of the current image
    var state = R.drawable.ic_assignment_turned_in_24px

    fun nextImage() {
        state = when (state) {
            R.drawable.ic_assignment_turned_in_24px -> R.drawable.ic_assignment_late_24px
            R.drawable.ic_assignment_late_24px -> R.drawable.ic_assignment_returned_black_24dp
            R.drawable.ic_assignment_returned_black_24dp -> R.drawable.ic_assignment_turned_in_24px
            else -> R.drawable.ic_assignment_turned_in_24px
        }
    }

}