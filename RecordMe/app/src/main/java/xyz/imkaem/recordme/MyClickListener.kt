package xyz.imkaem.recordme

import android.view.View
import android.widget.Toast

//this approach is no good for creating click listener
class MyClickListener: View.OnClickListener {
    override fun onClick(v: View?) {
//        thios does not work
//        Toast.makeText(context, "hello", Toast.LENGTH_LONG)
    }
}