package xyz.imkaem.lifecycleapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import xyz.imkaem.lifecycleapp.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    lateinit var viewBinding: FragmentTestBinding
    private var fragmentListener: TestFragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as TestFragmentListener
    }

    //    not really used in fragments
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentTestBinding.inflate(inflater, container, false)
        val view: View = viewBinding.root

        return view;

//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.textViewFragmentTestText.text = "This is set from fragment class"

        viewBinding.buttonFragmentTestClear.setOnClickListener {
            fragmentListener?.clearActivityScreen()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


    override fun onDetach() {
        super.onDetach()
        fragmentListener = null
    }

    interface TestFragmentListener {
        fun clearActivityScreen()
    }


}