package xyz.imkaem.first_my_compose

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BlankFragment : Fragment() {

    fun saveDetails() {
//        ćthis is better
//        lifecycleScope.launch(Dispatchers.Main) {
//            startAnimation()
//            withContext(Dispatchers.IO) {
//                storeUser()
//            }
//
//            stopAnimation()
//        }


//        this foreses UI things for animation to run on IO thread
//        lifecycleScope.launch(Dispatchers.IO) {
//            startAnimation()
////            this is here suspend function
//            storeUser()
//            stopAnimation()
//        }
    }

    fun someOtherFunc() {


        //    this is useding async
//        lifecycleScope.launch(Dispatchers.IO) {
//            val deferredAudio: Deferred<Audio> = async {
//                convertTextToSpeech(title)
//            }
//
////            now here we await - we can call because this is Deferred object
//            val titleAudio = deferredAudio.await()
//
//            playSound(titleAudio)
//
//        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }


}